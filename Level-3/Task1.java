//////////////////////////////////////////////////////////////////////////////////////
///
///  PROBLEM STATEMENT
///  1.contacts management system using classes and arraylists
///  Author Name:Shubham Isai
///
/// ///////////////////////////////////////////////////////////////////////////////////

// SOLUTION:


import java.util.ArrayList;
import java.util.Scanner;

class Task1 {
  public static void main(String args[])
  {
    Scanner sobj=new Scanner(System.in);
    ArrayList<Contact> contacts=new ArrayList<>();
    int choice;
    do
    {
        System.out.println("\n...contact management system....");
        System.out.println("1.Add Contact");
        System.out.println("2.view all contacts");
        System.out.println("3.search contact");
        System.out.println("4.update contact");
        System.out.println("5.delete contact");
        System.out.println("6.exit");
        System.out.println("enter your choice:");
        choice=sobj.nextInt();
        sobj.nextLine();
        switch(choice)
        {
            case 1:
                System.out.println("enter name:");
                String name=sobj.nextLine();

                System.out.println("enter email:");
                String email=sobj.nextLine();

                System.out.println("enter phone:");
                String phone=sobj.nextLine();

                contacts.add(new Contact(name,phone,email));
                System.out.println("contact added successfully");
                break;
            
            case 2:
                if(contacts.isEmpty())
                {
                    System.out.println("no contacts Available.");
                }
                else
                {
                    for(Contact c:contacts)
                    {
                       c.display();
                    }
                }
                break;
            
            case 3:
                System.out.println("enter name to search:");
                String search=sobj.nextLine();
                boolean found=false;
                for(Contact c:contacts)
                {
                    if(c.getname().equalsIgnoreCase(search))
                    {
                        c.display();
                        found=true;
                        break;
                    }
                }
                if(!found)
                {
                    System.out.println("contact not found");
                }
                break;

            case 4:
                System.out.print("enter name to update:");
                String update=sobj.nextLine();
                found=false;
                for(Contact c:contacts)
                {
                    if(c.getname().equalsIgnoreCase(update))
                    {
                        System.out.print("enter new phone:");
                        String newphone=sobj.nextLine();

                        System.out.println("enter new email:");
                        String newemail=sobj.nextLine();

                        c.setphone(newphone);
                        c.setemail(newemail);

                        System.out.println("contact updated successfully");
                        found=true;
                        break;
                    }
                }
                
            if(!found)
            {
            System.out.println("contact not found");
            }
            break;
            
            case 5:
                System.out.println("enter name to delete:");
                String delete=sobj.nextLine();
                found=false;
                for(int i=0;i<contacts.size();i++)
                {
                    if(contacts.get(i).getname().equalsIgnoreCase(delete))
                    {
                       contacts.remove(i);
                       System.out.println("contacts deleted successfully.");
                       found=true;
                       break;
                    }
                }
                if(!found)
                {
                    System.out.println("contact not found");
                }
                break;
            case 6:
                System.out.println("Thank you!");
                break;

            default:System.out.println("invalid choice");
        }
        }while(choice!=6);
        sobj.close();
    }
}

class Contact {
    private String name;
    private String phone;
    private String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    String getname() {
        return name;
    }

    void setphone(String phone) {
        this.phone = phone;
    }

    void setemail(String email) {
        this.email = email;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println();
    }
}
