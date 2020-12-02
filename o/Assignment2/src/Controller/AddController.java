/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.AddNew;
import GUI.EmployeeManagement;
import generated.Employees;
import generated.Employees.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Don OzOn
 */
public class AddController {

    EmployeeManagement home;
    AddNew add;
    Date date;
    XMLGregorianCalendar calendar;
    int count = 0;

    public AddController(AddNew add) {
        this.add = add;
        control();
    }

    public void control() {
        ValidateInput val = new ValidateInput();
        home = new EmployeeManagement();
        add.getBTAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                System.out.println("count " + count);
                String name = val.checkName(add.getTF_Name().getText());
                String id = val.checkID(add.getTF_ID().getText());
                String dob = val.checkDob(add.getTF_DOB().getText());
                String address = val.checkAddress(add.getTF_Address().getText());
                String email = val.checkEmail(add.getTF_Email().getText());
                String phone = val.checkPhone(add.getTF_Phone().getText());
                String plOfWork = val.placeOfwork(add.getTA_PLofWork().getText());
                try {
                    JAXBContext context = JAXBContext.newInstance(Employees.class);
                    Unmarshaller unmarshaller = context.createUnmarshaller();
                    Employees employees = (Employees) unmarshaller.unmarshal(new File("Employee.xml"));
                    //check ID
                    if (id != null) {
                        JOptionPane.showMessageDialog(null, id);
                    } else {
                        //check name
                        if (name != null) {
                            JOptionPane.showMessageDialog(null, name);
                        } else {
                            //check dob
                            Pattern DATE_PATTERN = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$");
                            if (dob != null) {
                                JOptionPane.showMessageDialog(null, dob);
                            } else {
                                if (DATE_PATTERN.matcher(add.getTF_DOB().getText()).matches()) {
                                    Date date = new SimpleDateFormat("dd-MM-yyyy").parse(add.getTF_DOB().getText());
                                    GregorianCalendar gregory = new GregorianCalendar();
                                    gregory.setTime(date);
                                    calendar = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
                                            gregory.get(Calendar.YEAR), gregory.get(Calendar.MONTH) + 1,
                                            gregory.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
                                    //check address
                                    if (address != null) {
                                        JOptionPane.showMessageDialog(null, address);
                                    } else {
                                        //check email
                                        if (email != null) {
                                            JOptionPane.showMessageDialog(null, email);
                                        } else {
                                            System.out.println("phone : " + phone);
                                            //check phone
                                            if (phone != null) {
                                                JOptionPane.showMessageDialog(null, phone);
                                            } else {
                                                //check place of work
                                                if (plOfWork != null) {
                                                    JOptionPane.showMessageDialog(null, plOfWork);
                                                } else {
                                                    Employee em = new Employee(add.getTF_Name().getText(), calendar, add.getTF_Address().getText(),
                                                            add.getTF_Email().getText(), add.getTF_Phone().getText(),
                                                            add.getTA_PLofWork().getText(), add.getTF_ID().getText());
                                                    employees.getEmployee().add(em);
                                                    for (Employee emp : employees.getEmployee()) {
                                                        System.out.println(emp);
                                                    }
                                                    Marshaller marshaller = context.createMarshaller();
                                                    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                                                    marshaller.marshal(employees, new File("Employee.xml"));
                                                    JOptionPane.showMessageDialog(null, "Add successfull");
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "DOB format was wrong");
                                }
                            }
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add.getBTBack().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add.dispose();
            }
        });
    }
}
