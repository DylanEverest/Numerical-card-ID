package EJBModule.Response;

public class BankClient implements java.io.Serializable
{
    private String cardId;
    private double amount;
    private String currencyID ; 
    
    public BankClient() {
    }


    public BankClient(String cardId, double amount) 
    {
        setCardId(cardId);
        setAmount(amount);
    }
    
    
    public String getCardId() 
    {
        return cardId;
    }
    public void setCardId(String cardId) 
    {
        this.cardId = cardId;
    }
    public double getAmount() 
    {
        return amount;
    }
    public void setAmount(double amount) 
    {
        this.amount = amount;
    }


    public String getCurrencyID() 
    {
        return currencyID;
    }


    public void setCurrencyID(String currencyID) 
    {
        this.currencyID = currencyID;
    }

}
