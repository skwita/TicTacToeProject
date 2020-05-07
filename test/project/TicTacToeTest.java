package project;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @Test
    void setCross() {
        TicTacToe first = new TicTacToe(5);
        TicTacToe.setCross(1, 4, first);
        Assert.assertEquals("X", first.board[0][3]);

        TicTacToe second = new TicTacToe(7);
        TicTacToe.setCross(7, 7, second);
        Assert.assertEquals("X", second.board[6][6]);

        TicTacToe third = new TicTacToe(1);
        TicTacToe.setCross(1, 1, third);
        Assert.assertEquals("X", third.board[0][0]);
    }

    @Test
    void setNought() {
        TicTacToe first = new TicTacToe(5);
        TicTacToe.setNought(1, 4, first);
        Assert.assertEquals("O", first.board[0][3]);

        TicTacToe second = new TicTacToe(7);
        TicTacToe.setNought(7, 7, second);
        Assert.assertEquals("O", second.board[6][6]);

        TicTacToe third = new TicTacToe(1);
        TicTacToe.setNought(1, 1, third);
        Assert.assertEquals("O", third.board[0][0]);
    }

    @Test
    void clear() {
        TicTacToe first = new TicTacToe(5);
        TicTacToe.setCross(1, 4, first);
        TicTacToe.clear(1, 4, first);
        Assert.assertEquals("_", first.board[0][3]);

        TicTacToe second = new TicTacToe(7);
        TicTacToe.setNought(7, 7, second);
        TicTacToe.clear(7, 7, second);
        Assert.assertEquals("_", second.board[6][6]);

        TicTacToe third = new TicTacToe(1);
        TicTacToe.setCross(1, 1, third);
        TicTacToe.clear(1, 1, third);
        Assert.assertEquals("_", third.board[0][0]);
    }

    @Test
    void maxLengthCheck() {
        TicTacToe first = new TicTacToe(3);
        TicTacToe.setNought(1, 1, first);
        TicTacToe.setNought(1, 2, first);
        TicTacToe.setNought(1, 3, first);
        ArrayList<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(0);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(0);
        ArrayList<Integer> c = new ArrayList<>();
        c.add(2);
        c.add(0);
        ArrayList<ArrayList<Integer>> sequenceOne = new ArrayList<>();
        sequenceOne.add(a);
        sequenceOne.add(b);
        sequenceOne.add(c);
        Assert.assertEquals(sequenceOne, TicTacToe.maxLengthCheck(first, "O"));

        TicTacToe second = new TicTacToe(3);
        TicTacToe.setCross(1, 1, second);
        TicTacToe.setCross(2, 1, second);
        TicTacToe.setCross(3, 1, second);
        ArrayList<Integer> d = new ArrayList<>();
        d.add(0);
        d.add(0);
        ArrayList<Integer> e = new ArrayList<>();
        e.add(0);
        e.add(1);
        ArrayList<Integer> f = new ArrayList<>();
        f.add(0);
        f.add(2);
        ArrayList<ArrayList<Integer>> sequenceTwo = new ArrayList<>();
        sequenceTwo.add(d);
        sequenceTwo.add(e);
        sequenceTwo.add(f);
        Assert.assertEquals(sequenceTwo , TicTacToe.maxLengthCheck(first ,"X"));
    }
}