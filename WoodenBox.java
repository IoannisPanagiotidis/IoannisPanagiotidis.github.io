package game;

import city.cs.engine.*;

public class WoodenBox extends DynamicBody {
    private static final Shape woodenBoxShape = new PolygonShape(-1.09f,1.14f, 1.1f,1.13f, 1.08f,-1.07f,
            -1.09f,-1.07f, -1.09f,1.13f);

    public WoodenBox(World world){
        super(world, woodenBoxShape);
        this.addImage(woodenBox);
        //setAlwaysOutline(true);
    }
    public static final BodyImage woodenBox = new BodyImage("data/box.png", 3);
}
