import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main{

    public static void main(String[] args) {
        
        List<Carta> deck = Carta.newDeck(); //cria um deck
        Collections.shuffle(deck); //embaralha o deck

        List<Jogador> lstJogador = new ArrayList<>();
        
        String[] nome = {"Jogador 1", "Jogador 2", "Jogador 3", "Jogador 4"};
        
        for(int i = 0; i < 4; i++) //cria 4 jogadores
        {
            
            lstJogador.add(new Jogador(nome[i], Mesa.deal(deck, 3)));
            
        }
        
        for (Jogador jogador : lstJogador) { //imprime as informações dos jogadores
            
            System.out.println(jogador);
            
        }
        
        //Início do jogo
        
        Carta vira = Mesa.deal(deck, 1).get(0); //vira a primeira carta
        System.out.println();
        System.out.println("Vira: " + vira);
        
        Carta.Valor manilha = Mesa.getManilha(vira); //obtém a manilha a partir da primeira carta
        System.out.println("Manilha: " + manilha);
        System.out.println();
        
        int pt1 = 0;
        int pt2 = 0;
        int ptEmpate = 0;
            
        while(pt1 < 2 && pt2 < 2 && ptEmpate < 3){
            
            ArrayList<Carta> lstMesa =  new ArrayList<>();
            Carta descarte;
            int ganhador;
            
            for (Jogador jogador : lstJogador) { //pega as cartas jogadas e adiciona numa lista
                
                descarte = jogador.jogaCarta(0);
                lstMesa.add(descarte);
                System.out.println(jogador.getNome() + ": " + descarte);
                
            }
            
            Mesa mesa = new Mesa(lstMesa);

            ganhador = mesa.getGanhador(manilha); //pega o ganhador da mesa atual
            
            if (ganhador == -1){ //empate
                System.out.println("Empate!\n");
                ptEmpate++;
            }
            else if ((ganhador & 1) == 0){ //número par
                System.out.println("A equipe 1 ganhou com a carta de " + lstJogador.get(ganhador).getNome() + "!\n");
                pt1++;
            }
            else{ //número ímpar
                System.out.println("A equipe 2 ganhou com a carta de " + lstJogador.get(ganhador).getNome() + "!\n");
                pt2++;
            }
            
            if (pt1 > pt2)          pt1 = pt1 + ptEmpate; //aplica regras de empate no truco
            else if (pt2 > pt1)     pt2 = pt2 + ptEmpate;
            
        }
        
        if (pt1 > pt2)
        {
            System.out.println("A equipe 1 ganhou a rodada!");
        } else if (pt2 > pt1) {
            System.out.println("A equipe 2 ganhou a rodada!");
        } else {
            System.out.println("A rodada terminou em empate!");
        }
        
    }

}