//////////////////////////////////////////////////////////////////////////////////////
///
///  PROBLEM STATEMENT
///  2.create a temprature converter (celsius <-> fahrenheit)
///  Author Name:Shubham Isai
///
/// ///////////////////////////////////////////////////////////////////////////////////

///  Solution

import java.util.Scanner;
public class Task2 
{
    public static void main(String args[])
    {
        Scanner sobj=new Scanner(System.in);
        int  choice;
        double celsius,fahrenheit;
        System.out.println("Temperature Converter");
        System.out.println("1.celsius to fahrenheit");
        System.out.println("2.fahrenheit to celsius");
        System.out.println("enter a your choice:");
        choice=sobj.nextInt();
        switch(choice)
        {
          case 1:
            System.out.println("enter a temprature in celsius:");
            celsius=sobj.nextDouble();
            fahrenheit=(celsius * 9/5)+32;
            System.out.println("Temprature in fahrenheit="+fahrenheit);
            break;
          

         case 2:
            System.out.println("enter temprature in fahrenheit:");
            fahrenheit=sobj.nextDouble();
            celsius=(fahrenheit-32)*5/9;
            System.out.println("temprature in celsius="+celsius);
            break;
   
         
         default:
            System.out.println("invalid choice...");
        }
        sobj.close();
    }
}
