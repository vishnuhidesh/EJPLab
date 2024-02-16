import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIExampleServer {
    public static void main(String[] args) {
        try {
            RMIExampleInterface remoteObject = new RMIExampleImplementation();
            LocateRegistry.createRegistry(1099); // Create the RMI registry
            Naming.rebind("rmi://localhost/MyRemoteObject", remoteObject); // Bind the remote object to a name
            System.out.println("Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
