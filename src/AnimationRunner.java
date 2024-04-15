//ID: 208748590
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

public class AnimationRunner {

    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    public AnimationRunner (GUI gui){
        this.framesPerSecond = 60;
        this.sleeper = new Sleeper();
        this.gui = gui;
    }


    public void run(Animation animation) {

        int millisecondsPerFrame = (int) (1000 / framesPerSecond);

        while (!animation.shouldStop()) {

            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}