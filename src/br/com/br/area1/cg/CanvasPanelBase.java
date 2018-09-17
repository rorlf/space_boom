/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.br.area1.cg;

import elementos.Nave;
import elementos.Tiro;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author oberdan
 */
public class CanvasPanelBase extends JPanel implements Runnable{
    private Nave nave;
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
        
        nave = new Nave(inicialx,inicialy);
        
    }

    private void update(double dt){
        atualizarNave();
        atualizarTiros();
        

         
    }

    private void draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(nave.getImage(), (int)nave.getX(),(int)nave.getY(), this);
        
               
        
         
        List<Tiro> tiros = nave.getTiros();

        for (Tiro tiro : tiros) {
            
            g2d.drawImage(tiro.getImage(), tiro.getX(),
                    tiro.getY(), this);
        }
        
    }
    
    private void atualizarNave(){
    nave.andar();
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
    }
    
        public class KeyboardAdapter extends KeyAdapter{
    
    
    public void keyReleased(KeyEvent e){
        key_states[e.getKeyCode()] = false;
        nave.keyReleased(e);
    }
    
    public void keyPressed(KeyEvent e){
        key_states[e.getKeyCode()] = true;
        nave.keyPressed(e);
    }
    
    
    
  
    

}
    
 }
