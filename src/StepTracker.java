public class StepTracker {

    MonthData[] monthToData;
    Converter converter = new Converter();
    int goalStep = 10000;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {
        int[] days = new int[30];
    }

    void printStat(int month) {
        for (int i = 0; i < monthToData[month + 1].days.length; i++) {
            System.out.print("День " + (i + 1) + ": " + monthToData[month - 1].days[i] + ", ");
        }
    }


    void saveStep(int month, int day, int steps) {
        if (steps < 0) {
            System.out.println("Введено некорректное значение!");
        } else {
            monthToData[month - 1].days[day - 1] = monthToData[month - 1].days[day - 1] + steps;
            System.out.println("Значение сохранено");
        }
    }

    int sumSteps(int month) {
        int sum = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            sum += monthToData[month - 1].days[i];
        }
        return sum;
    }

    int averageStep(int month) {
        int sum = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            sum += monthToData[month - 1].days[i];
        }
        return sum / 30;
    }

    double distanceMonth(int month) {
        int sum = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            sum += monthToData[month - 1].days[i];
        }
        double distance = converter.distance(sum);
        return distance;
    }

    double kcal (int month) {
        int sum = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            sum += monthToData[month - 1].days[i];
        }
        double burnKcal = converter.burnKilocalories(sum);
        return burnKcal;
    }

    int maxSteps(int month) {
        int maxStep = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            if (monthToData[month - 1].days[i] > maxStep) {
                maxStep = monthToData[month - 1].days[i];
            }
        }
        return maxStep;
    }

    int seriesStep(int month) {
        int countDays = 0;
        int maxCountDays = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            if (monthToData[month - 1].days[i] >= goalStep) {
                countDays += 1;
            } else {
                if (countDays > maxCountDays) {
                    maxCountDays = countDays;
                }
                countDays = 0;
            }
        }
        return maxCountDays;
    }

    void newGoalStep(int step) {
        if (step < 0) {
            System.out.println("Введите положительное значение.");
        } else {
            goalStep = step;
            System.out.println("Значение изменено.");
        }
    }

    void printStatistic(int month) {
        System.out.println("1. Количество пройденных шагов за месяц: ");
        printStat(month);
        System.out.println("2. Общее количество шагов за месяц: " +
                sumSteps(month));
        System.out.println("3. Максимальное количество пройденных шагов за месяц: " +
                maxSteps(month));
        System.out.println("4. Среднее количество шагов за месяц: " +
                averageStep(month));
        System.out.println("5. Пройденная дистанция за месяц: " +
                distanceMonth(month) + " км.");
        System.out.println("6. Количество сожженых килокалориев: " +
                kcal(month));
        System.out.println("7. Лучшая серия дней: " +
                seriesStep(month));
    }
}