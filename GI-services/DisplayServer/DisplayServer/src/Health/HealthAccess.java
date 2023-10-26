package Health;
// 
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

    public static HealthInfo [] getHealthInfo(String NIC) throws Exception
    {
        Get get2 = new Get("http://localhost:5198/Health/"+NIC);

        return (((HealthInfo[])(get2.getObject(HealthInfo[].class))) );
    }


    public static String getHTMLHealthInfo(String NIC) throws Exception{
        HealthInfo[] h= getHealthInfo(NIC);

        String html ="";
        if (h != null) 
        {
            for (int i = 0; i < h.length; i++) {
                html = html + "<div class=\"col-lg-4 col-md-6 u-s-m-b-30\">\n" +
                "    <div class=\"bp-mini bp-mini--img u-h-100\">\n" +
                "        <div class=\"bp-mini__thumbnail\">\n" +
                "            <a class=\"aspect aspect--bg-grey aspect--1366-768 u-d-block\">\n" +
                "                <img class=\"aspect__img\" src=\"images/blog/post-2.jpg\" alt=\"\"></a>\n" +
                "        </div>\n" +
                "        <div class=\"bp-mini__content\">\n" +
                "            <div class=\"bp-mini__stat\">\n" +
                "                <span class=\"bp-mini__stat-wrap\">\n" +
                "                    <span class=\"bp-mini__publish-date\">\n" +
                "                        <a>\n" +
                "                            <span> Since :"+ h[i].getDateBegin() +"</span></a></span></span>\n" +
                "                <span class=\"bp-mini__stat-wrap\">\n" +
                "                    <span class=\"bp-mini__author\">\n" +
                "                        <a>Dayle</a></span></span>\n" +
                "            </div>\n" +
                "            <span class=\"bp-mini__h1\">\n" +
                "                <a> Deseases name:"+ h[i].getDiseases()+ " </a></span>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    </div>\n" 
                ;
            }
        }
        return html;


    }
    public static void doesExist(String senderNIC) throws Exception
    {
        try 
        {
            HealthAccess.getGeneralINFO(senderNIC);
        } 
        catch (Exception e) 
        {
            throw new Exception("Unfound NIC"+senderNIC);
        }
    }

    public static String getHTMLGeneralInfo(String NIC) throws Exception {
        Info inf = HealthAccess.getGeneralINFO(NIC);

        if (inf == null){
            return "";
        }

        String name = inf.getName();

        String firstName = inf.getFirstName();

        String bd = inf.getBirthDate().toString();

        

        return "<div class=\"col-lg-4 col-md-6 u-s-m-b-30\">\n" +
               "    <div class=\"bp-mini bp-mini--img u-h-100\">\n" +
               "        <div class=\"bp-mini__thumbnail\">\n" +
               "            <a class=\"aspect aspect--bg-grey aspect--1366-768 u-d-block\">\n" +
               "                <img class=\"aspect__img\" src=\"images/blog/post-2.jpg\" alt=\"\"></a>\n" +
               "        </div>\n" +
               "        <div class=\"bp-mini__content\">\n" +
               "            <div class=\"bp-mini__stat\">\n" +
               "                <span class=\"bp-mini__stat-wrap\">\n" +
               "                    <span class=\"bp-mini__publish-date\">\n" +
               "                        <a>\n" +
               "                            <span>"+ bd +"</span></a></span></span>\n" +
               "                <span class=\"bp-mini__stat-wrap\">\n" +
               "                    <span class=\"bp-mini__author\">\n" +
               "                        <a>Dayle</a></span></span>\n" +
               "            </div>\n" +
               "            <span class=\"bp-mini__h1\">\n" +
               "                <a>"+name + firstName +" </a></span>\n" +
               "        </div>\n" +
               "    </div>\n"  
               ;
    }
    


    public static void main(String[] args) throws Exception 
    {
        System.out.println(HealthAccess.getGeneralINFO("ID002"));        

        System.out.println(HealthAccess.getHTMLHealthInfo("ID002"));
    }
}
