//////////////////////////////////////////////////////////////////////////////////////
///
///  PROBLEM STATEMENT
///  2.Develop a two  player console tic-tac-toe game
///   Author Name:Shubham Isai
///
/// ///////////////////////////////////////////////////////////////////////////////////

// SOLUTION:

import java.util.Scanner;
public class Task1 
{
    static char board[][]={{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
    public static void main(String args[])
    {
        Scanner sobj=new Scanner(System.in);
        char currentplayer='X';
        int movecount=0;
        boolean gameover=false;
        while(!gameover)
        {
            displayboard();
            System.out.println("player"+currentplayer+"enter position(1-9):");
            int pos=sobj.nextInt();
            if(placemove(pos,currentplayer))
            {
               movecount++;
            if(checkwinner(currentplayer))
            {
                displayboard();
                System.out.println("\nplayer" + currentplayer + "wins!");
                gameover=true;
            }
            else if(movecount==9)
            {
                displayboard();
                System.out.println("\n match draw!");
                gameover=true;
            }
            else
            {
                if(currentplayer=='X')
                {
                    currentplayer='O';
                }
                else
                {
                    currentplayer='X';
                }
            }
            }
            else
            {
                System.out.println("invalis move! try again:");
            }
        }
sobj.close();

    }

public static void displayboard()
{
    System.out.println("-----------------+----------------+-------------------");
    for(int i=0;i<3;i++)
    {
        System.out.print("|");
        for(int j=0;j<3;j++)
        {
            System.out.print("        "+board[i][j]+"        ");
            if(j<=2)
            {
                System.out.print("|");
            }

        }
        System.out.println();
        if(i<2)
        {
            System.out.println("------------------+---------------+-------------------");
        }
    }
    System.out.println("-----------------+----------------+-------------------");
}

public static boolean placemove(int pos,char symbol)
{
    switch(pos)
    {
        case 1:
            if(board[0][0]!='X' && board[0][0]!='O')
            {
                board[0][0]=symbol;
                return true;
            }
            break;
        
        case 2:
            if(board[0][1]!='X' && board[0][1]!='O')
            {
                board[0][1]=symbol;
                return true;
            }
            break;
        
        case 3:
            if(board[0][2]!='X' && board[0][2]!='O')
            {
                board[0][2]=symbol;
                return true;
            }
            break;
        
        case 4:
            if(board[1][0]!='X' && board[1][0]!='O')
            {
                board[1][0]=symbol;
                return true;
            }
            break;
        
        case 5:
            if(board[1][1]!='X' && board[1][1]!='O')
            {
                board[1][1]=symbol;
                return true;
            }
            break;
         
        case 6:
            if(board[1][2]!='X' && board[1][2]!='O')
            {
                board[1][2]=symbol;
                return true;
            }
            break;
        
        case 7:
            if(board[2][0]!='X' && board[2][0]!='O')
            {
                board[2][0]=symbol;
                return true;
            }
            break;
        
        case 8:
            if(board[2][1]!='X' && board[2][1]!='O')
            {
                board[2][1]=symbol;
                return true;
            }
            break;
        
         case 9:
            if(board[2][2]!='X' && board[2][2]!='O')
            {
                board[2][2]=symbol;
                return true;
            }
            break;
        
        default:
            return false;
    }
    return false;
}

public static boolean checkwinner(char symbol)
{
    for(int i=0;i<3;i++)
    {
        if(board[i][0]==symbol && board[i][1]==symbol && board[i][2]==symbol)
        {
            return true;
        }
    }

    for(int j=0;j<3;j++)
    {
        if(board[0][j]==symbol && board[1][j]==symbol && board[2][j]==symbol)
        {
            return true;
        }
    }

    if(board[0][0]==symbol && board[1][1]==symbol && board[2][2]==symbol)
    {
        return true;
    }

    if(board[0][2]==symbol && board[1][1]==symbol && board[2][0]==symbol)
    {
        return true;
    }
    return false;
}

}