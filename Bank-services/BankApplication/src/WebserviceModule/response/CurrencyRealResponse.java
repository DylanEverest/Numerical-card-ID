package WebserviceModule.response;

public class CurrencyRealResponse 
{
    double price ;
    String currencyName ;
    
    public CurrencyRealResponse() {
    }

    public CurrencyRealResponse(double price, String currencyName) {
        setPrice(price);
        setCurrencyName(currencyName);
    }


    public double getPrice() 
    {
        return price;
    }
    public void setPrice(double price) 
    {
        this.price = price;
    }
    public String getCurrencyName() 
    {
        return currencyName;
    }
    public void setCurrencyName(String currencyName) 
    {
        this.currencyName = currencyName;
    }

    
}

