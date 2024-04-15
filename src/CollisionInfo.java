//ID: 208748590
public class CollisionInfo {

    //creating variables:
    private Point collisionPoint;
    private Collidable collisionObject;

    //Constructor

    /**
     * A Constructor
     * @param collisionPoint
     * @param collisionObject
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * A getter: the point at which the collision occurs.
     * @return collisionPoint.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * A getter: the collidable object involved in the collision.
     * @return collisionObject.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }

}
