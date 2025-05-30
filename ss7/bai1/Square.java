package ss7.bai1;

import java.awt.*;

public class Square implements Resizeable {
    private double width;

    public Square(double width) {
        this.width = width;
    }
    public double calculateArea() {
        return width * width;
    }
    @Override
    public void resize(double percent) {
                width = percent * 2;
    }
}
