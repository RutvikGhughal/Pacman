import java.io.*;
import java.util.*;
public class user_input
{
    String pdirection="";
    String odirection="";
    public void input()throws IOException
    {
      InputStreamReader read=new InputStreamReader(System.in);
      BufferedReader in=new BufferedReader(read);
      
      String uint="";//uint==User input
      uint=in.readLine();
      for(int n=0;n<uint.length();n++)
      {
          if (uint.charAt(n)=='a')pdirection="west";
          else if (uint.charAt(n)=='s')pdirection="south";
          else if (uint.charAt(n)=='d')pdirection="east";
          else if (uint.charAt(n)=='w')pdirection="north"; 
          
          else if (uint.charAt(n)=='i')odirection="north";  
          else if (uint.charAt(n)=='l')odirection="east";  
          else if (uint.charAt(n)=='k')odirection="south";  
          else if (uint.charAt(n)=='j')odirection="west";  
      }
    }
    
    public String return_pdirection()throws IOException
    {
        input();
        return pdirection;
    }
    public String return_odirection()throws IOException
    {
        input();
        return odirection;
    }
}