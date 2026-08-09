
////////////////////////////////////////////////////////////////////////////////////////
///
/// 
///  Task1.Create a Multi-threaded Application
///  Author:Shubham Isai
/// 
////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////
/// 
///  ALOGORITHM:
///  1) start the program
///  2) create a BankAccount object with an initial balance
///  3) Define Synchronized methods for
///       . Deposit Money  . Withdraw Money
///       . Display Current Balance
///       . Display transaction history
///  4) create a customer class that extends the thread class
///  5) pass the bank account object,customer name,
///     operation(deposit/withdraw),and amount to each customer thread
///  6) if the run() method
///     .if the operation is deposit,call the deposit() method
///     .if the operation withdraw,call the withdraw() method
///  7) in the main method
///     .create multiple customer threads
///     .start all threads using start() method
///  8) wait for all thread to complete using the join() method
///  9) display the final account balance
///  10) display the complete transation history
///  11) stop the program
///
///////////////////////////////////////////////////////////////////////////////////////////

///  SOLUTION

import java.util.*;


public class Project1 
{
    public static void main(String args[])
    {
        BankAccount account=new BankAccount(100000);
        Customer c1=new Customer(account,"shubham","withdraw",4000);
        Customer c2=new Customer(account,"Rahul","deposit",3000);
        Customer c3=new Customer(account,"Amit","withdraw",7000);
        Customer c4=new Customer(account, "Rohit","deposit", 2000);
        Customer c5=new Customer(account,"sneha", "withdraw", 5000);
        
       Thread t1=new Thread(c1);
       Thread t2=new Thread(c2);
       Thread t3=new Thread(c3);
       Thread t4=new Thread(c4);
       Thread t5=new Thread(c5);

       t1.start();
       t2.start();
       t3.start();
       t4.start();
       t5.start();
       try
       {
        c1.join();
        c2.join();
        c3.join();
        c4.join();
        c5.join();
        
    }
       catch(Exception e)
       {
        System.out.println(e);
       }
       account.displaybalance();
       account.displayhistory();
       
    }
}


class BankAccount 
{
    private int balance;
    private ArrayList<String> history;

    public BankAccount(int balance)
    {
        this.balance=balance;
        history=new ArrayList<>();
    }
    public synchronized void deposit(String name,int amount)
    {
        System.out.println("\n"+name+"is depositing="+amount);
        try
        {
            Thread.sleep(10000);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        balance=balance+amount;
        history.add(name+"Deposited$"+amount);
        System.out.println(name+"deposit successful");
        System.out.println("Current Balance:$"+balance);
    }
    public synchronized void withdraw(String name,int amount)
    {
        System.out.println("\n"+name+"want to withdraw $"+amount);
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        if(balance>=amount)
        {
            balance=balance-amount;
            history.add(name+"withdraw$"+amount);
            System.out.println(name+"withdrawal successful");
            System.out.println("Remaining balance:$"+balance);
        }
        else
        {
            history.add(name+"withdrawal failed");
            System.out.println(name+"insufficient balance");
        }
    }
    public synchronized void displaybalance()
    {
        System.out.println("\n current balance:$"+balance);
    }
    public synchronized void displayhistory()
    {
        System.out.println("\n.......Transaction history.........");
        for(String s:history)
        {
            System.out.println(s);
        }
        System.out.println("---------------------------------------------");
    }
}

class Customer extends Thread
{
    private BankAccount account;
    private String customername;
    private String operation;
    private int amount; 
    
    public Customer(BankAccount account,String customername,String operation,int amount)
    {
        this.account=account;
        this.customername=customername;
        this.operation=operation;
        this.amount=amount;
    }

    public void run()
    {
        try
        {
        if(operation.equalsIgnoreCase("deposit"))
        {
            account.deposit(customername,amount);
        }
        else if(operation.equalsIgnoreCase("withdraw"))
        {
           account.withdraw(customername, amount);
        }
        else
        {
            System.out.println("output operation");
        }
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    }

}
