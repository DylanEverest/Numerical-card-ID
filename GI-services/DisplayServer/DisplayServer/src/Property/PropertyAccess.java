package Property;

import WebserviceModule.Jersey.Post;
import WebserviceModule.response.PropertyResponse;

public class PropertyAccess
{


    public static PropertyResponse [] getPropertiesByNIC(String NIC) throws Exception
    {
        Post<PropertyResponse> ps = new Post<PropertyResponse>("http://dylan-aspireek571g:8080/Property/resources/property/getByNIC") ;
        PropertyResponse obj = new PropertyResponse();
        obj.setCardId(NIC);

        return ((PropertyResponse [])ps.getObject( obj, PropertyResponse [].class)) ;
   
    }






    public static void main(String[] args) throws Exception {
        System.out.println(PropertyAccess.getPropertiesByNIC("12345abc")) ;
    }
}
