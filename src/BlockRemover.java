//ID: 208748590

// a BlockRemover is in charge of removing blocks from the gameLevel, as well as keeping count
// of the number of blocks that remain.
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * a constructor
     *
     * @param gameLevel            - GameLevel type
     * @param remainingBlocks - Counter type.
     */
    public BlockRemover(GameLevel gameLevel, Counter remainingBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * // Blocks that are hit should be removed from the gameLevel.
     * // we remove this listener from the block that is being removed from the gameLevel.
     *
     * @param beingHit - a Block.
     * @param hitter   - a Ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("hitEvent: Remove Block from Game");   //debug
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.gameLevel);
        this.remainingBlocks.decrease(1);
    }
}