
package ultil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {

    Scanner t = new Scanner(System.in);

    public int checkIntRC(String mess, boolean check) {
        while (true) {
            try {
                System.out.print(mess);
                int num = Integer.parseInt(t.nextLine());
                if (check) {
                    if (num > 0) {
                        return num;
                    } else {
                        System.out.println("number must be >0");
                    }
                } else {
                    return num;
                }
            } catch (InputMismatchException e) {
                System.out.println("must be number");
            }
        }
    }
    public int checkChoose(String mess) {
     while(true){
            try {
                System.out.println(mess);
                 int num = Integer.parseInt(t.nextLine());
                if(num>4){
                    System.out.println("must <=4 !");
                }else if(num<=0){
                    System.out.println("must >0 !");
                }  else   {           
              return num;
                }
            } catch (Exception e) {
                System.out.println("must be number");
            }
        
     }
    }
}
    
    
   

    
    