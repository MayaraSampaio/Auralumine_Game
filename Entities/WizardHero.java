package Entities;

import Items.MainWeapon;

public class WizardHero extends Hero {

    public WizardHero(String name, int maxHp, int currentHp, int strength, int gold, HeroType heroType, int level, MainWeapon mainWeapon) {
        super(name, maxHp, currentHp, strength, gold, heroType, level, mainWeapon);
    }

    @Override
    public boolean attack(Npc targetNpc) {

        return true;
    }
}
