package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CurrencyTable 
{
    double precisionAriary;
    double precisionEuro;
    double precisionDollar;
    
    public static CurrencyTable getCurrencyNow(Connection connection , boolean transaction) throws Exception
    {
        try
        {
            String selectQuery = "SELECT amount_Ariary ,amount_Euro ,amount_dollar FROM currencyequivalence WHERE dateEnd  IS NULL";   
            Statement statement = connection.createStatement();
            ResultSet res= statement.executeQuery(selectQuery);
            CurrencyTable currencyTable = new CurrencyTable();
            if( res.next())
            {
                currencyTable.setPrecisionAriary(res.getDouble("amount_Ariary"));
                currencyTable.setPrecisionEuro(res.getDouble("amount_Euro"));
                currencyTable.setPrecisionDollar(res.getDouble("amount_dollar"));
            }
            return currencyTable ;
        }
        catch (Exception e)
        {
            throw new Exception( "SELECT ERROR SQL CurrencyTable");
        }
        finally
        {
            if(!transaction)
                connection.close();
        }

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
