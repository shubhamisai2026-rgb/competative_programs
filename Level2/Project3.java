////////////////////////////////////////////////////////////////////////////////////////
///
/// 
///  Task3. Encryption and Decryption file
///  Author:Shubham Isai
/// 
////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////
/// 
///  ALOGORITHM:
///  ENCRYPTION:                                               DECRYPTION
/// 
///  1) start the program                                 1)open the encrypted file
///  2) open the input file                               2)read one character at a time
///  3) read one character at a time                      3)suntract from each characer
///  4) add 3 to the ASCII value of each character        4)wwrite the result into the decrypted file
///  5) write the new character into the encrypted file   5)Repeat until end of file
///  6) repeat until the end of the file                  6)close but files
///  7) close of the both files                           7)display "decryption successful"
///  8) Display "Encryption successful"                   8)end of the program
///   
///
///////////////////////////////////////////////////////////////////////////////////////////

///  SOLUTION

////////////////////////////////////////////////////////////////////////////////////////////
/// 
/// 
///  import the inbuid libraries
/// 
/// /////////////////////////////////////////////////////////////////////////////////////////

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

////////////////////////////////////////////////////////////////////////////////////////////////
/// 
///  main class of the program
/// 
/////////////////////////////////////////////////////////////////////////////////////////////////

public class Project3 {
    public static void main(String args[]) {
        try {
            FileReader fr = new FileReader("input.txt");
            FileWriter fw = new FileWriter("encrypted.txt");
            int ch;
            while ((ch = fr.read()) != -1) {
                fw.write(ch + 3);
            }   
            fr.close();
            fw.close();
            System.out.println("Encryption successful.");

            FileReader fr2 = new FileReader("encrypted.txt");
            FileWriter fw2 = new FileWriter("decrypted.txt");
            while ((ch = fr2.read()) != -1) {
                fw2.write(ch - 3);
            }
            fr2.close();
            fw2.close();
            System.out.println("Decryption Successfule");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
