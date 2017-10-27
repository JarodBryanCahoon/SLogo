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

import exceptions.XMLException;

public class ColorReader extends XMLReader {
	private final String CSSPATH = "/src/resources/style/";
	File file;
	FileWriter fileWriter;
	BufferedWriter bf;
	NodeList document;
	
	public ColorReader(String path) throws IOException {
		super(path);

	}

	@Override
	protected void readFromFile() throws IOException{
		file = new File(System.getProperty("user.dir") +CSSPATH,"stylesheet2.css");
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
			String name = document.item(k).getNodeName();
			bf.write("." + createName(name));
			bf.write("{ \n");
			NodeList region = document.item(k).getChildNodes();
			for (int i = 1;i<region.getLength();i+=2) {
				Node n = region.item(i);
				bf.write("-" +n.getNodeName() + ":" + n.getTextContent()+";");
				bf.write("\n");
			}
			bf.write("}\n");
		}
	}

	private String createName(String name) {
		if (name.contains(".")) {
			String[] n = name.split("\\.");
			return String.join(" .",n);
		}
		return name;
	}
	
	public List<String> getWords() {
		List<String> toReturn = new ArrayList<String>();
		for (int i = 3;i<12; i+=2) {
			toReturn.add(document.item(i).getNodeName());
		}
		return toReturn;
	}
	public List<String> getRender() {
		List<String> toReturn = new ArrayList<String>();
		NodeList render = document.item(17).getChildNodes();
		for (int i = 1; i<render.getLength(); i+=2) {
			toReturn.add(render.item(i).getNodeName());
		}
		return toReturn;
	}
	public void setColor(String name, String color) {
		try {
		getElement().getElementsByTagName(name).item(0).getChildNodes().item(1).setTextContent(color);
		}
		catch (Exception NullPointerException) {
		}
		getElement().getElementsByTagName("Variable").item(0).getChildNodes().item(1);
	}
	
}
