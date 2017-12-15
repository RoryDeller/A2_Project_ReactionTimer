package Controller;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Random;

public class RandomDotController {

    private GraphicsContext gc;
    private int width;
    private int height;
    private TimerController timerController;

    private int currentX;
    private int currentY;
    private int currentR;
    private int currentG;
    private int currentB;
    private int currentRadius;
    private long nextDotTime;
    private long dotExpiryTime;
    private double lifetime = 2;
    private double delay = 3;
    private Image circleImage;
    private boolean lifeTaken = false;

    private long lastMissedTime;

    public RandomDotController(GraphicsContext gc, int width, int height, TimerController timerController) {
        this.gc = gc;
        this.width = width;
        this.height = height;
        this.timerController = timerController;
        this.circleImage = new Image("Resources/Circle.png");
        this.nextDotTime = 0;
    }

    public void start() {

        final Font missedFont = new Font("Arial", 60);
        final Font loseFont = new Font("Arial", 100);

        new AnimationTimer() {

            @Override
            public void handle(long now) {

                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, width, height);

                if (HeartController.lives <= 0) {

                    gc.setFill(Color.WHITE);
                    gc.setFont(missedFont);
                    gc.fillText("GAME OVER!", 100, 100);

                }
                else if (!timerController.countDown) {

                    long currentTime = System.currentTimeMillis();

                    if (currentTime > nextDotTime) {
                        lifeTaken = false;
                        newCircle();
                    }

                    gc.drawImage(circleImage, width/2 - circleImage.getWidth()/2,height/2 - circleImage.getHeight()/2);

                    if (currentTime < dotExpiryTime) {
                        gc.setFill(Color.rgb(currentR, currentB, currentG));
                        gc.fillOval(currentX - currentRadius / 2, currentY - currentRadius / 2, currentRadius, currentRadius);
                    } else if (!lifeTaken) {
                        if (nextDotTime != 0) HeartController.lives -= 1;
                        lifeTaken = true;
                    }

                    if (currentTime < lastMissedTime + 1000) {

                        gc.setFill(Color.rgb(255,0,0, ((float) (lastMissedTime + 1000 - currentTime))/1000.0));
                        gc.setFont(missedFont);
                        gc.fillText("MISSED!", 100, 100);

                    }

                }

            }

        }.start();

    }

    public void canvasClicked(MouseEvent e) {

        if (timerController.countDown){
            return;
        }
        double x = e.getX();
        double y = e.getY();

        System.out.println("You clicked at " + x + ", " + y);

        if (Math.pow(x - currentX, 2) + Math.pow(y - currentY, 2) <= Math.pow(currentRadius, 2)) {
            newCircle();
            System.out.println("You clicked on a circle!!!");
        }
        else {
            System.out.println("You missed!!!");
            lastMissedTime = System.currentTimeMillis();
            HeartController.lives -= 1;
        }

    }

    public void newCircle() {

        long currentTime = System.currentTimeMillis();

        Random rnd = new Random(currentTime);

        boolean inCircle;

        do {

            currentRadius = rnd.nextInt(50) + 50;
            currentX = rnd.nextInt(width - currentRadius * 2) + currentRadius;
            currentY = rnd.nextInt(height - currentRadius * 2) + currentRadius;

            inCircle = Math.pow(currentX - width/2, 2)
                    + Math.pow(currentY - height/2, 2)
                    < Math.pow(currentRadius + circleImage.getWidth()/2, 2);

        } while (inCircle);

        currentR = rnd.nextInt(255);
        currentG = rnd.nextInt(255);
        currentB = rnd.nextInt(255);
        dotExpiryTime = currentTime + (long) (lifetime * 1000);
        nextDotTime = currentTime + (long) (delay * 1000);

        delay *= 0.95;
        lifetime *= 0.95;
    }


}

