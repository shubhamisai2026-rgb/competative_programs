//////////////////////////////////////////////////////////////////////////////////////
///
///  PROBLEM STATEMENT
///  1.student report generator with formatted output
///  Author Name:Shubham Isai
///
/// ///////////////////////////////////////////////////////////////////////////////////

// SOLUTION:

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class Task3 
{
    public static void main(String args[])
    {
        Scanner sobj=new Scanner(System.in);

        System.out.print("enter student name:");
        String name=sobj.nextLine();

        System.out.print("enter roll number:");
        int roll=sobj.nextInt();

        System.out.print("enter number of subjects:");
        int subjects=sobj.nextInt();

        Student ssobj=new Student(name,roll,subjects);
        ssobj.inputmarks(sobj);
        ssobj.calculateresult();
        ssobj.displayreport();
        ssobj.savereport();
        sobj.close();
    }
}

class Student
{
    String name;
    int rollno;
    int marks[];
    int total;
    double average;
    double percentage;
    char grade;

    public Student(String name,int rollno,int subjects)
    {
        this.name=name;
        this.rollno=rollno;
        marks=new int[subjects];
    }

    public void inputmarks(Scanner sobj)
    {
        System.out.println("\n enter marks:");
        for(int i=0;i<marks.length;i++)
        {
            System.out.print("subject"+(i+1)+":");
            marks[i]=sobj.nextInt();
        }
    }

    public void calculateresult()
    {
        total=0;
        for(int i=0;i<marks.length;i++)
        {
          total=total+marks[i];
        }

        average=(double)total/marks.length;
        percentage=average;

        if(percentage>=90)
        {
            grade='A';
        }
        else if(percentage>=80)
        {
            grade='B';
        }
        else if(percentage>=70)
        {
            grade='C';
        }
        else if(percentage>=60)
        {
            grade='D';
        }
        else
        {
            grade='F';
        }
    }
    public void displayreport()
    {
        System.out.println("\n...........................................");
        System.out.println("..........STUDENT REPORT......................");
        System.out.println("..............................................");

        System.out.println("name:"+name);
        System.out.println("roll no:"+rollno);
        System.out.println("\nMarks:");

        for(int i=0;i<marks.length;i++)
        {
            System.out.println("subjects:"+(i+1)+":"+marks[i]);
        }
        System.out.println("-----------------------------------------");
        System.out.println("Total:"+total);
        System.out.printf("Average:%.2f\n",average);
        System.out.printf("percentage:%.2f%%\n",percentage);
        System.out.println("Grade:"+grade);
        System.out.println("--------------------------------------------");
    }
       
    public void savereport()
    {
        try
        {
            BufferedWriter bw=new BufferedWriter(new FileWriter("studentreport.txt"));
            bw.write("---------------------------------------------------");
            bw.write("-------------STUDENT REPORT-----------------");
            bw.newLine();
            bw.write("------------------------------------------------");
            bw.newLine();
            bw.write("Roll no:"+rollno);
            bw.newLine();
            bw.write("Name:"+name);
            bw.newLine();
            bw.newLine();
            bw.write("Marks:");
            bw.newLine();
            for(int i=0;i<marks.length;i++)
            {
                bw.write("subject"+(i+1)+":"+marks[i]);
                bw.newLine();
            }
            bw.write("----------------------------------------");
            bw.newLine();
            bw.write("Total:"+total);
            bw.newLine();
            bw.write("Average:"+average);
            bw.newLine();
            bw.write("percentage:"+percentage);
            bw.newLine();
            bw.write("Grade:"+grade);
            bw.newLine();
            bw.write("-------------------------------------");
            bw.newLine();
            bw.close();

            System.out.println("\n Reeport saved successfully in studentreport.txt");
        }
        catch(IOException e)
        {
            System.out.println("error while saving report");
        }
    }
}
        