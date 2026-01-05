package Entities;

import Assets.Audio;
import Items.Consumable;
import Items.HeroItem;
import Items.MainWeapon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Seller {
    private ArrayList<HeroItem> itemsForSale;

    public Seller() {

        this.itemsForSale = new ArrayList<HeroItem>();
    }

    public ArrayList<HeroItem> getItemsForSale() {
        return itemsForSale;
    }

    /**
     * Method for adding new items for sale.
     * @param item
     */
    public void addItemsForSale(HeroItem item){
        itemsForSale.add(item);
    }


    /**
     * Method for displaying sales inventory in a random order.
     */
    public void showStore(){
        System.out.println();
        Collections.shuffle(this.itemsForSale);
        System.out.println("Itens disponíveis :");

        for (int i = 0; i < 10; i++) {
            System.out.println("Opção " + (i + 1) + ":");
            this.itemsForSale.get(i).showHeroItemDetails();
            System.out.println("----------------------------");
        }
        System.out.println("0 - Sair da loja");

    }

    /**
     * Method for implementing the sales logic.
     * @param heroBuy
     * @param itemBuy
     */
    public void selling(Hero heroBuy, HeroItem itemBuy ) throws InterruptedException {
        if (!itemsForSale.contains(itemBuy)){
            System.out.println("Item não disponível.");
            return;
        }

        if (!itemBuy.isAllowedHero(heroBuy.getHeroType())) {
            System.out.println("Este item não está disponível para seu tipo de herói.");
            return;
        }

        if (heroBuy.getGold() < itemBuy.getGoldPrice()) {
            System.out.println("Ouro insuficiente!");
            return;
        }
        // verificar se o item comprado é uma arma principal ou um consumível

        if (itemBuy instanceof MainWeapon) {
            Audio.playMusic("AudioFiles/SonicRingSound.wav");
            sleep(3000);
            Audio.stopMusic();
            heroBuy.setMainWeapon((MainWeapon) itemBuy);
            System.out.println("Arma equipada com sucesso!");
        }
        else if (itemBuy instanceof Consumable) {
            Audio.playMusic("AudioFiles/SonicRingSound.wav");
            sleep(3000);
            Audio.stopMusic();
            heroBuy.addConsumableInInventory((Consumable) itemBuy);
            System.out.println("Consumível adicionado ao inventário!");
        }

        heroBuy.setGold(heroBuy.getGold() - itemBuy.getGoldPrice());
        System.out.println("compra realizada com sucesso");
        System.out.println();
    }

    /**
     * Method for displaying items and making a sale if the hero wishes.
     * @param hero
     */
    public void openStore(Hero hero) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        int choice;

        while(true) {
            System.out.println();
            System.out.println("--------LOJA--------");
            System.out.println();
            System.out.println("OURO ATUAL :" + hero.getGold());
            System.out.println("O que você deseja comprar :");
            showStore();

            choice = input.nextInt();

            if (choice == 0) {
                System.out.println("Nos vemos em breve!");
                System.out.println();
                break;

            }

            int index = choice - 1;

            if (index < 0 || index >= itemsForSale.size()) {
                System.out.println("Opção invalida");
                continue;
            }

            HeroItem choseItem = itemsForSale.get(index);

            selling(hero, choseItem);

        }





    }


}
