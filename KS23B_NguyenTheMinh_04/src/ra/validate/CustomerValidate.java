package ra.validate;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerValidate {
    public static String generateCustomerId() {
        Random random = new Random();
        return "C" + String.format("%04d", random.nextInt(10000));
    }


    public static String validateCustomerId(Scanner scanner, String message, String regex) {
        System.out.print(message);
        while (true) {
            try {
                String input = scanner.nextLine();
                if (!Pattern.matches(regex, input)) {
                    throw new IllegalArgumentException("Ký tự không hợp lệ, Nhập lại");
                }
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String validateInputString(Scanner scanner, String message, StringRule rule) {
        System.out.print(message);
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Không được để trống!, Nhập lại");
                }
                if (!rule.isValidString(input)) {
                    throw new IllegalArgumentException("Số lượng ký tự không hợp lệ, Nhập lại!");
                }
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static LocalDate validateDateOfBirth(Scanner scanner, String message) {
        System.out.println(message);
        while (true) {
            try {
                System.out.print("Nhập ngày sinh: ");
                String dayStr = scanner.nextLine().trim();
                System.out.print("Nhập tháng sinh: ");
                String monthStr = scanner.nextLine().trim();
                System.out.print("Nhập năm sinh: ");
                String yearStr = scanner.nextLine().trim();

                if (dayStr.isEmpty() || monthStr.isEmpty() || yearStr.isEmpty()) {
                    System.out.println("Không được để trống ngày, tháng, năm! Vui lòng nhập lại.");
                    continue;
                }

                int day = Integer.parseInt(dayStr);
                int month = Integer.parseInt(monthStr);
                int year = Integer.parseInt(yearStr);
                return LocalDate.of(year, month, day);
            } catch (InputMismatchException e) {
                System.out.println("Không được để trống!, Nhập lại");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean validateInputBoolean(Scanner scanner, String message) {
        System.out.print(message);
        while (true) {
            try {
                String input = scanner.nextLine().trim().toLowerCase();
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Không được để trống!, Nhập la");
                }
                if (!input.equals("true") && !input.equals("false")) {
                    throw new InputMismatchException("Không phải giá trị boolean hợp lệ, Nhập lại");
                }
                return Boolean.parseBoolean(input);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String validateEmail(Scanner scanner, String message) {
        System.out.print(message);
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new InputMismatchException("Không được để trống!, Nhập lại");
                }
                if (!pattern.matcher(input).matches()) {
                    throw new InputMismatchException("Email không hợp lệ, Nhập lại!");
                }
                return input;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String validatePhone(Scanner scanner, String message) {
        System.out.print(message);
        String regex = "^(0[35789][0-9]{8})$";

        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new InputMismatchException("Không được để trống! Nhạp lại");
                }
                if (!input.matches(regex)) {
                    throw new InputMismatchException("Số điện thoại không hợp lệ, Nhập lại!");
                }
                return input;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
