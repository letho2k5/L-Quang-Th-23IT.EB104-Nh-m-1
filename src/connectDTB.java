import java.sql.Connection;
import java.sql.DriverManager;
public class connectDTB {
    private Connection conn;

    public connectDTB() {
        try {
            String dbURL = "jdbc:sqlserver://DESKTOP-R4TO9PD\\MSSQLSERVER01;databaseName=employee;user=sa;password=12345;encrypt=true;trustServerCertificate=true";
            this.conn = DriverManager.getConnection(dbURL);
            System.out.println("Connected to the database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}