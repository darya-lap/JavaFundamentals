package Task_3_4_Inheritance_Interface;

public class Ballpen extends Pen {
    String suitableCore;
    Ballpen (int price,String producer, int wide, String core){
        super(price,producer, wide);
        this.suitableCore = core;
    }
}
