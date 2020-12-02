/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Information {

    Scanner t = new Scanner(System.in);
    Validator val = new Validator();
    DB db = new DB();

//input doctor information
    public Doctor addInformation(ArrayList<Doctor> doctorInfor) throws FileNotFoundException, IOException {
        boolean check = false;
        Doctor dor = new Doctor();
        String code = null;
        do {
            System.out.print("Enter code: ");
            code = t.nextLine();
            check = false;
            if (!code.isEmpty()) {
                for (Doctor doctor : doctorInfor) {

                    if (code.equalsIgnoreCase(doctor.getCode())) {
                        //work if code not equal code in array list
                        System.out.println("Doctor code Code is duplicate");
                        check = true;
                    } //work if code not equal code in array list

                }

            } else {
                System.out.println("code is not empty");
                check = true;
            }

        } while (check);
        //input Name, Specialization,Availability
        dor.setCode(code);

        dor.setName(val.checkString("Enter Name: ", true));
        dor.setSpecialization(val.checkString("Enter Specialization: ", false));
        dor.setAvailability(val.checkAvailability("Enter Availability: "));

        return dor;
    }
//update infor base on code

    public ArrayList<Doctor> updateInformation(ArrayList<Doctor> doctorInfor) {
        boolean check;
        do {
            check = true;
            System.out.print("Enter code:");
            String code = t.nextLine();
            for (Doctor doctor : doctorInfor) {
                if (code.equalsIgnoreCase(doctor.getCode())) {//work if code enter exist in arraylist
                    check = false;
                    doctor.setName(val.checkString("Update Name: ", true));
                    doctor.setSpecialization(val.checkString("Update Specialization: ", false));
                    doctor.setAvailability(val.checkAvailability("Update Availability: "));
                    break;
                }
            }
            if (check) {
                System.out.println("Code not exist");
            }
        } while (check);
        db.writeAllToFile(doctorInfor);
        display(doctorInfor);
        return doctorInfor;
    }

    public ArrayList<Doctor> deleteDoctor(ArrayList<Doctor> doctorInfor) {
        boolean check;
        do {
            check = true;
            System.out.print("Enter code:");
            String code = t.nextLine();
            for (Doctor doctor : doctorInfor) {
                if (code.equalsIgnoreCase(doctor.getCode())) {
                    check = false;
                    doctorInfor.remove(doctor);
                    break;
                }
            }
            if (check) {
                System.out.println("Code not exist");
            }
        } while (check);
        db.writeAllToFile(doctorInfor);
        display(doctorInfor);
        return doctorInfor;

    }
//search doctor information

    public ArrayList<Doctor> searchDoctor(ArrayList<Doctor> doctorInfor) {
        ArrayList<Doctor> al = new ArrayList<>();
        boolean check;
        do {
            check = true;
            System.out.print("Enter text:");
            String text = t.nextLine();
            for (Doctor doctor : doctorInfor) {//if your text contain in string of array
                if ((doctor.getCode().contains(text)) || (doctor.getName().contains(text)) || (doctor.getSpecialization().contains(text))) {
                    check = false;
                    al.add(doctor);//add that doctoc information to new arraylist
                }
            }
        } while (check);
        System.out.println("-- -- -- -- - Result -- -- -- -- -- --");
        for (Doctor doctor : al) {
            System.out.println(doctor);
        }
        return doctorInfor;
    }
//display doctor information

    public void display(ArrayList<Doctor> doctorInfor) {
        System.out.println("-- -- -- -- - Doctor Information -- -- -- -- -- --");
        System.out.println("Code" + "       " + "Name" + "       " + "Specialization" + "       " + "Availability");
        for (Doctor doctor : doctorInfor) {
            System.out.println(doctor);

        }
    }
//add into Arraylist

    public void add(ArrayList<Doctor> doctorInfor) throws IOException {

        do {
            doctorInfor.add(addInformation(doctorInfor));

        } while (val.checkYN());
        db.writeAllToFile(doctorInfor);
        display(doctorInfor);
    }
}
