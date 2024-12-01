package Casestudy;

import Casestudy.Model.KhachHang;
import Casestudy.Model.NhaDat;
import Casestudy.Model.TrangThai;
import Casestudy.util.CSVUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<KhachHang> danhSachKhachHang = new ArrayList<>();
    private static List<NhaDat> danhSachNhaDat = new ArrayList<>();
    private static List<TrangThai> danhSachTrangThai = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Đọc dữ liệu từ file CSV khi bắt đầu
        danhSachKhachHang = CSVUtils.docDanhSachKhachHang();
        danhSachNhaDat = CSVUtils.docDanhSachNhaDat();
        danhSachTrangThai = CSVUtils.docDanhSachTrangThai();

        boolean running = true;
        while (running) {
            printMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1 -> themKhachHang();
                case 2 -> hienThiKhachHang();
                case 3 -> themNhaDat();
                case 4 -> hienThiNhaDat();
                case 5 -> nhapTrangThai();
                case 6 -> hienThiTrangThai();
                case 7 -> xoaKhachHang();
                case 8 -> capNhatKhachHang();
                case 9 -> xoaNhaDat();
                case 10 -> capNhatNhaDat();
                case 11 -> capNhatTrangThai();
                case 12 -> {
                    CSVUtils.ghiDanhSachKhachHang(danhSachKhachHang);
                    CSVUtils.ghiDanhSachNhaDat(danhSachNhaDat);
                    CSVUtils.ghiDanhSachTrangThai(danhSachTrangThai);
                    running = false;
                }
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
        scanner.close();
        System.out.println("Chương trình kết thúc.");
    }

    private static void printMenu() {
        System.out.println("\nHệ thống quản lý:");
        System.out.println("1. Nhập khách hàng");
        System.out.println("2. Hiển thị danh sách khách hàng");
        System.out.println("3. Nhập nhà đất");
        System.out.println("4. Hiển thị danh sách nhà đất");
        System.out.println("5. Nhập tình trạng tương thích");
        System.out.println("6. Hiển thị trạng thái khách hàng - nhà đất");
        System.out.println("7. Xóa khách hàng");
        System.out.println("8. Cập nhật thông tin khách hàng");
        System.out.println("9. Xóa nhà đất");
        System.out.println("10. Cập nhật thông tin nhà đất");
        System.out.println("11. Cập nhật tình trạng khách hàng - nhà đất");
        System.out.println("12. Thoát");
    }

    private static int getUserChoice() {
        while (true) {
            System.out.print("Lựa chọn của bạn: ");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            }
        }
    }

    private static void themKhachHang() {
        System.out.print("Nhập ID khách hàng: ");
        int idKhachHang = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên khách hàng: ");
        String tenKhachHang = scanner.nextLine();
        System.out.print("Nhập số điện thoại khách hàng: ");
        String soDienThoai = scanner.nextLine();

        if (danhSachKhachHang.stream().anyMatch(kh -> kh.getTen().equalsIgnoreCase(tenKhachHang) && kh.getSoDienThoai().equals(soDienThoai))) {
            System.out.println("Thông tin khách hàng đã tồn tại. Không thể thêm mới.");
        } else {
            danhSachKhachHang.add(new KhachHang(idKhachHang, tenKhachHang, soDienThoai));
            System.out.println("Khách hàng đã được thêm.");
        }
    }

    private static void hienThiKhachHang() {
        System.out.println("Danh sách khách hàng:");
        danhSachKhachHang.forEach(kh -> System.out.println("ID: " + kh.getId() + ", Tên: " + kh.getTen() + ", SĐT: " + kh.getSoDienThoai()));
    }

    private static void themNhaDat() {
        System.out.print("Nhập ID nhà đất: ");
        int idNhaDat = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập địa chỉ: ");
        String diaChi = scanner.nextLine();
        System.out.print("Nhập giá: ");
        long gia = Long.parseLong(scanner.nextLine());

        NhaDat nhaDatTrung = danhSachNhaDat.stream().filter(nha -> nha.getDiaChi().equalsIgnoreCase(diaChi)).findFirst().orElse(null);

        if (nhaDatTrung != null) {
            if (nhaDatTrung.getGia() == gia) {
                System.out.println("Nhà đất đã tồn tại với địa chỉ và giá này. Không thể thêm mới.");
            } else {
                System.out.print("Nhà đất đã có địa chỉ này nhưng giá khác. Bạn có muốn cập nhật giá không? (y/n): ");
                if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
                    nhaDatTrung.setGia(gia);
                    System.out.println("Giá nhà đất đã được cập nhật.");
                }
            }
        } else {
            danhSachNhaDat.add(new NhaDat(idNhaDat, diaChi, gia));
            System.out.println("Nhà đất đã được thêm.");
        }
    }

    private static void hienThiNhaDat() {
        System.out.println("Danh sách nhà đất:");
        danhSachNhaDat.forEach(nha -> System.out.println("ID: " + nha.getId() + ", Địa chỉ: " + nha.getDiaChi() + ", Giá: " + nha.getGia()));
    }

    private static void nhapTrangThai() {
        System.out.print("Nhập ID khách hàng: ");
        int idKhachHang = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập ID nhà đất: ");
        int idNhaDat = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập mức độ yêu thích (1-5): ");
        int mucDoYeuThich = Integer.parseInt(scanner.nextLine());

        try {
            TrangThai trangThai = new TrangThai(idKhachHang, idNhaDat, mucDoYeuThich);
            danhSachTrangThai.add(trangThai);
            System.out.println("Đã thêm trạng thái: " + trangThai);
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void hienThiTrangThai() {
        System.out.println("Trạng thái khách hàng - nhà đất:");
        danhSachTrangThai.forEach(System.out::println);
    }

    private static void xoaKhachHang() {
        System.out.print("Nhập ID khách hàng cần xóa: ");
        int idKhachHang = Integer.parseInt(scanner.nextLine());
        KhachHang khachHang = danhSachKhachHang.stream()
                .filter(kh -> kh.getId() == idKhachHang)
                .findFirst()
                .orElse(null);

        if (khachHang != null) {
            danhSachKhachHang.remove(khachHang);
            System.out.println("Khách hàng đã được xóa.");
        } else {
            System.out.println("Khách hàng không tồn tại.");
        }
    }

    private static void capNhatKhachHang() {
        System.out.print("Nhập ID khách hàng cần cập nhật: ");
        int idKhachHang = Integer.parseInt(scanner.nextLine());
        KhachHang khachHang = danhSachKhachHang.stream()
                .filter(kh -> kh.getId() == idKhachHang)
                .findFirst()
                .orElse(null);

        if (khachHang != null) {
            System.out.print("Nhập tên mới cho khách hàng (hiện tại: " + khachHang.getTen() + "): ");
            String tenKhachHang = scanner.nextLine();
            System.out.print("Nhập số điện thoại mới cho khách hàng (hiện tại: " + khachHang.getSoDienThoai() + "): ");
            String soDienThoai = scanner.nextLine();

            khachHang.setTen(tenKhachHang);
            khachHang.setSoDienThoai(soDienThoai);
            System.out.println("Thông tin khách hàng đã được cập nhật.");
        } else {
            System.out.println("Khách hàng không tồn tại.");
        }
    }

    private static void xoaNhaDat() {
        System.out.print("Nhập ID nhà đất cần xóa: ");
        int idNhaDat = Integer.parseInt(scanner.nextLine());
        NhaDat nhaDat = danhSachNhaDat.stream()
                .filter(nha -> nha.getId() == idNhaDat)
                .findFirst()
                .orElse(null);

        if (nhaDat != null) {
            danhSachNhaDat.remove(nhaDat);
            System.out.println("Nhà đất đã được xóa.");
        } else {
            System.out.println("Nhà đất không tồn tại.");
        }
    }

    private static void capNhatNhaDat() {
        System.out.print("Nhập ID nhà đất cần cập nhật: ");
        int idNhaDat = Integer.parseInt(scanner.nextLine());
        NhaDat nhaDat = danhSachNhaDat.stream()
                .filter(nha -> nha.getId() == idNhaDat)
                .findFirst()
                .orElse(null);

        if (nhaDat != null) {
            System.out.print("Nhập địa chỉ mới cho nhà đất (hiện tại: " + nhaDat.getDiaChi() + "): ");
            String diaChi = scanner.nextLine();
            System.out.print("Nhập giá mới cho nhà đất (hiện tại: " + nhaDat.getGia() + "): ");
            long gia = Long.parseLong(scanner.nextLine());

            nhaDat.setDiaChi(diaChi);
            nhaDat.setGia(gia);
            System.out.println("Thông tin nhà đất đã được cập nhật.");
        } else {
            System.out.println("Nhà đất không tồn tại.");
        }
    }

    private static void capNhatTrangThai() {
        System.out.print("Nhập ID khách hàng: ");
        int idKhachHang = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập ID nhà đất: ");
        int idNhaDat = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập mức độ yêu thích mới (1-5): ");
        int mucDoYeuThich = Integer.parseInt(scanner.nextLine());

        TrangThai trangThai = danhSachTrangThai.stream()
                .filter(tt -> tt.getIdKhachHang() == idKhachHang && tt.getIdNhaDat() == idNhaDat)
                .findFirst()
                .orElse(null);

        if (trangThai != null) {
            trangThai.setMucDoYeuThich(mucDoYeuThich);
            System.out.println("Trạng thái đã được cập nhật.");
        } else {
            System.out.println("Trạng thái không tồn tại.");
        }
    }
}
