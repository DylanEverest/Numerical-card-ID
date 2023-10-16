import EJBModule.Implementation.ImplementationBankClientInformation;
import EJBModule.Response.BankClient;

public class App {
    public static void main(String[] args) throws Exception {
        new ImplementationBankClientInformation().getInformation("ID002");
        // new ImplementationBankClientInformation().insertAmount(new BankClient("4512365",4562));
    }
}
