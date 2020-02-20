package project;

class TicTacToe {
    private int size;
    String[][] board;

    TicTacToe(int size) {
        this.board = new String[size][size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[j][i] = "_";
            }
        }
    }

    private static void printCanvas(TicTacToe test) {
        for (int i = 0; i < test.size; i++) {
            for (int j = 0; j < test.size; j++) {
                System.out.print(test.board[j][i] + "  ");
            }
            System.out.print("\n");
        }
    }

    static void setCross(int x, int y, TicTacToe test) {
        if (test.board[x-1][y-1].equals("_")) {
            test.board[x-1][y-1] = "X";
        }
    }

    static void setNought (int x, int y, TicTacToe test) {
        if (test.board[x-1][y-1].equals("_")) {
            test.board[x-1][y-1] = "O";
        }
    }

    static void clear (int x, int y, TicTacToe test) {
            test.board[x-1][y-1] = "_";
    }

    private static int[][] maxLengthCrossCheck(TicTacToe test){
        int[] firstCurrentPos = new int[] {0, 0};
        int[] secondCurrentPos = new int[] {0, 0};
        int[] firstMaxPos = new int[] {0, 0};
        int[] secondMaxPos = new int[] {0, 0};
        for (int i = 0; i < test.size; i++) {
            for (int j = 0; j < test.size; j++) {

            }
        }
        return new int[][] {firstMaxPos, secondMaxPos};
    }
}
