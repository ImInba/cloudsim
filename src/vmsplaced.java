import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class vmsplaced extends ApplicationFrame
{
   public vmsplaced( String applicationTitle , String chartTitle )
   {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Category",            
         "Percentage",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   private CategoryDataset createDataset( )
   {
      final String no1 = "25 Vms";        
      final String no2 = "40 Vms";        
      final String no3 = "55 Vms";        
      final String fdc1 = "FDC1";        
      final String fdc2 = "FDC2";        
      final String fdc3 = "FDC3";        
      final String fdc4 = "FDC4";        
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      dataset.addValue( 91 , no1 , fdc1 );        
      dataset.addValue( 89 , no1 , fdc3 );        
      dataset.addValue( 92 , no1 , fdc2 ); 
      dataset.addValue( 93 , no1 , fdc4 );           

      dataset.addValue( 84 , no2 , fdc2 );        
      dataset.addValue( 90 , no2 , fdc1 );        
      dataset.addValue( 85 , no2 , fdc3 );       
      dataset.addValue( 80 , no2 , fdc4 );

      dataset.addValue( 80 , no3 , fdc1 );        
      dataset.addValue( 82 , no3 , fdc3 );        
      dataset.addValue( 86 , no3 , fdc2 );        
      dataset.addValue( 81 , no3 , fdc4 );               

      return dataset; 
   }
  void run()
   {
      vmsplaced chart = new vmsplaced("vm placement", "accuracy of vm placement");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }
}