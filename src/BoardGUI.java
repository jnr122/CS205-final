import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BoardGUI extends BorderPane {

    private Stage window;
    private BorderPane mainPane = new BorderPane();
    private BorderPane board = new BorderPane();


    public BoardGUI(Stage stage){
        this.window = stage;

        setSquares(this.board);
        mainPane.setCenter(this.board);


    }


    private void setSquares(BorderPane board){

        HBox topRow = new HBox(7);
        topRow.setPadding(new Insets(20,20,20,20));
        topRow.setAlignment(Pos.CENTER);
        HBox botRow = new HBox(7);
        botRow.setPadding(new Insets(20,20,20,20));
        botRow.setAlignment(Pos.CENTER);
        VBox leftCol= new VBox(7);
        VBox rightCol = new VBox(7);

        for (int i=0; i<=7; i++){
            Circle boardSqaure = new Circle();
            boardSqaure.setId("boardSquare");
            boardSqaure.setCenterX(100.0f);
            boardSqaure.setCenterY(100.0f);
            boardSqaure.setRadius(50.0f);
            topRow.getChildren().addAll(boardSqaure);
            botRow.getChildren().addAll(boardSqaure);
            leftCol.getChildren().addAll(boardSqaure);
            rightCol.getChildren().addAll(boardSqaure);

            board.setTop(topRow);
            board.setBottom(botRow);
            board.setRight(rightCol);
            board.setLeft(leftCol);
        }
    }
}