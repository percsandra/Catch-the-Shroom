package org.academiadecodigo.splicegirls.CatchTheShroom.MusicPlayer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class MusicPlayer {

    public void playMusic(String musicLocation) {
        try
        {
            File musicPath = new File(musicLocation);

            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);

                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);

                //JOptionPane.showMessageDialog(null,"Press OK to stop playing");
                //clip.stop();

            }
            else
            {
                System.out.println("BZZT ERROR BZZT FILE NOT FOooooouund.....d...bzzt... boop");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}