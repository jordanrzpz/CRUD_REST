package Entity.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Jordan Ramirez
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Entity.service.ProductoFacadeREST.class);
    }
    
}
