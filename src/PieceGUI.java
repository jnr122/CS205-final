import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PieceGUI extends Circle {

    public PieceGUI(){
        this.setCenterX(10.0f);
        this.setCenterY(10.0f);
        this.setRadius(25.0f);
        this.setFill(Color.GRAY);

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                System.out.println("hi");
            }
        });

    }
}
