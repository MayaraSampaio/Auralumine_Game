package Game;

import Entities.*;
import Items.MainWeapon;
import com.sun.tools.javac.Main;

import java.util.Scanner;

import static Entities.HeroType.*;

public class Game {

    public void initialHistory(){
        Scanner sc = new Scanner(System.in);

        System.out.println(
                "Era uma vez em Auralumine, um reino de seres luminosos chamados Auralianos, " +
                        "cuja vida era iluminada pelos cristais Lumens."
        );
        System.out.println("Pressione Enter para continuar...");
        sc.nextLine();

        System.out.println(
                "O reino era governado pelo Rei Ed e pela Rainha Firna, que tinham dois filhos gêmeos, " +
                        "Solaria e Sonte, nascidos sob um eclipse raro."
        );
        System.out.println("Pressione Enter para continuar...");
        sc.nextLine();

        System.out.println(
                "O rei e a rainha nunca decidiram quem seria o próximo governante, " +
                        "decretando que ambos se tornariam rei e rainha ao completarem 21 anos.\n" +
                        "Solaria era corajosa e treinava com os guardiões do reino, " +
                        "enquanto Sonte estudava profundamente a magia dos Lumens."
        );
        System.out.println("Pressione Enter para continuar...");
        sc.nextLine();

        System.out.println(
                "Tudo mudou quando o Coração de Lumen, cristal primordial do reino, foi roubado, " +
                        "e os pais foram misteriosamente assassinados. O reino entrou em pânico e os gêmeos ficaram órfãos."
        );
        System.out.println("Pressione Enter para continuar...");
        sc.nextLine();

        System.out.println(
                "Determinada a salvar seu povo, Solaria decidiu partir em uma jornada " +
                        "para recuperar o Coração de Lumen.\n" +
                        "Antes de começar, o Conselho Luminar a orienta a escolher seu caminho."
        );
        System.out.println("Pressione Enter para continuar...");
        sc.nextLine();

        System.out.println("LOCAL: SANTUÁRIO LUMINAR\n" +
                "\n" +
                "Solaria caminha até o Santuário luminar para encontrar com o sábio Mestre Kael , \n" +
                " um Auraliano Luminoso com marcas de luz azulada que brilham como constelações.");

        System.out.println("Pressione Enter para continuar...");
        sc.nextLine();

    }

    public Hero createHero() {
        Scanner input = new Scanner(System.in);

        int option;
        HeroType heroType = null;
        Difficulty playerDifficulty;
        int creationalPoints = 0;
        int strength;
        int totalSpent;
        int gold = 0;
        int maxHp =0;


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
            if (option < 1 || option > 3){
                System.out.println("Opção inválida, tente novamente");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                System.out.println();
            }
        } while (option < 1 || option > 3);

        switch (option){
            case 1 :
                heroType = CAVALEIRA;

                break;

            case 2 :
                heroType = FEITICEIRA;
                break;


            case 3 :
                heroType = ARQUEIRA;
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
                creationalPoints = 300;
                gold = 30;
                break;

            case 2 :
                playerDifficulty = Difficulty.HARD;
                creationalPoints = 220;
                gold = 20;
                break;

        }

        do {


            System.out.println("Para continuar, você deve distribuir seus pontos de vida e de força ...");
            System.out.println("Você possui " + creationalPoints + "pontos de criação");
            System.out.println(" cada ponto de vida é trocado por 1 ponto de criação");
            System.out.println("cada ponto de força é trocada por 5 pontos de criação");


            System.out.println("Quantos pontos deseja adicionar em vida?");
            maxHp = input.nextInt();

            System.out.println("Quantos pontos deseja adicionar em força?");
            strength = input.nextInt();

            totalSpent = maxHp + (strength *5 );

            if(totalSpent != creationalPoints){
                System.out.println();
                System.out.println("Distribuição inválida, você gastou " + totalSpent + " de" + creationalPoints);
                System.out.println(" Tente novamente a´te gastar exatamente todos os seus pontos criacionais");

            }




        }while (totalSpent != creationalPoints);

        int level= 1;
        int currentHp = maxHp;
        MainWeapon starterWeapon = new MainWeapon("lâmina de luz",2,6,10);
        Hero hero = null;


        switch (heroType) {
            case CAVALEIRA :
                hero = new KnightHero("Solaria",maxHp ,currentHp,strength,gold,heroType,level,starterWeapon);

            case FEITICEIRA :
                hero = new WizardHero("Solaria", maxHp, currentHp, strength, gold, heroType, level, starterWeapon);

            case ARQUEIRA :
                hero = new ArcherHero("Heroína", maxHp, currentHp, strength, gold, heroType, level, starterWeapon);


        }
        return hero;



    }

    public void auralumen(Hero hero){

    }
}
