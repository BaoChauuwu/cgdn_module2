package ss7.bai2;

public class Test {

    public static void main(String[] args) {
            Shape[] shapes = {
                    new Square(5),
                    new Circle(2),
                    new Rectangle(4, 5)
            };

            for (Shape s : shapes) {
                System.out.println(s);
                System.out.println("area:" + s.getArea());
                if (s instanceof Colorable) {
                    ((Colorable) s).howToColor();
                }
            }
    }
}
