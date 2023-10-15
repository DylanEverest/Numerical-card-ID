package Jersey;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class Get {
    
    String targetUrl ;
    
    public Get(String targetUrl) 
    {
        this.targetUrl = targetUrl;
    }

    public Object getObject(Class<?> clazz) throws Exception
    {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(targetUrl);

        // Make a GET request to the resource and specify the media type you expect
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        
        // Check the HTTP response status
        if (response.getStatus() == 200) 
        {
            return response.readEntity(clazz);
        }
        throw new Exception(response.getStatus()+"");
        
        
    }

}
