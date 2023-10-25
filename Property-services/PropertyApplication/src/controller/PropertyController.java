package controller;

import java.sql.Connection;

import databaseconnectivity.PgConnection;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import models.CurrencyTable;
import models.GeometryModels;
import models.PropertyView;
import response.CurrencyResponse;
import response.GeometryProperty;
import response.PropertyResponse;

@Path("/property")
public class PropertyController 
{

    @POST
    @Path("/getByNIC")
    @Consumes(MediaType.APPLICATION_JSON)
    public PropertyResponse [] getPropertyByNIC(PropertyResponse propertyResponse) throws Exception
    {
        PropertyView[] views = PropertyView.selectFromPropertyView(new PgConnection("property","postgres","","jdbc:postgresql://localhost:5432/").connectToDataBase(), propertyResponse.getCardId() ,true);

        PropertyResponse[] babas = new PropertyResponse[views.length];

        for (int i = 0; i < babas.length; i++) 
        {
            babas[i] = new PropertyResponse(views[i].getPropertyId(), views[i].getAddress(), views[i].getPropertyPersonId(), views[i].getCardId(), views[i].getPurchaseDate() ,null);
        }
        return babas ;
    }

    @GET
    @Path("/getCurrency")
    @Produces(MediaType.APPLICATION_JSON)
    public CurrencyResponse getCurrencyNow() throws Exception
    {
        CurrencyTable cur=  CurrencyTable.getCurrencyNow(new PgConnection("property","postgres","","jdbc:postgresql://localhost:5432/").connectToDataBase(), false) ;

        CurrencyResponse response = new CurrencyResponse();
        
        response.setPrecisionAriary(cur.getPrecisionAriary());
        response.setPrecisionEuro(cur.getPrecisionEuro());
        response.setPrecisionDollar(cur.getPrecisionDollar());
        response.setPrecesionAriaryAchat(cur.getPrecesionAriaryAchat());
        response.setPrecisionAriaryVente(cur.getPrecisionAriaryVente());

        return response;
    }

    @POST
    @Path("/newadress")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean insertAdress(GeometryProperty geometryProperty) throws Exception
    {

        GeometryModels geo = new GeometryModels();
        geo.setLatitude(geometryProperty.getLatitudes());
        geo.setLongitude(geometryProperty.getLongitudes());

        geo.setProperty(new PropertyView(0, geometryProperty.getProperty().getAddress(), 0, null, null, null));


        return geo.insertAdress(new PgConnection("property","postgres","","jdbc:postgresql://localhost:5432/").connectToDataBase(), true);

    }
    
    @POST
    @Path("/map")
    @Produces(MediaType.APPLICATION_JSON)
    public GeometryProperty[] getMap(String cardID) throws Exception
    {
        Connection con = new PgConnection("property","postgres","","jdbc:postgresql://localhost:5432/").connectToDataBase();
        GeometryModels [] geos = GeometryModels.selectAllByCardID(con, cardID, false);

        con.close();        

        // tranform datas
        GeometryProperty [] res = new GeometryProperty[geos.length];
        for (int i = 0; i < res.length; i++) {
            
            res[i] = new GeometryProperty();
            
            res[i].setLatitudes(geos[i].getLatitude());
            res[i].setLongitudes(geos[i].getLongitude());
            GeometryModels g =geos [i] ;
            res[i].setProperty( new PropertyResponse(g.getProperty().getPropertyId(), g.getProperty().getAddress(), g.getProperty().getPropertyPersonId(), cardID, g.getProperty().getPurchaseDate(), g.getProperty().getSold()));
        }

        return res;
        
    }


}
