
import java.io.*;
import java.sql.*;
import java.util.*;

public class SelectTestProps {
    public static void main(String[] args)throws Exception {
    //locate property file 
    FileInputStream fis=new FileInputStream("jdbc PostGraseSql\\lec70_reading database connection file popstgrace sql\\lec70_postgrace.txt");
    //load the property file data to my util property class object
    Properties p=new Properties();
    p.load(fis);
    //read the data form the proeprties p object
    String dri=p.getProperty("mydriver");
    String url=p.getProperty("url");
    String pass=p.getProperty("pwd");
    String user=p.getProperty("pwd");

    String string=p.getProperty("qry");
    //crate the jdbc object or connetion 
    Class.forName(dri);
    Connection con=DriverManager.getConnection(url,user,pass);
    //write the persistence logic
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery(string);
    while(rs.next()){
        System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
        rs.close();
        con.close();
        st.close();
    }
    }
}
