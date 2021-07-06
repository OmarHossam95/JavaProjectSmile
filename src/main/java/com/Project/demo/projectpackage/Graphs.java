/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Project.demo.projectpackage;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author omarh
 */
public class Graphs {
    public static JFreeChart jobsPerCompaniesPiePlot(LinkedHashMap<String, Integer> jobsPerComapnies, String title){
        /*int size = jobsPerComapnies.size();
        int g = 0;
        for (int i=6; i< size; i++){
            g += (Integer) jobsPerComapnies.get
        }*/
        DefaultPieDataset pieData = new DefaultPieDataset();
        
        int i = 0;
        for (Map.Entry<String, Integer> entry: jobsPerComapnies.entrySet()){
            pieData.setValue((String) entry.getKey(), (Integer) entry.getValue());
            i++;
            if (i >= 5) break;
        }
        JFreeChart pieChart = ChartFactory.createPieChart("Jobs Per Company", pieData, true, false, false);
        pieChart.setBorderVisible(false);
        return pieChart;
    }
    
}
