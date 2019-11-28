import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
    private BorderPane selectPane = new BorderPane();
    private Scene homeScene = new Scene(homePane, 800, 700);
    private Scene gameScene = new Scene(gamePane, 1000, 1000);
    private Scene selectScene = new Scene(selectPane, 800, 600);
    private Loader loader = new Loader();
    private Game game;


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
        homePane.setAlignment(title(), Pos.BASELINE_CENTER);
        homePane.setTop(title());


        SelectGUI select = new SelectGUI();
        BoardGUI board = new BoardGUI();

        gamePane.setCenter(board.getBoard());
        gamePane.setTop(gameButtons());
        selectPane.setCenter(select.getPage());
        selectPane.setBottom(selectButtons());

        homeScene.getStylesheets().add("resources/stylesheet.css");
        gameScene.getStylesheets().add("resources/stylesheet.css");
        selectPane.getStylesheets().add("resources/stylesheet.css");

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
            window.setScene(selectScene);
        });
        Button resumeButton = new Button("RESUME");
        resumeButton.setOnAction( e -> {
            //TODO load a stored game
            window.setScene(gameScene);
        });
        Button exitButton = new Button("EXIT");
        exitButton.setOnAction( e -> {
            System.exit(1);
        });

        buttonBox.getChildren().addAll(startButton, resumeButton, exitButton);


        return buttonBox;
    }


    /**
     * The title for the game
     * @return a label for the title

     */
    private Label title() {
        Label title = new Label(" TROUBLE");
        title.getStyleClass().add("labelTitle");
        title.setAlignment(Pos.CENTER);

        return title;
    }

    /**
     * collection of buttons on the selection screen
     * @return an HBox of two buttons centered
     */
    private HBox selectButtons(){

        HBox buttonBox = new HBox(1);
        buttonBox.setPadding(new Insets(20,20,20,20));
        buttonBox.setAlignment(Pos.CENTER);

        Button backButton = new Button("BACK");
        backButton.setOnAction(e -> {
            window.setScene(homeScene);
        });
        Button startButton = new Button("START");
        startButton.setOnAction( e -> {
            //TODO load a stored game
            window.setScene(gameScene);
        });

        buttonBox.getChildren().addAll(backButton, startButton);

        return buttonBox;
    }

    /**
     * collection of buttons on the game screen
     * @return an HBox of buttons
     */
    private HBox gameButtons(){

        HBox buttonBox = new HBox(1);
        buttonBox.setPadding(new Insets(20,20,20,20));
        buttonBox.setAlignment(Pos.CENTER_RIGHT);

        Button exitButton = new Button("EXIT");
        exitButton.setOnAction(e -> {
            window.setScene(homeScene);
        });

        buttonBox.getChildren().addAll(exitButton);

        return buttonBox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
