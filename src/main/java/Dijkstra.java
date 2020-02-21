import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.*;

public class Dijkstra  {
    private final int infinite = 9999;
    private Network network;
    private List<Node> unvisited;
    private Node start; ;
    private Node destination;
    private Node currentNode;
    private List<Node> nodes;
    private StringProperty route = new SimpleStringProperty("foo");

    public Dijkstra(Network network) {
        this.network = network;
        nodes = network.getNodes();
    }

    public void run(String startName, String destinationName) {
        this.start = network.getNodeByName(startName);
        this.destination = network.getNodeByName(destinationName);
        createUnvisited();

        System.out.println("From: " + startName + " To: " + destinationName);

        // Schritt 2
        for (Node i : nodes) {
            i.setCurrentDistance(infinite);
        }

        start.setCurrentDistance(0);
        currentNode = start;

        // Schritt 3
        List<Node> neighbours = start.getNeighbours();
        for (Node i : neighbours) {
            int tempDistance;
            tempDistance = network.getDistance(currentNode, i);
            if (tempDistance < currentNode.getCurrentDistance()) {
                currentNode.setCurrentDistance(tempDistance);
                i.setPredecessor(currentNode);
            }
        }

        // Schritt 4
        currentNode.setAsVisited();
        unvisited.remove(currentNode);

        // Schritt 5
        for (Node i : unvisited) {
            int temp = i.getCurrentDistance();


        }
    }

    private void createUnvisited() {
        unvisited = new ArrayList<>(network.getNodes());
    }
}
