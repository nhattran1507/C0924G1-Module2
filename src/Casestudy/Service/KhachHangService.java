package Casestudy.Service;

import Casestudy.Model.KhachHang;
import Casestudy.Repository.KhachHangRepository;

public class KhachHangService {
    private KhachHangRepository repository = new KhachHangRepository();

    public void themKhanhHang(KhachHang khachHang) {
        repository.save(khachHang);
    }

    public void hienThiKhachHang() {
        repository.findAll().forEach(kh ->
                System.out.println("ID: " + kh.getId() + ", Tên: " + kh.getTen()));
    }
}
