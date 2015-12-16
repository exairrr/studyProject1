import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by User on 07.12.2015.
 */
public class ReadXMLFileDOMGroup{

    public ArrayList parsing(String filename){

        ArrayList<Group> list = new ArrayList<Group>();
        int id;

        try {

            // Строим объектную модель исходного XML файла
            final File xmlFile = new File(System.getProperty("user.dir") + File.separator + filename);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);

            // Выполнять нормализацию не обязательно, но рекомендуется
            doc.getDocumentElement().normalize();

            // Получаем все узлы с именем "group"
            NodeList nodeList = doc.getElementsByTagName("group");

            //Проводим перебор всех студентов
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                // Записываем информацию о каждом студенете в ArrayList
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    Element element = (Element) node;
                    /*
                    System.out.println("ID Cстудента: " + element.getAttribute("id"));
                    System.out.println("ФИО: " + element.getElementsByTagName("fio").item(0).getTextContent());
                    System.out.println("Группа: " + element.getElementsByTagName("group").item(0).getTextContent());
                    */
                    id=Integer.parseInt(element.getAttribute("id"));
                    list.add(new Group(id,
                            element.getElementsByTagName("name").item(0).getTextContent()));
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(ReadXMLFileDOMStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  list;
    }

}
