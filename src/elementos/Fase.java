/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rorlf
 */
public class Fase {
    private int level;
    private int x=0;
    private List<Inimigo1> inimigos;
   private final int[][] pos = {
        {2380, 29}, {2500, 59}, {1380, 89},
        {780, 109}, {580, 139}, {680, 239},
        {790, 259}, {760, 50}, {790, 150},
        {980, 209}, {560, 45}, {510, 70},
        {930, 159}, {590, 80}, {530, 60},
        {940, 59}, {990, 30}, {920, 200},
        {900, 259}, {660, 50}, {540, 90},
        {810, 220}, {860, 20}, {740, 180},
        {820, 128}, {490, 170}, {700, 30}
    };

    public Fase(int level) {
        this.level = level;
        x=0;
    }
    
    public void povoarFase(){ 
                 inimigos = new ArrayList<>();

        if(level==1){
        for (int[] p : pos) {        
    
            
            inimigos.add(new Inimigo1(p[0],p[1],4));                    

            
        }
    }
        
    }
    public List<Inimigo1> getInimigos(){
    return inimigos;
    }
    
}
