package Task_1_Pen;

public class Pen {
    private String owner;
    private String producer;
    private int price;

    public Pen(int price, String owner, String producer){
        this.producer = producer;
        this.owner = owner;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){return true;}
        if (this == null) {return false;}
        if (getClass() != obj.getClass()){return false;}
        Pen pen = (Pen) obj;
        if (price != pen.price){return false;}
        if (producer == null){
            if (pen.producer != null) return false;
        }
        else{
            if(!producer.equals(pen.producer)) return false;
        }
        if (owner == null) return (pen.owner == null);
        else{
            if (!owner.equals(pen.owner)) return false;
            else return true;
        }
    }

    @Override
    public int hashCode(){
        return (int) ((31 * price)+ ((producer == null) ? 0 : producer.hashCode())
                + ((owner == null) ? 0 : owner.hashCode()));
    }

    @Override
    public String toString(){
        return getClass().getName() + "@ price: " + price + ", owner: " + owner
                + ", producer: " + producer;
    }
}
