public class get_star
{
    public static int main(int[] m)
    {
     int star_count=0;
     for(int n=0;n<196;n++)if(m[n]==3)star_count++;
     return star_count;
    }
}