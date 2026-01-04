package Items;

import Entities.HeroType;

import java.util.ArrayList;

public abstract class HeroItem {
    protected String name;
    protected int goldPrice;
    protected ArrayList<HeroType> allowedHeroes;

    public HeroItem(String name, int goldPrice) {
        this.name = name;
        this.goldPrice = goldPrice;
        this.allowedHeroes = new ArrayList<HeroType>();
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public int getGoldPrice() {
        return goldPrice;
    }

    public void setGoldPrice(int goldPrice) {
        this.goldPrice = goldPrice;
    }

    public ArrayList<HeroType> getAllowedHeroes() {
        return allowedHeroes;
    }

    public String getName() {
        return name;
    }

    /**
     * Method to add which heroes are allowed to use a specific item.
     * @param typeOfHero
     */
    public void addAllowedHeroes(HeroType typeOfHero){
    allowedHeroes.add(typeOfHero);

   }

    /**
     * Method to list which heroes are allowed to use a specific item.
     */
   public void showHerosAllowed(){
       for(HeroType hero : this.allowedHeroes){
           System.out.println("-" + hero);
       }
   }

    /**
     * Method to verify which heroes are allowed to use a specific item.
     * @param heroType
     * @return
     */
    public boolean isAllowedHero(HeroType heroType) {
        return allowedHeroes.contains(heroType);
    }


   public abstract void showHeroItemDetails();






}
