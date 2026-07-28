//////////////////////////////////////////////////////////////////////////////////////
///
///  PROBLEM STATEMENT
///  3.encrypt and decrypt text files using basic algorithm
///   Author Name:Shubham Isai
///
/// ///////////////////////////////////////////////////////////////////////////////////

// SOLUTION:
import java.io.*;
public class Task3 
{
    public static void main(String args[])
    {
        String  inputfile="input.txt";
        String encryptfile="encrypted.txt";
        String decryptedfile="decrypted.txt";
        encryptfile(inputfile,encryptfile);
        decryptfile(encryptfile,decryptedfile);
        System.out.println("encryption and decryption completed successfully:");
    }
    public static void encryptfile(String input,String output)
    {
      try
      {
         FileReader fr=new FileReader(input);
         BufferedReader br=new BufferedReader(fr);
         FileWriter fw=new FileWriter(output);
         BufferedWriter bw=new BufferedWriter(fw);
         int ch;
         while((ch=br.read())!=-1)
         {
            ch=ch+3;
            bw.write(ch);
         }
         br.close();
         bw.close();
         System.out.println("file encrypted successfully");
      }
      catch(Exception e)
      {
        System.out.println(e);
      }
    }
    public static void decryptfile(String input,String output)
    {
        try
        {
          FileReader fr=new FileReader(input);
          BufferedReader br=new BufferedReader(fr);

          FileWriter fw=new FileWriter(output);
          BufferedWriter bw=new BufferedWriter(fw);

          int ch;
          while((ch=br.read())!=-1)
          {
            ch=ch-3;
            bw.write(ch);
          }
          br.close();
          bw.close();
        System.out.println("file decrypted successfully:");
        }
    catch(Exception e)
    {
        System.out.println(e);
    }
}
}
