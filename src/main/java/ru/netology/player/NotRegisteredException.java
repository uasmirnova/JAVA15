package ru.netology.player;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String msg) {
        super(msg);
    }
}
