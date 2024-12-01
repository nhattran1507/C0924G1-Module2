package Casestudy.Controller;

import Casestudy.Model.KhachHang;
import Casestudy.Service.KhachHangService;

public class KhachHangController {
    private KhachHangService service = new KhachHangService();
    public void taoMoiKhachHang(int id, String ten, String soDienThoai) {
        KhachHang khachHang = new KhachHang(id, ten, soDienThoai);
        service.themKhanhHang(khachHang);
    }
    public void hienThiTatCaKhachHang() {
        service.hienThiKhachHang();
    }
}
