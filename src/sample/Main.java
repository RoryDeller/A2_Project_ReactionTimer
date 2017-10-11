package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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
        leftPane.setStyle("-fx-background-color: RED");
        leftPane.setPrefWidth(400);

        VBox rightPane = new VBox(20);
        Button rightButton1 = new Button("Reaction Timer");
        rightPane.getChildren().add(rightButton1);
        rightPane.setStyle("-fx-background-color: aqua");
        //BorderPane.setAlignment(rightPane, Pos.CENTER_RIGHT);
        rightPane.setAlignment(Pos.CENTER_LEFT);
        rightPane.setPrefWidth(400);
        root.setRight(rightPane);

        VBox topPane = new VBox(20);
        Label Title = new Label("Welcome to my reaction Timer");
        Title.setFont(new Font("Arial", 30));
        topPane.getChildren().add(Title);
        root.setTop(topPane);
        topPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);


        HBox authorPane = new HBox(20);
        authorPane.setPadding(new Insets(20));
        authorPane.setStyle("-fx-background-color: Grey");
        Label Author = new Label("By Rory Deller");
        Author.setFont(new Font("Arial", 25));
        authorPane.getChildren().add(Author);

        HBox quitSubPane = new HBox(20);
        Button rightButton2 = new Button("Settings");
        rightButton2.setPadding(new Insets(20));
        quitSubPane.getChildren().add(rightButton2);

        quitSubPane.setPadding(new Insets(20));
        HBox.setHgrow(quitSubPane, Priority.ALWAYS);
        quitSubPane.setAlignment(Pos.CENTER_RIGHT);
        Button bottomButton2 = new Button("Quit");
        bottomButton2.setPadding(new Insets(20));
        quitSubPane.getChildren().add(bottomButton2);
        quitSubPane.setAlignment(Pos.BOTTOM_RIGHT);
        authorPane.getChildren().add(quitSubPane);
        quitSubPane.setStyle("-fx-background-color: Silver");



        root.setBottom(authorPane);



        VBox centerPane = new VBox(3);
        Button enterMusic = new Button("Musical Mode");
        centerPane.setStyle("-fx-background-color: green");
        centerPane.getChildren().add(enterMusic);
        centerPane.setPrefWidth(50);

        ImageView iv1 = new ImageView(new Image("Sample.gif"));
        centerPane.getChildren().add(iv1);

        Button centerButton3 = new Button("Statistics");
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