package Task_3_4_Inheritance_Interface;

import static Task_2_Desktop.Worker.MAX_SIZE;

public class BeginnerSet{
    private Stationery[] stationery = new Stationery[MAX_SIZE];
    private int index = 0;

    BeginnerSet(Stationery ... s){
        for (Stationery j : s) {
            stationery[index] = j;
            index++;
        }
    }
    public void setStationery(Stationery s){
        stationery[index] = s;
        index++;
    }

    public int getIndex(){
        return index;
    }

    public Stationery getStationery(int i){
        return this.stationery[i];
    }



}
