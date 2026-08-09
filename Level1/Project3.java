////////////////////////////////////////////////////////////////////////////////////////
///
/// 
///  Task3.Student Grade Calculator
///  Author:Shubham Isai
/// 
////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////
/// 
///  ALOGORITHM:
///  1)start the program
///  2)read the numbers of subjects
///  3)create an array to store marks
///  4)read the marks for each subject using a loop
///  5)add all marks to sum
///  6)calculate the average using sum/n
///  7)Display the total,average,and grade
///  8)end the program
///  
///
///////////////////////////////////////////////////////////////////////////////////////////

///  SOLUTION

import java.util.Scanner;
public class Project3 
{
public static void main(String args[])
{
    Scanner sobj=new Scanner(System.in);
    int n;
    System.out.println("enter a number of subjects:");
    n=sobj.nextInt();
    double sum=0; double average;
    double marks[]=new double[n];
    System.out.println("enter marks:");
    for(int i=0;i<n;i++)
    {
        System.out.print("subject"+(i+1)+":");
        marks[i]=sobj.nextDouble();
        sum=sum+marks[i];
    }
    average=sum/n;
    System.out.println("\n...................Result................");
    System.out.println("Total Marks="+sum);
    System.out.println("Average Marks="+average);
    
    if(average>=90)
    {
      System.out.println("Grade:A+");
    }
    else if(average>=80)
    {
        System.out.println("Grade:B");
    }
    else if(average>=70)
    {
        System.out.println("Grade:C");
    }
    else if(average>=40)
    {
        System.out.println("Grade:D");
    }
    else
    {
        System.out.println("Grade:Fail");
    }
     sobj.close();
}
}
