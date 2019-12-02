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
    SelectGUI select;
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


        select = new SelectGUI();
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
            window.setScene(gameScene);
            game = loader.load();
//            run();
        });
        Button exitButton = new Button("EXIT");
        exitButton.setOnAction( e -> {
            System.exit(1);
        });

        buttonBox.getChildren().addAll(startButton, resumeButton, exitButton);


        return buttonBox;
    }

    /**
     * Main game loop
     */
    public void run() {
        window.setScene(gameScene);
        int turnCount = game.getStartingTurn();
        // start turn with player0
        while (!game.isGameOver()) {
            //TODO some sort of updateBoardGUI function that goes through the game's board's arraylists
            //     and updates the piece positions every time the game loops
            game.turn(turnCount);
            // until the game is over, rotate turns
            if (!game.isGameOver()) {
                turnCount += 1;
                turnCount %= Constants.NUMPLAYERS;
            }
            loader.save(turnCount, game.getPlayers());
        }

        // if the game is over because a winner was selected, win
        if (game.getWinner() != -1) {
            game.win(game.getWinner());
        }
        // else game was stopped for another reason


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
            window.setScene(gameScene);
            game = new Game(select.getTypes());
//            run();
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
