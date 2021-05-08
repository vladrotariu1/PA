package com.lab10.Commands;

import com.lab10.Commands.Exceptions.FriendYourselfException;
import com.lab10.Commands.Exceptions.InvalidNumberOfParametersException;
import com.lab10.DBPersistance.entities.FriendshipsEntity;
import com.lab10.DBPersistance.entities.UsersEntity;
import com.lab10.DBPersistance.entitiesManager.FriendshipsEntityManager;
import com.lab10.DBPersistance.entitiesManager.UsersEntityManager;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class FriendShellCommand extends ShellCommand{
    public FriendShellCommand(ArrayList<String> parameters) {
        super(parameters);
    }

    public void execute(int userId) throws Exception {
        ArrayList<String> parameters = this.getParameters();

        if (parameters.size() != 1)
            throw new InvalidNumberOfParametersException("Invalid number of parameters");

        UsersEntityManager usersEM = new UsersEntityManager();
        UsersEntity user = usersEM.findByName(parameters.get(0));

        FriendshipsEntityManager friendshipEM = new FriendshipsEntityManager();
        FriendshipsEntity friendship = new FriendshipsEntity();

        if (user.getId() == userId)
            throw new FriendYourselfException("You cannot create friendship with yourself");

        friendship.setFriendship(userId, user.getId());
        friendshipEM.create(friendship);
    }
}
