/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.AddNew;
import GUI.EmployeeManagement;
import GUI.Search;
import GUI.Show;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Don OzOn
 */
public class HomeController {

    EmployeeManagement home;
    AddNew add;
    Show show;
    Search search;

    public HomeController(EmployeeManagement home) {
        this.home = home;
        control();
    }

    public void control() {
        show = new Show();
        search = new Search();
        add = new AddNew();
        home.setVisible(true);
        home.getBTAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add.setVisible(true);
                add.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                add.getTF_ID().setText("");
                add.getTF_Name().setText("");
                add.getTF_DOB().setText("");
                add.getTF_Address().setText("");
                add.getTF_Email().setText("");
                add.getTF_Phone().setText("");
                add.getTA_PLofWork().setText("");
                AddController addController = new AddController(add);
            }
        });
        home.getBTSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search.setVisible(true);
                search.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                SearchController searchController = new SearchController(search);
            }
        });
        home.getBTShow().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                show.setVisible(true);
                show.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ShowController showController = new ShowController(show);
            }
        });
        home.getBTExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
