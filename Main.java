package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Задание 1: Расчет количества дней в году");
        System.out.println("Введите год в формате yyyy");
        int year = scanner.nextInt();
        int days = getDaysInYear(year);
        System.out.println("Количество дней " + days);

        System.out.println("\n" + "=".repeat(50) + "\n");

        System.out.println("Задание 2: Игра 'Угадай количество дней в году'");
        System.out.println("Вводите год и количество дней через пробел (например: 2000 366)");
        System.out.println("Для выхода введите любой нечисловой символ");

        playGame(scanner);

        scanner.close();
    }

    public static int getDaysInYear(int year) {
        if (year % 400 == 0) {
            return 366;
        } else if (year % 100 == 0) {
            return 365;
        } else if (year % 4 == 0) {
            return 366;
        } else {
            return 365;
        }
    }

    public static void playGame(Scanner scanner) {
        int score = 0;

        while (true) {
            try {
                System.out.print("\nВведите год и количество дней: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Игра завершена.");
                    break;
                }

                int year = scanner.nextInt();

                if (!scanner.hasNextInt()) {
                    System.out.println("Игра завершена.");
                    break;
                }

                int userDays = scanner.nextInt();

                int correctDays = getDaysInYear(year);

                if (userDays == correctDays) {
                    score++;
                    System.out.println("Правильно! Переходим к следующему году.");
                } else {
                    System.out.println("Неправильно! В " + year + " году " + correctDays + " дней!");
                    System.out.println("Набрано очков: " + score);
                    break;
                }

            } catch (Exception e) {
                System.out.println("Ошибка ввода. Игра завершена.");
                System.out.println("Набрано очков: " + score);
                break;
            }
        }
    }
}