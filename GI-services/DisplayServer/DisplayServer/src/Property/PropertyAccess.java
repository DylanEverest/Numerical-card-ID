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

    public static String getHTMLProperties(String NIC) throws Exception {
        PropertyResponse [] inf = PropertyAccess.getPropertiesByNIC(NIC);

        String html ="";
        if (inf != null) 
        {

            for (int i = 0; i < inf.length; i++) {
                html = html + "<div class=\"col-lg-4 col-md-6 u-s-m-b-30\">\n" +
                "    <div class=\"bp-mini bp-mini--img u-h-100\">\n" +
                "        <div class=\"bp-mini__thumbnail\">\n" +
                "            <a class=\"aspect aspect--bg-grey aspect--1366-768 u-d-block\">\n" +
                "                <img class=\"aspect__img\" src=\"images/blog/post-2.jpg\" alt=\"\"></a>\n" +
                "        </div>\n" +
                "        <div class=\"bp-mini__content\">\n" +
                "            <div class=\"bp-mini__stat\">\n" +
                "                <span class=\"bp-mini__stat-wrap\">\n" +
                "                    <span class=\"bp-mini__publish-date\">\n" +
                "                        <a>\n" +
                "                            <span> Since :"+ inf[i].getPurchaseDate() +"</span></a></span></span>\n" +
                "                <span class=\"bp-mini__stat-wrap\">\n" +
                "                    <span class=\"bp-mini__author\">\n" +
                "                        <a>Dayle</a></span></span>\n" +
                "            </div>\n" +
                "            <span class=\"bp-mini__h1\">\n" +
                "                <a> Adress :"+ inf[i].getAddress()+ " </a></span>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    </div>\n" 
                ;
            }
        }
        return html;
    }
    

    public static GeometryProperty getGeometryProperty(String [] inputsLatitudes ,String [] inputsLongitudes)
    {
        return new GeometryProperty(inputsLatitudes, inputsLongitudes) ;
    }



    public static void main(String[] args) throws Exception {
        System.out.println(PropertyAccess.getHTMLProperties("ID002")) ;
    }
}
