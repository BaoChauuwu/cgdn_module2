package ss18;

public class ClassNameValidator {
    public static boolean isValidClassName(String className) {
        String regex = "^[CAP]\\d{4}[GHIK]$";
        return className.matches(regex);
    }

    public static void main(String[] args) {
        String[] testCases = {
                "C0223G",
                "A0323K",
                "M0318G",
                "P0323A",
                "C02@3G",
                "A12345G"
        };

        for (String className : testCases) {
            System.out.printf("Tên lớp \"%s\" %s hợp lệ.%n",
                    className,
                    isValidClassName(className) ? "là" : "không");
        }
    }
}
