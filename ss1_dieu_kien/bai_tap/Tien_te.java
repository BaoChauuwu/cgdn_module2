package ss1_dieu_kien.bai_tap;

import java.util.Scanner;

public class Tien_te {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap so tien muon chuyen doi");
        double number =  Integer.parseInt(sc.nextLine());
        double rate=23000;
        System.out.println("So tien chuyen doi qua tien VND la: "+number*rate);
    }
}
