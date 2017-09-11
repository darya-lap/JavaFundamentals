package test;

public class GetStateDemo implements Runnable{
    public void run() {
        Thread.State state = Thread.currentThread().getState();
        System.out.println(Thread.currentThread().getName() + " " + state);
    }

    public static void main(String[] args) {
        Thread th1 = new Thread(new GetStateDemo());
        Thread th2 = new Thread(new GetStateDemo());
        th1.start();
        th2.start();
        try{
            System.out.println(th2.getState());
            Thread.sleep(5000);
            System.out.println(th2.getState());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Thread.State state = th1.getState();
        System.out.println(th1.getName() + " "+ state);
    }
}
