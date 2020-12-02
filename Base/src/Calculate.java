
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Calculate {

    Validator val = new Validator();

    public List<Float> calculateEquation(float a, float b) {
        List<Float> num = new ArrayList<Float>();
        float x = -b / a;
        System.out.println("Solution : " + x);
        num.add(x);
        num.add(a);
        num.add(b);
        System.out.print("Num Odd: ");
        for (int i = 0; i < num.size(); i++) {
            if (val.isOdd(num.get(i))) {
                System.out.print(num.get(i) + ",");
            }
        }
        System.out.println();
        System.out.print("Num Even: ");
        for (int i = 0; i < num.size(); i++) {
            if (!val.isOdd(num.get(i))) {
                System.out.print(num.get(i));
                 if(i<(num.size()-1)){
                    System.out.println(",");
                }
            }

        }
        System.out.println();
        System.out.print("Num is Perfect Square: ");
        for (int i = 0; i < num.size(); i++) {
            if (val.isPerfectSquare(num.get(i))) {

                System.out.print(num.get(i));
                 if(i<(num.size()-1)){
                    System.out.println(",");
                }
            }
        }
        return num;
    }

    public List<Float> calculateQuadraticEquation(float a, float b, float c) {
        List<Float> num = new ArrayList<Float>();
        float x1 = 0, x2 = 0;
        float delta = (float) (Math.pow(b, 2) - (4 * a * c));
        if (delta < 0) {
            System.out.println("No solution!");
        } else if (delta == 0) {
            x1 = x2 = -b / (2 * a);
            System.out.println(" x1 = " + x1 + " and " + " x2 = " + x2);
        } else if (delta > 0) {
            x1 = (float) (-b + Math.sqrt(delta) / (2 * a));
            x2 = (float) (-b - Math.sqrt(delta) / (2 * a));
            System.out.println(" x1 = " + x1 + " and " + " x2 = " + x2);
        }
        num.add(a);
        num.add(b);
        num.add(c);
        num.add(x1);
        num.add(x2);
        System.out.print("Num Odd: ");
        for (int i = 0; i < num.size(); i++) {
            if (val.isOdd(num.get(i))) {

                System.out.print(num.get(i) + ",");
            }
        }
        System.out.println();
        System.out.print("Num Even: ");
        for (int i = 0; i < num.size(); i++) {
            if (!val.isOdd(num.get(i))) {

                System.out.print(num.get(i));
                if(i<(num.size()-1)){
                    System.out.println(",");
                }
            }

        }
        System.out.println();
        System.out.print("Num is Perfect Square: ");
        for (int i = 0; i < num.size(); i++) {
            if (val.isPerfectSquare(num.get(i))) {
                System.out.print(num.get(i));
                  if(i<(num.size()-1)){
                    System.out.println(",");
                }
            }
        }
        return num;
    }

    public void option1() {
        float a = val.checkInput("Enter A: ");
        float b = val.checkInput("Enter B: ");
        calculateEquation(a, b);
        System.out.println();

    }

    public void option2() {
        float a;
        do {
            a = val.checkInput("Enter A: ");
        } while (a == 0);
        float b = val.checkInput("Enter B: ");
        float c = val.checkInput("Enter C: ");
        calculateQuadraticEquation(a, b, c);
        System.out.println();

    }
}
