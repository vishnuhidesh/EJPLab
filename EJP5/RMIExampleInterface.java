import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIExampleInterface extends Remote {
    // Declare remote methods
    int add(int a, int b) throws RemoteException;
}
