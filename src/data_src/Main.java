package data_src;

import data_src.res.*;

import java.util.List;


public class Main {

    //------------------------MAIN----------------------------------------
    public static void main (String[] args){

        path pth = new path(); // класс содержащий пути до файлов для остальных классов

        jurnal j = new jurnal(); // для отчиски журанала .clear(), для записи .print( String )
        j.clear();


        // объекты сотрудника и совместителя
        empFull empf = new empFull(); // класс eployee , который получает информацию из csvReader и дополняет ее для сотрудников
        empPart empp = new empPart(); // класс eployee , который получает информацию из csvReader и дополняет ее для совместителей



        empList emp_list = new empList(); // коллекция для передачи в список на запись в файл
        empList empl = new empList(); // Новый список для записи сотрудников из файла

        csvReader csv = new csvReader();// класс для записи данных из csv в список
        List<List<String>> csv_data = csv.readDataWith(pth.get_csv(),";");


        // Инициализация объектов сотрудника и совместителя
        empf.init(csv_data);
        empp.init(csv_data);


        // добавление объектов в список сотрудников
        emp_list.push(empf);
        emp_list.push(empp);



        //Запись списка Cотрудников и Совместителей в файл
        emp_list.writeFile(pth.get_emp_list());

        // Чтение списка сотрудников из файла
        empl.readFile(pth.get_emp_list());
        empl.showEmp();


    }




}
