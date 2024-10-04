import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер головоломки: ");
        int size = scanner.nextInt();

        FifteenPuzzle puzzle = new FifteenPuzzle(size);
        puzzle.printGameBoard();

        while (!puzzle.decisionMade()) {
            System.out.print("Введите номер для перемещения: ");
            int tileToMove = scanner.nextInt();
            if (puzzle.moveSpecificTile(tileToMove)) {
                puzzle.printGameBoard();
            } else {
                System.out.println("Невозможно выполнить ход");
            }
        }

        System.out.println("Поздравляю, головоломка решена!");
        scanner.close();
    }
}