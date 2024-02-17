import java.io.*;
import java.sql.*;
public class EJP1 {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/Db1";
            String username = "gct";
            String password = "password";
            try (Connection con = DriverManager.getConnection(url, username, password);
                 Statement stmt = con.createStatement();
                 BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int ch;
                while (true) {
                    System.out.println("1. Select");
                    System.out.println("2. Insert");
                    System.out.println("3. Update");
                    System.out.println("4. Delete");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice:");
                    ch = Integer.parseInt(br.readLine());
                    switch (ch) {
                        case 1:
                            printResultSet(stmt.executeQuery("select * from emp"));
                            break;
                        case 2:
                            insertRecord(br, stmt);
                            break;
                        case 3:
                            updateRecord(br, stmt);
                            break;
                        case 4:
                            deleteRecord(br, stmt);
                            break;
                        case 5:
                            return;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void printResultSet(ResultSet rs) throws Exception {
        ResultSetMetaData rm = rs.getMetaData();
        int n = rm.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= n; i++)
                System.out.print(rs.getString(i) + "\t\t");
            System.out.println();
        }
    }
    private static void insertRecord(BufferedReader br, Statement stmt) throws Exception {
        System.out.println("Enter Eno");
        String eno = br.readLine();
        System.out.println("Enter Name");
        String ename = br.readLine();
        System.out.println("Enter Salary");
        String salary = br.readLine();
        stmt.execute("insert into emp values(" + eno + ",'" + ename + "'," + salary + ")");
        System.out.println("1 Record inserted");
    }
    private static void updateRecord(BufferedReader br, Statement stmt) throws Exception {
        System.out.println("Enter E.No. to Edit :");
        String eno = br.readLine();
        System.out.println("Enter Name");
        String ename = br.readLine();
        System.out.println("Enter Salary");
        String salary = br.readLine();
        stmt.execute("update emp set ename='" + ename + "', salary= " + salary + " where eno=" + eno + "");
        System.out.println("1 Record Updated");
    }
    private static void deleteRecord(BufferedReader br, Statement stmt) throws Exception {
        System.out.println("Enter E.No. to Delete :");
        String eno = br.readLine();
        stmt.execute("delete from emp where eno =" + eno + "");
        System.out.println("Record Deleted");
    }
}