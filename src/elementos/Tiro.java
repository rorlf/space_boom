/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import br.com.br.area1.cg.MainFrameBase;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
 

/**
 *
 * @author Rorlf
 */
public class Tiro {
    
      private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private Image tiro;
    private int speed = 1;


    public Tiro(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed= speed;
        criarTiro();
    }
    
    public void criarTiro(){
        loadImage();    
        getImageDimensions();
        setVisible(true);

    }
    
      public void move() {
        
        x += speed;
        
        if (x > MainFrameBase.BOARD_WIDTH) {
            visible = false;
        }
         if (x < 0 ) {
            visible = false;
        }
    }
        protected void loadImage() {

          tiro = new ImageIcon(this.getClass().getResource("/imagens/tiro.png")).getImage();

    }
    
    protected void getImageDimensions() {

        width = tiro.getWidth(null);
        height = tiro.getHeight(null);
    }    

    public Image getImage() {
        return tiro;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
