package project;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

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
}

