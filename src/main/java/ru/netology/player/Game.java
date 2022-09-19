package ru.netology.player;

import java.util.ArrayList;

public class Game {

    protected ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {

        Player player1 = null;
        Player player2 = null;

        for (Player player : players) {
            if (player.getPlayerName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getPlayerName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(playerName1 + " is not registered");
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2 + " is not registered");
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }
}
