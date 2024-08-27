import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class GUIStatement extends Frame implements ActionListener {
    Label lno, lname, lm1, lm2, lm3, lres;
    Choice ch;
    TextField tname, tm1, tm2, tm3, tres;
    Button bdetails, bresult;
    Connection con;

    ResultSet rs1, rs2;

    GUIStatement() {
        setLayout(new FlowLayout());
        setSize(500,400);
        setBackground(Color.lightGray);

        lno = new Label("Student No.");
        add(lno);

        ch = new Choice();
        add(ch);

        bdetails = new Button("Details");
        bdetails.addActionListener(this); // Add ActionListener to the "Details" button
        add(bdetails);

        lname = new Label("Name");
        add(lname);
        tname = new TextField(15);
        add(tname);

        lm1 = new Label("Marks 1");
        add(lm1);
        tm1 = new TextField(15);
        add(tm1);

        lm2 = new Label("Mark 2");
        add(lm2);
        tm2 = new TextField(15);
        add(tm2);

        lm3 = new Label("Mark 3");
        add(lm3);
        tm3 = new TextField(15);
        add(tm3);

        bresult = new Button("Result");
        bresult.addActionListener(this); // Add ActionListener to the "Result" button
        add(bresult);

        lres = new Label("Result is");
        add(lres);
        tres = new TextField(15);
        add(tres);

        myInit();

        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
    void myInit() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Register the MySQL JDBC driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "tiger");
            Statement st = con.createStatement();
            String query = "SELECT RollNumber FROM studentData";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ch.addItem(rs.getString(1));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bdetails) {
            try {
                String selectedRollNumber = ch.getSelectedItem();
                String query = "SELECT name, m1, m2, m3 FROM studentData WHERE RollNumber = ?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, selectedRollNumber);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    tname.setText(rs.getString("name"));
                    tm1.setText(rs.getString("m1"));
                    tm2.setText(rs.getString("m2"));
                    tm3.setText(rs.getString("m3"));
                } else {
                    tname.setText("");
                    tm1.setText("");
                    tm2.setText("");
                    tm3.setText("");
                    tres.setText("No data found");
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } else if (ae.getSource() == bresult) {
            try {
                int m1 = Integer.parseInt(tm1.getText());
                int m2 = Integer.parseInt(tm2.getText());
                int m3 = Integer.parseInt(tm3.getText());

                if (m1 < 35 || m2 < 35 || m3 < 35) {
                    tres.setText("Fail");
                } else {
                    tres.setText("Pass");
                }
            } catch (NumberFormatException nfe) {
                tres.setText("Invalid marks");
            }
        }
    } public static void main(String[] args) {
        new GUIStatement();
}
}

