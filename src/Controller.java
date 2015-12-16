import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by User on 07.12.2015.
 */
public class Controller {

    private ArrayList <Student> student;
    private ArrayList <Group> group;

    Controller(ArrayList student, ArrayList group) {
        this.student = student;
        this.group = group;
    }

    public void start() {
        View view = new View();
        view.mainView();
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        while ((i > 8) || (i < 1)) {
            view.showError();
            start();
        }
        menu(i,view);
    }

    public void menu(int i,View view) {

        switch (i) {
            case 1: {
                //Показать студентов
                view.showStudents(student);
                start();
                break;
            }
            case 2: { //Добавить студента
                view.addStudent();
                Scanner in = new Scanner(System.in);
                String name = in.nextLine();
                String group1 = in.nextLine();
                int signal = 0;
                Student s = new Student(name, group1);
                Iterator<Group> iterator = group.iterator();
                while (iterator.hasNext()) {
                    String gr = iterator.next().getName();
                    if (s.getGroup().equals(gr)) {
                        signal++;
                    }
                }
                if (signal > 0) {
                    int id = student.get(student.size() - 1).getId() + 1;
                    s.setId(id);
                    addStudent(id, s.getFIO(), s.getGroup());
                    view.complAddStudent(name);
                } else {
                    view.errAddStudent();
                }
                start();
                break;
            }
            case 3: {
                //Удалить студента
                view.deleteStudent();
                Scanner in = new Scanner(System.in);
                String name = in.nextLine();

                int signal = 0;
                Iterator<Student> iterator = student.iterator();

                while (iterator.hasNext()) {
                    String s = iterator.next().getFIO();
                    if (s.equals(name)) {
                        iterator.remove();
                        signal++;
                    }
                }
                if (signal > 0) {
                    view.complDeleteStudent(name);
                } else {
                    view.errDeleteStudent();
                }
                start();
                break;
            }

            case 4: {
                //Показать группы
                view.showGroups(group);
                start();
                break;
            }
            case 5: {
                //Добавить группу
                view.addGroup();
                Scanner in = new Scanner(System.in);
                String name = in.nextLine();
                int id = group.get(group.size() - 1).getId() + 1;
                addGroup(id, name);
                view.complAddGroup(name);
                start();
                break;
            }
            case 6: {
                //Удалить группу
                view.deleteGroup();
                Scanner in = new Scanner(System.in);
                String name = in.nextLine();

                int signal = 0;
                Iterator<Student> iterator = student.iterator();

                while (iterator.hasNext()) {
                    String s = iterator.next().getGroup();
                    if (s.equals(name)) {
                        signal++;
                    }
                }
                if (signal > 0) {
                    view.errDeleteGroup();
                } else {
                    iterator.remove();
                    view.complDeleteGroup(name);
                }
                start();
                break;
            }
            case 7: {
                MaskFinder maskFinder= new MaskFinder();
                view.mask();
                Scanner in = new Scanner(System.in);
                String s = in.nextLine();

                Iterator <Student> iterator = student.iterator();
                while (iterator.hasNext()) {
                    String fio = iterator.next().getFIO();
                    if ( maskFinder.find(maskFinder.convert(s), fio)) {
                       view.showMask(fio);
                    }
                }
                start();
                break;
                //Поиск по маске
            }
            case 8: {
                //Выход
                view.exit();
                Scanner in = new Scanner(System.in);
                String otv = in.nextLine();
                if (otv.equals("y")) {
                    view.saveChangesAndExit();
                    WriteXMLFileDOMStudent file = new WriteXMLFileDOMStudent(student);
                    file.saveSt();
                    WriteXMLFileDOMGroup file1 = new WriteXMLFileDOMGroup(group);
                    file1.saveGr();
                }
                else if (otv.equals("n")) view.complExit();
                else view.showError();
                break;
            }
        }
    }

    public void addStudent(int id,String fio, String gr){
        student.add(new Student(id, fio, gr));
    }

    public void addGroup(int id, String name){group.add( new Group(id,name));}

}
