/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.Search;
import generated.Employees;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Don OzOn
 */
public class SearchController {

    Search search;
    boolean found;

    public SearchController(Search search) {
        this.search = search;
        control();
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public void control() {
        search.getBTSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                found = false;
                String employeeID = search.getTF_ID_Search().getText();
                try {
                    JAXBContext context = JAXBContext.newInstance(Employees.class);
                    Unmarshaller unmarshaller = context.createUnmarshaller();
                    Employees employees = (Employees) unmarshaller.unmarshal(new File("Employee.xml"));
                    //check ID in list get from xml file
                    for (int i = 0; i < employees.getEmployee().size(); i++) {
                        if (employees.getEmployee().get(i).getEmployeeNo().equalsIgnoreCase(employeeID)) {
                            //print detail result of ID search
                            search.getTA_ShowAll().setText(employees.getEmployee().get(i).toString());
                            found = true;
                        }
                    }
                } catch (Exception ex) {
                }
                //show message when not found 
                if (found == false) {
                    search.getTA_ShowAll().setText("");
                    JOptionPane.showMessageDialog(null, "Employee not found!!!");

                }
            }
        });
        //button "Back" of "search" frame
        search.getBTBack().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search.dispose();
            }
        });
    }
}
