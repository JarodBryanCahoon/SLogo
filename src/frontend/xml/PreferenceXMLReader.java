package frontend.xml;

import java.io.IOException;

import exceptions.XMLException;

public class PreferenceXMLReader extends XMLReader {
	public enum RenderTags {
		NAME("name"),
		MODULE("module"),
		RESOURCES("resources"),
		MYX("myX"),
		MYY("myY"),
		PEN("pen"),
		PEN_WIDTH("pen_width"),
		VISIBILITY("is_visible"),
		ANGLE("angle"),
		ID("id"),
		PATH("image_path"),
		STAGE_WIDTH("stage_width"),
		STAGE_HEIGHT("stage_height");

		private String tag;

		RenderTags(String tag) {
			this.tag = tag;
		}

		public String getTag() {
			return tag;
		}
	}

	
	public PreferenceXMLReader(String path) throws XMLException, IOException {
		super(path);
	}

	@Override
	protected void readFromFile() throws XMLException {
		// TODO Auto-generated method stub

	}

}
