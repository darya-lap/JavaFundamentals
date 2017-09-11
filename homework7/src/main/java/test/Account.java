package test;

public class Account{
    private int balance;

    public Account(int balance){
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public  void deposit (int amount){
        synchronized (this) {
            int x = balance + amount;
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = x;
        }
    }

    public  void withdraw (int amount){
        synchronized (this) {
            int x = balance - amount;
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = x;
        }
    }
}
