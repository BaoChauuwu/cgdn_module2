package ss6.Bai3;

public class TestPoint {
    public static void main(String[] args) {
        MovablePoint mp = new MovablePoint(2, 3, 1, 1);
        System.out.println("Before move: " + mp);

        mp.move();
        System.out.println("After move: " + mp);
    }
}

