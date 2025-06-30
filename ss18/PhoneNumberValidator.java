package ss18;

public class PhoneNumberValidator {
    public static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
        return phoneNumber.matches(regex);
    }

    public static void main(String[] args) {
        String[] testCases = {
                "(84)-(0978489648)",
                "(a8)-(22222222)",
                "(84)-(22b22222)",
                "(84)-(9978489648)",
                "(84)-(0123456789)",
                "(01)-(0123456789)",
                "(84)-(012345678)"
        };

        for (String phone : testCases) {
            System.out.printf("SĐT \"%s\" %s hợp lệ.%n",
                    phone,
                    isValidPhoneNumber(phone) ? "là" : "không");
        }
    }
}
