/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author skykn
 */
public class Quack implements QuackBehavior {

    public Quack() {
    }

    @Override
    public void quack() {
        System.out.println("quack quack");
    }
    
}
