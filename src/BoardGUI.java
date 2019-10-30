import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
        board.setVgap(5);
        board.setHgap(5);
        setSquares(board);
    }


    private void setSquares(GridPane board){


        //home 1
        for (int i=0; i<=3; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("boardSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, i, 3-i);
        }

        //home 2
        for (int i=0; i<=3; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("boardSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, i, 9+i);
        }

        //home 3
        for (int i=0; i<=3; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("boardSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, 12-i, 9+i);
        }

        //home 4
        for (int i=0; i<=3; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("boardSquare");
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

    }

    public GridPane getBoard(){
        return this.board;
    }
}