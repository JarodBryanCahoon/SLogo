package frontend.xml;

import exceptions.XMLException;

public class PreferenceXMLReader extends XMLReader {
	public enum RenderTags {
		MYX("myX"),
		MYY("myY"),
		PEN("pen"),
		PEN_WIDTH("pen width"),
		VISIBILITY("is visible"),
		ANGLE("angle"),
		ID("id"),
		PATH("image path"),
		STAGE_WIDTH("stage width"),
		STAGE_HEIGHT("stage height");

		private String tag;

		RenderTags(String tag) {
			this.tag = tag;
		}

		public String getTag() {
			return tag;
		}
	}

	
	public PreferenceXMLReader(String path) throws XMLException {
		super(path);
	}

	@Override
	protected void readFromFile() throws XMLException {
		// TODO Auto-generated method stub

	}

}
