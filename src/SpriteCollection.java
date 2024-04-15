//ID: 208748590

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

public class SpriteCollection {

    private List<Sprite> allSprites;

    /**
     * A constructor to a list of Sprites.
     */
    public SpriteCollection() {
        allSprites = new ArrayList<Sprite>();
    }

    /**
     * An adder to the list of Sprites.
     * @param s - a sprite.
     */
    public void addSprite(Sprite s) {
        allSprites.add(s);
    }

    public void removeSprite (Sprite s){ allSprites.remove(s); }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < allSprites.size(); i++) {
            allSprites.get(i).timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     * @param d - a DrawSurface interface.
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < allSprites.size(); i++) {
            allSprites.get(i).drawOn(d);
        }
    }
}