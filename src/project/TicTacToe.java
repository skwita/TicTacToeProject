package project;

import javax.swing.text.Position;
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

    static int[][] maxLengthCheck(TicTacToe test, String Symbol) {

        int[][][] crossSequences = new int[pow(test.size)][test.size][2];

        boolean isGoing = true;
        int SequenceNumber = 0;
        int CordsPosition = 0;
        while (isGoing) { //horizontal check
            for (int i = 0; i < test.size; i++){
                for (int j = 0; j < test.size - 1; j++) {
                    if (test.board[j][i].equals(Symbol)){
                        if ((test.board[j][i].equals(test.board[j + 1][i]))) {
                            crossSequences[SequenceNumber][CordsPosition][0] = j;
                            crossSequences[SequenceNumber][CordsPosition][1] = i;
                            CordsPosition++;
                            if ((test.board[j + 1][i].equals(Symbol)) & (j + 1 == test.size - 1)) {
                                crossSequences[SequenceNumber][CordsPosition][0] = i;
                                crossSequences[SequenceNumber][CordsPosition][1] = j + 1;
                                SequenceNumber++;
                                CordsPosition = 0;
                            }
                            if (((test.size - 1) == i) & (i == j)) isGoing = false;
                        } else {
                            crossSequences[SequenceNumber][CordsPosition][0] = j;
                            crossSequences[SequenceNumber][CordsPosition][1] = i;
                            SequenceNumber++;
                            CordsPosition = 0;
                        }
                    }
                }
            }
        }

        isGoing = true;
        while (isGoing) { //vertical check
            for (int i = 0; i < test.size - 1; i++){
                for (int j = 0; j < test.size; j++) {
                    if (test.board[j][i].equals(Symbol)){
                        if ((test.board[j][i].equals(test.board[j][i + 1]))) {
                            crossSequences[SequenceNumber][CordsPosition][0] = j;
                            crossSequences[SequenceNumber][CordsPosition][1] = i;
                            CordsPosition++;
                            if ((test.board[j][i + 1].equals(Symbol)) & (i + 1 == test.size - 1)) {
                                crossSequences[SequenceNumber][CordsPosition][0] = j;
                                crossSequences[SequenceNumber][CordsPosition][1] = i + 1;
                                SequenceNumber++;
                                CordsPosition = 0;
                            }
                            if (((test.size - 1) == i) & (i == j)) isGoing = false;
                        } else {
                            crossSequences[SequenceNumber][CordsPosition][0] = j;
                            crossSequences[SequenceNumber][CordsPosition][1] = i;
                            SequenceNumber++;
                            CordsPosition = 0;
                        }
                    }
                }
            }
        }

        isGoing = true;
        while (isGoing) { //diagonal check (left-up to right-down) part 1
            for (int k = 0; k < test.size - 1; k++){
                for (int i = 0, j = k; j < test.size - 1; i++, j++) {
                    if (test.board[j][i].equals(Symbol)){
                        if ((test.board[j][i].equals(test.board[j + 1][i + 1]))) {
                            crossSequences[SequenceNumber][CordsPosition][0] = j;
                            crossSequences[SequenceNumber][CordsPosition][1] = i;
                            CordsPosition++;
                            if ((test.board[j + 1][i + 1].equals(Symbol)) & (j + 1 == test.size - 1)) {
                                crossSequences[SequenceNumber][CordsPosition][0] = j + 1;
                                crossSequences[SequenceNumber][CordsPosition][1] = i + 1;
                                SequenceNumber++;
                                CordsPosition = 0;
                            }
                            if (((test.size - 1) == j) & (i == 0)) isGoing = false;
                        } else {
                            crossSequences[SequenceNumber][CordsPosition][0] = j;
                            crossSequences[SequenceNumber][CordsPosition][1] = i;
                            SequenceNumber++;
                            CordsPosition = 0;
                        }
                    }
                }
            }
        }

        isGoing = true;
        while (isGoing) { //diagonal check (left-up to right-down) part 2
            for (int k = 1; k < test.size - 1; k++){
                for (int i = k, j = 0; i < test.size - 1; i++, j++) {
                    if (test.board[j][i].equals(Symbol)){
                        if ((test.board[j][i].equals(test.board[j + 1][i + 1]))) {
                            crossSequences[SequenceNumber][CordsPosition][0] = j;
                            crossSequences[SequenceNumber][CordsPosition][1] = i;
                            CordsPosition++;
                            if ((test.board[j + 1][i + 1].equals(Symbol)) & (i + 1 == test.size - 1)) {
                                crossSequences[SequenceNumber][CordsPosition][0] = j + 1;
                                crossSequences[SequenceNumber][CordsPosition][1] = i + 1;
                                SequenceNumber++;
                                CordsPosition = 0;
                            }
                            if (((test.size - 1) == i) & (j == 0)) isGoing = false;
                        } else {
                            crossSequences[SequenceNumber][CordsPosition][0] = j;
                            crossSequences[SequenceNumber][CordsPosition][1] = i;
                            SequenceNumber++;
                            CordsPosition = 0;
                        }
                    }
                }
            }
        }

        isGoing = true;
        while (isGoing) { //diagonal check (right-up to left-down) part 1
            for (int k = test.size - 1; k > 0; k--){
                for (int i = 0, j = k; j > 0; i++, j--) {
                    if (test.board[j][i].equals(Symbol)){
                        if ((test.board[j][i].equals(test.board[j - 1][i + 1]))) {
                            crossSequences[SequenceNumber][CordsPosition][0] = j;
                            crossSequences[SequenceNumber][CordsPosition][1] = i;
                            CordsPosition++;
                            if ((test.board[j - 1][i + 1].equals(Symbol)) & (j - 1 == 0)) {
                                crossSequences[SequenceNumber][CordsPosition][0] = j - 1;
                                crossSequences[SequenceNumber][CordsPosition][1] = i + 1;
                                SequenceNumber++;
                                CordsPosition = 0;
                            }
                            if ((i == 0) & (j == 1)) isGoing = false;
                        } else {
                            crossSequences[SequenceNumber][CordsPosition][0] = j;
                            crossSequences[SequenceNumber][CordsPosition][1] = i;
                            SequenceNumber++;
                            CordsPosition = 0;
                        }
                    }
                }
            }
        }

        isGoing = true;
        while (isGoing) { //diagonal check (right-up to left-down) part 2
            for (int k = 1; k < test.size; k++){
                for (int i = k, j = test.size - 1; j < test.size; i++, j--) {
                    if (test.board[j][i].equals(Symbol)){
                        if ((test.board[j][i].equals(test.board[j - 1][i + 1]))) {
                            crossSequences[SequenceNumber][CordsPosition][0] = j;
                            crossSequences[SequenceNumber][CordsPosition][1] = i;
                            CordsPosition++;
                            if ((test.board[j - 1][i + 1].equals(Symbol)) & (i + 1 == test.size - 1)) {
                                crossSequences[SequenceNumber][CordsPosition][0] = j - 1;
                                crossSequences[SequenceNumber][CordsPosition][1] = i + 1;
                                SequenceNumber++;
                                CordsPosition = 0;
                            }
                            if ((i == 0) & (j == 1)) isGoing = false;
                        } else {
                            crossSequences[SequenceNumber][CordsPosition][0] = j;
                            crossSequences[SequenceNumber][CordsPosition][1] = i;
                            SequenceNumber++;
                            CordsPosition = 0;
                        }
                    }
                }
            }
        }

        if (test.board[0][0].equals(Symbol)) { //checking corners
            crossSequences[SequenceNumber][CordsPosition][0] = 0;
            crossSequences[SequenceNumber][CordsPosition][1] = 0;
        }
        if (test.board[0][test.size - 1].equals(Symbol)) {
            crossSequences[SequenceNumber][CordsPosition][0] = 0;
            crossSequences[SequenceNumber][CordsPosition][1] = test.size - 1;
        }
        if (test.board[test.size - 1][0].equals(Symbol)) {
            crossSequences[SequenceNumber][CordsPosition][0] = test.size - 1;
            crossSequences[SequenceNumber][CordsPosition][1] = 0;
        }
        if (test.board[test.size - 1][test.size - 1].equals(Symbol)) {
            crossSequences[SequenceNumber][CordsPosition][0] = test.size - 1;
            crossSequences[SequenceNumber][CordsPosition][1] = test.size - 1;
        }

        int maxLength = 0;
        int sequenceIndex = 0;
        for (int i = 0; i <= crossSequences.length; i++){
            if (crossSequences[i].length > maxLength) {
                sequenceIndex = i;
                maxLength = crossSequences[i].length;
            }
        }

        int[][] maxSequence = new int[crossSequences[sequenceIndex].length][];
        if (crossSequences[sequenceIndex].length + 1 >= 0)
            System.arraycopy(crossSequences[sequenceIndex], 0, maxSequence, 0, crossSequences[sequenceIndex].length + 1);
        return maxSequence;
    }

    private static int pow(int size) {
        int result = size;
        for (int k = 1; k < 4; k++){
            result *= size;
        }
        return result;
    }
}

