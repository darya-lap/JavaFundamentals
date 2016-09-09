package Task_2_Desktop;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StationaryTest {

    @Test
    public void HowMuchStationery(){
        Stationery st1 = new Stationery(200, "pen");
        Stationery st2 = new Stationery(100, "pencil");
        Stationery st3 = new Stationery(60, "eraser");
        Worker w = new Worker("Molly", st1, st2, st3);
        assertEquals(w.getIndex(), 3);
    }

    @Test
    public  void GetListOfWorkers(){
        Stationery pen = new Stationery(100,"pen");
        Worker w1 = new Worker("Tommy",pen);
        Worker w2 = new Worker("Bill");
        Worker w3 = new Worker("Molly");
        Worker w4 = new Worker("Sam");
        ListOfWorkers l1 = new ListOfWorkers(w1, w2, w3, w4);
        Worker w5 = new Worker("Nick");
        l1.addWorker(w5);
        assertEquals(l1.getListOfWorkers(),"Tommy\nBill\nMolly\nSam\nNick\n");
    }

    @Test
    public void GetCostOfStationery(){
        Worker w = new Worker("Bill", new Stationery(100,"pen"), new Stationery(150,"pencil"),
                new Stationery(100,"rubber"));
        assertEquals(w.costOfStationery(),350);
    }
}
