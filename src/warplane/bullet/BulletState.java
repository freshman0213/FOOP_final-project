package warplane.bullet;

import flyingObjects.Bullet;
import warplane.StatusState;

public interface BulletState extends StatusState {
    Bullet getBullet();
}
