package frontend.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import exceptions.XMLException;

public class ColorReader extends XMLReader {
	File file;
	FileWriter fileWriter;
	BufferedWriter bf;
	private static final String CSSPATH = "/src/resources/style/";
	
	public ColorReader(String path) throws IOException {
		super(path);

	}

	@Override
	protected void readFromFile() throws IOException{
		file = new File(System.getProperty("user.dir") +CSSPATH,"stylesheet2.css");
		System.out.println(System.getProperty("user.dir"));
		System.out.println(file);
		NodeList document = getElement().getChildNodes();
		fileWriter = new FileWriter(file);
		bf = new BufferedWriter(fileWriter);
		writeHeader();
		
		writeBody(document);
		bf.close();
		
		
	}

	private void writeBody(NodeList document) throws IOException {
		for (int k = 1; k<document.getLength();k+=2) {
			bf.write("." + document.item(k).getNodeName());
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

	private void writeHeader() throws IOException {
		bf.write("/*Document   : sstylesheet2.css*/ \n \n");
	}

}
