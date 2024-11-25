//ID: 208748590

import biuoop.DrawSurface;

public interface Sprite {
    /**
     * draw the sprite to the screen.
     * @param d
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time quantity finished.
     */
    void timePassed();
}
