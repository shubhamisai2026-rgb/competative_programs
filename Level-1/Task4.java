//////////////////////////////////////////////////////////////////////////////////////
///
///  PROBLEM STATEMENT
///  4.generate a secure random password based on user preference
///  Author Name:Shubham Isai
///
/// ///////////////////////////////////////////////////////////////////////////////////

///  Solution

import java.util.Scanner;
import java.util.Random;

public class Task4 
{
    public static void main(String args[])
    {
        Scanner sobj=new Scanner(System.in);
        Random robj=new Random();
        String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower="abcdefghijklmnopqrstuvwxyz";
        String digits="0123456789";
        String symbols="!#@$%^&*";
        String characters="";
        System.out.println("include upercase letters?(Y/N:");
        if(sobj.next().equalsIgnoreCase("Y"))
        {
           characters=characters+upper;
        }
        System.out.println("include lowercase letters?(Y/N):");
        if(sobj.next().equalsIgnoreCase("Y"))
        {
           characters=characters+lower;
        }
        System.out.println("include digits?(Y/N):");
        if(sobj.next().equalsIgnoreCase("Y"))
        {
          characters=characters+digits;
        }
        System.out.println("include special symblos?(Y/N):");
        if(sobj.next().equalsIgnoreCase("Y"))
        {
            characters=characters+symbols;
        }
        if(characters.length()==0)
        {
            System.out.println("no character set selected");
            sobj.close();
            return;
        }
        System.out.println("enter password length:");                              
        int length=sobj.nextInt();
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
