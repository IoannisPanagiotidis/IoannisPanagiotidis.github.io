package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Heart extends DynamicBody {
    private static final Shape heartShape = new PolygonShape(-0.492f,0.488f, -0.492f,-0.002f,
            -0.082f,-0.494f, 0.064f,-0.502f, 0.516f,0.022f, 0.478f,0.49f);

    private static SoundClip heartSound;

    public Heart(World world){
        super(world, heartShape);
        this.addImage(heart);
        //setAlwaysOutline(true);
    }
    public static final BodyImage heart = new BodyImage("data/heart.png", 1);

    static {
        try {
            heartSound = new SoundClip("data/jump.wav");
            System.out.println("heartsound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    @Override
    public void destroy()
    {
        heartSound.play();
        super.destroy();

    }
}
