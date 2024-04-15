//ID: 208748590

import java.lang.Math;

public class Velocity {

    //create variables
    private double dx, dy;

    /**
     * constructor
     * @param dx - change in x coordination.
     * @param dy - change in y coordination.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * This methode converts angle and speed to velocity (dx, dy)
     * @param angle
     * @param speed - number of steps
     * @return
     */
    // alpha = the angle between dx and the speed
    // dx is angle 90  because "assuming up is angle 0".
    // angle = 90 + alpha    --> alpha = angle -90
    // cos(alpha)=dx/speed   -->  dx = speed . cos(alpha) = speed * cos(angle-90) = speed * sin(angle)
    // sin(alpha)=dy/speed   -->  dy = speed * sin(alpha) = speed * sin(angle-90) = speed * (-cos(angle))
   public static Velocity fromAngleAndSpeed(double angle, double speed) {
       double angleRadiant = Math.toRadians(angle);
       double dx = speed * Math.sin(angleRadiant);
       double dy = speed * (-1) * Math.cos(angleRadiant);
       return new Velocity(dx, dy);
   }

    public Velocity(Velocity v) {
        this.dx = v.getDx();
        this.dy = v.getDy();
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * This methode gets a point and returns a new point (to move to).
     * @param p
     * @return newP
     */
    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    public Point applyToPoint(Point p) {
        double newX = p.getX() + this.dx;
        double newY = p.getY() + this.dy;

        Point newP = new Point(newX, newY);
        return newP;
    }

}
