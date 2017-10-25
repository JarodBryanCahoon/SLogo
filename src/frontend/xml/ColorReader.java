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
		file = new FileWriter("stylesheet2.css");
		bf = new BufferedWriter(file);
		writeHeader();
		bf.write(".root{\n");
		Element root = getNode("Root");
		System.out.println(root.getTagName());
//		for (int i = 0; i < nList.getLength();i++) {
//			Node n = nList.item(i);
//			n.
//			System.out.println(n..getgetTextContent());
//		}
		
		
	}

	private void writeHeader() throws IOException {
		bf.write("/* Document: sstylesheet2.css");
	}

}
