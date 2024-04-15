//ID: 208748590

import java.util.List;

//This class defines a line.
public class Line {

    private Point start;
    private Point end;

    // constructor 1

    /**
     * This constructor gets 2 points and defines a line.
     * @param start
     * @param end
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // constructor 2

    /**
     * This constructor gets coordinates and initiates 2 points.
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }


    /**
     * @return the length of the line
     */
    public double length() {
        return this.start.distance(this.end);
    }


    /**
     * This method calculates the middle coordinates of a line.
     * @return the middle point of the line
     */
    public Point middle() {
        double MiddleX = (end.getX() + start.getX()) / 2;
        double MiddleY = (end.getY() + start.getY()) / 2;

        Point middlePoint = new Point(MiddleX, MiddleY);
        return middlePoint;
    }


    /**
     * @return the start point of the line
     */
    public Point start() {
        return this.start;
    }


    /**
     * @return the end point of the line
     */
    public Point end() {
        return this.end;
    }


    /**
     * Works only if both x coordinates are different
     * @return the incline of the line
     */
    public double incline() {
        double incline = ((this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX()));
        return incline;
    }


    /*
     * @param other - the second line that we compare the first to
     * @return true if the lines intersect, false otherwise
     */
    /*
    public boolean isIntersecting(Line other) {

        // Calculate the slopes of 2 lines
        double lineSlope = this.incline();
        double otherSlope = other.incline();

        // Calculate "b" (intersection with y-axis) in the equations of 2 lines
        double bLine = this.start.getY() - (lineSlope * this.start.getX());
        double bOther = other.start.getY() - (otherSlope * other.start.getX());


        // Find intersecting point (by equation)
        // Works only while lineSlope and otherSlope are different
        double intersectX;
        double intersectY;

        if (
                (this.start == other.start && this.end == other.end) ||
                        (this.start == other.end && this.end == other.start)
        ) return true;

        if ((lineSlope == otherSlope) && (bOther != bLine)) return false;

        intersectX = (bOther - bLine) / (lineSlope - otherSlope);
        intersectY = (lineSlope * intersectX) + bLine;

        // Attention: I still have a hole for exactly same line equation and overlapping segments!
        // exactly same segment is handled OK.

        double minX, maxX, minY, maxY;
        boolean cutX, cutY;
        minX = Math.min(this.start.getX(), this.end.getX());
        maxX = Math.max(this.start.getX(), this.end.getX());
        minY = Math.min(this.start.getY(), this.end.getY());
        maxY = Math.max(this.start.getY(), this.end.getY());

        if (intersectX >= minX && intersectX <= maxX && intersectY >= minY && intersectY <= maxY) cutX = true;
        else cutX = false;

        minX = Math.min(other.start.getX(), other.end.getX());
        maxX = Math.max(other.start.getX(), other.end.getX());
        minY = Math.min(other.start.getY(), other.end.getY());
        maxY = Math.max(other.start.getY(), other.end.getY());

        if (intersectX >= minX && intersectX <= maxX && intersectY >= minY && intersectY <= maxY) cutY = true;
        else cutY = false;

        if (cutX == true && cutY == true) return true;
        else return false;
    }
*/

    public int threePointsDirection(Point p1, Point p2, Point p3) {
        double val = (p2.getY() - p1.getY()) * (p3.getX() - p2.getX()) - (p2.getX() - p1.getX()) * (p3.getY() - p2.getY());

        if (val == 0) return 0; // same equation
        if (val > 0) return 1; // 1 = clockwise
        else return 2; // 2 Counterclock wise
    }

    public boolean isIntersecting(Line other) {
        int d1, d2, d3, d4;
        d1 = threePointsDirection(this.start, this.end, other.start);
        d2 = threePointsDirection(this.start, this.end, other.end);
        d3 = threePointsDirection(other.start, other.end, this.start);
        d4 = threePointsDirection(other.start, other.end, this.end);

        if ((d1 != d2) && (d3 != d4)) return true;
        else return false;
    }

