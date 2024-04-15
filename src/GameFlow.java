//ID: 208748590

import biuoop.KeyboardSensor;
import java.util.List;


public class GameFlow {

    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;

    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
    }

    public void runLevels(List<LevelInformation> levels) {
        // ...
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner);

            level.initialize();

            //level has more blocks and balls
            while (!level.shouldStop()) {
                level.run();
            }

            // no more balls   // TBD Later
            //if (level.) {
            //    break;
            //}

        }
    }
}
