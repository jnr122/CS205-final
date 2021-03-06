import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Scale;

public class BoardGUI {

    private GridPane board;
    private Die die;

    public BoardGUI(Board backendBoard, Die die, int currTurn){
        board = new GridPane();
        board.setAlignment(Pos.CENTER);
        board.setVgap(10);
        board.setHgap(10);
        this.die = die;
        setDie();
        setSquares(backendBoard, die, currTurn);

//        this.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("here");
//            }
//        });
    }

    private void addMouseListener(EventHandler<MouseEvent> mouseEventEventHandler) {
    }

    public void setDie() {
        // The DIE
        Globals.dieLabel = new Label("?");
        board.add(Globals.dieLabel, 6,6);
        Globals.dieLabel.setAlignment(Pos.CENTER);
        Globals.dieLabel.getStyleClass().add("die");
        Globals.dieLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                Globals.showDie = true;
                Globals.dieLabel.setText(Integer.toString(die.getCurrSide()));
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



    }


    public void setSquares(Board backendBoard, Die die, int currTurn){
        this.die = die;

        // SCALING FOR EFFECTS
        Scale scaleUP = new Scale(1.08, 1.08);
        scaleUP.setPivotX(75);
        scaleUP.setPivotY(75);
        Scale scaleDown = new Scale(1, 1);
        scaleDown.setPivotX(0);
        scaleDown.setPivotY(0);

        //home 0 RED
        for (int i=0; i<=3; i++) {
            int currPlayerNum = 0;
            Circle boardSqaure = new Circle();
            StackPane stacked = new StackPane();
            String homeLabel = "HOME";
            Label home = new Label(Character.toString(homeLabel.charAt(i)));
            stacked.getChildren().addAll(boardSqaure, home);

            if (currTurn == currPlayerNum) {
                boardSqaure.setStrokeWidth(5);
                boardSqaure.getStyleClass().add("currentTurn");
            } else {
                boardSqaure.setStrokeWidth(5);
                boardSqaure.getStyleClass().add("notCurrentTurnRed");

            }

            boardSqaure.getStyleClass().add("redSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(stacked, i, 3-i);

            Piece piece1 = backendBoard.getHomes().get(currPlayerNum).get(i).getPiece();
            if (piece1 != null) {
                PieceGUI piece = new PieceGUI(piece1.getPlayerNum(), piece1.getPieceNum());


                stacked = new StackPane();
                stacked.getChildren().addAll(piece, home);
                board.add(stacked, i, 3 - i);
            }

        }

        //home 1 YELLOW
        for (int i=0; i<=3; i++) {
            int currPlayerNum = 1;

            Circle boardSqaure = new Circle();
            StackPane stacked = new StackPane();
            String homeLabel = "HOME";
            Label home = new Label(Character.toString(homeLabel.charAt(i)));
            stacked.getChildren().addAll(boardSqaure, home);

            if (currTurn == currPlayerNum) {
                boardSqaure.setStrokeWidth(5);
                boardSqaure.getStyleClass().add("currentTurn");
            } else {
                boardSqaure.setStrokeWidth(5);
                boardSqaure.getStyleClass().add("notCurrentTurnYellow");
            }

            boardSqaure.getStyleClass().add("yellowSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(stacked, i, 9+i);

            Piece piece1 = backendBoard.getHomes().get(currPlayerNum).get(i).getPiece();
            if (piece1 != null) {
                PieceGUI piece = new PieceGUI(piece1.getPlayerNum(), piece1.getPieceNum());
                stacked = new StackPane();
                stacked.getChildren().addAll(piece, home);
                board.add(stacked, i, 9 + i);
            }
        }

        //home 2 GREEN
        for (int i=0; i<=3; i++) {
            int currPlayerNum = 2;
            Circle boardSqaure = new Circle();
            StackPane stacked = new StackPane();
            String homeLabel = "HOME";
            Label home = new Label(Character.toString(homeLabel.charAt(i)));
            stacked.getChildren().addAll(boardSqaure, home);

            if (currTurn == currPlayerNum) {
                boardSqaure.setStrokeWidth(5);
                boardSqaure.getStyleClass().add("currentTurn");
            }{
                boardSqaure.setStrokeWidth(5);
                boardSqaure.getStyleClass().add("notCurrentTurnGreen");
            }

            boardSqaure.getStyleClass().add("greenSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(stacked, 9+i, 12-i);

            Piece piece1 = backendBoard.getHomes().get(currPlayerNum).get(i).getPiece();
            if (piece1 != null) {
                PieceGUI piece = new PieceGUI(piece1.getPlayerNum(), piece1.getPieceNum());
                stacked = new StackPane();
                stacked.getChildren().addAll(piece, home);
                board.add(stacked, 9+i, 12 - i);
            }
        }

        //home 3 BLUE
        for (int i=0; i<=3; i++) {
            int currPlayerNum = 3;
            Circle boardSqaure = new Circle();
            StackPane stacked = new StackPane();
            String homeLabel = "HOME";
            Label home = new Label(Character.toString(homeLabel.charAt(i)));
            stacked.getChildren().addAll(boardSqaure, home);

            if (currTurn == currPlayerNum) {
                boardSqaure.setStrokeWidth(5);
                boardSqaure.getStyleClass().add("currentTurn");
            } else {
                boardSqaure.setStrokeWidth(5);
                boardSqaure.getStyleClass().add("notCurrentTurnBlue");
            }

            boardSqaure.getStyleClass().add("blueSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(stacked, 9+i, i);

            Piece piece1 = backendBoard.getHomes().get(currPlayerNum).get(i).getPiece();
            if (piece1 != null) {
                PieceGUI piece = new PieceGUI(piece1.getPlayerNum(), piece1.getPieceNum());
                stacked = new StackPane();
                stacked.getChildren().addAll(piece, home);
                board.add(stacked, 9+i, i);
            }
        }

        // top row of spaces
        for (int i=0; i<7; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("boardSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, 2, 3+i);

            Piece piece1 = backendBoard.getBoard().get(convertCoordinates(2, 3 + i)).getPiece();
            if (piece1 != null) {
                PieceGUI piece = new PieceGUI(piece1.getPlayerNum(), piece1.getPieceNum());
                piece.setCenterX(10.0f);
                piece.setCenterY(10.0f);
                piece.setRadius(30.0f);

                board.add(piece, 2, 3+i);
            }
        }

        // bottom row of spaces
        for (int i=0; i<7; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("boardSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, 10, 3+i);

            Piece piece1 = backendBoard.getBoard().get(convertCoordinates(10, 3+i)).getPiece();
            if (piece1 != null) {
                PieceGUI piece = new PieceGUI(piece1.getPlayerNum(), piece1.getPieceNum());

                piece.setCenterX(10.0f);
                piece.setCenterY(10.0f);
                piece.setRadius(30.0f);

                board.add(piece, 10, 3+i);
            }
        }

        // left column of spaces
        for (int i=0; i<7; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("boardSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, 3+i, 2);

            Piece piece1 = backendBoard.getBoard().get(convertCoordinates(3+i, 2)).getPiece();
            if (piece1 != null) {
                PieceGUI piece = new PieceGUI(piece1.getPlayerNum(), piece1.getPieceNum());

                piece.setCenterX(10.0f);
                piece.setCenterY(10.0f);
                piece.setRadius(30.0f);

                board.add(piece, 3+i, 2);
            }
        }

        // right column of spaces
        for (int i=0; i<7; i++) {
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("boardSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, 3+i, 10);

            Piece piece1 = backendBoard.getBoard().get(convertCoordinates(3+i, 10)).getPiece();
            if (piece1 != null) {
                PieceGUI piece = new PieceGUI(piece1.getPlayerNum(), piece1.getPieceNum());

                piece.setCenterX(10.0f);
                piece.setCenterY(10.0f);
                piece.setRadius(30.0f);

                board.add(piece, 3+i, 10);
            }
        }

        //Finish 0 RED
        for (int i=0; i<=3; i++) {
            int currPlayerNum = 0;
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("redSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, 3, 3+i);

            Piece piece1 = backendBoard.getFinishes().get(currPlayerNum).get(i).getPiece();
            if (piece1 != null) {
                PieceGUI piece = new PieceGUI(piece1.getPlayerNum(), piece1.getPieceNum());

                piece.setCenterX(10.0f);
                piece.setCenterY(10.0f);
                piece.setRadius(30.0f);

                board.add(piece, 3, 3+i);
            }
        }

        //finish 1 YELLOW
        for (int i=0; i<=3; i++) {
            int currPlayerNum = 1;

            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("yellowSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, 3+i, 9);

            Piece piece1 = backendBoard.getFinishes().get(currPlayerNum).get(i).getPiece();
            if (piece1 != null) {
                PieceGUI piece = new PieceGUI(piece1.getPlayerNum(), piece1.getPieceNum());

                piece.setCenterX(10.0f);
                piece.setCenterY(10.0f);
                piece.setRadius(30.0f);

                board.add(piece, 3+i, 9);
            }
        }

        //finish 2 GREEN
        for (int i=0; i<=3; i++) {
            int currPlayerNum = 2;
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("greenSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure, 9, 9-i);

            Piece piece1 = backendBoard.getFinishes().get(currPlayerNum).get(i).getPiece();
            if (piece1 != null) {
                PieceGUI piece = new PieceGUI(piece1.getPlayerNum(), piece1.getPieceNum());

                piece.setCenterX(10.0f);
                piece.setCenterY(10.0f);
                piece.setRadius(30.0f);

                board.add(piece, 9, 9-i);
            }
        }

        //finish 3 BLUE
        for (int i=0; i<=3; i++) {
            int currPlayerNum = 3;
            Circle boardSqaure = new Circle();
            boardSqaure.getStyleClass().add("blueSquare");
            boardSqaure.setCenterX(10.0f);
            boardSqaure.setCenterY(10.0f);
            boardSqaure.setRadius(30.0f);
            board.add(boardSqaure,9-i , 3);

            Piece piece1 = backendBoard.getFinishes().get(currPlayerNum).get(i).getPiece();
            if (piece1 != null) {
                PieceGUI piece = new PieceGUI(piece1.getPlayerNum(), piece1.getPieceNum());

                piece.setCenterX(10.0f);
                piece.setCenterY(10.0f);
                piece.setRadius(30.0f);

                board.add(piece, 9-i, 3);
            }
        }

    }
    
    public int convertCoordinates(int i, int j) {
        int x = 0;

        if (i > j && i != 10) {
            x = j - i + 28;
        }
        
        if (i > j && i == 10) {
            x = i - j + 13;
        }
        
        if (j > i && i != 2) {
            x = j + i - 6;
        }
        
        if (j > i && i == 2) {
            x = i + j - 5;
        }
        
        return x;
    }

    public GridPane getBoard(){
        return this.board;
    }

    public void setOnMouseClicked(EventHandler<MouseEvent> mouseEventEventHandler) {
        System.out.println("clicked");
    }
}
