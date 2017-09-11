package Task_4;

import java.util.ArrayList;

/**
 * Created by Дарья on 27.08.2016.
 * Программа в качестве аргумента принимает набор действительных чисел
 *
 */
public class Main4 {
    public static void main(String... args) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n = 0;
        try{
            for (Object o: args){
                arr.add(Integer.parseInt(o.toString()));
                n++;
            }
            if (args.length == 0){
                System.out.println("Данные отсутствуют");
            }
            else{
                int j = n - 1;
                int sum = arr.get(0) + arr.get(j);
                j--;
                for (int i = 1; i < n / 2; i++){
                    if (arr.get(i) + arr.get(j) > sum){
                        sum = arr.get(i) + arr.get(j);
                    }
                    j--;
                }
                System.out.println("Максимальная сумма :" + sum);
            }
        }
        catch (NumberFormatException e){
            System.out.println("Некорректный ввод данных.");
        }
    }
}
