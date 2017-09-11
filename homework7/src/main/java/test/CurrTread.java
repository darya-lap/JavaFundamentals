package test;

public class CurrTread {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Current thread: " + t);
        t.setName("My Thread");
        System.out.println("After changes: " + t);
        try{
            for (int n = 5; n > 0; n--){
                System.out.println(n);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
