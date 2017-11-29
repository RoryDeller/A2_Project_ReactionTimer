package Controller;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

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
    private int currentRaduis;
    private long nextDotTime;
    private long dotExpiryTime;
    private double lifetime = 2;
    private double delay = 3;
    private Image circleImage;

    public RandomDotController(GraphicsContext gc, int width, int height, TimerController timerController) {
        this.gc = gc;
        this.width = width;
        this.height = height;
        this.timerController = timerController;
        this.circleImage = new Image("Resources/Circle.png");
        this.nextDotTime = 0;
    }

    public void start() {

        new AnimationTimer() {

            @Override
            public void handle(long now) {

                if (!timerController.countDown) {

                    long currentTime = System.currentTimeMillis();

                    if (currentTime > nextDotTime) {

                        Random rnd = new Random(currentTime);

                        currentRaduis = rnd.nextInt(50) + 50;
                        currentX = rnd.nextInt(width - currentRaduis * 2) + currentRaduis;
                        currentY = rnd.nextInt(height - currentRaduis * 2) + currentRaduis;
                        currentR = rnd.nextInt(255);
                        currentG = rnd.nextInt(255);
                        currentB = rnd.nextInt(255);
                        dotExpiryTime = currentTime + (long) (lifetime * 1000);
                        nextDotTime = currentTime + (long) (delay * 1000);

                        delay *= 0.95;
                        lifetime *= 0.95;

                    }

                    gc.setFill(Color.BLACK);
                    gc.fillRect(0, 0, width, height);

                    gc.drawImage(circleImage, width/2 - circleImage.getWidth()/2,height/2 - circleImage.getHeight()/2);

                    if (currentTime < dotExpiryTime) {
                        gc.setFill(Color.rgb(currentR, currentB, currentG));
                        gc.fillOval(currentX - currentRaduis / 2, currentY - currentRaduis / 2, currentRaduis, currentRaduis);
                    }

                }

            }

        }.start();

    }

}
