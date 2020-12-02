/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import generated.Employees;
import generated.Employees.Employee;
import java.io.File;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Don OzOn
 */
public class ValidateInput {
    //check id
    public String checkID(String id) {
        String s = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Employees employees = (Employees) unmarshaller.unmarshal(new File("Employee.xml"));

            if (id == null || id.equals("") || id.isEmpty()) {
                s = "Please enter ID!!";
            } else {
                for (Employee emp : employees.getEmployee()) {
                    if (id.equalsIgnoreCase(emp.getEmployeeNo())) {
                        s = "ID is existed!!";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }
//check name

    public String checkName(String name) {
        String s = null;
        if (name == null || name.equals("") || name.isEmpty()) {
            int a = 1;
            s = "Please enter name!!";
        }
        return s;
    }
//check Dob

    public String checkDob(String date) {
        String mess = null;
        if (date == null || date.equals("") || date.isEmpty()) {
            mess = "Please enter date!!";
        }
        return mess;
    }
//check address

    public String checkAddress(String address) {
        String mess = null;
        if (address == null || address.equals("") || address.isEmpty()) {
            mess = "Please enter address!!";
        }
        return mess;
    }
//check mail

    static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public String checkEmail(String email) {
        String mess = null;
        if (email == null || email.equals("") || email.isEmpty()) {
            mess = "Please enter email!!";
        } else {
            if (!isValid(email)) {
                mess = "Please check email format!!";
            }
        }
        return mess;
    }

    //check phone
    //09123456781123 and 01634305551 01934305551 01834305551 01734305551
    static boolean isValidPhone(String phone) {
        String pattern = "(09|01[2|6|8|9]|03|07|05|02)+([0-9]{8})\\b";
        return phone.matches(pattern);
    }

    public String checkPhone(String phone) {
        String mess = null;
        if (phone == null || phone.equals("") || phone.isEmpty()) {
            mess = "Please enter phone!!";
        } else {
            if (!isValidPhone(phone)) {
                mess = "Please check your phone number!!";
            }
        }
        return mess;
    }

    //check placeOfwork
    public String placeOfwork(String pLOfwork) {
        String mess = null;
        if (pLOfwork == null || pLOfwork.equals("") || pLOfwork.isEmpty()) {
            mess = "Please enter place of work!!";
        }
        return mess;
    }
}
