////////////////////////////////////////////////////////////////////////////////////////
///
/// 
///  Task2.Palindrome of the string
///  Author:Shubham Isai
/// 
////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////
/// 
///  ALOGORITHM:
///  1) start the program
///  2) read a word or phrase from the user
///  3) remove all space and special characters
///  4) convert the string to lowercase
///  5) reverse the string using loop
///  6) compare the original string with the reverse string
///  7) if both are equal,print palindrome
///  8) otherwise,print not palindrome
///  9)end the program
///
///////////////////////////////////////////////////////////////////////////////////////////

///  SOLUTION

import java.util.Scanner;
public class Project2 
{
    public static void main(String args[])
    {
        Scanner sobj=new Scanner(System.in);
        System.out.print("enter a word or phrase:");
        String input=sobj.nextLine();

        String str=input.replaceAll("[^a-z A-Z 0-9]"," ").toLowerCase();
        String reverse="";

        for(int i=str.length()-1;i>=0;i--)
        {
            reverse=reverse+str.charAt(i);
        }
        if(str.equals(reverse))
        {
            System.out.println("Palindrome...................");
        }
        else
        {
            System.out.println("not a palindrome..............");
        }
        sobj.close();
    }
}
