package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import java.awt.*;

public class GameView extends UserView {

    GameLevel currentLevel;



    public GameView(GameLevel w, int width, int height) {
        super(w, width, height);
        currentLevel = w;
    }

    @Override
    public void setWorld(World w){

        super.setWorld(w);
        currentLevel =(GameLevel) w;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(currentLevel.getBackground(), 0, 0, this);
    }
}
