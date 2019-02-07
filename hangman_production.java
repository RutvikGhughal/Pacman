import java.io.*;
import java.util.*;
public class hangman_production
{
    public static void main()throws IOException
    {
     String production[]={"R","U","T","V","I","K"," ","A","N","I","M","A","T","I","O","N","S"," "};
     String presents[]={"P","R","E","S","E","N","T","S",""};
     String pacman[]={"H","A","N","G","M","A","N",""};
    for(int i=0;i<99999999;i++);     
     for(int a=0;a<production.length;a++)//nested loop is used to delete any user input
     {
     System.out.print('\u000C');
     System.out.print( "\t\t\t\t");
     for(int n=0;n<a;n++)
     {
        System.out.print(production[n]);
     }
     for(int i=0;i<99999999;i++);
    }
    
     for(int a=0;a<presents.length;a++)//nested loop is used to delete any user input
     {
     System.out.print('\u000C');
     System.out.println( "\t\t\t\tRUTVIK ANIMATIONS");
     System.out.print( "\t\t\t\t    ");
     for(int n=0;n<a;n++)
     {
        System.out.print(presents[n]);
     }
     for(int i=0;i<99999999;i++);
    }    
    
     for(int a=0;a<pacman.length;a++)//nested loop is used to delete any user input
     {
     System.out.print('\u000C');
     System.out.println( "\t\t\t\tRUTVIK ANIMATIONS");
     System.out.println( "\t\t\t\t    PRESENTS");
     System.out.println();
     System.out.print( "\t\t\t\t   ");
     
     for(int n=0;n<a;n++)
     {
        System.out.print(pacman[n]);
     }
     for(int i=0;i<99999999;i++);
    }   
    for(int i=0;i<99999999;i++);
    for(int i=0;i<99999999;i++);
     hangman next=new hangman();
     next.main();
    }
}