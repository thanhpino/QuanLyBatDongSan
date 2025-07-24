import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
abstract class BatDongSan {
    protected String maSo;
    protected double chieuDai;
    protected double chieuRong;

    public BatDongSan(String maSo, double chieuDai, double chieuRong) {
        this.maSo = maSo;
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }
    public String getMaSo() {
        return maSo;
    }
    public double getChieuDai() {
        return chieuDai;
    }
    public double getChieuRong() {
        return chieuRong;
    }
    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }
    public abstract double tinhGiaBan();
    public abstract double tinhPhiKinhDoanh();
@Override
    public String toString() {
        return "Ma so: " + maSo + ", Chieu dai: " + chieuDai + ", Chieu rong: " + chieuRong + ", Dien tich: " + tinhDienTich();
    }
}
class DatTrong extends BatDongSan {
    public DatTrong(String maSo, double chieuDai, double chieuRong) {
        super(maSo, chieuDai, chieuRong);
    }
    @Override
    public double tinhGiaBan() {
        return tinhDienTich() * 10000;
    }
    @Override
    public double tinhPhiKinhDoanh(){
        return 0;
    }
    @Override
    public String toString() {
        return "Dat trong - " + super.toString() + ", Gia ban: " + tinhGiaBan();
    }
}
class NhaO extends BatDongSan {
    private int soLau;
    public NhaO(String maSo, double chieuDai, double chieuRong, int soLau) {
        super(maSo, chieuDai, chieuRong);
        this.soLau = soLau;
    }
    public int getSoLau() {
        return soLau;
    }
@Override
    public double tinhGiaBan() {
        return tinhDienTich() * 10000 + soLau * 100000;
    }
@Override
    public double tinhPhiKinhDoanh(){
        return 0;
    }
@Override
    public String toString() {
        return "Nha o - " + super.toString() + ", So lau: " + soLau + ", Gia ban: " + tinhGiaBan();
    }
}
class KhachSan extends BatDongSan {
    private int soSao;
    public KhachSan(String maSo, double chieuDai, double chieuRong, int soSao) {
        super(maSo, chieuDai, chieuRong);
        this.soSao = soSao;
    }
    public int getSoSao() {
        return soSao;
    }
@Override
    public double tinhGiaBan() {
        return 100000 + soSao * 50000;
    }

@Override
    public double tinhPhiKinhDoanh() {
        return getChieuRong() * 5000;
    }

@Override
    public String toString() {
        return "Khach san - " + super.toString() + ", So sao: " + soSao + ", Gia ban: " + tinhGiaBan() + ", Phi kinh doanh: " + tinhPhiKinhDoanh();
    }
}
class BietThu extends BatDongSan {
    public BietThu(String maSo, double chieuDai, double chieuRong) {
        super(maSo, chieuDai, chieuRong);
    }
    @Override
    public double tinhGiaBan() {
        return tinhDienTich() * 400000;
    }
    @Override
    public double tinhPhiKinhDoanh() {
        return tinhDienTich() * 1000;
    }
    @Override
    public String toString() {
        return "Biet thu - " + super.toString() + ", Gia ban: " + tinhGiaBan() + ", Phi kinh doanh: " + tinhPhiKinhDoanh();
    }
}
public class QuanLyBatDongSan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BatDongSan> danhSachBatDongSan = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Ung Dung Quan Ly Bat Dong San ---");
            System.out.println("1. Them dat trong");
            System.out.println("2. Them nha o");
            System.out.println("3. Them khach san");
            System.out.println("4. Them biet thu");
            System.out.println("5. Hien thi danh sach cac bat dong san");
            System.out.println("6. Thoat");
            System.out.print("Chon chuc nang: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    themDatTrong(scanner, danhSachBatDongSan);
                    break;
                case "2":
                    themNhaO(scanner, danhSachBatDongSan);
                    break;
                case "3":
                    themKhachSan(scanner, danhSachBatDongSan);
                    break;
                case "4":
                    themBietThu(scanner, danhSachBatDongSan);
                    break;
                case "5":
                    hienThiDanhSach(danhSachBatDongSan);
                    break;
                case "6":
                    System.out.println("Ung dung ket thuc.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai!.");
            }
        }
    }
    public static void themDatTrong(Scanner scanner, List<BatDongSan> danhSach) {
        System.out.print("Nhap ma so: ");
        String maSo = scanner.nextLine();
        System.out.print("Nhap chieu dai: ");
        double chieuDai = scanner.nextDouble();
        System.out.print("Nhap chieu rong: ");
        double chieuRong = scanner.nextDouble();
        scanner.nextLine();
        danhSach.add(new DatTrong(maSo, chieuDai, chieuRong));
        System.out.println("Da them dat trong thanh cong!");
    }
    public static void themNhaO(Scanner scanner, List<BatDongSan> danhSach) {
        System.out.print("Nhap ma so: ");
        String maSo = scanner.nextLine();
        System.out.print("Nhap chieu dai: ");
        double chieuDai = scanner.nextDouble();
        System.out.print("Nhap chieu rong: ");
        double chieuRong = scanner.nextDouble();
        System.out.print("Nhap so lau: ");
        int soLau = scanner.nextInt();
        scanner.nextLine(); 
        danhSach.add(new NhaO(maSo, chieuDai, chieuRong, soLau));
        System.out.println("Da them nha o thanh cong!");
    }
    public static void themKhachSan(Scanner scanner, List<BatDongSan> danhSach) {
        System.out.print("Nhap ma so: ");
        String maSo = scanner.nextLine();
        System.out.print("Nhap chieu dai: ");
        double chieuDai = scanner.nextDouble();
        System.out.print("Nhap chieu rong: ");
        double chieuRong = scanner.nextDouble();
        System.out.print("Nhap so sao: ");
        int soSao = scanner.nextInt();
        scanner.nextLine(); 
        danhSach.add(new KhachSan(maSo, chieuDai, chieuRong, soSao));
        System.out.println("Da them khach san thanh cong.!");
    }
    public static void themBietThu(Scanner scanner, List<BatDongSan> danhSach) {
        System.out.print("Nhap ma so: ");
        String maSo = scanner.nextLine();
        System.out.print("Nhap chieu dai: ");
        double chieuDai = scanner.nextDouble();
        System.out.print("Nhap chieu rong: ");
        double chieuRong = scanner.nextDouble();
        scanner.nextLine(); 
        danhSach.add(new BietThu(maSo, chieuDai, chieuRong));
        System.out.println("Da them biet thu thanh cong.!");
    }
    public static void hienThiDanhSach(List<BatDongSan> danhSach) {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach bat dong san trong!.");
            return;
        }
        System.out.println("\n--- Danh sach bat dong san ---");
        for (BatDongSan bds : danhSach) {
            System.out.println(bds);
        }
    }
}