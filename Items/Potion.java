package Items;

public class Potion extends Consumable {
    private int healLife;
    private int increaseStrength;

    public Potion(String name, int goldPrice, int healLife, int increaseStrength) {
        super(name, goldPrice);
        this.healLife = healLife;
        this.increaseStrength = increaseStrength;
    }

    public int getHealLife() {
        return healLife;
    }

    public void setHealLife(int healLife) {
        this.healLife = healLife;
    }

    public int getIncreaseStrength() {
        return increaseStrength;
    }

    public void setIncreaseStrength(int increaseStrength) {
        this.increaseStrength = increaseStrength;
    }

    @Override
    public void showConsumableItem() {
        System.out.println("Nome :" + super.name +" | Poder de Cura : " +this.healLife + "| Aumento de força : " + this.increaseStrength);
    }


    @Override
    public void showHeroItemDetails() {
        System.out.println(this.goldPrice +"moedas de ouro ");
        showConsumableItem();
        System.out.println( "Heróis que podem usar:");
        showHerosAllowed();
    }
}
