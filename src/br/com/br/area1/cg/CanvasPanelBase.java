/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.br.area1.cg;

import elementos.Background;
import elementos.Estrela;
import elementos.Fase;
import elementos.Inimigo1;
import elementos.Missil;
import elementos.Nave;
import elementos.Tiro;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author oberdan
 */
public class CanvasPanelBase extends JPanel implements Runnable{
    private Nave nave;
    private Fase fase;
    private Missil missil;
    private Background background;
    private int score,flag=0,contInvul=0;
    private boolean gameover;
        private Image turbo,vida;
        
        

    private int inicialx=200 ,inicialy=200;
       private boolean[] key_states = new boolean[256];
       double px=280;
        
    public CanvasPanelBase(){
        setDoubleBuffered(true);
        setFocusable(true);
        load();
        new Thread(this).start();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    
    @Override
    public void run(){
        double btime, dtime = 0;
        btime = System.currentTimeMillis();
        while(true){
            update(dtime/1000);
            repaint();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            dtime = (System.currentTimeMillis() - btime);
            btime = System.currentTimeMillis();
        }
    }
    
    private void load(){
        addKeyListener(new KeyboardAdapter());
        setBackground(Color.BLACK);
        gameover=false;
        nave = new Nave(inicialx,inicialy);
        background = new Background();
        fase = new Fase(1);
                atualizarFase();
                
         turbo = new ImageIcon(this.getClass().getResource("/imagens/turbo.png")).getImage();
          vida = new ImageIcon(this.getClass().getResource("/imagens/gui_spaceship.png")).getImage();



        
    }

    private void update(double dt){
        if(gameover==false){
        atualizarNave();
        atualizarTiros();
        atualizarInimigos();
        checarColisao();
        checarInvulnerabilidade();
        background.atualizarEstrelas(5,nave.getSpeed());
        

        }
        
       
         
    }

    private void draw(Graphics g){
                Graphics2D g2d = (Graphics2D)g;
                
                
 
                List<Estrela> estrelas = background.getEstrelas();
                
                for (Estrela estrela : estrelas) {
            g.setColor(Color.white);
            g.fillOval(estrela.getX(), estrela.getY(), estrela.getTamanho(), estrela.getTamanho());
        }
        
         g2d.drawImage(turbo, 100,520,nave.getContadorTurboOn()/10,25, this);
         
         if(nave.getVida()>=1){
             g2d.drawImage(vida, 20,20,this);
             if (nave.getVida()>=2)
             g2d.drawImage(vida, 55,20,this);
              if (nave.getVida()>=3)
             g2d.drawImage(vida, 90,20,this);
         }
                 
        List<Tiro> tiros = nave.getTiros();

        for (Tiro tiro : tiros) {
            
            g2d.drawImage(tiro.getImage(), tiro.getX(),
                    tiro.getY(), this);
        }
        
                List<Missil> misseis = nave.getMisseis();
             for (Missil missil : misseis) {
            
            g2d.drawImage(missil.getImage(), (int)missil.getX(),
                    (int)missil.getY(), this);
        }
        
        
        
        
        
         List<Inimigo1> inimigos = fase.getInimigos();

        for (Inimigo1 inimigo : inimigos) {            
            g2d.drawImage(inimigo.getImage(), (int)inimigo.getX(),
                    (int)inimigo.getY(),inimigo.getWidth()-25,inimigo.getHeight()-25, this);
            
            
            tiros = inimigo.getTiros();
            for (Tiro tiro : tiros) {
            
            g2d.drawImage(tiro.getImage(), tiro.getX(),
                    tiro.getY(), this);        }
             
        }
      
        
        
        
                     
            Font myFont = new Font ("Arial", 1, 20); 
             g2d.setColor(Color.white);
            g2d.setFont(myFont);           
            g2d.drawString(String.valueOf(score), 350, 30);
            
             if(nave.isVisible() && !nave.isInvulneravel()){
        g2d.drawImage(nave.getImage(), (int)nave.getX(),(int)nave.getY(), this);
        }
             
                 if(nave.isVisible() && nave.isInvulneravel()&& contInvul%5==0 ){
        g2d.drawImage(nave.getImage(), (int)nave.getX(),(int)nave.getY(), this);
        }
        
        
         if(gameover == true){
         Font gameover = new Font ("Arial", 1, 72);
                 g2d.setColor(Color.pink);

         g2d.setFont(gameover);
        g2d.drawString("GAME OVER", 195, 250);
        
        }
    }
    
    private void atualizarNave(){
        if (nave.isVisible()) {

                nave.atualizar();
            } else {

            }
    if(nave.getVida()<=0){
    gameover=true;
    }
    }

    private void atualizarTiros() {
        List<Tiro> tiros = nave.getTiros();

        for (int i = 0; i < tiros.size(); i++) {

            Tiro tiro = tiros.get(i);

            if (tiro.isVisible()) {

                tiro.move();
            } else {

                tiros.remove(i);
            }
        }
        
           List<Inimigo1> inimigos = fase.getInimigos();

       
       for (Inimigo1 inimigo : inimigos) {

        tiros = inimigo.getTiros();

                 for (int i = 0; i < tiros.size(); i++) {

            Tiro tiro = tiros.get(i);

            if (tiro.isVisible()) {

                tiro.move();
            } else {

                tiros.remove(i);
            }
        }     
            }
       
               List<Missil> misseis = nave.getMisseis();

           for (int i = 0; i < misseis.size(); i++) {

            Missil missil = misseis.get(i);
            
            
            if (missil.isVisible()) {
                if(missil.getAlvo().isVisible()==false){
                missil.setAlvo(inimigoPertoMissil(missil));
                }
                missil.move();
            } else {

                misseis.remove(i);
            }
        }

    }

    private void atualizarFase() {
        fase.povoarFase();
    }

    private void atualizarInimigos() {
           List<Inimigo1> inimigos = fase.getInimigos();

        for (int i = 0; i < inimigos.size(); i++) {

            Inimigo1 inimigo = inimigos.get(i);

            if (inimigo.isVisible()) {

                inimigo.move();
                
                if(inimigo.getX()<MainFrameBase.BOARD_WIDTH && (inimigo.getTipo()==2 ||inimigo.getTipo()==4 )){
                double chanceDeTiro = Math.random() * 100;
                if(chanceDeTiro<=0.01){
                inimigo.atirar();
                }
                }
                
            } else {
                
                inimigos.remove(i);
                
            }
        }
        
    }

    private void checarColisao() {
            Rectangle r3 = nave.getBounds();

       List<Inimigo1> inimigos = fase.getInimigos();

       
       for (Inimigo1 inimigo : inimigos) {

                Rectangle r2 = inimigo.getBounds();

                if (r3.intersects(r2)) {
                    if(!nave.isInvulneravel()){
                    nave.setVida(nave.getVida()-1);
                    if(nave.getVida()>0){
                    nave.setX(inicialx);
                     nave.setY(inicialy);
                                          nave.setInvulneravel(true);

                    }
                }}
                List<Tiro> tiros = inimigo.getTiros();
                for (Tiro tiro : tiros){
                Rectangle r4 = tiro.getBounds();
                if (r4.intersects(r3)) {
                    if(!nave.isInvulneravel()){
                   nave.setVida(nave.getVida()-1);
                                       if(nave.getVida()>0){
                    nave.setX(inicialx);
                     nave.setY(inicialy);
                     nave.setInvulneravel(true);
                                       }}
                                       
                                       

                }
                }
            }
       
      List<Tiro> tiros = nave.getTiros();

        for (Tiro tiro : tiros) {

            Rectangle r1 = tiro.getBounds();

            for (Inimigo1 inimigo : inimigos) {

                Rectangle r2 = inimigo.getBounds();

                if (r1.intersects(r2)) {
                    inimigo.setVida(inimigo.getVida()-1);
                    tiro.setVisible(false);
                    if(inimigo.getVida()<=0){
                    inimigo.setVisible(false);
                    int tipoInimigo = inimigo.getTipo();
                if (tipoInimigo ==1){
                score+=10;
                }
                if (tipoInimigo ==2){
                score+=50;
                }
                 if (tipoInimigo ==3){
                score+=100;
                }
                  if (tipoInimigo ==4){
                score+=200;
                }
                    }
                }
            }
        }
        
        
        
        
        
        
          List<Missil> misseis = nave.getMisseis();

        for (Missil missil : misseis) {

            Rectangle r1 = missil.getBounds();

            for (Inimigo1 inimigo : inimigos) {

                Rectangle r2 = inimigo.getBounds();

                if (r1.intersects(r2)) {
                    inimigo.setVida(inimigo.getVida()-5);
                    missil.setVisible(false);
                    if(inimigo.getVida()<=0){
                    inimigo.setVisible(false);
                    int tipoInimigo = inimigo.getTipo();
                if (tipoInimigo ==1){
                score+=10;
                }
                if (tipoInimigo ==2){
                score+=50;
                }
                 if (tipoInimigo ==3){
                score+=100;
                }
                  if (tipoInimigo ==4){
                score+=200;
                }
                    }
                }
            }
        }
        
        
    }
    
    private Inimigo1 inimigoPerto(){
         List<Inimigo1> inimigos = fase.getInimigos();
double distancia=99999999;
Inimigo1 escolhido = null;

        for (int i = 0; i < inimigos.size(); i++) {

            Inimigo1 inimigo = inimigos.get(i);
            if(Math.sqrt(Math.pow(inimigo.getX() - nave.getX(), 2) + Math.pow(inimigo.getY() - nave.getY(), 2))<distancia){
                distancia=Math.sqrt(Math.pow(inimigo.getX() - nave.getX(), 2) + Math.pow(inimigo.getY() - nave.getY(), 2));
                escolhido=inimigo;
            }            
        }
return escolhido;
    }
    
       private Inimigo1 inimigoPertoMissil(Missil missil){
         List<Inimigo1> inimigos = fase.getInimigos();
double distancia=99999999;
Inimigo1 escolhido = null;

        for (int i = 0; i < inimigos.size(); i++) {

            Inimigo1 inimigo = inimigos.get(i);
            if(Math.sqrt(Math.pow(inimigo.getX() - missil.getX(), 2) + Math.pow(inimigo.getY() - missil.getY(), 2))<distancia){
                distancia=Math.sqrt(Math.pow(inimigo.getX() - missil.getX(), 2) + Math.pow(inimigo.getY() - missil.getY(), 2));
                escolhido=inimigo;
            }            
        }
return escolhido;
    }
       
       
       
       
       public void checarInvulnerabilidade(){
       if(nave.isInvulneravel()){
       contInvul++;
       if(contInvul>800){
       nave.setInvulneravel(false);
       contInvul=0;
       }
       }
       }
    
        public class KeyboardAdapter extends KeyAdapter{
    
    
    public void keyReleased(KeyEvent e){
        key_states[e.getKeyCode()] = true;
                if(gameover==false){
        nave.keyReleased(e);
                }
    }
    
    public void keyPressed(KeyEvent e){
        key_states[e.getKeyCode()] = true;
                if(gameover==false){
        nave.keyPressed(e);
                if (key_states[KeyEvent.VK_Z]){
                nave.atirarMissil(inimigoPerto());
                }
        }
        if(gameover==true){
        if (key_states[KeyEvent.VK_ENTER]){
            nave = new Nave(inicialx,inicialy);
                            atualizarFase();
                            gameover=false;
                            

            }
        
      
        
        }
    }
    
    
    
  
    

}
    
 }
