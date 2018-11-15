
import java.util.*;
import java.lang.Math;
public class statistics
{

    private int number_of_inputs;
    private int array_of_numbers[];



    public void accept_inputs()
    {
      boolean ch=true;
      while(ch)
      {
            try
            {
              System.out.println("Enter the total number of characters you want to enter.");
              Scanner sc=new Scanner(System.in);
              this.number_of_inputs=sc.nextInt();
              ch=false;
            }
            catch(InputMismatchException e)
            {
              System.out.println("Mismatch in input type retrying process try again. Input has to be a Integer!!");
              continue;
            }

        }
      array_of_numbers=new int[this.number_of_inputs];
      for (int i=0 ; i < this.number_of_inputs ; i++)
          {
          	System.out.println("Enter element "+(i+1));
            try
            {
              Scanner sc1=new Scanner(System.in);
              this.array_of_numbers[i]=sc1.nextInt();
            }
            catch(InputMismatchException e)
            {
              System.out.println("Mismatch in input type retrying process");
              i--;
              continue;

            }


	  	     }
          this.show_results();

    }


    public void calculate_statistics()
    {
      int sum=0,average,min,max,average_centering=0,variance=0;
      for (int i=0;i<this.number_of_inputs;i++)
        sum+=this.array_of_numbers[i];

      average=(int)sum/this.number_of_inputs;
      IntSummaryStatistics stat = Arrays.stream(this.array_of_numbers).summaryStatistics();
      min = stat.getMin();
      max = stat.getMax();
      for (int i=0;i<this.number_of_inputs;i++)
        average_centering+=Math.pow((this.array_of_numbers[i]-average),2);

      variance=(int)Math.sqrt(average_centering/(this.number_of_inputs-1));
      System.out.println("sum="+sum+" ,variance="+variance+" ,maximun element="+max+" ,minimum element="+min+" ,average="+average);


    }

    public void show_results()
    {
        System.out.println("Given Inputs are");
        for (int i=0;i<this.number_of_inputs;i++)
          System.out.print(this.array_of_numbers[i]+" ");

        System.out.println("");
    }

    public void start_operation()
    {
      this.accept_inputs();
      this.calculate_statistics();
    }

    public static void main(String[] args)
    {
      statistics obj=new statistics();
      obj.start_operation();
    }

}
