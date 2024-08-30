import java.sql.*;
public class batchProcesingWithPST{
 public static void main(String[] args) throws Exception {
       Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/mydb";
        String us="root";
        String ps="tiger";
        try {
            Connection con=DriverManager.getConnection(url,us,ps);
            System.out.println("Connection sucessfully........!");
            PreparedStatement pst=con.prepareStatement("Insert into student1 value(?,?,?)");
            //add batch 1
            pst.setInt(1,456);
            pst.setString(2,"sameer");
            pst.setString(3,"Parali");
            pst.addBatch();
            //add batch 2
            pst.setInt(1,456);
            pst.setString(2,"Prathmesh");
            pst.setString(3,"nashik");
            pst.addBatch();
            //add batch 3
            pst.setInt(1,456);
            pst.setString(2,"sakhi");
            pst.setString(3,"bombay");
            pst.addBatch();
            int r[]=pst.executeBatch();
            int rec=0;
            for (int i=0;i<r.length;i++) {
                rec+=r[i];
            }
            System.out.println("Record insertion is:"+rec);
            pst.close();
            con.close();
            
        } catch (SQLException e) {
            System.out.println("Error 404");
        }
    }  
}  

// Connection sucessfully........!
// Record insertion is:1
// 456	sameer	    Parali

// Connection sucessfully........!
// Record insertion is:3
// 456	sameer	    Parali
// 456	Prathmesh	nashik
// 456	sakhi	    bombay