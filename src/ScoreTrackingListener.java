//ID: 208748590

public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * a constructor.
     * @param scoreCounter - a Counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * the method removes this class from the HitListeners list.
     * @param beingHit - a block.
     * @param hitter   - a Ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        this.currentScore.increase(5);
    }

    /**
     * we can increase currentScore by 100.
     */
    public void increaseByHundred() {
        this.currentScore.increase(100);
    }
}