//ID: 208748590

//This class defines a point.
public class Point {

private double x;
private double y;

    // constructor
    /**
     * @param x - value of the x coordinate.
     * @param y - value of the y coordinate.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This method returns the distance of this point to the other point.
     * @param other - The method gets the other point.
     * @return Distance - The calculated distance between the two points.
     */
    public double distance(Point other) {
      double horizontalDisX = this.x - other.getX();
      double verticalDisY = this.y - other.getY();

      double Distance = Math.sqrt((horizontalDisX * horizontalDisX) + (verticalDisY * verticalDisY));
      return Distance;
    }

    /**
     * This method returns true if the points are equal, false otherwise.
     * @param other - The method gets the other point.
     * @return True or False according to the values of the dots.
     */
    public boolean equals(Point other) {
        if (other == null) return false;
      if ( (this.x == other.getX() ) && (this.y == other.getY() ))  return true;
    else return false;
    }

    /**
     * A getter.
     * @return this.x - The original value of x.
     */
   public double getX() {
        return this.x;
    }

    /**
     * A setter.
     * @return this.y - The original value of y.
     */
    public double getY() {
        return this.y;
    }
}
