////////////////////////////////////////////////////////////////////////////////////////
///
/// 
///  Client side program 
///  Author:Shubham Isai
/// 
////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////
/// 
///  ALOGORITHM:
///  1) connect to the server using socket
///  2) create input and output streams
///  3) read the message from the keyboard
///  4) send the message to the server
///  5) receives the servers reply
///  6) display the reply
///  7) repeat until "end" is entered
///  8)close all resources
///  
///////////////////////////////////////////////////////////////////////////////////////////

///  SOLUTION

import java.net.*;
import java.io.*;

public class Client
{
    public static void main(String args[])
    {
        try
        {
            Socket socket=new Socket("localhost",6000);
            System.out.println("connected to the server....");
            BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
            BufferedReader bobj=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter response=new PrintWriter(socket.getOutputStream(),true);

            String Message;
            while(true)
            {
                 
                  System.out.println("Client:");
                Message=keyboard.readLine();
                response.println(Message);
                 
                String reply=bobj.readLine();
                if(reply.equalsIgnoreCase("end"))
                {
                    System.out.println("server Disconnected...");
                    break;
                }
                System.out.println("Server:"+reply);
            }
            bobj.close();
            response.close();
            keyboard.close();
            socket.close();    
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}