package Controller;

import GUI.EmployeeManagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Don OzOn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        EmployeeManagement home = new EmployeeManagement();
        // TODO code application logic here
        HomeController homes = new HomeController(home);
    }
    
}
