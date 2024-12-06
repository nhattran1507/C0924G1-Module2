package mvc.service.impl;

import mvc.entity.Student;
import mvc.repository.StudentRepository;
import mvc.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private StudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {

        return studentRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        studentRepository.remove(id);
    }

    @Override
    public List<Student> findByNam(String name) {
        return List.of();
    }
}
