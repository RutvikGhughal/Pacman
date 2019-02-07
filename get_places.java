import java.io.*;
import java.util.*;
public class get_places
{
    public static int get_OpponentPlace()
    {
     int mark[]=new int[196];
     pacman get_OpponentPlaceNeed=new pacman();   //to create instance of class pacman to get value of mark
     mark=get_OpponentPlaceNeed.mark;             //mark here=mark there 
     int eater_place=0;
     for(int n=0;n<196;n++)
     {
        if ((mark[n]==4)||(mark[n]==5)||(mark[n]==6)||(mark[n]==7)||(mark[n]==8))
        {
          eater_place=n;
        }
    } 
    return eater_place;
    } 
    
    public static int get_PacmanPlace()
    {
     int mark[]=new int[196]; 
     pacman get_PacmanPlaceNeed=new pacman();   //to create instance of class pacman to get value of mark 
     mark=get_PacmanPlaceNeed.mark;             //mark here=mark there
     int pacman_place=0;
     for(int n=0;n<196;n++)
    {
         if ((mark[n]==9)||(mark[n]==10)||(mark[n]==11)||(mark[n]==12)||(mark[n]==13))
         {
            pacman_place=n;
         }
    }
    return pacman_place;
    }

}
