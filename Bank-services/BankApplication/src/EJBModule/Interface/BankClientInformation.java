package EJBModule.Interface;

import EJBModule.Response.BankClient;
import jakarta.ejb.Remote;

@Remote
public interface BankClientInformation 
{

    public abstract BankClient getInformation(String NCI) throws Exception;

}