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

        ArrayList<Student> list = new ArrayList<Student>();

        try {

            // Строим объектную модель исходного XML файла
            final File xmlFile = new File(System.getProperty("user.dir") + File.separator + filename);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);

            // Выполнять нормализацию не обязательно, но рекомендуется
            doc.getDocumentElement().normalize();

            // Получаем все узлы с именем "student"
            NodeList nodeList = doc.getElementsByTagName("student");

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
                    list.add(new Student(element.getAttribute("id"),
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
