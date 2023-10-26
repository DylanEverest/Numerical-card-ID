package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PropertyPerson 
{
    int property_person_id ;

    int property_id ;

    String card_id  ;

    Date purchase_date ;

    Date sold ;

    public PropertyPerson(int property_id, String card_id) 
    {
     
        this.property_id = property_id;
     
        this.card_id = card_id;

    }

    public static PropertyPerson[] getAllPropertiesByCardID(String cardID, Connection connection, boolean closeable) throws SQLException
    {
        List<PropertyPerson> propertyPersons = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            String query = "SELECT * FROM property_person WHERE card_id = ? AND sold is null";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cardID);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                int propertyPersonId = resultSet.getInt("property_person_id");
                int propertyId = resultSet.getInt("property_id");
                String cardId = resultSet.getString("card_id");
                Date purchaseDate = resultSet.getDate("purchase_date");
                PropertyPerson propertyPerson = new PropertyPerson(propertyId, cardId);
                propertyPerson.setProperty_person_id(propertyPersonId);
                propertyPerson.setPurchase_date(purchaseDate);
                propertyPersons.add(propertyPerson);
            }
        } finally {
            if (closeable) {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            }
        }

        return propertyPersons.toArray(new PropertyPerson[0]);
    }

    public boolean insertPropertyAndPerson(Connection connection, boolean closeable) throws SQLException
    {
        PreparedStatement preparedStatement = null;
        
        try {
            String query = "INSERT INTO property_person (property_id, card_id) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, property_id);
            preparedStatement.setString(2, card_id);
            preparedStatement.executeUpdate();
            return true;
        } finally {
            if (closeable && preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public int getProperty_person_id() {
        return property_person_id;
    }

    public void setProperty_person_id(int property_person_id) {
        this.property_person_id = property_person_id;
    }

    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Date getSold() {
        return sold;
    }

    public void setSold(Date sold) {
        this.sold = sold;
    }
    

}
