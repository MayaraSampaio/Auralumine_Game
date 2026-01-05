package Game;

import Assets.Audio;
import Assets.Image;
import Entities.*;
import Items.ConsumableCombat;
import Items.MainWeapon;
import Items.Potion;
import java.util.Scanner;

import static Assets.Typewriter.narrar;
import static Assets.Typewriter.narrar2;
import static Entities.HeroType.*;

public class Game {
    private Difficulty difficulty;

    public Game() {
    }
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * The method used to begin the story before creating the character
     */
    public void initialHistory() throws InterruptedException {
        Audio.playMusic("AudioFiles/openmusic.wav");
        Scanner sc = new Scanner(System.in);

        System.out.println(Image.LOGO);
        Thread.sleep(4000);

        narrar(
                "Era uma vez em Auralumine, um reino de seres luminosos chamados Auralianos, cuja vida era iluminada pelos cristais Lumens.",
                sc
        );

        narrar(
                "O reino era governado pelo Rei Ed e pela Rainha Firna, que tinham dois filhos gêmeos, Solaria e Sonte, nascidos sob um eclipse raro.",
                sc
        );

        narrar(
                "O rei e a rainha nunca decidiram quem seria o próximo governante, decretando que ambos se tornariam rei e rainha ao completarem 21 anos.",
                sc
        );

        narrar(
                "Solaria era corajosa e treinava com os guardiões do reino, enquanto Sonte estudava profundamente a magia dos Lumens.",
                sc
        );

        narrar(
                "Tudo mudou quando o Coração de Lumen, cristal primordial do reino, foi roubado, e os pais foram misteriosamente assassinados. O reino entrou em pânico e os gêmeos ficaram órfãos.",
                sc
        );

        narrar(
                "Determinada a salvar seu povo, Solaria decidiu partir em uma jornada para recuperar o Coração de Lumen.",
                sc
        );

        narrar(
                "Antes de começar, o Conselho Luminar a orienta a escolher seu caminho.",
                sc
        );

        narrar("LOCAL: SANTUÁRIO LUMINAR", sc);

        narrar(
                "Solaria caminha até o Santuário Luminar para encontrar com o sábio Mestre Kael, um Auraliano Luminoso com marcas de luz azulada que brilham como constelações.",
                sc
        );
        Audio.stopMusic();

    }
    /**
     *
     * The method used to create the hero.
     * @return Hero
     */
    public Hero createHero() {
        Scanner input = new Scanner(System.in);

        int option;
        HeroType heroType = null;
        int creationalPoints = 0;
        int strength;
        int totalSpent;
        int gold = 0;
        int maxHp = 0;


        do {
            System.out.println("LOCAL : SANTUÁRIO LUMINAR");
            System.out.println("Mestre Kael: O destino chamou por você . Não posso impedir sua partida, mas posso garantir que você vá preparada.");
            System.out.println("Escolha seu caminho com sabedoria.");
            System.out.println();
            System.out.println();
            System.out.println("⚔\uFE0F 1 - Cavaleira : Defesa acima de tudo, terá uma armadura alada forjada pela chama de lúmens que te protegerá no combate corpo a corpo. ");
            System.out.println("\uD83D\uDD2E 2 - Feiticeira: Manipula magia luminosa, com ataques à media distância .");
            System.out.println("\uD83C\uDFF9 3 - Arqueira:   Rápida e precisa, utiliza o arco feito do carvalho mais antigo de Auralúmens,ataques acima de tudo");
            System.out.println();
            System.out.println("Pense bem ...");
            System.out.println("Escolha a sua opção: ");
            System.out.println();
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

                this.difficulty  = Difficulty.EASY;
                creationalPoints = 300;
                gold = 30;
                break;

            case 2 :

                this.difficulty = Difficulty.HARD;
                creationalPoints = 220;
                gold = 20;
                break;

        }

        do {


            System.out.println("Para continuar, você deve distribuir seus pontos de vida e de força ...");
            System.out.println("Você possui " + creationalPoints + " pontos de criação");
            System.out.println("cada ponto de vida é trocado por 1 ponto de criação");
            System.out.println("cada ponto de força é trocada por 5 pontos de criação");


            System.out.println("Quantos pontos deseja adicionar em vida?");
            maxHp = input.nextInt();

            System.out.println("Insira sua força desejada (pontos criacionais/5)?");
            strength = input.nextInt();

            totalSpent = maxHp + (strength *5 );

            if(totalSpent != creationalPoints){
                System.out.println();
                System.out.println("Distribuição inválida, você gastou " + totalSpent + " de " + creationalPoints);
                System.out.println("Tente novamente até gastar exatamente todos os seus pontos criacionais");

            }




        }while (totalSpent != creationalPoints);

        int level= 1;
        int currentHp = maxHp;
        MainWeapon starterWeapon = new MainWeapon("lâmina de luz",2,6,10);
        String name = "Solária";


        Hero hero;

        switch (heroType) {
            case CAVALEIRA:
                hero = new KnightHero(name, maxHp, currentHp, strength, gold, heroType, level, starterWeapon);
                hero.showDetails();
                break;

            case FEITICEIRA:
                hero = new WizardHero(name, maxHp, currentHp, strength, gold, heroType, level, starterWeapon);
                hero.showDetails();
                break;

            case ARQUEIRA:
                hero = new ArcherHero(name, maxHp, currentHp, strength, gold, heroType, level, starterWeapon);
                hero.showDetails();
                break;

            default:
                throw new IllegalStateException("Tipo de herói inválido");
        }


        return hero;


    }

