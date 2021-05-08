package com.lab10.Commands;

import com.lab10.Commands.Exceptions.InvalidNumberOfParametersException;
import com.lab10.DBPersistance.entitiesManager.UsersEntityManager;
import com.lab10.Server.Messages.Message;
import com.lab10.Server.Messages.MessagePool;

import java.util.ArrayList;

public class ShowmsgShellCommand extends ShellCommand{
    public ShowmsgShellCommand(ArrayList<String> parameters) {
        super(parameters);
    }

    private String formatInbox(ArrayList<Message> inbox) {
        UsersEntityManager usersEM = new UsersEntityManager();
        StringBuilder formattedInbox = new StringBuilder();

        for (Message M : inbox) {
            String sender = usersEM.findById(M.getSender()).getName();
            String message = M.getMessage();
            formattedInbox.append(sender).append(": ").append(message).append("\n");
        }

        return formattedInbox.toString();
    }

    public String execute(int userId) throws InvalidNumberOfParametersException {
        if (this.getParameters().size() != 0)
            throw new InvalidNumberOfParametersException("Invalid number of parameters");

        ArrayList<Message> inbox = MessagePool.getInbox(userId);
        System.out.println(inbox);

        return formatInbox(inbox);
    }
}
