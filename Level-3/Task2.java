//////////////////////////////////////////////////////////////////////////////////////
///
///  PROBLEM STATEMENT
///  2.students records system with file based persistence
///  Author Name:Shubham Isai
///
/// ///////////////////////////////////////////////////////////////////////////////////

// SOLUTION:

import java.util.*;
import java.io.*;

public class Task2 
{
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sobj = new Scanner(System.in);
    static final String fname = "students.txt";

    public static void main(String args[]) 
    {
       loadfromfile();
       int choice;
       do
       {
        System.out.println("\n------------Student Record System----------------");
        System.out.println("1.add student");
        System.out.println("2.view students");
        System.out.println("3.search student");
        System.out.println("4.update student");
        System.out.println("5.delete student");
        System.out.println("6.save records");
        System.out.println("7.load records");
        System.out.println("8.exit");
        System.out.println("enter your choice:");
        choice=sobj.nextInt();
        sobj.nextLine();
        switch(choice)
        {
            case 1:
                addstudent();
                break;
            case 2:
                viewstudents();
                break;
            case 3:
                searchstudent();
                break;
            case 4:
                updatestudent();
                break;
            case 5:
                deletestudent();
                break;
            case 6:
                savefile();
                break;
            case 7:
                loadfromfile();
                break;
            case 8:
                savefile();
                System.out.println("invalid choice");
        }
       }while(choice!=8);
    }

    public static void addstudent() 
    {
        System.out.println("enter roll no:");
        int roll = sobj.nextInt();
        sobj.nextLine();

        System.out.print("enter name:");
        String name = sobj.nextLine();

        System.out.print("enter marks:");
        double marks = sobj.nextDouble();

        students.add(new Student(roll, name, marks));
        System.out.println("students added successfully");
    }

    public static void viewstudents() 
    {
        if (students.isEmpty()) 
            {
            System.out.println("no record found");
            return;
        }
        for (Student s : students)
             {
            s.display();
        }
    }

    public static void searchstudent()
     {
        System.out.println("enter roll no:");
        int roll = sobj.nextInt();
        for (Student s : students) 
            {
            if (s.getrollno() == roll)
                 {
                s.display();
                return;
            }
            System.out.println("student not found");
        }
    }

    public static void updatestudent()
     {
        System.out.print("enter roll number:");
        int roll = sobj.nextInt();
        sobj.nextLine();

        for (Student s : students) {
            if (s.getrollno() == roll) 
                {
                System.out.print("enter new name:");
                String name = sobj.nextLine();

                System.out.println("enter new marks:");
                double marks = sobj.nextDouble();

                s.setname(name);
                s.setmarks(marks);

                System.out.print("record updated");
                return;
            }
        }
        System.out.println("student not found");
    }

    public static void deletestudent() 
    {
        System.out.print("entr rol number:");
        int roll = sobj.nextInt();
        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) 
            {
            Student s = itr.next();
            if (s.getrollno() == roll) 
                {
                itr.remove();
                System.out.println("Record deleted");
                return;
            }
        }
        System.out.println("student not found");
    }

    public static void savefile()
     {
        try 
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fname));
            for (Student s : students) 
                {
                bw.write(s.getrollno() + "," + s.getname() + "," + s.getmarks());
                bw.newLine();
            }
            bw.close();
            System.out.println("Records saved successfully");
        } 
        catch (Exception e)
         {
            System.out.println(e);
        }
    }

    public static void loadfromfile() 
    {
        students.clear();
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            while ((line = br.readLine()) != null) 
                {
                String data[] = line.split(",");
                int roll = Integer.parseInt(data[0]);
                String name = data[1];
                double marks = Double.parseDouble(data[2]);
                students.add(new Student(roll, name, marks));
            }
            br.close();
        } 
        catch (Exception e)
         {
            System.out.println(e);
        }

    }
}

class Student implements Serializable
 {
    private int rollno;
    private String name;
    private double marks;

    public Student(int rollno, String name, double marks) 
    {
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }

    public int getrollno() 
    {
        return rollno;
    }

    public String getname() 
    {
        return name;
    }

    public double getmarks() 
    {
        return marks;
    }

    public void setname(String name)
     {
        this.name = name;
    }

    public void setmarks(double marks)
     {
        this.marks = marks;
    }

    public void display() 
    {
        System.out.println("---------------------------------------");
        System.out.println("ROLL NO:" + rollno);
        System.out.println("NAME:" + name);
        System.out.println("MARKS:" + marks);
    }
}
