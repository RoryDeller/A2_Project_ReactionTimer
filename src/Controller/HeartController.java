package Controller;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class HeartController {

    public static int lives = 0;


    private static double heartPulse = 0;

    public static void startHeartAnimation(GraphicsContext heartGC) {

        lives = 3;

        Image heart = new Image("Resources/heart.png");

        new AnimationTimer() {
            @Override
            public void handle(long now) {

                heartGC.clearRect(0,0,999,99);

                if (lives <= 0) return;

                heartPulse += 0.2;

                double heartScale = 10+10*Math.sin(heartPulse);

                for (int x = 0; x < 100*lives; x += 100) {
                    heartGC.drawImage(heart, 0, 0, 200, 200, x + heartScale, heartScale, 100 - 2 * heartScale, 100 - 2 * heartScale);
                }

            }
        }.start();

    }

}
