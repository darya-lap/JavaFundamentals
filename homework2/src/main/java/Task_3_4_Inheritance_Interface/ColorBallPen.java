package Task_3_4_Inheritance_Interface;

public class ColorBallPen extends Ballpen {
    String color;
    ColorBallPen (int price,String producer, int wide, String core, String color){
        super(price,producer, wide, core);
        this.color = color;
    }
}
