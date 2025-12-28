package Entities;
import Items.Consumable;
import Items.ConsumableCombat;
import Items.MainWeapon;
import Items.Potion;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hero extends Entity {

    protected HeroType heroType;
    protected int level;
    protected MainWeapon mainWeapon;
    protected ArrayList<Consumable> inventory;
    protected boolean specialUsed;

    public Hero(String name, int maxHp, int currentHp, int strength, int gold, HeroType heroType, int level, MainWeapon mainWeapon,boolean specialUsed) {
        super(name, maxHp, currentHp, strength, gold);
        this.heroType = heroType;
        this.level = level;
        this.mainWeapon = mainWeapon;
        this.inventory = new ArrayList<Consumable>();
        this.specialUsed =false;
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

    /**
     * método para usar uma poção
     */
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
     * Metodo que chama o Menu para escolher o tipo de ataque
     * @return choice
     */
    public int attackMenu(){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Escolha o tipo de ataque:");
            System.out.println("1 - Ataque Normal");
            System.out.println("2 - Ataque Especial");
            System.out.println("3 - Ataque Consumível");

            int choice = sc.nextInt();

            if (choice >=1 && choice <=3 ) {
                return choice;
            }
            else {
                System.out.println("Esta opção é inválida, tente novamente!");
            }
        }

    }

    /**
     * Metodo para mostrar as opções de consumiveis de combate disponiveis do jogador
     * @return consumable combate
     */
    public ConsumableCombat choiceConsumableCombate(){
        Scanner sc = new Scanner(System.in);

        ArrayList<ConsumableCombat> listConsumablesCombat = new ArrayList<>();

        for (Consumable consumable : this.inventory){
            if (consumable instanceof ConsumableCombat){
                listConsumablesCombat.add((ConsumableCombat) consumable);
            }
        }
        if (listConsumablesCombat.isEmpty()){
            System.out.println("Você não possui consumíveis de combate.");
            return null;
        }

        while (true) {
            System.out.println("Consumíveis de Combate:");
            for (int i = 0; i < listConsumablesCombat.size(); i++) {
                System.out.println((i + 1) + "-" + listConsumablesCombat.get(i));
            }
            System.out.println("0-Cancelar");

            int choice = sc.nextInt();

            //utilizado para quando o jogador quiser voltar para o menu inicial que será implementado no metodo de ataque
            if (choice == 0) {
                return null;

            }

            if (choice > 0 && choice <= listConsumablesCombat.size()) {
                return listConsumablesCombat.get(choice - 1);
            }

            System.out.println("Escolha inválida.");
        }

    }



    /**
     * Método que retorna dano causado para o ataque normal
     * @return damage value
     */
    public int normalAttack(){
        int damage = this.strength + this.mainWeapon.getAttack();
        return damage;
    };

    /**
     * Método que retone dano causado para ataque especial
     * @return damage
     */
    public int specialAttack(){
        int damage = this.strength + this.mainWeapon.getSpecialAttack();
        return damage;
    }

    /**
     *Método que retorna dano causado por instantAttack e remove o consumable combat utilizado
     * @param consumable
     * @return damage
     */
    public int consumableAttack(ConsumableCombat consumable){
        int damage = consumable.getInstantAttack();
        removeConsumableInventory(consumable);
        return damage;

    }


    /**
     * Método para ataques por turnos
     * @param targetNpc
     * @return true when the Hero Wins | return false when the NPC wins
     */
    public abstract boolean attack(Npc targetNpc);
}
