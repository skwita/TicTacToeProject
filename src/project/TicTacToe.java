package project;

public class TicTacToe {
    private int size;
    private String[][] board;

    private TicTacToe(int size) {
        this.board = new String[size][size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = "_";
            }
        }
    }



    private static void PrintCanvas(TicTacToe test) {
        for (int i = 0; i < test.size; i++) {
            for (int j = 0; j < test.size; j++) {
                System.out.print(test.board[i][j] + "  ");
            }
            System.out.print("\n");
        }
    }

    private static void SetCross(int x, int y, TicTacToe test) {
        if (test.board[x-1][y-1].equals("_") && x < test.size && y < test.size) {
            test.board[x-1][y-1] = "X";
        }
    }

    private static void SetNought (int x, int y, TicTacToe test) {
        if (test.board[x-1][y-1].equals("_") && x < test.size && y < test.size) {
            test.board[x-1][y-1] = "O";
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(10);
        PrintCanvas(game);
        System.out.println();
        SetCross(1,2, game);
        SetNought(4, 3, game);
        PrintCanvas(game);
    }


}
