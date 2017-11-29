package Controller;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class HeartController {

    private static double heartPulse = 0;

    public static void startHeartAnimation(GraphicsContext heartGC) {

        Image heart = new Image("Resources/heart.png");

        new AnimationTimer() {
            @Override
            public void handle(long now) {

                heartPulse += 0.2;

                double heartScale = 10+10*Math.sin(heartPulse);

                //heartGC.setFill(Color.rgb(0,0,64));
                //heartGC.fillRect(0,0,499,499);

                heartGC.clearRect(0,0,999,99);

                for (int x = 0; x <= 900; x += 100) {
                    heartGC.drawImage(heart, 0, 0, 200, 200, x + heartScale, heartScale, 100 - 2 * heartScale, 100 - 2 * heartScale);
                }

                /*for (int i = 0; i < BALL_COUNT; i++) {
                    x[i] += dx[i];
                    y[i] += dy[i];
                    t[i] += 0.1;

                    double radius = 50 + 30 * Math.sin(t[i]);

                    if (x[i] < radius/2 && dx[i] < radius/2) dx[i] = -dx[i];
                    if (y[i] < radius/2 && dy[i] < radius/2) dy[i] = -dy[i];
                    if (x[i] > 500 - radius/2 && dx[i] < 500 - radius/2) dx[i] = -dx[i];
                    if (y[i] > 500 - radius/2 && dy[i] < 500 - radius/2) dy[i] = -dy[i];

                    circleGC.setFill(Color.rgb(r[i], g[i], b[i], a[i]));
                    circleGC.fillOval(x[i] - radius/2, y[i] - radius/2, radius, radius);

                }*/

            }
        }.start();

    }

}
