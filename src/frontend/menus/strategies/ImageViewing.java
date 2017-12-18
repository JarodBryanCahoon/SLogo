package frontend.menus.strategies;

import backend.board.RenderSprite;
import exceptions.ErrorMessage;
import frontend.modules.RenderModule;
import frontend.modules.ViewModule;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

public class ImageViewing extends MenuItemStrategy {
    private static final int DIMENSIONS = 50;

    /**
     * Creates a new MenuItemStrategy
     *
     * @param module ViewModule associated with this strategy
     */
    public ImageViewing(ViewModule module) {
        super(module);
    }

    @Override
    public void execute() {
        Stage s = new Stage();
        Scene scene = new Scene(createViewer(this.getView(), s));
        s.setScene(scene);
        s.show();
    }

    private GridPane createViewer(ViewModule view, Stage stage) {
        GridPane gridPane = new GridPane();
        RenderModule render = view.getRenderModule();
        List<RenderSprite> sprites = render.getSprites();
        for(int i = 0; i < sprites.size(); i++) {
            ImageView spriteView = sprites.get(i).getImage();
            ImageView imgView = new ImageView(spriteView.getImage());
            imgView.setFitWidth(DIMENSIONS);
            imgView.setFitHeight(DIMENSIONS);
            imgView.setOnMouseClicked(display -> openFileChooser(imgView, spriteView, stage));
            gridPane.add(imgView, 0, i);
        }
        return gridPane;
    }

    private void openFileChooser(ImageView display, ImageView turtleView, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File selected = fileChooser.showOpenDialog(null);
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        if(selected != null) {
            Image img = null;
            try {
                img = new Image(selected.toURI().toURL().toString());
            } catch (MalformedURLException e) {
                new ErrorMessage("uh oh").show();
                return;
            }
            display.setImage(img);
            double oldHeight = turtleView.getBoundsInLocal().getHeight();
            double oldWidth = turtleView.getBoundsInLocal().getWidth();
            turtleView.setImage(img);
            turtleView.setFitHeight(oldHeight);
            turtleView.setFitWidth(oldWidth);
        }
    }
}
