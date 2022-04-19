package JP2.library;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class BookController implements Initializable {
    public TableView<Book> tbBooks;
    public TableColumn<Book,String> bName;
    public TableColumn<Book,String> bPN;
    public TableColumn<Book,Date> bPY;
    public TableColumn<Book,String> bAuthor;
    public TableColumn<Book,Double> bPrice;
    public TableColumn<Book, Button> bAction;
    public final static String connectionString = "jdbc:mysql://localhost:3306/duoc";
    public final static String user = "root";
    public final static String password = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        bPN.setCellValueFactory(new PropertyValueFactory<>("publisherName"));
        bPY.setCellValueFactory(new PropertyValueFactory<>("publishYear"));
        bAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        bPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        bAction.setCellValueFactory(new PropertyValueFactory<>("action"));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,user,password);
            Statement stt = conn.createStatement();
            String txt_sql = "select * from books";
            ResultSet rs = stt.executeQuery(txt_sql);

            ObservableList<Book> list = FXCollections.observableArrayList();
            while (rs.next()){
                Book s = new Book(
                        rs.getInt("id"),
                        rs.getString("bookName"),
                        rs.getString("publisherName"),
                        Date.valueOf(rs.getString("publishYear")),
                        rs.getString("author"),
                        rs.getDouble("price")
                );
                list.add(s);
            }
            tbBooks.setItems(list);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void backHome(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.rootStage.setScene(new Scene(root,600,400));
    }

    public void addBook(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("BookForm.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
    }
}
