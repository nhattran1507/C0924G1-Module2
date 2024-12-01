package Casestudy.util;

import Casestudy.Model.KhachHang;
import Casestudy.Model.NhaDat;
import Casestudy.Model.TrangThai;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {
    private static final String FILE_KHACH_HANG = "khach_hang.csv";
    private static final String FILE_NHA_DAT = "nha_dat.csv";
    private static final String FILE_TRANG_THAI = "trang_thai.csv";

    private static void taoFileNeuChuaCo(String filePath, String header) {
        File file = new File(filePath);
        if (!file.exists()) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                writer.println(header);
                System.out.println("Tạo file mới với tiêu đề: " + filePath);
            } catch (IOException e) {
                System.out.println("Lỗi khi tạo file mới: " + filePath + " - " + e.getMessage());
            }
        }
    }

    public static void ghiDanhSachKhachHang(List<KhachHang> danhSachKhachHang) {
        taoFileNeuChuaCo(FILE_KHACH_HANG, "ID,Ten,SoDienThoai");
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_KHACH_HANG))) {
            writer.println("ID,Ten,SoDienThoai");
            for (KhachHang kh : danhSachKhachHang) {
                writer.printf("%d,%s,%s%n", kh.getId(), kh.getTen(), kh.getSoDienThoai());
            }
            System.out.println("Đã ghi danh sách khách hàng vào file CSV.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file CSV: " + e.getMessage());
        }
    }

    public static void ghiDanhSachNhaDat(List<NhaDat> danhSachNhaDat) {
        taoFileNeuChuaCo(FILE_NHA_DAT, "ID,DiaChi,Gia");
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NHA_DAT))) {
            writer.println("ID,DiaChi,Gia");
            for (NhaDat nha : danhSachNhaDat) {
                writer.printf("%d,%s,%d%n", nha.getId(), nha.getDiaChi(), nha.getGia());
            }
            System.out.println("Đã ghi danh sách nhà đất vào file CSV.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file CSV: " + e.getMessage());
        }
    }

    public static void ghiDanhSachTrangThai(List<TrangThai> danhSachTrangThai) {
        taoFileNeuChuaCo(FILE_TRANG_THAI, "ID_KhachHang,ID_NhaDat,MucDoYeuThich");
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_TRANG_THAI))) {
            writer.println("ID_KhachHang,ID_NhaDat,MucDoYeuThich");
            for (TrangThai tt : danhSachTrangThai) {
                writer.printf("%d,%d,%d%n", tt.getIdKhachHang(), tt.getIdNhaDat(), tt.getMucDoYeuThich());
            }
            System.out.println("Đã ghi danh sách trạng thái vào file CSV.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file CSV: " + e.getMessage());
        }
    }

    public static List<KhachHang> docDanhSachKhachHang() {
        taoFileNeuChuaCo(FILE_KHACH_HANG, "ID,Ten,SoDienThoai");
        List<KhachHang> danhSachKhachHang = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_KHACH_HANG))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 3) {
                    System.out.println("Dòng dữ liệu không hợp lệ: " + line);
                    continue;
                }
                try {
                    int id = Integer.parseInt(data[0]);
                    String ten = data[1];
                    String soDienThoai = data[2];
                    danhSachKhachHang.add(new KhachHang(id, ten, soDienThoai));
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi định dạng dòng: " + line);
                }
            }
            System.out.println("Đã đọc danh sách khách hàng từ file CSV.");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file CSV: " + e.getMessage());
        }
        return danhSachKhachHang;
    }

    public static List<NhaDat> docDanhSachNhaDat() {
        taoFileNeuChuaCo(FILE_NHA_DAT, "ID,DiaChi,Gia");
        List<NhaDat> danhSachNhaDat = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NHA_DAT))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 3) {
                    System.out.println("Dòng dữ liệu không hợp lệ: " + line);
                    continue;
                }
                try {
                    int id = Integer.parseInt(data[0]);
                    String diaChi = data[1];
                    long gia = Long.parseLong(data[2]);
                    danhSachNhaDat.add(new NhaDat(id, diaChi, gia));
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi định dạng dòng: " + line);
                }
            }
            System.out.println("Đã đọc danh sách nhà đất từ file CSV.");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file CSV: " + e.getMessage());
        }
        return danhSachNhaDat;
    }

    public static List<TrangThai> docDanhSachTrangThai() {
        taoFileNeuChuaCo(FILE_TRANG_THAI, "ID_KhachHang,ID_NhaDat,MucDoYeuThich");
        List<TrangThai> danhSachTrangThai = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_TRANG_THAI))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 3) {
                    System.out.println("Dòng dữ liệu không hợp lệ: " + line);
                    continue;
                }
                try {
                    int idKhachHang = Integer.parseInt(data[0]);
                    int idNhaDat = Integer.parseInt(data[1]);
                    int mucDoYeuThich = Integer.parseInt(data[2]);
                    danhSachTrangThai.add(new TrangThai(idKhachHang, idNhaDat, mucDoYeuThich));
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi định dạng dòng: " + line);
                }
            }
            System.out.println("Đã đọc danh sách trạng thái từ file CSV.");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file CSV: " + e.getMessage());
        }
        return danhSachTrangThai;
    }
}
