package Entities;

import Items.Consumable;
import Items.HeroItem;
import Items.MainWeapon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Seller {
    private ArrayList<HeroItem> itemsForSale;

    public Seller() {
        this.itemsForSale = new ArrayList<HeroItem>();
    }

    public ArrayList<HeroItem> getItemsForSale() {
        return itemsForSale;
    }

    public void addItemsForSale(HeroItem item){
        itemsForSale.add(item);
    }

    public void showStore(){
        Collections.shuffle(this.itemsForSale);
        System.out.println("Itens disponíveis :");

        for (int i = 0; i < 10; i++) {
            System.out.println("opção" + i+1 +": "+ this.itemsForSale.get(i));
            this.itemsForSale.get(i).showHeroItemDetails();



        }

    }
    public void selling(Hero heroBuy, HeroItem itemBuy ){
        if (itemsForSale.contains(itemBuy)){
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
            heroBuy.setMainWeapon((MainWeapon) itemBuy);
            System.out.println("Arma equipada com sucesso!");
        }
        else if (itemBuy instanceof Consumable) {
            heroBuy.addConsumableInInventory((Consumable) itemBuy);
            System.out.println("Consumível adicionado ao inventário!");
        }

        heroBuy.setGold(heroBuy.getGold() - itemBuy.getGoldPrice());
        System.out.println("compra realizada com sucesso");
        System.out.println("Cuidado por aí, dizem que as luzes se fizeram sombras");
    }

    public void openStore(Hero hero){
        Scanner input = new Scanner(System.in);

        int choice;

        do {

            System.out.println("Detalhes do seu herói atual :");
            hero.showDetails();
            System.out.println();
            System.out.println();
            System.out.println("Escolha um item :");
            showStore();

            choice= input.nextInt();

            if (choice == 0){
                System.out.println("Faremos negócio na proxima, então.");
                break;

            }

            int index = choice -1;

            if (index <0 || index>= itemsForSale.size()){
                System.out.println("Opção invalida");
                continue;
            }

            HeroItem choseItem = itemsForSale.get(index);

            selling(hero,choseItem);




        }while (true);


    }


}
