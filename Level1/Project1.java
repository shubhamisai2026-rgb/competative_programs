////////////////////////////////////////////////////////////////////////////////////////
///
/// 
///  Task1.Temprature converter
///  Author:Shubham Isai
/// 
////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////
/// 
///  ALOGORITHM:
///  1) Start the program
///  2)create scanner object
///  3)read the temprature from the user
///  4)read the unit(c or f)
///  5)if the unit is c,convert to fahrenheit
///  6)if the unit is f,convert to celsius
///  7)otherwise,display an error message
///  8)close the scanner
///  9)end the program
///
///////////////////////////////////////////////////////////////////////////////////////////

///  SOLUTION

import java.util.Scanner;
public class Project1 
{
    public static void main(String args[])
    {
        Scanner sobj=new Scanner(System.in);
        double temp;
        char unit;
        System.out.println("------Temprature Converter...........");
        System.out.println("enter the temprature:");
        temp=sobj.nextDouble();
        System.out.println("enter unit(C/F):");
        unit=sobj.next().toUpperCase().charAt(0);

        if(unit=='C')
        {
            double fah=(temp * 9/5)+ 32;
            System.out.println("temprature in fahrenheit="+fah+"F");
        }
        else if(unit=='F')
        {
            double celsius=(temp-32)*5/9;
            System.out.println("temprature in celsius="+celsius+"C");
        }
        else
        {
            System.out.println("invalid choice................");
        }
        sobj.close();
    }
}
