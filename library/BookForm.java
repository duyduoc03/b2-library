package JP2.library;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BookForm {
    public TextField bName;
    public TextField bPN;
    public TextField bPY;
    public TextField bAuthor;
    public TextField bPrice;
    public final static String connectionString = "jdbc:mysql://localhost:3306/duoc";
    public final static String user = "root";
    public final static String password = "";

    public void backBooks() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Books.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
    }

    public void submit(ActionEvent event) {
        String name = this.bName.getText();
        String pn = this.bPN.getText();
        String py = this.bPY.getText();
        String author = this.bAuthor.getText();
        String price = this.bPrice.getText();

        String sql_txt = "insert into books (bookName,publisherName,publishYear,author,price) " +
                " values('"+name+"','"+pn+"','"+py+"','"+author+"','"+price+"')";
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
