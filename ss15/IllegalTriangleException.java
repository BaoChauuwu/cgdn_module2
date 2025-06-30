package ss15;

public class IllegalTriangleException extends Exception {
    
    public IllegalTriangleException() {
        super("Invalid triangle: sides do not form a valid triangle");
    }
    
    public IllegalTriangleException(String message) {
        super(message);
    }
} 