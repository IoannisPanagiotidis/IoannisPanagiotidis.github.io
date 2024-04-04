/*package game;

import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoxPlacer implements MouseListener {

    private GameView view;
    private GameLevel world;

    public BoxPlacer(GameView v, GameLevel w){
        view = v;
        world = w;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Vec2 worldPos = view.viewToWorld(e.getPoint());

        StaticBody box = new StaticBody(world, new BoxShape(0.5f, 1));
        box.setPosition(worldPos);
        box.setFillColor(Color.red);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
*/