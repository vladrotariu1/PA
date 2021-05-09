package com.lab10.NetworkVisualisation;

import com.lab10.DBPersistance.entities.FriendshipsEntity;
import com.lab10.DBPersistance.entities.UsersEntity;
import com.lab10.DBPersistance.entitiesManager.FriendshipsEntityManager;
import com.lab10.DBPersistance.entitiesManager.UsersEntityManager;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.file.FileSinkDOT;
import org.graphstream.stream.file.FileSinkSVG;
import org.graphstream.ui.layout.Layout;
import org.graphstream.ui.layout.LayoutRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.prefs.NodeChangeEvent;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("Tutorial");

        FriendshipsEntityManager friendshipsEM = new FriendshipsEntityManager();
        UsersEntityManager usersEM = new UsersEntityManager();
        ArrayList<FriendshipsEntity> friendships = friendshipsEM.getFriendships();
        ArrayList<UsersEntity> users = usersEM.getAllUsers();

        for (UsersEntity user : users) {
            graph.addNode(String.valueOf(user.getId()));
            Node n = graph.getNode(String.valueOf(user.getId()));
            n.setAttribute("ui.style", "shape:circle;fill-color: yellow;size: 40px;");
            n.setAttribute("ui.label", user.getName());
        }

        for (FriendshipsEntity friendship : friendships) {
            String friend1Id = String.valueOf(friendship.getUser1Id());
            String friend2Id = String.valueOf(friendship.getUser2Id());
            graph.addEdge(friend1Id + "-" + friend2Id, friend1Id, friend2Id);
        }

        graph.display();
    }
}
