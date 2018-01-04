import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class energy extends ApplicationFrame
{
   public energy( String applicationTitle , String chartTitle )
   {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "CPU Utilization Percentage",            
         "Energy Consumption KwH",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   private CategoryDataset createDataset( )
   {
      final String no1 = "FAP DC1";        
      final String no2 = "FAP DC2";        
      final String no3 = "TRIVIAL";        
      final String no4 = "FDC PRH-EM(G)";        
      final String fdc1 = "20%";        
      final String fdc2 = "40%";        
      final String fdc3 = "60%";        
      final String fdc4 = "80%";        
      final String fdc5 = "100%";        
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      dataset.addValue( 2.9 , no1 , fdc1 );        
      dataset.addValue( 2.9 , no1 , fdc3 );        
      dataset.addValue( 2.8 , no1 , fdc2 ); 
      dataset.addValue( 2.9 , no1 , fdc4 );           
      dataset.addValue( 2.9 , no1 , fdc5 );           

      dataset.addValue( 1.9 , no2 , fdc2 );        
      dataset.addValue( 1.9 , no2 , fdc1 );        
      dataset.addValue( 1.7 , no2 , fdc3 );       
      dataset.addValue( 1.5 , no2 , fdc4 );
      dataset.addValue( 1.4 , no2 , fdc5 );

      dataset.addValue( 9.1 , no3 , fdc1 );        
      dataset.addValue( 9.1 , no3 , fdc3 );        
      dataset.addValue( 9.0 , no3 , fdc2 );        
      dataset.addValue( 9.1 , no3 , fdc4 );               
      dataset.addValue( 9.2 , no3 , fdc5 );               
      
      dataset.addValue( 1.6 , no4 , fdc1 );        
      dataset.addValue( 1.5 , no4 , fdc3 );        
      dataset.addValue( 1.5 , no4 , fdc2 );        
      dataset.addValue( 1.4 , no4 , fdc4 );               
      dataset.addValue( 1.4 , no4 , fdc5 );               

      return dataset; 
   }
  void run()
   {
      energy chart = new energy("Energy Vs CPU Utilization", "Energy Consumption Analysis");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }
}