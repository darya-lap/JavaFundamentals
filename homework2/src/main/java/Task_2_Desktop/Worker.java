package Task_2_Desktop;


public class Worker {
    public static final int MAX_SIZE =  200;
    private String workerName;
    private Stationery[] stationery = new Stationery[MAX_SIZE];
    private int indexOfStationery = 0;
    Worker(String name, Stationery ... st){
        for (Stationery j: st) {
            stationery[indexOfStationery] = j;
            indexOfStationery++;
        }
        workerName = name;
    }

    int getIndex(){
        return this.indexOfStationery;
    }

    String getWorkerName(){
        return this.workerName;
    }

    int costOfStationery(){
        int cost = 0;
        for (int i = 0; i < indexOfStationery; i++){
            cost += stationery[i].getPrice();
        }
        return cost;
    }


}
