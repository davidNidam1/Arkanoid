//ID: 208748590

/**
 * a BallRemover is in charge of removing balls from the gameLevel, as well as keeping count
 * of the number of balls that remain.
 */
public class BallRemover implements HitListener {

        private GameLevel gameLevel;
        private Counter remainingBalls;

    /**
     * a constructor.
     * @param gameLevel - GameLevel type.
     * @param remainingBalls - Counter type.
     */
        public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
            this.gameLevel = gameLevel;
            this.remainingBalls = remainingBalls;
        }

    /**
     * This method is called whenever the beingHit object is hit.
     * @param beingHit - Block type.
     * @param hitter - The hitter parameter is the Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter){
        System.out.println("Death hit!");
        hitter.removeHitListener(this);
        hitter.removeFromGame(this.gameLevel);
        this.remainingBalls.decrease(1);
        }

    }

