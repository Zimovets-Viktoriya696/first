
package sensorhandler;

import java.util.ArrayList;
import java.util.List;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RefineryUtilities;

public class Project
{
   
    public static void main(String [] args)
    {
        List<Long> x1 = new ArrayList<>();
        List<Double> y1 = new ArrayList<>();
        
        List<Long> x2 = new ArrayList<>();
        List<Double> y2 = new ArrayList<>();
       
        long[] x1Ar = ListToArrayL(x1);
        double[] y1Ar = ListToArrayD(y1);

        long[] x2Ar = ListToArrayL(x2);
        double[] y2Ar = ListToArrayD(y2);
        
       input hh = new input();
               
       hh.d();
        
        SensorHandler sh = new SensorHandler();

        sh.AddSensor(x1Ar, y1Ar);
        sh.AddSensor(x2Ar, y2Ar);
        
        int[] result = sh.GetReferenceVector(100);
        
        for (  int p : result)
            {
            System.out.print(p);
          //  System.out.print("\t");
            }
       // sh.Start(10);
     
        
    }
  public static long[] ListToArrayL(List<Long> list)
    {
        long[] array = new long[list.size()];
        for(int i = 0; i < array.length; i++)
        {
            array[i] = list.get(i);
           
        }
 
        return array;
        
       
    }
 
    public static double[] ListToArrayD(List<Double> list)
    {
        double[] array = new double[list.size()];
        for(int i = 0; i < array.length; i++)
        {
            array[i] = list.get(i);
                   
        }
 
        return array;
        
    }
       
    
}

