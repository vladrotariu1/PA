package com.lab10.Commands;

import com.lab10.Commands.Exceptions.InvalidNumberOfParametersException;
import com.lab10.DBPersistance.entities.UsersEntity;
import com.lab10.DBPersistance.entitiesManager.FriendshipsEntityManager;
import com.lab10.DBPersistance.entitiesManager.UsersEntityManager;

import java.util.ArrayList;

public class RegisterShellCommand extends ShellCommand{

    public RegisterShellCommand(ArrayList<String> parameters) {
        super(parameters);
    }

    public void execute() throws Exception {
        ArrayList<String> parameters = this.getParameters();

        if (parameters.size() != 1)
            throw new InvalidNumberOfParametersException("Invalid number of parameters");

        UsersEntityManager usersEM = new UsersEntityManager();
        UsersEntity u = new UsersEntity();
        u.setName(parameters.get(0));
        usersEM.create(u);
    }
}
