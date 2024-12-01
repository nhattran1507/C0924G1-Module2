package Casestudy.Repository;

import Casestudy.Model.KhachHang;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {
    private List<KhachHang> khachHangs = new ArrayList<>();

    public void save(KhachHang khachHang) {
        khachHangs.add(khachHang);
    }

    public List<KhachHang> findAll() {
        return khachHangs;
    }
}
