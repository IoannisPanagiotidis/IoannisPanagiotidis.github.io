package game;

import city.cs.engine.*;

public class Monster extends Walker {

    private static final Shape monsterShape = new PolygonShape(-1.125f,0.68f, 0.293f,0.995f,
            1.227f,0.653f, 1.237f,-1.016f, -1.253f,-1.048f);


    public Monster(World world){
        super(world, monsterShape);
        this.addImage(monster);
    }

    public static final BodyImage monster = new BodyImage("data/enemy4.gif", 2);
}