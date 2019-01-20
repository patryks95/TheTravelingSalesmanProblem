package algorithms;

import tools.Point;

import java.util.List;

public interface LocalSearch {

    public List<List<Point>> getOptimalPath(List<Point> path1, List<Point> path2);

    double getMinimalPathLength();
}
