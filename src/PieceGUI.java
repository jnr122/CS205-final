import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PieceGUI extends Circle implements SelectPiece {
    public PieceGUI(double centerX, double centerY, double radius) {
        super(centerX, centerY, radius);
    }

    @Override
    public boolean requestSelection(boolean select) {
        return true;
    }

    @Override
    public void notifySelection(boolean select) {
        if(select)
            this.setFill(Color.GRAY);
        else
            this.setFill(Color.BLACK);
    }
}
