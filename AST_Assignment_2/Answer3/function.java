import java.util.*;
import java.lang.Math;
import java.math.*;
import java.math.BigDecimal;
import java.text.*;

public class function
{
    public double part2_calculation(double n)
    {
      return (n/(1-n));
    }
    public double function_calculation(int k,int n)
    {
      double prod=1.0,o1=0.5,o2=0.9,o3=0.1;
      for (int i=1;i<=n;i++)
      {
        if(i==1)
        {
          prod=prod*part2_calculation(o1);
        }
        else if(i>1 && i<k)
        {
          prod=prod*part2_calculation(o2);
        }
        else
        {
          prod=prod*part2_calculation(o3);
        }
      }

      double function_result=1-Math.pow((1+prod),-1);
      return function_result;
    }

    public void answer()
    {
        int[] k={10,100,1000,10000};
        int[] n={20,120,1200,10200};
        System.out.println("Calculating function :");
        for (int i=0;i<k.length;i++)
        {
          System.out.println("Value of function is: "+function_calculation(k[i],n[i]));
        }

    }
    public static void main(String[] args)
      {

        function obj=new function();
        obj.answer();



      }


}
