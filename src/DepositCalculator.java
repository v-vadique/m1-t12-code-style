import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int period) {
        double outcome = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return roundSum(outcome, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return roundSum(amount + amount * yearRate * period, 2);
    }

    double roundSum(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateOutcome() {
        int period;
        int type;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        type = scanner.nextInt();
        double outcome = 0;
        if (type ==1) {
            outcome = calculateSimplePercent(amount, 0.06, period);
        }
        else if (type == 2) {
            outcome = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outcome);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateOutcome();
    }
}
