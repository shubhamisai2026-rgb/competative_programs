//////////////////////////////////////////////////////////////////////////////////////
///
///  PROBLEM STATEMENT
///  4.CSV Data processor for summaries and Analytics
///  Author Name:Shubham Isai
///
/// ///////////////////////////////////////////////////////////////////////////////////

// SOLUTION:
import java.io.*;
import java.util.*;
public class Task4 
{
    public static void main(String args[])
    {
        ArrayList<Sale>saleslist=new ArrayList<>();
        final String fname="sales.csv";
        try
        {
            BufferedReader br=new BufferedReader(new FileReader(fname));
            String line;
            br.readLine(); //ignores the first line of csv file
            
            while((line=br.readLine())!=null)
            {
                String data[]=line.split(",");
                int id=Integer.parseInt(data[0]);

                String name=data[1];
                String product=data[2];
                
                int quantity=Integer.parseInt(data[3]);
                double price=Double.parseDouble(data[4]);

                Sale sobj=new Sale(id,name,product,quantity,price);
                saleslist.add(sobj);
            }
            br.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
            return;
        }
        double totalsales=0.0;
        double highestsale=Double.MIN_VALUE;
        double lowestsale=Double.MAX_VALUE;

        for(Sale s:saleslist)
        {
          double salesamount=s.gettotalsale();
          totalsales=totalsales+salesamount;

          if(salesamount>highestsale)
          {
            highestsale=salesamount;
          }
          if(salesamount<lowestsale)
          {
            lowestsale=salesamount;
          }
        }
        double averagesale=totalsales/saleslist.size();

        System.out.println("\n--------------------------------------------");
        System.out.println("---------SALES REPORT--------------");
        System.out.println("-----------------------------------------------");

        System.out.println("total records:"+saleslist.size());
        System.out.println();

        System.out.printf("%-5s %-10s %-12s %-8s %-10s %-12s\n",
        "id","name","product","quantity","price","sale");

        System.out.println("---------------------------------------------------");

        for(Sale s:saleslist)
        {
           System.out.printf("%-5d %-10s %-12s %-8d %-10.2f %-12.2f\n",
    s.id, s.name, s.product, s.quantity, s.price, s.gettotalsale());
        }

        System.out.printf("Total sale:%.2f\n",totalsales);
        System.out.printf("Average sale:%.2f\n",averagesale);
        System.out.printf("highest sale:%.2f\n",highestsale);
        System.out.printf("lowest sale:%.2f\n",lowestsale);
        
    }
}

class Sale
{
    int id;
    String name;
    String product;
    int quantity;
    double price;

    public Sale(int id,String name,String product,int quantity,double price)
    {
        this.id=id;
        this.name=name;
        this.product=product;
        this.quantity=quantity;
        this.price=price;
    }

    public double gettotalsale()
    {
        return quantity*price;
    }
}
