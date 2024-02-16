import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import java.util.Properties;

public class Client {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Calculator";
            Arithmetic.Calculator calculator = Arithmetic.CalculatorHelper.narrow(ncRef.resolve_str(name));

            float operand1 = 10.5f;
            float operand2 = 5.0f;

            System.out.println("Adding: " + operand1 + " + " + operand2 + " = " + calculator.add(operand1, operand2));
            System.out.println("Subtracting: " + operand1 + " - " + operand2 + " = " + calculator.subtract(operand1, operand2));
            System.out.println("Multiplying: " + operand1 + " * " + operand2 + " = " + calculator.multiply(operand1, operand2));

            try {
                System.out.println("Dividing: " + operand1 + " / " + operand2 + " = " + calculator.divide(operand1, operand2));
            } catch (ArithmeticException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
