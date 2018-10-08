/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

/**
 *
 * @author Rorlf
 */
public class Estrela {
    private int x;
        private int y;
        private int tamanho;

    public Estrela(int x, int y, int tamanho) {
        this.x = x;
        this.y = y;
                this.tamanho = tamanho;

    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    
    
}
