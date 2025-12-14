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

    public void addAllowedHeroes(HeroType typeOfHero){
    allowedHeroes.add(typeOfHero);

   }
   public void showHerosAllowed(){
       for(HeroType hero : this.allowedHeroes){
           System.out.println("-" + hero);
       }
   }
    public boolean isAllowedHero(HeroType heroType) {
        return allowedHeroes.contains(heroType);
    }


   public void showHeroItemDetails(){

       System.out.println("Nome : " +this.name+ "| Preço : " + this.goldPrice +"moedas de ouro ");
       System.out.println( "Heróis que podem usar:");
       showHerosAllowed();
   }






}
