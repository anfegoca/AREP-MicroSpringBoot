
package co.edu.escuelaing.httpserver;


public interface URIProcessor {
    public void mapService(String command) throws Exception;
    public String executeService(String theuri);
    
}
