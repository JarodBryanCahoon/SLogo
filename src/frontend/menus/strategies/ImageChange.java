package frontend.menus.strategies;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import backend.board.RenderSprite;
import exceptions.ErrorMessage;
import exceptions.XMLException;
import frontend.modules.RenderModule;
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
			 Path p = Paths.get(path);
			 ImageView newImage = loadImage(p);
			 List<RenderSprite> selectedSprites = getView().getRenderModule().getSprites();
			 for(RenderSprite s : selectedSprites) { 
				 if(s.isSelected()) {
					 RenderModule rModule = (RenderModule) getView().getRenderModule();

					 ImageView oldImage = s.changeImage(newImage);
					 rModule.replaceImage(oldImage, newImage);
				 }
			 }			 
		 } catch (XMLException | NullPointerException e) {
			 ErrorMessage eMessage = new ErrorMessage(ErrorMessage.INVALID_PATH);
			 eMessage.show();
		 }
	}
	
	private ImageView loadImage(Path path) throws XMLException{
		try {
			ImageView image = new ImageView(path.toString());
			return image;
		} catch (NullPointerException | IllegalArgumentException e) {
			throw new XMLException();
		}
	}
}
