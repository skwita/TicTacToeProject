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

    private static int[][] maxLengthCrossCheck(TicTacToe test){

        int[][][][] crossSequences = new int[1][][][];
//        ArrayList<ArrayList<Position>> crossSequences = new ArrayList<>();

        boolean isGoing = true;
        int SequenceNumber = 0;
        int CordsPosition = 0;
        while (isGoing) {
            for (int i = 0; i < (test.size - 1); i++){
                for (int j = 0; j < (test.size - 1); j++) {
                    if (test.board[j][i].equals("X")){
                        if ((test.board[j][i].equals(test.board[j + 1][i]))) {
                            crossSequences[0][SequenceNumber][CordsPosition][0] = j;
                            crossSequences[0][SequenceNumber][CordsPosition][1] = i;
                            CordsPosition++;
                            if (((test.size - 1) == i) & (i == j)) isGoing = false;
                        } else {
                            crossSequences[0][SequenceNumber][CordsPosition][1] = i;
                            crossSequences[0][SequenceNumber][CordsPosition][1] = j;
                            SequenceNumber++;
                            CordsPosition = 0;
                        }
                    }
                }
            }
        }

        isGoing = true;
        while (isGoing) {
            for (int i = 0; i < (test.size - 1); i++){
                for (int j = 0; j < (test.size - 1); j++) {
                    if (test.board[j][i].equals("X")){
                        if ((test.board[j][i].equals(test.board[j][i + 1]))) {
                            crossSequences[0][SequenceNumber][CordsPosition][0] = j;
                            crossSequences[0][SequenceNumber][CordsPosition][1] = i;
                            CordsPosition++;
                            if (((test.size - 1) == i) & (i == j)) isGoing = false;
                        } else {
                            crossSequences[0][SequenceNumber][CordsPosition][0] = j;
                            crossSequences[0][SequenceNumber][CordsPosition][1] = i;
                            SequenceNumber++;
                            CordsPosition = 0;
                        }
                    }
                }
            }
        }



        int maxLength = 0;
        int sequenceIndex = 0;
        for (int i = 0; i <= crossSequences[0].length; i++){
            if (crossSequences[0][i].length > maxLength) {
                sequenceIndex = i;
                maxLength = crossSequences[0][i].length;
            }
        }

        int[][] maxSequence = new int[crossSequences[sequenceIndex].length][];
        if (crossSequences[0][sequenceIndex].length + 1 >= 0)
            System.arraycopy(crossSequences[0][sequenceIndex], 0, maxSequence, 0, crossSequences[0][sequenceIndex].length + 1);
        return (maxSequence);
    }

    private static int[][] maxLengthNoughtCheck(TicTacToe test){

        int[][][][] crossSequences = new int[1][][][];
//        ArrayList<ArrayList<Position>> crossSequences = new ArrayList<>();

        boolean isGoing = true;
        int SequenceNumber = 0;
        int CordsPosition = 0;
        while (isGoing) {
            for (int i = 0; i < (test.size - 1); i++){
                for (int j = 0; j < (test.size - 1); j++) {
                    if (test.board[j][i].equals("O")){
                        if ((test.board[j][i].equals(test.board[j + 1][i]))) {
                            crossSequences[0][SequenceNumber][CordsPosition][0] = j;
                            crossSequences[0][SequenceNumber][CordsPosition][1] = i;
                            CordsPosition++;
                            if (((test.size - 1) == i) & (i == j)) isGoing = false;
                        } else {
                            crossSequences[0][SequenceNumber][CordsPosition][1] = i;
                            crossSequences[0][SequenceNumber][CordsPosition][1] = j;
                            SequenceNumber++;
                            CordsPosition = 0;
                        }
                    }
                }
            }
        }

        isGoing = true;
        while (isGoing) {
            for (int i = 0; i < (test.size - 1); i++){
                for (int j = 0; j < (test.size - 1); j++) {
                    if (test.board[j][i].equals("O")){
                        if ((test.board[j][i].equals(test.board[j][i + 1]))) {
                            crossSequences[0][SequenceNumber][CordsPosition][0] = j;
                            crossSequences[0][SequenceNumber][CordsPosition][1] = i;
                            CordsPosition++;
                            if (((test.size - 1) == i) & (i == j)) isGoing = false;
                        } else {
                            crossSequences[0][SequenceNumber][CordsPosition][0] = j;
                            crossSequences[0][SequenceNumber][CordsPosition][1] = i;
                            SequenceNumber++;
                            CordsPosition = 0;
                        }
                    }
                }
            }
        }
        

        int maxLength = 0;
        int sequenceIndex = 0;
        for (int i = 0; i <= crossSequences[0].length; i++){
            if (crossSequences[0][i].length > maxLength) {
                sequenceIndex = i;
                maxLength = crossSequences[0][i].length;
            }
        }

        int[][] maxSequence = new int[crossSequences[sequenceIndex].length][];
        if (crossSequences[0][sequenceIndex].length + 1 >= 0)
            System.arraycopy(crossSequences[0][sequenceIndex], 0, maxSequence, 0, crossSequences[0][sequenceIndex].length + 1);
        return (maxSequence);
    }
}

