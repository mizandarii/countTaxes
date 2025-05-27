import java.util.InputMismatchException;
import java.util.Scanner;

public class AnnualSalary {

    public double[] Annual(double monthly, int yrs) {
        if (monthly < 0 || yrs < 0) {
            throw new IllegalArgumentException("Оклад и стаж не могут быть отрицательными.");
        }

        double annual = monthly * 12;
        double taxFree = 0;

        if (annual <= 14400.0) {
            taxFree = 7848.0;
        } else if (annual <= 25200.0) {
            taxFree = (7848.00 - (7848.00 / 10800.00) * (annual - 14400.00));
        }else{
            taxFree = 0;
        }

        int compensationDays = 0;
        if (yrs < 5) {
            compensationDays = 180;
        } else if (yrs < 10) {
            compensationDays = 210;
        } else {
            compensationDays = 300;
        }

        double daily = monthly / 30.0;
        double insurance = daily * 0.6 * 100 + daily * 0.4 * compensationDays;
        double tax = Math.max(0, (annual - taxFree) * 0.22); // чтобы не было отрицательных налогов

        return new double[]{annual, insurance, tax, taxFree};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnnualSalary salary = new AnnualSalary();

        try {
            System.out.print("Введите месячный оклад: ");
            double monthly = scanner.nextDouble();

            System.out.print("Введите стаж (лет): ");
            int yrs = scanner.nextInt();

            double[] result = salary.Annual(monthly, yrs);

            System.out.printf("Годовой доход: %.2f%n", result[0]);
            System.out.printf("Страховка: %.2f%n", result[1]);
            System.out.printf("Подоходный налог: %.2f%n", result[2]);
            System.out.printf("Необлагаемый минимум: %.2f%n", result[3]);
            

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введите только числовые значения.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e.getMessage());
        }
    }
}
