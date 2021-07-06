
package com.Project.demo.projectpackage;

import org.apache.commons.csv.CSVFormat;
import smile.data.DataFrame;
import smile.io.Read;

import java.io.IOException;
import java.net.URISyntaxException;

public class JobProvider {
    private DataFrame jobDataFrame;
    public DataFrame readCSV(String path){
        CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader ();
        DataFrame df = null;
        try {
            df = Read.csv (path, format);
            df = df.select ("Title", "Company", "Location", "Type", "Level", "YearsExp", "Country", "Skills");
            System.out.println(df);
            System.out.println(df.summary());
            System.out.println(df.column("Title"));
        } catch (IOException e) {
            e.printStackTrace ();
        }
        catch (URISyntaxException e) {
            e.printStackTrace ();
        }
        jobDataFrame = df;
        return df;
    }
}
