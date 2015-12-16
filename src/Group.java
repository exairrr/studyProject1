/**
 * Created by User on 07.12.2015.
 */
public class Group {

    private String name;
    private int id;

    Group(){

    }

    Group(int id, String name){
        this.id=id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "Id группы: "+id+", название: "+name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
