package project;

import java.util.*;

class TicTacToe {
    private final int size;
    private final Board[][] board;

    TicTacToe(int n) {
        board = new Board[n][n];
        size = n;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[j][i] = Board.E;
            }
        }
    }

    Board returnValue(int i, int j) {
        return board[i][j];
    }

    void setCross(int x, int y) {
        if (board[x - 1][y - 1].equals(Board.E)) {
            board[x - 1][y - 1] = Board.X;
        }
    }

    void setNought(int x, int y) {
        if (board[x - 1][y - 1].equals(Board.E)) {
            board[x - 1][y - 1] = Board.O;
        }
    }

    void clear(int x, int y) {
        board[x - 1][y - 1] = Board.E;
    }

    public TwoPositions maxLengthCheck(Board Symbol) {
        TwoPositions horizontalSequence = deltaCheck(Symbol, 1, 0);
        TwoPositions verticalSequence = deltaCheck(Symbol, 0, 1);
        TwoPositions diagonalSequence = deltaCheck(Symbol, 1, 1);


        int horizontal = horizontalSequence.length(false);
        int vertical = verticalSequence.length(true);
        int diagonal = diagonalSequence.length(true);
        int maximum = Math.max(diagonal, (Math.max(vertical, horizontal)));

        TwoPositions maxSequence = new TwoPositions();
        if (maximum == horizontal) maxSequence = horizontalSequence;
        if (maximum == vertical) maxSequence = verticalSequence;
        if (maximum == diagonal) maxSequence = diagonalSequence;

        return maxSequence;
    }

    private TwoPositions deltaCheck(Board Symbol, int deltaY, int deltaX) {
        int maxLength = 0;
        int length = 0;
        int beginI = -1;
        int beginJ = -1;
        TwoPositions result = new TwoPositions();
        if (Math.abs(deltaY) != Math.abs(deltaX)) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (deltaY == 1) {
                        if (board[i][j].equals(Symbol)) {
                            length++;
                            if (length == 1) {
                                beginI = i;
                                beginJ = j;
                            }
                            if (i == size - 1 || !board[i][j].equals(board[i][j + 1])) {
                                if (length > maxLength) {
                                    maxLength = length;
                                    length = 0;
                                    result.clear();
                                    result.addStart(beginI, beginJ);
                                    result.addEnd(i, j);
                                }
                            }
                        } else {
                            beginI = -1;
                            beginJ = -1;
                            length = 0;
                        }
                    } else {
                        if (board[j][i].equals(Symbol)) {
                            length++;
                            if (length == 1) {
                                beginI = i;
                                beginJ = j;
                            }
                            if (j == size - 1 || !board[j][i].equals(board[j + 1][i])) {
                                if (length > maxLength) {
                                    maxLength = length;
                                    length = 0;
                                    result.clear();
                                    result.addStart(beginJ, beginI);
                                    result.addEnd(j, i);
                                }
                            }
                        } else {
                            beginI = -1;
                            beginJ = -1;
                            length = 0;
                        }
                    }
                }
            }
        } else {
            for (int i = size - 1; i > 0; i--) { //left-up to right-down (bottom)
                for (int j = 0, k = i; k < size; j++, k++) {
                    if (board[k][j].equals(Symbol)) {
                        length++;
                        if (length == 1) {
                            beginI = k;
                            beginJ = j;
                        }
                        if (k == size - 1 || !board[k][j].equals(board[k + 1][j + 1])) {
                            if (length > maxLength) {
                                maxLength = length;
                                result.clear();
                                result.addStart(beginI, beginJ);
                                result.addEnd(k, j);
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

            for (int i = 0; i < size; i++) { //left-up to right-down (mid-top)
                for (int j = 0, k = i; k < size; j++, k++) {
                    if (board[j][k].equals(Symbol)) {
                        length++;
                        if (length == 1) {
                            beginJ = j;
                            beginI = k;
                        }
                        if (k == size - 1 || !board[j][k].equals(board[j + 1][k + 1])) {
                            if (length > maxLength) {
                                maxLength = length;
                                result.clear();
                                result.addStart(beginJ, beginI);
                                result.addEnd(j, k);
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

            for (int k = 0; k < size; k++) { // left-down to right-up (mid-top)
                for (int j = 0; j <= k; j++) {
                    int i = k - j;
                    if (board[i][j].equals(Symbol)) {
                        length++;
                        if (length == 1) {
                            beginI = i;
                            beginJ = j;
                        }
                        if (i == 0 || !board[i][j].equals(board[i - 1][j + 1])) {
                            if (length > maxLength) {
                                maxLength = length;
                                result.clear();
                                result.addStart(beginI, beginJ);
                                result.addEnd(i, j);
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

            for (int k = size - 2; k >= 0; k--) { // left-down to right-up (bottom)
                for (int j = 0; j <= k; j++) {
                    int i = k - j;
                    if (board[size - 1 - j][size - 1 - i].equals(Symbol)) {
                        length++;
                        if (length == 1) {
                            beginJ = size - 1 - j;
                            beginI = size - 1 - i;
                        }
                        if (i == 0 ||
                                !board[size - 1 - j][size - 1 - i].equals(board[size - 2 - j][size - i])) {
                            if (length > maxLength) {
                                maxLength = length;
                                result.clear();
                                result.addStart(beginJ, beginI);
                                result.addEnd(size - 1 - j, size - 1 - i);
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
        }
        return result;
    }
}