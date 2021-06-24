package warplane;

import fsm.ImageRenderer;
import livingObject.LivingObject;
import flyingObject.Bullet;
import livingObject.cd.*;
import livingObject.bullet.*;
import livingObject.numBullets.*;
import livingObject.velocity.*;
import model.SpriteShape;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.*;

import static livingObject.LivingObject.Status.*;

public abstract class Warplane extends LivingObject {
    private final Map<Object, ImageRenderer> imageRenderers = new HashMap<>();

    public Warplane(int hp, int cd, Bullet bullet, int numBullet, int velocity, SpriteShape shape, List<Image> idleImages, List<Image> walkingImages) { // template for all warplanes
        super(hp, cd, bullet, numBullet, velocity, shape, idleImages, walkingImages);
        imageRenderers.put(CD, new CDImageRenderer(this));
        imageRenderers.put(Bullet, new BulletImageRenderer(this));
        imageRenderers.put(NumBullets, new NumBulletsImageRenderer(this));
        imageRenderers.put(Velocity, new VelocityImageRenderer(this));


    }

    public ImageRenderer getImageRenderer(Object status) {
        return imageRenderers.get(status);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        // display status
        for (Object status : Status.values()) {
            imageRenderers.get(status).render(currentStatus.get(status)., g); // TODO: how to handle ImageState
        }
    }
}
