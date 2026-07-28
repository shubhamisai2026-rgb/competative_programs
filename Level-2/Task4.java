//////////////////////////////////////////////////////////////////////////////////////
///
///  PROBLEM STATEMENT
///  4.build a personal expense tracker with file
///   Author Name:Shubham Isai
///
/// ///////////////////////////////////////////////////////////////////////////////////

// SOLUTION:
import java.util.*;
import java.io.*;


 class Task4 
{
  static ArrayList<Expense>expenses=new ArrayList<>();  
  static Scanner sobj=new Scanner(System.in);
  static final String Fname="expenses.txt";
  public static void main(String args[])
  {
    loadexpenses();  
    int choice;
    do
    {
      System.out.println("-----------------Expense Tracker--------------------\n");
      System.out.println("1.add expenses");
      System.out.println("2.view expenses");
      System.out.println("3.total expenses");
      System.out.println("4.save expenses");
      System.out.println("5.exit");
      System.out.println("enter a your choice:");
      choice=sobj.nextInt();
      sobj.nextLine();
      switch(choice)
      {
        case 1:
            addexpenses();
            break;
        case 2:
            viewexpenses();
            break;
        case 3:
             totalexpense();
             break;
        case 4:
            saveexpenses();
            break;
        case 5:
            saveexpenses();
            System.out.println("Thank you....");
            default:
                System.out.println("invalid choice...");
      }
    }while(choice!=5);
    sobj.close();
  }
  public static void addexpenses()
  {
    System.out.print("expense name:");
    String name=sobj.nextLine();

    System.out.println("category:");
    String category=sobj.nextLine();

    System.out.println("amount:");
    double amount=sobj.nextDouble();
    sobj.nextLine();

    System.out.println("Date:");
    String date=sobj.nextLine();

    Expense tobj=new Expense(name,category,amount,date);
    expenses.add(tobj);
    System.out.println("expenses add successfully");
 }
public static void viewexpenses()
{
    if(expenses.isEmpty())
    {
        System.out.println("no expenses found.");
        return;
    }
    System.out.println("\n-------------------------------------------------");
    System.out.printf("%-15s %-15s %-10s %-15s\n","Name","Category","Amount","Date");
    System.out.println("-----------------------------------------------------");
    for(Expense e:expenses)
    {
        System.out.printf("%-15s %-15s %-10.2f %-15s\n",e.getName(),e.getCategory(),e.getAmount(),e.getDate());
    }
    System.out.println("------------------------------------------------------");
}
public static void totalexpense()
{
    double total=0;
    for(Expense e:expenses)
    {
        total=total+e.getAmount();
    }
    System.out.println("total expense="+total);
}

public static void saveexpenses()
{
  try
  {
    BufferedWriter bw=new BufferedWriter(new FileWriter(Fname));
    for(Expense e:expenses)
    {
        bw.write(e.toString());
        bw.newLine();
    }
    bw.close();
    System.out.println("expenses saved successfully:");
  }
  catch(Exception e)
  {
    System.out.println(e);
  }
}

public static void loadexpenses()
{
    try{
        File file=new File(Fname);
    if(!file.exists())
    {
        file.createNewFile();
        return;
    }
    BufferedReader br=new BufferedReader(new FileReader(Fname));
    String line;
    while((line=br.readLine())!=null)
    {
        String data[]=line.split(",");
        Expense eobj=new Expense(data[0],data[1],Double.parseDouble(data[2]),data[3]);
        expenses.add(eobj);
    }
    br.close();
}
catch(Exception e)
{
    System.out.println(e);
}
}
}
