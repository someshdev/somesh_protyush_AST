import java.util.*;
import java.lang.Math;
import java.math.*;
import java.math.BigDecimal;
import java.text.*;

public class number_generator
{

    public float[] floating_number_generator(int count)
      {
        float result []=new float[count];
        for (int i=0;i<count;i++)
        {
          Random rand = new Random();
          result[i] = rand.nextFloat();
        }
        return result;
      }

    public void calculate_statistics(float[] array_of_numbers)
      {
        float sum=0,average=0,min=0,average_centering=0,variance=0;
        for (int i=0;i<array_of_numbers.length;i++)
          sum+=array_of_numbers[i];

        average=sum/array_of_numbers.length;


        for (int i = 0; i < array_of_numbers.length; i++)
          {
              min=array_of_numbers[i];

              for (int j = i+1; j<array_of_numbers.length; j++)
              {
                if(array_of_numbers[j] < array_of_numbers[j-1])
                {
                    float temp = array_of_numbers[j];
                    array_of_numbers[j] = array_of_numbers[j-1];
                    array_of_numbers[j-1] = temp;
                }

              }
           }
        for (int i=0;i<array_of_numbers.length;i++)
          average_centering+=Math.pow((array_of_numbers[i]-average),2);

        variance=(float)Math.sqrt(average_centering/(array_of_numbers.length));
        System.out.println("sum="+sum+" ,variance="+variance+" ,maximun element="+array_of_numbers[array_of_numbers.length-1]+" ,minimum element="+array_of_numbers[0]+" ,average="+average);


      }


    public void show_results(float[] array)
      {
          System.out.println("Given Inputs are");
          for (int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");

          System.out.println("");
      }


    public void answer()
      {
        Scanner sc=new Scanner(System.in);
        int n1=0,n2=0,n3=0;
        while(true)
        {

          try
            {
              System.out.println("Enter a number between 1 to 1 million");
              n1=sc.nextInt();
              if(n1<1 || n1>1000000)
              {
                System.out.println("Wrong choice please re enter from begining !!");
                continue;
              }
              System.out.println("now enter 2 numbers . 2nd number should be greater than previous");
              n2=sc.nextInt();
              n3=sc.nextInt();

              if(n3<=n2)
              {
                System.out.println("Wrong choice please re enter from begining !!");
                continue;
              }

              break;

            }
          catch(Exception e)
            {
              System.out.println("Exception please enter Integer: "+e);
              continue;
            }
        }

        float[] array=new float[n1];
        array=floating_number_generator(n1);
        show_results(array);
        calculate_statistics(array);
    }


    public static void main(String[] args)
      {

        number_generator obj=new number_generator();
        obj.answer();



      }


}
