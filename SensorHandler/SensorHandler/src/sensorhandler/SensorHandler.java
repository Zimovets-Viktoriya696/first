package sensorhandler;

import java.util.*;

public class SensorHandler
{
    private List<long[]> times;
    private List<double[]> values;

    public SensorHandler()
    {
        this.times = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public void AddSensor(long[] sensorTimes, double[] sensorValues)
    {
        times.add(sensorTimes);
        values.add(sensorValues);
    }

    public int[] GetReferenceVector(long timeInterval)
    {
        double[][] matrix = PackSensorsToMatrix(CalculateAllValuesByTime(timeInterval));

        double[][] scaleMatrix = ScaleMatrix(matrix);

        double[] scaleMatrixAverage = GetAverageFromMatrix(scaleMatrix);
         
        double[] upLimit = AddToArray(scaleMatrixAverage, 20);
        double[] downLimit = AddToArray(scaleMatrixAverage, -20);
        int[][] binMatrix = BinMatrix(scaleMatrix, upLimit, downLimit);

        double[] binMatrixAverage = GetAverageFromMatrix(binMatrix);
        int[] referenceVector = new int[binMatrixAverage.length];

        for(int i = 0; i < referenceVector.length; i++)
        {
            double value = binMatrixAverage[i];
            if(value > 0.5)
            {
                referenceVector[i] = 1;
                
            }
        }

        Clear();

        return referenceVector;
      
    }
    

    double[][] PackSensorsToMatrix(List<double[]> dump)
    {
        int rows = dump.size();
        int columns = GetShortestArrayLen(dump);

        double[][] matrix = new double[rows][columns];

        for(int s = 0; s < rows; s++)
        {
            for(int e = 0; e < columns; e++)
            {
                    matrix[s][e] = dump.get(s)[e];
            }
        }
  
        return matrix;
    }

    int GetShortestArrayLen(List<double[]> dump)
    {
        int shortestArrayLen = Integer.MAX_VALUE;
        for(int d = 0; d < dump.size(); d++)
        {
            if(dump.get(d).length < shortestArrayLen)
            {
                shortestArrayLen = dump.get(d).length;
            }
        }

        return shortestArrayLen;
    }

    private List<double[]> CalculateAllValuesByTime(long timeInterval)
    {
        List<double[]> dump = new ArrayList<>();
        int sensorAmount = values.size();
        for(int s = 0; s < sensorAmount; s++)
        {
            dump.add(CalculateSensorValuesByTime(s, timeInterval));
        }

        return dump;
    }

    double[] CalculateSensorValuesByTime(int id, long timeInterval)
    {
        List<Double> valuesByTime = new ArrayList<>();

        long[] times = this.times.get(id);
        double[] values = this.values.get(id);

        long curTime = timeInterval;
        int i = 1;
        while(i < times.length)
        {
            if(times[i] >= curTime)
            {
                double curValue = GetValueByTime(curTime, times[i - 1], times[i], values[i - 1], values[i]);
                if(curValue < 0)
                {
                    valuesByTime.add(0.0);
                }
                else
                {
                    valuesByTime.add(curValue);
                }
                curTime += timeInterval;
            }
            else
            {
                i++;
            }
        }
        return ListToArray(valuesByTime);
    }

    double GetValueByTime(double time, double timeMin, double timeMax, double valueMin, double valueMax)
    {
        return (time - timeMin) / (timeMax - timeMin) * (valueMax - valueMin) + valueMin;
    }

    double[] ListToArray(List<Double> list)
    {
        double[] array = new double[list.size()];
        for(int i = 0; i < array.length; i++)
        {
            array[i] = list.get(i);
        }

        return array;
    }

    double[][] ScaleMatrix(double[][] matrix)
    {
        int rows = matrix.length;
        int columns = matrix[0].length;

        double[][] scaleMatrix = new double[rows][columns];

        for(int s = 0; s < rows; s++)
        {
            double minValue = GetMinValue(matrix[s]);
            double maxValue = GetMaxValue(matrix[s]);

            double alpha = 100.0 / (maxValue - minValue);
            double beta = alpha * minValue;

            for(int e = 0; e < columns; e++)
            {
                scaleMatrix[s][e] = alpha * matrix[s][e] - beta;
            }
        }

        return scaleMatrix;
    }

    double GetMinValue(double[] ar)
    {
        double min = Double.MAX_VALUE;
        for(int i = 0; i < ar.length; i++)
        {
            if(ar[i] < min)
            {
                min = ar[i];
            }
        }

        return min;
    }

    double GetMaxValue(double[] ar)
    {
        double max = Double.MIN_VALUE;
        for(int i = 0; i < ar.length; i++)
        {
            if(ar[i] > max)
            {
                max = ar[i];
            }
        }

        return max;
    }
    
      private double[] GetAverageFromMatrix(double[][] matrix)
    {
        int rows = matrix.length;
        int columns = matrix[0].length;

        double[] average = new double[columns];// должен быть как размер

    for(int  c  = 0;  c  < columns;  c ++)
        {
            double total = 0.0;
            for(int  r  = 0;  r  <  rows ;  r ++)
            {
                total += matrix[ c ][ r ];
            }
            average[c] = total /   rows ;
        }
     return average;
    }

   /* private double[] GetAverageFromMatrix1(double[][] matrix1)
    {
        int rows = matrix.length;
        int columns = matrix[0].length;

        double[] average = new double[rows];

        for(int r = 0; r < rows; r++)
        {
            double total = 0.0;
            for(int c = 0; c < columns; c++)
            {
                total += matrix[r][c];
            }
            average[r] = total / columns;
        }

        return average;
    }
*/
    double[] GetAverageFromMatrix(int[][] matrix)
    {
        int rows = matrix.length;
        int columns = matrix[0].length;

        double[] average = new double[rows];

        for(int c = 0; c < rows; c++)
        {
            double total = 0.0;
            for(int r = 0; r < columns; r++)
            {
                total += matrix[r][c];
            }
            average[c] = total / columns;
        }

        return average;
    }

    double[] AddToArray(double[] ar, double value)
    {
        double[] result = ar.clone();
        for(int i = 0; i < result.length; i++)
        {
            result[i] += value;
        }
        return result;
    }

    int[][] BinMatrix(double[][] scaleMatrix, double[] upLimit, double[] downLimit)
    {
        int rows = scaleMatrix.length;
        int columns = scaleMatrix[0].length;
        int[][] binMatrix = new int[rows][columns];

        for(int r = 0; r < rows; r++)
        {
            for(int c = 0; c < columns; c++)
            {
                double up = upLimit[c];
                double down = downLimit[c];
                
                double value = scaleMatrix[r][c];
                if(value <= up && value >= down)
                {
                    binMatrix[r][c] = 1;
                }
            }
        }

        return binMatrix;
    }

    private void Clear()
    {
        this.times = new ArrayList<>();
        this.values = new ArrayList<>();
    }

   
}