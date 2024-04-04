package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class WizardPickup implements CollisionListener {

    private Wizard wizard;
    GameLevel currentLevel;
    Game game;


    public WizardPickup(Wizard w, GameLevel level, Game game) {
        wizard = w;
        currentLevel = level;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Treasure) {
            wizard.setTreasure(wizard.getTreasure() + 1);
            collisionEvent.getOtherBody().destroy();
        }

        if (collisionEvent.getOtherBody() instanceof Heart) {
            collisionEvent.getOtherBody().destroy();
        }

        if (currentLevel.isComplete())
            game.goToNextLevel();

    }
}
