package controller;

import databaseconnectivity.PgConnection;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import models.CurrencyTable;
import models.PropertyView;
import response.CurrencyResponse;
import response.PropertyResponse;

@Path("/property")
public class PropertyController 
{

    @POST
    @Path("/getByNIC")
    @Consumes(MediaType.APPLICATION_JSON)
    public PropertyResponse [] getPropertyByNIC(PropertyResponse propertyResponse) throws Exception
    {
        PropertyView[] views = PropertyView.selectFromPropertyView(new PgConnection("property","postgres","","jdbc:postgresql://localhost:5432/"), propertyResponse.getCardId());

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

}