    //NPC -Vilao
    /**
     * The method used to create a villain.
     * @return Npc
     */
    public Npc createLoboLuminar(){
        return new Npc("Lobo das Sombras",70,70,10,10);
    }

    /**
     * The method used to create a villain.
     * @return Npc
     */
    public Npc createSileph(){return new Npc("Guardiã Corrompida Sileph",95,95,12,20);}

    /**
     * The method used to create a villain.
     * @return Npc
     */
    public Npc createComandanteMascara(){return new Npc("Comandante da Máscara",120,120,17,40);}

    /**
     * The method used to create a villain.
     * @return Npc
     */
    public Npc createSonteFinal(){
        return new Npc("Sonte",170,170,23,0);
    }

    /**
     * The method used to create a Seller
     * @return Seller
     */
    public Seller createSeller(){
        Seller lira = new Seller();

        //weapons
        MainWeapon solarBlade = new MainWeapon("Lâmina Solar", 10, 12, 15);
        solarBlade.addAllowedHeroes(CAVALEIRA);

        MainWeapon starHammer = new MainWeapon("Martelo Estelar",40,20,25);
        starHammer.addAllowedHeroes(CAVALEIRA);


        MainWeapon luminaryArc = new MainWeapon("Arco luminar",10, 12, 15);
        luminaryArc.addAllowedHeroes(ARQUEIRA);

        MainWeapon luminaryBeast = new MainWeapon("Besta Luminar",40,20,25);
        luminaryBeast.addAllowedHeroes(ARQUEIRA);


        MainWeapon eclipseStaff = new MainWeapon("Cajado do Eclipse", 10, 12, 15);
        eclipseStaff.addAllowedHeroes(FEITICEIRA);

        MainWeapon glowWand = new MainWeapon("varinha luminica",40,20,25);
        glowWand.addAllowedHeroes(FEITICEIRA);

        //potions
        Potion potionLifeMinor = new Potion("Poção de vida menor",10, 15, 2);
        potionLifeMinor.addAllowedHeroes(CAVALEIRA);
        potionLifeMinor.addAllowedHeroes(ARQUEIRA);
        potionLifeMinor.addAllowedHeroes(FEITICEIRA);

        Potion potionLifeMedium = new Potion("Poção de vida radiante",20,25,0);
        potionLifeMedium.addAllowedHeroes(CAVALEIRA);
        potionLifeMedium.addAllowedHeroes(ARQUEIRA);
        potionLifeMedium.addAllowedHeroes(FEITICEIRA);

        Potion potionStrength = new Potion("Poção de força luminosa",20,0,2);
        potionStrength.addAllowedHeroes(CAVALEIRA);
        potionStrength.addAllowedHeroes(ARQUEIRA);
        potionStrength.addAllowedHeroes(FEITICEIRA);

        Potion potionVitality = new Potion("Poção de vitalidade",70,50,4);
        potionVitality.addAllowedHeroes(CAVALEIRA);
        potionVitality.addAllowedHeroes(ARQUEIRA);
        potionVitality.addAllowedHeroes(FEITICEIRA);

        //consumableCombat
        ConsumableCombat lightGrenade = new ConsumableCombat("Granada de Luz",25,20);
        lightGrenade.addAllowedHeroes(CAVALEIRA);
        lightGrenade.addAllowedHeroes(ARQUEIRA);
        lightGrenade.addAllowedHeroes(FEITICEIRA);

        ConsumableCombat luminarPowder = new ConsumableCombat("Pó explosivo Luminar",35,35);
        luminarPowder.addAllowedHeroes(CAVALEIRA);
        luminarPowder.addAllowedHeroes(FEITICEIRA);
        luminarPowder.addAllowedHeroes(ARQUEIRA);


        ConsumableCombat starArrow = new ConsumableCombat("Flecha estelar condensada", 20, 25);
        starArrow.addAllowedHeroes(ARQUEIRA);

        ConsumableCombat rageFlask = new ConsumableCombat("Frasco de Ira",20,25);
        rageFlask.addAllowedHeroes(CAVALEIRA);

        ConsumableCombat unstableOrb = new ConsumableCombat("Orbe lumínico instavel",20,25);
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

    /**
     * The method used to create Santuario Luminar Room
     * @return int -> used in switch case
     */
    public int santuarioLuminar_01(){
        Scanner input = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("para onde deseja ir agora?");
            System.out.println("1 - Torre do Horizonte");
            System.out.println("2 - Seguir para o Vilarejo Vivalume");

            choice = input.nextInt();

            if (choice == 1) return 2; // Torre do Horizonte
            if (choice == 2) return 3;  // Vivalume

            System.out.println("Opção inválida");

        }

    }

