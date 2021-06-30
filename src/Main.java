import ai.MoveAI;
import ai.RandomBoss;
import boss.Boss;
import boss.NormalBoss;
import boss.StrongerBoss;
import collisionHandler.ObjectCollisionHandler;
import controller.Game;
import flyingObject.boost.FixedTimeRandomBoostHandler;
import model.World;
import physicsHandler.NormalPhysicsHandler;
import physicsHandler.RandomPhysicsHandler;
import views.GameView;
import warplane.NormalWarplane;
import warplane.StrongerWarplane;
import warplane.Warplane;

import java.awt.*;


/**
 * Demo route: Main, GameView, Game, GameLoop, World, Sprite, Knight, FiniteStateMachine
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Main {
    public static void main(String[] args) {
        // initialization procedure
        Warplane warplane = new NormalWarplane(new Point(GameView.WIDTH / 2, GameView.HEIGHT - 100));
        Boss boss = new NormalBoss(new Point(GameView.WIDTH / 2, 50));
        World world = new World(new ObjectCollisionHandler(), new NormalPhysicsHandler(), new FixedTimeRandomBoostHandler(), warplane, boss);  // model
        Game game = new Game(world, warplane, boss);  // controller
        GameView view = new GameView(game);  // view
        MoveAI ai = new RandomBoss(game, boss);
    }
}
