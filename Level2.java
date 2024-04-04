package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level2 extends GameLevel{

    private Treasure treasure;
    Image background;

    public Level2(Game game){
        super(game);

        background = new ImageIcon("data/level2.png").getImage();


        // make a suspended platform
        Shape platformShape = new BoxShape(3f, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-9, -8f));
        platform1.setFillColor(Color.green);


        Shape platformShape2 = new BoxShape(3.8f, 0.4f);
        StaticBody platform2 = new StaticBody(this, platformShape2);
        platform2.setPosition(new Vec2(8, 6.5f));
        platform2.setFillColor(Color.green);

        Shape platformShape3 = new BoxShape(3f, 0.5f);
        StaticBody platform3 = new StaticBody(this, platformShape3);
        platform3.setPosition(new Vec2(2, -4f));
        platform3.setFillColor(Color.green);

        Shape platformShape4 = new BoxShape(3f, 0.5f);
        StaticBody platform4 = new StaticBody(this, platformShape4);
        platform4.setPosition(new Vec2(8, -2f));
        platform4.setFillColor(Color.green);

        Shape platformShape5 = new BoxShape(2f, 0.5f);
        StaticBody platform5 = new StaticBody(this, platformShape5);
        platform5.setPosition(new Vec2(-9, 0f));
        platform5.setFillColor(Color.green);

        Shape platformShape6 = new BoxShape(2f, 0.5f);
        StaticBody platform6 = new StaticBody(this, platformShape6);
        platform6.setPosition(new Vec2(0, 5f));
        platform6.setFillColor(Color.green);
        //platform6.move(new Vec2(-1, 3));

        //make a character (with an overlaid image)
        getWizard().setPosition(new Vec2(2, -11));



        //creat spider enemy
        getSpider().setPosition(new Vec2(6, 9));

        //creat treasure level 1
        treasure = new Treasure(this);
        treasure.setPosition(new Vec2(10, 9));


    }

    @Override
    public boolean isComplete() {
        if (getWizard().getTreasure() == 1)
            return true;
        else
            return false;
    }

    @Override
    public Image getBackground() {
        return background;
    }
}
