/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import br.com.br.area1.cg.MainFrameBase;
import java.awt.Image;
import java.awt.Rectangle;
import static java.lang.Math.atan2;
import javax.swing.ImageIcon;

/**
 *
 * @author Rorlf
 */
public class Missil {
    
    private double x;
    private double y;
    private int width;
    private int height;
    private boolean visible=false;
    private Image missil;
    private int speed = 1;
    private Inimigo1 alvo;
                private int t = 0;


    public Missil(double x, double y,Inimigo1 alvo) {
        this.x = x;
        this.y = y;
         criarMissil();
         this.alvo =alvo;

    }
    
     public void criarMissil(){
        loadImage();    
        getImageDimensions();
        setVisible(true);
        

    }
    
           protected void loadImage() {

          missil = new ImageIcon(this.getClass().getResource("/imagens/nuclear.png")).getImage();

    }
           
           
              public void move() {
                  t++;
        x = x +speed*Math.cos(calcularAngulo())*(t/150);
        y = y +speed*Math.sin(calcularAngulo())*(t/150);

      
    }
    
    protected void getImageDimensions() {

        width = missil.getWidth(null);
        height = missil.getHeight(null);
    }

    
    public double calcularAngulo(){
      double angulo;
      angulo= atan2(alvo.getY()-y,alvo.getX()-x);
    return angulo;
    }
    public Inimigo1 getAlvo() {
        return alvo;
    }

    public void setAlvo(Inimigo1 alvo) {
        this.alvo = alvo;
    }
    
    

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Image getImage() {
        return missil;
    }
    
      public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, width, height);
    }
    
    
    
    
    
}
