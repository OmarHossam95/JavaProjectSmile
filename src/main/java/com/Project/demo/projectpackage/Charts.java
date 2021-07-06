package com.Project.demo.projectpackage;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Charts {
    // Function responsible to draw Pie Chart of count of jobs per company
    public static void jobsPerCompanyPieChart(LinkedHashMap<String, Integer> jobsPerCompany){

        PieChart chart = new PieChartBuilder().width(800).height(600).title("Jobs Per Company").build();

        Color[] sliceColors = new Color[]{new Color(180, 68, 50), new Color(130, 105, 120)};
        chart.getStyler().setSeriesColors(sliceColors);

        for (Map.Entry<String, Integer> entry: jobsPerCompany.entrySet()){
            chart.addSeries(entry.getKey(), entry.getValue());
        }

        new SwingWrapper(chart).displayChart();



    }

    // Function responsible to draw Bar Chart of count of jobs
    public static void jobsCountBarChart(LinkedHashMap<String, Integer> jobsCount) {
        CategoryChart chart = new CategoryChartBuilder().width(1024).height(768).title("Most Popular Jobs").xAxisTitle("Jobs").yAxisTitle("Count").build();
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setStacked(true);
        ArrayList<String> jobsNames = new ArrayList<String>(jobsCount.keySet());
        ArrayList<Integer> counts = new ArrayList<Integer>(jobsCount.values());
        chart.addSeries("Jobs Count", jobsNames.subList(0, 10), counts.subList(0, 10));
        new SwingWrapper(chart).displayChart();
    }

    // Function responsible to draw Bar Chart of count of areas
    public static void areaCountBarChart(LinkedHashMap<String, Integer> areaCount) {
        CategoryChart chart = new CategoryChartBuilder().width(1024).height(768).title("Most Popular Areas").xAxisTitle("Areas").yAxisTitle("Count").build();
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setStacked(true);
        ArrayList<String> areaNames = new ArrayList<String>(areaCount.keySet());
        ArrayList<Integer> counts = new ArrayList<Integer>(areaCount.values());
        chart.addSeries("Jobs Count", areaNames.subList(0, 10), counts.subList(0, 10));
        new SwingWrapper(chart).displayChart();
    }
}
