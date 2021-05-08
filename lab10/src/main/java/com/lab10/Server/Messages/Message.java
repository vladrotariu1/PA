package com.lab10.Server.Messages;

public class Message {
    private int sender;
    private int receiver;
    private String Message;

    public Message(int sender, int receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        Message = message;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender=" + sender +
                ", receiver=" + receiver +
                ", Message='" + Message + '\'' +
                '}';
    }
}
