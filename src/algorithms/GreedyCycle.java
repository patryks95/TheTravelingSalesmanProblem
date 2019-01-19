package algorithms;

import tools.EuclideanDistance;
import tools.PathTool;
import tools.Point;
import tools.listType;

import java.util.*;


import java.util.List;
public class GreedyCycle   implements  Metaheuristic  {

    private  List<Point> points;
    private GreedyCycle() {
    }

    public GreedyCycle(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public Point nextPoint(List<Point> points, Point FirstPoint, Point ActualPoint) {

        Map<Point, Long> distanceLengths = new HashMap<>();
        for (Point point: points) {
            Long summaryDistance = EuclideanDistance.calculate(FirstPoint, point) + EuclideanDistance.calculate(ActualPoint, point);
            distanceLengths.put(point, summaryDistance);
        }

        Map.Entry<Point, Long> min = Collections.min(distanceLengths.entrySet(),
                Comparator.comparing(Map.Entry::getValue));
        return  min.getKey();
    }





    @Override
    public List<List<Point>> getPaths() {

        List<Point> leftPoints = new ArrayList<>();
        List<Point> rightPoints = new ArrayList<>();
        Point point=PathTool.getRandomPoint(points);
        leftPoints.add(point);
        points.remove(point);
        point = PathTool.getRandomPoint(points);
        rightPoints.add(point);
        points.remove(point);

        while (points.size()>0){

            listType list = PathTool.getRandomTypeList(leftPoints, rightPoints);

            if(list==listType.Left){

                point = nextPoint(points,leftPoints.get(0), leftPoints.get(leftPoints.size() - 1));
                points.remove(point);
                leftPoints.add(point);
            }
            if(list==listType.Right){
                point = nextPoint(points, rightPoints.get(0), rightPoints.get(rightPoints.size() - 1));
                points.remove(point);
                rightPoints.add(point);
            }

            System.out.println(points);

        }
        List<List<Point>> lists = new ArrayList<List<Point>>();
        lists.add(leftPoints);
        lists.add(rightPoints);
        return  lists;




    }
}
