

import databaseconnectivity.PgConnection;
import models.CurrencyTable;
import models.PropertyView;
import response.CurrencyResponse;
import response.PropertyResponse;

public class App {
    public static void main(String[] args) throws Exception {

        // PropertyView[] views = PropertyView.selectFromPropertyView(new PgConnection("property","postgres","","jdbc:postgresql://localhost:5432/"), "ID002");
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

    }    
}
