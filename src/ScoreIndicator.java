//ID: 208748590
import biuoop.DrawSurface;

import java.awt.Color;

public class ScoreIndicator implements Sprite {

    private Rectangle rectangle;
    private Counter score;
    private Block block;

    /**
     * a constructor.
     * @param score
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    /**
     * we create a score indicator block.
     * @param d - a DrawSurface.
     */
    public void drawOn(DrawSurface d) {
        this.block = new Block(new Rectangle(new Point(0, 0), 800, 25), Color.BLUE);
        block.drawOn(d);
        d.setColor(Color.CYAN);
        d.drawText(355, 22, "Score: " + this.score, 14);
    }

    /**
     * notify the sprite that time quantity finished.
     */
    public void timePassed() {
    }

    /**
     * we want to add this class to sprites.
     * @param gameLevel - GameLevel type.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
}
