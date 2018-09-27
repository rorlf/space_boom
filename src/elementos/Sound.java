/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Rorlf
 */
public class Sound {
    private String nome;
    private Clip clip;

    public Sound(String nome) {
        this.nome = nome;
        
          

}
    
    
    public void play(){
        try {
        AudioInputStream audioInputStream; 
        audioInputStream = AudioSystem.getAudioInputStream(new File(nome).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        
        
    } catch(Exception error) {           
        System.out.println("Error with playing sound."+error);
    }
    }
    }
    
    
