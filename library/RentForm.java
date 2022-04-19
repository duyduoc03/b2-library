package JP2.library;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RentForm {
    public TextField rSID;
    public TextField rBID;
    public TextField rQ;
    public TextField rSD;
    public TextField rED;
    public TextField rUD;
    public TextField rS;
    public TextField rN;

    public final static String connectionString = "jdbc:mysql://localhost:3306/duoc";
    public final static String user = "root";
    public final static String password = "";

    public void backBooks() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Rents.fxml"));
        Main.rootStage.setScene(new Scene(root, 1000, 800));
    }
    public void submit(ActionEvent event) {
        String sid = this.rSID.getText();
        String bid = this.rBID.getText();
        String qty = this.rQ.getText();
        String sd = this.rSD.getText();
        String ed = this.rED.getText();
        String ud = this.rUD.getText();
        String status = this.rS.getText();
        String note = this.rN.getText();

        String sql_txt = "insert into bookrents (studentid,bookid,qty,startDate,endDate,updateDate,status,note) " +
                " values('"+sid+"','"+bid+"','"+qty+"','"+sd+"','"+ed+"','"+ud+"','"+status+"','"+note+"')";
        System.out.println(sql_txt);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,user,password);
            Statement stt = conn.createStatement();
            stt.execute(sql_txt);
            this.backBooks();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
