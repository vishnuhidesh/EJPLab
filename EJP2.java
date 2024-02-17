import java.sql.*;

public class EJP2 {
    public static void main(String args[]) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Db2", "gct", "password");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            System.out.println("Print records from bottom to top");
            rs.afterLast();
            while (rs.previous()) {
                System.out.println(rs.getString(1) + " " + rs.getInt(2) + " " + rs.getString(3));
            }

            System.out.println("To print 3rd record data using absolute(3):");
            rs.absolute(3);
            System.out.println(rs.getString(1) + " " + rs.getInt(2) + " " + rs.getString(3));

            System.out.println("Print 2nd record data using relative(-1)");
            rs.relative(-1);
            System.out.println(rs.getString(1) + " " + rs.getInt(2) + " " + rs.getString(3));

            System.out.println("Print the first record after moving to the first position with first(): ");
            rs.first();
            System.out.println(rs.getString(1) + " " + rs.getInt(2) + " " + rs.getString(3));

            System.out.println("Print the last record after moving to the last record using last():");
            rs.last();
            System.out.println(rs.getString(1) + " " + rs.getInt(2) + " " + rs.getString(3));

            System.out.println("Print records from top to bottom");
            rs.beforeFirst();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getInt(2) + " " + rs.getString(3));
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
