import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        // переменную sumOfAmount можно назвать просто amount - здесь нет суммы - исправил
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundNumber(pay, 2); // перед return вроде не надо ставить пустую строку - да, ставил разрыв,
                                          // как перед блоком переменных и основного тела метода, но тут точно не нужно
    }

    double calculateSimplePercent(double sumOfAmount, double yearRate, int depositPeriod) {
        double pay = sumOfAmount + sumOfAmount * yearRate * depositPeriod;
        return roundNumber(pay, 2);
    }

    double roundNumber(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() { // мне кажется, что название get.. не подходит, потому что метод ничего не возвращает
        int period;
        int action;
        double finalSumDeposit = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action == 1) {
            finalSumDeposit = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            finalSumDeposit = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + finalSumDeposit);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }

}
