package sample;

import algorithms.*;
import com.sun.org.apache.xml.internal.security.utils.resolver.implementations.ResolverAnonymous;
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
import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


/*
        for (int i = 0 ; i<10; i++) {
            System.out.println("Iteracja: "+ i);
            List<Point> temp = PathTool.getPath("kroA100.tsp");
            NearestNeighbor nn = new NearestNeighbor(temp);
            List<List<Point>> points = nn.getPaths();
            System.out.println(PointListHelper.toString(points.get(0)));
            System.out.println(PointListHelper.toString(points.get(1)));
            LocalSearchAlgorithm localSearch = new LocalSearchAlgorithm();
            ILPAlgorithm ilp = new ILPAlgorithm(localSearch);
            List<List<Point>> pointsopt = ilp.getOptimalPath(points.get(0), points.get(1));
            Visualisation.show(temp, pointsopt.get(0), pointsopt.get(1), "Iteracja: "+i);


        }
        */


/*
        for (int i = 0 ; i<10; i++) {
            System.out.println("Iteracja: "+ i);
            List<Point> temp = PathTool.getPath("kroA150.tsp");
            NearestNeighbor nn = new NearestNeighbor(temp);
            List<List<Point>> points = nn.getPaths();
            System.out.println(PointListHelper.toString(points.get(0)));
            System.out.println(PointListHelper.toString(points.get(1)));
            LocalSearchAlgorithm localSearch = new LocalSearchAlgorithm();
            ILPAlgorithm ilp = new ILPAlgorithm(localSearch);
            List<List<Point>> pointsopt = ilp.getOptimalPath(points.get(0), points.get(1));
            Visualisation.show(temp, pointsopt.get(0), pointsopt.get(1), "Iteracja: "+i);


        }



*/






        for (int i = 0 ; i<10; i++) {
            System.out.println("Iteracja: " + i);

            List<Point> temp = PathTool.getPath("kroA150.tsp");
            List<Point> path1 = new ArrayList<>();
            List<Point> path2 = new ArrayList<>();
            Random r  = new Random();
            while (temp.size()!=0){

                Point tempPoint = temp.get(r.nextInt(temp.size()));
                temp.remove(tempPoint);
                Point tempPoint2 = temp.get(r.nextInt(temp.size()));
                temp.remove(tempPoint2);
                path1.add(tempPoint);
                path2.add(tempPoint2);

            }
            List<List<Point>> points = new ArrayList<List<Point>>();
            points.add(path1);
            points.add(path2);
            List<Point> all = new ArrayList<>();
            all.addAll(path1);
            all.addAll(path2);
            System.out.println(PointListHelper.toString(points.get(0)));
            System.out.println(PointListHelper.toString(points.get(1)));
            LocalSearchAlgorithm localSearch = new LocalSearchAlgorithm();
            List<List<Point>> pointsopt = localSearch.getOptimalPath(points.get(0), points.get(1));
            Visualisation.show(all, pointsopt.get(0), pointsopt.get(1), "Iteracja: " + i);
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
