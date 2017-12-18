package frontend.xml;

import java.io.IOException;

import exceptions.XMLException;

/**
 * A class that will theoretically read in preferences for each module according to an xml file
 * @author Albert
 *
 */
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

	
	/**
	 * Creates a new PreferenceXMLReader
	 * @param path			path of file to be read from
	 * @throws XMLException
	 * @throws IOException
	 */
	public PreferenceXMLReader(String path) throws XMLException, IOException {
		super(path);
	}

	@Override
	protected void readFromFile() throws XMLException {
		// TODO Auto-generated method stub

	}

}
