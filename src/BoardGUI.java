import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class BoardGUI {

    private GridPane board;


    public BoardGUI(){
        board = new GridPane();
        board.setAlignment(Pos.CENTER);
        board.setVgap(10);
        board.setHgap(10);
        setSquares(board);
    }

    private void setSquares(GridPane board){
        // SCALING FOR EFFECTS
        Scale scaleUP = new Scale(1.08, 1.08);
        scaleUP.setPivotX(75);
        scaleUP.setPivotY(75);
        Scale scaleDown = new Scale(1, 1);
        scaleDown.setPivotX(0);
        scaleDown.setPivotY(0);

        // The DIE
        Label die = new Label("?");
        board.add(die, 6,6);
        die.setAlignment(Pos.CENTER);
        die.getStyleClass().add("die");
        die.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                die.setText("1");
            }
        });
        // die animation
//        die.setOnMouseEntered(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent t) {
//                die.getTransforms().setAll(scaleUP);
//            }
//        });
//
//        die.setOnMouseExited(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent t) {
//                die.getTransforms().setAll(scaleDown);
//            }
//        });



        //home 1 RED
        for (int i=0; i<=3; i++) {
            Circle boardSqaure = new Circle();
            StackPane stacked = new StackPane();
            String homeLabel = "HOME";
            Label home = new Label(Character.toString(homeLabel.charAt(i)));
            stacked.getChildren().addAll(boardSqaure, home);

            boardSqaure.getStyleClass().add("redSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(stacked, i, 3-i);

            PieceGUI piece = new PieceGUI(0);
            board.add(piece, i, 3-i);
        }

        //home 2 YELLOW
        for (int i=0; i<=3; i++) {
            Circle boardSqaure = new Circle();
            StackPane stacked = new StackPane();
            String homeLabel = "HOME";
            Label home = new Label(Character.toString(homeLabel.charAt(i)));
            stacked.getChildren().addAll(boardSqaure, home);

            boardSqaure.getStyleClass().add("yellowSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(stacked, i, 9+i);
        }

        //home 3 GREEN
        for (int i=0; i<=3; i++) {
            Circle boardSqaure = new Circle();
            StackPane stacked = new StackPane();
            String homeLabel = "HOME";
            Label home = new Label(Character.toString(homeLabel.charAt(i)));
            stacked.getChildren().addAll(boardSqaure, home);

            boardSqaure.getStyleClass().add("greenSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(stacked, 9+i, 12-i);
        }

        //home 4 BLUE
        for (int i=0; i<=3; i++) {
            Circle boardSqaure = new Circle();
            StackPane stacked = new StackPane();
            String homeLabel = "HOME";
            Label home = new Label(Character.toString(homeLabel.charAt(i)));
            stacked.getChildren().addAll(boardSqaure, home);

            boardSqaure.getStyleClass().add("blueSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(stacked, 9+i, i);
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