import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ReactionTester {

    private static Stage masterStage;

    public static void ReactionTesterScene(Stage stage) {

        masterStage = stage;

        BorderPane root = new BorderPane();

        HBox leftPane = new HBox(20);
        root.setLeft(leftPane);
        leftPane.setAlignment(Pos.CENTER_RIGHT);
        BorderPane.setAlignment(leftPane, Pos.CENTER_LEFT);
        leftPane.setStyle("-fx-background-color: Grey");
        leftPane.setPrefWidth(400);

        VBox rightPane = new VBox(20);
        rightPane.setStyle("-fx-background-color: Grey");
        //BorderPane.setAlignment(rightPane, Pos.CENTER_RIGHT);
        rightPane.setAlignment(Pos.CENTER_LEFT);
        rightPane.setPrefWidth(400);
        root.setRight(rightPane);

        VBox topPane = new VBox(20);
        root.setTop(topPane);
        topPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);



        VBox centerPane = new VBox(3);
        centerPane.setStyle("-fx-background-color: Grey");
        centerPane.setPrefWidth(50);

        ImageView iv1 = new ImageView(new Image("Circle.gif"));
        centerPane.getChildren().add(iv1);


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

}
