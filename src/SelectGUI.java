import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SelectGUI {

    private Stage window;
    private GridPane selectionPage;


    public SelectGUI(){

        selectionPage = new GridPane();
        selectionPage.setVgap(5);
        selectionPage.setHgap(5);

    }

    public GridPane getPage(){
        return selectionPage;
    }
}
