package Items;

public abstract class Consumable extends HeroItem {

    public Consumable(String nome, int goldPrice) {
        super(nome, goldPrice);
    }

    public abstract void showConsumableItem();

}
