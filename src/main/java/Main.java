import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        // załadowanie fxml
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainScreen.fxml"));
        // creacja Achnor Pane i załadowanie fxml i ba scene
        AnchorPane anchorPane;
        anchorPane = loader.load();
        Scene scene  =new Scene(anchorPane);
        // załadowanie scene na Stage i tytył
        primaryStage.setScene(scene);
        primaryStage.setTitle("Kalkulatorus !");
        // Wyświetlenie
        primaryStage.show();



    }
}
