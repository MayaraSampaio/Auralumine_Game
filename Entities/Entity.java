package Entities;

public abstract class Entity {
    protected String name;
    protected int maxHp;
    protected int currentHp;
    protected int strength;
    protected int gold;

    public Entity(String name, int maxHp, int currentHp, int strength, int gold) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.strength = strength;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     *Method for showing details
     */
    public void showDetails(){
        System.out.println( "Name : "+ this.name + " hp: "+ this.currentHp+"/"+ this.maxHp + " | Strength +" + this.strength + " | Gold :" + this.gold);

    }
}
