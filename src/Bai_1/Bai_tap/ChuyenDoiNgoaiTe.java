package Bai_1.Bai_tap;

import java.util.Scanner;

public class ChuyenDoiNgoaiTe {
    public static void main(String[] args) {
        double usd;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Moi ban nhap Usd (phai > 0): ");
            usd = sc.nextDouble();
            if (usd <= 0) {
                System.out.println("So tien phai lon hon 0. Vui long nhap lai.");
            }
        } while (usd <= 0);

        double convert = usd * 23000;
        System.out.print("Vnd = " + convert);
    }
}
