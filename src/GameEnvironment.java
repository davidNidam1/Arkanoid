//ID: 208748590

import java.util.ArrayList;
import java.util.List;

public class GameEnvironment {

    private List<Collidable> listOfCollidables;

    /**
     * construct "listOfCollidables".
     */
    public GameEnvironment() {
        this.listOfCollidables = new ArrayList<Collidable>();
    }

    /**
     * add the given collidable to the environment.
     * @param c - a Collidable object.
     */
    public void addCollidable(Collidable c) {
        this.listOfCollidables.add(c);
    }

    public void removeCollidable(Collidable c) { this.listOfCollidables.remove(c);}

    /**
     * confirm the ball is not stuck. if it is - release it.
     * @param ball - we check.
     */
    public void releaseTheBall(Ball ball) {
//        DEBUG: System.out.println("TRY_TO_RELEASE -------------------------");

        for (int i = 0; i < this.listOfCollidables.size(); i++) {
            if (this.listOfCollidables.get(i).getCollisionRectangle().isPointInRectangle(ball.getCenter())) {
                  ball.setCenter(400 , 500);
            }
        }
    }

    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables in this collection, return null.
     * Else, return the information about the closest collision that is going to occur.
     * @param trajectory - a segment which th ball moves on.
     * @return collisionInfo.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        if (this.listOfCollidables.isEmpty()) {
            return null;
        }
//        System.out.println (this.listOfCollidables.size()); -Debug check

        for (int i = 0; i < this.listOfCollidables.size(); i++) {
            if (this.listOfCollidables.get(i).getCollisionRectangle().intersectionPoints(trajectory).size() == 0) {
                //               System.out.println("no collision!");
                continue;
            } else if (this.listOfCollidables.get(i).getCollisionRectangle().intersectionPoints(trajectory).size() == 1) {
                CollisionInfo collisionInfo = new CollisionInfo(this.listOfCollidables.get(i).getCollisionRectangle().intersectionPoints(trajectory).get(0),
                        this.listOfCollidables.get(i));

                //               System.out.println("in getClosestCollision!");

                return collisionInfo;
            }
            // 2 collision points - case. check again.
            else if (this.listOfCollidables.get(i).getCollisionRectangle().intersectionPoints(trajectory).size() == 2) {
                CollisionInfo collisionInfo = new CollisionInfo(trajectory.closestIntersectionToStartOfLine(this.listOfCollidables.get(i).getCollisionRectangle()), // closestIntersectionToStartOfLine - gets a rectangle
                        this.listOfCollidables.get(i));

                return collisionInfo;
            }
        }

        return null;
    }  // end of getClosestCollision

}
