package Task_3_4_Inheritance_Interface;

public class ColorPencil extends Pencil {
    String color;
    ColorPencil(int price, String producer, String hardness,String color){
        super(price,producer, hardness);
        this.color = color;
    }
}