    /**
     * @param other - the second line that we compare the first to
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {

        // Repeating variables //

        // Calculate the slopes of 2 lines
        double lineSlope;
        double otherSlope;
        double intersectX;
        double intersectY;

        double bLine;
        double bOther;

        bOther = 1;
        bLine = 1;
        lineSlope = 1;
        otherSlope = 1;
        intersectX = 1;
        intersectY = 1;// dummy defaults (dangerous but checked)

        if (this.start.getX() != this.end.getX()) {
            lineSlope = this.incline();
            bLine = this.start.getY() - (lineSlope * this.start.getX());
        }
        if (other.start.getX() != other.end.getX()) {
            otherSlope = other.incline();
            bOther = other.start.getY() - (otherSlope * other.start.getX());
        }

        if ((this.start.getX() != this.end.getX()) && (other.start.getX() != other.end.getX())) {
            intersectX = (bOther - bLine) / (lineSlope - otherSlope);
            intersectY = (lineSlope * intersectX) + bLine;
        }
        if (this.start.getX() == this.end.getX()) {
            intersectX = this.start.getX();
            intersectY = (this.start.getY() + this.end.getY()) / 2;
        }
        if (other.start.getX() == other.end.getX()) {
            intersectX = other.start.getX();
            intersectY = (other.start.getY() + other.end.getY()) / 2;
        }

        Point intersectionPoint = new Point(intersectX, intersectY);

        if (
                (this.start == other.start && this.end == other.end) ||
                        (this.start == other.end && this.end == other.start)
        ) return null;

            //Same equation - if there's only one common dot - return dot, if there are few - return null.
        else if (lineSlope == otherSlope && bLine == bOther) // Same equation
        {
            // System.out.println("Same equation");
            if (this.end == other.start) return this.end;
            else if (other.end == this.start && other.end != other.start) return other.end;
            else {
                // System.out.println("Hello");
                return null;
            }
        }

        // Same dot
        else if (this.start == this.end && this.start == other.start && other.start == other.end) return this.start;

            // There is no intersection
        else if (isIntersecting(other) == false) {
            return null;
        }

        if (isIntersecting(other) == true) return intersectionPoint;
        return null;
    }

    /**
     * @param other - the second line that we compare the first to
     * @return true if the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        if (this.start == other.start && this.end == other.end) return true;

        return false;
    }


    /**
     * If this line does not intersect with the rectangle, return null. Otherwise, return the closest intersection point to the start of the line.
     * @param rect
     * @return closestIntersection - to start
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> candidatesIntersectionPoints = rect.intersectionPoints(this); // getting all intersections with rect
        if (candidatesIntersectionPoints.size() == 0) return null;
        if (candidatesIntersectionPoints.size() == 1) return candidatesIntersectionPoints.get(0);

        Point closestIntersection = null;                                              // Based on assumption that I covered all the cases.
        if (candidatesIntersectionPoints.size() == 2) {
            Point firstIntersection = candidatesIntersectionPoints.get(0);
            Point secondIntersection = candidatesIntersectionPoints.get(1);

            if (firstIntersection.distance(this.start) <= secondIntersection.distance(this.start))
                closestIntersection = firstIntersection;
            else                                  // if (firstIntersection.distance(this.start) > secondIntersection.distance(this.start))
                closestIntersection = secondIntersection;
        }
        return closestIntersection;
    }


    /**
     * We check if an intersection is on the segment.
     * @param point
     * @return
     */
    public boolean isOnSegment(Point point) {
        double bigX, smallX, bigY, smallY;

        bigX = Math.max(this.start.getX(), this.end.getX());
        bigY = Math.max(this.start.getY(), this.end.getY());
        smallX = Math.min(this.start.getX(), this.end.getX());
        smallY = Math.min(this.start.getY(), this.end.getY());

        if ((point.getX() >= smallX) && (point.getX() <= bigX) && (point.getY() >= smallY) && (point.getY() <= bigY)) return true;
        else return false;
    }


    /**
     * We check if a line includes a point.
     * @param point
     * @return
     */
    public boolean isIncludePoint(Point point) {
        if (point == null) return false;

        Line methodicLine;
        methodicLine = new Line(this.start, point);
        Point methodicPoint;
        methodicPoint = methodicLine.intersectionWith(this);

        if ((methodicPoint == null) && (isOnSegment(point) == true)) return true;
        else return false;
    }

}





