package frontend.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
		NodeList document = getElement().getChildNodes();
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



}
