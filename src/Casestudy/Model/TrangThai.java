package Casestudy.Model;

public class TrangThai {
    private int idKhachHang;
    private int idNhaDat;
    private int mucDoYeuThich;

    public TrangThai(int idKhachHang, int idNhaDat, int mucDoYeuThich) {
        this.idKhachHang = idKhachHang;
        this.idNhaDat = idNhaDat;
        setMucDoYeuThich(mucDoYeuThich);
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdNhaDat() {
        return idNhaDat;
    }

    public void setIdNhaDat(int idNhaDat) {
        this.idNhaDat = idNhaDat;
    }

    public int getMucDoYeuThich() {
        return mucDoYeuThich;
    }

    public void setMucDoYeuThich(int mucDoYeuThich) {
        if (mucDoYeuThich < 1 || mucDoYeuThich > 5) {
            throw new IllegalArgumentException("mucDoYeuThich must be between 1 and 5");
        }
        this.mucDoYeuThich = mucDoYeuThich;
    }

    public String dienGiaiMucDoYeuThich() {
        switch (mucDoYeuThich) {
            case 1:
                return "Không phù hợp yêu cầu";
            case 2:
                return "Phù hợp nhưng khách chưa thích";
            case 3:
                return "Phù hợp, khách thích nhưng chưa trả giá";
                case 4:
                    return "Khách trả giá nhưng chưa thiện chí";
                    case 5:
                        return "Khách thực sự tích và mong muốn mua";
            default:
                throw new IllegalArgumentException("Mức độ yêu thích phải nằm trong khoảng từ 1 đến 5.");

        }
    }
    @Override
    public String toString() {
        return "TrangThai{" +
                "idKhachHang=" + idKhachHang +
                ", idNhaDat=" + idNhaDat +
                ", mucDoYeuThich=" + mucDoYeuThich +
                " (" + dienGiaiMucDoYeuThich() + ")" +
                '}';
    }
}
