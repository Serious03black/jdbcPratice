
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FUnction {
    public static void main(String[] args)throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        //create connection
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB","root","tiger");
    Statement st = con.createStatement();
    String query = " CREATE FUNCTION getsallary(name varchar(100) RETURNS DATE)"+
    "BEGIN"+
    "declare sallaryAmount sallary;"+
    "select sallary into sallaryAmount from employee where name = Name;"+
    "return sallaryAmount"+
    "END";
    ResultSet rs = st.executeQuery(query);
    System.out.println("function created");
    while(rs.next()){
        System.out.println("radhe");
    }

    }
}
