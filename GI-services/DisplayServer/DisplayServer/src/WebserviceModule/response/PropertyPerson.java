package WebserviceModule.response;

import java.io.Serializable;

import jakarta.json.bind.annotation.JsonbProperty;

public class PropertyPerson implements Serializable
{
    String cardID ;
    int propertyID ;
    
    public PropertyPerson() {
    }



    public PropertyPerson(@JsonbProperty("cardID") String cardID, @JsonbProperty("propertyID") int propertyID) 
    {
        this.cardID = cardID;
        this.propertyID = propertyID;
    }




    public String getCardID() {
        return cardID;
    }
    public void setCardID(String cardID) {
        this.cardID = cardID;
    }
    public int getPropertyID() {
        return propertyID;
    }
    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }
}
