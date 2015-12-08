import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by User on 07.12.2015.
 */
public class MainClass {
    public static void main(String[] args) {
        //лист студентов
        ReadXMLFileDOMStudent parser = new ReadXMLFileDOMStudent();
        ArrayList student = parser.parsing("students.xml");
        //лист групп(пока не создал)
        ReadXMLFileDOMStudent parser1 = new ReadXMLFileDOMStudent();
        ArrayList group = parser1.parsing("group.xml");
        //создаем контроллер и передаем туда коллекции
        Controller controller = new Controller(student,group);
        controller.start();

    }
}