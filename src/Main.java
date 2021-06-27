import ai.MoveAI;
import ai.RandomBoss;
import boss.Boss;
import boss.NormalBoss;
import collisionHandler.ObjectCollisionHandler;
import controller.Game;
import model.World;
import physicsHandler.NormalPhysicsHandler;
import views.GameView;
import warplane.NormalWarplane;
import warplane.Warplane;

import java.awt.*;

import static media.AudioPlayer.addAudioByFilePath;

/**
 * Demo route: Main, GameView, Game, GameLoop, World, Sprite, Knight, FiniteStateMachine
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Main {
    public static void main(String[] args) {
//        addAudioByFilePath(Walking.AUDIO_STEP1, new File("assets/audio/step1.wav"));
//        addAudioByFilePath(Walking.AUDIO_STEP2, new File("assets/audio/step2.wav"));
//        addAudioByFilePath(Attacking.AUDIO_SWORD_CLASH_1, new File("assets/audio/sword-clash1.wav"));
//        addAudioByFilePath(Attacking.AUDIO_SWORD_CLASH_2, new File("assets/audio/sword-clash2.wav"));
//        addAudioByFilePath(HealthPointSprite.AUDIO_DIE, new File("assets/audio/die.wav"));

        // initialization procedure
        Warplane warplane = new NormalWarplane(new Point(250, 350));
        Boss boss = new NormalBoss(new Point(250, 0));
        World world = new World(new ObjectCollisionHandler(), new NormalPhysicsHandler(), warplane, boss);  // model
        Game game = new Game(world, warplane, boss);  // controller
        GameView view = new GameView(game);  // view
        MoveAI ai = new RandomBoss(game, boss);
    }
}
