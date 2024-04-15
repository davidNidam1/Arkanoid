//ID: 208748590

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class FinalFour implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 3;
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
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        Sprite bg = new Sprite() {
            public void drawOn(DrawSurface d)
            { d.setColor(Color.BLUE);
                //  d.drawCircle...  This is the place to draw an artistic background...
            }
            public void timePassed() { }
        };
        return bg;
    }

    @Override
    public List<Block> blocks() {

        Block[] blocksRow1 = new Block[15];
        Block[] blocksRow2 = new Block[15];
        Block[] blocksRow3  = new Block[15];
        Block[] blocksRow4 = new Block[15];
        Block[] blocksRow5 = new Block[15];
        Block[] blocksRow6 = new Block[15];
        Block[] blocksRow7 = new Block[15];

        List<Block> blocksList = new ArrayList<Block>();

        for (int i = 1; i <= blocksRow1.length; i++){
            blocksRow1[i-1] = new Block(55 +((i-1) * 46), 100, 46, 23, Color.GRAY);
            blocksList.add(blocksRow1[i-1]); // fill the blocks list

            blocksRow2[i-1] = new Block(55 +((i-1) * 46), 124, 46, 23, Color.RED);
            blocksList.add(blocksRow2[i-1]); // fill the blocks list

            blocksRow3[i-1] = new Block(55 +((i-1) * 46), 148, 46, 23, Color.yellow);
            blocksList.add(blocksRow3[i-1]); // fill the blocks list

            blocksRow4[i-1] = new Block(55 +((i-1) * 46), 172, 46, 23, Color.green);
            blocksList.add(blocksRow4[i-1]); // fill the blocks list

            blocksRow1[i-1] = new Block(55 +((i-1) * 46), 196, 46, 23, Color.WHITE);
            blocksList.add(blocksRow1[i-1]); // fill the blocks list

            blocksRow1[i-1] = new Block(55 +((i-1) * 46), 220, 46, 23, Color.pink);
            blocksList.add(blocksRow1[i-1]); // fill the blocks list

            blocksRow1[i-1] = new Block(55 +((i-1) * 46), 244, 46, 23, Color.cyan);
            blocksList.add(blocksRow1[i-1]); // fill the blocks list
        }

        return blocksList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }
}
