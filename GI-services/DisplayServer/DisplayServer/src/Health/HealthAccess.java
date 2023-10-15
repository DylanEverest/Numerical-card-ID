package Health;

import Jersey.Get;
import Health.Obj.HealthInfo;
import Health.Obj.Info;

public class HealthAccess {
    public static void main(String[] args) throws Exception 
    {
        // Get get= new Get("http://localhost:5198/Info/ID002");        

        // System.out.println(((Info)(get.getObject(Info.class))).getCard_id());

        Get get2 = new Get("http://localhost:5198/Health/ID002");

        System.out.println(((HealthInfo)(get2.getObject(HealthInfo.class))).getDiseases() );

    }
}
