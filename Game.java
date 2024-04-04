package game;

import city.cs.engine.DebugViewer;
import city.cs.engine.SoundClip;
import city.cs.engine.World;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

/**
 * Your main game entry point
 */
public class Game {

    GameLevel currentLevel;
    GameView view;
    Wizard wizard;
    World world;
    WizardController controller;
    private SoundClip gameMusic;


    public GameLevel getCurrentLevel() {
        return currentLevel;
    }

    /** Initialise a new Game. */
    public Game() {

        //1. make an empty game world
        currentLevel = new Level1(this);


        try {
            gameMusic = new SoundClip("data/game music - MAIN.mp3");
            gameMusic.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }


        //2. make a view to look into the game world
        //UserView view = new UserView(world, 1000, 1000);
        view = new GameView(currentLevel, 500, 500);

        controller = new WizardController(currentLevel.getWizard());
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));


        wizard = currentLevel.getWizard();
        //controller = new WizardController(currentLevel.getWizard());



        //view.addMouseListener(new BoxPlacer(view, world));



        //3. create a Java window (frame) and add the game
        //   view to it
        final JFrame frame = new JFrame("City Game");
        frame.add(view);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
         JFrame debugView = new DebugViewer(currentLevel, 500, 500);

        // start our game world simulation!
        currentLevel.start();
    }

    public void goToNextLevel() {

        if (currentLevel instanceof Level1) {
            currentLevel.stop();
            currentLevel = new Level2(this);
            view.setWorld(currentLevel);
            controller.updateWizard(currentLevel.getWizard());
            currentLevel.start();
        } else if (currentLevel instanceof Level2) {
            currentLevel.stop();
            currentLevel = new Level3(this);
            view.setWorld(currentLevel);
            controller.updateWizard(currentLevel.getWizard());
            currentLevel.start();
        } else if (currentLevel instanceof Level3) {
            currentLevel.stop();
            currentLevel = new Level4(this);
            view.setWorld(currentLevel);
            controller.updateWizard(currentLevel.getWizard());
            currentLevel.start();
        } else if (currentLevel instanceof Level4) {
            currentLevel.stop();
            currentLevel = new Level5(this);
            view.setWorld(currentLevel);
            controller.updateWizard(currentLevel.getWizard());
            currentLevel.start();
        } else if (currentLevel instanceof Level5) {
            System.exit(0);
        }
    }



    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
