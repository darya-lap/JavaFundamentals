package Task_2_Desktop;

import static Task_2_Desktop.Worker.MAX_SIZE;

public class ListOfWorkers {
    private int indexOfWorkers = 0;
    Worker[] listOfWorkers = new Worker[MAX_SIZE];

    ListOfWorkers(Worker... workers) {
        for (Worker j : workers) {
            listOfWorkers[indexOfWorkers] = j;
            indexOfWorkers++;
        }
    }

    public void addWorker(Worker w) {
        listOfWorkers[indexOfWorkers] = w;
        indexOfWorkers++;
    }

    public String getListOfWorkers(){
        String s = new String("");
        for (int j = 0;j < indexOfWorkers;j++){
            s += this.listOfWorkers[j].getWorkerName();
            s += "\n";
        }
        return s;
    }
}
