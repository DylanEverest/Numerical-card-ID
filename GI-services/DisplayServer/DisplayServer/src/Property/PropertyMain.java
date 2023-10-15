package Property;

import WebserviceModule.Jersey.Post;
import WebserviceModule.response.PropertyResponse;

public class PropertyMain {
    public static void main(String[] args) throws Exception {
        Post<PropertyResponse> ps = new Post<PropertyResponse>("http://dylan-aspireek571g:8080/Property/resources/property/getByNIC") ;
        PropertyResponse obj = new PropertyResponse();
        obj.setCardId("12345abc");
        System.out.println(ps.getObject( obj, PropertyResponse [].class));
    }
}
