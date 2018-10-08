/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import br.com.br.area1.cg.MainFrameBase;
import java.awt.Graphics2D;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Rorlf
 */
public class Background {
    private List<Estrela> estrelas;
    int contador,tempo,quantia;
    
    
    
     public Background() {
        estrelas = new ArrayList<>();
           contador=0;
           tempo=0;
           quantia = (MainFrameBase.BOARD_WIDTH+MainFrameBase.BOARD_HEIGHT)/10;
            for(int estrelass=0;estrelass<quantia;estrelass++){
                                 Random random = new Random();
                 estrelas.add(new Estrela(random.nextInt(MainFrameBase.BOARD_WIDTH), random.nextInt(MainFrameBase.BOARD_HEIGHT),5));
                 tempo=0;
         }


    }
    
      public List<Estrela> getEstrelas() {
        return estrelas;
    }

   
     
     public void atualizarEstrelas(int tamanho, int velocidade){
         tempo++;
         if(velocidade==1){
         if(tempo>180){
              for (Estrela estrela : estrelas) {
                     Random random = new Random();
                   estrela.setX(random.nextInt(MainFrameBase.BOARD_WIDTH));
                   estrela.setY(random.nextInt(MainFrameBase.BOARD_HEIGHT));
                   tempo=0;
        }
         }
         }
         
          if(velocidade==2){
         if(tempo>50){
              for (Estrela estrela : estrelas) {
                     Random random = new Random();
                   estrela.setX(random.nextInt(MainFrameBase.BOARD_WIDTH));
                   estrela.setY(random.nextInt(MainFrameBase.BOARD_HEIGHT));
                   tempo=0;
        }
         }
         }
          
              if(velocidade==3){
         if(tempo>30){
              for (Estrela estrela : estrelas) {
                     Random random = new Random();
                    estrela.setX(random.nextInt(MainFrameBase.BOARD_WIDTH));
                   estrela.setY(random.nextInt(MainFrameBase.BOARD_HEIGHT));
                   tempo=0;
        }
         }
         }
              
                  if(velocidade==4){
         if(tempo>10){
              for (Estrela estrela : estrelas) {
                     Random random = new Random();
                    estrela.setX(random.nextInt(MainFrameBase.BOARD_WIDTH));
                   estrela.setY(random.nextInt(MainFrameBase.BOARD_HEIGHT));
                   tempo=0;
        }
         }
         }
         
         
         }
     
     }

