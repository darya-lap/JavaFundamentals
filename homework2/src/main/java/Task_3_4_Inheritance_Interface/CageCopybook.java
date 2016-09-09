package Task_3_4_Inheritance_Interface;

public class CageCopybook extends Copybook {
    int sizeOfCages;
    CageCopybook (int price,String producer, String color, int size){
        super(price,producer,color);
        this.sizeOfCages = size;
    }
}
