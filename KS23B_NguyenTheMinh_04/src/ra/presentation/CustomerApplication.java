package ra.presentation;

import ra.bussiness.CustomerBusiness;

import java.util.Scanner;

public class CustomerApplication {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        do{

            System.out.println("==================MENU================");
            System.out.println("1. Hiển thị danh sách khách hàng");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Chỉnh sửa khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Tìm kiếm khách hàng theo lựa chọn");
            System.out.println("6. Sắp xếp khách haàng theo lựa chọn");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    CustomerBusiness.displayAllCustomers();
                    break;
                case 2:
                    CustomerBusiness.addCustomer(scanner);
                    break;
                case 3:
                    CustomerBusiness.updateCustomer();
                    break;
                case 4:
                    CustomerBusiness.deleteCustomer();
                    break;
                case 5:
                    CustomerBusiness.searchCustomer(scanner);
                    break;
                case 6:
                    CustomerBusiness.sortCustomers(scanner);
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                default:
                    System.out.println("Không hợp lệ, vui lòng chọn lại");
            }
        }while (true);
    }
}
