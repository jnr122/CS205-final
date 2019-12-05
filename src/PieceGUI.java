import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Scale;

import java.awt.*;

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
        this.setCenterX(15.0f);
        this.setCenterY(15.0f);
        this.setRadius(26.0f);

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                System.out.println("hi");
            }
        });

        setMouseOver();


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

    private void setMouseOver(){
        // SCALING FOR EFFECTS
        Scale scaleUP = new Scale(1.03, 1.03);
        scaleUP.setPivotX(75);
        scaleUP.setPivotY(75);
        Scale scaleDown = new Scale(1, 1);
        scaleDown.setPivotX(0);
        scaleDown.setPivotY(0);

        // this is a hacky bit of code but it works... ¯\_(ツ)_/¯
        PieceGUI c  = this;

        this.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                c.getTransforms().setAll(scaleUP);
            }
        });

        this.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                c.getTransforms().setAll(scaleDown);
            }
        });

    }
}