    /**
     * The method used to create Torre Horizonte Room
     * @return int -> used in switch case
     * @throws InterruptedException
     */
    public int torreHorizonte_02() throws InterruptedException {
        Scanner sc = new Scanner(System.in);


        narrar2("LOCAL: Torre do horizonte", sc);
        System.out.println();
        System.out.println();

        narrar2("Eldros o sábio cego!", sc);

        narrar2("Eldros: Eu não vejo como você vê, Solaria...", sc);
        narrar2("Mas percebo sua luz.", sc);
        narrar2("Ela oscila.", sc);
        narrar2("Você carrega dor e esperança.", sc);

        System.out.println();

        narrar2("Eldros: O Coração de Lumen ainda pulsa...", sc);
        narrar2("mas está em mãos traiçoeiras.", sc);
        narrar2("Muitas vezes podemos nos surpreender.", sc);

        System.out.println();
        System.out.println();


        narrar("Nós nunca conhecemos realmente a fundo", sc);
        narrar("aqueles que pensamos.", sc);

        System.out.println();

        narrar("Siga seu caminho...", sc);
        narrar("Força não é ausência de medo.", sc);
        narrar("É escolher avançar mesmo tremendo.", sc);

        System.out.println();

        narrar(
                "Você precisa passar pelo Vilarejo Vivalume, pois precisa procurar uma pessoa...",
                sc
        );

        narrar("Seguir para o Vilarejo Vivalume", sc);
        System.out.println();
        return 3;  // Vivalume

    }

