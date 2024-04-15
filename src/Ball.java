//ID: 208748590

import biuoop.DrawSurface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ball implements Sprite {

    // Creating variables
    private int radius;
    private Point center;
    private int frameWidth;
    private int frameHeigh;
    private int originX;
    private int originY;
    private GameEnvironment gameEnvironment;
    private Velocity velocity;
    private Color color;

    private Block block;
    private List<HitListener> hitListeners;

    // constructors

    /**
     * construct ball by a Point.
     * @param center - the center of a circle .
     * @param r      - radius.
     * @param color  - a pigment.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.velocity = new Velocity(0, 0); // initialize Velocity meaning no movement by default
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * construct ball by x, y coordinates
     * @param x
     * @param y
     * @param r     - radius.
     * @param color - a pigment.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.radius = r;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }


    /**
     * construct a ball by x, y coordinates.
     * @param x
     * @param y
     * @param r          - radius.
     * @param frameWidth - limit of frame width.
     * @param frameHeigh - limit of frame high.
     * @param color      - a pigment.
     */
    public Ball(double x, double y, int r, int frameWidth, int frameHeigh, java.awt.Color color) {
        double newX = x;
        double newY = y;

        // Handle the case where the ball initial location is not in frame (even far from).
        // In this case we arbitrarily locate the ball at the center of the frame
//        if ((x - r) < 0) newX = frameWidth / 2;
//        if ((x + r) > frameHeigh) newX = frameWidth / 2;
//        if ((y - r) < 0) newY = frameHeigh / 2;
//        if ((y + r) > frameWidth) newY = frameHeigh / 2;

        this.center = new Point(newX, newY);
        this.radius = r;
        this.color = color;
        this.frameWidth = frameWidth;
        this.frameHeigh = frameHeigh;
        originX = 0;
        originY = 0;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * construct ball by x, y coordinates and origin location
     * @param x
     * @param y
     * @param r          - radius.
     * @param frameWidth - limit of frame width.
     * @param frameHeigh - limit of frame high.
     * @param color      - a pigment.
     * @param originX    - initial location of x
     * @param originY    - initial location of y
     */
    public Ball(double x, double y, int r, int frameWidth, int frameHeigh, java.awt.Color color, int originX, int originY) {
        double newX = x;
        double newY = y;

        // Handle the case where the ball initial location is not in frame (even far from).
        // In this case we arbitrarily locate the ball at the center of the frame
//        if ((x - r) < 0) newX = originX + frameWidth / 2;
//        if ((x + r) > frameHeigh) newX = originX + frameWidth / 2;
//        if ((y - r) < 0) newY = originY + frameHeigh / 2;
//        if ((y + r) > frameWidth) newY = originY + frameHeigh / 2;

        this.center = new Point(newX, newY);
        this.radius = r;
        this.color = color;
        this.frameWidth = frameWidth;
        this.frameHeigh = frameHeigh;
        this.originX = originX;
        this.originY = originY;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * construct ball by gameEnvironment.
     * @param xCenter
     * @param yCenter
     * @param radius
     * @param paint
     * @param gameEnvironment
     */
    public Ball(int xCenter, int yCenter, int radius, Color paint, GameEnvironment gameEnvironment) {
        this.center = new Point((double) xCenter, (double) yCenter);
        this.radius = radius;
        this.color = paint;
        this.velocity = new Velocity(0, 0);
        this.gameEnvironment = gameEnvironment;
        this.hitListeners = new ArrayList<HitListener>();
    }

    // accessors

    /**
     * get the center of a ball object.
     * @return this.center.
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * set the center of a ball object.
     * @param x - center
     * @param y - center
     */
    public void setCenter(double x, double y) {
        this.center = new Point(x, y);
    }

    /**
     * set the center-x of a ball object.
     * @return this.center.getX().
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * set the center-y of a ball object.
     * @return this.center.getY().
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * The radius of a ball determines it's size.
     * @return
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * A getter.
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * A setter.
     * @param v - the velocity we set.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * A setter.
     * @param dx, dy - the velocity we set.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * A getter.
     * @return the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * A getter.
     * @return the game Environment of the ball.
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }



    /**
     * draw the ball on the given DrawSurface.
     * @param d
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
    }


    /**
     * The method creates a trajectory.
     * @return newTrajectory.
     */
    public Line trajectory() {
        Point start, end;
        start = new Point((int) this.center.getX(), (int) this.center.getY());
        end = new Point((int) (this.center.getX() + getVelocity().getDx()), (int) (this.center.getY() + getVelocity().getDy()));

        Line newTrajectory = new Line(start, end);
        return newTrajectory;
    }


    /**
     * The method moves the ball.
     */
    public void moveOneStep() {
        // Check if there are collidable objects (may involve a change in velocity of the ball)
        boolean areCollidables = false;

        if (this.gameEnvironment.getClosestCollision(this.trajectory()) == null) areCollidables = false;
        else areCollidables = true;

        if (areCollidables)
        {
            Velocity newV = new Velocity (this.gameEnvironment.getClosestCollision(this.trajectory()).collisionObject().hit(this, this.gameEnvironment.getClosestCollision(this.trajectory()).collisionPoint(), this.getVelocity()));
            this.setVelocity(newV);
        }

        // New Center after applying the Velocity.
        this.center = this.getVelocity().applyToPoint(this.center);

        //check if the ball is stuck. If yes, Release it.
        this.gameEnvironment.releaseTheBall(this);
    }

    /**
     * The method declares the ball that a time quantity just finished.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * An adder. When we add a Ball we need to call only addSprite().
     * @param gameLevel object.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    // Add hl as a listener to hit events.
    public void addHitListener(HitListener hl){
        // we add hl to the list of the listeners:
        this.hitListeners.add(hl);
    }

    public void removeHitListener(HitListener hl){
        this.hitListeners.remove(hl);
        //this.block.removeHitListener(hl); //debug
        System.out.println("Ball removed");
    }
    public void removeFromGame(GameLevel gameLevel){
    gameLevel.removeSprite(this);
    }


} //end of Ball class

