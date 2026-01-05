package Entities;

public class Npc extends Entity {


    public Npc(String name, int maxHp, int hp, int forca, int gold) {
        super(name, maxHp, hp, forca, gold);
    }

    @Override
    public void showDetails() {
        System.out.println( "Name : "+ this.name + " hp: "+ this.currentHp+"/"+ this.maxHp + " | Strength +" + this.strength + " | Gold :" + this.gold )
        ;
    }

}
