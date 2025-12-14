package Items;

public class MainWeapon extends HeroItem {
    private int attack;
    private int specialAttack;

    public MainWeapon(String nome, int goldPrice, int attack, int specialAttack) {
        super(nome, goldPrice);
        this.attack = attack;
        this.specialAttack = specialAttack;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }
}
