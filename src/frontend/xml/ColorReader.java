package frontend.xml;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import exceptions.XMLException;

public class ColorReader extends XMLReader {
	FileWriter file;
	BufferedWriter bf;
	private static final String CSSPATH = "/resources/style/stylesheet.css";
	
	public ColorReader(String path) throws IOException {
		super(path);

	}

	@Override
	protected void readFromFile() throws IOException{
		NodeList nList = getElement().getChildNodes();
		file = new FileWriter("stylesheet2.css");
		bf = new BufferedWriter(file);
		writeHeader();
		
		writeRoot(nList);
		
		
		
	}

	private void writeRoot(NodeList nList) {
		NodeList root = nList.item(1).getChildNodes();
		for (int i = 1; i<root.getLength();i+=2) {
			System.out.println(root.item(i).getTextContent());
		}
	}

	private void writeHeader() throws IOException {
		bf.write(".root{\n");
		bf.write("/* Document: sstylesheet2.css");
		bf.write("}");
	}

}
