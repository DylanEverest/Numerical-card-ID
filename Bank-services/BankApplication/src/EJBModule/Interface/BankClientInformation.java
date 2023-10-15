import EJBModule.Response.BankClient;

@Remote
public interface BankClientInformation 
{

    public abstract BankClient getInformation(String NCI);

}