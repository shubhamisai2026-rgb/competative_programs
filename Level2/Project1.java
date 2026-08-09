////////////////////////////////////////////////////////////////////////////////////////
///
/// 
///  Task1.Tic-Tac-Toe game
///  Author:Shubham Isai
/// 
////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////
/// 
///  ALOGORITHM:
///  1) create the 3 * 3 character array
///  2) display the game board
///  3) player x enters a position
///  4) convert the position into row and column
///  5) check weather the position is already occupied
///  6) store the players symbol
///  7) check all rows,columns,and diagonals for a winner
///  8) if a player wins,display the winner
///  9) if all 9 moves are completed without a winning declare a draw
///
///////////////////////////////////////////////////////////////////////////////////////////

///  SOLUTION

import java.util.Scanner;
public class Project1 
{
    static char board[][]={{'1','2','3'},{'4','5','6'},{'7','8','9'}};
    public static void printboard()
    {
      System.out.println();
      for(int i=0;i<3;i++)
      {
        for(int j=0;j<3;j++)
        {
            System.out.print(" "+board[i][j]+" ");
            if(j<2)
            {
                System.out.print("|");
            }
        }
            System.out.println();
            if(i<2)
            {
                System.out.println("----------");
            }
        System.out.println();
      }
    }

    public static boolean checkwinner(char player)
    {
        for(int i=0;i<3;i++)
        {
            if(board[i][0]==player && board[i][1]==player && board[i][2]==player)
            {
                return true;
            }
            if(board[0][i]==player && board[1][i]==player && board[2][i]==player)
            {
                return true;
            }
            if(board[0][0]==player && board[1][1]==player && board[2][2]==player)
            {
               return true;
            }
            if(board[0][2]==player && board[1][1]==player && board[2][0]==player)
            {
              return true;
            }
        }
        return false;
    }

    public static void main(String args[])
    {
        Scanner sobj=new Scanner(System.in);
        char player='x';
        for(int move=1;move<=9;move++)
        {
            printboard();
            System.out.println("player"+player+"enter a position(1-9):");
            int pos=sobj.nextInt();
            int row=(pos-1)/3;
            int col=(pos-1)%3;
            if(board[row][col]=='x' || board[row][col]=='o')
            {
                System.out.println("position already occupied...");
                move--;
                continue;
            }
            board[row][col]=player;
            if(checkwinner(player))
            {
                printboard();
                System.out.println("player"+player+"wins!");
                sobj.close();
                return;
            }
            if(player=='x')
            {
                player='o';
            }
            else
            {
                player='x';
            }
        }
        printboard();
        System.out.println("Match Draw..!");
        sobj.close();
    }
   
}
