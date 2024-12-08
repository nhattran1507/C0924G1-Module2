package casestudy2.service;

import java.util.Map;

public interface IService<E> {
    void add(E e);
    void update(E e);
    void remove(String id);
    E findById(String id);
    Map<String,E> getAll();
}
