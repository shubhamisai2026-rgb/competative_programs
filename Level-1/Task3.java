//////////////////////////////////////////////////////////////////////////////////////
///
///  PROBLEM STATEMENT
///  3.calculate student grade average using arrays.
///  Author Name:Shubham Isai
///
/// ///////////////////////////////////////////////////////////////////////////////////

///  Solution:

import java.util.Scanner;
public class Task3 
{
    public static void main(String[] args) 
    {
        Scanner sobj=new Scanner(System.in);
        int marks[]=new int[5];
        int sum=0;
        double average;
        char grade;
        System.out.println("enter marks of 5 subjects:");
        for(int i=0;i<5;i++)
        {
            System.out.println("subject"+(i+1)+":");
            marks[i]=sobj.nextInt();
            sum=sum+marks[i];
        }
        average=sum/5.0;
        if(average>=90)
        {
            grade='A';
        }
        else if(average>=80)
        {
            grade='B';
        }
        else if(average>=75)
        {
            grade='C';
        }
        else if(average>=40)
        {
            grade='D';
        }
        else
        {
            grade='F';
        }
        System.out.println("\nTotal marks="+sum);
        System.out.println("Average="+average);
        System.out.println("Greade="+grade);
        sobj.close();
    }
}
