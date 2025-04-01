package ra.entity;

import ra.validate.CustomerValidate;
import ra.validate.StringRule;

import java.time.LocalDate;
import java.util.Scanner;

public class Customer implements IApp {
    private String customerId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private boolean gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String customerType;

    public Customer() {}

    public Customer(String customerId, String firstName, String lastName, LocalDate dateOfBirth, boolean gender, String address, String phoneNumber, String email, String customerType) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.firstName = CustomerValidate.validateInputString(scanner, "Nhập tên khách hàng: ", new StringRule(0, 50));
        this.lastName = CustomerValidate.validateInputString(scanner, "Nhập họ khách hàng: ", new StringRule(0, 30));
        this.dateOfBirth = CustomerValidate.validateDateOfBirth(scanner, "Nhập ngày tháng năm sinh");
        this.gender = CustomerValidate.validateInputBoolean(scanner, "Nhập giới tính: (true/false): ");
        this.address = CustomerValidate.validateInputString(scanner, "Nhập địa chỉ khách hàng: ", new StringRule(0, 255));
        this.phoneNumber = CustomerValidate.validatePhone(scanner, "Nhập số điện thoại: ");
        this.email = CustomerValidate.validateEmail(scanner, "Nhập email: ");
        this.customerType = CustomerValidate.validateInputString(scanner, "Nhập loại khách hàng: ", new StringRule(0, 255));
    }

    @Override
    public void displayData() {
        System.out.println("Mã khách hàng: " + this.customerId);
        System.out.println("Họ và tên khách hàng: " + this.lastName + " " + this.firstName);
        System.out.println("Ngày tháng năm sinh của khách hàng: " + this.dateOfBirth);
        System.out.println("giới tính của khách hàng: " + (this.gender? "Nam" : "Nữ"));
        System.out.println("Địa chỉ khách hàng: " + this.address);
        System.out.println("Số điện thoại khách hàng: " + this.phoneNumber);
        System.out.println("Email khách hàng: " + this.email);
        System.out.println("Loại khách hàng: " + this.customerType);
    }
}
