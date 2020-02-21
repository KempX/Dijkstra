import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.*;

public class Dijkstra extends Application {
    private Network network;
    private List<Node> unvisited = new ArrayList<>(createUnvisited());
    private final int infinite = 9999;
    private Node start; //= network.getNodeByName("Cham");
    private Node destination; //= network.getNodeByName("Malters");
    private Node currentNode;
    private List<Node> nodes = network.getNodes();
    private StringProperty route = new SimpleStringProperty("foo");

    public static void main(String[] args) {
        launch(args);
    }

    private void run() {
        // Schritt 2
        for(Node i: nodes){
            i.setCurrentDistance(infinite);
        }
        start.setCurrentDistance(0);
        currentNode = start;

        // Schritt 3
        List<Node> neighbours = start.getNeighbours();
        for (Node i : neighbours){
            int tempDistance;
            tempDistance = network.getDistance(currentNode,i);
            if (tempDistance < currentNode.getCurrentDistance()){
                currentNode.setCurrentDistance(tempDistance);
                i.setPredecessor(currentNode);
            }
        }

        // Schritt 4
        currentNode.setAsVisited();
        unvisited.remove(currentNode);

        // Schritt 5
        for (Node i: unvisited){
            int temp = i.getCurrentDistance();



        }
    }

    private void loadDistances() {
        try {
            network = new Network("Distanzen.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<Node> createUnvisited() {
        unvisited = network.getNodes();
        return unvisited;
    }

    public List<Node> getNodes(){
        return network.getNodes();
    }

    public void setStart(Node start){
        this.start = start;
    }

    public void setDestination(Node destination){
        this.destination = destination;
    }

    public Node getNodeByName(String name){
        return network.getNodeByName(name);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.loadDistances();
        dijkstra.run();

        Presenter presenter = new Presenter(dijkstra);

        FXMLLoader loader= new FXMLLoader(getClass().getResource("view.fxml"));
        loader.setController(presenter);
        GridPane root = loader.load();

        initScene(primaryStage, root);

        primaryStage.setTitle("Dijkstra");

        primaryStage.show();
    }

    private void initScene(Stage primaryStage, GridPane root){
        final int width = 300;
        final int height = 300;
        Scene scene = new Scene(root, width, height);
        primaryStage.setScene(scene);
    }
}
