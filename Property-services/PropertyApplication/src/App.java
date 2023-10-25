

// import databaseconnectivity.PgConnection;
// import models.CurrencyTable;
// import models.PropertyView;
// import response.CurrencyResponse;
// import response.PropertyResponse;
// import java.sql.Connection;

// import databaseconnectivity.PgConnection;
// import jakarta.ws.rs.Consumes;
// import jakarta.ws.rs.GET;
// import jakarta.ws.rs.POST;
// import jakarta.ws.rs.Path;
// import jakarta.ws.rs.Produces;
// import jakarta.ws.rs.core.MediaType;
// import models.CurrencyTable;
// import models.GeometryModels;
// import models.PropertyView;
// import response.CurrencyResponse;
// import response.GeometryProperty;
// import response.PropertyResponse;


public class App {
    public static void main(String[] args) throws Exception {

    }    
}





/*
 * OLD TEST:
 * 
 * 
 * 
 *         // PropertyView[] views = PropertyView.selectFromPropertyView(new PgConnection("property","postgres","","jdbc:postgresql://localhost:5432/"), "ID002");
        // PropertyResponse[] babas = new PropertyResponse[views.length];

        // for (int i = 0; i < babas.length; i++) 
        // {
        //     babas[i] = new PropertyResponse(views[i].getPropertyId(), views[i].getAddress(), views[i].getPropertyPersonId(), views[i].getCardId(), views[i].getPurchaseDate() ,null);

        // }
        // System.out.println(babas[0].getAddress());

        // CurrencyTable cur=  CurrencyTable.getCurrencyNow(new PgConnection("property","postgres","","jdbc:postgresql://localhost:5432/").connectToDataBase(), false) ;

        // CurrencyResponse response = new CurrencyResponse();
        
        // response.setPrecisionAriary(cur.getPrecisionAriary());
        // response.setPrecisionEuro(cur.getPrecisionEuro());
        // response.setPrecisionDollar(cur.getPrecisionDollar());
 */


 /**
  * MAP


          String cardID = "12345abc";

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
        System.out.println(" x ");
  */



  /*
   *         GeometryProperty geometryProperty = new GeometryProperty(new String []{"45","12","10"},new String []{"45","12","10"} );
        PropertyResponse r= new PropertyResponse() ;
        r.setAddress("Andavamamba");
        geometryProperty.setProperty(r);

        GeometryModels geo = new GeometryModels();
        geo.setLatitude(geometryProperty.getLatitudes());
        geo.setLongitude(geometryProperty.getLongitudes());

        geo.setProperty(new PropertyView(0, geometryProperty.getProperty().getAddress(), 0, null, null, null));


        geo.insertAdress(new PgConnection("property","postgres","","jdbc:postgresql://localhost:5432/").connectToDataBase(), true);
   */