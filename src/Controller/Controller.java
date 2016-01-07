package Controller;

import Model.*;
import Parsing.JAXBParser;
import View.*;


import java.io.File;
import java.util.*;

/**
 * Created by User on 07.12.2015.
 */
public class Controller{
    JAXBParser<StudentContainer> StudParser = new JAXBParser();
    JAXBParser<GroupContainer> GroupParser = new JAXBParser();
    List<Student> StudentList;
    List<Group> GroupList;
    StudentContainer listOfStudents;
    GroupContainer listOfGroups;

    public void reading() throws Exception{

        listOfStudents = StudParser.getObject(new File("students.xml"), StudentContainer.class);
        listOfGroups = GroupParser.getObject(new File("groups.xml"), GroupContainer.class);
        StudentList = listOfStudents.getStudents();
        GroupList = listOfGroups.getGroups();

    }

    public void start() throws Exception{

        View view = new View();
        view.mainView();
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        while ((i > 8) || (i < 1)) {
            view.showError();
            start();
        }
        menu(i, view);

    }

    public void menu(int i, View view) throws Exception{

        switch (i) {

            case 1: {
                //Показать студентов
                view.showStudents(StudentList);
                start();
                break;
            }

            case 2: {
                //Добавить студента
                view.addStudent();
                Scanner in = new Scanner(System.in);
                String name = in.nextLine();
                String group1 = in.nextLine();
                int signal = 0;
                Student s = new Student(name, group1);
                Iterator<Group> iterator = GroupList.iterator();
                while (iterator.hasNext()) {
                    String gr = iterator.next().getName();
                    if (s.getGroup().equals(gr)) {
                        signal++;
                    }
                }
                if (signal > 0) {
                    int id = StudentList.get(StudentList.size() - 1).getId() + 1;
                    s.setId(id);
                    listOfStudents.add(new Student(id, s.getFIO(), s.getGroup()));
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
                Iterator<Student> iterator = StudentList.iterator();

                while (iterator.hasNext()) {
                    String s = iterator.next().getFIO();
                    if (s.equals(name)) {
                        signal++;
                    }
                }
                if (signal > 0) {
                    listOfStudents.delete(name);
                    view.complDeleteStudent(name);
                } else {
                    view.errDeleteStudent();
                }
                start();
                break;
            }

            case 4: {
                //Показать группы
                view.showGroups(GroupList);
                start();
                break;
            }
            case 5: {
                //Добавить группу
                view.addGroup();
                Scanner in = new Scanner(System.in);
                String name = in.nextLine();
                int id = GroupList.get(GroupList.size() - 1).getId() + 1;
                listOfGroups.add(new Group(id, name));
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
                Iterator<Student> iterator = StudentList.iterator();

                while (iterator.hasNext()) {
                    String s = iterator.next().getGroup();
                    if (s.equals(name)) {
                        signal++;
                    }
                }
                if (signal > 0) {
                    view.errDeleteGroup();
                } else {
                    listOfGroups.delete(name);
                    view.complDeleteGroup(name);
                }

                start();
                break;
            }
            case 7: {
                MaskFinder maskFinder = new MaskFinder();
                view.mask();
                Scanner in = new Scanner(System.in);
                String s = in.nextLine();

                Iterator<Student> iterator = StudentList.iterator();
                while (iterator.hasNext()) {
                    String fio = iterator.next().getFIO();
                    if (maskFinder.find(maskFinder.convert(s), fio)) {
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

                    StudParser.saveObject(new File( "students.xml" ), listOfStudents);
                    GroupParser.saveObject(new File( "groups.xml" ), listOfGroups);
                    view.saveChangesAndExit();

                } else if (otv.equals("n")) view.complExit();
                else view.showError();
                break;
            }
        }
    }
}