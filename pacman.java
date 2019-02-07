import java.io.*;
import java.util.*;
public class pacman
{
    public static int[] mark=new int[196];
    String odirection;
    String pdirection;
    boolean game_status;
    int pacman_points=0;
    int pacman_life=0;
    int player_one=0;
    int player_two=0;
    int p=0;int o=0;                   //change pacman and opponent place
    int round=1;
    int round_part=2;
    public void main()throws IOException
    {
      print();
    }
    
    public static void mark_assign()
    {
      for(int n=0;n<196;n++)mark[n]=3;                                          //to give * to everything 

      mark[167]=9;mark[29]=4;                                              //to make space for opponent and eater
      for(int n=1;n<=15;n++)mark[n]=0;                                      //make first horizontal
      for(int n=1;n<=181;n+=15)mark[n]=0;                                   //make first vertical
      for(int n=15;n<=195;n+=15)mark[n]=0;                                  //make second verctical
      for(int n=181;n<=195;n++)mark[n]=0;                               //make second horizontal
      
      mark[33]=2;mark[34]=2;mark[35]=2;
      
      mark[23]=2;mark[38]=2;mark[53]=2;
      
      mark[40]=2;mark[41]=2; mark[56]=2; mark[57]=2; mark[58]=2;mark[71]=2;mark[73]=2;
      
      mark[62]=2;mark[63]=2;mark[64]=2;mark[65]=2;mark[77]=2;mark[80]=2;mark[92]=2;
      mark[95]=2;mark[95]=2;mark[107]=2;mark[122]=2;mark[137]=2;mark[138]=2;
      
      mark[82]=2;mark[83]=2;mark[84]=2;mark[99]=2;
      
      mark[102]=2;mark[103]=2;
      
      mark[125]=2;mark[126]=2;mark[127]=2;mark[140]=2;
      
      mark[130]=2;mark[131]=2;mark[144]=2;mark[145]=2;mark[159]=2;
      
      mark[162]=2;mark[163]=2;
      
      mark[157]=2;mark[170]=2;mark[171]=2;mark[172]=2;
    }
       
    public void print()throws IOException
    {
     mark_assign();   
     game_status=true;
     
     get_places object=new get_places();
     p=object.get_PacmanPlace();
     o=object.get_OpponentPlace();
     get_star star=new get_star();
     
    start();
      while(game_status)
     {
                p=object.get_PacmanPlace();
                o=object.get_OpponentPlace();
             if(pdirection=="west")
             {
               if((mark[p]==11)||((mark[p]==12)||(mark[p]==10)||(mark[p]==13)))mark[p]=9;
               else mark[p]=11;
             }
             
             if (pdirection=="north")
             {
               if((mark[p]==9)||((mark[p]==9)||(mark[p]==10)||(mark[p]==11)))mark[p]=12;
               else mark[p]=9;
             }
             
             if (pdirection=="south")
             {
               if((mark[p]==9)||((mark[p]==9)||(mark[p]==10)||(mark[p]==11)))mark[p]=13;
               else mark[p]=9;
             }
             
             if(pdirection=="east")
             {
               if((mark[p]==10)||((mark[p]==11)||(mark[p]==12)||(mark[p]==13)))mark[p]=9;
               else mark[p]=10;
             }
            
             if(odirection=="west")
             {
               if((mark[o]==5)||((mark[o]==6)||(mark[o]==7)||(mark[o]==8)))mark[o]=4;
               else mark[o]=5;
             }
             
             if((odirection=="north")||(odirection=="south"))
             {
               if((mark[o]==8)||((mark[o]==4)||(mark[o]==5)||(mark[o]==6)))mark[o]=7;
               else mark[o]=8;
             }
             
             if(odirection=="east")
             {
               if((mark[o]==6)||((mark[o]==5)||(mark[o]==7)||(mark[o]==8)))mark[o]=4;
               else mark[o]=6;
             }
            System.out.println('\u000C');
  
     for(int n=1;n<196;n++)
     {
      
        if(mark[n]==0)System.out.print("||");
        if(mark[n]==1)System.out.print("  ");
        if(mark[n]==2)System.out.print("||");
        if(mark[n]==3)System.out.print("* ");
        if(mark[n]==4)System.out.print("= ");
        if(mark[n]==5)System.out.print("> ");
        if(mark[n]==6)System.out.print("< ");
        if(mark[n]==7)System.out.print("{ ");
        if(mark[n]==8)System.out.print("} ");
        if(mark[n]==9)System.out.print("o ");
        if(mark[n]==10)System.out.print("( ");
        if(mark[n]==11)System.out.print(") ");
        if(mark[n]==12)System.out.print("U ");
        if(mark[n]==13)System.out.print("n ");
        
        if(n%15==0) System.out.println();
     }
     System.out.println("\t\t\t  POINTS");
     System.out.println("\t\tPACMAN           PACMAN LIFE");
     System.out.println("\t\t   "+pacman_points+"                   "+round_part);

     pacman_change();
     opponent_change();
    }
    System.out.println('\u000C');
    
    Game_Over over=new Game_Over();
    over.main(player_one,player_two);
    }
    
