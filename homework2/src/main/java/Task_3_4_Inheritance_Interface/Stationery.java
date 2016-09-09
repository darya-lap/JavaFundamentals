package Task_3_4_Inheritance_Interface;

public class Stationery{
    int price;
    String producer;
    Stationery(int price,String producer){
        this.price = price;
        this.producer = producer;
    }

    @Override
    public String toString(){
        String s = this.getClass().getSimpleName() + " " + this.price + " руб." + " " + this.producer + "\n";
        return s;
    }

}
