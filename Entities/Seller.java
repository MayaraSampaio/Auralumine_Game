package Entities;

import Items.Consumable;
import Items.HeroItem;
import Items.MainWeapon;

import java.util.ArrayList;
import java.util.Collections;

public class Seller {
    private ArrayList<HeroItem> itemsForSale;

    public Seller() {
        this.itemsForSale = new ArrayList<HeroItem>();
    }

    public ArrayList<HeroItem> getItemsForSale() {
        return itemsForSale;
    }

    public void showStore(){
        Collections.shuffle(this.itemsForSale);
        System.out.println("Itens disponíveis :");

        for (int i = 0; i < 10; i++) {
            System.out.println("opção" + i+1 +": "+ this.itemsForSale.get(i));
        }

    }
    public void selling(Hero heroBuy, HeroItem itemBuy ){
        if (itemsForSale.contains(itemBuy.isAllowedHero(heroBuy.getHeroType())));

        if (heroBuy.getGold() < itemBuy.getGoldPrice()) {
            System.out.println("Ouro insuficiente!");
            return;
        }
        // verificar se o item comprado é uma arma principal ou um consumível

        if (itemBuy instanceof MainWeapon) {
            heroBuy.setMainWeapon((MainWeapon) itemBuy);
            System.out.println("Arma equipada com sucesso!");
        }else if (itemBuy instanceof Consumable) {
            heroBuy.addConsumableInInventory((Consumable) itemBuy);
            System.out.println("Consumível adicionado ao inventário!");
        }

        heroBuy.setGold(heroBuy.getGold() - itemBuy.getGoldPrice());
        System.out.println("Cuidado por aí, dizem que as luzes se fizeram sombras");
    }
}
