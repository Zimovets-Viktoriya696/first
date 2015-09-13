/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sensorhandler;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import static com.sun.deploy.uitoolkit.impl.fx.DeployPerfLogger.timestamp;
import static com.sun.javafx.perf.PerformanceTracker.logEvent;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import static javafx.util.Duration.millis;
import org.apache.commons.collections4.ListUtils;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;
/**
 *
 * @author Вика
 */
public class BDClass {

   
	ArrayList<Double> kanat1;
        ArrayList<String> kanat2;
        ArrayList<Integer> kanat3;
               
        ArrayList<Double> otklon1;
        ArrayList<String> otklon2;
        ArrayList<Integer> otklon3;
        
        ArrayList<Long> timeVecktor1;
        ArrayList<Long> timeVecktor2;
        
        public  double[] massiv1;
        public  long[] myFirstTime;
        
        public double[] mySecondValue;
        public  long[] mySecondTime;
      
        public static String timeDifference(long timeDifference1) {
long timeDifference = timeDifference1/1000;
int h = (int) (timeDifference / (3600));
int m = (int) ((timeDifference - (h * 3600)) / 60);
int s = (int) (timeDifference - (h * 3600) - m * 60);
System.out.println(String.format("%02d:%02d:%02d", h,m,s));
return String.format("%02d:%02d:%02d", h,m,s);
  
        }
        
    SensorHandler ss = new SensorHandler();    
            
    public double[]  masInit() {
               
    double[] massiv1 = new double[kanat1.size()];
    massiv1 = ss.ListToArray(kanat1); 
   
    this.massiv1 = massiv1;
    
            return massiv1;
      
}
       
      

// JDBC driver name and database URL
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
static final String DB_URL = "jdbc:mysql://localhost/export_mybase"; 
static final String USER = "root"; 
static final String PASS = "";


   //  Database credentials
 
