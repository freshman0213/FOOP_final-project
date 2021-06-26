package physicsHandler;

import java.awt.Dimension;
import java.util.Random;

import model.PhysicsHandler;
import model.Sprite;

public class RandomPhysicsHandler implements PhysicsHandler{

    @Override
    public void applyForce(Sprite from, Dimension offset) {
        Random random = new Random();
        int xScale = random.nextInt(5) - 2;
        int yScale = random.nextInt(5) - 2;
        from.getLocation().translate(xScale * offset.width, yScale * offset.height);
    }
    
}
