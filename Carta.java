import java.util.ArrayList;
import java.util.List;

public class Carta {
    public enum Valor { //3 2 A K J Q 7 6 5 4
        QUATRO  (0),
        CINCO   (1),
        SEIS    (2),
        SETE    (3),
        DAMA    (4),
        VALETE  (5),
        REI     (6),
        AS      (7),
        DOIS    (8),
        TRES    (9);
        
        private int rank;
        
        Valor (int rank)
        {
            this.rank = rank;
        }
        
        public int getRank() {
            return this.rank;
        }
    
    }

    public enum Naipe { //Paus > Copas > Espadas > Ouros
        OUROS   (0),
        ESPADAS (1),
        COPAS   (2),
        PAUS    (3);
    
        private int rank;
        
        Naipe (int rank)
        {
            this.rank = rank;
        }
        
        public int getRank() {
            return this.rank;
        }
    
    }

    private final Valor valor;
    private final Naipe naipe;
    private Carta(Valor valor, Naipe naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public Valor valor() { return valor; }
    public Naipe naipe() { return naipe; }
    public String toString() { return valor + " de " + naipe; }

    private static final List<Carta> protoDeck = new ArrayList<>();

    // Initialize prototype deck
    static {
        for (Naipe naipe : Naipe.values())
            for (Valor valor : Valor.values())
                protoDeck.add(new Carta(valor, naipe));
    }

    public static ArrayList<Carta> newDeck() {
        return new ArrayList<Carta>(protoDeck); // Return copy of prototype deck
    }
    
    public static Carta getWorstCard(Valor manilha) {
        if (manilha.getRank() == Carta.Valor.QUATRO.getRank())
            return new Carta(Carta.Valor.CINCO, Carta.Naipe.OUROS);
        else 
            return new Carta(Carta.Valor.QUATRO, Carta.Naipe.OUROS);
    }
}