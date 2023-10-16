package EJBModule.Implementation;


import java.sql.Connection;

import CurrencyAccess.CurrencyAccess;
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

    @Override
    public boolean insertAmount(BankClient bankClient) throws Exception 
    {
        BankAccountTransaction bankAccountTransaction = new BankAccountTransaction();
 
        bankAccountTransaction.setAmount(bankClient.getAmount());
        bankAccountTransaction.setCardId(bankClient.getCardId());

        return bankAccountTransaction.insertTransaction(new MysqlConnection("bank","root", "root", 
                                            "jdbc:mysql://localhost:3306/"), false);

    }

    @Override
    public boolean transferMoney(BankClient bankSender, BankClient bankReceiver) throws Exception
    {
        setAmountConvert(bankReceiver);

        setAmountConvert(bankSender);

        if(checkTransactionValidityAmount(bankSender, bankReceiver))
        {
            return doTransaction(bankSender, bankReceiver) ;
        }
        return false ;
    }


    private boolean doTransaction(BankClient bankSender, BankClient bankReceiver) throws Exception 
    {
        Connection connection =null;
        try
        {
            connection = new MysqlConnection("bank","root", "root", 
            "jdbc:mysql://localhost:3306/").connectToDatabase() ;
    
    
            BankAccountTransaction bankAccountTransaction = new BankAccountTransaction();
            bankAccountTransaction.setAmount(bankSender.getAmount());
            bankAccountTransaction.setCardId(bankSender.getCardId());
    
            bankAccountTransaction.insertTransaction(connection, false);
    
            bankAccountTransaction.setAmount(bankReceiver.getAmount());
            bankAccountTransaction.setCardId(bankReceiver.getCardId());
    
            bankAccountTransaction.insertTransaction(connection, false);

            return true;
        }
        catch(Exception e)
        {
            throw new Exception("SQLConnectivityProblem");
        }
        finally
        {
            if(connection!=null)
                connection.close();
        }
                                    
    }
    public double getCurrentAriary(String deviseID) throws Exception
    {
        return CurrencyAccess.getCurrency(deviseID);
    }


    private boolean checkTransactionValidityAmount(BankClient bankSender, BankClient bankReceiver) throws Exception {

        BankClient sender= getInformation(bankSender.getCardId()) ;
        /*
         * amount in BankClient sender is supposed to be negative if he/she wants to give money
         */
        double newAmountEstimated = sender.getAmount() + bankSender.getAmount();
        if( newAmountEstimated <0)
        {
            throw new Exception("Amount can't be negative");
        }
        return true;
    }

    public void setAmountConvert (BankClient bankClient) throws Exception
    {
        ImplementationBankClientInformation i = new ImplementationBankClientInformation() ;
        bankClient.setAmount(bankClient.getAmount() * i.getCurrentAriary(bankClient. getCurrencyID())) ;
        bankClient.setCurrencyID("Ariary");
    }
    
}
