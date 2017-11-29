package GUIs;

import Controller.HeartController;
import Controller.RandomDotController;
import Controller.TimerController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReactionTester {

    private static Stage masterStage;

    //private double x[], y[], dx[], dy[], t[], a[];
    //private int r[], g[], b[];
    //final int BALL_COUNT = 5000;

    public ReactionTester(Stage stage) {

        masterStage = stage;

        BorderPane root = new BorderPane();

        HBox topPane = new HBox();
        topPane.setAlignment(Pos.TOP_CENTER);
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);
        topPane.setStyle("-fx-background-color: Red");
        topPane.setMinHeight(100);

        Label timeLabel = new Label();
        topPane.getChildren().add(timeLabel);

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

        Canvas heartCanvas = new Canvas();
        heartCanvas.setWidth(1000);
        heartCanvas.setHeight(100);
        bottomPane.getChildren().add(heartCanvas);


        Canvas circleCanvas = new Canvas();

        int circleCanvasWidth = 900;
        int circleCanvasHeight = 600;

        circleCanvas.setWidth(circleCanvasWidth);
        circleCanvas.setHeight(circleCanvasHeight);
        centerPane.getChildren().add(circleCanvas);

        GraphicsContext circleGC = circleCanvas.getGraphicsContext2D();




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

        TimerController timerController = new TimerController();
        timerController.startTimerAnimation(timeLabel);

        HeartController.startHeartAnimation(heartCanvas.getGraphicsContext2D());

        RandomDotController rdController = new RandomDotController(circleGC, circleCanvasWidth, circleCanvasHeight, timerController);
        rdController.start();


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
