package Property;

import Converter.Converter;
import Health.HealthAccess;
import WebserviceModule.Jersey.Post;
import WebserviceModule.response.GeometryProperty;
import WebserviceModule.response.PropertyPerson;
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

    public static GeometryProperty [] getPropertiesWithCoordinates(String NIC) throws Exception 
    {
        Post<String> post = new Post<String>("http://dylan-aspireek571g:8080/Property/resources/property/map");

        return (GeometryProperty []) post.getObject(NIC, GeometryProperty [].class);
    }

    public static Boolean insertPropertiesAdress(GeometryProperty geo) throws Exception
    {

        Post<GeometryProperty> post = new Post<GeometryProperty>("http://dylan-aspireek571g:8080/Property/resources/property/newadress");

        return ( ((Boolean)post.getObject(geo ,Boolean.class))) ;
    }



    public static String getHTMLProperties(String NIC) throws Exception 
    {
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
                "                <a href='MapSpecific.jsp?adressID="+inf[i].getPropertyId()+"'> Adress :"+ inf[i].getAddress()+ " </a></span>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    </div>\n" 
                ;
            }
        }
        return html;
    }


    public static String getScriptMap(String adressID) throws Exception
    {
        GeometryProperty geos= PropertyAccess.getGeometryProperty(adressID);

        String arrayMap = Converter.getArrayMap(geos);

        String map = "<script>\n" +
                    "var map = L.map('map').setView([-18.766947, 46.869107], 6.2);\n" +
                    "L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {\n" +
                    "maxZoom: 10000000,\n" +
                    "attribution: '&copy; <a href=\"http://www.openstreetmap.org/copyright\">OpenStreetMap</a>'\n" +
                    "}).addTo(map);\n" +
                    "var array_lglt ="+arrayMap +" ;\n" +
                    "var polygon = L.polygon(array_lglt).addTo(map);\n" +
                    "function addCoordinate(coupleLtLg) {\n" +
                    "array_lglt.push([coupleLtLg.lat, coupleLtLg.lng]);\n" +
                    "L.marker([coupleLtLg.lat, coupleLtLg.lng]).addTo(map);\n" +
                    "drawPolygon();\n" +
                    "duplicateLongitudeLatitude(coupleLtLg.lat, coupleLtLg.lng);\n" +
                    "}\n" +
                    "function drawPolygon() {\n" +
                    "map.removeLayer(polygon);\n" +
                    "polygon = L.polygon(array_lglt);\n" +
                    "polygon.addTo(map);\n" +
                    "}\n" +
                    "function duplicateLongitudeLatitude(latitude, longitude) {\n" +
                    "const container = document.querySelector('.dash-address-manipulation');\n" +
                    "addFieldset(container, latitude, longitude);\n" +
                    "}\n" +
                    "function onMapClick(e) {\n" +
                    "addCoordinate(e.latlng);\n" +
                    "}\n" +
                    "map.on('click', onMapClick);\n" +
                    "// INPUT\n" +
                    "const addButton = document.getElementById('additems');\n" +
                    "const deleteButton = document.getElementById('deleteitems');\n" +
                    "const container = document.querySelector('.dash-address-manipulation');\n" +
                    "const refreshButton = document.getElementById('refreshitems');\n" +
                    "addButton.addEventListener('click', function (event) {\n" +
                    "event.preventDefault();\n" +
                    "addFieldset(container);\n" +
                    "});\n" +
                    "deleteButton.addEventListener('click', function (event) {\n" +
                    "event.preventDefault();\n" +
                    "removeLastFieldset(container);\n" +
                    "});\n" +
                    "refreshButton.addEventListener('click', function (event) {\n" +
                    "event.preventDefault();\n" +
                    "const fieldsets = container.querySelectorAll('.gl-inline');\n" +
                    "while (fieldsets.length > 1) {\n" +
                    "container.removeChild(fieldsets[fieldsets.length - 1]);\n" +
                    "}\n" +
                    "});\n" +
                    "function createFieldset(latitude, longitude) {\n" +
                    "const fieldset = document.createElement('div');\n" +
                    "fieldset.className = 'gl-inline';\n" +
                    "fieldset.innerHTML = \n" +
                    "'<div class=\"u-s-m-b-30\">' +\n" +
                    "'<label class=\"gl-label\" for=\"latitude\">Latitude *</label>' +\n" +
                    "'<input name=\"latitude[]\" class=\"input-text input-text--primary-style\" type=\"text\" id=\"latitude\" placeholder=\"Latitude\" value=\"' + latitude + '\">' +\n" +
                    "'</div>' +\n" +
                    "'<div class=\"u-s-m-b-30\">' +\n" +
                    "'<label class=\"gl-label\" for=\"longitude\">Longitude *</label>' +\n" +
                    "'<input name=\"longitude[]\" class=\"input-text input-text--primary-style\" type=\"text\" id=\"longitude\" placeholder=\"Longitude\" value=\"' + longitude + '\">' +\n" +
                    "'</div>';\n" +
                    "return fieldset;\n" +
                    "}\n" +
                    "function addFieldset(container, latitude, longitude) {\n" +
                    "const newFieldset = createFieldset(latitude, longitude);\n" +
                    "const lastFieldset = container.lastElementChild;\n" +
                    "container.insertBefore(newFieldset, lastFieldset);\n" +
                    "}\n" +
                    "function removeLastFieldset(container) {\n" +
                    "const fieldsets = container.querySelectorAll('.gl-inline');\n" +
                    "if (fieldsets.length >= 1) {\n" +
                    "container.removeChild(fieldsets[fieldsets.length - 1]);\n" +
                    "}\n" +
                    "}\n" +
                    "</script>";
    

    

        

        return map;
    }
    

    public static GeometryProperty getGeometryProperty(String [] inputsLatitudes ,String [] inputsLongitudes)
    {
        return new GeometryProperty(inputsLatitudes, inputsLongitudes) ;
    }


    public static void insertPropertyPerson(String  NIC , String adressID) throws Exception
    {
        PropertyPerson person = new PropertyPerson(NIC, Integer.parseInt(adressID)) ;
        
        Post <PropertyPerson> p = new Post<PropertyPerson>("http://dylan-aspireek571g:8080/Property/resources/property/associatePersonProperty");        
        
        HealthAccess.doesExist(NIC);

        p.getObject(person, Boolean.class) ;
        

    }


    public static GeometryProperty getGeometryProperty(String adressID) throws Exception
    {
        Post <String> p = new Post<String>("http://dylan-aspireek571g:8080/Property/resources/property/getGeom");         

        return ((GeometryProperty)p.getObject(adressID, GeometryProperty.class)) ;
    }



    public static void main(String[] args) throws Exception {
        // GeometryProperty[] vita = PropertyAccess. getPropertiesWithCoordinates("12345abc");
        // System.out.println("misa");
    }
}
