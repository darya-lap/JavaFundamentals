package test;

public class OperatorWithdraw extends Thread{
    private Account account;

    public OperatorWithdraw(Account account){
        this.account = account;
    }

    public void run(){
        for (int i = 0; i <5; i++){
            account.withdraw(50);
        }
    }
}