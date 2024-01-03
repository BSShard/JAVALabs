import java.util.Scanner;
public class lab3_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть довжину першого катета:");
        double A = scan.nextDouble();
        System.out.println("Введіть довжину другого катета:");
        double B = scan.nextDouble();
        scan.close();
        double Hyp = Math.hypot(A, B);
        double k1 = Math.toDegrees(Math.asin(A / Hyp));
        double k2 = Math.toDegrees(Math.asin(B / Hyp));
        double k3 = 90;
        System.out.println("Кут A: " + k1);
        System.out.println("Кут B: " + k2);
        System.out.println("Кут C: " + k3);
    }
}
