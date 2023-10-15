package EJBModule.glassfish7;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Lookup<T> {

    public static String ORBInitialHost = "org.omg.CORBA.ORBInitialHost";
    
    public static String ORBInitialPort = "org.omg.CORBA.ORBInitialPort";

    String host ;

    /*
     * default 3700
     */
    String port = "3700" ;

    public Lookup( String host , String port)
    {
        setHost(host);
        setPort(port);
    }

    @SuppressWarnings("unchecked")
                            // ("JarName/ImplementsNameOnly", "EJBModule.IRemote")
    public T getObject(String remoteimplementedWithSlash , String interfaceString) throws NamingException
    {
        Properties p = new Properties();
        
        p.setProperty(Lookup.ORBInitialHost, host);
        p.setProperty(Lookup.ORBInitialPort, port);

        InitialContext i = new InitialContext(p);

        return ((T)i.lookup("java:global/"+ remoteimplementedWithSlash +"!"+interfaceString));

    }

    public static String getORBInitialHost() 
    {
        return ORBInitialHost;
    }

    public static void setORBInitialHost(String oRBInitialHost) 
    {
        ORBInitialHost = oRBInitialHost;
    }

    public static String getORBInitialPort() 
    {
        return ORBInitialPort;
    }

    public static void setORBInitialPort(String oRBInitialPort) 
    {
        ORBInitialPort = oRBInitialPort;
    }

    public String getHost() 
    {
        return host;
    }

    public void setHost(String host) 
    {
        this.host = host;
    }

    public String getPort() 
    {
        return port;
    }

    public void setPort(String port) 
    {
        this.port = port;
    }
}
