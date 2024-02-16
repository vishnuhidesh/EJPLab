import java.sql.*;
class EJP2 {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Db1", "root", "gct2018");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("select * from student");
            System.out.println("Print records from bottom to top");
            rs.afterLast();
            while (rs.previous()) {
                System.out.println(rs.getString(1) + " " + rs.getInt(2) + " " + rs.getString(3));
            }
            System.out.println("To print 3rd record data using absolute(3):");
            rs.absolute(3);
            System.out.println(rs.getString(1) + " " + rs.getInt(2) + " " + rs.getString(3));
            System.out.println("print 2rd record data using relative(-1)");

            rs.relative(-1);
            System.out.println(rs.getString(1) + " " + rs.getInt(2) + " " + rs.getString(3));
            System.out.println("print the first record after moving to first position with first(): ");
            rs.first();
            System.out.println(rs.getString(1) + " " + rs.getInt(2) + " " + rs.getString(3));
            System.out.println("print the last record after moving to last record using last():");
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
            System.out.println(e);
        }
    }
}