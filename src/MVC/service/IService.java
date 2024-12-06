package mvc.service;

import mvc.entity.Student;

import java.util.List;

public interface IService<E> {

    List<E> getAll();

    void save(E s);

    E findById(int id);

    void remove(int id);

    List<E> findByNam(String name);
}
