package Model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "GROUP" )
public class Group {
    private String name;
    private int id;
    Group(){}
   public Group(int id, String name){
        this.id=id;
        this.name = name;
    }
    @Override
    public String toString(){
        return "Id группы: "+id+", name: "+name;
    }

    @XmlElement(name = "GROUP_NAME")
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlAttribute(name = "ID")
    public int getId() {
        return id;
    }

}
