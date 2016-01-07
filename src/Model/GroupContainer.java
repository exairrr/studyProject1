package Model;

import Model.Group;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@XmlRootElement( name = "GROUPS" )
public class GroupContainer {

    List<Group> groups;

    @XmlElement(name = "GROUP")
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void add(Group group) {
        if (this.groups == null) {
            this.groups = new ArrayList<Group>();
        }
        this.groups.add(group);
    }

    public void delete(String name) {
        Iterator<Group> iterator = this.groups.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next().getName();
            if (s.equals(name)) {
                iterator.remove();
            }
        }
    }
}
