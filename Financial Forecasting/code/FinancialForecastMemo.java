import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FinancialForecastMemo {

    public static double forecast(double value, double rate, int years, Map<Integer, Double> memo) {
        if (years == 0) {
            return value;
        }
        if (memo.containsKey(years)) {
            return memo.get(years);
        }

        double result = forecast(value * (1 + rate), rate, years - 1, memo);
        memo.put(years, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter current value: ");
        double value = sc.nextDouble();

        System.out.print("Enter growth rate (e.g., 0.05 for 5%): ");
        double rate = sc.nextDouble();

        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        Map<Integer, Double> memo = new HashMap<>();
        double futureValue = forecast(value, rate, years, memo);

        System.out.printf("Forecasted value after %d years: %.2f\n", years, futureValue);

        sc.close();
    }
}