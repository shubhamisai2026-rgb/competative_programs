//////////////////////////////////////////////////////////////////////////////////////
///
///  PROBLEM STATEMENT
///  2.Daily Task Manager load/save functionality
///  Author Name:Shubham Isai
///
/// ///////////////////////////////////////////////////////////////////////////////////

// SOLUTION:

import java.io.*;
import java.util.*;

public class Task2
{
  static ArrayList<Task>tasklist=new ArrayList<>();
  static final String fname="tasks.txt";
 public static void loadtasks()
 {
    File file=new File(fname);
    if(!file.exists())
    {
      return;
    }
    try
    {
      BufferedReader br=new BufferedReader(new FileReader(file));
      String line;
      while((line=br.readLine())!=null)
      {
        String data[]=line.split(",");
        if(data.length==2)
        {
          String title=data[0];
          boolean completed=Boolean.parseBoolean(data[1]);
          tasklist.add(new Task(title,completed));
        }
      }
      br.close();
    }
    catch(IOException e)
    {
      System.out.println("error loading tasks");
    }
 }
 public static void savetasks()
 {
  try
  {
    BufferedWriter bw=new BufferedWriter(new FileWriter(fname));
    for(Task t:tasklist)
    {
      bw.write(t.title+","+t.completed);
      bw.newLine();
    }
    bw.close();
    System.out.println("tasks saved successfully.");
  }
  catch(IOException e)
  {
    System.out.println("error saving tasks");
  }
 }

 public static void addtask(Scanner sobj)
 {
   System.out.print("enter task:");
   String task=sobj.nextLine();

   tasklist.add(new Task(task,false));
   System.out.println("task added successfully");
 }

 public static void viewtasks()
 {
   if(tasklist.isEmpty())
   {
     System.out.println("No tasks Available");
     return;
   }
   System.out.println("\n.........Task List................");
   for(int i=0;i<tasklist.size();i++)
   {
     System.out.println((i+1)+"."+tasklist.get(i));
   }
 }

 public static void markcomplete(Scanner sobj)
 {
   viewtasks();
   if(tasklist.isEmpty())
   {
    return;
   }
   System.out.print("enter task number:");
   int index=sobj.nextInt();
   sobj.nextLine();

   if(index>=1 && index<=tasklist.size())
   {
    tasklist.get(index-1).completed=true;
    System.out.println("task completed");
   }
   else
   {
    System.out.println("invalid task number");
   }
 }

 public static void deletetask(Scanner sobj)
 {
  viewtasks();
  if(tasklist.isEmpty())
  {
    return;
  }
  System.out.print("enter task number:");
  int index=sobj.nextInt();
  sobj.nextLine();

  if(index>=1 && index<=tasklist.size())
  {
    tasklist.remove(index-1);
    System.out.println("task deleted");
  }
  else
  {
    System.out.println("invalid task number");
  }
 }

 public static void main(String[] args) 
 {
   Scanner sobj=new Scanner(System.in);
   loadtasks();
   int choice;
   do
   {
     System.out.println("\n...........DAILY TASK MANAGER............");
     System.out.println("1.Add Task");
     System.out.println("2.view Task");
     System.out.println("3.mark task complete");
     System.out.println("4.Delete Task");
     System.out.println("5.save task");
     System.out.println("6.Exit");

     System.out.println("enter choice:");
     choice=sobj.nextInt();
     sobj.nextLine();

     switch(choice)
     {
      case 1:
        addtask(sobj);
        break;
      
      case 2:
        viewtasks();
        break;
      
      case 3:
        markcomplete(sobj);
        break;
      
      case 4:deletetask(sobj);
      break;

      case 5:savetasks();
      break;

      case 6:savetasks();
      System.out.println("Invalid choice");
     }
   }while(choice!=6);
   sobj.close();
  }
}

class Task
{
  String title;
  boolean completed;    

  public Task(String title,boolean completed)
  {
    this.title=title;
    this.completed=completed;
  }

  @Override
  public String toString()
  {
    return (completed ?"[Done]":"[Pending]")+title;
  }
}


