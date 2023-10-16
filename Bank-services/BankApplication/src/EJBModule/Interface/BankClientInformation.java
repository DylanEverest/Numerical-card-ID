package EJBModule.Interface;

import EJBModule.Response.BankClient;
import jakarta.ejb.Remote;

@Remote
public interface BankClientInformation 
{

    public abstract BankClient getInformation(String NCI) throws Exception;

    public abstract boolean insertAmount(BankClient bankClient) throws Exception;

    // public abstract boolean doTransaction(BankClient bankSender ,BankClient bankReceiver) throws Exception;
// 
    // public abstract boolean checkTransactionValidityAmount(BankClient bankSender ,BankClient bankReceiver) throws Exception ;
// 
    // public abstract double getCurrentAriary(String deviseID) throws Exception ;

    public boolean transferMoney(BankClient bankSender, BankClient bankReceiver) throws Exception ;

}