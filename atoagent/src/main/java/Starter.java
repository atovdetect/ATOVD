

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * ATO Start up class
 */
public class Starter {

    private void init(){
        //Initializing all the connections
    }

    public void startListesning(HttpServletRequest request){
       //request.
    }

    public void alertUser(){
        // If any anomalies detected . raise the alert
    }

    void shutDown(){
        //stop the listener on server shutdown
    }

    /**
     *
     * @param request
     * @return
     */
    private Map<String, String> getRequestHeadersInMap(HttpServletRequest request) {

        Map<String, String> result = new HashMap<>();

        Enumeration headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            result.put(key, value);
        }

        return result;
    }

}
