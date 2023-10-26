package CurrencyAccess;

import WebserviceModule.Jersey.Get;
import WebserviceModule.response.CurrencyResponse;

public class CurrencyAccess 
{
    public static double getCurrency(String convertor) throws Exception
    {

        System.out.println(convertor);
        Get get = new Get("http://dylan-aspireek571g:8080/Property/resources/property/getCurrency");

        CurrencyResponse response = ((CurrencyResponse)get.getObject(CurrencyResponse.class));



        if(convertor.equalsIgnoreCase("ariary"))
        {
            return response.getPrecisionAriary() ;
        }   
        else if (convertor.equalsIgnoreCase("euro")) 
        {
            return  response.getPrecisionAriary()  * response.getPrecisionEuro() ;
        }
        else if (convertor.equalsIgnoreCase("dollar"))
        {
            return response.getPrecisionAriary() * response.getPrecisionDollar();
        }
        else if (convertor.equalsIgnoreCase("euroAchat"))
        {
            return response.getPrecesionAriaryAchat() * response.getPrecisionEuro() ;
        }
        else if (convertor.equalsIgnoreCase("euroVente"))
        {
            return response.getPrecisionAriaryVente() * response.getPrecisionEuro() ;
        }

        else 
        {
            throw new Exception (" Unkwon currency") ;
        }
        
    }    
}
