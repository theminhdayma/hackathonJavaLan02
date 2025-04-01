package ra.bussiness;

import ra.entity.Customer;
import ra.validate.CustomerValidate;
import ra.validate.StringRule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class CustomerBusiness {
    static ArrayList<Customer> customers = new ArrayList<Customer>();

    public static void addCustomer(Scanner scanner) {
        Customer customer = new Customer();
        customer.setCustomerId(CustomerValidate.generateCustomerId());
        customer.inputData(scanner);
        customers.add(customer);
        System.out.println("Thêm khách hàng thành công!");
    }

    public static int findIndexById(String CustomerId) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerId().equals(CustomerId)) {
                return i;
            }
        }
        return -1;
    }

    public static void displayAllCustomers() {
        if (customers.size() > 0) {
            System.out.println("Danh sách khách hàng:");
            for (Customer customer : customers) {
                System.out.println("-----------------------------------");
                customer.displayData();
            }
        } else {
            System.out.println("Danh sách khách hàng rỗng !");
        }
    }

    public static void updateCustomer() {
        Scanner scanner = new Scanner(System.in);

        String idIndex = CustomerValidate.validateCustomerId(scanner, "Nhập id khách hàng: ", "[C].{4}$");

        int index = findIndexById(idIndex);
        if (index == -1) {
            System.out.println("Khách hàng không tồn tại");
            return;
        }

        int choice;
        do {
            System.out.println("\n-------------------Menu chỉnh sửa---------------------");
            System.out.println("1. Tên khách hàng");
            System.out.println("2. Họ khách hàng");
            System.out.println("3. Ngày tháng năm sinh");
            System.out.println("4. Giới tính");
            System.out.println("5. Địa chỉ");
            System.out.println("6. Số điện thoại");
            System.out.println("7. Email");
            System.out.println("8. Loại khách hàng");
            System.out.println("9. Thoát chỉnh sửa");
            System.out.print("Lựa chọn của bạn (1-9): ");

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    customers.get(index).setFirstName(CustomerValidate.validateInputString(scanner, "Nhập tên mới: ", new StringRule(0, 50)));
                    break;
                case 2:
                    customers.get(index).setLastName(CustomerValidate.validateInputString(scanner, "Nhập họ mới: ", new StringRule(0, 30)));
                    break;
                case 3:
                    customers.get(index).setDateOfBirth(CustomerValidate.validateDateOfBirth(scanner, "Nhập ngày tháng năm sinh mới"));
                    break;
                case 4:
                    customers.get(index).setGender(CustomerValidate.validateInputBoolean(scanner, "Nhập giới tính mới: (true/false): "));
                    break;
                case 5:
                    customers.get(index).setAddress(CustomerValidate.validateInputString(scanner, "Nhập địa chỉ khách hàng mới: ", new StringRule(0, 255)));
                    break;
                case 6:
                    customers.get(index).setPhoneNumber(CustomerValidate.validatePhone(scanner, "Nhập số điện thoại mới: "));
                    break;
                case 7:
                    customers.get(index).setEmail(CustomerValidate.validateEmail(scanner, "Nhập email mới: "));
                    break;
                case 8:
                    customers.get(index).setCustomerType(CustomerValidate.validateInputString(scanner, "Nhập loại khách hàng mới: ", new StringRule(0, 255)));
                    break;
                case 9:
                    System.out.println("Chỉnh sửa thành công !!!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 9);
    }

    public static void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        String idIndex = CustomerValidate.validateCustomerId(scanner, "Nhập id khách hàng: ", "[C].{4}$");

        int index = findIndexById(idIndex);
        if (index == -1) {
            System.out.println("Khách hàng không tồn tại");
            return;
        }

        int choice;
        while (true) {
            System.out.print("Bạn có chắc chắn muốn xóa khách hàng này? (1: Có, 2: Không): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    customers.remove(index);
                    System.out.println("Xóa khách hàng thành công!");
                    return;
                case 2:
                    System.out.println("Hủy xóa khách hàng.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }


    public static void searchCustomer(Scanner scanner) {
        System.out.println("Chọn tiêu chí tìm kiếm:");
        System.out.println("1. Tìm kiếm theo tên khách hàng");
        System.out.println("2. Tìm kiếm theo loại khách hàng");
        System.out.println("3. Tìm kiếm theo số điện thoại");
        System.out.print("Chọn: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Customer> result = new ArrayList<>();

        switch (choice) {
            case 1:
                System.out.print("Nhập tên khách hàng: ");
                String name = scanner.nextLine().toLowerCase();
                for (Customer c : customers) {
                    if (c.getFirstName().toLowerCase().contains(name) || c.getLastName().toLowerCase().contains(name)) {
                        result.add(c);
                    }
                }
                break;
            case 2:
                System.out.print("Nhập loại khách hàng: ");
                String type = scanner.nextLine().toLowerCase();
                for (Customer c : customers) {
                    if (c.getCustomerType().toLowerCase().contains(type)) {
                        result.add(c);
                    }
                }
                break;
            case 3:
                System.out.print("Nhập số điện thoại: ");
                String phone = scanner.nextLine();
                for (Customer c : customers) {
                    if (c.getPhoneNumber().contains(phone)) {
                        result.add(c);
                    }
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy kết quả phù hợp");
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (Customer c : result) {
                c.displayData();
            }
        }
    }


    public static void sortCustomers(Scanner scanner) {
        System.out.println("Chọn tiêu chí sắp xếp:");
        System.out.println("1. Sắp xếp theo tên tăng dần");
        System.out.println("2. Sắp xếp theo tên giảm dần");
        System.out.println("3. Sắp xếp theo năm sinh tăng dần");
        System.out.println("4. Sắp xếp theo năm sinh giảm dần");
        System.out.print("Lựa chọn của bạn: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                customers.sort(Comparator.comparing(Customer::getFirstName));
                break;
            case 2:
                customers.sort(Comparator.comparing(Customer::getFirstName).reversed());
                break;
            case 3:
                customers.sort(Comparator.comparing(Customer::getDateOfBirth));
                break;
            case 4:
                customers.sort(Comparator.comparing(Customer::getDateOfBirth).reversed());
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ! Chọn từ 1 đến 4");
                return;
        }

        System.out.println("Danh sách khách hàng sau khi sắp xếp:");
        displayAllCustomers();
    }

}
