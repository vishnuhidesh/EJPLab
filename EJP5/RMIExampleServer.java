// RMIExampleServer.java
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
public class RMIExampleServer {
    public static void main(String[] args) {
        try {
            RMIExampleInterface remoteObject = new RMIExampleImplementation();
            LocateRegistry.createRegistry(1099); 
            Naming.rebind("rmi://localhost/MyRemoteObject", remoteObject); 
            System.out.println("Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
