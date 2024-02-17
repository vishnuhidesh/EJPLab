// RMIExampleImplementation.java
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class RMIExampleImplementation extends UnicastRemoteObject implements RMIExampleInterface {
    public RMIExampleImplementation() throws RemoteException {
        super(); 
    }
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
