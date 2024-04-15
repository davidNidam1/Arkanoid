//ID: 208748590

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class Block implements Collidable, Sprite, HitNotifier {

    //Class members
    private Rectangle rectangle;
    private Color color;

    private List<HitListener> hitListeners;

    /**
     * construct Block by "upperleft" point, it's width and height.
     *
     * @param upperleft - one relation point.
     * @param width     dimension (Y axis).
     * @param height    dimension (X axis).
     */
    public Block(Point upperleft, double width, double height) {
        this.rectangle = new Rectangle(upperleft, width, height);
        this.hitListeners = new ArrayList<HitListener>();
    }

    public Block(Block b){
        this.rectangle = b.rectangle;
        this.color = b.color;
        this.hitListeners = new ArrayList<HitListener>();
    }
    /**
     * construct Block by a rectangle object, and a color .
     *
     * @param rectangle - the block skeleton.
     * @param color     of a block.
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    public Block(double x, double y, double width, double height, Color color) {
        this.rectangle = new Rectangle(new Point(x, y), width, height);
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * A getter of the rectangle.
     *
     * @return this.rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * This method gets a collision-Point, a current-Velocity. and returns a new suitable velocity.
     * In addition, notifies the listeners about the hit.
     *
     * @param collisionPoint  - the point where the ball hits the block
     * @param currentVelocity - dx, dy.
     * @return updated currentVelocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        int axisX = 0, axisY = 0;

        System.out.println("Block.hit");
        //notify the listeners about the hit:
        this.notifyHit(hitter);

        if ((this.rectangle.getDownLine().isIncludePoint(collisionPoint)) || (this.rectangle.getUpperLine().isIncludePoint(collisionPoint)))
            axisY = 1;

        if ((this.rectangle.getRightLine().isIncludePoint(collisionPoint)) || (this.rectangle.getLeftLine().isIncludePoint(collisionPoint)))
            axisX = 1;
        //until here - definitions

        if (axisX == 1 && axisY == 1)
            return new Velocity((-1) * currentVelocity.getDx(), (-1) * currentVelocity.getDy());
        else {
            if (axisX == 1) return new Velocity((-1) * currentVelocity.getDx(), currentVelocity.getDy());
            if (axisY == 1) return new Velocity(currentVelocity.getDx(), (-1) * currentVelocity.getDy());
        }

        return currentVelocity;
    }

    /**
     * We get a surface dimension, and draw a block on it.
     *
     * @param d - plane.
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


    /**
     * When we add a Block we need to call both addSprite and addCollidable.
     *
     * @param gameLevel - an object including the gameLevel interface.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
        gameLevel.addCollidable(this);
    }

    /**
     * currently - no use.
     */
    public void timePassed() {
    }

    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }

    /**
     * Add hl as a listener to hit events.
     *
     * @param hl - a hitListener type.
     */
    public void addHitListener(HitListener hl) {
        // we add hl to the list of the listeners:
        this.hitListeners.add(hl);
    }

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl - a hitListener type.
     */

    public void removeHitListener(HitListener hl) {
        // we remove hl from the list of the listeners:
        this.hitListeners.remove(hl);
    }

    /**
     * notify all registered Hit-listeners about a hit.
     *
     * @param hitter - a Ball type.
     */
    private void notifyHit(Ball hitter) {
        //System.out.println("Block.notifyHit");
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);

        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

} // end of class block
