//ID: 208748590

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;


public class GameLevel implements Animation {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int THICKNESS = 50;


    private GUI gui;
    private biuoop.KeyboardSensor keyboard;

    private SpriteCollection sprites;     // List of sprites
    private GameEnvironment environment;  // List of collidables

    private Counter counter;   // counter of blocks
    private Counter ballsCounter;
    private Counter score;

    private AnimationRunner runner;
    private boolean running;

    private LevelInformation levelInformation;
    private List<Block> bL;

    /**
     * A constructor.
     */
//    public GameLevel() {
    public GameLevel(LevelInformation levelInfo,  KeyboardSensor keyboardSensor , AnimationRunner animationRunner) {
        this.gui = new GUI("GameLevel Part 2", WIDTH, HEIGHT);
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.counter = new Counter(0);
        this.levelInformation = levelInfo;
        this.ballsCounter = new Counter(levelInformation.numberOfBalls());
        this.score = new Counter(0);
        this.running = true;
        this.runner = new AnimationRunner(this.gui);
        this.bL = new ArrayList<Block>();
        for (Block b : levelInformation.blocks()) {
            this.bL.add(new Block(b));
        }
    }
    public GameLevel(LevelInformation levelInfo) {
        this.gui = new GUI("GameLevel Part 2", WIDTH, HEIGHT);
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.counter = new Counter(0);
        this.levelInformation = levelInfo;
        this.ballsCounter = new Counter(levelInformation.numberOfBalls());
        this.score = new Counter(0);
        this.running = true;
        this.runner = new AnimationRunner(this.gui);
        this.bL = new ArrayList<Block>();
        for (Block b : levelInformation.blocks()) {
            this.bL.add(new Block(b));
        }
    }


    /**
     * An adder to the list of Collidables.
     *
     * @param c - the wanted-add.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * An adder to the list of Sprites.
     *
     * @param s- the wanted-add.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * The method roll is to initialize the 2 balls in the game.
     */
    public void initializeBalls() {
        //      Make it general based on numberOfBalls();
        // if   levelInformation.numberOfBalls() == 1 --> The ball is positioned in the middle of the screen
        // if   numberOfBalls() == 2 --> The balls are positioned symmetrically on both sides of the middle of the screen
        // if   numberOfBalls() == 3 --> The balls are positioned: One in the middle and the rest symmetrically on both sides of the middle of the screen
        // if   numberOfBalls() == 10 --> The balls are positioned: Half o one side, half on the other
        // if   numberOfBalls() == even _number --> The balls are positioned: Half on one side, half on the other
        // if   numberOfBalls() == odd _number --> The balls are positioned: one on the middle and the rest: Half on one side, half on the other
        Random rand = new Random();
        int x = 400;           // ew need to initialize the balls on the paddle TBD
        int y = 300;
        int r = 10;

        Ball[] balls = new Ball[this.ballsCounter.getValue()];
        for (int i = 0; i < this.ballsCounter.getValue(); i++) {
            balls[i] = new Ball(x, y, r, Color.CYAN, this.environment);

            int angle = rand.nextInt(360);   // 0;  // 0=up
            int speed = 5;
            Velocity v = Velocity.fromAngleAndSpeed(angle, speed);
            //v = this.levelInformation.initialBallVelocities();
            balls[i].setVelocity(v);

            balls[i].addToGame(this);
        }
        //int x2 = 400;
        //int y2 = 300;
        //Ball ball2 = new Ball(x2, y2, r, Color.RED, this.environment);
        //int angle2 = rand.nextInt(360);
        //Velocity v2 = Velocity.fromAngleAndSpeed(angle2, speed);
        //ball2.setVelocity(v2);
        //ball2.addToGame(this);
//
        // // int x3 = 400;
        // // int y3 = 300;
        //Ball ball3 = new Ball(x2, y2, r, Color.ORANGE, this.environment);
        //int angle3 = rand.nextInt(360);
        //Velocity v3 = Velocity.fromAngleAndSpeed(angle3, speed);
        //ball3.setVelocity(v3);
        //ball3.addToGame(this);
    }

    /**
     * The method roll is to initialize the frame (4 rectangles) in the game.
     */
    public void initializeFrame() {
        Rectangle[] frame = new Rectangle[3];

        frame[0] = new Rectangle(new Point(0, 0), WIDTH, THICKNESS);
        frame[1] = new Rectangle(new Point(0, 0), THICKNESS, HEIGHT);
        frame[2] = new Rectangle(new Point(WIDTH - THICKNESS, 0), THICKNESS, HEIGHT);
        //frame[3] = new Rectangle(new Point(0, HEIGHT - THICKNESS), WIDTH, THICKNESS);

        for (Rectangle rectangle : frame) {
            Block block = new Block(rectangle, Color.GRAY);
            block.addToGame(this);
        }
    }

