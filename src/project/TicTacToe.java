package project;

import java.util.*;

class TicTacToe {
    private final int size;
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

    public static List<List<Integer>> maxLengthCheck(TicTacToe test, String Symbol) {
        List<List<Integer>> horizontalSequence = horizontalCheck(test, Symbol);
        List<List<Integer>> verticalSequence = verticalCheck(test, Symbol);
        List<List<Integer>> diagonalSequence = diagonalCheck(test, Symbol);

        int horizontal = -1;
        if (!horizontalSequence.isEmpty()) {
            if (!horizontalSequence.get(1).isEmpty()) {
                horizontal = horizontalSequence.get(1).get(1) - horizontalSequence.get(0).get(1) + 1;
            }
        }

        int vertical = -1;
        if (!verticalSequence.isEmpty()){
            if (!verticalSequence.get(1).isEmpty()) {
                vertical = verticalSequence.get(1).get(0) - verticalSequence.get(0).get(0) + 1;
            }
        }

        int diagonal = -1;
        if (!diagonalSequence.isEmpty()){
            if (!diagonalSequence.get(1).isEmpty()) {
                diagonal = Math.abs(diagonalSequence.get(1).get(0) - diagonalSequence.get(0).get(0)) + 1;
            }
        }

        int maximum = Math.max(diagonal,(Math.max(vertical, horizontal)));
        List<List<Integer>> maxSequence = new ArrayList<>();

        if (maximum == horizontal) maxSequence = horizontalSequence;
        if (maximum == vertical) maxSequence = verticalSequence;
        if (maximum == diagonal) maxSequence = diagonalSequence;

        return maxSequence;

    }

    private static List<List<Integer>> horizontalCheck(TicTacToe test, String Symbol) {
        int maxLength = 0;
        int length = 0;
        int beginI = -1;
        int beginJ = -1;
        List<Integer> begin = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        for (int i = 0; i < test.size ; i++){
            for (int j = 0; j < test.size; j++) {
                if (test.board[i][j].equals(Symbol)) {
                    length++;
                    if (length == 1) {
                        beginI = i;
                        beginJ = j;
                    }
                    if (j == test.size - 1 || !test.board[i][j].equals(test.board[i][j + 1])) {
                        if (length > maxLength) {
                            maxLength = length;
                            length = 0;
                            begin.clear();
                            begin.add(beginI);
                            begin.add(beginJ);
                            end.clear();
                            end.add(i);
                            end.add(j);
                        }
                    }
                }  else {
                    beginI = -1;
                    beginJ = -1;
                    length = 0;
                }
            }
        }
        return List.of(begin, end);
    }

    private static List<List<Integer>> verticalCheck(TicTacToe test, String Symbol) {
        int maxLength = 0;
        int length = 0;
        int beginI = -1;
        int beginJ = -1;
        List<Integer> begin = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        for (int i = 0; i < test.size ; i++){
            for (int j = 0; j < test.size; j++) {
                if (test.board[j][i].equals(Symbol)) {
                    length++;
                    if (length == 1) {
                        beginJ = j;
                        beginI = i;
                    }
                    if (j == test.size - 1 || !test.board[j][i].equals(test.board[j + 1][i])) {
                        if (length > maxLength) {
                            maxLength = length;
                            begin.clear();
                            begin.add(beginJ);
                            begin.add(beginI);
                            end.clear();
                            end.add(j);
                            end.add(i);
                            length = 0;
                        }
                    }
                } else {
                    beginI = -1;
                    beginJ = -1;
                    length = 0;
                }
            }
        }
        return List.of(begin, end);
    }

    private static List<List<Integer>> diagonalCheck(TicTacToe test, String Symbol){
        int maxLength = 0;
        int length = 0;
        int beginI = -1;
        int beginJ = -1;
        List<Integer> begin = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        for (int i = test.size - 1; i > 0; i--) { //left-up to right-down (bottom)
            for (int j = 0, k = i; k < test.size; j++, k++) {
                if (test.board[k][j].equals(Symbol)){
                    length++;
                    if (length == 1) {
                        beginI = k;
                        beginJ = j;
                    }
                    if (k == test.size - 1 || !test.board[k][j].equals(test.board[k + 1][j + 1])) {
                        if (length > maxLength) {
                            maxLength = length;
                            begin.clear();
                            begin.add(beginI);
                            begin.add(beginJ);
                            end.clear();
                            end.add(k);
                            end.add(j);
                            length = 0;
                        }
                    }
                } else {
                    beginI = -1;
                    beginJ = -1;
                    length = 0;
                }
            }
        }

        for (int i = 0; i < test.size; i++) { //left-up to right-down (mid-top)
            for (int j = 0, k = i; k < test.size; j++, k++) {
                if (test.board[j][k].equals(Symbol)){
                    length++;
                    if (length == 1) {
                        beginJ = j;
                        beginI = k;
                    }
                    if (k == test.size - 1 || !test.board[j][k].equals(test.board[j + 1][k + 1])) {
                        if (length > maxLength) {
                            maxLength = length;
                            begin.clear();
                            begin.add(beginJ);
                            begin.add(beginI);
                            end.clear();
                            end.add(j);
                            end.add(k);
                            length = 0;
                        }
                    }
                } else {
                    beginI = -1;
                    beginJ = -1;
                    length = 0;
                }
            }
        }

        for (int k = 0; k < test.size; k++) { // left-down to right-up (mid-top)
            for (int j = 0; j <= k; j++) {
                int i = k - j;
                if (test.board[i][j].equals(Symbol)){
                    length++;
                    if (length == 1) {
                        beginI = i;
                        beginJ = j;
                    }
                    if (i == 0 || !test.board[i][j].equals(test.board[i - 1][j + 1])) {
                        if (length > maxLength) {
                            maxLength = length;
                            begin.clear();
                            begin.add(beginI);
                            begin.add(beginJ);
                            end.clear();
                            end.add(i);
                            end.add(j);
                            length = 0;
                        }
                    }
                } else {
                    beginI = -1;
                    beginJ = -1;
                    length = 0;
                }
            }
        }

        for (int k = test.size - 2 ; k >= 0 ; k--) { // left-down to right-up (bottom)
            for (int j = 0 ; j <= k ; j++ ) {
                int i = k - j;
                if (test.board[test.size - 1 - j][test.size - 1 - i].equals(Symbol)){
                    length++;
                    if (length == 1) {
                        beginJ = test.size - 1 - j;
                        beginI = test.size - 1 - i;
                    }
                    if (i == 0 ||
                            !test.board[test.size - 1 - j][test.size - 1 - i].equals(test.board[test.size - 2 - j][test.size - i])) {
                        if (length > maxLength) {
                            maxLength = length;
                            begin.clear();
                            begin.add(beginJ);
                            begin.add(beginI);
                            end.clear();
                            end.add(test.size - 1 - j);
                            end.add(test.size - 1 - i);
                            length = 0;
                        }
                    }
                } else {
                    beginI = -1;
                    beginJ = -1;
                    length = 0;
                }
            }
        }

        return List.of(begin, end);
    }
}