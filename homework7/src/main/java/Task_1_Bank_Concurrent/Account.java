package Task_1_Bank_Concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private int balance;
    private int id;
    Lock l;

    Account(int id){
        this.id = id;
        l = new ReentrantLock();
    }

    boolean withdraw(int amount){
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        else{
            return false;
        }
    }

    void deposit(int amount){
            balance += amount;
    }

    int getBalance(){
        return balance;
    }

    int getID(){
        return id;
    }

    void setBalance(int initialBalance){
        this.balance = initialBalance;
    }

    Lock getLock(){
        return this.l;
    }

}
