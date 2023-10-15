package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import databaseconnectivity.SQLiteConnection;

import java.sql.Date; // Importez la classe Date pour utiliser les types DATE.

public class PropertyView {
    private int propertyId;
    private String address;
    private int propertyPersonId;
    private String cardId;
    private Date purchaseDate; // Utilisation du type Date pour purchaseDate.
    private Date sold; // Utilisation du type Date pour sold.

    public PropertyView(int propertyId, String address, int propertyPersonId, String cardId, Date purchaseDate, Date sold) {
        this.propertyId = propertyId;
        this.address = address;
        this.propertyPersonId = propertyPersonId;
        this.cardId = cardId;
        this.purchaseDate = purchaseDate;
        this.sold = sold;
    }

    // Getters and setters for the fields

    public static PropertyView[] selectFromPropertyView(SQLiteConnection sqliteConnection, String cardId) throws SQLException 
    {
        List<PropertyView> results = new ArrayList<>();
        Connection connection = sqliteConnection.connectToDatabase();
    
        String selectQuery = "SELECT * FROM property_view WHERE card_id = ? AND sold IS NOT NULL";
    
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) 
        {
            preparedStatement.setString(1, cardId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) 
            {
                while (resultSet.next()) 
                {
                    int propertyId = resultSet.getInt("property_id");
                    String address = resultSet.getString("address");
                    int propertyPersonId = resultSet.getInt("property_person_id");
                    String resultCardId = resultSet.getString("card_id");
                    Date purchaseDate = resultSet.getDate("purchase_date");
                    Date sold = resultSet.getDate("sold");
    
                    PropertyView propertyView = new PropertyView(propertyId, address, propertyPersonId, resultCardId, purchaseDate, sold);
                    results.add(propertyView);
                }
                return results.toArray(new PropertyView[results.size()]);
            }
        } 
        finally 
        {
            connection.close();
        }
    }
    
    

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPropertyPersonId() {
        return propertyPersonId;
    }

    public void setPropertyPersonId(int propertyPersonId) {
        this.propertyPersonId = propertyPersonId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getSold() {
        return sold;
    }

    public void setSold(Date sold) {
        this.sold = sold;
    }
}
