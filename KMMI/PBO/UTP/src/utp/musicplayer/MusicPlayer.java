package utp.musicplayer;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class MusicPlayer {
    private Clip clip;
    private long clipTimePosition;
    public void playMusic(String musicLocation) {
        try {
            File musicPath = new File(musicLocation);
            
            if (musicPath.exists()){
                System.out.println("getting music");
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                
                clip.start();
                
                System.out.println("starting music");
                //JOptionPane.showMessageDialog(null, "Press OK to Stop Playing");
                
            } else {
                System.out.println("Can't find music file");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void loopMusic(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void pauseMusic(){
        this.clipTimePosition = clip.getMicrosecondPosition();
        clip.stop();
    }
    public void stopMusic(){
        clip.stop();
    }
    public void continueMusic() {
        
        clip.setMicrosecondPosition(this.clipTimePosition);
        clip.start();
    }
}
