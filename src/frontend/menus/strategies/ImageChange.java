package frontend.menus.strategies;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.List;

import backend.board.RenderSprite;
import exceptions.ErrorMessage;
import exceptions.XMLException;
import frontend.modules.ViewModule;
import frontend.popups.TextPromptWindow;
import javafx.scene.image.ImageView;

public class ImageChange extends MenuItemStrategy {
	public ImageChange(ViewModule module) {
		super(module);
	}

	@Override
	public void execute() {
		TextPromptWindow tWindow = new TextPromptWindow("Load", "Load Image URL...", e -> changeImage(e));
	}
	
	private void changeImage(String path) {
		 try {
			 ImageView newImage = loadImage(this.getClass().getClassLoader().getResource(path).getPath());
			 List<RenderSprite> selectedSprites = getView().getRenderModule().getSelectedSprites();
			 for(RenderSprite s : selectedSprites) {  // ???
				 s.changeImage(newImage);
			 }			 
		 } catch (XMLException | NullPointerException e) {
			 ErrorMessage eMessage = new ErrorMessage(ErrorMessage.INVALID_PATH);
			 eMessage.show();
		 }
	}
	
	private ImageView loadImage(String path) throws XMLException{
		try {
			ImageView image = new ImageView(path);
			return image;
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
			throw new XMLException();
		}
	}
}
