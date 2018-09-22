/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Rorlf
 */
public class Inimigo1 {
    
   private double x;
    private double y;
    private double contador=0,contadorFrente=0;
    private int andaPraCima=0,andaPraDireita=0;
    private int width;
    private int height;
    private int tipo;
    private int vida;
    private List<Tiro> tiros;
    int raioTrajetoria = 50, i =0 ;
    private double c_x ,c_y;
    private boolean visible;
    private Image inimigo;


    public Inimigo1(int x, int y, int tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        criarInimigo();
        
    }

  
    
    public void criarInimigo(){
            tiros = new ArrayList<>();
        loadImage();    
        getImageDimensions();
        setVisible(true);
        if (tipo==1){
        this.vida=1;
        }
         if (tipo==2){
        this.vida=1;
        }
          if (tipo==3){
        this.vida=3;
        }
           if (tipo==4){
        this.vida=5;
        criarTrajetoria();
        }

    }

  
    
      public void move() {
        if(tipo==1){
        x -= 0.1;
         if (x < 0) {
            visible = false;
        }
       }
       
         if (tipo==2){             
                  x -= 0.1;          
         if (x < 0) {
            visible = false;
        }
        }
         
         
         
         
          if (tipo==3){
          if(andaPraCima==1){
                  x -= 0.1;
                  y -= 0.1;
                  contador+=1;
             }
             
              if(andaPraCima==0 ){
                  x -= 0.1;
                  y += 0.1;
                  contador-=1;
             }
              
              if(contador<=-400){
              andaPraCima=1;
              }
                if(contador>=400){
              andaPraCima=0;
              }
         if (x < 0) {
            visible = false;
        }
        }
          
          
          
           if (tipo==4){
               
              
               
              i++;
              double  angulo = 2 * Math.PI / 180;
                x =  (raioTrajetoria * Math.cos(angulo * (i/10)) + c_x);
                y =  (raioTrajetoria * Math.sin(angulo * (i/10)) + c_y);
                atualizarTrajetoria();
                if (x < 0) {
            visible = false;
        }
        }
       
           
           
           
           
             if (tipo==5){
            if(andaPraCima==1 && andaPraDireita==0){
                  x -= 0.1;
                  y -= 0.1;
                  contador+=1;
                  contadorFrente += 1;
             }
             
              if(andaPraCima==0 && andaPraDireita==0){
                  x -= 0.1;
                  y += 0.1;
                  contador-=1;
                  contadorFrente += 1;

             }
              
                if(andaPraCima==1 && andaPraDireita==1){
                  x += 0.1;
                  y -= 0.1;
                  contador+=1;
                  contadorFrente -= 1;
             }
             
              if(andaPraCima==0 && andaPraDireita==1){
                  x += 0.1;
                  y += 0.1;
                  contador-=1;
                  contadorFrente -= 1;

             }
              
              if(contador<=-400){
              andaPraCima=1;
              }
                if(contador>=400){
              andaPraCima=0;
              }
                
                if(contadorFrente>=200){
              andaPraDireita=1;
              }
                if(contadorFrente<=-200){
              andaPraDireita=0;
              }
         if (x < 0) {
            visible = false;
        }
        }
        
    }
      
      public void criarTrajetoria(){
      
          c_x=x+50;
           c_y=y;
      }
      public void atualizarTrajetoria(){
      
          c_x-=0.05;
           
      }
      
       public void atirar() {
        if(tiros.size()<=2) {  
        tiros.add(new Tiro((int)x - width, (int)y + height / 2,-1));
        }
    }
       
        public List<Tiro> getTiros() {
        return tiros;
    }
      
      
        protected void loadImage() {
  if (tipo==1){
                  inimigo = new ImageIcon(this.getClass().getResource("/imagens/enemy1.png")).getImage();
        }
         if (tipo==2){
                  inimigo = new ImageIcon(this.getClass().getResource("/imagens/enemy2.png")).getImage();
        }
          if (tipo==3){
                  inimigo = new ImageIcon(this.getClass().getResource("/imagens/enemy3.png")).getImage();
        }
           if (tipo==4){
                  inimigo = new ImageIcon(this.getClass().getResource("/imagens/enemy4.png")).getImage();
        }

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
    
      public int getTipo() {
        return tipo;
    }
      
       public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    } 
      

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
    
     public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y+1, width, height-25);
    }
    
}
