package Items;

public class ConsumableCombat extends Consumable {
  private int instantAttack;

    public ConsumableCombat(String nome, int goldPrice, int instantAttack) {
        super(nome, goldPrice);
        this.instantAttack = instantAttack;
    }

    public int getInstantAttack() {
        return instantAttack;
    }

    public void setInstantAttack(int instantAttack) {
        this.instantAttack = instantAttack;
    }


    @Override
    public void showConsumableItem() {

        System.out.println("Ataque instantaneo : " + this.instantAttack);
    }


    @Override
    public void showHeroItemDetails() {
        System.out.println("Nome : " +this.name+ "| Intant Attack : " + this.instantAttack+ "| Preço : " + this.goldPrice + "moedas de ouro ");
        System.out.println( "Heróis que podem usar:");
        showHerosAllowed();
    }
}


