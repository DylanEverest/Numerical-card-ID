package Glassfish7;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;


@ApplicationPath("resources")
public class ContainerService extends Application 
{
    public Set<Class<?>> getClasses() 
    {
        Set<Class<?>> s = new HashSet<Class<?>>();
        // s.add(ExempleResource.class);
        // s.add(Employee.class);
        return s;
    }
    
    @Override
    public Set<Object> getSingletons() 
    {
        Set<Object> singletons = new HashSet<>();
        return singletons;
    }
    
}
