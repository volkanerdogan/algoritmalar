import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    final int chessRows = 8;
    final int chessColumns = 8;
    String[][] chessTable = new String[8][8];
    int[][] chessTableCalculate = new int[8][8];
    boolean[][] chessTableMoved = new boolean[8][8];

    public static void main(String[] args) {
        Main demo = new Main();
        demo.initilazeTable();
        demo.printTableToConsole();
        System.out.println("");
        demo.calculateAccessPointsToCell();
        demo.printCalculatedTableToConsole();
        demo.start();
    }

    public void initilazeTable() {
        for (int i = 0; i < chessRows; i++) {
            for (int j = 0; j < chessColumns; j++) {
                chessTable[i][j] = "[" + i + "," + j + "]";
            }
        }
    }

    public void printTableToConsole() {
        for (int i = 0; i < chessRows; i++) {
            for (int j = 0; j < chessColumns; j++) {
                System.out.print(chessTable[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void calculateAccessPointsToCell() {
        for (int i = 0; i < chessRows; i++) {
            for (int j = 0; j < chessColumns; j++) {
                int accessPoint = 0;
                if (((i + 2) <= 7 && (i + 2) >= 0) && ((j + 1) <= 7 && (j + 1) > 0)) {
                    accessPoint += 1;
                }
                if (((i + 2) <= 7 && (i + 2) >= 0) && ((j - 1) <= 7 && (j - 1) > 0)) {
                    accessPoint += 1;
                }
                if (((i - 2) <= 7 && (i - 2) >= 0) && ((j + 1) <= 7 && (j + 1) > 0)) {
                    accessPoint += 1;
                }
                if (((i - 2) <= 7 && (i - 2) >= 0) && ((j - 1) <= 7 && (j - 1) > 0)) {
                    accessPoint += 1;
                }


                if (((i + 1) <= 7 && (i + 1) >= 0) && ((j + 2) <= 7 && (j + 2) > 0)) {
                    accessPoint += 1;
                }
                if (((i + 1) <= 7 && (i + 1) >= 0) && ((j - 2) <= 7 && (j - 2) > 0)) {
                    accessPoint += 1;
                }
                if (((i - 1) <= 7 && (i - 1) >= 0) && ((j + 2) <= 7 && (j + 2) > 0)) {
                    accessPoint += 1;
                }
                if (((i - 1) <= 7 && (i - 1) >= 0) && ((j - 2) <= 7 && (j - 2) > 0)) {
                    accessPoint += 1;
                }
                chessTableCalculate[i][j] = accessPoint;
            }
        }
    }


    public void printCalculatedTableToConsole() {
        for (int i = 0; i < chessRows; i++) {
            for (int j = 0; j < chessColumns; j++) {
                System.out.print(chessTableCalculate[i][j] + " ");
            }
            System.out.println("");
        }
    }


    public int[] pickMinimum(int row, int column) {
        int[] cell = {-1, -1};
        int min = 10;
        if (((row + 2) <= 7 && (row + 2) >= 0) && ((column + 1) <= 7 && (column + 1) >= 0)
                && chessTableCalculate[row + 2][column + 1] != 0 && chessTableCalculate[row + 2][column + 1] < min
                && !chessTableMoved[row + 2][column + 1]) {
            min = chessTableCalculate[row + 2][column + 1];
            cell[0] = (row + 2);
            cell[1] = (column + 1);
        }
        if (((row + 2) <= 7 && (row + 2) >= 0) && ((column - 1) <= 7 && (column - 1) >= 0)
                && chessTableCalculate[row + 2][column - 1] != 0 && chessTableCalculate[row + 2][column - 1] < min
                && !chessTableMoved[row + 2][column - 1]) {
            min = chessTableCalculate[row + 2][column - 1];
            cell[0] = (row + 2);
            cell[1] = (column - 1);
        }
        if (((row - 2) <= 7 && (row - 2) >= 0) && ((column + 1) <= 7 && (column + 1) >= 0)
                && chessTableCalculate[row - 2][column + 1] != 0 && chessTableCalculate[row - 2][column + 1] < min
                && !chessTableMoved[row - 2][column + 1]) {
            min = chessTableCalculate[row - 2][column + 1];
            cell[0] = (row - 2);
            cell[1] = (column + 1);
        }
        if (((row - 2) <= 7 && (row - 2) >= 0) && ((column - 1) <= 7 && (column - 1) >= 0)
                && chessTableCalculate[row - 2][column - 1] != 0 && chessTableCalculate[row - 2][column - 1] < min
                && !chessTableMoved[row - 2][column - 1]) {
            min = chessTableCalculate[row - 2][column - 1];
            cell[0] = (row - 2);
            cell[1] = (column - 1);
        }

        if (((row + 1) <= 7 && (row + 1) >= 0) && ((column + 2) <= 7 && (column + 2) >= 0)
                && chessTableCalculate[row + 1][column + 2] != 0 && chessTableCalculate[row + 1][column + 2] < min
                && !chessTableMoved[row + 1][column + 2]) {
            min = chessTableCalculate[row + 1][column + 2];
            cell[0] = (row + 1);
            cell[1] = (column + 2);
        }
        if (((row + 1) <= 7 && (row + 1) >= 0) && ((column - 2) <= 7 && (column - 2) >= 0)
                && chessTableCalculate[row + 1][column - 2] != 0 && chessTableCalculate[row + 1][column - 2] < min
                && !chessTableMoved[row + 1][column - 2]) {
            min = chessTableCalculate[row + 1][column - 2];
            cell[0] = (row + 1);
            cell[1] = (column - 2);
        }
        if (((row - 1) <= 7 && (row - 1) >= 0) && ((column + 2) <= 7 && (column + 2) >= 0)
                && chessTableCalculate[row - 1][column + 2] != 0 && chessTableCalculate[row - 1][column + 2] < min
                && !chessTableMoved[row - 1][column + 2]) {
            min = chessTableCalculate[row - 1][column + 2];
            cell[0] = (row - 1);
            cell[1] = (column + 2);
        }
        if (((row - 1) <= 7 && (row - 1) >= 0) && ((column - 2) <= 7 && (column - 2) >= 0)
                && chessTableCalculate[row - 1][column - 2] != 0 && chessTableCalculate[row - 1][column - 2] < min
                && !chessTableMoved[row - 1][column - 2]) {
            min = chessTableCalculate[row - 1][column - 2];
            cell[0] = (row - 1);
            cell[1] = (column - 2);
        } else {
        }
        return cell;

    }

    int movementCounter = 0;

    public void start() {
        Random rnd = new Random();
        int initRow = rnd.nextInt(8);
        int initCol = rnd.nextInt(8);
        recursive(initRow, initCol);

        printTableToConsole();
        System.out.println("Init" + initRow + " " + initCol);
    }

    private void recursive(int initRow, int initCol) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chessTableCalculate[initRow][initCol] -= 1;
        chessTableMoved[initRow][initCol] = true;
        movementCounter += 1;

        System.out.println("Move :" + movementCounter);
        System.out.println(" ");

        if (movementCounter != 64) {
            chessTable[initRow][initCol] = printMovement(movementCounter);
            int nextMove[] = pickMinimum(initRow, initCol);
            printTableToConsole(initRow, initCol);
            recursive(nextMove[0], nextMove[1]);
        }
    }

    private void printTableToConsole(int initRow, int initCol) {
        for (int i = 0; i < chessRows; i++) {
            for (int j = 0; j < chessColumns; j++) {
                if (initRow == i && initCol == j) {
                    String s = (char) 27 + "[41m";
                    s += chessTable[i][j] + " ";
                    s = s + (char) 27 + "[0m";
                    System.out.print(s);
                } else {
                    if (!chessTable[i][j].contains("[")) {
                        String s = (char) 27 + "[42m";
                        s += chessTable[i][j] + " ";
                        s = s + (char) 27 + "[0m";
                        System.out.print(s);
                    } else {
                        System.out.print(chessTable[i][j] + " ");
                    }
                }
            }
            System.out.println("");
        }
    }

    private String printMovement(int movementCounter) {
        String s = "";
        if (movementCounter < 10) {
            s += "  " + movementCounter + "  ";
        } else {
            s += "  " + movementCounter + " ";
        }
        return s;
    }
}
