package Entities;

import Items.Consumable;
import Items.ConsumableCombat;
import Items.MainWeapon;

import java.util.ArrayList;
import java.util.Scanner;

public class KnightHero extends Hero {

    public KnightHero(String name, int maxHp, int currentHp, int strength, int gold, HeroType heroType, int level, MainWeapon mainWeapon) {
        super(name, maxHp, currentHp, strength, gold, heroType, level, mainWeapon);
    }

    /**
     * preencher
     * @param targetNpc
     * @return
     */
    @Override
    public boolean attack(Npc targetNpc) {

        specialUsed = false;

        while (this.currentHp > 0 && targetNpc.getCurrentHp() > 0) {

            // NPC - 80% damage
            int npcDamage = (int) Math.round((targetNpc.getStrength() * 0.80));
            currentHp -= npcDamage;
            System.out.println(targetNpc.name + "causou " + npcDamage + " de dano!");

            if (currentHp <= 0) {
                System.out.println("Você foi derrotado!");
                specialUsed = false;
                return false;
            }


            //utiliza uma das opções do menu ataque
            int option = attackMenu();
            int damage = 0;

            switch (option) {
                case 1:
                    damage = normalAttack();
                    break;

                case 2:
                    if (specialUsed) {
                        System.out.println("Não possui mais ataque consumível!");
                        continue;
                    }
                    damage = specialAttack();
                    specialUsed = true;
                    break;

                case 3:
                    ConsumableCombat consumable = choiceConsumableCombate();
                    if (consumable == null) continue;
                    damage = consumableAttack(consumable);
                    break;
            }

            //KnightHero
            targetNpc.setCurrentHp(targetNpc.getCurrentHp() - damage);
            System.out.println("Você causou " + damage + " de dano!");

            if (targetNpc.getCurrentHp()<=0) {
                System.out.println("O vilão foi derrotado!");
                level++;
                strength++;
                currentHp += 10;
                gold += targetNpc.getGold();

                specialUsed = false;
                return true;
            }


        }

        specialUsed = false;
        return false;
    }
}
