//////////////////////////////////////////////////////////////////////////////////////
///
///  PROBLEM STATEMENT
///  1.display a 3 * 3 number grid using arrays and check if a number exists.
///  Author Name:Shubham Isai
///
/// ///////////////////////////////////////////////////////////////////////////////////

// SOLUTION:

import java.util.Scanner;
public class Task1
{
    public static void main(String args[])
    {
       Scanner sobj=new Scanner(System.in);
       int arr[][]=new int[3][3];
       System.out.println("enter a 9 numbers:");
       for(int i=0;i<3;i++)
       {
        for(int j=0;j<3;j++)
        {
            arr[i][j]=sobj.nextInt();
        }
       }
       System.out.println("\n 3*3 Number Grid:");
       for(int i=0;i<3;i++)
       {
        for(int j=0;j<3;j++)
        {
            System.out.println(arr[i][j]+"\t");
        }
        System.out.println();
    }
     System.out.println("\n enter number to search:");
     int iValue=sobj.nextInt();
     boolean found=false;

     for(int i=0;i<3;i++)
     {
        for(int j=0;j<3;j++)
        {
            if(arr[i][j]==iValue)
            {
                found=true;
                 break;
            }
        }
     }
     if(found)
     {
        System.out.println("number found");
     }
     else
     {
        System.out.println("number not found");
     }
     sobj.close();
    }
}
