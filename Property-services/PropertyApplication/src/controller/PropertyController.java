package controller;

import databaseconnectivity.PgConnection;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import models.PropertyView;
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

}
