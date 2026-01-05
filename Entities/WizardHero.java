package Entities;

import Items.Consumable;
import Items.ConsumableCombat;
import Items.MainWeapon;

import java.util.ArrayList;

public class WizardHero extends Hero {

    public WizardHero(String name, int maxHp, int currentHp, int strength, int gold, HeroType heroType, int level, MainWeapon mainWeapon) {
        super(name, maxHp, currentHp, strength, gold, heroType, level, mainWeapon);
    }

    /**
     *Witch's attack method
     * @param targetNpc
     * @return
     */
    @Override
    public boolean attack(Npc targetNpc) {

        specialUsed = false;

        while (this.currentHp > 0 && targetNpc.getCurrentHp() > 0) {

            int option = attackMenu();
            int damage = 0;

            switch (option) {
                case 1:
                    damage = normalAttack();
                    break;

                case 2:
                    if (specialUsed) {
                        System.out.println("Não possui mais ataques consumíveis!");
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
                case 4:
                    usePotion();
                    continue;
            }

            //WizardHero
            targetNpc.setCurrentHp(targetNpc.getCurrentHp() - damage);
            System.out.println("Você causou " + damage + " de dano!");
            System.out.println(targetNpc.name + targetNpc.getCurrentHp() + "|  Sua vida : " + this.currentHp);


            if (targetNpc.getCurrentHp()<=0) {
                System.out.println("O vilão foi derrotado!");
                level++;
                strength++;
                currentHp += 10;
                gold += targetNpc.getGold();

                specialUsed = false;
                return true;
            }

            // NPC
            int npcDamage = targetNpc.getStrength();
            currentHp -= npcDamage;
            System.out.println("O NPC causou " + npcDamage + " de dano!");
            System.out.println(targetNpc.name + targetNpc.getCurrentHp() + " Sua vida : " + this.currentHp);
            System.out.println();
            System.out.println();


            if (currentHp <= 0) {
                System.out.println("Você foi derrotado!");
                specialUsed = false;
                return false;
            }
        }

        specialUsed = false;
        return false;
    }

    @Override
    public void showDetails() {
            System.out.println( "Name : "+ this.name + " hp: "+ this.currentHp+"/"+ this.maxHp + " | Strength +" + this.strength + " | Gold :" + this.gold +"Level :"+this.level );

    }
}
