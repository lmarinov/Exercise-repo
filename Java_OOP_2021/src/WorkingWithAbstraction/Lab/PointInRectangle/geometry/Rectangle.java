package WorkingWithAbstraction.Lab.PointInRectangle.geometry;

public class Rectangle {
    private Point2D bottomLeft;
    private Point2D topRight;

    public Rectangle(Point2D botoomLeft, Point2D topRight) {
        this.bottomLeft = botoomLeft;
        this.topRight = topRight;
    }

    public boolean contains (Point2D point){
        return point.isGreaterOrEqualByX(bottomLeft)
                && point.isLessOrEqualByX(topRight)
                && point.isGreaterOrEqualByY(bottomLeft)
                && point.isLessOrEqualByY(topRight);
    }


}
