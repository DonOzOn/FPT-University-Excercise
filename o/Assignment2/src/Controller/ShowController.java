/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.Show;
import GUI.Update;
import generated.Employees;
import generated.Employees.Employee;
import java.awt.Button;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.xml.bind.JAXBContext;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Don OzOn
 */
public class ShowController {

    XMLGregorianCalendar calendar;
    Show show;
    Update update;
    int pos = 0;
    Date date;
    int row = 0;

    public ShowController(Show show) {
        this.show = show;
        control();
    }

    public void control() {
        update = new Update();
        ValidateInput val = new ValidateInput();
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Employees employees = (Employees) unmarshaller.unmarshal(new File("Employee.xml"));
            DefaultTableModel model = new DefaultTableModel(new Object[]{"ID",
                "Name", "DOB",
                "Address", "Email",
                "Phone", "Place of work",},
                    0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };
            for (Employee employee : employees.getEmployee()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                GregorianCalendar gc = employee.getDob().toGregorianCalendar();
                String datestring = sdf.format(gc.getTime());
                model.addRow(new Object[]{employee.getEmployeeNo(), employee.getName(),
                    datestring, employee.getAddress(), employee.getEmail(), employee.getPhoneNo(),
                    employee.getPlaceOfWork()});
            }
            show.getTBShowAll().setModel(model);
            show.getTBShowAll().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            //delete in xml file and Jtable
            show.getBTDelete().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // check for selected row first
                    if (show.getTBShowAll().getSelectedRow() != -1) {
                        // remove selected row from the model
                        pos = show.getTBShowAll().getSelectedRow();
                        model.removeRow(show.getTBShowAll().getSelectedRow());
                        System.out.println("pos : " + pos);
                    }
                    employees.getEmployee().remove(pos);
                    try {
                        Marshaller marshaller = context.createMarshaller();
                        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                        marshaller.marshal(employees, new File("Employee.xml"));
                    } catch (Exception ez) {
                        ez.printStackTrace();
                    }
                }
            });
            show.getBTUpdate().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    row = 0;
                    if (show.getTBShowAll().getSelectedRow() == -1) {
                        JOptionPane.showMessageDialog(null, "Please select a employess to update!!!");
                    } else {
                        update.setVisible(true);
                        update.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        row = show.getTBShowAll().getSelectedRow();
                        update.getTF_ID().setText(show.getTBShowAll().getValueAt(row, 0).toString());
                        update.getTF_Name().setText(show.getTBShowAll().getValueAt(row, 1).toString());
                        update.getTF_DOB().setText(show.getTBShowAll().getValueAt(row, 2).toString());
                        update.getTF_Address().setText(show.getTBShowAll().getValueAt(row, 3).toString());
                        update.getTF_Email().setText(show.getTBShowAll().getValueAt(row, 4).toString());
                        update.getTF_Phone().setText(show.getTBShowAll().getValueAt(row, 5).toString());
                        update.getTA_PLofWork().setText(show.getTBShowAll().getValueAt(row, 6).toString());
                        update.getBTUpdate().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String name = val.checkName(update.getTF_Name().getText());
                                String dob = val.checkDob(update.getTF_DOB().getText());
                                String address = val.checkAddress(update.getTF_Address().getText());
                                String email = val.checkEmail(update.getTF_Email().getText());
                                String phone = val.checkPhone(update.getTF_Phone().getText());
                                String plOfWork = val.placeOfwork(update.getTA_PLofWork().getText());
                                try {
                                    //check name
                                    if (name != null) {
                                        JOptionPane.showMessageDialog(null, name);
                                    } else {
                                        //check dob
                                        Pattern DATE_PATTERN = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$");
                                        if (dob != null) {
                                            JOptionPane.showMessageDialog(null, dob);
                                        } else {
                                            if (DATE_PATTERN.matcher(update.getTF_DOB().getText()).matches()) {
                                                Date date = new SimpleDateFormat("dd-MM-yyyy").parse(update.getTF_DOB().getText());
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
                                                                //update in Jtable
                                                                model.setValueAt(update.getTF_ID().getText(), row, 0);
                                                                model.setValueAt(update.getTF_Name().getText(), row, 1);
                                                                model.setValueAt(update.getTF_DOB().getText(), row, 2);
                                                                model.setValueAt(update.getTF_Address().getText(), row, 3);
                                                                model.setValueAt(update.getTF_Email().getText(), row, 4);
                                                                model.setValueAt(update.getTF_Phone().getText(), row, 5);
                                                                model.setValueAt(update.getTA_PLofWork().getText(), row, 6);
                                                                //update in file xml
                                                                System.out.println("row : " + row);
                                                                employees.getEmployee().set(row, new Employee(
                                                                        update.getTF_Name().getText(),
                                                                        calendar, update.getTF_Address().getText(),
                                                                        update.getTF_Email().getText(),
                                                                        update.getTF_Phone().getText(),
                                                                        update.getTA_PLofWork().getText(),
                                                                        update.getTF_ID().getText()));
                                                                Marshaller marshaller = context.createMarshaller();
                                                                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                                                                marshaller.marshal(employees, new File("Employee.xml"));
                                                                update.dispose();
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "DOB format was wrong");
                                            }
                                        }
                                    }
                                } catch (Exception a) {
                                    a.printStackTrace();
                                }
                            }
                        });
                        update.getBTBack().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                update.dispose();
                            }
                        });
                    }
                }
            });
        } catch (Exception ex) {
        }

        show.getBTBack().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                show.dispose();
            }
        });
    }

}
