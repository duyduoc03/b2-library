package JP2.library;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HomeController {
    public void studentModule(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Students.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }

    public void bookModule(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Books.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }

    public void rentModul(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Rents.fxml"));
        Main.rootStage.setScene(new Scene(root,1000,800));
    }

    public void allModul(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ThuVien.fxml"));
        Main.rootStage.setScene(new Scene(root,1300,850));
    }
}
