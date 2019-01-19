package tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;

public class PathTool {

    private static Random random = new Random();

    public static  listType getRandomTypeList(List<Point> left, List<Point> right){

        if(left.size()<right.size()){
            return  listType.Left;
        }
        else
        if(left.size()>right.size()){
            return  listType.Right;
        }
        else {

            return  getRandomColor();
        }

    }
    public static List<Point> getPath(String fileName){
        List<Point> points = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data/" + fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.matches("[0-9]{1,4} [0-9]{1,4} [0-9]{1,4}")) {
                    String[] splited = line.split(" ");
                    points.add(new Point(Integer.parseInt(splited[1]), Integer.parseInt(splited[2])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return points;



    }

    private static listType getRandomColor() {
        return listType.values()[random.nextInt(listType.values().length)];
    }



    public static Point getRandomPoint(List<Point> points)
    {
        if(points.size()==0){
            return null;
        }
        return points.get(random.nextInt(points.size()));

    }

    public static double deltaCalculate(Point i, Point i_2,  Point j, Point j_2){

        return EuclideanDistance.calculate(i,j) + EuclideanDistance.calculate(i_2, j_2)-EuclideanDistance.calculate(i, i_2)-EuclideanDistance.calculate(j,j_2);
    }



}
