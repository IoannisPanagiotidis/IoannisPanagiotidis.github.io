package game;

import city.cs.engine.*;

public class Spider extends Walker {

        private static final Shape spiderShape = new PolygonShape(-2.7f,-1.7f, 2.22f,-1.68f, 1.98f,1.92f, -1.98f,2.0f);



    public Spider(World world){
        super(world, spiderShape);
        this.addImage(spider);
        //setAlwaysOutline(true);
    }
    public static final BodyImage spider = new BodyImage("data/enemy2.gif", 8);

}
