/**
 * Created by User on 07.12.2015.
 */
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class View {

    public int mainView(){
        System.out.println("Введите необходимое Вам действие");
        System.out.println("1 - Посмотреть студентов");
        System.out.println("2 - Добавить студента");
        System.out.println("3 - Удалить студента");
        System.out.println("4 - Посмотреть группы ");
        System.out.println("5 - Добавить группу");
        System.out.println("6 - Удалить группу");
        System.out.println("7 - Поиск по маске");

        Scanner in = new Scanner(System.in);
        int rez = in.nextInt();
        return rez;
    }

    public void showError(){
        System.out.println("Вы ввели некорректное значение, пробуйте еще");
    }

    public void showStudents(Collection c){
        for (Iterator <Student > i = c.iterator(); i.hasNext();) {
            //В классе Student для корректного вывода был переопределен метод toString
            System.out.println(i.next());
        }
    }

    public Student addStudent(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите ФИО студента");
        String name = in.nextLine();
        System.out.println("Введите группу студента");
        String group = in.nextLine();
        String id="0006";
        return new Student(id,name,group);
    }

    public String deleteStudent(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите ФИО студента, которого хотите удалить");
        String name = in.nextLine();
        return name;
    }

    public void errDeleteStudent(){
        System.out.println("Такого студента не существует");

    }

    public void complDeleteStudent(String s){
        System.out.println("Студент " + s + " удален!");

    }
}
