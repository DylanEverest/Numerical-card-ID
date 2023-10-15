package Bank;

import EJBModule.Interface.BankClientInformation;
import EJBModule.Response.BankClient;
import EJBModule.glassfish7.Lookup;

public class BankAccess{
    
    
    
    public static BankClient getBankInfo(String NCI) throws Exception
    {
        Lookup<BankClientInformation> lookup = new Lookup<BankClientInformation>("localhost", "3700");
        BankClientInformation bk = lookup.getObject("Bank/ImplementationBankClientInformation", "EJBModule.Interface.BankClientInformation");

        return bk.getInformation(NCI);
    }

    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) throws Exception 
    {
        System.out.println(BankAccess.getBankInfo("54651248"));

    }

}
