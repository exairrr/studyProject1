import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by User on 07.12.2015.
 */
public class Controller {
    private ArrayList student;
    private ArrayList group;

    Controller(ArrayList student, ArrayList group) {
        this.student = student;
        this.group = group;
    }

    public void start() {
        View view = new View();
        int i = view.mainView();
        while ((i > 7) || (i < 1)) {
            view.showError();
            start();
        }
        menu(i,view);
    }

    public void menu(int i,View view) {

        switch (i) {
            case 1: {
                view.showStudents(student);
                start();
                break;
            }
            case 2: {
                Student s = view.addStudent();
                addStudent(s.getId(), s.getFIO(), s.getGroup());

                start();
                break;
            }
            case 3: {
                int signal=0;
                String delstud = view.deleteStudent();
                Iterator<Student> iterator = student.iterator();

                while (iterator.hasNext()) {
                    String s = iterator.next().getFIO();
                    if (s.equals(delstud)) {
                        iterator.remove();
                        signal++;
                    }
                }
                if (signal>0){
                    view.errDeleteStudent();
                }
                else{
                    view.complDeleteStudent(delstud);
                }
                start();
                break;
            }

            case 4:
            case 5:
            case 6:
        }
    }



    public void addStudent(String id,String fio, String gr){
        student.add(new Student(id, fio, gr));
    }
}
