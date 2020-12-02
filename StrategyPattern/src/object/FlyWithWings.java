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
public class FlyWithWings implements FlyBehavior {

    public FlyWithWings() {
    }

    @Override
    public void fly() {
        System.out.println("Fly with wing");
    }
    
}
