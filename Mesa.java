import java.util.ArrayList;
import java.util.List;

public class Mesa{
    
    private ArrayList<Carta> cartas;

    public Mesa(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }
    
    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }
    
    public ArrayList<Carta> getCartas() {
        return this.cartas;
    }
    
    public int getGanhador(Carta.Valor manilha) {
        
        Carta bestCard = Carta.getWorstCard(manilha);
        int n = 0;
        
        for (Carta c : cartas)
        {
            if (c.valor().getRank() == manilha.getRank())
            {
                if (bestCard.valor().getRank() != manilha.getRank())
                    bestCard = c;
                else if (c.naipe().getRank() > bestCard.naipe().getRank())
                    bestCard = c;
            }
            else if (c.valor().getRank() > bestCard.valor().getRank() && bestCard.valor().getRank() != manilha.getRank())
                bestCard = c;
        }
        
        System.out.println("Melhor carta: " + bestCard);
        
        if (bestCard.valor().getRank() != manilha.getRank())
        {
            for (Carta c : cartas)
            {
                if (bestCard.valor().getRank() == c.valor().getRank())
                    n++;
            }
        }
        
        if (n > 1)
        {
            return -1;
        }
        else
        {
            return cartas.indexOf(bestCard);
        }
    }
    
    public static Carta.Valor getManilha(Carta carta){
        int rank = carta.valor().getRank();
        if (rank == Carta.Valor.TRES.getRank()) rank = 0; else rank++;
        return Carta.Valor.values()[rank];
    }
    
    public static ArrayList<Carta> deal(List<Carta> deck, int n) {
        int deckSize = deck.size();
        List<Carta> handView = deck.subList(deckSize-n, deckSize);
        ArrayList<Carta> hand = new ArrayList<Carta>(handView);
        handView.clear();
        return hand;
    }
}