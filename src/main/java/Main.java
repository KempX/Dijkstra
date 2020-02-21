import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String path = "Distanzen.csv";

        Network network =  new Network(path);
        Dijkstra dijkstra = new Dijkstra(network);
        Presenter presenter = new Presenter(dijkstra);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
        loader.setController(presenter);
        Pane root = loader.load();

        initScene(primaryStage, root);

        primaryStage.setTitle("Dijkstra");

        primaryStage.show();

    }


    private void initScene(Stage primaryStage, Pane root) {
        final int width = 300;
        final int height = 300;
        Scene scene = new Scene(root, width, height);
        primaryStage.setScene(scene);
    }
}
