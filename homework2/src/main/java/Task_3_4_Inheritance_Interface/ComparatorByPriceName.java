package Task_3_4_Inheritance_Interface;

import java.util.Comparator;

    class ComparatorByPriceName implements Comparator<Stationery> {

    @Override
    public int compare(Stationery s1, Stationery s2) {
        if (s1.price > s2.price) return 1;
        else {
            if (s1.price < s2.price) return -1;
            else {
                ComparatorByName comparator = new ComparatorByName();
                return (comparator.compare(s1,s2));
            }
        }
    }
}
