import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by User on 12.12.2015.
 */
public class WriteXMLFileDOMGroup {
    private ArrayList<Group> group;

    WriteXMLFileDOMGroup(ArrayList groups) {
        this.group = groups;
    }

    public void saveGr() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("groups");
            doc.appendChild(rootElement);

            for (int i = 0; i < group.size(); i++) {
                Element gr = doc.createElement("group");
                rootElement.appendChild(gr);
                gr.setAttribute("id", Integer.toString(group.get(i).getId()));
                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(group.get(i).getName()));
                gr.appendChild(name);
            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("groups.xml"));

            transformer.transform(source, result);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
