/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Rorlf
 */
public class Nave {
    private double x;
    private double y;
    private double dy;
    private double dx;

    private int width;
    private int height;
    private boolean visible;
    private List<Tiro> tiros;
    private int limiteMissil;
    private int speed; 
    private boolean turbo;

  
    protected Image nave_image;
    
    public Nave(int x, int y) {
        this.x = x;
        this.y = y;
        criarnave();
    }
    private void criarnave(){
    tiros = new ArrayList<>();
    loadImage();    
    getImageDimensions();
      setVisible(true);

    
    }
    
      public List<Tiro> getTiros() {
        return tiros;
    }
    
    protected void getImageDimensions() {

        width = nave_image.getWidth(null);
        height = nave_image.getHeight(null);
    }

    protected void loadImage() {
        
        nave_image = new ImageIcon(this.getClass().getResource("/imagens/spaceshipt.png")).getImage();
    }

    public Image getImage() {
        return nave_image;
    }
    

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
      public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
       public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, width, height);
    }
    
    public void andar(){
    x+=dx;
    y+=dy;
    }
    
      public void atirar() {
        if(tiros.size()<6) {  
        tiros.add(new Tiro((int)x + width, (int)y + height / 2));
        }
    }
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {            
            atirar();
        }
        if (key == KeyEvent.VK_LEFT) {            
            dx = -0.5;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0.5;
        }

        if (key == KeyEvent.VK_UP) {
            dy = - 0.5;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0.5;
        }        
        
    }
    
public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
    
}
