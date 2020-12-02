
import java.util.Scanner;

public class Validator {
    Scanner t=new Scanner(System.in);
    public float checkInput(String mess){
        while(true){
            try{
            System.out.print(mess);
            float num=Float.parseFloat(t.nextLine());
            return num;
            }catch(Exception e){
                System.out.println("Must a  number !");
            }
        }
    }
    public int checkChoose(String mess) {
     while(true){
            try {
                System.out.print(mess);
                 int num = Integer.parseInt(t.nextLine());
                if(num>4){
                    System.out.println("must <4 !");
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
    public boolean isOdd (float number){
        if(number%2!=0){
            return true;
        }else{
            return false;
        }
    }
    public boolean  isPerfectSquare(float number){
        float squareNum=(float) Math.sqrt(number);
         if(number==(Math.pow(squareNum, 2))){
             return true;
         }else{
             return false;
         }
    }
    
}
