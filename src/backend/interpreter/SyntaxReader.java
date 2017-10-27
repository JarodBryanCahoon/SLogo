package backend.interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import exceptions.ErrorMessage;

public class SyntaxReader {
	private Properties myProperties;
	private static final String SYNTAX_PATH = "src/resources/languages/Syntax.properties";

	public SyntaxReader() {
		myProperties = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(SYNTAX_PATH);
			myProperties.load(input);
		} catch (IOException ex) {
			ErrorMessage eMessage = new ErrorMessage("Could Not Load Properties File");
			eMessage.show();
		}
	}
	
	protected Properties getProperties() {
		return myProperties;
	}
}
