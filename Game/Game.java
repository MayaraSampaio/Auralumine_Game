package Game;

import Entities.*;
import Items.ConsumableCombat;
import Items.MainWeapon;
import Items.Potion;


import java.sql.SQLOutput;
import java.util.Scanner;

import static Entities.HeroType.*;

public class Game {
    private Difficulty difficulty;

    public Game(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Metodo utilizado para iniciar a história antes de criar o personagem.
     */
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
        int maxHp = 0;


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
            if (option < 1 || option > 2){
                System.out.println("Opção inválida, tente novamente");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                System.out.println();
            }
        } while (option < 1 || option > 2);

        switch (option){
            case 1 :
                playerDifficulty = Difficulty.EASY;
                this.difficulty =playerDifficulty;
                creationalPoints = 300;
                gold = 30;
                break;

            case 2 :
                playerDifficulty = Difficulty.HARD;
                this.difficulty =playerDifficulty;
                creationalPoints = 220;
                gold = 20;
                break;

        }

        do {


            System.out.println("Para continuar, você deve distribuir seus pontos de vida e de força ...");
            System.out.println("Você possui " + creationalPoints + "pontos de criação");
            System.out.println("cada ponto de vida é trocado por 1 ponto de criação");
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
        String name = "Solária";


        switch (heroType) {
            case CAVALEIRA :
                hero = new KnightHero(name,maxHp ,currentHp,strength,gold,heroType,level,starterWeapon);

            case FEITICEIRA :
                hero = new WizardHero(name, maxHp, currentHp, strength, gold, heroType, level, starterWeapon);

            case ARQUEIRA :
                hero = new ArcherHero(name, maxHp, currentHp, strength, gold, heroType, level, starterWeapon);


        }
        return hero;


    }


    //NPC -Vilao

    public Npc createLoboLuminar(){
        return new Npc("Lobo das Sombras",70,70,15,10);
    }
    public Npc createSileph(){

        return new Npc("Guardiã Corrompida Sileph",35,35,9,15);
    }
    public Npc createComandanteMascara(){
        return new Npc("Comandante da Máscara",120,150,30,4);
    }
    public Npc createSonteFinal(){
        return new Npc("Sonte",130,130,35,0);
    }
    public Npc createSonteForma2(){
        return new Npc(" Sonte forma 2", 180,180,35,0);
    }

    //Seller
    public Seller createSeller(){
        Seller lira = new Seller();

        //weapons
        MainWeapon solarBlade = new MainWeapon("Lâmina Solar", 40, 12, 25);
        solarBlade.addAllowedHeroes(CAVALEIRA);
        MainWeapon starHammer = new MainWeapon("Martelo Estelar",50,15,32);
        starHammer.addAllowedHeroes(CAVALEIRA);


        MainWeapon luminaryArc = new MainWeapon("arco luminar",40,12,25);
        luminaryArc.addAllowedHeroes(ARQUEIRA);
        MainWeapon luminaryBeast = new MainWeapon("Besta Luminar",50,15,32);
        luminaryBeast.addAllowedHeroes(ARQUEIRA);


        MainWeapon eclipseStaff = new MainWeapon("Cajado do Eclipse", 40,12,25);
        eclipseStaff.addAllowedHeroes(FEITICEIRA);
        MainWeapon glowWand = new MainWeapon("varinha luminica",50,15,32);
        glowWand.addAllowedHeroes(FEITICEIRA);

        //potions
        Potion potionLifeMinor = new Potion("Poção de vida menor",10,15,0);
        potionLifeMinor.addAllowedHeroes(CAVALEIRA);
        potionLifeMinor.addAllowedHeroes(ARQUEIRA);
        potionLifeMinor.addAllowedHeroes(FEITICEIRA);

        Potion potionLifeMedium = new Potion("poção de vida radiante",15,25,0);
        potionLifeMedium.addAllowedHeroes(CAVALEIRA);
        potionLifeMedium.addAllowedHeroes(ARQUEIRA);
        potionLifeMedium.addAllowedHeroes(FEITICEIRA);

        Potion potionStrength = new Potion("Porção de força luminosa",25,0,2);
        potionStrength.addAllowedHeroes(CAVALEIRA);
        potionStrength.addAllowedHeroes(ARQUEIRA);
        potionStrength.addAllowedHeroes(FEITICEIRA);

        Potion potionVitality = new Potion("Poção de vitalidade",30,15,1);
        potionVitality.addAllowedHeroes(CAVALEIRA);
        potionVitality.addAllowedHeroes(ARQUEIRA);
        potionVitality.addAllowedHeroes(FEITICEIRA);

        //consumableCombat
        ConsumableCombat lightGrenade = new ConsumableCombat("Granada de Luz",20,20);
        lightGrenade.addAllowedHeroes(CAVALEIRA);
        lightGrenade.addAllowedHeroes(ARQUEIRA);
        lightGrenade.addAllowedHeroes(FEITICEIRA);

        ConsumableCombat luminarPowder = new ConsumableCombat("Pó explosivo Luminar",10,14);
        luminarPowder.addAllowedHeroes(CAVALEIRA);
        luminarPowder.addAllowedHeroes(FEITICEIRA);
        luminarPowder.addAllowedHeroes(ARQUEIRA);


        ConsumableCombat starArrow = new ConsumableCombat("Flecha estelar condensada", 28, 25);
        starArrow.addAllowedHeroes(ARQUEIRA);

        ConsumableCombat rageFlask = new ConsumableCombat("Frasco de Ira",28,25);
        rageFlask.addAllowedHeroes(CAVALEIRA);

        ConsumableCombat unstableOrb = new ConsumableCombat("Orbe lumínico instavel",28,25);
        unstableOrb.addAllowedHeroes(FEITICEIRA);


        //adicionar itens a vendedora
        lira.addItemsForSale(solarBlade);
        lira.addItemsForSale(luminaryArc);
        lira.addItemsForSale(starHammer);
        lira.addItemsForSale(luminaryBeast);
        lira.addItemsForSale(eclipseStaff);
        lira.addItemsForSale(glowWand);
        lira.addItemsForSale(potionLifeMedium);
        lira.addItemsForSale(potionLifeMedium);
        lira.addItemsForSale(potionVitality);
        lira.addItemsForSale(potionStrength);
        lira.addItemsForSale(lightGrenade);
        lira.addItemsForSale(luminarPowder);
        lira.addItemsForSale(starArrow);
        lira.addItemsForSale(rageFlask);
        lira.addItemsForSale(unstableOrb);


        return lira;
    }





