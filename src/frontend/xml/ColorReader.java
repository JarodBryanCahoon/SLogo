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

public class ColorReader extends XMLReader {
	private final String CSSPATH = System.getProperty("user.dir")+"/src/resources/style/";
	private final String CSSFILENAME = "stylesheet2.css";
	private String xmlPath;
	
	private File file;
	private FileWriter fileWriter;
	private BufferedWriter bf;
	private NodeList document;
	
	private ViewModule myViewModule;
	
	public ColorReader(String path, ViewModule view) throws IOException {
		super(path);
		this.xmlPath = path;
		myViewModule = view;
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
		System.out.println("dones");
		
		
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
		color = "#" +color.substring(2);
		node.setTextContent(color);
		GenericWriter writer = new GenericWriter(xmlPath,getElement());
		writer.write();
		readFromFile();
		refreshScene();
}

	private void refreshScene() {
		Scene scene =myViewModule.getParent().getScene();
		scene.getStylesheets().clear();
		scene.getStylesheets().add("/resources/style/" + "stylesheet2.css");
		System.out.println("This works");
	}
}
