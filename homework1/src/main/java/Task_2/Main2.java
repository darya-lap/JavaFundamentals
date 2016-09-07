package Task_2;

import java.util.Scanner;

import static Task_2.Epsilon.Eps;
import static Task_2.Function2.F2;

/**
 * Created by Дарья on 27.08.2016.
 */
public class Main2 {
    public static void main(String... args) {
        double eps = Eps();
        int i = 1;
        int k = 1;
        System.out.println("Если хотите залипнуть минут на пять и посмотреть на все элементы последовательности, то введите 1.\n" +
                "А если просто хотите узнать минимальный номер(что будет логичным решением), введите 2.");
        int w;
        Scanner in = new Scanner(System.in);
        w = in.nextInt();
        while (F2(i) > eps){
            if (w == 1) {
                System.out.print(F2(i)+" ");
                if (k == 5){
                    System.out.println();
                    k = 0;
                }
                k++;
            }
            i++;
        }
        System.out.println("\nНаименьший номер элемента последовательности: "+i);
    }

}
