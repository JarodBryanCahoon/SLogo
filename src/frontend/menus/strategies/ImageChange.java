package frontend.menus.strategies;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.List;

import backend.board.RenderSprite;
import exceptions.ErrorMessage;
import exceptions.XMLException;
import frontend.modules.ViewModule;
import javafx.scene.image.ImageView;

public class ImageChange extends MenuItemStrategy {
	public ImageChange(ViewModule module) {
		super(module);
	}

	@Override
	public void execute() {
		TextPromptWindow tWindow = new TextPromptWindow("Load", "Load Image URL...", e -> execute(e));
	}
	
	private void execute(String path) {
		 try {
			 ImageView newImage = loadImage(path);
			 List<RenderSprite> selectedSprites = getView().getRenderModule().getSelectedSprites();
			 for(RenderSprite s : selectedSprites) {  // ???
				 s.changeImage(newImage);
			 }			 
		 } catch (XMLException e) {
			 ErrorMessage eMessage = new ErrorMessage(ErrorMessage.INVALID_PATH);
			 eMessage.show();
		 }
	}
	
	private ImageView loadImage(String path) throws XMLException{
		try {
			ImageView image = new ImageView(path);
			return image;
		} catch (InvalidPathException | NullPointerException e) {
			throw new XMLException();
		}
	}
}
