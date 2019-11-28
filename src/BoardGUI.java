import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BoardGUI {

    private Stage window;
    private GridPane board;


    public BoardGUI(){
        board = new GridPane();
        board.setAlignment(Pos.CENTER);
        board.setVgap(10);
        board.setHgap(10);
        setSquares(board);
    }


    private void setSquares(GridPane board){

        // The DIE
        Label die = new Label("?");
        board.add(die, 6,6);
        die.setAlignment(Pos.CENTER);
        die.getStyleClass().add("die");
        die.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
                die.setText("1");
            }
        });

        //home 1 RED
        for (int i=0; i<=3; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("redSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, i, 3-i);
        }

        //home 2 YELLOW
        for (int i=0; i<=3; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("yellowSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, i, 9+i);
        }

        //home 3 GREEN
        for (int i=0; i<=3; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("greenSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, 12-i, 9+i);
        }

        //home 4 BLUE
        for (int i=0; i<=3; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("blueSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, 9+i, i);
        }

        // top row of spaces
        for (int i=0; i<7; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("boardSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, 2, 3+i);
        }

        // bottom row of spaces
        for (int i=0; i<7; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("boardSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, 10, 3+i);
        }

        // left column of spaces
        for (int i=0; i<7; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("boardSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, 3+i, 2);
        }

        // right column of spaces
        for (int i=0; i<7; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("boardSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, 3+i, 10);
        }

        //Finish 1 RED
        for (int i=0; i<=3; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("redSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, 3, 3+i);
        }

        //finish 2 YELLOW
        for (int i=0; i<=3; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("yellowSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, 3+i, 9);
        }

        //finish 3 GREEN
        for (int i=0; i<=3; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("greenSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, 9, 9-i);
        }

        //finish 4 BLUE
        for (int i=0; i<=3; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("blueSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure,9-i , 3);
        }

    }

    public GridPane getBoard(){
        return this.board;
    }
}