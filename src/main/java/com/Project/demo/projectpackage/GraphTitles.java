/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Project.demo.projectpackage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import smile.data.DataFrame;

/**
 *
 * @author omarh
 */
public class GraphTitles extends HttpServlet {
    JobProvider jobProvider = new JobProvider();
    DataFrame df = jobProvider.readCSV("src/main/resources/Wuzzuf_Jobs.csv");
    LinkedHashMap<String, Integer> sortedCompanyJobCount = Operations.getJobCountPerCompany(df);
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("image/png");
        
        OutputStream out = resp.getOutputStream();
        
        JFreeChart pieChart = Graphs.jobsPerCompaniesPiePlot(sortedCompanyJobCount, "Jobs Per Companies");
        int width = 1024;
        int height = 720;
        ChartUtilities.writeChartAsPNG(out, pieChart, width, height);
        
    }
    
}
