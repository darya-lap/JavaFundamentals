package Task_3_4_Inheritance_Interface;

public class Copybook extends Stationery {
    String colorOfLines;
    Copybook (int price,String producer, String color){
        super(price,producer);
        this.colorOfLines = color;
    }
}
