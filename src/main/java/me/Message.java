package me;

import java.time.LocalTime;

public class Message {
    private String username;
    private LocalTime localTime;
    private String msg;

    public Message(String username, String msg) {
        this.username = username;
        this.localTime = LocalTime.now();
        this.msg = msg;
    }

    public Message(User user, String msg) {
        this.username = user.getUsername();
        this.localTime = LocalTime.now();
        this.msg = msg;
    }

    public String toString() {
        return "[" + this.username + "][" + this.localTime + "] : " + this.msg;
    }
}
