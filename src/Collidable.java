//ID: 208748590
// This class is an interface for all the objects we want them to be collidable.

public interface Collidable {
    /**
     * @return the "collision shape" of the object
     */

    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * @param collisionPoint
     * @param currentVelocity
     * @return the new velocity expected after the hit (based on the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
