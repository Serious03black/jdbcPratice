import java.sql.*;
public class connection{
    public static void main(String[] args) throws Exception {
       Class.forName("org.postgresql.Driver");
        String url="jdbc:postgresql://localhost:5432/mydb";
        String us="postgres";
        String ps="tiger";
        try {
            Connection con=DriverManager.getConnection(url,us,ps);
             System.out.println("Connection sucessfully........!");
        } catch (Exception e) {
            System.out.println("Error 404");
            e.printStackTrace();
        }
    }  }  