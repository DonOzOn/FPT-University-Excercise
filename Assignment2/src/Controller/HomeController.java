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
import GUI.Update;
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
    Update update;
    AddController addController;
    SearchController searchController;
    ShowController showController;

    public HomeController(EmployeeManagement home) {
        this.home = home;
        control();
    }

    public void control() {
        search = new Search();
        add = new AddNew();
        update = new Update();
        home.setVisible(true);
        addController = new AddController(add);
        home.getBTAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                add.setVisible(true);
                //set default for text input
                add.getTF_ID().setText("");
                add.getTF_Name().setText("");
                add.getTF_DOB().setText("");
                add.getTF_Address().setText("");
                add.getTF_Email().setText("");
                add.getTF_Phone().setText("");
                add.getTA_PLofWork().setText("");
                add.setResizable(false);
                addController.setAdd(add);
            }
        });
        searchController = new SearchController(search);
        home.getBTSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search.setVisible(true);
                //set default for input and output search
                search.getTF_ID_Search().setText("");
                search.getTA_ShowAll().setText("");
                search.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                search.setResizable(false);
                searchController.setSearch(search);
            }
        });
        home.getBTShow().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                show = new Show();
                show.setVisible(true);
                show.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                show.setResizable(false);
                showController = new ShowController(show);

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
