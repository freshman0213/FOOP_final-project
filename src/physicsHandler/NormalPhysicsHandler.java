package physicsHandler;

import java.awt.Dimension;

import model.PhysicsHandler;
import model.Sprite;

import java.awt.*;

public class NormalPhysicsHandler implements PhysicsHandler{

    @Override
    public void applyForce(Sprite from, Dimension offset) {
        from.getLocation().translate(offset.width, offset.height);
    }
    
}
