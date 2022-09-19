package ru.netology.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Маша", 5);
    Player player2 = new Player(2, "Миша", 15);
    Player player3 = new Player(3, "Вася", 10);

    @Test
    public void ShouldWonPlayer1() {

        game.register(player1);
        game.register(player2);
        game.register(player3);

        int expected = 1;
        int actual = game.round("Миша", "Вася");

        Assertions.assertEquals( expected, actual );
    }

    @Test
    public void ShouldWonPlayer2() {

        game.register(player1);
        game.register(player2);
        game.register(player3);

        int expected = 2;
        int actual = game.round("Маша", "Миша");

        Assertions.assertEquals( expected, actual );
    }

    @Test
    public void ShouldDrawnGame() {

        Player player4 = new Player(4,"Катя", 5);

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int expected = 0;
        int actual = game.round("Маша", "Катя");

        Assertions.assertEquals( expected, actual );
    }

    @Test
    public void ShouldPlayer1IsUnregistered() {

        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Маша", "Петя");
        });
    }

    @Test
    public void ShouldPlayer2IsUnregistered() {

        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Петя", "Маша");
        });
    }
}
