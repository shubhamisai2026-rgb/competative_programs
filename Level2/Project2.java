////////////////////////////////////////////////////////////////////////////////////////
///
/// 
///  Task2.password strength checker
///  Author:Shubham Isai
/// 
////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////
/// 
///  ALOGORITHM:
///  1) start the program
///  2) read the password from the user
///  3) initialize four boolean variable
///   . hasUpper=false . hasLower=false .hasDigit=false .hasSpecial=false
///  4) Traverse the password character by character
///  5) for each character
///    .if it is lowercase,set has lowercase=true
///    .if it s uppercase,set has uppercase=true
///    .if it is digit,set has hasdigit=true
///    .otherwise ,set hasspecial=true
///  6) check the password length
///  7) display whether the password is weak medium or strong
///  8) end of the program
///
///////////////////////////////////////////////////////////////////////////////////////////

///  SOLUTION

import java.util.Scanner;
public class Project2 
{
    public static void main(String args[])
    {
        Scanner sobj=new Scanner(System.in);
        System.out.print("enter a password:");
        String password=sobj.nextLine();
        boolean hasupper=false;
        boolean haslower=false;
        boolean hasdigit=false;
        boolean hasspecial=false;

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
        if(password.length()>=8 && hasupper && haslower &&hasdigit && hasspecial)
        {
            System.out.println("strong password...");
        }
        else if(password.length()>=6 &&hasdigit&&haslower&&hasupper&&hasspecial)
        {
            System.out.println("medium password...");
        }
        else
        {
            System.out.println("weak password");
        }
        sobj.close();
    }
}
