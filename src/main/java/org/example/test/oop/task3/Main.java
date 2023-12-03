package org.example.test.oop.task3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

// Игра крестики нолики

public class Main {
    // Инициализация игрового поля и игрока
    static String[] board;
    static String player;

    // Метод для вывода игрового поля
    static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }

    // Метод для проверки победителя
    static String checkWinner() {
        // Перебор всех возможных выигрышных комбинаций
        for (int a = 0; a < 8; a++) {
            String line = null;

            // Возможные комбинации
            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            /*
            Если найдена строка с тремя 'X' подряд - вернуть 'X'
            Иначе, если найдена строка с тремя '0' - вернуть '0'
            */
            if (line.equals("XXX")) {
                return "X";
            }
            else if (line.equals("000")) {
                return "0";
            }
        }

        /*
        Если на этом этапе нет победителя, цикл проверит, есть ли
        незаполненные клетки на игровой доске.  Он использует метод
        Arrays.asList(board).contains(String.valueOf(a + 1)),
        чтобы проверить, есть ли в массиве board символы, представляющие незаполненные клетки.
        Если все клетки заполнены - ничья.
        */
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "Ничья";
            }
        }

        System.out.println(player + " ходит, введите номер ячейки:");
        return null;
    }

    public static void main(String[] args) {
        // Создание игрового поля 3x3, игрока и победителя.
        Scanner in = new Scanner(System.in);
        board = new String[9];
        player = "X";
        String winner = null;

        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }

        // Приветствие и генерация игрового поля
        System.out.println("КРЕСТИКИ-НОЛИКИ");
        printBoard();

        System.out.println("'X' ходит первым. Введи номер ячейки, в которое поместишь 'X':");

        /*
        Затем игроку X предлагается ввести номер поля, в которое он хочет поместить свой символ X.
        В цикле `while` проверяется условие, что переменная `winner` равна `null`,
        то есть игра продолжается, пока нет победителя.
        */
        while (winner == null) {
            int numInput;

            try {
                numInput = in.nextInt();
                // Проверка на корректность ввода
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Неверный ввод. Введите номер ячейки заново:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Введите номер ячейки заново:");
                continue;
            }

            /*
            Если введенная ячейка свободна, то символ текущего хода (X или 0) помещается
            в выбранное поле массива board.
            */
            if (board[numInput - 1].equals(String.valueOf(numInput))) {
                board[numInput - 1] = player;

                if (player.equals("X")) {
                    player = "O";
                } else {
                    player = "X";
                }

                // Обновление доски и проверка победителя
                printBoard();
                winner = checkWinner();
            } else {
                System.out.println("Ячейка занята, введите другой номер:");
            }
        }

        /*
        После окончания цикла проверяется значение переменной winner.
        Если значение равно "Ничья", выводится сообщение о ничьей.
        В противном случае, выводится сообщение о победе (X или O)*/
        if (winner.equalsIgnoreCase("Ничья")) {
            System.out.println("Ничья!");
        } else {
            System.out.println("Поздравляем! " + winner + " победил!");
        }
        in.close();
    }
}
