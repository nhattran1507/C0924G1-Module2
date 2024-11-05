package Bai_1.Bai_tap;

import java.util.Scanner;

public class ChuyenDoiNgoaiTe {
    public static void main(String[] args) {
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.print("Moi ban nhap Usd:");
        usd = sc.nextDouble();
        double convert = usd * 23000;
        System.out.print("Vnd = " + convert);
    }
}
