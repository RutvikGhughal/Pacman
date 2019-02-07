import java.io.*;
import java.util.*;
public class Start
{
    public static void pacman_main()throws IOException
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        String loading[]={"L","O","A","D","I","N","G"," ","P","A","C","M","A","N",""};
         for(int a=0;a<loading.length;a++)//nested loop is used to delete any user input
     {
     System.out.print('\u000C');
     for(int n=0;n<a;n++)
     {
        System.out.print(loading[n]);
     }
     for(int i=0;i<99999999;i++);
    }
    
             for(int a=0;a<6;a++)//nested loop is used to delete any user input
     {
     System.out.print('\u000C');
     System.out.print("LOADING PACMAN");
     for(int n=0;n<a;n++)
     {
        System.out.print(".");
     }
     for(int i=0;i<99999999;i++);
    }
    for(int i=0;i<99999999;i++);

        production start=new production();
        start.main();   
    }
 


    public static void read()throws IOException
    {
       InputStreamReader read =new InputStreamReader(System.in);
       BufferedReader in =new BufferedReader(read);
       String choice[] ={"play","pacman","playing","packman","hangman"};
       System.out.println("What do you want to do ?(play pacman or hangman)");
       String uint=in.readLine();
       
       hangman_production next=new hangman_production();
        x:for(int n=0;n< choice.length ;n++)
        {
           if (uint.toLowerCase().indexOf(choice[n])!=-1)
           {
              
                 switch (choice[n].toLowerCase())
                {
                  case"pacman":case"packman":
                  pacman_main();
                  break x;
                  case "hangman":
                  next.main();
                  break x;
                }
        
            }
    
        }
      }


}