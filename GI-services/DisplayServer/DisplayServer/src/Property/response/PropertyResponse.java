package Property.response;

import jakarta.json.bind.annotation.JsonbProperty;

import java.io.Serializable;
import java.sql.Date; // Importez la classe Date pour utiliser les types DATE.

public class PropertyResponse implements Serializable{
    private int propertyId;
    private String address;
    private int propertyPersonId;
    private String cardId;
    private Date purchaseDate; // Utilisation du type Date pour purchaseDate.
    private Date sold; // Utilisation du type Date pour sold.

    public PropertyResponse() {
    }

    public PropertyResponse(@JsonbProperty("propertyId") int propertyId, @JsonbProperty("address") String address,
                           @JsonbProperty("propertyPersonId") int propertyPersonId, @JsonbProperty("cardId") String cardId,
                           @JsonbProperty("purchaseDate") Date purchaseDate, @JsonbProperty("sold") Date sold) 
    {
        this.propertyId = propertyId;
        this.address = address;
        this.propertyPersonId = propertyPersonId;
        this.cardId = cardId;
        this.purchaseDate = purchaseDate;
        this.sold = sold;
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
