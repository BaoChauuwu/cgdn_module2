package final_module2.controller;

import final_module2.model.entity.Contact;
import final_module2.model.service.ContactService;

import java.util.List;
import java.util.Scanner;

public class ManagementContact {
    private ContactService contactService = new ContactService();
    private Scanner scanner = new Scanner(System.in);

    private boolean checkIsEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public void addContact() {
        System.out.println("------- THÊM LIÊN HỆ MỚI-------");
        System.out.println("Nhập tên người dùng: ");
        String userName = scanner.nextLine();

        System.out.println("Nhap number");
        String number = scanner.nextLine();

        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();


        System.out.println("Nhap email");
        String email = scanner.nextLine();

        System.out.println("Nhập nhóm (gia đình/bạn bè/công việc): ");
        String group = scanner.nextLine();

        System.out.println("Nhập giới tính (nam/nữ): ");
        String sex = scanner.nextLine();

        System.out.println("Nhập ngày sinh theo định dạng (dd/mm/yyyy): ");
        String dob = scanner.nextLine();

        Contact contact = new Contact(userName, number, address, email, group, sex, dob);
        contactService.addContact(contact);
        System.out.println("Thêm danh bạ thành công!");
    }

    public void displayAllContact() {
        List<Contact> contacts = contactService.findAll();
        if (contacts.isEmpty()) {
            System.out.println("Không có danh bạ nào trong danh sách.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void updateContact() {
        System.out.println("Nhập số điện thoại của liên hệ cần cập nhật: ");
        String number = scanner.nextLine();

        if (contactService.isExistContact(number)) {
            Contact existingContact = contactService.findContactByNumber(number);
            System.out.println("Thông tin hiện tại: " + existingContact);

            System.out.println("Nhập tên người dùng mới");
            String userName = scanner.nextLine();
            if (userName.isEmpty())
                return;

            System.out.println("Nhập địa chỉ mới:");
            String address = scanner.nextLine();
            if (address.isEmpty())
                return;

            System.out.println("Nhập email mới:");
            String email = scanner.nextLine();
            if (email.isEmpty())
                return;

            System.out.println("Nhập nhóm mới:");
            String group = scanner.nextLine();
            if (group.isEmpty())
                return;

            System.out.println("Nhập giới tính mới:");
            String sex = scanner.nextLine();
            if (sex.isEmpty())
                return;

            System.out.println("Nhập ngày sinh mới (dd/mm/yyyy): ");
            String dob = scanner.nextLine();
            if (dob.isEmpty())
                return;

            Contact updatedContact = new Contact(userName, number, address, email, group, sex, dob);
            contactService.updateContact(updatedContact);
            System.out.println("Cập nhật danh bạ thành công!");
        } else {
            System.out.println("Không tìm thấy liên hệ với số điện thoại: " + number);
        }
    }

    public void deleteContact() {
        System.out.println("Nhập số điện thoại của liên hệ cần xóa: ");
        String number = scanner.nextLine();

        if (contactService.isExistContact(number)) {
            Contact contact = contactService.findContactByNumber(number);
            System.out.println("Bạn có chắc chắn muốn xóa liên hệ: " + contact.getUserName() + " (" + number + ")? (y/n): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("Y")) {
                contactService.deleteContact(number);
                System.out.println("Xóa danh bạ thành công");
            } else {
                System.out.println("Hủy bỏ thao tác xóa");
            }
        } else {
            System.out.println("Không tìm thấy liên hệ với số điện thoại");
        }
    }

    public void searchContact() {
        System.out.println("Chọn phương thức tìm kiếm");
        System.out.println("1.Tìm khiếm theo số điện thoại");
        System.out.println("2.Tìm khiếm theo tên");
        System.out.println("3.Lựa chọn");
        int choice = Integer.parseInt(scanner.nextLine());
        Contact contact = null;
        switch (choice) {
            case 1:
                System.out.println("Nhập số điện thoại: ");
                String number = scanner.nextLine();
                contact = contactService.findContactByNumber(number);
                break;
            case 2:
                System.out.println("Nhập tên: ");
                String name = scanner.nextLine();
                contact = contactService.findContactByName(name);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ");
                return;
        }
        if (contact != null) {
            System.out.println("Tìm thấy liên hệ");
            System.out.println(contact);
        } else {
            System.out.println("Không tìm thấy liên hệ");
        }
    }

    public void readFromFile() {
        List<Contact> contacts = contactService.findAll();
        if (contacts.isEmpty()) {
            System.out.println("Không có dữ liệu trong file.");
        } else {
            displayAllContact();
        }
    }
}
