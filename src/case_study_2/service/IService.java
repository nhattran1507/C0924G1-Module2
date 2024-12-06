package case_study_2.service;

import java.util.List;

public interface IService<T, K> {
    void add(T item);            // Thêm một đối tượng
    List<T> findById(K id);      // Tìm danh sách đối tượng theo ID
    void update(K id1, K id2, int preferenceLevel); // Cập nhật một đối tượng với 2 tham số ID
    List<T> getAll();            // Lấy danh sách tất cả các đối tượng
}
