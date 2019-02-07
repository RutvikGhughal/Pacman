import java.io.*;
public class hangman
{
public static String word="";
public static void main()throws IOException
{
 InputStreamReader read=new InputStreamReader(System.in);
 BufferedReader in=new BufferedReader(read);
 get_word();
 System.out.print('\u000C');
 
 char alphabet[]=new char[26];
 char mark[]=new char[word.length()];
 for(int i=0;i<mark.length;i++)mark[i]='_';
 
 int chance=5;
 String input="";
 boolean game_status=true;

 hang_print print=new hang_print();
 boolean present=false;
 boolean done=false;
 boolean duplicate=false;
 int alphabet_part=0;
 boolean given=false;
 while(game_status==true)   
 {
  System.out.print('\u000C');for(int i=0;i<mark.length;i++)System.out.print(mark[i]+" ");     //to print mark-array
  System.out.print("      ");
  given=false;
  if (chance==5){}                                            //to print man according to chances left
  else if (chance==4){print.chance_5();}
  else if (chance==3){print.chance_4();}
  else if (chance==2){print.chance_3();}
  else if (chance==1){print.chance_2();}
  else if (chance==0)
  {
      print.hangman();game_status=false;
      System.out.println("YOU LOSE :The word was '"+word+"'");
  }
  
  for(int i=0;i<alphabet_part;i++)System.out.print(alphabet[i]+"  "); 
  
  if(chance!=0)input=in.readLine();
  present=false;              //to assume input is not present
 
  duplicate=false;
  if(input.length()==1)
  {
    
     for(int i=0;i<alphabet_part;i++)
    {
        if(duplicate==false)
    {
        if(alphabet[i]==input.charAt(0))
        {
            duplicate=true;given=true;
        }
    }
    }
    
    if(duplicate==false)
    {
    alphabet[alphabet_part]=input.charAt(0);
    alphabet_part++;
    }
  }
  

  if(given==false)
  {
  for(int a=0;a<=(word.length()-input.length());a++)
  {
   if(input.equalsIgnoreCase(word.substring(a,a+input.length())))
   {
       present=true;
       for(int i=a;i<a+input.length();i++)mark[i]=word.charAt(i);
   } 
  }
  if(present==false)chance=chance-1;                    
 }
    done=false;
    for(int i=0;i<mark.length;i++)
    {
        if(done==false)
    {
        if(mark[i]=='_')
        {
            done=true;
        }
    }
    }
    
    if(done==false)
    {
        game_status=false;
        System.out.print('\u000C');
        System.out.print("WOW!!You guessed it!!!!");
    }
  }

  
 } 
 
 //int temp=Integer.parseInt(in.readLine());

    
public static void get_word()throws IOException
{
 InputStreamReader read=new InputStreamReader(System.in);
 BufferedReader in=new BufferedReader(read);
 
 System.out.print('\u000C');
 System.out.print("Player 1,please give the word:");
 word=in.readLine();
}

}