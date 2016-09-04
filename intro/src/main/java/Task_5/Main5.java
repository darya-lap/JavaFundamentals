package Task_5;

/**
 * Created by Дарья on 27.08.2016.
 */
public class Main5 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int column1 = 0;
        int column2 = n - 1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if ((j == column1) || (j == column2)){
                    System.out.print("1 ");
                }
                else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
            column1++;
            column2--;
        }

    }
}
