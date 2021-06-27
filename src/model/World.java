package model;

import java.awt.*;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import controller.Game;
import flyingObject.FlyingObjects;
import livingObject.LivingObject;
import views.GameView;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toSet;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class World {
    private final List<Sprite> sprites = new CopyOnWriteArrayList<>();
    private final CollisionHandler collisionHandler;
    private final PhysicsHandler physicsHandler;

    public World(CollisionHandler collisionHandler, PhysicsHandler physicsHandler, Sprite... sprites) {
        this.collisionHandler = collisionHandler;
        this.physicsHandler = physicsHandler;
        addSprites(sprites);
    }

    public void update() {
        for (Sprite sprite : sprites) {
            sprite.update();
        }
    }

    public void addSprites(Sprite... sprites) {
        stream(sprites).forEach(this::addSprite);
    }

    public void addSprite(Sprite sprite) {
        sprites.add(sprite);
        sprite.setWorld(this);
    }

    public void removeSprite(Sprite sprite) {
        sprites.remove(sprite);
        sprite.setWorld(null);
    }

    public void move(Sprite from, Dimension offset) {
        Point originalLocation = new Point(from.getLocation());
        
        physicsHandler.applyForce(from, offset);

        Rectangle range = from.getRange();
        Rectangle body = from.getBody();
        
        // collision detection
        for (Sprite to : sprites) {
            if (to != from && body.intersects(to.getBody())) {
                collisionHandler.handle(originalLocation, from, to);
            }
        }

        if(from instanceof FlyingObjects){
            if(body.x < 0 || body.y < 0 || body.x + body.width > GameView.WIDTH || body.y + body.height > GameView.HEIGHT)
                removeSprite(from);
        }
        else if(from instanceof LivingObject){
            if(body.x < 0) from.setLocation(new Point(range.x - body.x, range.y));
            if(body.y < 0) from.setLocation(new Point(range.x, range.y - body.y));
            if(body.x + body.width > GameView.WIDTH) from.setLocation(new Point(range.x - (body.x + body.width - GameView.WIDTH), range.y));
            if(body.y + body.height > GameView.HEIGHT) from.setLocation(new Point(range.x, range.y - (body.y + body.height - GameView.HEIGHT)));
        }
    }

    public Collection<Sprite> getSprites(Rectangle area) {
        return sprites.stream()
                .filter(s -> area.intersects(s.getBody()))
                .collect(toSet());
    }

    public List<Sprite> getSprites() {
        return sprites;
    }

    // Actually, directly couple your model with the class "java.awt.Graphics" is not a good design
    // If you want to decouple them, create an interface that encapsulates the variation of the Graphics.
    public void render(Graphics g) {
        for (Sprite sprite : sprites) {
            sprite.render(g);
        }
    }
}
