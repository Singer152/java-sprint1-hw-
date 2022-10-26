import java.util.Scanner;

public class Praktikum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();


        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                System.out.println("Введите месяц в году.");
                int monthInput = scanner.nextInt();
                if (monthInput < 1 | monthInput > 12) {
                    System.out.println("Введен не правильный номер месяца");
                } else {
                    System.out.println("Выбирите день в который хотите занести данные");
                    int day = scanner.nextInt();
                    if (day < 1 | day > 30) {
                        System.out.println("Введен не правильный номер дня");
                    } else {
                        System.out.println("Введите количество шагов");
                        int steps = scanner.nextInt();
                        stepTracker.saveStep(monthInput, day, steps);
                    }
                }
            } else if (userInput == 2) {
                System.out.println("За какой месяц показать статистику?");
                int monthInput = scanner.nextInt();
                if (monthInput < 1 || monthInput > 12) {
                    System.out.println("Введено некорректное значение.");
                } else {
                    stepTracker.printStatistic(monthInput);
                }
            } else if (userInput == 3) {
                System.out.println("Какую цель вы хотите себе поставить?");
                int Step = scanner.nextInt();
                stepTracker.newGoalStep(Step);
            } else if (userInput == 4) {
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов в определенный день");
        System.out.println("2 - Напечатать статистику за определенный месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выход");
    }
}