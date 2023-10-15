package WebserviceModule.response;

import jakarta.json.bind.annotation.JsonbProperty;
import java.util.Date;

public class HealthInfo {
    @JsonbProperty("health_id")
    private int healthId;
    @JsonbProperty("card_id")
    private String cardId;
    @JsonbProperty("deseases")
    private String diseases;
    @JsonbProperty("date_begin")
    private Date dateBegin;
    @JsonbProperty("date_end")
    private Date dateEnd;

    // Constructeurs, getters et setters

    public HealthInfo() {
        // Constructeur par défaut
    }

    public HealthInfo(
        @JsonbProperty("health_id") int healthId,
        @JsonbProperty("card_id") String cardId,
        @JsonbProperty("deseases") String diseases,
        @JsonbProperty("date_begin") Date dateBegin,
        @JsonbProperty("date_end") Date dateEnd
    ) {
        this.healthId = healthId;
        this.cardId = cardId;
        this.diseases = diseases;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }

    public int getHealthId() {
        return healthId;
    }

    public void setHealthId(int healthId) {
        this.healthId = healthId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    // Getters et setters
}
