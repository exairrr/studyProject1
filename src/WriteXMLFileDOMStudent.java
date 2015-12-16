/**
 * Created by User on 12.12.2015.
 */
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXMLFileDOMStudent {

    private ArrayList <Student> student;

    WriteXMLFileDOMStudent(ArrayList student) {
        this.student = student;
    }

    public void saveSt() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("students");
            doc.appendChild(rootElement);

            for (int i = 0; i < student.size(); i++) {
                Element student1 = doc.createElement("student");
                rootElement.appendChild(student1);
                student1.setAttribute("id", Integer.toString(student.get(i).getId()));
                Element fio = doc.createElement("fio");
                fio.appendChild(doc.createTextNode(student.get(i).getFIO()));
                student1.appendChild(fio);
                Element group = doc.createElement("group");
                group.appendChild(doc.createTextNode(student.get(i).getGroup()));
                student1.appendChild(group);
            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("students.xml"));

            transformer.transform(source, result);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}

