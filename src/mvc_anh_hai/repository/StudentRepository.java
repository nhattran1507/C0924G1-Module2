package mvc_anh_hai.repository;

import mvc.entity.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentRepository {

    public List<Student> getAll() {
        File file = new File("src/mvc/data/data.csv");
        List<Student> students = new LinkedList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line = "";
            Student student = null;
            while ((line = bufferedReader.readLine())!= null) {
                String[] data = line.split(",");
                student = new Student(Integer.parseInt(data[0]), data[1], data[2], Float.parseFloat(data[3]));
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return students;
    }

    public void save(Student student) {
        List<Student> students = new ArrayList<>();
        students.add(student);
        writeFile(students, true);
    }

    public Student findById(int id) {
        List<Student> students = getAll();
        for (Student student: students) {
            if (student.getCode() == id) {
                return student;
            }
        }
        return null;
    }

    public void remove(int id) {
        List<Student> students = getAll();
        for (Student student: students) {
            if (student.getCode() == id) {
                students.remove(student);
                break;
            }
        }
        writeFile(students, false);
    }

    public static void writeFile(List<Student> students, boolean append) {
        File file = new File("src/mvc/data/data.csv");
        try(FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for(Student student: students) {
                bufferedWriter.write(student.toString());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu");
        }
    }
}
