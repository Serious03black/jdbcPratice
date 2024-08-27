import java.sql.*;
public class  PostgraceDataRetirve{
    public static void main(String[] args) throws Exception {
       Class.forName("org.postgresql.Driver");
        String url="jdbc:postgresql://localhost:5432/mydb";
        String us="postgres";
        String ps="tiger";
        try {
            Connection con=DriverManager.getConnection(url,us,ps);
            //  System.out.println("Connection sucessfully........!");
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from studentt");
             while(rs.next()){
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
             }
                    } catch (Exception e) {
            System.out.println("Error 404");
            e.printStackTrace();
        }


    }  
}  