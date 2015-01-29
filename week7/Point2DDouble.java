public class Point2DDouble {

    private double x, y;

    public Point2DDouble(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distance(Point2DDouble pt1, Point2DDouble pt2) {
        double dX = pt1.getX() - pt2.getX();
        double dY = pt1.getY() - pt2.getY();
        return Math.sqrt(dX * dX + dY * dY);
    }

    public double getX() {
            return x;
    }

    public double getY() {
            return y;
    }

}
