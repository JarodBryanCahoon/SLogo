package frontend.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.xml.internal.txw2.Document;

import exceptions.ErrorMessage;
import exceptions.XMLException;

public class ColorReader extends XMLReader {
	private final String CSSPATH = System.getProperty("user.dir")+"/src/resources/style/";
	private final String FILENAME = "stylesheet2.css";
	File file;
	FileWriter fileWriter;
	BufferedWriter bf;
	NodeList document;
	
	public ColorReader(String path) throws IOException {
		super(path);

	}

	@Override
	protected void readFromFile() throws IOException{
		file = new File(CSSPATH,FILENAME);
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
	
	public void setColor(String name, int index, String color) {
		NodeList nList =getNodeList(name).item(0).getChildNodes();
		Node node = nList.item(index);
		node.setTextContent(color);
		System.out.println(node.getNodeName());
		System.out.println(node.getTextContent());
		GenericWriter writer = new GenericWriter(CSSPATH+FILENAME,getElement());
		
	}
	

	
}
