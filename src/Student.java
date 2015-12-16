/**
 * Created by User on 07.12.2015.
 */
public class Student {
    private String FIO;
    private String group;
    private int id;

    Student(){

    }
    Student(int id, String fn, String gr){
        this.id=id;
        this.FIO = fn;
        this.group = gr;
    }

    Student( String fn, String gr){
        this.FIO = fn;
        this.group = gr;
    }

    @Override
    public String toString(){
        return "Id: "+id+", FIO: "+FIO+", group: "+group;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }
    public String getFIO() {
        return FIO;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public String getGroup() {
        return group;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

}
