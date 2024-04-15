//ID: 208748590

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Green3 implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 2;
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
        return 70;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        Sprite bg = new Sprite() {
            public void drawOn(DrawSurface d)
            { d.setColor(Color.green);
                //  d.drawCircle...  This is the place to draw an artistic background...
            }
            public void timePassed() { }
        };
        return bg;
    }

    @Override
    public List<Block> blocks() {

        int rowBlockWidth = 50;
        int rowBlockHeight = 20;

        Block[] firstRow  = new Block[10];   //Upper Row
        Block[] secondRow = new Block[9];
        Block[] thirdRow  = new Block[8];
        Block[] fourthRow = new Block[7];
        Block[] fifthRow  = new Block[6];    //Lower Row

        List<Block> blocksList = new ArrayList<Block>();

        for (int i = 1; i <= firstRow.length; ++i) {
            firstRow[i-1] = new Block(750 - (i * rowBlockWidth), 140, rowBlockWidth, rowBlockHeight, Color.PINK);
            blocksList.add(firstRow[i-1]); // fill the blocks list
        }

        for (int i = 1; i <= secondRow.length; i++){
            secondRow[i-1] = new Block(750 - (i * rowBlockWidth), 160, rowBlockWidth, rowBlockHeight, Color.CYAN);
            blocksList.add(secondRow[i-1]); // fill the blocks list
        }

        for (int i = 1; i <= thirdRow.length; i++){
            thirdRow[i-1] = new Block(750 - (i * rowBlockWidth), 180, rowBlockWidth, rowBlockHeight, Color.BLUE);
            blocksList.add(thirdRow[i-1]); // fill the blocks list
        }

        for (int i = 1; i <= fourthRow.length; i++){
            fourthRow[i-1] = new Block(750 - (i * rowBlockWidth), 200, rowBlockWidth, rowBlockHeight, Color.GRAY);
            blocksList.add(fourthRow[i-1]); // fill the blocks list
        }

        for (int i = 1; i <= fifthRow.length; i++){
            fifthRow[i-1] = new Block(750 - (i * rowBlockWidth), 220, rowBlockWidth, rowBlockHeight, Color.GREEN);
            blocksList.add(fifthRow[i-1]); // fill the blocks list
        }

            return blocksList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }
}
