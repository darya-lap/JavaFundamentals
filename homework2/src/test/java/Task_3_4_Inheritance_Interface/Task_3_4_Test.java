package Task_3_4_Inheritance_Interface;

import org.junit.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import static junit.framework.TestCase.assertEquals;

public class Task_3_4_Test {
    Stationery bp = new Ballpen(100,"ErichKrause",3,"Flix");
    Stationery cbp = new ColorBallPen(120,"Nova", 2, "Flix", "red");
    Stationery fp = new FountainPen(300,"MarcoPolo", 1, "BlackInk");
    Stationery ccb = new CageCopybook(50,"Fenix", "blue", 50);
    Stationery lcb = new LineCopyBook(50,"Fenix", "blue", 100);
    Stationery p1 = new Pencil(50, "ErichKrause", "HB");
    Stationery cp = new ColorPencil(50, "ErichKrause", "HB", "yellow");
    Stationery p2 = new Pencil(50, "ErichKrause", "HB");

    @Test
    public void BegginerSetCreate(){
        BeginnerSet set = new BeginnerSet(bp,cbp,fp,ccb,lcb,p1,cp,p2);
        assertEquals(set.getStationery(0),bp);
        assertEquals(set.getStationery(1),cbp);
        assertEquals(set.getStationery(2),fp);
        assertEquals(set.getStationery(3),ccb);
        assertEquals(set.getStationery(4),lcb);
        assertEquals(set.getStationery(5),p1);
        assertEquals(set.getStationery(6),cp);
        assertEquals(set.getStationery(7),p2);
    }

    @Test
    public void CheckClassName(){
        String s =  bp.getClass().getSimpleName();
        System.out.println(s.charAt(0));
    }

    @Test
    public void CompareByPrice(){
        Comparator<Stationery> comp = new ComparatorByPrice();
        Set<Stationery> set = new TreeSet<>(comp);
        set.add(bp);
        set.add(cbp);
        set.add(fp);
        set.add(ccb);
        set.add(lcb);
        set.add(p1);
        set.add(cp);
        set.add(p2);
        System.out.println(set.toString());
    }

    @Test
    public void CompareByName(){
        Comparator<Stationery> comp = new ComparatorByName();
        Set<Stationery> set = new TreeSet<>(comp);
        set.add(bp);
        set.add(cbp);
        set.add(fp);
        set.add(ccb);
        set.add(lcb);
        set.add(p1);
        set.add(cp);
        set.add(p2);
        System.out.println(set.toString());

    }

    @Test
    public void CompareByPriceAndName(){
        Comparator<Stationery> comp = new ComparatorByPriceName();
        Set<Stationery> set = new TreeSet<>(comp);
        set.add(bp);
        set.add(cbp);
        set.add(fp);
        set.add(ccb);
        set.add(lcb);
        set.add(p1);
        set.add(cp);
        set.add(p2);
        System.out.println(set.toString());
    }

}
