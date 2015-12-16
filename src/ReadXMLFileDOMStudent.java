import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXMLFileDOMStudent{

    public ArrayList parsing(String filename){

        ArrayList <Student> list = new ArrayList <Student> ();
        int id;
        try {
            // Строим объектную модель исходного XML файла
            final File xmlFile = new File(System.getProperty("user.dir") + File.separator + filename);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);

            // Выполнять нормализацию не обязательно, но рекомендуется
            doc.getDocumentElement().normalize();

            // Получаем все узлы с именем "staff"
            NodeList nodeList = doc.getElementsByTagName("student");

            for (int i = 0; i < nodeList.getLength(); i++) {
                // Выводим информацию по каждому из найденных элементов
                Node node = nodeList.item(i);

                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    Element element = (Element) node;

                    id=Integer.parseInt(element.getAttribute("id"));
                    list.add(new Student(id,
                            element.getElementsByTagName("fio").item(0).getTextContent(),
                            element.getElementsByTagName("group").item(0).getTextContent()));
                }
}
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(ReadXMLFileDOMStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  list;
    }
}
