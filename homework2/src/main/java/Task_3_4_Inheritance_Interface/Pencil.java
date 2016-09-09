package Task_3_4_Inheritance_Interface;

public class Pencil extends Stationery {
    String hardnes;
    Pencil(int price, String producer, String hardness){
        super(price,producer);
        this.hardnes = hardness;
    }
}
