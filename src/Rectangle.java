//ID: 208748590

import java.util.List;
import java.util.ArrayList;

public class Rectangle {

    // Create local variables - obtained data:
    private Point upperLeft;
    private double width;
    private double height;

    // intermediate variables
    private Point downLeft;
    private Point upperRight;
    private Point downRight;

    // Create more variables - calculated lines - represents the rectangle:
    private Line leftLine;
    private Line rightLine;
    private Line upperLine;
    private Line downLine;

    // Constructor:

    /**
     * Create a new rectangle with location and width/height.
     * @param upperLeft - a Point.
     * @param width     dimension.
     * @param height    dimension.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;

        this.downLeft = getDownLeft(); //depends on given data - upperLeft and height
        this.upperRight = getUpperRight();
        this.downRight = getDownRight();

        this.leftLine = new Line(this.upperLeft, this.downLeft);
        this.rightLine = new Line(this.upperRight, this.downRight);
        this.upperLine = new Line(this.upperLeft, this.upperRight);
        this.downLine = new Line(this.downLeft, this.downRight);
    }  // end of Rectangle constructor

    /**
     * Return a (possibly empty) List of intersection points with the specified line.
     * @param line - to check with.
     * @return interPoints - intersection Points with the line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {

        List<Point> interPoints;
        interPoints = new ArrayList<Point>();

        if (line.isIntersecting(this.leftLine)) interPoints.add(line.intersectionWith(this.leftLine));
        if (line.isIntersecting(this.rightLine)) interPoints.add(line.intersectionWith(this.rightLine));
        if (line.isIntersecting(this.upperLine)) interPoints.add(line.intersectionWith(this.upperLine));
        if (line.isIntersecting(this.downLine)) interPoints.add(line.intersectionWith(this.downLine));
/*
        //DEBUG!!!----
        System.out.print(line.start().getX());
        System.out.print(" ");
        System.out.print(line.start().getY());
        System.out.print(" ");
        System.out.print(line.end().getX());
        System.out.print(" ");
        System.out.print(line.end().getY());
        System.out.println(" ");
        System.out.print(this.leftLine.start().getX());
        System.out.print(" ");
        System.out.print(this.leftLine.start().getY());
        System.out.print(" ");
        System.out.print(this.leftLine.end().getX());
        System.out.print(" ");
        System.out.print(this.leftLine.end().getY());
        System.out.println(" ");
        if ((line.isIntersecting(this.leftLine)) ||
                (line.isIntersecting(this.rightLine)) ||
                (line.isIntersecting(this.upperLine)) ||
                (line.isIntersecting(this.downLine))) System.out.println(" COLLISION COLLISION COLLISION !!!");
        System.out.println(interPoints.size());
        //DEBUG!!!----
*/
        return interPoints;
    }

    /**
     * A getter.
     * @return this.width.
     */
    // Return the width and height of the rectangle
    public double getWidth() {
        return this.width;
    }

    /**
     * A getter.
     * @return this.height.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * A getter.
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    //assuming height-var is legal (>0)

    /**
     * A getter.
     * @return new Point of DownLeft.
     */
    public Point getDownLeft() {
        return new Point(this.upperLeft.getX(), (this.upperLeft.getY() + this.height));
    }

    /**
     * A getter.
     * @return new Point of UpperRight.
     */
    public Point getUpperRight() {
        return new Point(this.upperLeft.getX() + getWidth(), this.upperLeft.getY());
    }

    /**
     * A getter.
     * @return new Point of DownRight.
     */
    public Point getDownRight() {
        return new Point(getUpperRight().getX(), (this.upperLeft.getY() + this.height));
    }

    //getters for the lines:

    /**
     * A getter.
     * @return this.leftLine.
     */
    public Line getLeftLine() {
        return this.leftLine;
    }

    /**
     * A getter.
     * @return this.RightLine.
     */
    public Line getRightLine() {
        return this.rightLine;
    }

    /**
     * A getter.
     * @return this.UpperLine.
     */
    public Line getUpperLine() {
        return this.upperLine;
    }

    /**
     * A getter.
     * @return this.DownLine.
     */
    public Line getDownLine() {
        return this.downLine;
    }

    /**
     * We check if a point is in a rectangle.
     * @param point - dot.
     * @return true or false.
     */
    public boolean isPointInRectangle(Point point) {
        if ((point.getX() >= this.getDownLeft().getX()) && (point.getX() <= this.getDownRight().getX()) &&
                (point.getY() >= this.getUpperLeft().getY()) && (point.getY() <= this.getDownLeft().getY()))
            return true;
        return false;
    }
}  // end of public class Rectangle



