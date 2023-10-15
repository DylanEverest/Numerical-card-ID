package Property;

import Jersey.Post;
import response.PropertyResponse;

public class PropertyMain {
    public static void main(String[] args) throws Exception {

        Post<PropertyResponse> ps = new Post<PropertyResponse>("http://dylan-aspireek571g:8080/Property/resources/property/getByNIC") ;
        PropertyResponse obj = new PropertyResponse();
        obj.setCardId("4561dsd");
        ps.getObject( obj, PropertyResponse [].class);
    }
}
