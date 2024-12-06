package case_study_2.service;

import java.util.List;

public interface IService<T, K> {
    void add(T item);
    List<T> findById(K id);
    void update(K id1, K id2, int preferenceLevel);
    List<T> getAll();
}
