//ID: 208748590

import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.Color;


public class Paddle implements Collidable, Sprite {

    private Point upperleft;
    private Rectangle rectangle;
    private Color color;
    private biuoop.KeyboardSensor keyboard;
    private Velocity velocity;
    private GUI gui;
    private int thickness;

    //constructors

    /**
     * A constructor.
     * @param upperleft Point.
     * @param width     dimension.
     * @param height    dimension.
     */
    public Paddle(Point upperleft, double width, double height) {
        this.rectangle = new Rectangle(upperleft, width, height);
    }

    /**
     * A constructor.
     * @param upperleft Point.
     * @param width     dimension.
     * @param height    dimension.
     * @param color     - pigment.
     */
    public Paddle(Point upperleft, double width, double height, Color color) {
        this.rectangle = new Rectangle(upperleft, width, height);
        this.color = color;
    }

    /**
     * A constructor.
     * @param upperleft Point.
     * @param width     dimension.
     * @param height    dimension.
     * @param color     - pigment.
     * @param keyboard  - a sensor.
     */
    public Paddle(Point upperleft, double width, double height, Color color, biuoop.KeyboardSensor keyboard) {
        this.rectangle = new Rectangle(upperleft, width, height);
        this.color = color;
        this.keyboard = keyboard;
        this.velocity = new Velocity(5, 0); // initialize Velocity meaning no movement by default
        this.upperleft = upperleft;
    }

    /**
     * A constructor.
     * @param upperleft Point.
     * @param width     dimension.
     * @param height    dimension.
     * @param color     - pigment.
     * @param keyboard  - a sensor.
     * @param gui
     * @param thickness of the paddle.
     */
    public Paddle(Point upperleft, double width, double height, Color color, biuoop.KeyboardSensor keyboard, GUI gui, int thickness) {
        this.rectangle = new Rectangle(upperleft, width, height);
        this.color = color;
        this.keyboard = keyboard;
        this.velocity = new Velocity(5, 0); // initialize Velocity meaning no movement by default
        this.upperleft = upperleft;
        this.gui = gui;
        this.thickness = thickness;
    }

    /**
     * A constructor.
     * @param rectangle - an object.
     * @param color     - pigment
     */
    public Paddle(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
    }
    // end of constructors

    /**
     * A getter.
     * @return the velocity of the paddle.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * This method allows the paddle to move left.
     */
    public void moveLeft() {
//        System.out.println("LEFT ARROW DETECTED ---------------------");
        if (this.rectangle.getUpperLeft().getX() > this.thickness + 3)
            this.rectangle = new Rectangle(new Point(rectangle.getUpperLeft().getX() - 3, rectangle.getUpperLeft().getY()), rectangle.getWidth(), rectangle.getHeight());
    }

    /**
     * The method allows the paddle to move right.
     */
    public void moveRight() {
//        System.out.println("RIGHT ARROW DETECTED ---------------------");
        if (this.rectangle.getUpperRight().getX() < (this.gui.getDrawSurface().getWidth() - this.thickness - 3))
            this.rectangle = new Rectangle(new Point(rectangle.getUpperLeft().getX() + 3, rectangle.getUpperLeft().getY()), rectangle.getWidth(), rectangle.getHeight());
    }

    /**
     * The method declares that a Quantity of time just finished.
     */
    public void timePassed() {
        if (keyboard.isPressed(keyboard.LEFT_KEY)) moveLeft();
        else if (keyboard.isPressed(keyboard.RIGHT_KEY)) moveRight();
    }

    /**
     * We draw a paddle on a surface.
     * @param d - DrawSurface object.
     */
    public void drawOn(DrawSurface d) {
        int x, y, width, height;

        x = (int) (this.rectangle.getUpperLeft().getX());
        y = (int) (this.rectangle.getUpperLeft().getY());
        width = (int) (this.rectangle.getWidth());
        height = (int) (this.rectangle.getHeight());

        d.setColor(this.color);
        d.fillRectangle(x, y, width, height);
        d.setColor(Color.BLACK);
        d.drawRectangle(x, y, width, height);
    }


    // Collidable
    /**
     * A getter.
     * @return the rectangle of the paddle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }


    /**
     * The method invoked only when the paddle is hit on its horizontal side.
     * @param collisionPoint indicator.
     * @return the paddle section - 1 or 2 or 3 or 4 or 5  according to the collision location.
     */
    public int paddleSection(Point collisionPoint) {
        int locationOnPaddle;
        int index;
        locationOnPaddle = (int) collisionPoint.getX() - (int) this.rectangle.getUpperLeft().getX();

        index = (locationOnPaddle / ((int) (this.rectangle.getWidth() / 5))) + 1;

        /*
        System.out.print("Index = "); System.out.println(index);
        */

        if (index < 1) index = 1;  // Paranoidic protection (never out of the bounds)...
        else if (index > 5) index = 5;

        return index;
    }

    /**
     * The method intermediate (converts to) between the collisionPoint & currentVelocity and the new velocity.
     * @param collisionPoint  - Point.
     * @param currentVelocity - Velocity.
     * @return updated currentVelocity.
     */
    public Velocity hit(Ball ball, Point collisionPoint, Velocity currentVelocity) {
        int hitVertical = 0, hitHorizontal = 0;
        int index; // index of the paddle section where the hit occurred. 1 to 5
        double dx, dy, speed;

        // Clarify which line is hit
        if ((this.rectangle.getDownLine().isIncludePoint(collisionPoint)) || (this.rectangle.getUpperLine().isIncludePoint(collisionPoint)))
            hitHorizontal = 1;
        if ((this.rectangle.getRightLine().isIncludePoint(collisionPoint)) || (this.rectangle.getLeftLine().isIncludePoint(collisionPoint)))
            hitVertical = 1;

        // Decide what is the next Velocity
        if (hitVertical == 1 && hitHorizontal == 1)
            return new Velocity((-1) * currentVelocity.getDx(), (-1) * currentVelocity.getDy());
        else if (hitVertical == 1) return new Velocity((-1) * currentVelocity.getDx(), currentVelocity.getDy());
        else if (hitHorizontal == 1) {
            index = paddleSection(collisionPoint);

            dx = currentVelocity.getDx();
            dy = currentVelocity.getDy();
            speed = Math.sqrt((dx * dx) + (dy * dy));

            if (index == 1) {
                return velocity.fromAngleAndSpeed(300, speed);
            } else if (index == 2) {
                return velocity.fromAngleAndSpeed(330, speed);
            } else if (index == 3) {
                return new Velocity(currentVelocity.getDx(), (-1) * currentVelocity.getDy());
            } else if (index == 4) {
                return velocity.fromAngleAndSpeed(60, speed);
            } else if (index == 5) {
                return velocity.fromAngleAndSpeed(30, speed);
            }

            return velocity.fromAngleAndSpeed(300, speed);   // Default, just in case...
        }

        return currentVelocity;
    }

    /**
     * Add this paddle to the game. when we add a paddle we need to call both addSprite and add Collidable.
     * @param g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}// End of Paddle class