     public void pacman_change()throws IOException
 {
      user_input obj=new user_input();
      pdirection=obj.return_pdirection();
    
     get_places obj1=new get_places();
     p=obj1.get_PacmanPlace();
     o=obj1.get_OpponentPlace();
      if(pdirection=="west")
      if((mark[p-1]!=0)&&(mark[p-1]!=2))
      {
          if(mark[p-1]==3){pacman_points++;mark[p-1]=1;}
          if((mark[p-1]==4)||(mark[p-1]==5)||(mark[p-1]==6)||(mark[p-1]==7)||(mark[p-1]==8))//in case pacman and eater meet
          {
                  mark[p]=1;mark[o]=1;
                  mark[167]=9;mark[29]=4;
                  
                  round_part--;
                  if(round_part==0){round++;round_part=2;}
                  if((round==2)&&(round_part==2)){player_one=pacman_points;mark_assign();intermediate();pacman_points =0;}
                  if(round==3){player_two=pacman_points;game_status=false;}
                  
           }
          else
          {
          int temp=mark[p];
          mark[p]=1;
          mark[p-1]=temp;
          }
      }
      
      if(pdirection=="east")
      if((mark[p+1]!=0)&&(mark[p+1]!=2))
      {
          if(mark[p+1]==3){pacman_points++;mark[p+1]=1;}
          if((mark[p+1]==4)||(mark[p+1]==5)||(mark[p+1]==6)||(mark[p+1]==7)||(mark[p+1]==8))//in case pacman and eater meet
          {
                  mark[p]=1;mark[o]=1;
                  mark[167]=9;mark[29]=4;
                   round_part--;
                  if(round_part==0){round++;round_part=2;}
                  if((round==2)&&(round_part==2)){player_one=pacman_points;mark_assign();intermediate();pacman_points =0;}
                  if(round==3){player_two=pacman_points;game_status=false;}
          }
          else
          {
          int temp=mark[p];
          mark[p]=1;
          mark[p+1]=temp;
          }
      }
      
      if(pdirection=="north")
      if((mark[p-15]!=0)&&(mark[p-15]!=2))
      {
          if(mark[p-15]==3){pacman_points++;mark[p-15]=1;}
          if((mark[p-15]==4)||(mark[p-15]==5)||(mark[p-15]==6)||(mark[p-15]==7)||(mark[p-15]==8))//in case pacman and eater meet
          {
                  mark[p]=1;mark[o]=1;
                  mark[167]=9;mark[29]=4;
                  round_part--;
                  if(round_part==0){round++;round_part=2;}
                  if((round==2)&&(round_part==2)){player_one=pacman_points;mark_assign();intermediate();pacman_points =0;}
                  if(round==3){player_two=pacman_points;game_status=false;}
          }
  
          else
          {
          int temp=mark[p];
          mark[p]=1;
          mark[p-15]=temp;
          }
      }
      
       if(pdirection=="south")
      if((mark[p+15]!=0)&&(mark[p+15]!=2))
      {
          if(mark[p+15]==3){pacman_points++;mark[p+15]=1;}
          if((mark[p+15]==4)||(mark[p+15]==5)||(mark[p+15]==6)||(mark[p+15]==7)||(mark[p+15]==8))//in case pacman and eater meet
          {
                  mark[o]=1;mark[p]=1;
                  mark[167]=9;mark[29]=4;
                  round_part--;
                  if(round_part==0){round++;round_part=2;}
                  if((round==2)&&(round_part==2)){player_one=pacman_points;mark_assign();intermediate();pacman_points =0;}
                  if(round==3){player_two=pacman_points;game_status=false;}
          }

          else
          {
          int temp=mark[p];
          mark[p]=1;
          mark[p+15]=temp;
          }
      }
 }

