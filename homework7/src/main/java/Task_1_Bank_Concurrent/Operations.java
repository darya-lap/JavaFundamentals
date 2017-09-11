package Task_1_Bank_Concurrent;

import javax.naming.InsufficientResourcesException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Operations {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Account> accounts = readAccountsFile();
        readAndDoOperations(accounts);
        Thread t = Thread.currentThread();
        for (Account a:accounts){
            System.out.println(a.getID() + "\t" + a.getBalance() + "\n");
        }

    }

    static void transfer(Account acc1, Account acc2, int amount) throws InsufficientResourcesException, InterruptedException {
        System.out.println(acc1.getID() + " (" + acc1.getBalance() + ") ->" + acc2.getID() + " (" + acc2.getBalance() + ") : " + amount);
        if (acc1.getLock().tryLock(1000, TimeUnit.SECONDS)){
            try{
                if (acc2.getLock().tryLock(1000, TimeUnit.SECONDS)) {
                    try {
                        if (acc1.withdraw(amount)) {
                            acc2.deposit(amount);
                            System.out.println("Transfer from " + acc1.getID() + " (" + acc1.getBalance() + ") to " + acc2.getID() + " (" + acc2.getBalance() + ")  is successful");
                        } else {
                            System.out.println("Transfer from " + acc1.getID() + " (" + acc1.getBalance() + ") to " + acc2.getID() + " (" + acc2.getBalance() + ")  is not successful");
                        }
                    }
                    finally {
                        acc2.getLock().unlock();
                    }
                }
            }finally {
                acc1.getLock().unlock();
            }
        }
        else{
            System.out.println("Error waiting lock");
        }
    }

    public static ArrayList<Account> readAccountsFile(){
        ArrayList<Account> accs = new ArrayList<>();
        try(BufferedReader bw= new BufferedReader(new FileReader("homework7/accounts_list.txt"))){
            String s;
            while ((s = bw.readLine()) != null) {
                if (s.contains("<accountID>")){
                    int i = s.indexOf("<accountID>");
                    i+=11;
                    StringBuilder accID = new StringBuilder();
                    while (s.charAt(i) != '<'){
                        accID.append(s.charAt(i));
                        i++;
                    }
                    if (!accs.contains(Integer.parseInt(accID.toString()))) accs.add(new Account(Integer.parseInt(accID.toString())));
                    while (!s.contains("<balance>")){
                        s = bw.readLine();
                    }
                    i = s.indexOf("<balance>") + 9;
                    StringBuilder accBalance = new StringBuilder();
                    while (s.charAt(i) != '<'){
                        accBalance.append(s.charAt(i));
                        i++;
                    }
                    accs.get(accs.size() - 1).setBalance(Integer.parseInt(accBalance.toString()));
                }

            }
            bw.close();
        }
        catch(IOException w){
            w.printStackTrace();
        }
       return accs;
    }

    public static void readAndDoOperations(ArrayList<Account> accounts) throws InterruptedException {
        try(BufferedReader bw= new BufferedReader(new FileReader("homework7/operations.txt"))){
            String s;
            while ((s = bw.readLine()) != null){
                if (s.contains("<from>")){
                    int i = s.indexOf("<from>");
                    i+=6;
                    StringBuilder sb = new StringBuilder();
                    while (s.charAt(i) != '<'){
                        sb.append(s.charAt(i));
                        i++;
                    }
                    int k = Integer.parseInt(sb.toString());
                    Account from = null;
                    for (Account acc: accounts){
                        if (acc.getID() == k){
                            from = acc;
                            break;
                        }
                    }
                    while (!s.contains("<to>")){
                        s = bw.readLine();
                    }
                    i = s.indexOf("<to>") + 4;
                    sb.setLength(0);
                    while (s.charAt(i) != '<'){
                        sb.append(s.charAt(i));
                        i++;
                    }
                    k = Integer.parseInt(sb.toString());
                    Account to = null;
                    for (Account acc: accounts){
                        if (acc.getID() == k){
                            to = acc;
                            break;
                        }
                    }
                    while (!s.contains("<amount>")){
                        s = bw.readLine();
                    }
                    i = s.indexOf("<amount>") + 8;
                    sb.setLength(0);
                    while (s.charAt(i) != '<'){
                        sb.append(s.charAt(i));
                        i++;
                    }
                    int amount = Integer.parseInt(sb.toString());
                    Account finalFrom = from;
                    Account finalTo = to;
                    Thread th = new Thread(() -> {
                        try {
                            transfer(finalFrom,finalTo, amount);
                        }
                        catch(InterruptedException|InsufficientResourcesException e){
                            e.printStackTrace();
                        }
                    });
                    th.start();
                    th.join();
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}

