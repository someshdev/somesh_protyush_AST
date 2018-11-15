
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
    System.out.println("Calculating prime numbers from 0 to Greatest Integer:");
    //this.prime_number_calculation(Integer.MAX_VALUE,0);
    System.out.println("Calculating prime numbers from 0 to Greatest long Integer:");
    //this.prime_number_calculation(Long.MAX_VALUE,0);
    System.out.println("Calculating time to count from smallest Integer to Greatest Integer: "+this.time_to_count(Integer.MIN_VALUE,Integer.MAX_VALUE)/1000000+" ms");
    System.out.println("Calculating time to count from smallest Long Integer to Greatest Long Integer: "+this.time_to_count(Long.MIN_VALUE,Long.MAX_VALUE)/1000000+" ms");
  }
  public static void main(String args[])
  {
    prime obj=new prime();
    obj.answers();
  }
}
