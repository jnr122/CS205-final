import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *  GUI Class - this is where the magic happens and the GUI is run from.
 *  It is the main for the UI.
 */

public class GUI extends Application{

    private Stage window;
    private BorderPane homePane = new BorderPane();
    private BorderPane gamePane = new BorderPane();
    private Scene homeScene = new Scene(homePane, 800, 800);
    private Scene gameScene = new Scene(gamePane, 900, 900);


    @Override
    public void start(Stage stage) {
        window = stage;
        initUI(window);
    }

    /**
     * setting up the Userinterfaces
     * @param stage
     */
    private void initUI(Stage stage) {

        homePane.setCenter(homeButtons());
        homePane.setTop(title());

        BoardGUI board = new BoardGUI();

        gamePane.setCenter(board.getBoard());

        homeScene.getStylesheets().add("resources/stylesheet.css");
        gameScene.getStylesheets().add("resources/stylesheet.css");

        stage.setTitle("Trouble");
        stage.setScene(homeScene);
        stage.show();
    }

    /**
     * collection of buttons on the main screen
     * @return an HBox of three buttons centered
     */
    private HBox homeButtons() {

        HBox buttonBox = new HBox(1);
        buttonBox.setPadding(new Insets(20,20,20,20));
        buttonBox.setAlignment(Pos.CENTER);

        Button startButton = new Button("START");
        startButton.setOnAction(e -> {
            //TODO load a NEW board
            window.setScene(gameScene);
        });
        Button resumeButton = new Button("RESUME");
        resumeButton.setOnAction( e -> {
            //TODO load a stored game
            window.setScene(gameScene);
        });
        Button exitButtom = new Button("EXIT");
        exitButtom.setOnAction( e -> {
            System.exit(1);
        });

        buttonBox.getChildren().addAll(startButton, resumeButton, exitButtom);


        return buttonBox;
    }

    /**
     * The title for the game
     * @return a label for the title

     */
    private Label title() {
        Label title = new Label("TROUBLE");
        title.getStyleClass().add("labelTitle");
        title.setAlignment(Pos.CENTER);

        return title;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
