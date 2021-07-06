
package com.Project.demo.frugalis.resources;

import com.Project.demo.projectpackage.Charts;
import com.Project.demo.projectpackage.Graphs;
import com.Project.demo.projectpackage.JobProvider;
import com.Project.demo.projectpackage.Operations;
import java.awt.PageAttributes;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import smile.data.DataFrame;
import java.util.HashMap;
import org.jfree.chart.JFreeChart;
import smile.data.vector.IntVector;

@Path("/data")
public class DataResource {

    JobProvider jobProvider = new JobProvider();
    DataFrame df = jobProvider.readCSV("src/main/resources/Wuzzuf_Jobs.csv");
    
    //get the the count of jobs for each company
    @GET
    @Path("/companyjobs")
    @Produces(MediaType.APPLICATION_JSON)
    public LinkedHashMap<String, Integer> getJobCountPerCompany() {
        LinkedHashMap<String, Integer> sortedCompanyJobCount = Operations.getJobCountPerCompany(df);
        return sortedCompanyJobCount;
        
    }
    
    //get the count of most popular jobs
    @GET
    @Path("/jobs")
    @Produces(MediaType.APPLICATION_JSON)
    public LinkedHashMap<String, Integer> getJobCount() {
        LinkedHashMap<String, Integer> sortedJobCount = Operations.getMostPopularJobs(df);
        return sortedJobCount;
    }
    
    //get the most popular areas
    @GET
    @Path("/areas")
    @Produces(MediaType.APPLICATION_JSON)
    public LinkedHashMap<String, Integer> getAreaCount() {
        LinkedHashMap<String, Integer> sortedAreaCount = Operations.getMostPopularAreas(df);
        return sortedAreaCount;
    }
    
    //get the most popular skills
    @GET
    @Path("/skills")
    @Produces(MediaType.APPLICATION_JSON)
    public LinkedHashMap<String, Integer> getSkillCount() {
        LinkedHashMap<String, Integer> sortedSkillCount = Operations.getMostPopularSkills(df);
        return sortedSkillCount;
    }
    
    //factorize the YearsExp feature 
    @GET
    @Path("/factorize")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> detDF(){
    DataFrame df1 = df.merge(IntVector.of("yearsOfExperince", Operations.facorizeYeasrExp(df, "YearsExp")));
    List<String> dataframe = new ArrayList<>();
    for (int i=0; i<=df.size(); i++){
        dataframe.add(df1.get(i).toString());
    }
    return dataframe;
    }
    
    
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response SaveUser() {

        return Response.ok().build();

    }

}
