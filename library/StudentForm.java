package JP2.library;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StudentForm {
    public TextField sName;
    public TextField sEmail;
    public TextField sPhone;
    public TextField sBirthday;
    public TextArea sAddress;
    public final static String connectionString = "jdbc:mysql://localhost:3306/duoc";
    public final static String user = "root";
    public final static String password = "";

    public void backStudents() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Students.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
    }

    public void submit(ActionEvent event) {
        String name = this.sName.getText();
        String email = this.sEmail.getText();
        String phone = this.sPhone.getText();
        String birthday = this.sBirthday.getText();
        String address = this.sAddress.getText();

        String sql_txt = "insert into students (studentName,dateOfBirth,address,email,phoneNumber) " +
                " values('"+name+"','"+birthday+"','"+address+"','"+email+"','"+phone+"')";
        System.out.println(sql_txt);
        try {
            // goi driver
            Class.forName("com.mysql.jdbc.Driver");
            // tao connect
            Connection conn = DriverManager.getConnection(connectionString,user,password);
            // khai bao Statement de truy van sql
            Statement stt = conn.createStatement();
            // insert
            stt.execute(sql_txt);
            this.backStudents();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
