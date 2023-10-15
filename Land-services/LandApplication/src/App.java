
import java.sql.SQLException;

import databaseconnectivity.SQLiteConnection;
import models.PropertyView;
import response.PropertyResponse;

public class App {
    public static void main(String[] args) throws SQLException {

        PropertyView[] views = PropertyView.selectFromPropertyView(new SQLiteConnection("/home/dylan/property"), "41651sa");

        PropertyResponse[] babas = new PropertyResponse[views.length];

        for (int i = 0; i < babas.length; i++) 
        {
            babas[i] = new PropertyResponse(views[i].getPropertyId(), views[i].getAddress(), views[i].getPropertyPersonId(), views[i].getCardId(), views[i].getPurchaseDate() ,null);
        }
    }    
}
