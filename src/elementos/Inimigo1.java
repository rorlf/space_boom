/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Rorlf
 */
public class Inimigo1 {
    
   private double x;
    private double y;
    private int width;
    private int height;

  
    private boolean visible;
    private Image inimigo;


    public Inimigo1(int x, int y) {
        this.x = x;
        this.y = y;
        criarInimigo();
    }
    
    public void criarInimigo(){
        loadImage();    
        getImageDimensions();
        setVisible(true);

    }
    
      public void move() {
        
        x -= 0.1;
         if (x < 0) {
            visible = false;
        }
       
    }
      
      
        protected void loadImage() {

          inimigo = new ImageIcon(this.getClass().getResource("/imagens/enemy1.png")).getImage();

    }
    
    protected void getImageDimensions() {

        width = inimigo.getWidth(null);
        height = inimigo.getHeight(null);
    }    

    public Image getImage() {
        return inimigo;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
      public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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
    
}
