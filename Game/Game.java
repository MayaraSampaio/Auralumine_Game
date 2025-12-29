package Game;

import Entities.Hero;
import Entities.HeroType;
import java.util.Scanner;

public class Game {

    public Hero createHero() {
        Scanner input = new Scanner(System.in);

        int option;
        HeroType playerHero;
        Difficulty playerDifficulty;


        do {
            System.out.println("Mestre Kael: O destino chamou por você . Não posso impedir sua partida, mas posso garantir que você vá preparada.");
            System.out.println("Escolha seu caminho com sabedoria.");
            System.out.println();
            System.out.println();
            System.out.println("1 - Cavaleira : Defesa acima de tudo, terá uma armadura alada forjada pela chama de lúmens que te protegerá no combate corpo a corpo. ");
            System.out.println("2 - Feiticeira: Manipula magia luminosa, com ataques à media distância .");
            System.out.println("3 - Arqueira:   Rápida e precisa, utiliza o arco feito do carvalho mais antigo de Auralúmens,ataques acima de tudo");
            System.out.println();
            System.out.println("Pense bem ...");
            System.out.println(" Escolha a sua opção: ");

            option = input.nextInt();
            if (option < 1 && option > 3){
                System.out.println("Opção inválida, tente novamente");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                System.out.println();
            }
        } while (option < 1 && option > 3);

        switch (option){
            case 1 :
                playerHero = HeroType.CAVALEIRA;
                break;

            case 2 :
                playerHero = HeroType.FEITICEIRA;
                break;


            case 3 :
                playerHero = HeroType.ARQUEIRA;
                break;

        }
        option =0;

        do {
            System.out.println();
            System.out.println("Escolha um modo de difuldade :");
            System.out.println("1 - Fácil. ");
            System.out.println("2 - Difícil .");
            System.out.println();

            option = input.nextInt();
            if (option < 1 && option > 2){
                System.out.println("Opção inválida, tente novamente");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                System.out.println();
            }
        } while (option < 1 && option > 2);

        switch (option){
            case 1 :
                playerDifficulty = Difficulty.EASY;
                break;

            case 2 :
                playerDifficulty = Difficulty.HARD;
                break;

        }
        //TODO
        // Escrever a parte das pontuações de acordo com o nível de dificuldade
        // definido os atributos do tipo de herói escolhido


    }
}
