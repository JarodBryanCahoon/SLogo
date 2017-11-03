package frontend.xml;

import org.w3c.dom.Element;

/**
 * An XMLWriter that does nothing special but write to file from a rot
 * @author Albert
 *
 */
public class GenericWriter extends XMLWriter {
	/**
	 * Creates a new GenericWriter that writes the root element to specified path
	 * @param path	path to create file at
	 * @param root	root to write file from
	 */
	public GenericWriter(String path, Element root) {
		super(path, root);
	}

	@Override
	public Element createChild() {
		// do nothing
		return null;
	}

}
