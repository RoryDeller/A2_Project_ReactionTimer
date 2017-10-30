import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage masterStage;

    @Override
    public void start(Stage stage) throws Exception {

        masterStage = stage;

        BorderPane root = new BorderPane();

        HBox leftPane = new HBox(20);
        Button leftButton1 = new Button("Reaction Tester");
        leftButton1.setOnAction((ActionEvent ae) -> toReactionTester(ae));
        leftPane.getChildren().add(leftButton1);
        root.setLeft(leftPane);
        leftPane.setAlignment(Pos.CENTER_RIGHT);
        BorderPane.setAlignment(leftPane, Pos.CENTER_LEFT);
        leftPane.setStyle("-fx-background-color: RED");
        leftPane.setPrefWidth(400);

        VBox rightPane = new VBox(20);
        Button rightButton1 = new Button("Reaction Timer");
        rightButton1.setOnAction((ActionEvent ae) -> doSomething(ae));
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
        rightButton2.setOnAction((ActionEvent ae) -> doSomething(ae));

        rightButton2.setPadding(new Insets(20));
        quitSubPane.getChildren().add(rightButton2);

        quitSubPane.setPadding(new Insets(20));
        HBox.setHgrow(quitSubPane, Priority.ALWAYS);
        quitSubPane.setAlignment(Pos.CENTER_RIGHT);
        Button bottomButton2 = new Button("Quit");
        bottomButton2.setOnAction((ActionEvent ae) -> terminate());

        bottomButton2.setPadding(new Insets(20));
        quitSubPane.getChildren().add(bottomButton2);
        quitSubPane.setAlignment(Pos.BOTTOM_RIGHT);
        authorPane.getChildren().add(quitSubPane);
        quitSubPane.setStyle("-fx-background-color: Silver");



        root.setBottom(authorPane);



        VBox centerPane = new VBox(3);
        Button enterMusic = new Button("Musical Mode");
        enterMusic.setOnAction((ActionEvent ae) -> doSomething(ae));
        centerPane.setStyle("-fx-background-color: green");
        centerPane.getChildren().add(enterMusic);
        centerPane.setPrefWidth(50);

        ImageView iv1 = new ImageView(new Image("Sample.gif"));
        centerPane.getChildren().add(iv1);

        Button centerButton3 = new Button("Statistics");
        centerButton3.setOnAction((ActionEvent ae) -> doSomething(ae));
        centerPane.getChildren().add(centerButton3);
        root.setCenter(centerPane);
        centerPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(centerPane, Pos.CENTER);


        Scene scene = new Scene(root, 1024, 768);

        stage.setTitle("Full screen canvas");
        stage.setResizable(true);
        stage.setFullScreen(true);
        stage.setWidth(1280);
        stage.setHeight(1024);
        stage.setScene(scene);

        stage.show();

    }



    public static void main(String[] args) {
        launch(args);



    }

    public static void doSomething(ActionEvent ae) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Placeholder code, this feature has not been implemented yet.");
        alert.showAndWait();



    }

    public static void toReactionTester(ActionEvent ae){
        ReactionTester.ReactionTesterScene(masterStage);

    }

    private static void terminate()
    {
        System.exit(0);
    }

}

