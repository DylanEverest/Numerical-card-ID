package response;

import jakarta.json.bind.annotation.JsonbProperty;

public class PropertyResponse {
    private int propertyId;
    private String address;
    private int propertyPersonId;
    private String cardId;
    private String purchaseDate;

    public PropertyResponse(@JsonbProperty("propertyId") int propertyId,@JsonbProperty("address") String address,
                    @JsonbProperty("propertyPersonId") int propertyPersonId, @JsonbProperty("cardId") String cardId, 
                    @JsonbProperty("purchaseDate") String purchaseDate) 
    {
        this.propertyId = propertyId;
        this.address = address;
        this.propertyPersonId = propertyPersonId;
        this.cardId = cardId;
        this.purchaseDate = purchaseDate;
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

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

}
