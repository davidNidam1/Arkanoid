import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.util.Random;
import java.awt.Color;


    public class testOfCollision {
        public static final int WIDTH = 900;
        public static final int HEIGHT = 700;

        public static void main(String[] args) {
            // create gui
            GUI gui = new GUI("testOfCollision", WIDTH, HEIGHT);
            Sleeper sleeper = new Sleeper();
            Random rand = new Random();

            //create ball
            int r = 10;
            int x = 450;
            int y = 350;

            GameEnvironment e = new GameEnvironment();
            Ball ball = new Ball(x, y, r, Color.BLACK, e);
                int angle = rand.nextInt(360);
            //int angle = 90;
            int speed = 10;
            Velocity v = Velocity.fromAngleAndSpeed(angle, speed);
            ball.setVelocity(v);

            //create block
            Color color = new Color (10,50,100);
            int width = WIDTH-10;
            int height = 50;
            Point p = new Point (5,5);
            Rectangle rect = new Rectangle(p, width, height);
            Block b1 = new Block (rect, color);

            Color color2 = new Color (10,50,100);
            int width2 = 50;
            int height2 = HEIGHT-10;
            Point p2 = new Point (5,5);
            Rectangle rect2 = new Rectangle(p2, width2, height2);
            Block b2 = new Block (rect2, color2);

            Color color3 = new Color (10,50,100);
            int width3 = 50;
            int height3 = HEIGHT-10;
            Point p3 = new Point (845,5);
            Rectangle rect3 = new Rectangle(p3, width3, height3);
            Block b3 = new Block (rect3, color3);

            Color color4 = new Color (10,50,100);
            int width4 = WIDTH-10;
            int height4 = 50;
            Point p4 = new Point (5,645);
            Rectangle rect4 = new Rectangle(p4, width4, height4);
            Block b4 = new Block (rect4, color4);

            ball.getGameEnvironment().addCollidable(b1);
            ball.getGameEnvironment().addCollidable(b2);
            ball.getGameEnvironment().addCollidable(b3);
            ball.getGameEnvironment().addCollidable(b4);


            while (true) {
                DrawSurface d = gui.getDrawSurface();
                ball.drawOn(d);
                b1.drawOn(d);
                b2.drawOn(d);
                b3.drawOn(d);
                b4.drawOn(d);
                gui.show(d);
                ball.moveOneStep();
                sleeper.sleepFor(50); // wait for 50 milliseconds.
            }
        }
    }

