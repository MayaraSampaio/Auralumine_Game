import Entities.Hero;
import Game.Game;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        Hero hero = game.startGame();
        game.auralumine(hero);

    }
}