 public  void opponent_change()throws IOException
 {
    user_input obj=new user_input();
    odirection=obj.return_odirection();
   
     get_places obj1=new get_places();
     p=obj1.get_PacmanPlace();
     o=obj1.get_OpponentPlace();
    if(odirection=="south")
    {
      if((mark[o+15]!=0)&&(mark[o+15]!=2))
      {
          if((mark[o+15]==9)||(mark[o+15]==10)||(mark[o+15]==11)||(mark[o+15]==12)||(mark[o+15]==13))//in case pacman and eater meet
          {

                  mark[p]=1;mark[o]=1;
                  mark[167]=9;mark[29]=4;
                 round_part--;
                  if(round_part==0){round++;round_part=2;}
                  if((round==2)&&(round_part==2)){player_one=pacman_points;mark_assign();intermediate();pacman_points =0;}
                  if(round==3){player_two=pacman_points;game_status=false;}
           
          }
          else
          {
          int temp=mark[o];
          mark[o]=3;
          mark[o+15]=temp;
          }
      }
    }
   
    if(odirection=="north")
    {
      if((mark[o-15]!=0)&&(mark[o-15]!=2))
      {
          if((mark[o-15]==9)||(mark[o-15]==10)||(mark[o-15]==11)||(mark[o-15]==12)||(mark[o-15]==13))//in case pacman and eater meet
          {

                  mark[p]=1;mark[o]=1;
                  mark[167]=9;mark[29]=4;
                  round_part--;
                  if(round_part==0){round++;round_part=2;}
                  if((round==2)&&(round_part==2)){player_one=pacman_points;mark_assign();intermediate();pacman_points =0;}
                  if(round==3){player_two=pacman_points;game_status=false;}
           
          }       
          else
          {
          int temp=mark[o];
          mark[o]=3;
          mark[o-15]=temp;
          }
      }
    }

    if(odirection=="east")
    {
      if((mark[o+1]!=0)&&(mark[o+1]!=2))
      {
          if((mark[o+1]==9)||(mark[o+1]==10)||(mark[o+1]==11)||(mark[o+1]==12)||(mark[o+1]==13))//in case pacman and eater meet
          {

                  mark[o]=1;mark[p]=1;
                  mark[167]=9;mark[29]=4;
                  round_part--;
                  if(round_part==0){round++;round_part=2;}
                  if((round==2)&&(round_part==2)){player_one=pacman_points;mark_assign();intermediate();pacman_points =0;}
                  if(round==3){player_two=pacman_points;game_status=false;}
            
          }   
          else
          {
          int temp=mark[o];
          mark[o]=3;
          mark[o+1]=temp;
          }
      }
    }
    
    if(odirection=="west")
    {
      if((mark[o-1]!=0)&&(mark[o-1]!=2))
      {
          if((mark[o-1]==9)||(mark[o-1]==10)||(mark[o-1]==11)||(mark[o-1]==12)||(mark[o-1]==13))//in case pacman and eater meet
           {
                  mark[o]=1;mark[p]=1;
                  mark[167]=9;mark[29]=4;
                  round_part--;
                  if(round_part==0){round++;round_part=2;}
                  if((round==2)&&(round_part==2)){player_one=pacman_points;mark_assign();intermediate();pacman_points =0;}
                  if(round==3){player_two=pacman_points;game_status=false;}
              
          }
          else
          {
          int temp=mark[o];
          mark[o]=3;
          mark[o-1]=temp;
          }
      }
    }
 }
 
 void intermediate()throws IOException
 {
     InputStreamReader read=new InputStreamReader(System.in);
     BufferedReader in=new BufferedReader(read);
       for(int m=0;m<5;m++) for(int i=0;i<99999999;i++);  
  System.out.print('\u000C');
  System.out.println("Change sides");
  System.out.println("Player one points- "+player_one);
   for(int m=0;m<5;m++) for(int i=0;i<99999999;i++);  
  System.out.println("Type ENTER to continue");
  String input=in.readLine();

 }
 
 void start()throws IOException
 {
         InputStreamReader read=new InputStreamReader(System.in);
     BufferedReader in=new BufferedReader(read);
   for(int m=0;m<5;m++) for(int i=0;i<99999999;i++);  
  System.out.print('\u000C');
  System.out.println("Player one is pacman in first round");
   for(int m=0;m<5;m++) for(int i=0;i<99999999;i++);  
  System.out.println("Type ENTER to continue");
  String input=in.readLine();

 }
}
