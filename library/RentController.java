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

public class RentController implements Initializable {
    public TableView<Rent> tbBookRents;
    public TableColumn<Rent,Integer> rSID;
    public TableColumn<Rent,Integer> rBID;
    public TableColumn<Rent,Integer> rQTY;
    public TableColumn<Rent,Date> rStartDate;
    public TableColumn<Rent,Date> rEndDate;
    public TableColumn<Rent,Date> rUpdateDate;
    public TableColumn<Rent,Integer> rStatus;
    public TableColumn<Rent, String> rNote;
    public TableColumn<Book, Button> rAction;
    public final static String connectionString = "jdbc:mysql://localhost:3306/duoc";
    public final static String user = "root";
    public final static String password = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rSID.setCellValueFactory(new PropertyValueFactory<>("studentid"));
        rBID.setCellValueFactory(new PropertyValueFactory<>("bookid"));
        rQTY.setCellValueFactory(new PropertyValueFactory<>("qty"));
        rStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        rEndDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        rUpdateDate.setCellValueFactory(new PropertyValueFactory<>("updateDate"));
        rStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        rNote.setCellValueFactory(new PropertyValueFactory<>("note"));
        rAction.setCellValueFactory(new PropertyValueFactory<>("action"));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,user,password);
            Statement stt = conn.createStatement();
            String txt_sql = "select * from bookrents";
            ResultSet rs = stt.executeQuery(txt_sql);

            ObservableList<Rent> list = FXCollections.observableArrayList();
            while (rs.next()){
                Rent s = new Rent(
                        rs.getInt("studentid"),
                        rs.getInt("bookid"),
                        rs.getInt("qty"),
                        Date.valueOf(rs.getString("startDate")),
                        Date.valueOf(rs.getString("endDate")),
                        Date.valueOf(rs.getString("updateDate")),
                        rs.getInt("status"),
                        rs.getString("note")
                );
                list.add(s);
            }
            tbBookRents.setItems(list);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void backHome(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.rootStage.setScene(new Scene(root,600,400));
    }

    public void addBookrents(ActionEvent event)  throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("RentForm.fxml"));
        Main.rootStage.setScene(new Scene(root,1000,800));
    }
}
