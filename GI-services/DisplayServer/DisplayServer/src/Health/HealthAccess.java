package Health;

import WebserviceModule.Jersey.Get;
import WebserviceModule.response.HealthInfo;
import WebserviceModule.response.Info;

public class HealthAccess 
{
    public static Info getGeneralINFO(String NIC) throws Exception
    {
        Get get= new Get("http://localhost:5198/Info/"+NIC);        

        return (((Info)(get.getObject(Info.class))));        
    }

    public static HealthInfo getHealthInfo(String NIC) throws Exception
    {
        Get get2 = new Get("http://localhost:5198/Health/"+NIC);

        return (((HealthInfo)(get2.getObject(HealthInfo.class))) );
    }


    public static void main(String[] args) throws Exception 
    {
        // Get get= new Get("http://localhost:5198/Info/ID002");        

        // System.out.println(((Info)(get.getObject(Info.class))).getCard_id());

        Get get2 = new Get("http://localhost:5198/Health/ID002");

        System.out.println(((HealthInfo)(get2.getObject(HealthInfo.class))).getDiseases() );

    }
}
