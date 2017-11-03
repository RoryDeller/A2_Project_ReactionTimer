import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class ReactionTester {

    private static Stage masterStage;

    //private double x[], y[], dx[], dy[], t[], a[];
    //private int r[], g[], b[];
    //final int BALL_COUNT = 5000;

    double heartPulse = 0;


    public ReactionTester(Stage stage) {

        masterStage = stage;

        BorderPane root = new BorderPane();

        HBox topPane = new HBox();
        topPane.setAlignment(Pos.TOP_CENTER);
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);
        topPane.setStyle("-fx-background-color: Red");
        topPane.setMinHeight(100);
        root.setTop(topPane);

        HBox bottomPane = new HBox();
        HBox.setHgrow(bottomPane, Priority.ALWAYS);
        bottomPane.setStyle("-fx-background-color: Green");
        BorderPane.setAlignment(bottomPane, Pos.BOTTOM_LEFT);
        bottomPane.setAlignment(Pos.BOTTOM_LEFT);
        bottomPane.setMinHeight(100);
        root.setBottom(bottomPane);

        /*VBox topPane = new VBox(20);
        root.setTop(topPane);
        topPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);*/



        VBox centerPane = new VBox(3);
        centerPane.setStyle("-fx-background-color: Grey");


        //ImageView iv1 = new ImageView(new Image("Circle.png"));
        //Image circleImage = new Image("Circle.png");

        Canvas heartCanvas = new Canvas();
        heartCanvas.setWidth(1000);
        heartCanvas.setHeight(100);
        bottomPane.getChildren().add(heartCanvas);


        /*Canvas circleCanvas = new Canvas();
        circleCanvas.setWidth(500);
        circleCanvas.setHeight(500);
        centerPane.getChildren().add(circleCanvas);*/

        final GraphicsContext heartGC = heartCanvas.getGraphicsContext2D();
        //final GraphicsContext circleGC = circleCanvas.getGraphicsContext2D();

        /*x = new double[BALL_COUNT];
        y = new double[BALL_COUNT];
        dx = new double[BALL_COUNT];
        dy = new double[BALL_COUNT];
        r = new int[BALL_COUNT];
        g = new int[BALL_COUNT];
        b = new int[BALL_COUNT];
        a = new double[BALL_COUNT];
        t = new double[BALL_COUNT];

        Random rnd = new Random();

        for (int i = 0; i < BALL_COUNT; i++) {
            t[i] = rnd.nextDouble() * 2 * 3.1415926;
            x[i] = rnd.nextDouble() * 500;
            y[i] = rnd.nextDouble() * 500;
            dx[i] = (rnd.nextDouble() - 0.5) * 10;
            dy[i] = (rnd.nextDouble() - 0.5) * 10;
            r[i] = rnd.nextInt(256);
            g[i] = rnd.nextInt(256);
            b[i] = rnd.nextInt(256);
            a[i] = rnd.nextDouble();
        }*/

        Image heart = new Image("heart.png");


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


        root.setCenter(centerPane);
        centerPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(centerPane, Pos.CENTER);


        Scene scene = new Scene(root);

        stage.setTitle("Full screen canvas");
        stage.setScene(scene);
        stage.setFullScreen(true);

//        stage.show();





    }

}