    //Rooms
    public int santuarioLuminar_01(){
        Scanner input = new Scanner(System.in);
        int choice;

        initialHistory();
        createHero();

        System.out.println("para onde deseja ir agora?");
        choice = input.nextInt();

        return choice;
    }
    public int torreHorizonte_02() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int choice;

        System.out.println("LOCAL: Torre do horizonte");
        Thread.sleep(1500);
        System.out.println();
        System.out.println();

        System.out.println("Eldros o sábio cego !");
        Thread.sleep(1500);

        System.out.println(" Eldros : Eu não vejo como você vê, Solaria...");
        Thread.sleep(2000);

        System.out.println(" Mas percebo sua luz.");
        Thread.sleep(1500);

        System.out.println("Ela oscila.");
        Thread.sleep(1500);

        System.out.println("Você carrega dor e esperança.");
        Thread.sleep(2000);


        System.out.println();
        System.out.println("Eldros : O Coração de Lumen ainda pulsa...");
        Thread.sleep(2000);

        System.out.println("mas está em mãos traiçoeiras.");
        Thread.sleep(2500);

        System.out.println("Muitas vezes podemos nos surpreender.");
        Thread.sleep(2000);


        System.out.println();
        System.out.println();
        System.out.println("Nós nunca conhecemos realmente a fundo");
        Thread.sleep(1500);

        System.out.println("aqueles que pensamos.");
        Thread.sleep(3000);

        System.out.println();
        System.out.println("Siga seu caminho...");
        Thread.sleep(2000);

        System.out.println("Força não é ausência de medo.");
        Thread.sleep(1500);

        System.out.println("É escolher avançar mesmo tremendo.");

        System.out.println();

        System.out.println("para onde deseja ir agora?");

        choice = input.nextInt();

        // aqui vou inserir vou colocar as opções de sala que ela vai poder entrar neste momento, ela escolhe alguma , por exemplo vilarejo Vivalume que é a sala 03 no switch case
        // mas eu vou ter duas opções aqui 1- ir para mercadora ou 2- ir para vilarejo vivalume
        // se ela escolher 02 eu vou dizer que então : se choice ==2 agora choice == 3 e eu vou retornar 03 e no meu switch case vai me levar para o case 03

