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

public class responsetime extends ApplicationFrame {

    public responsetime(final String title) {

        super(title);

        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        XYPlot plot = (XYPlot) chart.getPlot();
        ValueAxis yAxis = plot.getRangeAxis();
        yAxis.setRange(0,100);
//       chart.getXYPlot().getRangeAxis().setRange(1, 2);
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 400));
        setContentPane(chartPanel);


    }

    private XYDataset createDataset() {
        final XYSeries series1 = new XYSeries("modified best fit");
        series1.add(5, 20);
        series1.add(10, 18);
        series1.add(15, 17);
        series1.add(20, 20);
        series1.add(25, 30);
        series1.add(30, 25);
        series1.add(35, 30);
       
        final XYSeries series2 = new XYSeries("best fit");
        series2.add(5, 35);
        series2.add(10, 31);
        series2.add(15, 25);
        series2.add(20, 34);
        series2.add(25, 42);
        series2.add(30, 46);
        series2.add(35, 50);
       
        final XYSeries series3 = new XYSeries("Greedy");
        series3.add(5, 25);
        series3.add(10, 29);
        series3.add(15, 95);
        series3.add(20, 40);
        series3.add(25, 55);
        series3.add(30, 45);
        series3.add(35, 50);
        
         final XYSeries series4 = new XYSeries("Graded VMP");
        series4.add(5, 18);
        series4.add(10, 15);
        series4.add(15, 15);
        series4.add(20, 18);
        series4.add(25, 26);
        series4.add(30, 21);
        series4.add(35, 25);
       
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
                "Response Time in ms", // y axis label
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

        final responsetime g1 = new responsetime("Response Time Amalysis");
        g1.pack();
        RefineryUtilities.centerFrameOnScreen(g1);
        g1.setVisible(true);

    }
}
