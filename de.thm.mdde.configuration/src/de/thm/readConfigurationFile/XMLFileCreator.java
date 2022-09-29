package de.thm.readConfigurationFile;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



import de.thm.model.JPAProvider;
import de.thm.model.ReverseDatabaseModel;

public class XMLFileCreator {

	public static boolean saveConfigurationFile(ReverseDatabaseModel model, String path) {

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			// root
			Element rootElement = doc.createElement("configuration");
			rootElement.setAttribute("xmlns", "http://www.thm.de/configuration");
			rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
			rootElement.setAttribute("xsi:schemaLocation",
					"http://www.thm.de/configuration http://www.thm.de/configuration ");

			// host
			Element host = doc.createElement("host");
			host.setTextContent(model.getHost());
			rootElement.appendChild(host);

			// port
			Element port = doc.createElement("port");
			port.setTextContent(model.getPort());
			rootElement.appendChild(port);

			// user
			Element user = doc.createElement("username");
			user.setTextContent(model.getUser());
			rootElement.appendChild(user);

			String schema = model.getSchema();
			if (schema != null && !schema.equals("")) {
				// user
				Element schemaElement = doc.createElement("schema");
				schemaElement.setTextContent(schema);
				rootElement.appendChild(schemaElement);

			}

			// JPA Provider
			JPAProvider jpaProvider = model.getJpaProvider();

			if (jpaProvider != null) {
				Element ormTool = doc.createElement("orm_tool");
				ormTool.setTextContent(jpaProvider.getName());
				Attr version = doc.createAttribute("version");
				version.setTextContent(jpaProvider.getVersion());
				ormTool.setAttributeNode(version);
				rootElement.appendChild(ormTool);

			}

			doc.appendChild(rootElement);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			StreamResult result = new StreamResult(new File(path));
			transformer.transform(source, result);
			System.out.println("File saved!");

			return true;
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
		return false;
	}

//	private static void createDefault(ReverseDatabaseModel model, String path) {
//		try {
//            
//            // instance.
//
//            final Document doc = loadXsdDocument("");
//
//            //Find the docs root element and use it to find the targetNamespace
//            final Element rootElem = doc.getDocumentElement();
//            String targetNamespace = null;
//            if (rootElem != null && rootElem.getNodeName().equals("xs:schema")) 
//                       {
//                targetNamespace = rootElem.getAttribute("targetNamespace");
//            }
//
//
//            //Parse the file into an XSModel object
//            org.apache.xerces.xs.XSModel xsModel = new XSParser().parse(filename);
//
//            //Define defaults for the XML generation
//            XSInstance instance = new XSInstance();
//            instance.minimumElementsGenerated = 1;
//            instance.maximumElementsGenerated = 1;
//            instance.generateDefaultAttributes = true;
//            instance.generateOptionalAttributes = true;
//            instance.maximumRecursionDepth = 0;
//            instance.generateAllChoices = true;
//            instance.showContentModel = true;
//            instance.generateOptionalElements = true;
//
//            //Build the sample xml doc
//            //Replace first param to XMLDoc with a file input stream to write to file
//            QName rootElement = new QName(targetNamespace, "out");
//            XMLDocument sampleXml = new XMLDocument(new StreamResult(System.out), true, 4, null);
//            instance.generate(xsModel, rootElement, sampleXml);
//        } catch (TransformerConfigurationException e) 
//                {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//	}
//	

	private static Document loadXsdDocument(String inputName) {
		final String filename = inputName;

		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		factory.setIgnoringElementContentWhitespace(true);
		factory.setIgnoringComments(true);
		Document doc = null;

		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(XMLFileReader.class.getResourceAsStream("/de/thm/schema/configuration.xsd"));
		} catch (final Exception e) {
			e.printStackTrace();
			// throw new ContentLoadException(msg);
		}

		return doc;
	}
}
