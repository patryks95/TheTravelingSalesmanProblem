package algorithms;

import tools.EuclideanDistance;
import tools.Point;

import java.util.*;

public class ILPAlgorithm   {

    private double bestDistance;
    private List<List<Point>> listOfPoints;



    private  LocalSearch localSearchAlgorithm;

    private ILPAlgorithm() {
    }
    public ILPAlgorithm(LocalSearchAlgorithm temp) {
        this.localSearchAlgorithm = temp;
    }



    public List<List<Point>> getOptimalPath(List<Point> path1, List<Point> path2) {


        List<List<Point>> points = localSearchAlgorithm.getOptimalPath(path1, path2);
        List<List<Point>> newPoints = new ArrayList<List<Point>>();
        newPoints.add(path1);
        newPoints.add(path2);
        bestDistance = localSearchAlgorithm.getMinimalPathLength();
        int iteration =  0;

        while (iteration<5000){

           newPoints =  localSearchAlgorithm.getOptimalPath(new ArrayList(points.get(0)), new ArrayList(points.get(1)));
           double currentConst = localSearchAlgorithm.getMinimalPathLength();
            if(currentConst < bestDistance) {
                bestDistance = currentConst;
                iteration = 0;
                points = newPoints;
            }
            iteration++;

        }
        return  newPoints;













    }












    private List<Point> perturbation(List<Point> list){
        Random r = new Random();
        int pos1 = 1 + r.nextInt(list.size()/4);
        int pos2 = pos1 + 1 + r.nextInt(list.size()/4);
        int pos3 = pos2 + 1 + r.nextInt(list.size()/4);
        List<Point> pierwsza =  list.subList(0, pos1);
        List<Point> druga =  list.subList(pos1, pos2);
        List<Point> trzecia =  list.subList(pos2, pos3);
        List<Point> czwarta =  list.subList(pos3, list.size());
        List<Point> points = new ArrayList<>();
        points.addAll(pierwsza);
        points.addAll(czwarta);
        points.addAll(trzecia);
        points.addAll(druga);
        return  points;
    }



}
