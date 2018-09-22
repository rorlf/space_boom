/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

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
    int contador,tempo;
    
    
    
     public Background() {
        estrelas = new ArrayList<>();
        atualizarEstrelas(5,1);
           contador=0;
           tempo=0;
            for(int estrelass=0;estrelass<100;estrelass++){
                                 Random random = new Random();
                 estrelas.add(new Estrela(random.nextInt(800), random.nextInt(600),5));
                 tempo=0;
         }


    }
    
      public List<Estrela> getEstrelas() {
        return estrelas;
    }

   
     
     public void atualizarEstrelas(int tamanho, int velocidade){
         tempo++;
         if(velocidade==1){
         if(tempo>80){
              for (Estrela estrela : estrelas) {
                     Random random = new Random();
                   estrela.setX(random.nextInt(800));
                   estrela.setY(random.nextInt(600));
                   tempo=0;
        }
         }
         }
         
          if(velocidade==2){
         if(tempo>50){
              for (Estrela estrela : estrelas) {
                     Random random = new Random();
                   estrela.setX(random.nextInt(800));
                   estrela.setY(random.nextInt(600));
                   tempo=0;
        }
         }
         }
         
         
         }
     
     }

