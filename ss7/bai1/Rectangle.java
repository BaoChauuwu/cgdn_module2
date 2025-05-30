package ss7.bai1;

public class Rectangle implements Resizeable {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double calculateArea() {
        return width * height;
    }
    @Override
    public void resize(double percent) {
            width = percent * 2;
            height = percent * 2;
    }
}
