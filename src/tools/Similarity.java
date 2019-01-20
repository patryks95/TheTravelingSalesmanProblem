package tools;

import algorithms.GreedyCycle;
import algorithms.LocalSearchAlgorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Similarity {
    private List<Point> data;
    private List<List<List<Point>>> allPaths;
    private List<Double> allCosts;

    private Map<Double,Double> allCostsEdges = new HashMap<>();
    public Map<Double, Double> getAllCostsEdges() {
        return allCostsEdges;
    }

    public Similarity(List<Point> input) {
        this.data = input;
        allPaths = new LinkedList<>();
        allCosts = new LinkedList<>();
    }
    public void run() {
        for(int i = 0; i<1000; i++) {
            List<List<Point>> gcPoints = new GreedyCycle(data).getPaths();
            List<List<Point>> lcPoints = new LocalSearchAlgorithm().getOptimalPath(gcPoints.get(0), gcPoints.get(1));
            allPaths.add(lcPoints);
            Double dist = EuclideanDistance.pathLength(lcPoints.get(0)).doubleValue() +
                    EuclideanDistance.pathLength(lcPoints.get(1)).doubleValue();
            allCosts.add(dist);
        }

        for(int i = 0; i<allPaths.size(); i++) {
            List<List<Point>> path = allPaths.get(i);
            Double similarEdges = 0.0;
            List<List<Point>> pathPairs1 = generatePairs(path.get(0), path.get(1));
            for(List<List<Point>> path2: allPaths) {
                if (path != path2) {
                    List<List<Point>> pathPairs2 = generatePairs(path2.get(0), path2.get(1));
                    similarEdges += checkEdges(pathPairs1, pathPairs2);
                }
            }
            allCostsEdges.put(allCosts.get(i), similarEdges/999.0);
        }
    }

    private int checkEdges(List<List<Point>> pair1, List<List<Point>> pair2) {
        return (int) pair1.stream().filter(pair2::contains).count();
    }

    private List<List<Point>> generatePairs(List<Point> pathOne, List<Point> pathTwo) {
        List<List<Point>> pairs = new LinkedList<>();
        for(int i = 0; i < pathOne.size() - 1; i++) {
            List<Point> pair = new LinkedList<>();
            pair.add(pathOne.get(i));
            pair.add(pathOne.get(i+1));
            pairs.add(pair);
        }
        for(int i = 0; i < pathTwo.size() - 1; i++) {
            List<Point> pair = new LinkedList<>();
            pair.add(pathTwo.get(i));
            pair.add(pathTwo.get(i+1));
            pairs.add(pair);
        }
        return pairs;
    }
}
