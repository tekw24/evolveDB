/*
 * EvolveDB - Model Driven Schema Evolution
 * Copyright Technische Hochschule Mittelhessen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.thm.readConfigurationFile;

import java.io.File;

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