    /**
     * @param args the command line arguments
     */
    public BDClass() {
        
   Connection conn = null;
   Statement stmt0 = null;
   Statement stmt1 = null;
   Statement stmt2 = null;
   Statement stmt3 = null;
  
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt0 = conn.createStatement();
      stmt1 = conn.createStatement();
      stmt2 = conn.createStatement();
      stmt3 = conn.createStatement();
    
      
      String nul = "SELECT * FROM temp_51 WHERE Signal_Index = 1 ";
      String firsRow = "SELECT * FROM temp_51 WHERE Signal_Index = 3 ";
      String secondRow = "SELECT * FROM temp_51 WHERE Signal_Index = 4";
      String thirdRow = "SELECT * FROM temp_51 WHERE Signal_Index = 5";
      
      ResultSet rs0 = stmt0.executeQuery(nul);
      ResultSet rs1 = stmt1.executeQuery(firsRow);
      ResultSet rs2=stmt2.executeQuery(secondRow);
      ResultSet rs3=stmt3.executeQuery(thirdRow);
      
          kanat1 = new ArrayList<>();
          kanat2 = new ArrayList<>();
          kanat3 = new ArrayList<>();
          while (rs0.next()) {
              kanat1.add(rs0.getDouble("Sample_Value_1"));
              kanat1.add(rs0.getDouble("Sample_Value_2"));
              kanat1.add(rs0.getDouble("Sample_Value_3"));
              kanat1.add(rs0.getDouble("Sample_Value_4"));
              kanat1.add(rs0.getDouble("Sample_Value_5"));
              kanat1.add(rs0.getDouble("Sample_Value_6"));
              kanat1.add(rs0.getDouble("Sample_Value_7"));
              kanat1.add(rs0.getDouble("Sample_Value_8"));
              kanat1.add(rs0.getDouble("Sample_Value_9"));
              kanat1.add(rs0.getDouble("Sample_Value_10"));
              kanat1.add(rs0.getDouble("Sample_Value_11"));
              kanat1.add(rs0.getDouble("Sample_Value_12"));
              kanat1.add(rs0.getDouble("Sample_Value_13"));
              kanat1.add(rs0.getDouble("Sample_Value_14"));
              kanat1.add(rs0.getDouble("Sample_Value_15"));
              kanat1.add(rs0.getDouble("Sample_Value_16"));
              kanat1.add(rs0.getDouble("Sample_Value_17"));
              kanat1.add(rs0.getDouble("Sample_Value_18"));
              kanat1.add(rs0.getDouble("Sample_Value_19"));
              kanat1.add(rs0.getDouble("Sample_Value_20"));
              kanat1.add(rs0.getDouble("Sample_Value_21"));
              kanat1.add(rs0.getDouble("Sample_Value_22"));
              kanat1.add(rs0.getDouble("Sample_Value_23"));
              kanat1.add(rs0.getDouble("Sample_Value_24"));
              kanat1.add(rs0.getDouble("Sample_Value_25"));
              kanat1.add(rs0.getDouble("Sample_Value_26"));
              kanat1.add(rs0.getDouble("Sample_Value_27"));
              kanat1.add(rs0.getDouble("Sample_Value_28"));
              kanat1.add(rs0.getDouble("Sample_Value_29"));
              kanat1.add(rs0.getDouble("Sample_Value_30"));
              kanat1.add(rs0.getDouble("Sample_Value_31"));
              kanat1.add(rs0.getDouble("Sample_Value_32"));
              kanat1.add(rs0.getDouble("Sample_Value_33"));
              kanat1.add(rs0.getDouble("Sample_Value_34"));
              kanat1.add(rs0.getDouble("Sample_Value_35"));
              kanat1.add(rs0.getDouble("Sample_Value_36"));
              kanat2.add(rs0.getString("Sample_TDate_1"));
              kanat2.add(rs0.getString("Sample_TDate_2"));
              kanat2.add(rs0.getString("Sample_TDate_3"));
              kanat2.add(rs0.getString("Sample_TDate_4"));
              kanat2.add(rs0.getString("Sample_TDate_5"));
              kanat2.add(rs0.getString("Sample_TDate_6"));
              kanat2.add(rs0.getString("Sample_TDate_7"));
              kanat2.add(rs0.getString("Sample_TDate_8"));
              kanat2.add(rs0.getString("Sample_TDate_9"));
              kanat2.add(rs0.getString("Sample_TDate_10"));
              kanat2.add(rs0.getString("Sample_TDate_11"));
              kanat2.add(rs0.getString("Sample_TDate_12"));
              kanat2.add(rs0.getString("Sample_TDate_13"));
              kanat2.add(rs0.getString("Sample_TDate_14"));
              kanat2.add(rs0.getString("Sample_TDate_15"));
              kanat2.add(rs0.getString("Sample_TDate_16"));
              kanat2.add(rs0.getString("Sample_TDate_17"));
              kanat2.add(rs0.getString("Sample_TDate_18"));
              kanat2.add(rs0.getString("Sample_TDate_19"));
              kanat2.add(rs0.getString("Sample_TDate_20"));
              kanat2.add(rs0.getString("Sample_TDate_21"));
              kanat2.add(rs0.getString("Sample_TDate_22"));
              kanat2.add(rs0.getString("Sample_TDate_23"));
              kanat2.add(rs0.getString("Sample_TDate_24"));
              kanat2.add(rs0.getString("Sample_TDate_25"));
              kanat2.add(rs0.getString("Sample_TDate_26"));
              kanat2.add(rs0.getString("Sample_TDate_27"));
              kanat2.add(rs0.getString("Sample_TDate_28"));
              kanat2.add(rs0.getString("Sample_TDate_29"));
              kanat2.add(rs0.getString("Sample_TDate_30"));
              kanat2.add(rs0.getString("Sample_TDate_31"));
              kanat2.add(rs0.getString("Sample_TDate_32"));
              kanat2.add(rs0.getString("Sample_TDate_33"));
              kanat2.add(rs0.getString("Sample_TDate_34"));
              kanat2.add(rs0.getString("Sample_TDate_35"));
              kanat2.add(rs0.getString("Sample_TDate_36"));
              kanat3.add(rs0.getInt("Sample_MSec_1"));
              kanat3.add(rs0.getInt("Sample_MSec_2"));
              kanat3.add(rs0.getInt("Sample_MSec_3"));
              kanat3.add(rs0.getInt("Sample_MSec_4"));
              kanat3.add(rs0.getInt("Sample_MSec_5"));
              kanat3.add(rs0.getInt("Sample_MSec_6"));
              kanat3.add(rs0.getInt("Sample_MSec_7"));
              kanat3.add(rs0.getInt("Sample_MSec_8"));
              kanat3.add(rs0.getInt("Sample_MSec_9"));
              kanat3.add(rs0.getInt("Sample_MSec_10"));
              kanat3.add(rs0.getInt("Sample_MSec_11"));
              kanat3.add(rs0.getInt("Sample_MSec_12"));
              kanat3.add(rs0.getInt("Sample_MSec_13"));
              kanat3.add(rs0.getInt("Sample_MSec_14"));
              kanat3.add(rs0.getInt("Sample_MSec_15"));
              kanat3.add(rs0.getInt("Sample_MSec_16"));
              kanat3.add(rs0.getInt("Sample_MSec_17"));
              kanat3.add(rs0.getInt("Sample_MSec_18"));
              kanat3.add(rs0.getInt("Sample_MSec_19"));
              kanat3.add(rs0.getInt("Sample_MSec_20"));
              kanat3.add(rs0.getInt("Sample_MSec_21"));
              kanat3.add(rs0.getInt("Sample_MSec_22"));
              kanat3.add(rs0.getInt("Sample_MSec_23"));
              kanat3.add(rs0.getInt("Sample_MSec_24"));
              kanat3.add(rs0.getInt("Sample_MSec_25"));
              kanat3.add(rs0.getInt("Sample_MSec_26"));
              kanat3.add(rs0.getInt("Sample_MSec_27"));
              kanat3.add(rs0.getInt("Sample_MSec_28"));
              kanat3.add(rs0.getInt("Sample_MSec_29"));
              kanat3.add(rs0.getInt("Sample_MSec_30"));
              kanat3.add(rs0.getInt("Sample_MSec_31"));
              kanat3.add(rs0.getInt("Sample_MSec_32"));
              kanat3.add(rs0.getInt("Sample_MSec_33"));
              kanat3.add(rs0.getInt("Sample_MSec_34"));
              kanat3.add(rs0.getInt("Sample_MSec_35"));
              kanat3.add(rs0.getInt("Sample_MSec_36"));
          }         
          
            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");// пересчитываем дату в милисекунды    
            formatter1.setTimeZone(TimeZone.getTimeZone("GTM+02:00"));
               timeVecktor1 = new ArrayList<Long>();      
           
            for (int i = 0; i <kanat3.size() ; i++){
            if (kanat2.get(i) != null && kanat3.get(i) != null){// взять только дату и милисек
            java.util.Date currentDate = formatter1.parse(kanat2.get(i) +  kanat3.get(i));

                       timeVecktor1.add(currentDate.getTime());
             }
            }
            
             Project project = new Project();
            myFirstTime= new long[timeVecktor1.size()];
            myFirstTime=project.ListToArrayL(timeVecktor1); // массив времени
           
            /* for (int i = 0; i <myFirstTime.length ; i++){
            System.out.println(myFirstTime[i]);}*/
          
          
          otklon1 = new ArrayList<>();
          otklon2 = new ArrayList<>();
          otklon3 = new ArrayList<>();
          while (rs2.next()) {
              otklon1.add(rs2.getDouble("Sample_Value_1"));
              otklon1.add(rs2.getDouble("Sample_Value_2"));
              otklon1.add(rs2.getDouble("Sample_Value_3"));
              otklon1.add(rs2.getDouble("Sample_Value_4"));
              otklon1.add(rs2.getDouble("Sample_Value_5"));
              otklon1.add(rs2.getDouble("Sample_Value_6"));
              otklon1.add(rs2.getDouble("Sample_Value_7"));
              otklon1.add(rs2.getDouble("Sample_Value_8"));
              otklon1.add(rs2.getDouble("Sample_Value_9"));
              otklon1.add(rs2.getDouble("Sample_Value_10"));
              otklon1.add(rs2.getDouble("Sample_Value_11"));
              otklon1.add(rs2.getDouble("Sample_Value_12"));
              otklon1.add(rs2.getDouble("Sample_Value_13"));
              otklon1.add(rs2.getDouble("Sample_Value_14"));
              otklon1.add(rs2.getDouble("Sample_Value_15"));
              otklon1.add(rs2.getDouble("Sample_Value_16"));
              otklon1.add(rs2.getDouble("Sample_Value_17"));
              otklon1.add(rs2.getDouble("Sample_Value_18"));
              otklon1.add(rs2.getDouble("Sample_Value_19"));
              otklon1.add(rs2.getDouble("Sample_Value_20"));
              otklon1.add(rs2.getDouble("Sample_Value_21"));
              otklon1.add(rs2.getDouble("Sample_Value_22"));
              otklon1.add(rs2.getDouble("Sample_Value_23"));
              otklon1.add(rs2.getDouble("Sample_Value_24"));
              otklon1.add(rs2.getDouble("Sample_Value_25"));
              otklon1.add(rs2.getDouble("Sample_Value_26"));
              otklon1.add(rs2.getDouble("Sample_Value_27"));
              otklon1.add(rs2.getDouble("Sample_Value_28"));
              otklon1.add(rs2.getDouble("Sample_Value_29"));
              otklon1.add(rs2.getDouble("Sample_Value_30"));
              otklon1.add(rs2.getDouble("Sample_Value_31"));
              otklon1.add(rs2.getDouble("Sample_Value_32"));
              otklon1.add(rs2.getDouble("Sample_Value_33"));
              otklon1.add(rs2.getDouble("Sample_Value_34"));
              otklon1.add(rs2.getDouble("Sample_Value_35"));
              otklon1.add(rs2.getDouble("Sample_Value_36"));
              otklon2.add(rs2.getString("Sample_TDate_1"));
              otklon2.add(rs2.getString("Sample_TDate_2"));
              otklon2.add(rs2.getString("Sample_TDate_3"));
              otklon2.add(rs2.getString("Sample_TDate_4"));
              otklon2.add(rs2.getString("Sample_TDate_5"));
              otklon2.add(rs2.getString("Sample_TDate_6"));
              otklon2.add(rs2.getString("Sample_TDate_7"));
              otklon2.add(rs2.getString("Sample_TDate_8"));
              otklon2.add(rs2.getString("Sample_TDate_9"));
              otklon2.add(rs2.getString("Sample_TDate_10"));
              otklon2.add(rs2.getString("Sample_TDate_11"));
              otklon2.add(rs2.getString("Sample_TDate_12"));
              otklon2.add(rs2.getString("Sample_TDate_13"));
              otklon2.add(rs2.getString("Sample_TDate_14"));
              otklon2.add(rs2.getString("Sample_TDate_15"));
              otklon2.add(rs2.getString("Sample_TDate_16"));
              otklon2.add(rs2.getString("Sample_TDate_17"));
              otklon2.add(rs2.getString("Sample_TDate_18"));
              otklon2.add(rs2.getString("Sample_TDate_19"));
              otklon2.add(rs2.getString("Sample_TDate_20"));
              otklon2.add(rs2.getString("Sample_TDate_21"));
              otklon2.add(rs2.getString("Sample_TDate_22"));
              otklon2.add(rs2.getString("Sample_TDate_23"));
              otklon2.add(rs2.getString("Sample_TDate_24"));
              otklon2.add(rs2.getString("Sample_TDate_25"));
              otklon2.add(rs2.getString("Sample_TDate_26"));
              otklon2.add(rs2.getString("Sample_TDate_27"));
              otklon2.add(rs2.getString("Sample_TDate_28"));
              otklon2.add(rs2.getString("Sample_TDate_29"));
              otklon2.add(rs2.getString("Sample_TDate_30"));
              otklon2.add(rs2.getString("Sample_TDate_31"));
              otklon2.add(rs2.getString("Sample_TDate_32"));
              otklon2.add(rs2.getString("Sample_TDate_33"));
              otklon2.add(rs2.getString("Sample_TDate_34"));
              otklon2.add(rs2.getString("Sample_TDate_35"));
              otklon2.add(rs2.getString("Sample_TDate_36"));
              otklon3.add(rs2.getInt("Sample_MSec_1"));
              otklon3.add(rs2.getInt("Sample_MSec_2"));
              otklon3.add(rs2.getInt("Sample_MSec_3"));
              otklon3.add(rs2.getInt("Sample_MSec_4"));
              otklon3.add(rs2.getInt("Sample_MSec_5"));
              otklon3.add(rs2.getInt("Sample_MSec_6"));
              otklon3.add(rs2.getInt("Sample_MSec_7"));
              otklon3.add(rs2.getInt("Sample_MSec_8"));
              otklon3.add(rs2.getInt("Sample_MSec_9"));
              otklon3.add(rs2.getInt("Sample_MSec_10"));
              otklon3.add(rs2.getInt("Sample_MSec_11"));
              otklon3.add(rs2.getInt("Sample_MSec_12"));
              otklon3.add(rs2.getInt("Sample_MSec_13"));
              otklon3.add(rs2.getInt("Sample_MSec_14"));
              otklon3.add(rs2.getInt("Sample_MSec_15"));
              otklon3.add(rs2.getInt("Sample_MSec_16"));
              otklon3.add(rs2.getInt("Sample_MSec_17"));
              otklon3.add(rs2.getInt("Sample_MSec_18"));
              otklon3.add(rs2.getInt("Sample_MSec_19"));
              otklon3.add(rs2.getInt("Sample_MSec_20"));
              otklon3.add(rs2.getInt("Sample_MSec_21"));
              otklon3.add(rs2.getInt("Sample_MSec_22"));
              otklon3.add(rs2.getInt("Sample_MSec_23"));
              otklon3.add(rs2.getInt("Sample_MSec_24"));
              otklon3.add(rs2.getInt("Sample_MSec_25"));
              otklon3.add(rs2.getInt("Sample_MSec_26"));
              otklon3.add(rs2.getInt("Sample_MSec_27"));
              otklon3.add(rs2.getInt("Sample_MSec_28"));
              otklon3.add(rs2.getInt("Sample_MSec_29"));
              otklon3.add(rs2.getInt("Sample_MSec_30"));
              otklon3.add(rs2.getInt("Sample_MSec_31"));
              otklon3.add(rs2.getInt("Sample_MSec_32"));
              otklon3.add(rs2.getInt("Sample_MSec_33"));
              otklon3.add(rs2.getInt("Sample_MSec_34"));
              otklon3.add(rs2.getInt("Sample_MSec_35"));
              otklon3.add(rs2.getInt("Sample_MSec_36"));
          }       
               
           mySecondValue= new double[otklon1.size()];// массив значения 2
           mySecondValue = project.ListToArrayD(otklon1); 
           
                   
            SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");// пересчитываем дату в милисекунды    
            formatter2.setTimeZone(TimeZone.getTimeZone("GTM+02:00"));
               timeVecktor2 = new ArrayList<Long>();    
           
            for (int i = 0; i <otklon3.size() ; i++){
            if (otklon2.get(i) != null && otklon3.get(i) != null){// взять только дату и милисек
            java.util.Date currentDate = formatter2.parse(otklon2.get(i) +  otklon3.get(i));

                timeVecktor2.add(currentDate.getTime());

              }
            }
 
           mySecondTime= new long[otklon1.size()];// массив значения 2
           mySecondTime = project.ListToArrayL(timeVecktor2);

          
   
      //STEP 6: Clean-up environment
      rs1.close();
     
      stmt1.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt1!=null)
            stmt1.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end tr  
    }//end main
  }//end FirstExample  // TODO code application logic here