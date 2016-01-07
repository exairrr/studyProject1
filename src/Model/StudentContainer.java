package Model;

import Model.Student;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@XmlRootElement( name = "STUDENTS" )
public class StudentContainer {
    List<Student> students;

    @XmlElement(name = "STUDENT")
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void add(Student student) {
        if (this.students == null) {
            this.students = new ArrayList<Student>();
        }
        this.students.add(student);
    }
    public void delete(String name) {
        Iterator<Student> iterator = this.students.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next().getFIO();
            if (s.equals(name)) {
                iterator.remove();
            }
        }
    }
}