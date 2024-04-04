package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Wizard extends Walker {

    private static final Shape wizardShape = new PolygonShape(-1.63f, 1.92f, 1.07f, 1.91f, 1.05f, -1.95f, -1.61f, -1.97f);

    public static final BodyImage leftImage = new BodyImage("data/character1left.png", 4);

    public static final BodyImage rightImage = new BodyImage("data/character1right.png", 4);

    private static final BodyImage magicBeamImage = new BodyImage("data/bullet2.png", 2);

    private String direction;
    private int treasure;

    public DynamicBody getBeam() {
        return beam;
    }

    private DynamicBody beam;

    public Wizard(World world) {
        super(world, wizardShape);
        this.addImage(rightImage);
        direction = "right";
        //setAlwaysOutline(true);

    }

    public void setTreasure(int treasure){
        this.treasure = treasure;
        System.out.println(treasure);
    }

    public int getTreasure() {
        return treasure;
    }

    public void shoot() {
        beam = new DynamicBody(this.getWorld(), new PolygonShape(-1.013f,0.12f, -0.656f,0.344f,
                0.016f,0.344f, 0.011f,-0.253f, -0.683f,-0.259f, -1.056f,0.008f));

        if (direction.equals("right")) {
            beam.setPosition(new Vec2(this.getPosition().x + 1.5f, this.getPosition().y));
            beam.setLinearVelocity(new Vec2(20f, 0));
            beam.addImage(magicBeamImage);
            beam.addCollisionListener(new DestroyEnemies());
        } else {
            beam.setPosition(new Vec2(this.getPosition().x - 1.5f, this.getPosition().y));
            beam.setLinearVelocity(new Vec2(-20f, 0));
            beam.addImage(magicBeamImage);
            beam.addCollisionListener(new DestroyEnemies());
        }
    }


    @Override
    public void startWalking(float speed){
        super.startWalking(speed);
        if (speed > 0){
            this.removeAllImages();
            this.addImage(rightImage);
            direction = "right";
        }
        else if (speed < 0){
            this.removeAllImages();
            this.addImage(leftImage);
            direction = "left";
        }
    }

}
