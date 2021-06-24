package livingObject.bullet;

import flyingObject.Bullet;
import livingObject.StatusState;

public interface BulletState extends StatusState {
    Bullet getBullet();
}
