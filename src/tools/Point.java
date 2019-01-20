package tools;

public class Point {

    private int x;
    private  int y;

    public int  id;
    public Point(int x, int y, int i) {
        this.x = x;
        this.y = y;
        this.id = i;

    }

    public Point(String x, String y, int i) {
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
        this.id = i;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
