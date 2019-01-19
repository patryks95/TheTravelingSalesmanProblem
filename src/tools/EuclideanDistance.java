package tools;

import java.util.List;

public class EuclideanDistance {

    public static Long calculate(Point a, Point b){
        return Math.round(Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2)));
    }

    public static  Long pathLength(List<Point> path){

        Long distance = 0L;
        for (int i = 0; i < path.size() - 1; i++) {
            distance += calculate(path.get(i), path.get(i + 1));
        }
        distance += calculate(path.get(path.size() - 1), path.get(0));
        return distance;

    }

}
