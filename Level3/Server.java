////////////////////////////////////////////////////////////////////////////////////////
///
/// 
///  Server Side program
///  Author:Shubham Isai
/// 
////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////
/// 
///  ALOGORITHM:
///  1) create server socket on port 5000
///  2) wait for the client ussing accept()
///  3) create input and output streams
///  4) read the client message
///  5) Display the message
///  6) read the reply from the keyboard
///  7) send the reply to the client
///  8) repeat until "end" is entered
///  9) close all resources
///
///////////////////////////////////////////////////////////////////////////////////////////

///  SOLUTION

import java.net.*;
import java.io.*;

public class Server 
{
    public static void main(String args[])
    {
        try
        {
        ServerSocket sobj=new ServerSocket(6000);
        System.out.println("Server started.....");
        Socket socket=sobj.accept();
        System.out.println("client connected....");
        BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bobj=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter response=new PrintWriter(socket.getOutputStream(),true);

        String Message;
        while(true)
        {
            Message=bobj.readLine();
            if(Message.equalsIgnoreCase("end"))
            {
                System.out.println("client disconnected...");
                break;
            }
            System.out.println("Client:"+Message);
            System.out.println("Server:");
            String Reply=keyboard.readLine();
            response.println(Reply);
        }
        sobj.close();
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
