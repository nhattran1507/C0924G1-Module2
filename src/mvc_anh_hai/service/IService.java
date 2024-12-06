package mvc_anh_hai.service;

import mvc_anh_hai.entity.Student;

import java.util.List;

public interface IService<E> {

    List<E> getAll();

    void save(E s);

    E findById(int id);

    void remove(int id);

    List<E> findByNam(String name);
}
