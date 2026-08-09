////////////////////////////////////////////////////////////////////////////////////////
///
/// 
///  Task4.Random Password Generator
///  Author:Shubham Isai
/// 
////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////
/// 
///  ALOGORITHM:
///  1)start the program
///  2)create a scanner and random object
///  3)store uppercase,lowercase,numbers and special characters in separate strings
///  4)ask the user which character types to include
///  5)combine the selected character sets into one string
///  6)generate random indexes using Random.nextInt()
///  7)pick characters using charAt(index)
///  8)Repeat until the required password length is reached
///  9)Display the generated password
///  10)end the program
///
///////////////////////////////////////////////////////////////////////////////////////////

///  SOLUTION

import java.util.Random;
import java.util.Scanner;
public class Project4 
{
    public static void main(String args[])
    {
       Scanner sobj=new Scanner(System.in);
       Random robj=new Random();
       String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String lower="abcdefghijklmnopqrstuvwxyz";
       String digit="0123456789";
       String symbol="!@#$%^&*";
       String characters=" ";

       System.out.println("enter a password length:");
       int length=sobj.nextInt();

       System.out.print("include uppercase ?(true/false):");
       boolean uppercase=sobj.nextBoolean();

       System.out.println("include lowercase ?(true/false):");
       boolean lowercase=sobj.nextBoolean();

       System.out.println("enter digits ?(true/false):");
       boolean digits=sobj.nextBoolean();

       System.out.println("include special characters ?(true/false):");
       boolean specialchar=sobj.nextBoolean();

       if(uppercase)
       {
        characters=characters+upper;
       }
       if(lowercase)
       {
        characters=characters+lower;
       }
       if(digits)
       {
        characters=characters+digit;
       }
       if(specialchar)
       {
        characters=characters+symbol;
       }
       if(characters.length()==0)
       {
         System.out.println("no characters type selected...");
         sobj.close();
         return;
       }
       String password="";
       for(int i=0;i<length;i++)
       {
        int index=robj.nextInt(characters.length());
        password=password+characters.charAt(index);
       }
       System.out.println("Generated password:"+password);
       sobj.close();
    }
}
