package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        BorderPane root = new BorderPane();


        HBox leftPane = new HBox(20);
        Button leftButton1 = new Button("Reaction Tester");
        leftPane.getChildren().add(leftButton1);
        root.setLeft(leftPane);
        leftPane.setAlignment(Pos.CENTER_RIGHT);
        BorderPane.setAlignment(leftPane, Pos.CENTER_LEFT);

        VBox rightPane = new VBox(20);
        Button rightButton1 = new Button("Reaction Timer");
        rightPane.getChildren().add(rightButton1);
        Button rightButton2 = new Button("Settings");
        rightPane.getChildren().add(rightButton2);
        root.setRight(rightPane);
        rightPane.setAlignment(Pos.CENTER_LEFT);
        BorderPane.setAlignment(rightPane, Pos.CENTER_RIGHT);

        VBox topPane = new VBox(20);
        Label Title = new Label("Welcome to my reaction Timer");
        Title.setFont(new Font("Arial", 30));
        topPane.getChildren().add(Title);
        root.setTop(topPane);
        topPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);

        HBox bottomPane = new HBox(20);
        Label Author = new Label("By Rory Deller");
        Author.setFont(new Font("Arial", 25));
        bottomPane.getChildren().add(Author);
        Button bottomButton2 = new Button("Quit");
        bottomPane.getChildren().add(bottomButton2);
        root.setBottom(bottomPane);
        bottomPane.setAlignment(Pos.BOTTOM_LEFT);
        BorderPane.setAlignment(bottomPane, Pos.BOTTOM_CENTER);

        VBox centerPane = new VBox(3);
        Button enterMusic = new Button("Musical Mode");
        centerPane.getChildren().add(enterMusic);

        ImageView iv1 = new ImageView(new Image("Sample.gif"));
        centerPane.getChildren().add(iv1);

        Button centerButton3 = new Button("");
        centerPane.getChildren().add(centerButton3);
        root.setCenter(centerPane);
        centerPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(centerPane, Pos.CENTER);


        Scene scene = new Scene(root, 1024, 768);

        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();

        stage.setTitle("Full screen canvas");
        stage.setResizable(true);
        stage.setFullScreen(true);
        stage.setWidth(1280);
        stage.setHeight(1024);
        stage.setScene(scene);
        stage.show();

        Canvas canvas = new Canvas();
        canvas.setWidth(1280);
        canvas.setHeight(1024);
        root.getChildren().add(canvas);

        gc = canvas.getGraphicsContext2D();



    }

    public static GraphicsContext gc;

    public static void main(String[] args) {
        launch(args);



    }
}