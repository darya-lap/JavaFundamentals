package Task_3;

import static java.lang.StrictMath.tanh;

/**
 * Created by Дарья on 26.08.2016.
 */
class Function3 {
    private static double x;

    public static double F3(double x){
        Function3.x = x;
        return tanh(2 * x) - 3;
    }
}
