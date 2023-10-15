package Health.Obj;

import java.io.Serializable;
import java.util.Date;

public class Info implements Serializable
{
    private String card_id;
    private String name;
    private String firstName;
    private Date birthDate;

    // Constructeurs, getters et setters

    public Info() {
        // Constructeur par défaut
    }

    public Info(String card_id, String name, String firstName, Date birthDate) {
        this.card_id = card_id;
        this.name = name;
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
