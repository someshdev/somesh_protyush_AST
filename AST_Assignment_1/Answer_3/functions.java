import java.util.*;
import java.lang.Math;
import java.text.*;
public class functions
{

  private String[] function_signatures_values(int n)
  {
    String[] funct_val=new String[7];
    funct_val[0]=String.format("%d",n);
    funct_val[1]=String.format("%d",2*n);
    funct_val[2]=String.format("%.3f",Math.pow(n,0.5));
    funct_val[3]=String.format("%d",(int)Math.pow(n,3));
    NumberFormat formatter = new DecimalFormat("0.###E0");
    funct_val[4]=formatter.format((int)Math.pow(10,n));
    if (n!=0)
    {
      funct_val[5]=String.format("%.3f",Math.pow(2,(1/n)));

    }
    else
    {
      funct_val[5]="Undefined";
    }

    funct_val[6]=formatter.format(Math.pow(Math.E,n));
    return funct_val;
  }
  private void print_values(String[] arr)
  {

    for(int i=0;i<arr.length;i++)
    {
      System.out.print(arr[i]+" \t\t");
    }
      System.out.println(" ");
  }
  public void function_iterations()
  {
    System.out.println("Functions and their values:");
    System.out.println("_____________________________________________________________________________________________________________");
    String[] function_signatures={"n","2n","n^0.5","n^3","10^n","2^(1/n)","e^n"};
    this.print_values(function_signatures);

    for(int i=0;i<=100;i++)
    {
      this.print_values(this.function_signatures_values(i));
    }
  }



  public static void main(String[] args)
  {
    functions obj=new functions();
    obj.function_iterations();
   }
}
