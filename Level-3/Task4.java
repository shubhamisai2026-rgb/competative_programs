//////////////////////////////////////////////////////////////////////////////////////
///
///  PROBLEM STATEMENT
///  4.time stamped file generator
///  Author Name:Shubham Isai
///
/// ///////////////////////////////////////////////////////////////////////////////////

// SOLUTION:
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Task4 
{
    static final String fname="log.txt";
    static Scanner sobj=new Scanner(System.in);
    public static void main(String args[])
    {
        int choice;
        do
        {
          System.out.println("\n---------LOG FILE GENERATOR-----------");
          System.out.println("1.write log");
          System.out.println("2.exit");

          System.out.print("enter choice:");
          choice=sobj.nextInt();
          sobj.nextLine();

          switch(choice)
          {
            case 1:writelog();
            break;
            case 2:
                System.out.println("Thank you!");
                break;

            default:System.out.println("invlid choice");
          }
        }while(choice!=2);
    }
    public static void writelog()
    {
        try{
            System.out.println("enter log message:");
            String message=sobj.nextLine();

            FileWriter fw=new FileWriter(fname,true);
            BufferedWriter bw=new BufferedWriter(fw);

            LocalDateTime now=LocalDateTime.now();

            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");

            String timestamp=now.format(formatter);

            bw.write(timestamp+"-"+message);
            bw.newLine();
            bw.close();
            System.out.println("log saved succefuuly");
        }
        catch(Exception e)
        {
            System.out.println("Error:"+e.getMessage());
        }
    }
}
