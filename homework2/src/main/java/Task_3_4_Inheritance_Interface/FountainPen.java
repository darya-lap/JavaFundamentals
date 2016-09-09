package Task_3_4_Inheritance_Interface;

public class FountainPen extends Pen {
    String suitableInk;
    FountainPen (int price,String producer, int wide, String ink){
        super(price,producer, wide);
        this.suitableInk = ink;
    }
}
