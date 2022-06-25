package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        // Input
        Scanner scanner = new Scanner(System.in);
        // String input = scanner.nextLine();
        char[][] array = new char[3][3];
        // int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ' '; // input.charAt(count);
                // count++;
            }
        }
        // Output Grid
        System.out.println("---------");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                System.out.print(array[i][j] + " ");
                if (j + 1 == array[i].length) {
                    System.out.println("|");
                }
            }
        }
        System.out.println("---------");

        // Promt "Make move"

        //int k = 0;
        boolean ifInRange = false;
        boolean ifUsed = false;
        boolean isXsesMove = false;
        boolean notFinished = false;
        int xCoor;
        int yCoor;

        do {
            do {
                System.out.print("Enter the coordinates: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("You should enter numbers!");
                    scanner.next();
                }

                xCoor = scanner.nextInt();
                yCoor = scanner.nextInt();

                ifInRange = xCoor > 0 && xCoor < 4 && yCoor > 0 && yCoor < 4;

                if (!ifInRange) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    ifUsed = array[xCoor - 1][yCoor - 1] != ' ';

                    if (ifUsed) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        array[xCoor - 1][yCoor - 1] = isXsesMove ? 'X' : 'O';
                        isXsesMove = !isXsesMove;
                    }
                }

            } while (!ifInRange || ifUsed);


            // Output updated grid

            System.out.println("---------");
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (j == 0) {
                        System.out.print("| ");
                    }
                    System.out.print(array[i][j] + " ");
                    if (j + 1 == array[i].length) {
                        System.out.println("|");
                    }
                }
            }
            System.out.println("---------");

            // Analyze ond output result
            // Game not finished
            notFinished = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] == ' ') {
                        notFinished = true;
                    }
                }
            }

            // xWins oWins
            //Horisontal
            boolean rowX1 = false;
            boolean rowX2 = false;
            boolean rowO1 = false;
            boolean rowO2 = false;
            for (int i = 0; i < 3; i++) {
                rowX1 = (array[i][0] == 'X' && array[i][1] == 'X' && array[i][2] == 'X');
                if (rowX1) {
                    break;
                }
            }
            for (int i = 0; i < 3; i++) {
                rowO1 = (array[i][0] == 'O' && array[i][1] == 'O' && array[i][2] == 'O');
                if (rowO1) {
                    break;
                }
            }
            //Vertical
            for (int j = 0; j < 3; j++) {
                rowX2 = (array[0][j] == 'X' && array[1][j] == 'X' && array[2][j] == 'X');
                if (rowX2) {
                    break;
                }
            }
            for (int j = 0; j < 3; j++) {
                rowO2 = (array[0][j] == 'O' && array[1][j] == 'O' && array[2][j] == 'O');
                if (rowO2) {
                    break;
                }
            }
            //Diagonal
            boolean diagX1 = (array[0][0] == 'X' && array[1][1] == 'X' && array[2][2] == 'X');
            boolean diagX2 = (array[0][2] == 'X' && array[1][1] == 'X' && array[2][0] == 'X');
            boolean diagO1 = (array[0][0] == 'O' && array[1][1] == 'O' && array[2][2] == 'O');
            boolean diagO2 = (array[0][2] == 'O' && array[1][1] == 'O' && array[2][0] == 'O');

            boolean xWins = rowX1 || rowX2 || diagX1 || diagX2;
            boolean oWins = rowO1 || rowO2 || diagO1 || diagO2;

            // Draw
            boolean isDraw = (!xWins && !oWins && !notFinished);
            // Impossible
            int countX = 0;
            int countO = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] == 'X') {
                        countX++;
                    }
                    if (array[i][j] == 'O') {
                        countO++;
                    }
                }
            }
            boolean differenceXO;
            if (countX > countO) {
                differenceXO = (countX - countO) >= 2;
            } else {
                differenceXO = (countO - countX) >= 2;
            }
            boolean isImpossible = (xWins && oWins) || differenceXO;

            //Output result
            if (isImpossible) {
                System.out.println("Impossible");
                break;
            } else if (isDraw) {
                System.out.println("Draw");
                break;
            } else if (xWins) {
                System.out.println("X wins");
                break;
            } else if (oWins) {
                System.out.println("O wins");
                break;
            } /* else if (notFinished) {
            System.out.println("Game not finished");
        } */
        } while (notFinished);
    }
}
