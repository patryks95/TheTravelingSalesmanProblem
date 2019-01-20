package sample;

import algorithms.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import tools.PathTool;
import tools.Point;
import tools.Similarity;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        List<Point> input = PathTool.getPath("kroA100.tsp");
        NearestNeighbor nn = new NearestNeighbor(input);
        GreedyCycle gc = new GreedyCycle(input);
        List<List<Point>> gcPoints = gc.getPaths();
        List<List<Point>> nnPoints =  nn.getPaths();
        Visualisation.show(input, nnPoints.get(0), nnPoints.get(1), "zadanie 1 Nearest Neighbor");
        Visualisation.show(input, gcPoints.get(0), gcPoints.get(1), "zadanie 1 Greedy Cycle");

        LocalSearchAlgorithm ls = new LocalSearchAlgorithm();
        List<List<Point>> lsPoints = ls.getOptimalPath(nnPoints.get(0), nnPoints.get(1));
        Visualisation.show(input, lsPoints.get(0), lsPoints.get(1), "zadanie 2");

        ILPAlgorithm ilp = new ILPAlgorithm();
        List<List<Point>> ilpPoints = ilp.getOptimalPath(new ArrayList<>(nnPoints.get(0)), new ArrayList<>(nnPoints.get(1)));
        Visualisation.show(input, ilpPoints.get(0), ilpPoints.get(1), "zadanie 3");

        Similarity similarity = new Similarity(input);
        similarity.run();
        Map<Double, Double> allCostsEdges = similarity.getAllCostsEdges();
        for(Double key : allCostsEdges.keySet()) {
            System.out.println(key + "," + allCostsEdges.get(key));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
