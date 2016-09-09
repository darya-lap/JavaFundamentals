package Task_3_4_Inheritance_Interface;

public class LineCopyBook extends Copybook {
    int wideOfLines;
    LineCopyBook (int price,String producer, String color, int wide){
        super(price,producer,color);
        this.wideOfLines = wide;
    }
}
