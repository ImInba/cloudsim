/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


//package temporal;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
//import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
//import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class load_dist extends ApplicationFrame {

    public load_dist(final String title) {

        super(title);

        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        XYPlot plot = (XYPlot) chart.getPlot();
        ValueAxis yAxis = plot.getRangeAxis();
        yAxis.setRange(0,100);
//       chart.getXYPlot().getRangeAxis().setRange(1, 2);
        chartPanel.setPreferredSize(new java.awt.Dimension(350, 350));
        setContentPane(chartPanel);


    }

    private XYDataset createDataset() {
        final XYSeries series1 = new XYSeries("modified best fit");
        series1.add(0, 45);
        series1.add(5, 58);
        series1.add(10, 57);
        series1.add(15, 56);
        
       
        final XYSeries series2 = new XYSeries("best fit");
        series2.add(0,20);
        series2.add(5, 29);
        series2.add(10, 26);
        series2.add(15, 42);
        series2.add(20, 50);
        series2.add(25, 40);
      
       
        final XYSeries series3 = new XYSeries("Greedy");
        series3.add(0,4);
        series3.add(5, 5);
        series3.add(10, 20);
        series3.add(15, 14);
        series3.add(20, 10);
        series3.add(25, 52);
        
         final XYSeries series4 = new XYSeries("Exigendy-VMM");
        series4.add(0,0);
         series4.add(5, 2);
        series4.add(10, 5);
        series4.add(15, 10);
        series4.add(20, 8);
        series4.add(25, 25);
     
       
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series2);
        dataset.addSeries(series1);
        dataset.addSeries(series3);
        dataset.addSeries(series4);
        //dataset.addSeries(series1);

        return dataset;

    }

    private JFreeChart createChart(final XYDataset dataset) {

        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "", // chart title
                "Number of Virtual Machines ", // x axis label
                "Load Stabilization", // y axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        chart.setBackgroundPaint(Color.white);

        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(1, true);
        plot.setRenderer(renderer);

        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
//        rangeAxis.setRange(1000,9000);//y axis


        return chart;

    }

    void run() {

        final load_dist g1 = new load_dist("Exigency based Migration/ Load Stabilization");
        g1.pack();
        RefineryUtilities.centerFrameOnScreen(g1);
        g1.setVisible(true);

    }
}
