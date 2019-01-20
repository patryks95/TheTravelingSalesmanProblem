package algorithms;

import tools.EuclideanDistance;
import tools.PathTool;
import tools.Point;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LocalSearchAlgorithm implements  LocalSearch  {

    double bestDistLeft;
    double bestDistRight;



    public List<List<Point>> getOptimalPath(List<Point> path1, List<Point> path2) {
        List<Point> newLeftPath;
        bestDistLeft = EuclideanDistance.pathLength(path1);
        double newDistLeft;
        List<Point> newRightPath;
         bestDistRight = EuclideanDistance.pathLength(path2);
        double newDistRight;
        int swaps = 1;
        boolean test = false;
        while (swaps != 0) {
            swaps = 0;

            for (int i = 1; i < path1.size() - 2; i++) {
                for (int j = i + 1; j < path1.size() - 1; j++) {
                    if (deltaCalculate(path1.get(i), path1.get(i-1), path1.get(j), path1.get(j+1))) {

                        newLeftPath = swap(path1, i, j);

                        newDistLeft = EuclideanDistance.pathLength(newLeftPath);

                        if (newDistLeft < bestDistLeft) {
                            path1 = newLeftPath;
                            bestDistLeft = newDistLeft;
                            swaps++;

                        }
                    }
                }
            }
            for (int i = 1; i < path1.size()-1 ; i++) {
                for (int j = i; j < path2.size() - 1; j++) {
                    if (deltaNodeCalculate(path1.get(i - 1), path1.get(i), path1.get(i + 1), path2.get(j - 1), path2.get(j), path2.get(j + 1))) {
                        swapNode(path1, path2, i, j);
                        swaps++;
                        test = true;


                    }
                }
            }

            for (int i = 1; i < path2.size() - 2; i++) {
                for (int j = i + 1; j < path2.size() - 1; j++) {
                    if (deltaCalculate(path2.get(i), path2.get(i-1), path2.get(j), path2.get(j+1))) {

                        newRightPath = swap(path2, i, j);

                        newDistRight = EuclideanDistance.pathLength(newRightPath);

                        if (newDistRight < bestDistRight) {
                            path2 = newRightPath;
                            bestDistRight = newDistRight;
                            swaps++;

                        }
                    }
                }
            }




        }
        List<List<Point>> lists = new ArrayList<List<Point>>();
        lists.add(path1);
        lists.add(path2);
        return  lists;


    }






    private  List<Point> swap(List<Point> points, int i, int j) {
        List<Point> newTour = new ArrayList<>();

        for (int c = 0; c <= i - 1; c++) {
            newTour.add(points.get(c));
        }

        int dec = 0;
        for (int c = i; c <= j; c++) {
            newTour.add(points.get(j - dec));
            dec++;
        }

        int size = points.size();
        for (int c = j + 1; c < size; c++) {
            newTour.add(points.get(c));
        }

        return newTour;
    }

    private  void swapNode(List<Point> path1, List<Point> path2, int i , int j ) {
        Point temp = path1.get(i);
        path1.set(i, path2.get(j));
        path2.set(j, temp);
    }



    private boolean deltaCalculate(Point i, Point i_1, Point j, Point j__){

        return (EuclideanDistance.calculate(i,i_1)+EuclideanDistance.calculate(j__,j)) >= (EuclideanDistance.calculate(i,j__)  + EuclideanDistance.calculate(i_1,j));
    }


    private boolean deltaNodeCalculate(Point i_1, Point i, Point i__1, Point j_1, Point j, Point j__1){

        long ij = EuclideanDistance.calculate(i_1,j)+EuclideanDistance.calculate(j,i__1);
        long ii = EuclideanDistance.calculate(i_1,i)+EuclideanDistance.calculate(i,i__1);
        long ji = EuclideanDistance.calculate(j_1,i)+EuclideanDistance.calculate(i,j__1);
        long jj = EuclideanDistance.calculate(j_1,j)+EuclideanDistance.calculate(j,j__1);
        return (ij+ji-ii-jj<0);



    }


    public double getMinimalPathLength(){

        return  bestDistLeft+bestDistRight;

    }
}
