package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class DestroyEnemies implements CollisionListener {
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Monster) {
            collisionEvent.getOtherBody().destroy();
        }
        if (collisionEvent.getOtherBody() instanceof Spider) {
            collisionEvent.getOtherBody().destroy();
        }

    }
}
