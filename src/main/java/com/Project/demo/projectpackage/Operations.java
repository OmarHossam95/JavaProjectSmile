
package com.Project.demo.projectpackage;
import smile.data.DataFrame;
import smile.data.measure.NominalScale;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

//Class Responsible for handling data manipulation and operations
public class Operations {

    //Function Responsible to get count of jobs per each company
    public static LinkedHashMap<String, Integer> getJobCountPerCompany(DataFrame df){
        Map<String, Integer> companyJobMap = new HashMap<String, Integer>();
        for (int i=0 ;i<df.size(); i++){
            int noOfJobs = companyJobMap.getOrDefault(df.get(i, "Company"), 0);
            companyJobMap.put((String) df.get(i, "Company"), noOfJobs+1);
        }

        LinkedHashMap<String, Integer> sortedCompanyJobCount = new LinkedHashMap<String, Integer>();
        companyJobMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> sortedCompanyJobCount.put(x.getKey(), x.getValue()));
        return sortedCompanyJobCount;
    }

    //Function responsible to get count of each job
    public static LinkedHashMap<String, Integer> getMostPopularJobs(DataFrame df){
        Map<String, Integer> jobCount = new HashMap<String, Integer>();
        for (int i=0 ;i<df.size(); i++){
            int noOfJobs = jobCount.getOrDefault(df.get(i, "Title"), 0);
            jobCount.put((String) df.get(i, "Title"), noOfJobs+1);
        }
        LinkedHashMap<String, Integer> sortedMostPopularJobs = new LinkedHashMap<String, Integer>();
        jobCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> sortedMostPopularJobs.put(x.getKey(), x.getValue()));

        return sortedMostPopularJobs;
    }

    //Function responsible to get count of each area
    public static LinkedHashMap<String, Integer> getMostPopularAreas(DataFrame df){
        Map<String, Integer> areaCount = new HashMap<String, Integer>();
        for (int i=0 ;i<df.size(); i++){
            int noOfAreas = areaCount.getOrDefault(df.get(i, "Location"), 0);
            areaCount.put((String) df.get(i, "Location"), noOfAreas+1);
        }
        LinkedHashMap<String, Integer> sortedMostPopularAreas = new LinkedHashMap<String, Integer>();
        areaCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> sortedMostPopularAreas.put(x.getKey(), x.getValue()));

        return sortedMostPopularAreas;
    }

    //Function responsible to get count of each skill
    public static LinkedHashMap<String, Integer> getMostPopularSkills(DataFrame df){
        Map<String, Integer> skillCount = new HashMap<String, Integer>();
        for (int i=0 ;i<df.size(); i++){
            String skills = (String) df.get(i, "Skills");
            String skillsSplit[] = skills.split(", ");
            for (String skill: skillsSplit){
                int noOfSkills = skillCount.getOrDefault(skill, 0);
                skillCount.put(skill, noOfSkills+1);
            }
        }
        LinkedHashMap<String, Integer> sortedMostPopularSkills = new LinkedHashMap<String, Integer>();
        skillCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> sortedMostPopularSkills.put(x.getKey(), x.getValue()));
        return sortedMostPopularSkills;
    }

    //Function to factorize years of experience
    public static int [] facorizeYeasrExp(DataFrame df , String columnName){

        String[] values = df.stringVector (columnName).distinct ().toArray (new String[]{});
        int[] pclassValues = df.stringVector(columnName).factorize(new NominalScale(values)).toIntArray();
        return pclassValues;
    }

}
