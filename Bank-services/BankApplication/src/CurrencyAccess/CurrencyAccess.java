package CurrencyAccess;

import WebserviceModule.Jersey.Post;
import WebserviceModule.response.CurrencyRealResponse;

public class CurrencyAccess 
{

    public static double getCurrency(String convertor) throws Exception
    {
        Post<String> post = new Post<String>("http://dylan-aspireek571g:8080/Property/resources/property/getRealCurrency");

        CurrencyRealResponse crp = ((CurrencyRealResponse)post.getObject(convertor, CurrencyRealResponse.class));

        return crp.getPrice() ;
    }



    // public static double getCurrency(String convertor) throws Exception
    // {

        // System.out.println(convertor);
        // Get get = new Get("http://dylan-aspireek571g:8080/Property/resources/property/getCurrency");

        // CurrencyResponse response = ((CurrencyResponse)get.getObject(CurrencyResponse.class));



        // if(convertor.equalsIgnoreCase("ariary"))
        // {
        //     return response.getPrecisionAriary() ;
        // }   
        // else if (convertor.equalsIgnoreCase("euro")) 
        // {
        //     return  response.getPrecisionAriary()  * response.getPrecisionEuro() ;
        // }
        // else if (convertor.equalsIgnoreCase("dollar"))
        // {
        //     return response.getPrecisionAriary() * response.getPrecisionDollar();
        // }
        // else if (convertor.equalsIgnoreCase("euroAchat"))
        // {
        //     return response.getPrecesionAriaryAchat() * response.getPrecisionEuro() ;
        // }
        // else if (convertor.equalsIgnoreCase("euroVente"))
        // {
        //     return response.getPrecisionAriaryVente() * response.getPrecisionEuro() ;
        // }

        // else 
        // {
        //     throw new Exception (" Unkwon currency") ;
        // }
        
    // }    
}
