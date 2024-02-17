// RMIExampleInterface.java
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface RMIExampleInterface extends Remote {
    int add(int a, int b) throws RemoteException;
}
