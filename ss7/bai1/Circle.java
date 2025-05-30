package ss7.bai1;

public class Circle implements Resizeable {
    private  double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    public double calculateArea() {
        return radius * radius * Math.PI;
    }
    @Override
    public void resize(double percent) {
            radius = percent * 2;
    }
}
