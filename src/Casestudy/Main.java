package Casestudy;

import Casestudy.Model.KhachHang;
import Casestudy.Model.NhaDat;
import Casestudy.Model.TrangThai;
import Casestudy.util.CSVUtils;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static final List<KhachHang> danhSachKhachHang = CSVUtils.docDanhSachKhachHang();
    private static final List<NhaDat> danhSachNhaDat = CSVUtils.docDanhSachNhaDat();
    private static final List<TrangThai> danhSachTrangThai = CSVUtils.docDanhSachTrangThai();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            try {
                printMenu();
                int choice = getUserChoice();
                running = handleMenuChoice(choice);
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        }
        System.out.println("Chương trình kết thúc.");
    }

    private static void printMenu() {
        System.out.println("\nHệ thống quản lý:");
        System.out.println("""
                1. Nhập khách hàng
                2. Hiển thị danh sách khách hàng
                3. Nhập nhà đất
                4. Hiển thị danh sách nhà đất
                5. Nhập tình trạng tương thích
                6. Hiển thị trạng thái khách hàng - nhà đất
                7. Xóa khách hàng
                8. Cập nhật thông tin khách hàng
                9. Xóa nhà đất
                10. Cập nhật thông tin nhà đất
                11. Cập nhật tình trạng khách hàng - nhà đất
                12. Lưu dữ liệu và thoát
                """);
    }

    private static int getUserChoice() {
        return nhapSoNguyenDuong("Lựa chọn của bạn: ");
    }

    private static boolean handleMenuChoice(int choice) {
        switch (choice) {
            case 1 -> themKhachHang();
            case 2 -> hienThiDanhSach(danhSachKhachHang, "Danh sách khách hàng:");
            case 3 -> themNhaDat();
            case 4 -> hienThiDanhSach(danhSachNhaDat, "Danh sách nhà đất:");
            case 5 -> nhapTrangThai();
            case 6 -> hienThiDanhSach(danhSachTrangThai, "Trạng thái khách hàng - nhà đất:");
            case 7 -> xoaKhachHang();
            case 8 -> capNhatKhachHang();
            case 9 -> xoaNhaDat();
            case 10 -> capNhatNhaDat();
            case 11 -> capNhatTrangThai();
            case 12 -> {
                luuDuLieu();
                return false; // Thoát chương trình
            }
            default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
        return true;
    }

    private static void nhapTrangThai() {
        int idKhachHang = nhapSoNguyenDuong("Nhập ID khách hàng: ");
        int idNhaDat = nhapSoNguyenDuong("Nhập ID nhà đất: ");
        int mucDoYeuThich = nhapSoTrongKhoang("Nhập mức độ yêu thích (1-5): ", 1, 5);

        TrangThai trangThai = new TrangThai(idKhachHang, idNhaDat, mucDoYeuThich);
        danhSachTrangThai.add(trangThai);
        System.out.println("Đã thêm trạng thái: " + trangThai);
    }

    private static void themNhaDat() {
        int idNhaDat = nhapSoNguyenDuong("Nhập ID nhà đất: ");
        String diaChi = nhapChuoiKhongRong("Nhập địa chỉ: ");
        long gia = nhapSoNguyenDuong("Nhập giá nhà đất: ");

        NhaDat existingNhaDat = danhSachNhaDat.stream()
                .filter(nha -> nha.getDiaChi().equalsIgnoreCase(diaChi))
                .findFirst()
                .orElse(null);

        if (existingNhaDat != null) {
            if (existingNhaDat.getGia() == gia) {
                System.out.println("Nhà đất đã tồn tại với địa chỉ và giá này. Không thể thêm mới.");
            } else {
                System.out.print("Nhà đất đã có địa chỉ này nhưng giá khác. Bạn có muốn cập nhật giá không? (y/n): ");
                if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
                    existingNhaDat.setGia(gia);
                    System.out.println("Giá nhà đất đã được cập nhật.");
                }
            }
        } else {
            danhSachNhaDat.add(new NhaDat(idNhaDat, diaChi, gia));
            System.out.println("Nhà đất đã được thêm.");
        }
    }


    private static void themKhachHang() {
        int idKhachHang = nhapSoNguyenDuong("Nhập ID khách hàng: ");
        String tenKhachHang = nhapChuoiKhongRong("Nhập tên khách hàng: ");
        String soDienThoai = nhapChuoiKhongRong("Nhập số điện thoại khách hàng: ");

        boolean exists = danhSachKhachHang.stream()
                .anyMatch(kh -> kh.getTen().equalsIgnoreCase(tenKhachHang) && kh.getSoDienThoai().equals(soDienThoai));

        if (exists) {
            System.out.println("Thông tin khách hàng đã tồn tại. Không thể thêm mới.");
        } else {
            danhSachKhachHang.add(new KhachHang(idKhachHang, tenKhachHang, soDienThoai));
            System.out.println("Khách hàng đã được thêm.");
        }
    }

    // Các phương thức nhập liệu tái sử dụng
    private static int nhapSoNguyenDuong(String thongBao) {
        while (true) {
            try {
                System.out.print(thongBao);
                int so = Integer.parseInt(scanner.nextLine());
                if (so > 0) {
                    return so;
                }
                System.out.println("Vui lòng nhập số nguyên dương.");
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập số nguyên.");
            }
        }
    }

    private static String nhapChuoiKhongRong(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Dữ liệu không được để trống. Vui lòng nhập lại.");
        }
    }

    private static int nhapSoTrongKhoang(String thongBao, int min, int max) {
        while (true) {
            try {
                System.out.print(thongBao);
                int so = Integer.parseInt(scanner.nextLine());
                if (so >= min && so <= max) {
                    return so;
                }
                System.out.println("Vui lòng nhập số trong khoảng " + min + " - " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập số nguyên.");
            }
        }
    }

    // Các phương thức chức năng chính
    private static void xoaKhachHang() {
        int id = nhapSoNguyenDuong("Nhập ID khách hàng cần xóa: ");
        if (danhSachKhachHang.removeIf(kh -> kh.getId() == id)) {
            System.out.println("Khách hàng đã được xóa.");
        } else {
            System.out.println("Không tìm thấy khách hàng với ID này.");
        }
    }

    private static void capNhatKhachHang() {
        int id = nhapSoNguyenDuong("Nhập ID khách hàng cần cập nhật: ");
        Optional<KhachHang> optionalKhachHang = danhSachKhachHang.stream().filter(kh -> kh.getId() == id).findFirst();
        if (optionalKhachHang.isPresent()) {
            KhachHang khachHang = optionalKhachHang.get();
            khachHang.setTen(nhapChuoiKhongRong("Nhập tên mới: "));
            khachHang.setSoDienThoai(nhapChuoiKhongRong("Nhập số điện thoại mới: "));
            System.out.println("Thông tin khách hàng đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy khách hàng với ID này.");
        }
    }

    private static void xoaNhaDat() {
        int id = nhapSoNguyenDuong("Nhập ID nhà đất cần xóa: ");
        if (danhSachNhaDat.removeIf(nd -> nd.getId() == id)) {
            System.out.println("Nhà đất đã được xóa.");
        } else {
            System.out.println("Không tìm thấy nhà đất với ID này.");
        }
    }

    private static void capNhatNhaDat() {
        int id = nhapSoNguyenDuong("Nhập ID nhà đất cần cập nhật: ");
        Optional<NhaDat> optionalNhaDat = danhSachNhaDat.stream().filter(nd -> nd.getId() == id).findFirst();
        if (optionalNhaDat.isPresent()) {
            NhaDat nhaDat = optionalNhaDat.get();
            nhaDat.setDiaChi(nhapChuoiKhongRong("Nhập địa chỉ mới: "));
            nhaDat.setGia(nhapSoNguyenDuong("Nhập giá mới: "));
            System.out.println("Thông tin nhà đất đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy nhà đất với ID này.");
        }
    }

    private static void capNhatTrangThai() {
        int idKhachHang = nhapSoNguyenDuong("Nhập ID khách hàng: ");
        int idNhaDat = nhapSoNguyenDuong("Nhập ID nhà đất: ");
        Optional<TrangThai> optionalTrangThai = danhSachTrangThai.stream()
                .filter(tt -> tt.getIdKhachHang() == idKhachHang && tt.getIdNhaDat() == idNhaDat)
                .findFirst();

        if (optionalTrangThai.isPresent()) {
            TrangThai trangThai = optionalTrangThai.get();
            trangThai.setMucDoYeuThich(nhapSoTrongKhoang("Nhập mức độ yêu thích mới (1-5): ", 1, 5));
            System.out.println("Trạng thái đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy trạng thái tương ứng.");
        }
    }

    private static void luuDuLieu() {
        CSVUtils.ghiDanhSachKhachHang(danhSachKhachHang);
        CSVUtils.ghiDanhSachNhaDat(danhSachNhaDat);
        CSVUtils.ghiDanhSachTrangThai(danhSachTrangThai);
        System.out.println("Dữ liệu đã được lưu.");
    }

    private static <T> void hienThiDanhSach(List<T> danhSach, String title) {
        System.out.println("\n" + title);
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            System.out.printf("%-5s %-20s %s%n", "STT", "Chi tiết", "Ghi chú");
            System.out.println("--------------------------------------------------");
            int index = 1;
            for (T item : danhSach) {
                System.out.printf("%-5d %-20s %s%n", index++, item.toString(), "");
            }
        }
    }}

