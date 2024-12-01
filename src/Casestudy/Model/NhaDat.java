package Casestudy.Model;

public class NhaDat {
    private int id;
    private String diaChi;
    private long gia;
    private TrangThai trangThai;
    public NhaDat(int id, String diaChi, long gia) {
        this.id = id;
        this.diaChi = diaChi;
        this.gia = gia;
        this.trangThai = trangThai;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public long getGia() {
        return gia;
    }
    public void setGia(long gia) {
        this.gia = gia;
    }

    public TrangThai getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThai trangThai) {
        this.trangThai = trangThai;
    }
}
