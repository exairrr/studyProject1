package Model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "STUDENT" )
public class Student {
    private String FIO;
    private String group;
    private int id;

    Student(){

    }
    public Student(int id, String fn, String gr){
        this.id=id;
        this.FIO = fn;
        this.group = gr;
    }
    public Student( String fn, String gr){
        this.FIO = fn;
        this.group = gr;
    }

    @Override
    public String toString(){
        return "STUDENT {Id: "+id+", NAME: "+FIO+", GROUP: "+group+" }";
    }

    @XmlAttribute(name = "ID")
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    @XmlElement(name = "STUDENT_NAME")
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }
    public String getFIO() {
        return FIO;
    }

    @XmlElement(name = "GROUP")
    public void setGroup(String group) {
        this.group = group;
    }
    public String getGroup() {
        return group;
    }


}
