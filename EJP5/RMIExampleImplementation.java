import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIExampleImplementation extends UnicastRemoteObject implements RMIExampleInterface {
    public RMIExampleImplementation() throws RemoteException {
        // Constructor
        super();  // Call the constructor of UnicastRemoteObject
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