    /**
     * The method used to create vilarejo vivalume Room
     * @param hero
     * @return int -> used in switch case
     * @throws InterruptedException
     */
    public int vilarejoVivalume_03(Hero hero) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Seller lira = createSeller();

        int choice;

        narrar2("LOCAL: VILAREJO DE VIVALUME ",sc);
        System.out.println();
        System.out.println();

        narrar("Solária: Quanta gente! Estão todos desesperados com o desaparecimento do coração de Lúmen.",sc);
        System.out.println();

        narrar2("Jovem de cabelo rosa que carrega uma mochila flutuante aparece em frente a Solária...",sc);
        narrar2("Lira a mercadora de Luz.",sc);

        narrar("Lira : Oh! Você é Solaria, não é? Todos aqui falam de sua coragem. Se precisar de equipamentos, magia engarrafada ou até fofocas… eu tenho de tudo um pouco!",sc);

        encontroComMercadora(hero);

        while (true) {
            System.out.println("Para onde deseja ir agora?");
            System.out.println("1 - Vilarejo Abandonado");
            System.out.println("2 - Fenda Negra");

            choice = input.nextInt();

            if (choice == 1) return 4;
            if (choice == 2) return 6;

            System.out.println("Escolha inválida.");
        }
    }

    /**
     * The method used to create vilarejo abandonado Room
     * @param hero
     * @return int -> used in switch case
     *
     * @throws InterruptedException
     */
    public int vilarejoAbandonado_04(Hero hero) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        narrar2("LOCAL: Vilarejo abandonado",sc);

        narrar(" Solária : Não tem ninguém por aqui, as sombras tomaram esse lugar...",sc);

        narrar2("barulho : AUUUUUUUUUUUUUUUUUUUUHHHHHHHHHHH!",sc);

        narrar2("Lobo luminar corrompido : Você não deveria estar aqui. As sombras irão dominar Auralumine",sc);
        Npc npc = createLoboLuminar();
        System.out.println();
        hero.showDetails();
        System.out.println();
        npc.showDetails();
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

        while (true) {

            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.println("Para onde deseja ir agora?");
            System.out.println("1 - Casa no Vilarejo Abandonado");
            System.out.println("2 - Ruínas Ocultas");

            int choice = input.nextInt();

            if (choice == 1) return 5;// casa vilarejo
            if (choice == 2) return 7;//ruinas ocultas

            System.out.println("Escolha inválida.");
        }


    }

    /**
     * The method used to create casa vilarejo abandonado Room
     * @param hero
     * @return int -> used in switch case
     * @throws InterruptedException
     */
    public int casaVilarejoAbandonado_05(Hero hero) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        narrar2("LOCAL: Casa com uma luz no Vilarejo Abandonado",sc);

        narrar2("Entre as ruínas, uma pequena casa ainda emite uma luz fraca. O brilho tremula, como se estivesse prestes a se apagar.",sc);
        narrar2("Ao se aproximar, você vê uma pessoa ferida, envolta em sombras. Ela parece exausta e assustada.",sc);


        narrar("Senhora em perigo: Por favor... eu não sei quanto tempo mais aguento...",sc);


        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Ajudar a pessoa");
        System.out.println("2 - Ignorar e seguir seu caminho");

        int choice;

        do {
            choice = sc.nextInt();
            if (choice<1||choice> 2) {
                System.out.println("Opção inválida, escolha 1 ou 2.");
            }
        } while (choice<1||choice>2);
        if (choice == 2) {
            System.out.println("A luz da casa se apaga lentamente enquanto você se afasta...");
            Thread.sleep(2000);

            while (true) {
                Scanner input = new Scanner(System.in);
                System.out.println("Para onde deseja ir agora?");
                System.out.println("1 - Fenda Negra");
                System.out.println("2 - Ruinas Ocultas");

                int myWay = input.nextInt();

                if (myWay == 1) return 6; // fenda negra
                if (myWay == 2) return 7; // ruinas ocultas

                System.out.println("Escolha inválida.");
            }
        } else {
            int damage = 8;
            hero.setCurrentHp(hero.getCurrentHp() - damage);
            System.out.println("Você sofreu " + damage + " pontos de dano ao proteger a pessoa.");

            // Revigora o herói para maxHP
            hero.setCurrentHp(hero.getMaxHp());
            System.out.println("Após ajudar a pessoa, você recupera sua energia totalmente!");

            System.out.println("Status atual:");
            hero.showDetails();
            Thread.sleep(1500);

            while (true) {
                Scanner input = new Scanner(System.in);
                System.out.println("Para onde deseja ir agora?");
                System.out.println("1 - Fenda Negra");
                System.out.println("2 - Ruinas Ocultas");

                int myWay = input.nextInt();

                if (myWay == 1) return 6; // fenda negra
                if (myWay == 2) return 7; // ruinas ocultas

                System.out.println("Escolha inválida.");
            }
        }

    }

    /**
     * The method used to create fenda Negra Room
     * @param hero
     * @return int -> used in switch case
     * @throws InterruptedException
     */
    public int fendaNegra_06(Hero hero) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        Scanner sc = new Scanner(System.in);
        narrar2("LOCAL: Sala da Fenda Negra",sc);
        narrar2("Você entra na sala e sente a escuridão abraçar cada canto...",sc);
        narrar2("Um garoto aparece e diz: Cuidado para atravessar. Tenho uma lanterna com lumis-fire ou posso te dar 200 moedas . ",sc);




        while(true){
            System.out.println("Escolha sua ação:");
            System.out.println("1 - Pegar a lanterna");
            System.out.println("2 - Pegar 200 moedas");

            int choice = input.nextInt();

            if (choice == 1){
                System.out.println("Você pega a lanterna e consegue atravessar a sala em segurança.");
                encontroComMercadora(hero);

                while (true) {
                    System.out.println("Para onde deseja ir agora?");
                    System.out.println("1 - Desfiladeiro do Eclipse");
                    System.out.println("2 - Ruínas Ocultas");

                    int myWay = input.nextInt();

                    if (myWay == 1) return 8; // desfiladeiro do eclipse
                    if (myWay == 2) return 7; // ruinas ocultas

                    System.out.println("Escolha inválida.");
                }

            } else if (choice ==2 ) {

                if (hero.getHeroType()== FEITICEIRA){
                    System.out.println("Você pega as moedas, mas a escuridão é traiçoeira...");
                    System.out.println("entretanto por ser feiticeira você usa a luz emanada por sua varinha e desvia dos perigos da escuridão");

                    while (true) {
                        System.out.println("Para onde deseja ir agora?");
                        System.out.println("1 - Desfiladeiro do Eclipse");
                        System.out.println("2 - Ruínas Ocultas");

                        int myWay = input.nextInt();

                        if (myWay == 1) return 8; // desfiladeiro do eclipse
                        if (myWay == 2) return 7; // ruinas ocultas

                        System.out.println("Escolha inválida.");
                    }

                }else {
                    System.out.println("Você pega as moedas, mas a escuridão é traiçoeira... Você caiu em um precipício...");
                    System.out.println("A escuridão abraça seu destino. Sua luz se apaga para sempre.");
                    return 0;
                }
            }
        }

    }

    /**
     * The method used to create ruinas ocultas Room
     * @param hero
     * @return int -> used in switch case
     * @throws InterruptedException
     */
    public int ruinasOcultas_07(Hero hero) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        int choice;

        hero.showDetails();
        Thread.sleep(1500);
        int gold = 30 + (int)(Math.random() * 71);
        System.out.println("Você está caminhando e encontrou um baú velho e enferrujado com "+gold+ " moedas de ouro ");

        hero.setGold(hero.getGold()+ gold);

        System.out.println();
        System.out.println("status atual:");
        hero.showDetails();

        while (true) {
            System.out.println("Para onde deseja ir agora?");
            System.out.println("1 - Desfiladeiro do Eclipse");
            System.out.println("2 - Camara Comandante");

            int myWay = input.nextInt();

            if (myWay == 1) return 8; // desfiladeiro do eclipse
            if (myWay == 2) return 9; // camara comandante

            System.out.println("Escolha inválida.");
        }

    }

    /**
     * The method used to create desfiladeiro Eclipse Room
     * @param hero
     * @return int -> used in switch case
     * @throws InterruptedException
     */
    public int desfiladeiroEclipse_08(Hero hero) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        encontroComMercadora(hero);

        narrar2("LOCAL: Desfiladeiro do Eclipse",sc);
        narrar2("Sileth, Ex-guardiã com armadura semi-corrompida, metade iluminada, metade tomada por sombra.",sc);
        narrar("Sileph: Fique longe de mim! A escuridão sussurra... ela controla... eu não...eu não posso…",sc);
        narrar("Sileph: Você vai sofrer Solária",sc);

        Npc sileph = createSileph();

        System.out.println();
        hero.showDetails();
        System.out.println();
        sileph.showDetails();

        boolean venceu = hero.attack(sileph);

        if (!venceu) {
            System.out.println("Você foi derrotado...");
            return 0;
        } else {
            System.out.println("Sileth derrotada! Você continua sua jornada.");
            System.out.println();
            System.out.println();

            while (true) {
                System.out.println("Para onde deseja ir agora?");
                System.out.println("1 - Ruinas ocultas");
                System.out.println("2 - Camara Comandante");

                int myWay = input.nextInt();

                if (myWay == 1) return 7; // ruinas ocultas
                if (myWay == 2) return 9; // camara comandante

                System.out.println("Escolha inválida.");
            }
        }

    }

    /**
     * The method used to create camara comandante Room
     * @param hero
     * @return int -> used in switch case
     * @throws InterruptedException
     */
    public int camaraComandante_09(Hero hero) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        narrar2("LOCAL: Câmara do Comandante", sc);
        narrar2("Você entra e vê o Comandante da Máscara aguardando...", sc);
        narrar("Comandante da Máscara: Então você é a Solária...", sc);
        narrar("Comandante da Máscara: Junte-se a nós, deixe as sombras mostrarem todo o seu poder...", sc);
        narrar2("Solária: Prefiro morrer...", sc);
        narrar("De repente, uma voz familiar ecoa: Sonte, seu irmão gêmeo, é o traidor!", sc);
        narrar2("Sonte: Comandante, mate-a", sc);

        narrar("Prepare-se para a batalha", sc);

        Npc comandante = createComandanteMascara();
        System.out.println();
        hero.showDetails();
        System.out.println();
        comandante.showDetails();

        boolean venceu = hero.attack(comandante);
        if (!venceu) {
            System.out.println("Você foi derrotado...");
            return 0;
        } else {
            System.out.println("Comandante da Máscara derrotado! Está perto de salvar Auralumine");
            System.out.println();
            System.out.println();
            System.out.println("Você caminha em direção a sala do Trono...");
            System.out.println("Seguir para o trono sombrio");
            System.out.println();
            System.out.println();
            return 10;

            }
        }

    /**
     * The method used to create Trono Sombrio Room
     * @param hero
     * @return int -> used in switch case
     * @throws InterruptedException
     */
    public int tronoSombrio_10(Hero hero) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        encontroComMercadora(hero);

        narrar("LOCAL: TRONO SOMBRIO", input);


        narrar("Você entra na grandiosa sala do trono. O ar está pesado, cheio de trevas e silêncio.",sc);
        narrar("Sonte, seu irmão gêmeo, está sentado no trono, metade de seu corpo iluminado, metade mergulhado em sombras.", sc);



        narrar("Sonte: Ah, Solaria... você finalmente veio. Eu esperava por este momento.", sc);
        narrar2("Solaria: Sonte! Como você pôde... matar nossos pais e roubar o Coração de Lumen?", sc);
        narrar("Sonte sorri, mas não há calor em seus olhos, apenas frieza e determinação.", sc);

        narrar("Sonte: Matar nossos pais... foi necessário. Eles eram fracos, limitados pelo medo da tradição. Eu não queria dividir o reino, Solaria. Nunca quis. E agora, a luz não é suficiente para governar este mundo.",sc);
        narrar("Sonte: As sombras são mais fortes, mais rápidas, mais eternas. A Luz é bela... mas fraca, efêmera.", sc);
        narrar2("Solaria: Ainda podemos mudar isso! Não é tarde!", sc);


        System.out.println();
        System.out.println("Pressione Enter para continuar...");
        input.nextLine();

        narrar("Sonte levanta-se, a escuridão envolvendo-o como uma aura viva.", sc);
        narrar("Sonte: Não há mais volta, irmã. Você não vai me salvar, e nem salvará este reino se se opuser a mim.", sc);
        narrar("Sonte: Eu sou a sombra que tudo consome, e quem tentar me enfrentar será destruído.", sc);




        Npc sonteFinal = createSonteFinal();

        System.out.println();
        hero.showDetails();
        System.out.println();
        sonteFinal.showDetails();

        boolean venceu = hero.attack(sonteFinal);

        if (!venceu) {
            System.out.println("Você foi derrotado...");
            return 0;
        } else {
            return 17;

        }

    }

    /**
     * Method used to introduce the saleswoman into the rooms.
     * @param hero
     */
    private void encontroComMercadora(Hero hero) throws InterruptedException {
        Seller lira1 = createSeller();
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Lira surge entre feixes de luz...");
        System.out.println("Lira: Antes de prosseguir, talvez queira se preparar...");
        System.out.println("1 - Comprar");
        System.out.println("0 - Seguir viagem");

        int choice = input.nextInt();
        if (choice == 1) {
            lira1.openStore(hero);
        }else {
            System.out.println("Lira desaparece entre partículas luminosas...");
            System.out.println("você continua seu caminho...");

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    /**
     * Method used to tell the initial story and create the hero to start the game.
     * @return Hero
     */
    public Hero startGame() throws InterruptedException {
        initialHistory();
        return createHero();
    }


    /**
     *
     *Method to start the game's navigation menu
     * @param hero
     * @throws InterruptedException
     */
    public void auralumine(Hero hero) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        int opcao = 1;

        do {
            switch (opcao) {


                case 1:
                    opcao = santuarioLuminar_01();
                    break;

                case 2:
                    opcao = torreHorizonte_02();
                    break;

                case 3:
                    opcao = vilarejoVivalume_03(hero);
                    break;

                case 4:
                    opcao = vilarejoAbandonado_04(hero);
                    break;

                case 5:
                    opcao = casaVilarejoAbandonado_05(hero);
                    break;

                case 6:
                    opcao = fendaNegra_06(hero);
                    break;

                case 7:
                    opcao = ruinasOcultas_07(hero);
                    break;

                case 8:
                    opcao = desfiladeiroEclipse_08(hero);
                    break;

                case 9:
                    opcao = camaraComandante_09(hero);
                    break;

                case 10:
                    opcao = tronoSombrio_10(hero);
                    break;

                case 17 :
                    System.out.println("Você salvou Auralumine");
                    return;
                default:
                    System.out.println("Caminho inexistente...");

            }

        } while (opcao != 0);
        System.out.println("A LUZ DE AURALUMINE SE APAGA...");
        System.out.println("FIM DE JOGO");


    }

}
