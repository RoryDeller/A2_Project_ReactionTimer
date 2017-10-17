import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ReactionTester {

    private static Stage masterStage;

    public static void ReactionTesterScene(Stage stage) {

        masterStage = stage;

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1024, 768);

        stage.setScene(scene);




    }

}
