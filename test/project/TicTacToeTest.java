package project;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;


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

        TicTacToe first = new TicTacToe(9); //horizontal check
        TicTacToe.setNought(2, 2, first);
        TicTacToe.setNought(2, 3, first);
        TicTacToe.setNought(2, 4, first);

        TicTacToe.setNought(3, 9, first);
        TicTacToe.setNought(3, 6, first);
        TicTacToe.setNought(3, 7, first);
        TicTacToe.setNought(3, 8, first);

        TicTacToe.setNought(5, 2, first);
        TicTacToe.setNought(5, 3, first);
        TicTacToe.setNought(5, 4, first);
        TicTacToe.setNought(5, 5, first);
        TicTacToe.setNought(5, 6, first);
        TicTacToe.setNought(5, 7, first);

        TicTacToe.setNought(8, 3, first);
        TicTacToe.setNought(8, 4, first);

        TicTacToe.setNought(9, 6, first);
        TicTacToe.setNought(9, 7, first);
        TicTacToe.setNought(9, 8, first);
        TicTacToe.setNought(9, 9, first);

        List<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(1);
        List<Integer> b = new ArrayList<>();
        b.add(4);
        b.add(6);
        List<List<Integer>> sequenceOne = new ArrayList<>();
        sequenceOne.add(a);
        sequenceOne.add(b);
        Assert.assertEquals(sequenceOne, TicTacToe.maxLengthCheck(first, "O"));

        TicTacToe second = new TicTacToe(9); //vertical check
        TicTacToe.setCross(2, 2, second);
        TicTacToe.setCross(3, 2, second);
        TicTacToe.setCross(4, 2, second);

        TicTacToe.setCross(7, 2, second);
        TicTacToe.setCross(8, 2, second);

        TicTacToe.setCross(1, 4, second);

        TicTacToe.setCross(3, 4, second);
        TicTacToe.setCross(4, 4, second);
        TicTacToe.setCross(5, 4, second);
        TicTacToe.setCross(6, 4, second);

        TicTacToe.setCross(2, 6, second);
        TicTacToe.setCross(3, 6, second);
        TicTacToe.setCross(4, 6, second);
        TicTacToe.setCross(5, 6, second);
        TicTacToe.setCross(6, 6, second);

        TicTacToe.setCross(3, 7, second);
        TicTacToe.setCross(4, 7, second);
        TicTacToe.setCross(5, 7, second);

        TicTacToe.setCross(7, 7, second);
        TicTacToe.setCross(8, 7, second);
        TicTacToe.setCross(9, 7, second);

        TicTacToe.setCross(4, 9, second);
        TicTacToe.setCross(5, 9, second);
        TicTacToe.setCross(6, 9, second);
        TicTacToe.setCross(7, 9, second);
        TicTacToe.setCross(8, 9, second);
        TicTacToe.setCross(9, 9, second);
        List<Integer> c = new ArrayList<>();
        c.add(3);
        c.add(8);
        List<Integer> d = new ArrayList<>();
        d.add(8);
        d.add(8);
        List<List<Integer>> sequenceTwo = new ArrayList<>();
        sequenceTwo.add(c);
        sequenceTwo.add(d);
        Assert.assertEquals(sequenceTwo , TicTacToe.maxLengthCheck(second,"X"));

        TicTacToe third = new TicTacToe(9); //mixed check for vertical and horizontal
        TicTacToe.setNought(7, 5, third);
        TicTacToe.setNought(8, 5, third);
        TicTacToe.setNought(9, 5, third);

        TicTacToe.setNought(5, 2, third);
        TicTacToe.setNought(5, 3, third);
        TicTacToe.setNought(5, 4, third);
        TicTacToe.setNought(5, 5, third);
        TicTacToe.setNought(5, 6, third);
        TicTacToe.setNought(5, 7, third);
        TicTacToe.setNought(5, 8, third);
        TicTacToe.setNought(5, 9, third);
        List<Integer> e = new ArrayList<>();
        e.add(4);
        e.add(1);
        List<Integer> f = new ArrayList<>();
        f.add(4);
        f.add(8);
        List<List<Integer>> sequenceThree = new ArrayList<>();
        sequenceThree.add(e);
        sequenceThree.add(f);
        Assert.assertEquals(sequenceThree , TicTacToe.maxLengthCheck(third,"O"));


        TicTacToe fourth = new TicTacToe(9); //diagonal check down-to-up
        TicTacToe.setNought(2, 1, fourth);
        TicTacToe.setNought(3, 2, fourth);
        TicTacToe.setNought(4, 3, fourth);

        TicTacToe.setNought(8, 7, fourth);
        TicTacToe.setNought(9, 8, fourth);

        TicTacToe.setNought(6, 2, fourth);
        TicTacToe.setNought(7, 3, fourth);
        TicTacToe.setNought(8, 4, fourth);
        TicTacToe.setNought(9, 5, fourth);

        TicTacToe.setNought(2, 3, fourth);
        TicTacToe.setNought(3, 4, fourth);
        TicTacToe.setNought(4, 5, fourth);
        TicTacToe.setNought(5, 6, fourth);
        TicTacToe.setNought(6, 7, fourth);

        List<Integer> g = new ArrayList<>();
        g.add(1);
        g.add(2);
        List<Integer> h = new ArrayList<>();
        h.add(5);
        h.add(6);
        List<List<Integer>> sequenceFour = new ArrayList<>();
        sequenceFour.add(g);
        sequenceFour.add(h);
        Assert.assertEquals(sequenceFour , TicTacToe.maxLengthCheck(fourth,"O"));

        TicTacToe fifth = new TicTacToe(9); //diagonal check up-to-down
        TicTacToe.setCross(5, 2, fifth);
        TicTacToe.setCross(4, 3, fifth);
        TicTacToe.setCross(3, 4, fifth);

        TicTacToe.setCross(1, 6, fifth);

        TicTacToe.setCross(5, 5, fifth);
        TicTacToe.setCross(4, 6, fifth);
        TicTacToe.setCross(3, 7, fifth);
        TicTacToe.setCross(2, 8, fifth);
        TicTacToe.setCross(1, 9, fifth);

        List<Integer> i = new ArrayList<>();
        i.add(4);
        i.add(4);
        List<Integer> j = new ArrayList<>();
        j.add(0);
        j.add(8);
        List<List<Integer>> sequenceFive = new ArrayList<>();
        sequenceFive.add(i);
        sequenceFive.add(j);
        Assert.assertEquals(sequenceFive , TicTacToe.maxLengthCheck(fifth,"X"));

        TicTacToe sixth = new TicTacToe(9); //mixed check for all directions
        TicTacToe.setNought(3, 4, sixth);
        TicTacToe.setNought(4, 4, sixth);
        TicTacToe.setNought(5, 4, sixth);
        TicTacToe.setNought(6, 4, sixth);
        TicTacToe.setNought(5, 3, sixth);
        TicTacToe.setNought(3, 8, sixth);
        TicTacToe.setNought(8, 3, sixth);
        TicTacToe.setNought(7, 8, sixth);

        TicTacToe.setCross(3, 3, sixth);
        TicTacToe.setCross(4, 3, sixth);
        TicTacToe.setCross(7, 4, sixth);
        TicTacToe.setCross(6, 5, sixth);
        TicTacToe.setCross(5, 6, sixth);
        TicTacToe.setCross(4, 7, sixth);
        TicTacToe.setCross(4, 5, sixth);
        TicTacToe.setCross(6, 7, sixth);



        List<Integer> k = new ArrayList<>();
        k.add(2);
        k.add(3);
        List<Integer> l = new ArrayList<>();
        l.add(5);
        l.add(3);
        List<List<Integer>> sequenceSix = new ArrayList<>();
        sequenceSix.add(k);
        sequenceSix.add(l);
        Assert.assertEquals(sequenceSix , TicTacToe.maxLengthCheck(sixth,"O"));

        List<Integer> m = new ArrayList<>();
        m.add(6);
        m.add(3);
        List<Integer> n = new ArrayList<>();
        n.add(3);
        n.add(6);
        List<List<Integer>> sequenceSeven = new ArrayList<>();
        sequenceSeven.add(m);
        sequenceSeven.add(n);
        Assert.assertEquals(sequenceSeven , TicTacToe.maxLengthCheck(sixth,"X"));

    }

}