public class AnnualSalary {

    /*
     * aastatuluga kuni 14 400 eurot on maksuvaba tulu aastas 7848 eurot;
     * aastatulu kasvades 14 400 eurolt 25 200 euroni väheneb maksuvaba tulu
     * vastavalt valemile 7848 – 7848 ÷ 10 800 × (tulu summa – 14 400);
     * aastatuluga üle 25 200 euro on maksuvaba tulu 0.
     */

    // yrs = стаж страхования от безработицы
    public double[] Annual(double monthly, int yrs) {
        // Годовой доход
        double annual = monthly * 12;
        double taxFree = 0;

        // Налоговый вычет в зависимости от годового дохода
        if (annual <= 14400.0) {
            taxFree = 7848.0;
        } else if (annual > 14400 && annual <= 25200) {
            taxFree = 7848 - (7848 / 10800) * (annual - 14400);
        }

        // Компенсационные дни в зависимости от стажа
        int compensationDays = 0;
        if (yrs < 5) {
            compensationDays = 180;
        } else if (yrs < 10) {
            compensationDays = 210;
        } else if (yrs >= 10) {
            compensationDays = 300;
        }

        // Дневной доход
        double daily = monthly / 30.0;

        // Страховка
        // Умножаем дневной доход на 0.6 и 0.4 в зависимости от компенсационных дней
        double insurance = daily * 0.6 * 100 + daily * 0.4 * compensationDays;

        // Подоходный налог
        double tax = (annual - taxFree) * 0.22;  // Налог на оставшуюся сумму

        // Возвращаем массив с результатами
        double[] arr = {annual, insurance, tax};
        return arr;
    }

    public static void main(String[] args) {
        AnnualSalary salary = new AnnualSalary();
        

        double[] result = salary.Annual(2000, 4);
        
        // Вывод результата
        System.out.println("Годовой доход: " + result[0]);
        System.out.println("Страховка: " + result[1]);
        System.out.println("Подоходный налог: " + result[2]);
    }
}
