package WebserviceModule.response;

import java.io.Serializable;

import jakarta.json.bind.annotation.JsonbProperty;

public class CurrencyResponse implements Serializable
{
    double precisionAriary;
    double precisionEuro;
    double precisionDollar;


    
    public CurrencyResponse(@JsonbProperty("precisionAriary")double precisionAriary,@JsonbProperty("precisionEuro") double precisionEuro,@JsonbProperty("precisionDollar") double precisionDollar) {
        this.precisionAriary = precisionAriary;
        this.precisionEuro = precisionEuro;
        this.precisionDollar = precisionDollar;
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
}
