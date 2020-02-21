import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Presenter implements Initializable {
    private final Dijkstra dijkstra;

    @FXML private ComboBox<String> start;
    @FXML private ComboBox<String> destination;
    @FXML private Button submit;

    public Presenter(Dijkstra dijkstra){
        this.dijkstra = dijkstra;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        start.getItems().addAll(dijkstra.getNodes().toString());
        destination.getItems().addAll(dijkstra.getNodes().toString());

        submit.setOnAction(this::submitButtonHandler);
    }

    public void submitButtonHandler(ActionEvent actionEvent) {
        dijkstra.setStart(dijkstra.getNodeByName(start.getValue()));
        dijkstra.setDestination(dijkstra.getNodeByName(destination.getValue()));
    }
}