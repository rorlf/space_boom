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
public class PowerUp {
      private double x;
    private double y;
    private int width;
    private int height;
    private boolean visible=false;
    private Image powerUP;
    private int tipo;

    public PowerUp(double x, double y,int tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        criarPowerUp();
    }
    
    
      public void criarPowerUp(){
        loadImage();    
        getImageDimensions();
        setVisible(true);
        

    }
protected void loadImage() {
if (tipo==1)
          powerUP = new ImageIcon(this.getClass().getResource("/imagens/gui_missile.png")).getImage();
if (tipo==2)
          powerUP = new ImageIcon(this.getClass().getResource("/imagens/heart.png")).getImage();
    }

protected void getImageDimensions() {

        width = powerUP.getWidth(null);
        height = powerUP.getHeight(null);
    }

  public void move() {
        
        x -= 0.05;
         if (x < 0) {
            visible = false;
        }
       
  }

  public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, width, height);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Image getImage() {
        return powerUP;
    }

   
}
