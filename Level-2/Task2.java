//////////////////////////////////////////////////////////////////////////////////////
///
///  PROBLEM STATEMENT
///  2.Analyze password strength using validation rules
///  Author Name:Shubham Isai
///
/// ///////////////////////////////////////////////////////////////////////////////////

// SOLUTION:

import java.util.Scanner;
public class Task2 
{
    public static void main(String args[])
    {
        Scanner sobj=new Scanner(System.in);
        System.out.print("enter password:");
        String password=sobj.nextLine();
        
        boolean hasupper=false;
        boolean haslower=false;
        boolean hasdigit=false;
        boolean hasspecial=false;
        boolean haslength=false;

        if(password.length()>=8)
        {
          haslength=true;
        }

        for(int i=0;i<password.length();i++)
        {
            char ch=password.charAt(i);
            if(Character.isUpperCase(ch))
            {
              hasupper=true;
            }
            else if(Character.isLowerCase(ch))
            {
                haslower=true;
            }
            else if(Character.isDigit(ch))
            {
                hasdigit=true;
            }
            else
            {
                hasspecial=true;
            }
        }
        int score=0;
        if(haslength)
        {
            score++;
        }
        if(hasupper)
        {
            score++;
        }
        if(haslower)
        {
            score++;
        }
        if(hasdigit)
        {
            score++;
        }
        if(hasspecial)
        {
            score++;
        }
        System.out.println("\n password analysis");
        System.out.println("-----------------------------------------");
        System.out.println("minimum length(8):"+haslength);
        System.out.println("uppercase letter:"+hasupper);
        System.out.println("lowercase letter:"+haslower);
        System.out.println("digit:"+hasdigit);
        System.out.println("special character:"+hasspecial);
        System.out.println();

        if(score==5)
        {
            System.out.println("password strength:strong");
        }
        else if(score>=3)
        {
            System.out.println("password strength:medium");
        }
        else
        {
            System.out.println("password strength:weak");
        }
        sobj.close();
    }
}
