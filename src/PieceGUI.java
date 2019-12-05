import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PieceGUI extends Circle {

    public PieceGUI(int playerNum){

        switch(playerNum){
            case 0:
                makeRed();
                break;
            case 1:
                makeYellow();
                break;
            case 2:
                makeGreen();
                break;
            case 3:
                makeBlue();
                break;
            default:
                break;
        }
        this.setCenterX(10.0f);
        this.setCenterY(10.0f);
        this.setRadius(25.0f);

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                System.out.println("hi");
            }
        });
    }

    private void makeRed(){
        this.getStyleClass().add("redPiece");
    }

    private void makeYellow(){
        this.getStyleClass().add("yellowPiece");
    }

    private void makeGreen(){
        this.getStyleClass().add("greenPiece");
    }

    private void makeBlue(){
        this.getStyleClass().add("bluePiece");
    }
}
