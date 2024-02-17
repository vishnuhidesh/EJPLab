// BankImpl.java
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
public class BankImpl extends UnicastRemoteObject implements Bank {
    private Map<String, Double> accountBalances;
    public BankImpl() throws RemoteException {
        super();
        accountBalances = new HashMap<>();
    }
    @Override
    public synchronized void deposit(String accountNumber, double amount) throws RemoteException {
        double balance = accountBalances.getOrDefault(accountNumber, 0.0);
        balance += amount;
        accountBalances.put(accountNumber, balance);
        System.out.println("Deposited $" + amount + " into account " + accountNumber);
    }
    @Override
    public synchronized void withdraw(String accountNumber, double amount) throws RemoteException {
        double balance = accountBalances.getOrDefault(accountNumber, 0.0);
        if (balance >= amount) {
            balance -= amount;
            accountBalances.put(accountNumber, balance);
            System.out.println("Withdrawn $" + amount + " from account " + accountNumber);
        } else {
            System.out.println("Insufficient funds in account " + accountNumber);
        }
    }
    @Override
    public synchronized double checkBalance(String accountNumber) throws RemoteException {
        return accountBalances.getOrDefault(accountNumber, 0.0);
    }
}
