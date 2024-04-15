//ID: 208748590
public class Ass6Game {
    /**
     * The main method which starts the program.
     * @param args
     */
    public static void main(String[] args) {
        DirectHit dH = new DirectHit();
        WideEasy wE = new WideEasy();
        Green3 g3 = new Green3();
        FinalFour fF = new FinalFour();

        //GameLevel gameLevel = new GameLevel(dH);
         //GameLevel gameLevel = new GameLevel(wE);
         GameLevel gameLevel = new GameLevel(g3);   // KeyboardSensor keyboardSensor , AnimationRunner animationRunner
       // GameLevel gameLevel = new GameLevel(fF);

        gameLevel.initialize();
        gameLevel.run();
    }
}

