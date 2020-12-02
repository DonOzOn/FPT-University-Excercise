package doctor;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {

    //load data to list
    public ArrayList<Doctor> loadToList(  ArrayList<Doctor> list) {
        list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("doctor.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] tmp = line.split("=");
                System.out.println(tmp[0] + " " + tmp[1] + " " + tmp[2] + " " + tmp[3]);
                //add to list doctor
                Doctor doc = new Doctor(tmp[0], tmp[1], tmp[2], Integer.parseInt(tmp[3]));
                list.add(doc);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    //write data to file
    public void writeAllToFile(ArrayList<Doctor> list) {
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"));
            for (Doctor doctor : list) {
                bw.write(doctor.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
