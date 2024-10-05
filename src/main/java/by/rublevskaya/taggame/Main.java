package by.rublevskaya.taggame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер головоломки: ");
        int size = scanner.nextInt();

        FifteenPuzzle puzzle = new FifteenPuzzle(size);
        printGameBoard(puzzle.board);

        while (!puzzle.decisionMade()) {
            System.out.print("Введите номер для перемещения: ");
            int tileToMove = scanner.nextInt();
            if (puzzle.moveSpecificTile(tileToMove)) {
                printGameBoard(puzzle.board);
            } else {
                System.out.println("Невозможно выполнить ход");
            }
        }
        System.out.println("Поздравляю, головоломка решена!");
        scanner.close();

    }
    public static void printGameBoard(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.printf("%2d ", board[row][col]);
            }
            System.out.println();
        }
    }
}