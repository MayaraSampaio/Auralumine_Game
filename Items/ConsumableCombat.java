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
}


