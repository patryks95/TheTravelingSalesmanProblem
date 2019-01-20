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

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        for (int i = 0 ; i<10; i++) {
            System.out.println("Iteracja: "+ i);
            List<Point> temp = PathTool.getPath("kroA100.tsp");
            NearestNeighbor nn = new NearestNeighbor(temp);
            List<List<Point>> points = nn.getPaths();
            Visualisation.show(temp, points.get(0), points.get(1), "Iteracja: "+i);



        }




       /* NearestNeighbor nn = new NearestNeighbor(temp);
        List<List<Point>> points =  nn.getPaths();
        LocalSearchAlgorithm ls = new LocalSearchAlgorithm();
        Visualisation.show(temp, points.get(0), points.get(1), "zadanie 1");
        points = ls.getOptimalPath( new ArrayList<>(points.get(0)), new ArrayList<>(points.get(1)));
        Visualisation.show(temp, points.get(0), points.get(1), "zadanie 2");
        ILPAlgorithm ilp = new ILPAlgorithm(ls);
        points = ilp.getOptimalPath(new ArrayList<>(points.get(0)), new ArrayList<>(points.get(1)));
        Visualisation.show(temp, points.get(0), points.get(1), "zadanie 3");

        */




    }


    public static void main(String[] args) {
        launch(args);
    }



}
