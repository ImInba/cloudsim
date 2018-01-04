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

public class profit extends ApplicationFrame {

    public profit(final String title) {

        super(title);

        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        XYPlot plot = (XYPlot) chart.getPlot();
        ValueAxis yAxis = plot.getRangeAxis();
        yAxis.setRange(0,1.5);
//       chart.getXYPlot().getRangeAxis().setRange(1, 2);
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 400));
        setContentPane(chartPanel);


    }

    private XYDataset createDataset() {
        final XYSeries series1 = new XYSeries("FAOO");
        series1.add(10, 1.07);
        series1.add(30, 1.02);
        series1.add(50, 0.98);
        series1.add(70, 0.95);
        series1.add(90, 0.95);
     
       
        final XYSeries series2 = new XYSeries("NFTI");
        series2.add(10, 1);
        series2.add(30, 1);
        series2.add(50, 1);
        series2.add(70, 1);
        series2.add(90, 1);
       
        final XYSeries series3 = new XYSeries("FAPO");
        series3.add(10, 1.08);
        series3.add(30, 1.03);
        series3.add(50, 1);
        series3.add(70, 0.99);
        series3.add(90, 1);
        
         final XYSeries series4 = new XYSeries("PRH-EM");
        series4.add(10, 1.09);
        series4.add(30, 1.05);
        series4.add(50, 1.03);
        series4.add(70, 1.01);
        series4.add(90, 1);
     
       
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
                "% of VM Request ", // x axis label
                "Normalized Profit", // y axis label
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

        final profit g1 = new profit("profit maximization Analysis");
        g1.pack();
        RefineryUtilities.centerFrameOnScreen(g1);
        g1.setVisible(true);

    }
}
