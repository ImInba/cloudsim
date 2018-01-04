import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class memoryusage extends ApplicationFrame
{
   public memoryusage( String applicationTitle , String chartTitle )
   {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Datacenters",            
         "Available Resources",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 700 , 500 ) );        
      setContentPane( chartPanel ); 
   }
   private CategoryDataset createDataset( )
   {
      final String rsa1 = "Total Resource";        
      final String rsa2 = "Utilized REsource";        
     
      final String bit1 = "DC1";        
      final String bit2 = "DC2";        
      final String bit3 = "DC3";        
      final String bit4 = "DC4";
      final String bit5= "DC5"; 
      final String bit6= "DC6";
      final String bit7= "DC7";
      final String bit8= "DC8";
      final String bit9= "DC9";
      final String bit10= "DC10";
      
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      dataset.addValue( 7000.0 , rsa1 , bit1 );        
      dataset.addValue( 6000.0 , rsa1 , bit3 );        
      dataset.addValue( 4500.0 , rsa1 , bit2 ); 
      dataset.addValue( 13000.0 , rsa1 , bit4 );   
      dataset.addValue( 2500.0 , rsa1 , bit5 );   
      dataset.addValue( 7000.0 , rsa1 , bit6);   
      dataset.addValue( 5000.0 , rsa1 , bit7 );   
      dataset.addValue( 2500.0 , rsa1 , bit8 );   
      dataset.addValue( 8000.0 , rsa1 , bit9 );   
      dataset.addValue( 2500.0 , rsa1 , bit10 );   
    //  dataset.addValue( 91542.0 , rsa1 , bit5 );

      dataset.addValue( 6500.0 , rsa2 , bit1 );        
      dataset.addValue( 5500.0 , rsa2 , bit3 );       
      dataset.addValue( 3000.0 , rsa2 , bit2 );        
      dataset.addValue( 8000.0 , rsa2 , bit4 );
      dataset.addValue( 500.0 , rsa2 , bit5 );
      dataset.addValue( 2000.0 , rsa2 , bit6 );
      dataset.addValue( 500.0 , rsa2 , bit7 );
      dataset.addValue( 500.0 , rsa2 , bit8 );
      dataset.addValue( 6000.0 , rsa2 , bit9 );
      dataset.addValue( 500.0 , rsa2 , bit10 );
//      dataset.addValue( 92899.0 , rsa2 , bit5 );
      

//      dataset.addValue( 247200.0 ,rsa4 , bit5 );
      return dataset; 
   }
   public static void main( String[ ] args )
   {
      memoryusage chart = new memoryusage("Memory Usage Analysis","Total Resources Available Vs Consumed");
      chart.pack( );    
      
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }
}