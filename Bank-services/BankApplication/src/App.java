import java.sql.Connection;

import EJBModule.Implementation.ImplementationBankClientInformation;
import EJBModule.Response.BankClient;
import databaseconnectivity.MysqlConnection;
import models.BankAccountTransaction;

public class App {
    public static void main(String[] args) throws Exception {
        // new ImplementationBankClientInformation().getInformation("ID002");
        // new ImplementationBankClientInformation().insertAmount(new BankClient("4512365",4562));

        // new ImplementationBankClientInformation().transferMoney(new BankClient("ID002", -12 , "Euro"),new BankClient("ID003", +12 , "Euro") ) ;
    }
}
