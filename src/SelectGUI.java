import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;

import java.util.ArrayList;

public class SelectGUI {

    private VBox selectionPage;
    private ArrayList<Type> types;


    public SelectGUI(){

        selectionPage = new VBox();
        types = new ArrayList<>();
        setUp(selectionPage);

    }

    private void setUp(VBox page){
        // SCALING FOR EFFECTS
        Scale scaleUP = new Scale(1.02, 1.02);
        scaleUP.setPivotX(75);
        scaleUP.setPivotY(75);
        Scale scaleDown = new Scale(1, 1);
        scaleDown.setPivotX(0);
        scaleDown.setPivotY(0);

        HBox boxes = new HBox(10);
        boxes.setAlignment(Pos.CENTER);
        for (int i = 0; i < 4; i++) {
            types.add(Type.NULL);
            StackPane stacked = new StackPane();
            Label selection = new Label(Integer.toString(i) + "-NONE");
            Rectangle r = new Rectangle();
            r.setWidth(150);
            r.setHeight(150);
            r.setArcWidth(20);
            r.setArcHeight(20);
            r.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent t) {
                    String[] text = selection.getText().split("-");
                    int ind =  Integer.parseInt(text[0]);
                    if (text[1].equals("NONE")) {
                        selection.setText(text[0] + "-PLAYER");
                        types.set(ind, Type.PLAYER);
                    } else if (text[1].equals("PLAYER")) {
                        selection.setText(text[0] + "-CPU");
                        types.set(ind, Type.CPU);
                    } else if (text[1].equals("CPU")) {
                        selection.setText(text[0] + "-NONE");
                        types.set(ind, Type.NULL);
                    }
                }
            });

            r.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    r.getTransforms().setAll(scaleUP);
                }
            });

            r.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    r.getTransforms().setAll(scaleDown);
                }
            });
            switch(i) {
                case 0: //red
                    r.getStyleClass().add("redSelectSquare");
                    break;
                case 1: //yellow
                    r.getStyleClass().add("yellowSelectSquare");
                    break;
                case 2: //green
                    r.getStyleClass().add("greenSelectSquare");
                    break;
                case 3: //blue
                    r.getStyleClass().add("blueSelectSquare");
                    break;
                default:
                    break;
            }
            stacked.getChildren().addAll(r, selection);
            boxes.getChildren().addAll(stacked);
        }


        HBox labels = new HBox(5);

        page.setAlignment(Pos.CENTER);
        page.getChildren().addAll(boxes, labels);


    }


    public VBox getPage(){
        return selectionPage;
    }
    public ArrayList<Type> getTypes() {
        return types;
    }
}
