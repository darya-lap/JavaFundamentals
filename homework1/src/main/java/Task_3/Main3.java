package Task_3;

import static Task_3.Function3.F3;

/**
 *
 */
public class Main3 {
    public static void main(String[] args) {
        try {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double h = Double.parseDouble(args[2]);
            if (b < a) {
                double q = a;
                a = b;
                b = q;
            }
            double x = a;
            System.out.println("Интервал: [" + a + ", " + b + "]");
            System.out.println("Шаг: " + h);
            System.out.println("    x    |    F    ");
            System.out.println("---------|---------");
            do {
                System.out.printf("%6f", x);
                System.out.printf(" |");
                System.out.printf("%6f", F3(x));
                System.out.printf("\n---------|---------\n");
                x += h;
            } while (x < b);
            System.out.printf("%6f", b);
            System.out.printf(" |");
            System.out.printf("%6f", F3(b));
        }
        catch (Exception e){
            System.out.println("Некорректные данные\n");
        }
    }
}
