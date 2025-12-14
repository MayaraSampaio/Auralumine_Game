package Entities;

import Items.MainWeapon;

import java.util.Scanner;

public class KnightHero extends Hero {

    public KnightHero(String name, int maxHp, int currentHp, int strength, int gold, HeroType heroType, int level, MainWeapon mainWeapon) {
        super(name, maxHp, currentHp, strength, gold, heroType, level, mainWeapon);
    }


    @Override
    public boolean attack(Npc targetNpc) {
        Scanner input = new Scanner(System.in);

        while(currentHp > 0 && targetNpc.currentHp > 0){

            //first atack: NPC
            int npcDamage = (int) (targetNpc.getStrength() * 0.80);
            currentHp -= npcDamage;

            //Hero atack
            if (currentHp > 0) return false;

        }
        return true;

    }
}
