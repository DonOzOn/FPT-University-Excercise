/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

/**
 *
 * @author Don OzOn
 */
public class matrix {
   private int rowa;
   private int cola;
    private int rowb;
   private int colb;
    public matrix(){
        
    }

    public matrix(int rowa, int cola,int rowb, int colb) {
        this.rowa = rowa;
        this.cola = cola;
      this.rowa = rowb;
        this.cola = colb;
    }

    public int getRowa() {
        return rowa;
    }

    public void setRowa(int rowa) {
        this.rowa = rowa;
    }

    public int getCola() {
        return cola;
    }

    public void setCola(int cola) {
        this.cola = cola;
    }
 public int getRowb() {
        return rowb;
    }

    public void setRowb(int rowb) {
        this.rowb = rowb;
    }

    public int getColb() {
        return colb;
    }

    public void setColb(int colb) {
        this.colb = colb;
    }
}
    
