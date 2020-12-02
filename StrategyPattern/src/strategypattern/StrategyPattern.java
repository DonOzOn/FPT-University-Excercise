/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypattern;

import object.Duck;
import object.FlyWithRocket;
import object.Mallardduck;
import object.ModelDuck;

/**
 *
 * @author skykn
 */
public class StrategyPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello");
//        Duck duck = new Mallardduck();
//        duck.display();
//        duck.performQuack();
//        duck.performFly();

        Duck duckModel = new ModelDuck();
        duckModel.performQuack();
        duckModel.performFly();
        duckModel.setFlyBehavior(new FlyWithRocket());
                duckModel.performFly();
    }

}
