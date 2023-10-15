package Bank;

import EJBModule.Interface.BankClientInformation;
import EJBModule.Response.BankClient;
import EJBModule.glassfish7.Lookup;

public class BankAccess{
    
    
    
    public BankClient getBankInfo(String NCI) throws Exception
    {
        Lookup<BankClientInformation> lookup = new Lookup<BankClientInformation>("localhost", "3700");
        BankClientInformation bk = lookup.getObject("Bank/ImplementationBankClientInformation", "EJBModule.Interface.BankClientInformation");

        return bk.getInformation(NCI);
    }

    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) throws Exception 
    {
        Lookup<BankClientInformation> lookup = new Lookup<BankClientInformation>("localhost", "3700");

        BankClientInformation bankClientInformation=  lookup.getObject("Bank/ImplementationBankClientInformation", "EJBModule.Interface.BankClientInformation");

        System.out.println(bankClientInformation.insertAmount(new BankClient("54651248", 1561230))) ;
    }

}
