package frontend.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.xml.internal.txw2.Document;

import exceptions.ErrorMessage;
import exceptions.XMLException;
import frontend.modules.ViewModule;
import javafx.scene.Scene;

/**Creates a css file based off of an XML file
 * Allows for changing of the XML file
 * @author lasia
 *
 */
public class ColorReader extends XMLReader {
	public static final String CSSPATH = System.getProperty("user.dir")+"/src/resources/style/";
	public static final String CSSFILENAME = "stylesheet2.css";
	private String xmlPath;
	
	private File file;
	private FileWriter fileWriter;
	private BufferedWriter bf;
	private NodeList document;
	
	
	public ColorReader(String path) throws IOException {
		super(path);
		this.xmlPath = path;
	}

	@Override
	protected void readFromFile() throws IOException{
		file = new File(System.getProperty("user.dir")+"/src/resources/style/",CSSFILENAME);
		document = getElement().getChildNodes();
		fileWriter = new FileWriter(file);
		bf = new BufferedWriter(fileWriter);
		writeHeader();
		writeBody(document);
		bf.close();		
		
	}
	private void writeHeader() throws IOException {
		bf.write("/*Document   : sstylesheet2.css*/ \n \n");
	}
	private void writeBody(NodeList document) throws IOException {
		for (int k = 1; k<document.getLength();k+=2) {

			NodeList parent = document.item(k).getChildNodes();
			for (int j = 1; j<parent.getLength();j+=2) {
				String name = parent.item(j).getNodeName();
				bf.write(createName(name));
				
				NodeList region = parent.item(j).getChildNodes();
				for (int i = 1;i<region.getLength();i+=2) {
					Node n = region.item(i);
					bf.write("-" +n.getNodeName() + ":" + n.getTextContent()+";");
					bf.write("\n");
				}
				
				bf.write("}\n\n");
			}
		}
	}

	private String createName(String name) {
		if (name.contains(".")) {
			String[] n = name.split("\\.");
			return "."+String.join(" .",n)+ "{ \n";
		}
		return "."+ name+ "{ \n";
	}
	
	public void setColor(String name, int index, String color) throws IOException {
		NodeList nList =getNodeList(name).item(0).getChildNodes();
		Node node = nList.item(index);
		node.setTextContent(color);
		GenericWriter writer = new GenericWriter(xmlPath,getElement());
		writer.write();
		readFromFile();
	}
}
