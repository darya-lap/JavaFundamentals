package Task_2;


/**
 * Created by Дарья on 27.08.2016.
 */
class Function2 {
private static double x;
    public static double F2(int n){
        Function2.x = n;
        Function2.x += 1;
        Function2.x *= Function2.x;
        Function2.x = 1 / Function2.x;
        return Function2.x;
    }
}
