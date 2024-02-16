import java.rmi.Naming;

public class RMIExampleClient {
    public static void main(String[] args) {
        try {
            RMIExampleInterface remoteObject = (RMIExampleInterface) Naming.lookup("rmi://localhost/MyRemoteObject");
            int result = remoteObject.add(30, 50);
            System.out.println("Remote method invocation result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
