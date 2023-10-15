package EJBModule.Implementation;

import EJBModule.Interface.BankClientInformation;
import EJBModule.Response.BankClient;
import databaseconnectivity.MysqlConnection;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import models.BankAccountTransaction;

@Stateless
@Remote(BankClientInformation.class)
public class ImplementationBankClientInformation implements BankClientInformation
{

    @Override
    public BankClient getInformation(String NCI) throws Exception 
    {
        double amount =  BankAccountTransaction.getTotalAmountByCardId(
                                        new MysqlConnection("bank","root", "root", 
                                                                "jdbc:mysql://localhost:3306/"),
                                                                       NCI, false) ;

        BankClient client = new BankClient(NCI , amount);
        return client;
        
    }
    
}
