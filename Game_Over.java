import java.io.*;
import java.util.*;
public class Game_Over
{    
    public static void main(int player_one,int player_two)throws IOException
    {
     String g_over[]={"G","A","M","E"," ","O","V","E","R",".",".",".",".",".",".",".",".",".",".",".",".","."};
    for(int i=0;i<99999999;i++);   
     for(int a=0;a<g_over.length;a++)//nested loop is used to delete any user input
     {
     System.out.print('\u000C');
     for(int n=0;n<a;n++)
     {
        System.out.print(g_over[n]);
     }
     for(int i=0;i<99999999;i++);
    }
    for(int m=0;m<4;m++) for(int i=0;i<99999999;i++);   
     System.out.println('\u000C');
     System.out.println("\t\t\t  POINTS");
     System.out.println("\t\tPlayer 1           Player 2");
     System.out.println("\t\t   "+player_one+"                   "+player_two);
     
     if(player_one==player_two)System.out.print("\nIT'S A DRAW!!!!");
     else if(player_one<player_two)     System.out.print("\nPLAYER 2,YOU WIN!!!!");
     else if(player_one>player_two)     System.out.print("\nPLAYER 1,YOU WIN!!!!");
    }
}