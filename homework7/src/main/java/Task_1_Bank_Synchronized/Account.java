package Task_1_Bank_Synchronized;


public class Account {
    private int balance;
    private int id;

    public Account(int id){
        this.id = id;
    }

    public boolean withdraw(int amount){
        synchronized (this) {
            if (balance >= amount) {
                balance -= amount;
                return true;
            }
            else return false;
        }
    }

    public void deposit(int amount){
        synchronized (this) {
            balance += amount;
        }
    }

    public int getBalance(){
        return balance;
    }

    public int getID(){
        return id;
    }

    public void setBalance(int initialBalance){
        this.balance = initialBalance;
    }

}
