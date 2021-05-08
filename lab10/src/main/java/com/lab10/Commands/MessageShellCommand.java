package com.lab10.Commands;

import com.lab10.DBPersistance.entitiesManager.FriendshipsEntityManager;
import com.lab10.DBPersistance.entitiesManager.UsersEntityManager;
import com.lab10.Server.Messages.Message;
import com.lab10.Server.Messages.MessagePool;

import java.util.ArrayList;

public class MessageShellCommand extends ShellCommand{
    public MessageShellCommand(ArrayList<String> parameters) {
        super(parameters);
    }

    public void execute(int userId) throws Exception {
        ArrayList<String> parameters = this.getParameters();

        int receiverId = new UsersEntityManager().findByName(parameters.remove(0)).getId();
        new FriendshipsEntityManager().findFriendship(userId, receiverId);

        StringBuilder message = new StringBuilder();
        for (String s : parameters) {
            message.append(s);
            message.append(" ");
        }

        System.out.println("Message: " + message.toString());
        MessagePool.addMessage(new Message(userId, receiverId, message.toString()));
    }
}
