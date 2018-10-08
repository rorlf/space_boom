/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import br.com.br.area1.cg.MainFrameBase;
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
    private double dyP,dyM;
    private double dxP,dxM;

    private int width;
    private int height;
private Inimigo1 alvo[];
   private Sound somTiro, somMissil;
    private boolean visible;
    private List<Tiro> tiros;
        private List<Missil> misseis;
    private int limiteMissil;
    private int speed; 
    private int vida;

    
    private boolean turbo;
        private boolean invulneravel;

    private int contadorTurboOn;

    

  
    protected Image nave_image,nave_image_turbo;
    
    public Nave(int x, int y) {
        this.x = x;
        this.y = y;
        criarnave();
    }
    private void criarnave(){
    tiros = new ArrayList<>();
        misseis = new ArrayList<>();

    loadImage();    
    getImageDimensions();
      setVisible(true);
      setTurbo(false);
      setSpeed(1);
            setVida(3);
      contadorTurboOn=5000;
      limiteMissil=3;
      invulneravel=false;
                                somTiro = new Sound("src/sounds/Laser.wav");
                                 somMissil = new Sound("src/sounds/Missil.wav");


     
    
    }
    
      public List<Tiro> getTiros() {
        return tiros;
    }

    public List<Missil> getMisseis() {
        return misseis;
    }
    
    protected void getImageDimensions() {
if(turbo==false){
        width = nave_image.getWidth(null);
        height = nave_image.getHeight(null);
}else{
width = nave_image_turbo.getWidth(null);
        height = nave_image_turbo.getHeight(null);
}
    }

    protected void loadImage() {
        
        nave_image = new ImageIcon(this.getClass().getResource("/imagens/spaceshipt.png")).getImage();
        
        nave_image_turbo = new ImageIcon(this.getClass().getResource("/imagens/spaceship-boosted.png")).getImage();

        
    }

    public Image getImage() {
        if(turbo==false){
        return nave_image;
        }else{
                return nave_image_turbo;

        }
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

    public boolean isInvulneravel() {
        return invulneravel;
    }

    public void setInvulneravel(boolean invulneravel) {
        this.invulneravel = invulneravel;
    }
    
    

    public void setTurbo(boolean turbo) {
        this.turbo = turbo;
        getImageDimensions();

    }
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        
        this.vida = vida;
    }

    public int getLimiteMissil() {
        return limiteMissil;
    }

    public void setLimiteMissil(int limiteMissil) {
        this.limiteMissil = limiteMissil;
    }
    
     public int getContadorTurboOn() {
        return contadorTurboOn;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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
    
    public void atualizar(){
    	if(x>=0)
    		x+=dxM;
    	
    	if(x<=MainFrameBase.BOARD_WIDTH-53)
            x+=dxP;
    	if(y>=0)
    y+=dyM;
    	if(y>=MainFrameBase.BOARD_HEIGHT-20)
    	    y+=dyP;	
    	
    if(turbo==true){
    contadorTurboOn-=4;
    speed=2;
    }
    if(turbo==false){
        if(contadorTurboOn<5000)
            contadorTurboOn+=1;
             speed=1;
    }
    if(contadorTurboOn<0){
                setTurbo(false);

    }
    
    }
    
      public void atirar() {
        if(tiros.size()<4) {  
                                      somTiro.play();

        tiros.add(new Tiro((int)x + width, (int)y + height / 2,1));
        }
    }
      
         public void atirarMissil(Inimigo1 alvo) {
         if(limiteMissil>0){
                          somMissil.play();
        misseis.add(new Missil(x + width, y + height / 2,alvo));
         limiteMissil-=1;}
        
    }
         
         public void checarAlvo(){
         
         }
         
        
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {            
            atirar();

        }
        
        if (key == KeyEvent.VK_LEFT) {
          
            if(turbo==false)
            dxM = -0.5;
            else
                dxM = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
             if(turbo==false)
            dxP = 0.5;
             
             else
                dxP = 1;
             
        }

        if (key == KeyEvent.VK_UP) {
               if(turbo==false)
            dyM = -0.5;
            else
                dyM = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
               if(turbo==false)
            dyP = 0.5;
            else
                dyP = 1;
        }
        
    }
    
public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dxM = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dxP = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dyM = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dyP = 0;
        }
        if (key == KeyEvent.VK_A) {
            if(turbo==true){
            setTurbo(false);
            }
            else{
                        setTurbo(true);

            }
        }          
        
    }
    
}
