package Task_3_4_Inheritance_Interface;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Stationery>{

    @Override
    public int compare(Stationery s1, Stationery s2) {
        String str1 = s1.getClass().getSimpleName();
        String str2 = s2.getClass().getSimpleName();
        return str1.compareTo(str2);
    }

}