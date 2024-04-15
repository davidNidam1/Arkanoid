//ID: 208748590

import biuoop.DrawSurface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WideEasy implements LevelInformation{

    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List velocities = new ArrayList<Velocity>();
        velocities.add(10);
        return  velocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 580;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        Sprite bg = new Sprite() {
            public void drawOn(DrawSurface d)
            { d.setColor(Color.WHITE);
                //  d.drawCircle...  This is the place to draw an artistic background...
            }
            public void timePassed() { }
        };
        return bg;
    }

    @Override
    public List<Block> blocks() {

  //      Block[] blocksRow = new Block[15];
//
  //      for (int i = 1; i <= blocksRow.length; i++){
  //          blocksRow[i-1] = new Block(55 * i, 270, 46, 23, Color.BLUE);
  //          blocks().add(blocksRow[i-1]); // fill the blocks list
  //      }
//
  //      return blocks();

             List <Block> bL = new ArrayList<Block>();

              for (int i = 1; i <= 15; i++){
                  Block b = new Block(55 +((i-1) * 46), 270, 46, 23, Color.GREEN);
                  bL.add(b); // fill the blocks list
              }
        return bL;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
