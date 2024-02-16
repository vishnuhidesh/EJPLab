import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import java.util.Properties;

public class Server {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);

            CalculatorImpl calculatorImpl = new CalculatorImpl();

            POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPoa.the_POAManager().activate();

            org.omg.CORBA.Object ref = rootPoa.servant_to_reference(calculatorImpl);
            Arithmetic.Calculator href = Arithmetic.CalculatorHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Calculator";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, href);

            System.out.println("Server ready...");

            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
