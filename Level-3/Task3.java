//////////////////////////////////////////////////////////////////////////////////////
///
///  PROBLEM STATEMENT
///  3.console-based library management system
///  Author Name:Shubham Isai
///
/// ///////////////////////////////////////////////////////////////////////////////////

// SOLUTION:

import java.util.*;
import java.io.*;
class Task3
{
    static ArrayList<Book>books=new ArrayList<>();
    static Scanner sobj=new Scanner(System.in);
    static final String fname="books.txt";

    public static void main(String args[])
    {
      loadfromfile();
      int choice;
      do
      {
        System.out.println("\n.....LIBRARY MANAGEMENT SYSTEM.........");
        System.out.println("1.Add Book");
        System.out.println("2.view books");
        System.out.println("3.search book");
        System.out.println("4.issue book");
        System.out.println("5.Return Book");
        System.out.println("6.Delete Book");
        System.out.println("7.save records");
        System.out.println("8.load records");
        System.out.println("9.exit");

        System.out.println("enter choice:");
        choice=sobj.nextInt();
        sobj.nextLine();
        switch(choice)
        {
          case 1:
            addbook();
            break;
          case 2:
            viewbooks();
            break;
          case 3:
            searchbook();
            break;
          case 4:
            issuebook();
            break;
          case 5:
            returnbook();
            break;
          case 6:
            deletebook();
            break;
          case 7:
            savetofile();
            break;
          case 8:
            loadfromfile();
            break;
          case 9:
            savetofile();
            System.out.println("Thank you!");
            break;

          default:
            System.out.println("invalid choice");
        }
      }while(choice!=9);
    }
    public static void addbook()
    {
      System.out.print("enter book id:");
      int id=sobj.nextInt();
      sobj.nextLine();

      System.out.print("enter title:");
      String title=sobj.nextLine();

      System.out.println("enter author:");
      String author=sobj.nextLine();
      
      books.add(new Book(id,title,author));

      System.out.println("book added successfully");
    }

    public static void viewbooks()
    {
      if(books.isEmpty())
      {
        System.out.println("no books found");
        return;
      }
      for(Book b:books)
      {
        b.display();
      }
    }

    public static void searchbook()
    {
      System.out.println("enter book id:");
      int id=sobj.nextInt();
      for(Book b:books)
      {
        if(b.getbookid()==id)
        {
          b.display();
          return;
        }
      }
      System.out.println("book not found");
    }

    public static void issuebook()
    {
       System.out.println("enter book id:");
       int id=sobj.nextInt();
       for(Book b:books)
       {
        if(b.getbookid()==id)
        {
           if(b.isissued())
           {
             System.out.println("book already issued");
           }
           else
           {
             b.setissued(true);
             System.out.println("book issued successufully");
           }
           return;
        }
       }
       System.out.println("book not found");
    }

    public static void returnbook()
    {
      System.out.print("enter book id:");
      int id=sobj.nextInt();
      for(Book b:books)
      {
        if(b.getbookid()==id)
        {
          if(!b.isissued())
          {
            System.out.println("book already available");
          }
          else
          {
            b.setissued(false);
            System.out.println("book returned successfully");
          }
          return;
        }
      }
      System.out.println("book not found");
    }

    public static void deletebook()
    {
      System.out.println("enter book id:");
      int id=sobj.nextInt();
      sobj.nextLine();
      Iterator<Book> itr=books.iterator();
      while(itr.hasNext())
      {
        Book b=itr.next();
        if(b.getbookid()==id)
        {
          itr.remove();
          System.out.println("book deleted successfully");
          return;
        }
      }
      System.out.println("Book not found");
    }
    public static void savetofile()
    {
        try
        {
           BufferedWriter bw=new BufferedWriter(new FileWriter(fname));
           for(Book b:books)
           {
             bw.write(b.getbookid()+","+b.gettitle()+","+b.getauthor()+","+b.isissued());
             bw.newLine();
           }
           bw.close();
           System.out.println("data saved successfully");
        }
        catch(Exception e)
        {
          System.out.println("Error:"+e.getMessage());
        }
    }

    public static void loadfromfile()
    {
      books.clear();
      try
      {
      BufferedReader br=new BufferedReader(new FileReader(fname));
      String line;
      while((line=br.readLine())!=null)
      {
         String arr[]=line.split(",");
         int id=Integer.parseInt(arr[0]);

         String title=arr[1];
         String author=arr[2];

         boolean issued=Boolean.parseBoolean(arr[3]);

         Book b=new Book(id,title,author);
         b.setissued(issued);
         books.add(b);
      }
      br.close();
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }

  }


class Book implements Serializable
{
   private int bookid;
   private String title;
   private String author;
   private boolean issued;

   public Book(int bookid,String title,String author)
   {
     this.bookid=bookid;
     this.title=title;
     this.author=author;
     this.issued=false;
   }

   public int getbookid()
   {
    return bookid;
   }

   public String gettitle()
   {
    return title;
   }

   public String getauthor()
   {
    return author;
   }

   public boolean isissued()
   {
    return issued;
   }

   public void setissued(boolean issued)
   {
     this.issued=issued;
   }

   public void display()
   {
     System.out.println("-----------------------------------");
     System.out.println("Book id:"+bookid);
     System.out.println("Title:"+title);
     System.out.println("Author:"+author);
     System.out.println("status:"+(issued?"issued":"available"));
   }
}
