package project;

import java.util.*;

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

    static ArrayList<ArrayList<Integer>> maxLengthCheck(TicTacToe test, String Symbol) {
        ArrayList<ArrayList<Integer>> horizontalSequence;
        ArrayList<ArrayList<Integer>> verticalSequence;
        ArrayList<ArrayList<Integer>> diagonalSequence;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        horizontalSequence = horizontalCheck(test, Symbol);
        verticalSequence = verticalCheck(test, Symbol);
        diagonalSequence = diagonalCheck(test, Symbol);

        int maximum = Math.max(horizontalSequence.size(),Math.max(verticalSequence.size(),diagonalSequence.size()));
        if (maximum == horizontalSequence.size()) {
            result = horizontalSequence;
        }
        if (maximum == verticalSequence.size()) {
            result = verticalSequence;
        }
        if (maximum == diagonalSequence.size()) {
            result = diagonalSequence;
        }
        return result;
    }

    private static ArrayList<ArrayList<Integer>> horizontalCheck(TicTacToe test, String Symbol) {
        ArrayList<Integer> tempSequence = new ArrayList<>();
        ArrayList<ArrayList<Integer>> currentSequence = new ArrayList<>();
        ArrayList<ArrayList<Integer>> maxSequence = new ArrayList<>();
        int maxLength = 0;
        int length = 0;
        for (int i = 0; i < test.size; i++) {
            for (int j = 0; j < test.size - 1; j++) {
                if (test.board[j][i].equals(Symbol)) {
                    if ((test.board[j][i].equals(test.board[j + 1][i]))) {
                        length++;
                        tempSequence.add(j);
                        tempSequence.add(i);
                        currentSequence.add(tempSequence);
                        tempSequence.clear();
                        if (j + 1 == test.size - 1) {
                            tempSequence.add(j + 1);
                            tempSequence.add(i);
                            currentSequence.add(tempSequence);
                            tempSequence.clear();
                        }
                    } else {
                        if (length > maxLength) {
                            maxLength = length;
                            length = 0;
                            maxSequence = currentSequence;
                        }
                        currentSequence.clear();
                    }
                }
            }
            if (length > maxLength) {
                maxLength = length;
                length = 0;
                maxSequence = currentSequence;
            }
            currentSequence.clear();
        }
        return maxSequence;
    }

    private static ArrayList<ArrayList<Integer>> verticalCheck(TicTacToe test, String Symbol) {
        ArrayList<Integer> tempSequence = new ArrayList<>();
        ArrayList<ArrayList<Integer>> currentSequence = new ArrayList<>();
        ArrayList<ArrayList<Integer>> maxSequence = new ArrayList<>();
        int maxLength = 0;
        int length = 0;
        for (int i = 0; i < test.size - 1; i++) {
            for (int j = 0; j < test.size; j++) {
                if (test.board[j][i].equals(Symbol)) {
                    if ((test.board[j][i].equals(test.board[j][i + 1]))) {
                        length++;
                        tempSequence.add(j);
                        tempSequence.add(i);
                        currentSequence.add(tempSequence);
                        tempSequence.clear();
                        if (i + 1 == test.size - 1) {
                            tempSequence.add(j);
                            tempSequence.add(i + 1);
                            currentSequence.add(tempSequence);
                            tempSequence.clear();
                        }
                    } else {
                        if (length > maxLength) {
                            maxLength = length;
                            length = 0;
                            maxSequence = currentSequence;
                        }
                        currentSequence.clear();
                    }
                }
            }
            if (length > maxLength) {
                maxLength = length;
                length = 0;
                maxSequence = currentSequence;
            }
            currentSequence.clear();
        }
        return maxSequence;
    }

    private static ArrayList<ArrayList<Integer>> diagonalCheck(TicTacToe test, String Symbol){
        ArrayList<Integer> tempSequence = new ArrayList<>();
        ArrayList<ArrayList<Integer>> currentSequence = new ArrayList<>();
        ArrayList<ArrayList<Integer>> maxSequence = new ArrayList<>();
        int maxLength = -1;
        int length = 0;
        for (int i = test.size - 1; i > 0; i--) { //down to up part 1
            for (int j = 0, x = i; x <= test.size - 1; j++, x++) {
                if(test.board[x][j].equals(Symbol)){
                    length++;
                    tempSequence.add(j);
                    tempSequence.add(i);
                    currentSequence.add(tempSequence);
                    tempSequence.clear();
                    if ((i - 1 == 0) & (j + 1 == test.size)) {
                        tempSequence.add(j + 1);
                        tempSequence.add(i - 1);
                        currentSequence.add(tempSequence);
                        tempSequence.clear();
                    }
                } else{
                    if (length > maxLength) {
                        maxLength = length;
                        length = 0;
                        maxSequence = currentSequence;
                    }
                    currentSequence.clear();
                }
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }

        for (int i = 0; i <= test.size - 1 - 1; i++) {//down to up part 2
            for (int j = 0, y = i; y <= test.size - 1 - 1; j++, y++) {
                if(test.board[j][y].equals(Symbol)){
                    length++;
                }
                else{
                    length = 1;
                }
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }

        for( int k = 0 ; k < test.size ; k++ ) {//up to down part 1
            for( int j = 0 ; j <= k ; j++ ) {
                int i = k - j;
                if(test.board[i][j].equals(Symbol)){
                    length++;
                }
                else{
                    length = 0;
                }
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }

        for (int k = test.size - 2 ; k >= 0 ; k--) { //up to down part 2
            for( int j = 0 ; j <= k ; j++ ) {
                int i = k - j;
                if(test.board[test.size - j - 1][test.size - i - 1].equals(Symbol)){
                    length++;
                }
                else{
                    length = 0;
                }
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxSequence;
    }
}

