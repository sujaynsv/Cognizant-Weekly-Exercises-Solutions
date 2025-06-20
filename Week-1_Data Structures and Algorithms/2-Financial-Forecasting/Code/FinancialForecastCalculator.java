// Utility class for performing financial forecasting calculations
public class FinancialForecastCalculator {

    /**
     * Calculates future value using recursion.
     * 
     * @param principal   The initial investment amount
     * @param growthRate  The growth rate per period (e.g. 5% → 0.05)
     * @param totalPeriods Number of periods (e.g. years)
     * @return Future value after all periods
     */
    public static double calculateFutureValue(double principal, double growthRate, int totalPeriods) {
        if (totalPeriods == 0) {
            return principal;
        }
        double previousValue = calculateFutureValue(principal, growthRate, totalPeriods - 1);
        return previousValue * (1 + growthRate);
    }

    public static void main(String[] args) {
        double initialInvestment = 1000.0;
        double annualGrowthRate = 0.05;
        int years = 10;

        double futureValue = calculateFutureValue(initialInvestment, annualGrowthRate, years);
        System.out.printf("Future value after %d years: %.2f%n", years, futureValue);
    }
}
