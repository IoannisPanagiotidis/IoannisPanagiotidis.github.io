package game;

import city.cs.engine.Shape;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class GameLevel extends World implements ActionListener {

    private Wizard wizard;
    private Spider spider;
    private int encounter;

    public GameLevel(Game game) {
        //Timer t = new Timer(3000, this);
        //t.start();

        //populate the GameLevel with bodies (ex: platforms, collectibles, characters)

        wizard = new Wizard(this);

        spider = new Spider(this);

        //make a ground platform
        Shape shape = new BoxShape(30, 0.1f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-2f, -12.6f));


        Shape wall = new BoxShape(0.1f, 16);
        StaticBody leftWall = new StaticBody(this, wall);
        leftWall.setPosition(new Vec2(-12.7f, -2));
        StaticBody rightWall = new StaticBody(this, wall);
        rightWall.setPosition(new Vec2(12.7f, -2));
        leftWall.setFillColor(Color.green);
        rightWall.setFillColor(Color.green);

        WizardPickup listener = new WizardPickup(wizard, this, game);
        getWizard().addCollisionListener(listener);


    }

    public Wizard getWizard(){
        return wizard;
    }

    public Spider getSpider(){
        return spider;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public abstract boolean isComplete();

    public abstract Image getBackground();
}
