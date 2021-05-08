package com.lab10.Server.Messages;

import java.util.ArrayList;

public class MessagePool {
    private static final ArrayList<Message> messagePool = new ArrayList<>(32);

    private MessagePool(){}

    public static synchronized void addMessage(Message M) {
        messagePool.add(M);
    }

    public static synchronized ArrayList<Message> getInbox(int userId) {
        ArrayList<Message> inbox = new ArrayList<>(4);

        for (Message M : messagePool) {
            if (M.getReceiver() == userId)
                inbox.add(M);
        }
        messagePool.removeAll(inbox);

        return inbox;
    }
}
