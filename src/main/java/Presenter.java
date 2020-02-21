import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.List;
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
        // todo: convert to string list
        List<Node> nodes = network.getNodes();
        start.getItems().addAll(nodes);
        destination.getItems().addAll(nodes);

        submit.setOnAction(this::submitButtonHandler);
    }

    public void submitButtonHandler(ActionEvent actionEvent) {
        String start = this.start.getValue();
        String destination = this.destination.getValue();

        start = "Cham";
        destination = "Malters";

        dijkstra.run(start, destination);
    }
}