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
import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.eclipse.swt.widgets.Display;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import de.thm.mdde.commonui.exception.handler.ErrorHandler;
import de.thm.model.JPAProvider;
import de.thm.model.ReverseDatabaseModel;

public class XMLFileReader {

	/**
	 * Validates the xml file
	 * 
	 * @param xml
	 * @param xsd
	 * @return
	 */
	public static boolean validateAgainstXSD(InputStream xml, InputStream xsd) {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new StreamSource(xsd));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(xml));
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * Validates an xml file
	 * 
	 * @param source
	 * @return
	 */
	public static boolean validateAgainstConfigurationSchema(StreamSource source) {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory
					.newSchema(new StreamSource(XMLFileReader.class.getResourceAsStream("/de/thm/schema/configuration.xsd")));
			
			// Schema schema = factory.newSchema( new
			// StreamSource(ClassLoader.getSystemResourceAsStream("/configuration.xsd")));
			// Schema schema = factory.newSchema(new StreamSource(new
			// File("/ConfigFileCreator/schema/configuration.xsd")));
			Validator validator = schema.newValidator();
			validator.validate(source);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			ErrorHandler.openErrorDialogWithStatus("de.thm.mdde.configuration",
					"An error occured while loading the resource!", Display.getCurrent().getActiveShell(), "Error", ex);
			return false;
		}

	}

	public static ReverseDatabaseModel loadConfiguration(File xml) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xml);

		ReverseDatabaseModel reverseDatabaseModel = new ReverseDatabaseModel();

		// optional, but recommended
		// read this -
		// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();

		// System.out.println("Root element :" +
		// doc.getDocumentElement().getNodeName());
		Element root = doc.getDocumentElement();

		reverseDatabaseModel.setHost(root.getElementsByTagName("host").item(0).getTextContent());
		reverseDatabaseModel.setPort(root.getElementsByTagName("port").item(0).getTextContent());
		reverseDatabaseModel.setUser(root.getElementsByTagName("username").item(0).getTextContent());
		reverseDatabaseModel.setSchema(root.getElementsByTagName("schema").item(0).getTextContent());
		// System.out.println(root.getElementsByTagName("schema").item(0).getTextContent());

		NodeList nl = root.getElementsByTagName("single_table_inheritance");
		if (nl.getLength() > 0) {
			System.out.println("single_table_inheritance");
		}
		
		nl = root.getElementsByTagName("orm_tool");
		if (nl.getLength() > 0) {
			Element orm = (Element) nl.item(0);
			JPAProvider jpaProvider = JPAProvider.getProvider(orm.getTextContent(), orm.getAttributeNode("version").getTextContent());
			reverseDatabaseModel.setJpaProvider(jpaProvider);
		}

		return reverseDatabaseModel;

	}

}
