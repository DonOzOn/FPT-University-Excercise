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
public class FlyNoWay implements FlyBehavior {

    public FlyNoWay() {
    }

    @Override
    public void fly() {
        System.out.println("Cant fly");
    }
    
}
