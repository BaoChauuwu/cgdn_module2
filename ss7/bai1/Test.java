package ss7.bai1;

public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle(2);
        Rectangle rectangle = new Rectangle(2,3);
        Square square = new Square(2);
        System.out.println("Dien tich truoc khi thay doi cua hinh tron la: " + circle.calculateArea());
        circle.resize(10);
        System.out.println("Dien tich sau khi thay doi cua hinh tron la: " + circle.calculateArea());
        System.out.println("Dien tich truoc khi thay doi cua hinh chu nhat la: " + rectangle.calculateArea());
        rectangle.resize(10);
        System.out.println("Dien tich sau khi thay doi cua hinh chu nhat la: " + rectangle.calculateArea());
        System.out.println("Dien tich truoc khi thay doi cua hinh vuong la: "+ square.calculateArea());
        square.resize(10);
        System.out.println("Dien tich sau khi thay doi cua hinh vuong l:"+square.calculateArea());


    }
}
