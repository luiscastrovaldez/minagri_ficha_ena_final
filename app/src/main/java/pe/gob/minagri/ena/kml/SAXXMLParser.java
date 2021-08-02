package pe.gob.minagri.ena.kml;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXXMLParser {
	public static List<ParsingStructure> parse(InputStream is) {
		List<ParsingStructure> parsingStru = null;
		try {
			// create a XMLReader from SAXParser

			SAXParserFactory saxParserFactory= SAXParserFactory.newInstance();
			saxParserFactory.setNamespaceAware(Boolean.TRUE);
			SAXParser saxParser = saxParserFactory.newSAXParser();

			XMLReader xmlReader = saxParser.getXMLReader();

			// create a SAXXMLHandler
			SAXXMLHandler saxHandler = new SAXXMLHandler();
			// store handler in XMLReader

			xmlReader.setContentHandler(saxHandler);
			// the process starts
			xmlReader.parse(new InputSource(is));
			// get the `get list`
			parsingStru = saxHandler.getParsingvalues();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return parsingStru;
	}
}
