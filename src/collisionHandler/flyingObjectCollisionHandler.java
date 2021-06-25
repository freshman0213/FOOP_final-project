package collisionHandler;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import effect.Effect;
import flyingObject.FlyingObjects;
import livingObject.LivingObject;
import model.CollisionHandler;
import model.Sprite;
import views.GameView;

public class flyingObjectCollisionHandler implements CollisionHandler {

    @Override
    public void handle(Point originalLocation, Sprite from, Sprite to) {
        if(from instanceof LivingObject && to instanceof FlyingObjects){
            FlyingObjects flyingObjects = (FlyingObjects) to;
            LivingObject livingObject = (LivingObject) from;
            List<Effect> effects = flyingObjects.getEffects();
            effects.forEach(e -> e.apply(livingObject));
            flyingObjects.getWorld().removeSprite(flyingObjects);
        }
        else if(to instanceof LivingObject && from instanceof FlyingObjects){
            FlyingObjects flyingObjects = (FlyingObjects) from;
            LivingObject livingObject = (LivingObject) to;
            List<Effect> effects = flyingObjects.getEffects();
            effects.forEach(e -> e.apply(livingObject));
            flyingObjects.getWorld().removeSprite(flyingObjects);
        }
        else if(from instanceof LivingObject && to instanceof LivingObject){
            // minus hp
        }
        // out of window
        Rectangle range = from.getRange();
        Rectangle body = from.getBody();
        if(body.x < 0) from.setLocation(new Point(range.x - body.x, range.y));
        if(body.y < 0) from.setLocation(new Point(range.x, range.y - body.y));
        if(body.x + body.width > GameView.WIDTH) from.setLocation(new Point(range.x - (body.x + body.width - GameView.WIDTH), range.y));
        if(body.y + body.height > GameView.HEIGHT) from.setLocation(new Point(range.x, range.y - (body.y + body.height - GameView.HEIGHT)));
    }
    
}
