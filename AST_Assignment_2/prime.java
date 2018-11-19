import java.util.*;
import java.lang.Math;
public class prime
{


  public void prime_number_calculation(long upper_limit,long lower_limit)
  {

    int count=0;
    boolean is_prime;

    for (long i=lower_limit;i<=upper_limit;i++)
    {
      is_prime=true;
      for (long j=2;j<=i/2;j++)
      {

        if (i%j==0)
        {

          is_prime=false;
          break;
        }
      }

      if(is_prime)
      {
        if(i!=0)
        {
          System.out.print(i+" ");
        }
      }
    }
    System.out.println(" ");

  }


  public void answers()
  {
    System.out.println("Calculating prime numbers from 0 to Greatest Integer:");
    this.prime_number_calculation(Integer.MAX_VALUE,0);
    System.out.println("Calculating prime numbers from 0 to Greatest long Integer:");
    this.prime_number_calculation(Long.MAX_VALUE,0);
  }
  public static void main(String args[])
  {
    prime obj=new prime();
    obj.answers();
  }
}




class count
{
        public void count(long upper_limit,long lower_limit)
        {
          for (long i=lower_limit;i<upper_limit;i++)
                continue;
        }
        public long time_to_count(long lower_bound,long upper_bound)
        {
          long startTime = System.nanoTime();
          this.count(upper_bound,lower_bound);
          long endTime = System.nanoTime();

          long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
          return duration;
        }
        public void answers()
        {
          int i =5*Integer.MIN_VALUE;
          long j=5*Long.MIN_VALUE;
          while( i<Integer.MAX_VALUE)
          {
            System.out.println("Calculating time to count from smallest Integer to "+ i +" : "+this.time_to_count(Integer.MIN_VALUE,i)/1000000+" ms");
            if(i<0)
            {
              i=i/5;
            }
            else
            {
              i=5*i;
            }
          }
          while(j<Long.MAX_VALUE)
          {
            System.out.println("Calculating time to count from smallest Long Integer to "+ j +" : "+this.time_to_count(Long.MIN_VALUE,j)/1000000+" ms");
            if(j<0)
            {
              j=j/5;
            }
            else
            {
              j=5*j;
            }
           }
        }

        public static void main(String args[])
        {
          count obj=new count();
          obj.answers();
         }

}
