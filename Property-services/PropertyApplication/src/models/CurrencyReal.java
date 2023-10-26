package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CurrencyReal 
{
    double price ;
    String currencyName ;
    
    public CurrencyReal() {
    }

    public CurrencyReal(double price, String currencyName) {
        setPrice(price);
        setCurrencyName(currencyName);
    }

    public static CurrencyReal getCurrencyNow(Connection connection , boolean transaction ,String currencyName) throws Exception
    {
        try
        {
            String selectQuery = "SELECT price FROM CurrencyReal WHERE dateEnd  IS NULL AND currencyName LIKE '"+currencyName+"'";   
            Statement statement = connection.createStatement();
            ResultSet res= statement.executeQuery(selectQuery);
            CurrencyReal currencyTable = new CurrencyReal() ;
            if( res.next())
            {
                currencyTable.setPrice(res.getDouble("price"));
                currencyTable.setCurrencyName(currencyName);
            }
            return currencyTable ;
        }
        catch (Exception e)
        {
            System.out.println(e);
            throw new Exception( "SELECT ERROR SQL New CurrencyTable");
        }
        finally
        {
            if(!transaction)
                connection.close();
        }

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
