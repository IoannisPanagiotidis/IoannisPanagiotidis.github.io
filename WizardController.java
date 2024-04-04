package game;


import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class WizardController implements KeyListener {

    private Wizard wizard;
    private static SoundClip jumpSound;

    public WizardController(Wizard w){
        wizard = w;
    }

    static {
        try {
            jumpSound = new SoundClip("data/jump.wav");
            System.out.println("jumpSound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }




    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
            wizard.startWalking(-4);// To the left
        } else if (code == KeyEvent.VK_RIGHT) {
            wizard.startWalking(4); // To the right
        } else if (code == KeyEvent.VK_UP) { // Up
            wizard.jump(10);
            jumpSound.play();
        } else if (code == KeyEvent.VK_DOWN) {
            wizard.stopWalking();
        } else if (code == KeyEvent.VK_SPACE) {
            wizard.shoot();
        }
        else if (code == KeyEvent.VK_U) {
            wizard.setAlwaysOutline(true);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            wizard.stopWalking();
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            wizard.stopWalking();
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            wizard.stopWalking();
            //jumpSound.stop();
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            wizard.stopWalking();
        }
        else if (e.getKeyCode() == KeyEvent.VK_U) {
            wizard.setAlwaysOutline(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e){
        System.out.println("press");
    }

    public void updateWizard(Wizard newWizard){
        wizard = newWizard;

    }
}
