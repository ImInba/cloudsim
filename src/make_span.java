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

public class make_span extends ApplicationFrame {

    public make_span(final String title) {

        super(title);

        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        XYPlot plot = (XYPlot) chart.getPlot();
        ValueAxis yAxis = plot.getRangeAxis();
        yAxis.setRange(0,300);
//       chart.getXYPlot().getRangeAxis().setRange(1, 2);
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 400));
        setContentPane(chartPanel);


    }

    private XYDataset createDataset() {
        final XYSeries series1 = new XYSeries("FCFS");
        series1.add(30,240 );
        series1.add(60, 140);
        series1.add(90, 90);
        series1.add(120, 80);
        series1.add(150, 70);
        series1.add(180, 60);
        series1.add(210, 55);
       
        final XYSeries series2 = new XYSeries("ABC_FCFS");
        series2.add(30, 225);
        series2.add(60, 120);
        series2.add(90, 80);
        series2.add(120, 70);
        series2.add(150, 60);
        series2.add(180, 55);
        series2.add(210, 50);
       
        final XYSeries series3 = new XYSeries("LJF");
        series3.add(30, 175);
        series3.add(60, 80);
        series3.add(90, 65);
        series3.add(120, 50);
        series3.add(150, 55);
        series3.add(180, 50);
        series3.add(210, 45);
        
        final XYSeries series4 = new XYSeries("ABC_LJF");
        series4.add(30, 170);
        series4.add(60, 80);
        series4.add(90, 65);
        series4.add(120, 50);
        series4.add(150, 55);
        series4.add(180, 55);
        series4.add(210, 40);
        
          final XYSeries series5 = new XYSeries("Graded VMP");
        series5.add(30, 150);
        series5.add(60, 70);
        series5.add(90, 60);
        series5.add(120, 50);
        series5.add(150, 50);
        series5.add(180, 45);
        series5.add(210, 40);
       
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series2);
        dataset.addSeries(series1);
        dataset.addSeries(series3);
        dataset.addSeries(series4);
        dataset.addSeries(series5);
        //dataset.addSeries(series1);

        return dataset;

    }

    private JFreeChart createChart(final XYDataset dataset) {

        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "", // chart title
                "Number of Virtual Machines ", // x axis label
                "Response Time in ms when No.of VM's increase", // y axis label
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

        final make_span g1 = new make_span("Job scheduling Time Amalysis");
        g1.pack();
        RefineryUtilities.centerFrameOnScreen(g1);
        g1.setVisible(true);

    }
}