        return choice;
    }
    public int vilarejoVivalume_03(Hero hero) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Seller lira = createSeller();

        int choice;
        int newWay;

        System.out.println("LOCAL: VILAREJO DE VIVALUME ");
        Thread.sleep(1500);
        System.out.println();
        System.out.println();

        System.out.println("Solária: Quanta gente! Estão todos desesperados com o desaparecimento do coração de Lúmen.");
        System.out.println();
        System.out.println();
        Thread.sleep(1500);


        System.out.println("Jovem de cabelo rosa que carrega uma mochila flutuante aparece em frente a Solária...");
        System.out.println();
        Thread.sleep(1500);

        System.out.println("Lira a mercadora de Luz.");
        System.out.println();
        System.out.println();
        Thread.sleep(1500);

        System.out.println(" Lira :" +"Oh! Você é Solaria, não é? Todos aqui falam de sua coragem. Se precisar de equipamentos, magia engarrafada ou até fofocas… eu tenho de tudo um pouco!");
        Thread.sleep(2000);
        System.out.println();


        do {
            System.out.println("Gostaria de comprar algo para sua jornada ?");
            System.out.println(" 1 - Sim ");
            System.out.println(" 0 - Sair da loja ");
            choice = input.nextInt();

            if (choice == 1){
            lira.openStore(hero);

            }

            if (choice == 0){
                System.out.println("Tem certeza que não que quer sair da loja?");
                System.out.println(" 1 - Sim ");
                System.out.println(" 0 - Não");
                choice = input.nextInt();

                if (choice == 1){
                    lira.openStore(hero);

                }
                if (choice == 0){
                    System.out.println("Faremos negócios na proxima então");
                    break;
                }

                break;

            }

        }while (true);

        System.out.println("Para onde deseja ir agora ?");











        return 0;
    }
    public int vilarejoAbandonado_04(Hero hero) throws InterruptedException {
        System.out.println("LOCAL: Vilarejo abandonado");
        Thread.sleep(1500);

        System.out.println(" Solária : Não tem ninguém por aqui, as sombras tomaram esse lugar...");
        Thread.sleep(1500);

        System.out.println("barulho : AUUUUUUUUUUUUUUUUUUUUHHHHHHHHHHH!");
        Thread.sleep(1500);

        Npc npc = createLoboLuminar();

        System.out.println("Lobo luminar corrompido : Você não deveria estar aqui. As sombras irão dominar Auralumine");

       hero.showDetails();
       boolean venceu = hero.attack(npc);

       if(!venceu){
           System.out.println("O Lobo Luminar dilacera sua luz...");
           System.out.println("Sua jornada termina aqui.");
           return 0;
       }

        System.out.println("O Lobo Luminar é derrotado e se dissipa em luz.");
        System.out.println("Você encontrou ouro entre os destroços.");
        Thread.sleep(1500);


        System.out.println("Status atual :");
        System.out.println();
        Thread.sleep(1500);


        hero.showDetails();

        System.out.println();
        System.out.println();
        System.out.println("Para onde você deseja ir agora?");
        return 0;


    }
    public int casaVilarejoAbandonado_05(Hero hero) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("LOCAL: Casa com uma luz no Vilarejo Abandonado");
        Thread.sleep(1500);


        System.out.println("Entre as ruínas, uma pequena casa ainda emite uma luz fraca.O brilho tremula, como se estivesse prestes a se apagar.");
        Thread.sleep(2000);
        System.out.println("Ao se aproximar, você vê uma pessoa ferida, envolta em sombras.Ela parece exausta e assustada.");
        Thread.sleep(2000);
        System.out.println("Senhora em perigo : Por favor... eu não sei quanto tempo mais aguento...");
        Thread.sleep(1500);

        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Ajudar a pessoa");
        System.out.println("2 - Ignorar e seguir seu caminho");

        int choice;

        do {
            choice = sc.nextInt();
            if (choice < 1 || choice > 2) {
                System.out.println("Opção inválida, escolha 1 ou 2.");
            }
        }while (choice < 1 || choice > 2);

        if (choice == 2) {
            System.out.println("A luz da casa se apaga lentamente enquanto você se afasta...");
            Thread.sleep(2000);
        } else if (choice ==1){
            int damage= 8;
            hero.setCurrentHp(hero.getCurrentHp() - damage);
            System.out.println( "Você sofreu " + damage + " pontos de dano ao proteger a pessoa.");

            System.out.println("status atual : ");
            hero.showDetails();
            Thread.sleep(1500);

            System.out.println("Para onde deseja ir agora ?");
            int myWay= sc.nextInt();

            return myWay;


            
        }
        System.out.println("Para onde deseja ir agora ?");
        int myWay= sc.nextInt();

        return myWay;


    }
    public int fendaNegra_06(Hero hero) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.println("LOCAL: Sala da Fenda Negra");
        Thread.sleep(1000);

        System.out.println("Você entra na sala e sente a escuridão abraçar cada canto...");
        Thread.sleep(1500);

        System.out.println("Um garoto aparece e diz:");
        Thread.sleep(1000);
        System.out.println("Cuidado para atravessar. Tenho uma lanterna com lumis-fire ou posso te dar 200 moedas . ");
        Thread.sleep(1500);

        System.out.println("Escolha sua ação:");
        System.out.println("1 - Pegar a lanterna");
        System.out.println("2 - Pegar 200 moedas");

        int choice = input.nextInt();
        int myWay = 0;

        if (choice == 1){
            System.out.println("Você pega a lanterna e consegue atravessar a sala em segurança.");
            System.out.println("para onde deseja ir agora?");

            myWay = input.nextInt();

        } else if (choice ==2 ) {

            if (hero.getHeroType()== FEITICEIRA){
                System.out.println("Você pega as moedas, mas a escuridão é traiçoeira...");
                Thread.sleep(1000);
                System.out.println("entretanto por ser feiticeira você usa a luz emanada por sua varinha e desvia dos perigos da escuridão");

                System.out.println("para onde deseja ir agora?");

                myWay = input.nextInt();

            }else {
                System.out.println("Você pega as moedas, mas a escuridão é traiçoeira...");
                Thread.sleep(1000);
                System.out.println("A escuridão abraça seu destino. Sua luz se apaga para sempre.");
                return 0;
            }


        }


        return myWay;
    }
    public int ruinasOcultas(Hero hero) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        int choice;

        hero.showDetails();
        System.out.println("Você está caminhando e encontrou um baú velho e enferrujado com 30 moedas de ouro ");
        Thread.sleep(1500);
        hero.setGold(hero.getGold()+ 30);

        System.out.println();
        System.out.println("status atual:");
        hero.showDetails();

        System.out.println("para onde você deseja ir agora?");
        choice = input.nextInt();
        return choice;

    }
    public int desfiladeiroEclipse(Hero hero) throws InterruptedException {
        Scanner sc = new Scanner(System.in);


        System.out.println("LOCAL: Desfiladeiro do Eclipse");
        Thread.sleep(1000);

        System.out.println("Sileth, Ex-guardiã com armadura semi-corrompida, metade iluminada, metade tomada por sombra.");
        Thread.sleep(1500);

        System.out.println("Sileph: Fique longe de mim! A escuridão sussurra... ela controla... eu não...eu não posso…");
        Thread.sleep(1500);

        System.out.println("Sileph: Você vai sofrer Solária");
        Thread.sleep(1500);


        Npc sileph = createSileph();
        boolean venceu = hero.attack(sileph);

        if (!venceu) {
            System.out.println("Você foi derrotado...");
            return 0;
        } else {
            System.out.println("Sileth derrotada! Você continua sua jornada.");
            System.out.println();
            System.out.println();

            System.out.println("Para onde você deseja ir agora?");
            return 0;
        }

    }
    public int camaraComandante(Hero hero) throws InterruptedException {
        System.out.println("LOCAL: Câmara do Comandante");
        Thread.sleep(1000);
        System.out.println("Você entra e vê o Comandante da Máscara aguardando...");
        Thread.sleep(1000);

        System.out.println("Comandante da Mascara: Então você é a Solária... ");
        Thread.sleep(1000);
        System.out.println("Comandante da Mascara: Junte se a nós, deixe as sombras mostrarem todo o seu poder... ");
        Thread.sleep(1000);

        System.out.println("Solária: Prefiro morrer... ");
        Thread.sleep(1000);

        System.out.println("De repente, uma voz familiar ecoa: Sonte, seu irmão gêmeo, é o traidor !");
        Thread.sleep(1500);

        System.out.println("Sonte : Comandante, mate-a");
        Thread.sleep(1500);


        System.out.println("Prepare-se para a batalha ");

        Npc comandante = createComandanteMascara();
        hero.showDetails();
        boolean venceu = hero.attack(comandante);
        if (!venceu) {
            System.out.println("Você foi derrotado...");
            return 0;
        } else {
            System.out.println("Comandante da Máscara derrotado! Está perto de salvar Auralumine");
            System.out.println();
            System.out.println();

            System.out.println("Para onde você deseja ir agora?");
            return 0;
        }
    }
    public int tronoSombrio() {


        return 0;
    }







    public void auralumen(Hero hero){

    }
}
