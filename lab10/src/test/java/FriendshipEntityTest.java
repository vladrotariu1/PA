import com.lab10.DBPersistance.entities.FriendshipsEntity;
import com.lab10.DBPersistance.entitiesManager.FriendshipsEntityManager;

import java.util.ArrayList;

public class FriendshipEntityTest {
    public static void main(String[] args) throws Exception {
        //FriendshipsEntity f = new FriendshipsEntity();
        //f.setFriendship(1,2);

        FriendshipsEntityManager friendshipsEM = new FriendshipsEntityManager();
        //friendshipsEM.create(f);
        ArrayList<FriendshipsEntity> friendships = friendshipsEM.getFriendships();
        System.out.println(friendships);
    }
}
