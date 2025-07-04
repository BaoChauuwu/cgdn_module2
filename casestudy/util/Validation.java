package casestudy.util;

import java.util.regex.Pattern;

public class Validation {
    
    // Pattern cho email
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
    );
    
    // Pattern cho ID (chỉ chứa chữ và số, từ 3-10 ký tự)
    private static final Pattern ID_PATTERN = Pattern.compile("^[a-zA-Z0-9]{3,10}$");
    
    // Pattern cho tên (chỉ chứa chữ cái, khoảng trắng và dấu)
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-ZÀ-ỹ\\s]{2,50}$");
    
    // Pattern cho ngày tháng (dd/MM/yyyy)
    private static final Pattern DATE_PATTERN = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$");
    
    /**
     * Kiểm tra chuỗi có null hoặc rỗng không
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    
    /**
     * Validate ID
     */
    public static boolean isValidId(String id) {
        if (isNullOrEmpty(id)) {
            return false;
        }
        return ID_PATTERN.matcher(id.trim()).matches();
    }
    
    /**
     * Validate tên
     */
    public static boolean isValidName(String name) {
        if (isNullOrEmpty(name)) {
            return false;
        }
        return NAME_PATTERN.matcher(name.trim()).matches();
    }
    
    /**
     * Validate email
     */
    public static boolean isValidEmail(String email) {
        if (isNullOrEmpty(email)) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email.trim()).matches();
    }
    
    /**
     * Validate ngày sinh (dd/MM/yyyy)
     */
    public static boolean isValidDateOfBirth(String dateOfBirth) {
        if (isNullOrEmpty(dateOfBirth)) {
            return false;
        }
        
        if (!DATE_PATTERN.matcher(dateOfBirth.trim()).matches()) {
            return false;
        }
        
        // Kiểm tra ngày hợp lệ
        try {
            String[] parts = dateOfBirth.trim().split("/");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);
            
            // Kiểm tra năm (từ 1900 đến năm hiện tại)
            int currentYear = java.time.Year.now().getValue();
            if (year < 1900 || year > currentYear) {
                return false;
            }
            
            // Kiểm tra tháng
            if (month < 1 || month > 12) {
                return false;
            }
            
            // Kiểm tra ngày
            int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            
            // Kiểm tra năm nhuận
            if (month == 2 && isLeapYear(year)) {
                daysInMonth[1] = 29;
            }
            
            return day >= 1 && day <= daysInMonth[month - 1];
            
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Validate tuổi
     */
    public static boolean isValidAge(int age) {
        return age > 0 && age <= 120;
    }
    
    /**
     * Validate lương (phải là số dương)
     */
    public static boolean isValidSalary(double salary) {
        return salary > 0;
    }
    
    /**
     * Validate chuỗi thông thường (không rỗng, không chỉ chứa khoảng trắng)
     */
    public static boolean isValidString(String str) {
        return !isNullOrEmpty(str) && str.trim().length() >= 2;
    }
    
    /**
     * Validate lớp học (cho Student)
     */
    public static boolean isValidClassName(String className) {
        if (isNullOrEmpty(className)) {
            return false;
        }
        // Lớp học có thể chứa chữ, số và một số ký tự đặc biệt
        return className.trim().matches("^[a-zA-Z0-9\\s-]{2,20}$");
    }
    
    /**
     * Validate vị trí công việc (cho Employee)
     */
    public static boolean isValidPosition(String position) {
        return isValidString(position) && position.trim().length() <= 50;
    }
    
    /**
     * Validate địa điểm làm việc (cho Employee)
     */
    public static boolean isValidWorkLocation(String workLocation) {
        return isValidString(workLocation) && workLocation.trim().length() <= 100;
    }
    
    /**
     * Kiểm tra năm nhuận
     */
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    /**
     * Validate toàn bộ thông tin Person
     */
    public static String validatePerson(String id, String name, String email, String dateOfBirth, int age) {
        StringBuilder errors = new StringBuilder();
        
        if (!isValidId(id)) {
            errors.append("ID không hợp lệ (phải từ 3-10 ký tự chữ và số).\n");
        }
        
        if (!isValidName(name)) {
            errors.append("Tên không hợp lệ (phải từ 2-50 ký tự chữ cái).\n");
        }
        
        if (!isValidEmail(email)) {
            errors.append("Email không hợp lệ.\n");
        }
        
        if (!isValidDateOfBirth(dateOfBirth)) {
            errors.append("Ngày sinh không hợp lệ (định dạng dd/MM/yyyy).\n");
        }
        
        if (!isValidAge(age)) {
            errors.append("Tuổi không hợp lệ (phải từ 1-120).\n");
        }
        
        return errors.toString();
    }
    
    /**
     * Validate toàn bộ thông tin Student
     */
    public static String validateStudent(String id, String name, String email, String dateOfBirth, int age, String className) {
        StringBuilder errors = new StringBuilder();
        
        // Validate thông tin Person trước
        errors.append(validatePerson(id, name, email, dateOfBirth, age));
        
        // Validate thông tin riêng của Student
        if (!isValidClassName(className)) {
            errors.append("Tên lớp không hợp lệ (phải từ 2-20 ký tự).\n");
        }
        
        return errors.toString();
    }
    
    /**
     * Validate toàn bộ thông tin Employee
     */
    public static String validateEmployee(String id, String name, String email, String dateOfBirth, int age, 
                                        String position, double salary, String workLocation) {
        StringBuilder errors = new StringBuilder();
        
        // Validate thông tin Person trước
        errors.append(validatePerson(id, name, email, dateOfBirth, age));
        
        // Validate thông tin riêng của Employee
        if (!isValidPosition(position)) {
            errors.append("Vị trí công việc không hợp lệ.\n");
        }
        
        if (!isValidSalary(salary)) {
            errors.append("Lương không hợp lệ (phải là số dương).\n");
        }
        
        if (!isValidWorkLocation(workLocation)) {
            errors.append("Địa điểm làm việc không hợp lệ.\n");
        }
        
        return errors.toString();
    }
} 