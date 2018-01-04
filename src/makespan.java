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

public class makespan extends ApplicationFrame {

    public makespan(final String title) {

        super(title);

        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        XYPlot plot = (XYPlot) chart.getPlot();
        ValueAxis yAxis = plot.getRangeAxis();
        yAxis.setRange(0,220);
//       chart.getXYPlot().getRangeAxis().setRange(1, 2);
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 400));
        setContentPane(chartPanel);


    }

    private XYDataset createDataset() {
        final XYSeries series1 = new XYSeries("ABC_FCFS");
        series1.add(100, 45);
        series1.add(200, 60);
        series1.add(300, 80);
        series1.add(400, 120);
        series1.add(500, 150);
        series1.add(600, 180);
        series1.add(700, 200);
       
        final XYSeries series2 = new XYSeries("ABC_LJF");
        series2.add(100, 20);
        series2.add(200, 30);
        series2.add(300, 60);
        series2.add(400, 70);
        series2.add(500, 90);
        series2.add(600, 110);
        series2.add(700, 120);
       
        final XYSeries series3 = new XYSeries("ABC_SJF");
        series3.add(100, 30);
        series3.add(200, 35);
        series3.add(300, 60);
        series3.add(400, 60);
        series3.add(500, 80);
        series3.add(600, 110);
        series3.add(700, 120);
        
        final XYSeries series4 = new XYSeries("Graded VMP");
        series4.add(100, 18);
        series4.add(200, 25);
        series4.add(300, 55);
        series4.add(400, 65);
        series4.add(500, 70);
        series4.add(600, 100);
        series4.add(700, 110);
       
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
                "Response Time in ms when Jobs Increase", // y axis label
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

        final makespan g1 = new makespan("Job scheduling Time Amalysis");
        g1.pack();
        RefineryUtilities.centerFrameOnScreen(g1);
        g1.setVisible(true);

    }
}
