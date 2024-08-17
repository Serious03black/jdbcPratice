import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class FetchFromDb{
    public static void main(String[] args) throws Exception{
        //load Driver Class
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Loded.....");
        //conncetion Establish 
            //Connection URl
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB","root","tiger");
        System.out.println("Connecting Sucessfully....");
        //Create Statement 
        Statement st=con.createStatement();
        String query="select * from employee";
        ResultSet rs=st.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt(1);
            String name=rs.getString(2);
            String Desg=rs.getString(3);
            String Dept=rs.getString(4);
            int sallary=rs.getInt(5);
            System.err.println("============================================");
            System.out.println("ID : "+id);
            System.err.println("----------------------------------------------");
            System.out.println("Name : "+name);
            System.err.println("----------------------------------------------");
            System.out.println("Desiganation : "+Desg);
            System.err.println("----------------------------------------------");
            System.out.println("Department : "+Dept);
            System.err.println("----------------------------------------------");
            System.out.println("Sallary : "+sallary);
             System.err.println("============================================");
        }
    }
}
