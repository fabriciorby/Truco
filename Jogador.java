import java.util.ArrayList;

public class Jogador{
    
    private String nome;
    private ArrayList<Carta> mao;
    
    public Jogador(String nome, ArrayList<Carta> mao) {
        this.nome = nome;
        this.mao = mao;
    }
    
    public void setMao(ArrayList<Carta> mao) {
        this.mao = mao;
    }
    
    public ArrayList<Carta> getMao() {
        return this.mao;
    }
    
    public Carta jogaCarta(int n) {
        return this.mao.remove(n);
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String toString() { return nome + ": " + mao; }
    
}