    /**
     * The method roll is to initialize the DeathBlock in the game.
     */
    public void initializeDeathBlock() {
        // Block deathBlock = new Block(0, HEIGHT - THICKNESS, WIDTH,1, Color.RED);
        Block deathBlock = new Block(0, HEIGHT - THICKNESS + 45, WIDTH, 5, Color.RED); // Debug
        deathBlock.addToGame(this);
        HitListener ballRemover = new BallRemover(this, this.ballsCounter);
        deathBlock.addHitListener(ballRemover);
    }

    /**
     * The method roll is to initialize the paddle in the game.
     */
    public void initializePaddle() {
        double pX, pY;

        if (this.levelInformation.paddleWidth() == 70){
            pX = 370;
        }
        else { // Wide easy level
            pX = 130;
        }

        pY = 550;
        Point upperleft = new Point(pX, pY);
        int paddleWidth = this.levelInformation.paddleWidth(), paddleHeight = 20;
        Paddle paddle = new Paddle(upperleft, paddleWidth, paddleHeight, Color.YELLOW, keyboard, gui, THICKNESS);
        paddle.addToGame(this);
    }

    /**
     * The method role is to initialize the blocks in the game.
     */
    public void initializeBlocksRows() {
        int numOfBlocks = this.levelInformation.numberOfBlocksToRemove();
        this.counter.increase(numOfBlocks);

        // create a PrintingHitListener:
        // afterwards we will add it to all the blocks that are being created
        // PrintingHitListener pHL = new PrintingHitListener();
        // System.out.print("this.counter ="); System.out.println(this.counter);   // Debug
        HitListener blockRemover = new BlockRemover(this, this.counter);
        HitListener scoreTrackingListener = new ScoreTrackingListener(this.score);

        // System.out.print("this.levelInformation.blocks().size()= ");  // Debug
        // System.out.println(this.levelInformation.blocks().size());

        for (Block i: this.bL) {
          i.addToGame(this);
          i.addHitListener(blockRemover);
          i.addHitListener(scoreTrackingListener);
        }
    }


    /**
     * Initialize a new game: add Blocks and Ball (and Paddle) to the game.
     */
    public void initialize() {
        //this.gui = new GUI("GameLevel Part 2", WIDTH, HEIGHT);
        this.keyboard = gui.getKeyboardSensor();

        //System.out.println("GameLevel");
        initializeBalls();
        initializeFrame();
        initializeDeathBlock();
        initializePaddle();
        initializeBlocksRows();
        ScoreIndicator scoreIndicator = new ScoreIndicator(score);
        scoreIndicator.addToGame(this);
    }

    public boolean shouldStop() {
        return !this.running;
    }

    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLUE);
        d.fillRectangle(0, 0, WIDTH, HEIGHT);
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

        if (this.keyboard.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboard));
        }

        if (this.counter.getValue() == 0 || this.ballsCounter.getValue() == 0) {
            this.running = false;
        }
    }

        /**
         * Run the game -- start the animation loop.
         */
        public void run() {
 //           this.createBallsOnTopOfPaddle(); // or a similar method
            this.running = true;
            // use our runner to run the current animation -- which is one turn of
            // the game.
            this.runner.run(this);
        }
 //       public void run () {
 //           biuoop.Sleeper sleeper = new biuoop.Sleeper();
 //           int framesPerSecond = 60;
 //           int millisecondsPerFrame = 1000 / framesPerSecond;
//
 //           while (true) {
 //               long startTime = System.currentTimeMillis(); // timing
//
 //               DrawSurface d = gui.getDrawSurface();
 //               //---
 //               d.setColor(Color.BLUE);
 //               d.fillRectangle(0, 0, WIDTH, HEIGHT);
 //               //---
 //               this.sprites.drawAllOn(d);
 //               gui.show(d);
 //               this.sprites.notifyAllTimePassed();
//
 //               // timing
 //               long usedTime = System.currentTimeMillis() - startTime;
 //               long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
 //               if (milliSecondLeftToSleep > 0) {
 //                   sleeper.sleepFor(milliSecondLeftToSleep);
//
 //                   if (this.counter.getValue() == 0) {
 //                       this.score.increase(100);
 //                   }
//
 //                   //we terminate the game while all the blocks are terminated:
 //                   if (this.counter.getValue() == 0 || this.ballsCounter.getValue() == 0) {
 //                       gui.close();
//
 //                       this.running = true;
 //                       // use our runner to run the current animation -- which is one turn of the game.
 //                       this.runner.run(this);
 //                   }
 //               }
 //           }
 //       }

        /**
         * we remove a Collidable object from a list.
         *
         * @param c - a Collidable.
         */
        public void removeCollidable (Collidable c){
            this.environment.removeCollidable(c);
        }

        /**
         * we remove a Sprite object from a list.
         *
         * @param s - a Sprite.
         */
        public void removeSprite (Sprite s){
            this.sprites.removeSprite(s);
        }

    }