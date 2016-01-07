package View; /**
 * Created by User on 07.12.2015.
 */

import Model.*;
import java.util.Collection;
import java.util.Iterator;

public class View {

    public void mainView(){
        System.out.println("Введите необходимое Вам действие");
        System.out.println("1 - Посмотреть студентов");
        System.out.println("2 - Добавить студента");
        System.out.println("3 - Удалить студента");
        System.out.println("4 - Посмотреть группы ");
        System.out.println("5 - Добавить группу");
        System.out.println("6 - Удалить группу");
        System.out.println("7 - Поиск по маске");
        System.out.println("8 - Выход");
    }

    public void showError(){
        System.out.println("Вы ввели некорректное значение, пробуйте еще");
    }

    public void showStudents(Collection c){
        for (Iterator <Student> i = c.iterator(); i.hasNext();) {
            System.out.println(i.next());
        }
    }

    public void addStudent(){
        System.out.println("Введите ФИО студента");
        System.out.println("Введите группу студента");
    }

    public void complAddStudent(String s){
        System.out.println("Студент " + s + " добавлен!");
    }

    public void errAddStudent(){
        System.out.println("Невозможно добавить студента, т.к. группы добавления не существует");
    }

    public void deleteStudent(){
        System.out.println("Введите ФИО студента, которого хотите удалить");
    }

    public void errDeleteStudent(){
        System.out.println("Такого студента не существует");
    }

    public void complDeleteStudent(String s){
        System.out.println("Студент " + s + " удален!");

    }

    public void showGroups(Collection c){
        for (Iterator <Group > i = c.iterator(); i.hasNext();) {
            System.out.println(i.next());
        }
    }

    public void addGroup(){
        System.out.println("Введите название группы");
    }

    public void complAddGroup(String s){
        System.out.println("Группа " + s + " добавлена!");
    }

    public void deleteGroup(){
        System.out.println("Введите название группы, которую хотите удалить");
    }

    public void errDeleteGroup(){
        System.out.println("В данной группе присутствуют студенты, сначала удалите их");
    }

    public void complDeleteGroup(String s){
        System.out.println("Группа " + s + " удалена!");

    }

    public void exit(){
        System.out.println("Вы хотите сохранить изменения? 'y'/'n'");
    }

    public void complExit(){
        System.out.println("Данные не будут сохранены. Работа окончена.");
    }

    public void saveChangesAndExit(){
        System.out.println("Данные сохранены. Работа окончена.");
    }

    public void mask(){
        System.out.println("Введите маску по следующим правилам: символ '*' - неограниченное кол-во символов");
        System.out.println("Cимвол '*' - неограниченное кол-во символов");
        System.out.println("Cимвол '?' - один символ");
    }

    public void showMask(String s){
        System.out.println("Студент " + s);
    }

}
