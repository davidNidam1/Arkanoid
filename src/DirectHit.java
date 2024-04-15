//ID: 208748590

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class DirectHit implements LevelInformation{

   // public DirectHit(){ }

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
      List velocities = new ArrayList<Velocity>();
     // velocities.add(10);
        velocities.add(new Velocity(0,5));
      return  velocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 70;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
       Sprite bg = new Sprite() {
           public void drawOn(DrawSurface d)
                { d.setColor(Color.BLACK);
                  //  d.drawCircle...  This is the place to draw an artistic background...
                }
           public void timePassed() { }
       };
        return bg;
    }


    //  Block(double x, double y, double width, double height, Color color)
    @Override
    public List<Block> blocks() {
      Block b = new Block(400, 150, 15, 15, Color.RED);
        List<Block> blocksList = new ArrayList<Block>();
        blocksList.add(b);

        return blocksList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
