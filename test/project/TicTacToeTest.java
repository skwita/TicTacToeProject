package project;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @Test
    void setCross() {
        TicTacToe first = new TicTacToe(5);
        first.setCross(1, 4);
        Assert.assertEquals(Board.X, first.returnValue(0,3));

        TicTacToe second = new TicTacToe(7);
        second.setCross(7, 7);
        Assert.assertEquals(Board.X, second.returnValue(6,6));

        TicTacToe third = new TicTacToe(1);
        third.setCross(1, 1);
        Assert.assertEquals(Board.X, third.returnValue(0,0));
    }

    @Test
    void setNought() {
        TicTacToe first = new TicTacToe(5);
        first.setNought(1, 4);
        Assert.assertEquals(Board.O, first.returnValue(0,3));

        TicTacToe second = new TicTacToe(7);
        second.setNought(7, 7);
        Assert.assertEquals(Board.O, second.returnValue(6,6));

        TicTacToe third = new TicTacToe(1);
        third.setNought(1, 1);
        Assert.assertEquals(Board.O, third.returnValue(0,0));
    }

    @Test
    void clear() {
        TicTacToe first = new TicTacToe(5);
        first.setCross(1, 4);
        first.clear(1, 4);
        Assert.assertEquals(Board.E, first.returnValue(0,3));

        TicTacToe second = new TicTacToe(7);
        second.setCross(7, 7);
        second.clear(7, 7);
        Assert.assertEquals(Board.E, second.returnValue(6,6));

        TicTacToe third = new TicTacToe(1);
        third.setCross(1, 1);
        third.clear(1, 1);
        Assert.assertEquals(Board.E, third.returnValue(0,0));
    }

    @Test
    void maxLengthCheck() {

        TicTacToe first = new TicTacToe(10); //horizontal check
        first.setNought(2, 2);
        first.setNought(2, 3);
        first.setNought(2, 4);

        first.setNought(3, 9);
        first.setNought(3, 6);
        first.setNought(3, 7);
        first.setNought(3, 8);

        first.setNought(5, 2);
        first.setNought(5, 3);
        first.setNought(5, 4);
        first.setNought(5, 5);
        first.setNought(5, 6);
        first.setNought(5, 7);

        first.setNought(8, 3);
        first.setNought(8, 4);

        first.setNought(9, 6);
        first.setNought(9, 7);
        first.setNought(9, 8);
        first.setNought(9, 9);

        Assert.assertEquals("[(4;1),(4;6)]", first.maxLengthCheck(Board.O).toString());

        TicTacToe second = new TicTacToe(10); //vertical check
        second.setCross(2, 2);
        second.setCross(3, 2);
        second.setCross(4, 2);

        second.setCross(7, 2);
        second.setCross(8, 2);

        second.setCross(1, 4);

        second.setCross(3, 4);
        second.setCross(4, 4);
        second.setCross(5, 4);
        second.setCross(6, 4);

        second.setCross(2, 6);
        second.setCross(3, 6);
        second.setCross(4, 6);
        second.setCross(5, 6);
        second.setCross(6, 6);

        second.setCross(3, 7);
        second.setCross(4, 7);
        second.setCross(5, 7);

        second.setCross(7, 7);
        second.setCross(8, 7);
        second.setCross(9, 7);

        second.setCross(4, 9);
        second.setCross(5, 9);
        second.setCross(6, 9);
        second.setCross(7, 9);
        second.setCross(8, 9);
        second.setCross(9, 9);

        Assert.assertEquals("[(3;8),(8;8)]" , second.maxLengthCheck(Board.X).toString());

        TicTacToe third = new TicTacToe(10); //mixed check for vertical and horizontal
        third.setNought(7, 5);
        third.setNought(8, 5);
        third.setNought(9, 5);

        third.setNought(5, 2);
        third.setNought(5, 3);
        third.setNought(5, 4);
        third.setNought(5, 5);
        third.setNought(5, 6);
        third.setNought(5, 7);
        third.setNought(5, 8);
        third.setNought(5, 9);

        Assert.assertEquals("[(4;1),(4;8)]" , third.maxLengthCheck(Board.O).toString());


        TicTacToe fourth = new TicTacToe(10); //diagonal check down-to-up
        fourth.setNought(2, 1);
        fourth.setNought(3, 2);
        fourth.setNought(4, 3);

        fourth.setNought(8, 7);
        fourth.setNought(9, 8);

        fourth.setNought(6, 2);
        fourth.setNought(7, 3);
        fourth.setNought(8, 4);
        fourth.setNought(9, 5);

        fourth.setNought(2, 3);
        fourth.setNought(3, 4);
        fourth.setNought(4, 5);
        fourth.setNought(5, 6);
        fourth.setNought(6, 7);

        Assert.assertEquals("[(1;2),(5;6)]" , fourth.maxLengthCheck(Board.O).toString());

        TicTacToe fifth = new TicTacToe(10); //diagonal check up-to-down
        fifth.setCross(5, 2);
        fifth.setCross(4, 3);
        fifth.setCross(3, 4);

        fifth.setCross(1, 6);

        fifth.setCross(5, 5);
        fifth.setCross(4, 6);
        fifth.setCross(3, 7);
        fifth.setCross(2, 8);
        fifth.setCross(1, 9);

        Assert.assertEquals("[(4;4),(0;8)]" , fifth.maxLengthCheck(Board.X).toString());

        TicTacToe sixth = new TicTacToe(10); //mixed check for all directions
        sixth.setNought(3, 4);
        sixth.setNought(4, 4);
        sixth.setNought(5, 4);
        sixth.setNought(6, 4);
        sixth.setNought(5, 3);
        sixth.setNought(3, 8);
        sixth.setNought(8, 3);
        sixth.setNought(7, 8);

        sixth.setCross(3, 3);
        sixth.setCross(4, 3);
        sixth.setCross(7, 4);
        sixth.setCross(6, 5);
        sixth.setCross(5, 6);
        sixth.setCross(4, 7);
        sixth.setCross(4, 5);
        sixth.setCross(6, 7);

        Assert.assertEquals("[(2;3),(5;3)]" , sixth.maxLengthCheck(Board.O).toString());
        Assert.assertEquals("[(6;3),(3;6)]" , sixth.maxLengthCheck(Board.X).toString());

    }

}