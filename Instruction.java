import java.io.*;
import java.util.*;
public class Instruction
{
public static void main()throws IOException
{
 System.out.print('\u000C');    
 System.out.println("\t\t\t\tINSTRUCTIONS/CONTROLS");
 System.out.println();
 System.out.println();
 System.out.println("\tFOR PACMAN:-");
 System.out.println();
 System.out.println("'W'-to move up");
 System.out.println("'S'-to move down");
 System.out.println("'A'-to move left");
 System.out.println("'D'-to move right");
 System.out.println();
 System.out.println("\tFOR PACMAN EATER:-");
 System.out.println();
 System.out.println("'I'-to move up");
 System.out.println("'K'-to move down");
 System.out.println("'J'-to move left");
 System.out.println("'L'-to move right");
 System.out.println("\nNOTE:Don't forget to keep on pressing enter button");
 System.out.println("\nPOINTS SYSTEM:");
 System.out.println("Each player has two lives");
 System.out.println("There are two Rounds");
 System.out.println("In First Round: player 1 eats as many * as he can ");
 System.out.println("In Second Round: player 2 eats as many * as he can ");
  InputStreamReader read=new InputStreamReader(System.in);
  BufferedReader in=new BufferedReader(read);
  System.out.println();
  System.out.println("Type ENTER to continue");
  String input=in.readLine();
  pacman start=new pacman();
  start.main();

}
}