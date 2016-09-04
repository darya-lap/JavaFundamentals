package Task_4;

/**
 * Created by Дарья on 27.08.2016.
 */
public class Main4 {
    public static void main(String... args) {
        int n = 0;
        try{
            for (Object o: args) n++;
        }
        catch (Exception e){
        }
        finally{
            try{
                int j = n - 1;
                int sum = Integer.parseInt(args[0]) + Integer.parseInt(args[j]);
                j--;
                for (int i = 1; i < n / 2; i++){
                    if ((Integer.parseInt(args[i]) + Integer.parseInt(args[j])) > sum){
                        sum = Integer.parseInt(args[i]) + Integer.parseInt(args[j]);
                    }
                    j--;
                }
                System.out.println("Максимальная сумма :" + sum);
            }
            catch (NumberFormatException ex){
                System.out.println("Некорректный ввод данных");
            }
        }
    }
}
