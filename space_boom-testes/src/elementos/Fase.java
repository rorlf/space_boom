/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import br.com.br.area1.cg.MainFrameBase;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Rorlf
 */
public class Fase {
    private int level;
    private int x=0;
    private boolean paused,flag,wait,gameover;
private int t,tempowait=0;
private int contador1,contador2,contador3,contador4;
  
    private List<Inimigo1> inimigos;
    
    private List<PowerUp> powerUps;


    public Fase(int level) {
        this.level = level;
        x=0;
        paused=false;
        flag=false;
        powerUps= new ArrayList<>();
                         inimigos = new ArrayList<>();
                         contador1=0 ;
                           contador2=0;
                           contador3=0;
                           contador4=0;
                         wait=true;
                         
             

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
    public void newPowerUp(double x, double y){
        Random random = new Random();
        
        if(random.nextInt(100)<=10){
    powerUps.add(new PowerUp(x,y,1));
        return;}
        
        if(random.nextInt(100)>=90){
    powerUps.add(new PowerUp(x,y,2));
    return;
        }
    }
    
    public void checarFase(){
    if( contador1==0 && contador2==0 && contador3==0 && contador4==0 ){
            wait=true;
            if(inimigos.isEmpty()){
             tempowait+=1;

            if(tempowait>1000){
                           level+=1;

           if(level<=10)
           setFases();
            }
    }
    }}
    
    public String stringFase(){
    if(wait==true && level>=0 && level<=10 && inimigos.isEmpty()){
        return "Fase "+String.valueOf(level+1);}
    
    return "";
    }
    
   
    
    public void povoarFase(){ 
        checarFase();
        if(wait==false){
        if(t>500){              
    
            
            inimigos.add(new Inimigo1(getlocalX(),getlocaly(),tipo())); 
                                    
        t=0;   
    }
              t++;}
  
    }
    private int tipo(){
        int c1=contador1;
           int c2=contador2;
               int c3=contador3;
                  int c4=contador4;
    if(c1>0||c2>0||c3>0||c4>0){
         Random random = new Random();

         while(c1==contador1 && c2==contador2 && c3==contador3 && c4==contador4){
                              int valor =random.nextInt(5);
 if(valor==1){
        if(c1>0){
        contador1-=1;
        return 1;
        }
        }
 if(valor==2){
        if(c2>0){
        contador2-=1;
        return 2;
        }
        }
 
    if(valor==3){
        if(c3>0){
        contador3-=1;
        return 1;
        }
        }
    
    if(valor==4){
        if(c4>0){
        contador4-=1;
        return 4;
        }
        }
    
    
         }
    }
    return 0;
    }
        private int getlocaly(){
     Random random = new Random();
          int divisao= MainFrameBase.BOARD_HEIGHT/80;
   
     int valor =random.nextInt(divisao);
     int localy=40;
     int contadory=0;
     while(localy<(MainFrameBase.BOARD_HEIGHT-160)){
      if(valor==contadory){
        return localy;
        }
      contadory++;
      localy+=80;
     }
       

        return localy;
    }
    private int getlocalX(){
     Random random = new Random();
                int valor =random.nextInt(5);

        if(valor==5){
        return MainFrameBase.BOARD_WIDTH+20;
        }
        if(valor==4){
        return MainFrameBase.BOARD_WIDTH+50;
        }
        if(valor==3){
        return MainFrameBase.BOARD_WIDTH+80;
        }
        if(valor==2){
        return MainFrameBase.BOARD_WIDTH+40;
        }
        return MainFrameBase.BOARD_WIDTH+100;
    }
    public List<Inimigo1> getInimigos(){
    return inimigos;
    }
    
     public List<PowerUp> getPowerUps(){
    return powerUps;
    }

    public boolean isPaused() {
        return paused;
    }

    public boolean isGameover() {
        return gameover;
    }
    
    
    
    public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            
            if (paused==false && key == KeyEvent.VK_ESCAPE && flag==false){
            paused=true;
            
            }
            if (paused==true && key == KeyEvent.VK_ESCAPE && flag==true ){
            paused=false;
            }
            
            
            
               if (gameover==false && key == KeyEvent.VK_ESCAPE && flag==false){
            gameover=true;
            
            }
            if (gameover==true && key == KeyEvent.VK_ENTER  ){
            gameover=false;
            }

    }
    
        
public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();
        if (paused==true && key == KeyEvent.VK_ESCAPE && flag==false){
            flag=true;            
            }
        
         if (paused==false && key == KeyEvent.VK_ESCAPE && flag==true){
            flag=false;            
            }
        
}





 private void setFases(){
    if(tempowait>500){
    if(level==1){
      contador1=10;
      contador2=0;
      contador3=0;
      contador4=0; 
    }
     if(level==2){
      contador1=0;
      contador2=10;
      contador3=0;
      contador4=0; 
    }
      if(level==3){
      contador1=25;
      contador2=20;
      contador3=10;
      contador4=0; 
    }
       if(level==4){
      contador1=30;
      contador2=25;
      contador3=20;
      contador4=0; 
    }
        if(level==5){
      contador1=35;
      contador2=35;
      contador3=35;
      contador4=0; 
    }
         if(level==6){
      contador1=40;
      contador2=35;
      contador3=35;
      contador4=0; 
    }
          if(level==7){
      contador1=60;
      contador2=50;
      contador3=35;
      contador4=0; 
    }
           if(level==8){
      contador1=20;
      contador2=30;
      contador3=20;
      contador4=10; 
    }
                      if(level==9){
      contador1=50;
      contador2=50;
      contador3=50;
      contador4=30; 
    }
                                 if(level==10){
      contador1=0;
      contador2=80;
      contador3=70;
      contador4=70; 
    }
    wait=false;
    tempowait=0;
    }}
}
