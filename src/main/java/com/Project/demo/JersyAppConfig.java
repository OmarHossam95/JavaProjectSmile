
package com.Project.demo;


import com.Project.demo.frugalis.resources.DataResource;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
//import org.graalvm.compiler.lir.CompositeValue;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class JersyAppConfig extends ResourceConfig{
    
    public JersyAppConfig(){
        
        register(DataResource.class);
        
        packages("com.Project.demo.frugalis.resources");
        packages("com.Project.demo.projectpackage");
    
    }
}
