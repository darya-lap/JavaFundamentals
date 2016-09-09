package Task_3_4_Inheritance_Interface;

public class Pen extends Stationery {
    int wide;
    Pen (int price,String producer, int wide){
        super(price,producer);
        this.wide = wide;
    }
}
