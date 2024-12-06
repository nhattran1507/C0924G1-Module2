package mvc_anh_hai.controller;

import mvc.entity.Student;
import mvc.service.IStudentService;
import mvc_anh_hai.service.impl.StudentService;

import java.util.List;

public class StudentController {
    private IStudentService studentService = new StudentService();
    public List<Student> display() {
        return studentService.getAll();
    }

    public void add(Student student) {
        studentService.save(student);
    }

    public Student findById(int id) {
        return studentService.findById(id);
    }

    public void remove(int id) {
        studentService.remove(id);
    }
}
