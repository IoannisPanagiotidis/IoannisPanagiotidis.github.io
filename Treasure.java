package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Treasure extends DynamicBody {

    private static final Shape treasureShape = new PolygonShape(-0.904f,0.952f, 0.956f,0.928f, 0.952f,-0.56f, 0.216f,
            -0.984f, -0.904f,-0.608f, -0.924f,0.932f);

    private static SoundClip treasureSound;

    public Treasure(World world){
        super(world, treasureShape);
        this.addImage(treasure);
        //setAlwaysOutline(true);
    }
    public static final BodyImage treasure = new BodyImage("data/treasure.png", 2);

    static {
        try {
            treasureSound = new SoundClip("data/jump.wav");
            System.out.println("heartsound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    @Override
    public void destroy()
    {
        treasureSound.play();
        super.destroy();
    }

}
