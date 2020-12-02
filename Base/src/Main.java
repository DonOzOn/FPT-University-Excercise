
public class Main {

    public static void main(String[] args) {
        Calculate cal = new Calculate();
        Validator val = new Validator();
        int choose;
        while (true) {
            System.out.println("1.Calculate Superlative Equation");
            System.out.println("2.Calculate Quadraric Equation");
            System.out.println("3.Exit");
            choose = val.checkChoose("Enter Your Choose:   ");
            switch (choose) {
                case 1:
                    cal.option1();
                    break;
                case 2:
                    cal.option2();
                    break;
                case 3:
                    break;
            }
        }
    }

}
