package Task_2;

/**
 * Created by Дарья on 27.08.2016.
 */
class Epsilon {
    public static double Eps(){
        double e1=2.0;
        double e = 1;
        while(e1!=1.0) {
            e=e/2;
            e1=e+1.0;
        }
        return e;
    }

}
