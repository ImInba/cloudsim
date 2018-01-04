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

public class Co2emission extends ApplicationFrame {

    public Co2emission(final String title) {

        super(title);

        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        XYPlot plot = (XYPlot) chart.getPlot();
        ValueAxis yAxis = plot.getRangeAxis();
        yAxis.setRange(0, 2);
//       chart.getXYPlot().getRangeAxis().setRange(1, 2);
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 400));
        setContentPane(chartPanel);


    }

    private XYDataset createDataset() {
        final XYSeries series1 = new XYSeries("PR");
        series1.add(20, 0.1);
        series1.add(40, 0.2);
        series1.add(60, 0.3);
        series1.add(80, 0.45);
        series1.add(100, 0.5);
        series1.add(120, 0.65);
        series1.add(150, 0.7);
        series1.add(200, 0.98);
        series1.add(250, 1.2);

        final XYSeries series2 = new XYSeries("CEPM");
        series2.add(20, 0);
        series2.add(40, 0.05);
        series2.add(60, 0.1);
        series2.add(80, 0.15);
        series2.add(100, 0.25);
        series2.add(120, 0.35);
        series2.add(150, 0.45);
        series2.add(200, 0.6);
        series2.add(250, 1.0);

        final XYSeries series3 = new XYSeries("PRH-EM");
        series3.add(20, 0);
        series3.add(40, 0.04);
        series3.add(60, 0.09);
        series3.add(80, 0.1);
        series3.add(100, 0.12);
        series3.add(120, 0.2);
        series3.add(150, 0.3);
        series3.add(200, 0.5);
        series3.add(250, 0.8);

      

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series2);
        dataset.addSeries(series1);
        dataset.addSeries(series3);
       

        return dataset;

    }

    private JFreeChart createChart(final XYDataset dataset) {

        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "", // chart title
                "Number of Virtual Machines ", // x axis label
                "Carbon Emission in Kg", // y axis label
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

        final Co2emission g1 = new Co2emission("Comparison Analysis");
        g1.pack();
        RefineryUtilities.centerFrameOnScreen(g1);
        g1.setVisible(true);

    }
}
