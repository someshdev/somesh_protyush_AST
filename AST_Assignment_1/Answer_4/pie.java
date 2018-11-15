import java.util.*;
import java.lang.Math;
import java.math.*;
import java.math.BigDecimal;
import java.text.*;
public class pie
{
    public double Area(double pi,double radius)
    {
      return (double)(pi*radius*radius);
    }
    public double Circumference(double pi,double radius)
    {
      return (double)(2*pi*radius);
    }
    public void pi_iteration()
    {
      int precision=0;
      double radius=0.0,previous_value_area=0.0,area_change=0.0,previous_value_circum=0.0,circum_change=0.0;
      boolean ch=true;

      while(ch)
      {
        try
        {
          Scanner sc=new Scanner(System.in);
          System.out.println("Enter the Diameter of circle:");
          radius = (sc.nextFloat())/2;
          System.out.println("Enter the precision limit in Integers(MAX=15):");
          precision = sc.nextInt();
          ch=false;
        }
        catch(Exception e)
        {
          ch=true;
          System.out.println("Error in data type:"+e);
          System.out.println("Retrying......");

        }

      }

      if (precision>15)
      {
        precision=10;
      }

      System.out.println("Showing Results:");

      for(int i=1;i<=precision;i++)
      {
        BigDecimal value = new BigDecimal(Math.PI).setScale(i, RoundingMode.DOWN);
        double pi=value.doubleValue();
        double area=this.Area(pi,radius);
        if (previous_value_area==0.0)
        {
          previous_value_area=area;
        }
        else
        {
          area_change=((area-previous_value_area)/previous_value_area)*100;
          previous_value_area=area;

        }

        double circumference=this.Circumference(pi,radius);
        if (previous_value_circum==0.0)
        {
          previous_value_circum=circumference;
        }
        else
        {
          circum_change=((circumference-previous_value_circum)/previous_value_circum)*100;
          previous_value_circum=circumference;

        }
        NumberFormat formatter = new DecimalFormat("0.##E00");
        System.out.println("Iteration number "+i);
        System.out.println("PI used="+pi);
        System.out.println("Area calculated="+area);
        System.out.println("Circumference calculated="+circumference);
        System.out.println("Percentage change in area="+formatter.format(area_change)+"%");
        System.out.println("Percentage change in circumference="+formatter.format(circum_change)+"%");


      }




    }


    public static void main(String[] args)
    {

      pie obj=new pie();
      obj.pi_iteration();



    }


}
