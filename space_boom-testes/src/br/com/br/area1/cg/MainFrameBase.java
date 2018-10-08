/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.br.area1.cg;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author oberdan
 */
public class MainFrameBase extends JFrame implements MouseMotionListener{
    public static int BOARD_WIDTH=1000, BOARD_HEIGHT=600;
    Cursor blankCursor = null;
    
    public MainFrameBase(){
        setTitle("Java 2D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new CanvasPanelBase());
        setSize(BOARD_WIDTH, BOARD_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        
        blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().createImage("nada.png"), new Point(0, 0), "blankCursor"); 
        addMouseMotionListener(this);
    } 
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                
                new MainFrameBase().setVisible(true);
            }
        });
    }

    
    @Override
    public void mouseDragged(MouseEvent e) {
        setCursor(blankCursor);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
                setCursor(blankCursor);

    }


}
