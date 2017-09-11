package test;

public class DemoJoin {
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("one");
        NewThread ob2 = new NewThread("two");
        NewThread ob3 = new NewThread("tree");
        System.out.println(("Thread one is alive: " + ob1.t.isAlive()));
        System.out.println(("Thread one is alive: " + ob1.t.isAlive()));
        System.out.println(("Thread one is alive: " + ob1.t.isAlive()));
        try {
            System.out.println("waiting for threads to finish.");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("main thread interrupted.");
        }
        System.out.println(("Thread one is alive: " + ob1.t.isAlive()));
        System.out.println(("Thread one is alive: " + ob1.t.isAlive()));
        System.out.println(("Thread one is alive: " + ob1.t.isAlive()));
        System.out.println("main thread exiting");
    }
}
