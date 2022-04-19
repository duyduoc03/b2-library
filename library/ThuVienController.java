package JP2.library;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ThuVienController implements Initializable {
    public TableView<Student> tbStudents;
    public TableColumn<Student,String> sName;
    public TableColumn<Student,String> sBirthday;
    public TableColumn<Student,String> sAddress;
    public TableColumn<Student,String> sEmail;
    public TableColumn<Student,String> sPhone;
    public TableView<Book> tbBooks;
    public TableColumn<Book,String> bName;
    public TableColumn<Book,String> bPN;
    public TableColumn<Book,Date> bPY;
    public TableColumn<Book,String> bAuthor;
    public TableColumn<Book,Double> bPrice;
    public TableView<Rent> tbBookRents;
    public TableColumn<Rent,Integer> rSID;
    public TableColumn<Rent,Integer> rBID;
    public TableColumn<Rent,Integer> rQTY;
    public TableColumn<Rent,Date> rStartDate;
    public TableColumn<Rent,Date> rEndDate;
    public TableColumn<Rent,Date> rUpdateDate;
    public TableColumn<Rent,Integer> rStatus;
    public TableColumn<Rent, String> rNote;

    public final static String connectionString = "jdbc:mysql://localhost:3306/duoc";
    public final static String user = "root";
    public final static String password = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        sBirthday.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        sAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        sEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        sPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        bName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        bPN.setCellValueFactory(new PropertyValueFactory<>("publisherName"));
        bPY.setCellValueFactory(new PropertyValueFactory<>("publishYear"));
        bAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        bPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        rSID.setCellValueFactory(new PropertyValueFactory<>("studentid"));
        rBID.setCellValueFactory(new PropertyValueFactory<>("bookid"));
        rQTY.setCellValueFactory(new PropertyValueFactory<>("qty"));
        rStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        rEndDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        rUpdateDate.setCellValueFactory(new PropertyValueFactory<>("updateDate"));
        rStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        rNote.setCellValueFactory(new PropertyValueFactory<>("note"));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,user,password);
            Statement stt = conn.createStatement();
            String txt_sql = "select * from students";
            ResultSet rs = stt.executeQuery(txt_sql);
            ObservableList<Student> list = FXCollections.observableArrayList();
            while (rs.next()){
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("studentName"),
                        Date.valueOf(rs.getString("dateOfBirth")),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("phoneNumber")
                );
                list.add(s);
            }
            tbStudents.setItems(list);
            String txt_sql2 = "select * from books";
            ResultSet rs2 = stt.executeQuery(txt_sql2);
            ObservableList<Book> list2 = FXCollections.observableArrayList();
            while (rs2.next()){
                Book s = new Book(
                        rs2.getInt("id"),
                        rs2.getString("bookName"),
                        rs2.getString("publisherName"),
                        Date.valueOf(rs2.getString("publishYear")),
                        rs2.getString("author"),
                        rs2.getDouble("price")
                );
                list2.add(s);
            }
            tbBooks.setItems(list2);
            String txt_sql3 = "select * from bookrents";
            ResultSet rs3 = stt.executeQuery(txt_sql3);
            ObservableList<Rent> list3 = FXCollections.observableArrayList();
            while (rs3.next()){
                Rent s = new Rent(
                        rs3.getInt("studentid"),
                        rs3.getInt("bookid"),
                        rs3.getInt("qty"),
                        Date.valueOf(rs3.getString("startDate")),
                        Date.valueOf(rs3.getString("endDate")),
                        Date.valueOf(rs3.getString("updateDate")),
                        rs3.getInt("status"),
                        rs3.getString("note")
                );
                list3.add(s);
            }
            tbBookRents.setItems(list3);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void backHome(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.rootStage.setScene(new Scene(root,600,400));
    }
}
