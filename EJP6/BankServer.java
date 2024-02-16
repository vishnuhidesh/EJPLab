import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class BankServer {
    public static void main(String[] args) {
        try {
            Bank bank = new BankImpl();

            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost/BankService", bank);

            System.out.println("Bank Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
