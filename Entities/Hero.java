package Entities;

import Items.Consumable;
import Items.MainWeapon;
import Items.Potion;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hero extends Entity {

    protected HeroType heroType;
    protected int level;
    protected MainWeapon mainWeapon;
    protected ArrayList<Consumable> inventory;

    public Hero(String name, int maxHp, int currentHp, int strength, int gold, HeroType heroType, int level, MainWeapon mainWeapon) {
        super(name, maxHp, currentHp, strength, gold);
        this.heroType = heroType;
        this.level = level;
        this.mainWeapon = mainWeapon;
        this.inventory = new ArrayList<Consumable>();
    }

    public HeroType getHeroType() {
        return heroType;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public MainWeapon getMainWeapon() {
        return mainWeapon;
    }

    public void setMainWeapon(MainWeapon mainWeapon) {
        this.mainWeapon = mainWeapon;
    }

    public ArrayList<Consumable> getInventory() {
        return inventory;
    }

    public void addConsumableInInventory(Consumable newConsumable){
        inventory.add(newConsumable);
    }

    public void removeConsumableInventory(Consumable consumableToDelete){
        inventory.remove(consumableToDelete);
    }

    public void usePotion(){
        ArrayList<Potion> potionsInInventory = new ArrayList<Potion>();

        for (Consumable consumable : this.inventory){
            if (consumable instanceof Potion){
                potionsInInventory.add((Potion) consumable);
            }
        }

        if (potionsInInventory.isEmpty()){
            System.out.println("Você está sem poções no seu inventário.");
            return;
        }

        System.out.println("Poções disponíveis");
        for (int i =0; i < potionsInInventory.size();i++){
            System.out.println((i+1) +"-"+ potionsInInventory.get(i));
            potionsInInventory.get(i).showConsumableItem();
            System.out.println("--------------------------------------------");
        }

        Scanner sc = new Scanner(System.in);
        System.out.print(" Digite o número da poção escolhida: ");
        int choice = sc.nextInt() - 1;

        if (choice < 0 || choice >= potionsInInventory.size()){
            System.out.println("Essa escolha é inválida");
            return;
        }

        Potion usePotion = potionsInInventory.get(choice);

        currentHp = currentHp + usePotion.getHealLife();
        if (currentHp > maxHp) {
            currentHp = maxHp;
        }

        strength = strength + usePotion.getIncreaseStrength();

        inventory.remove(usePotion);

        System.out.println("Poção usada com sucesso!");
        System.out.println("Vida atual: " + currentHp + "/" + maxHp);
        System.out.println("Força atual: " + strength);

    }

    /**
     * Método para ataques por turnos
     * @param targetNpc
     * @return true when the Hero Wins | return false when the NPC wins
     */
    public abstract boolean attack(Npc targetNpc);

}
