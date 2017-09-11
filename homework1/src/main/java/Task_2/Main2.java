package Task_2;

import java.util.Scanner;

public class Main2 {
    public static void main(String... args) {
        double eps = Eps();
        int i = 1;
        System.out.println("Данная программа берет каждый элемент, начиная с 1.\n" +
                "По формуле вычисляет значение а(i). Вычисления ведутся до тех пор, пока " +
                "не будет найдено то минимальное число, которое воспринимается машиной" +
                "как 0.\nЕсли хотите залипнуть минут на пять и посмотреть на все элементы последовательности, то введите 1.\n" +
                "А если просто хотите узнать минимальный номер(что будет логичным решением), введите любую другую цифру.");
        int w;
        Scanner in = new Scanner(System.in);
        w = in.nextInt();
        while (f(i) > eps){
            if (w == 1)
                System.out.println(f(i));
            i++;
        }
        System.out.println("\nНаименьший номер элемента последовательности: "+i);
    }

    private static double f(int n){
        return (1.0/(n + 1)/(n + 1));
    }

    private static double Eps(){
        double e1=2.0;
        double e = 1;
        while(e1!=1.0) {
            e=e/2;
            e1=e+1.0;
        }
        return e;
    }
}
