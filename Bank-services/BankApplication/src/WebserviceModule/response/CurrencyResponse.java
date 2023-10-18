package WebserviceModule.response;

import java.io.Serializable;

import jakarta.json.bind.annotation.JsonbProperty;

public class CurrencyResponse implements Serializable
{
    double precisionAriary;
    double precisionEuro;
    double precisionDollar;
    double precesionAriaryAchat ;
    double precisionAriaryVente ;


    public CurrencyResponse(){}
    
    public CurrencyResponse(@JsonbProperty("precisionAriary")double precisionAriary,@JsonbProperty("precisionEuro") double precisionEuro,@JsonbProperty("precisionDollar") double precisionDollar
                        ,@JsonbProperty("precesionAriaryAchat") double precisionAriaryAchat , @JsonbProperty("precisionAriaryVente") double precisionAriaryVente ) {
        this.precisionAriary = precisionAriary;
        this.precisionEuro = precisionEuro;
        this.precisionDollar = precisionDollar;
        this.precesionAriaryAchat = precisionAriaryAchat ;
        this.precisionAriaryVente = precisionAriaryVente;
    }

    public double getPrecisionAriary() {
        return precisionAriary;
    }
    public void setPrecisionAriary(double precisionAriary) {
        this.precisionAriary = precisionAriary;
    }
    public double getPrecisionEuro() {
        return precisionEuro;
    }
    public void setPrecisionEuro(double precisionEuro) {
        this.precisionEuro = precisionEuro;
    }
    public double getPrecisionDollar() {
        return precisionDollar;
    }
    public void setPrecisionDollar(double precisionDollar) {
        this.precisionDollar = precisionDollar;
    }    
    public double getPrecesionAriaryAchat() {
        return precesionAriaryAchat;
    }
    public void setPrecesionAriaryAchat(double precesionAriaryAchat) {
        this.precesionAriaryAchat = precesionAriaryAchat;
    }
    public double getPrecisionAriaryVente() {
        return precisionAriaryVente;
    }
    public void setPrecisionAriaryVente(double precisionAriaryVente) {
        this.precisionAriaryVente = precisionAriaryVente;
    }    
}
