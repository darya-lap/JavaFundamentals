package test;

public class OperationInspector {
    public static void main(String[] args) {
        Account account = new Account(200);
        OperatorDeposit opD = new OperatorDeposit(account);
        OperatorWithdraw opW = new OperatorWithdraw(account);

        opD.start();
        opW.start();

        try {
            opD.join();
            opW.join();
        }
        catch( Exception e){
            e.printStackTrace();
        }

        System.out.println(account.getBalance());
    }
}
