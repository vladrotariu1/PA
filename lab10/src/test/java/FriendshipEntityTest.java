import com.lab10.DBPersistance.entities.FriendshipsEntity;
import com.lab10.DBPersistance.entitiesManager.FriendshipsEntityManager;

public class FriendshipEntityTest {
    public static void main(String[] args) {
        FriendshipsEntity f = new FriendshipsEntity();
        f.setFriendship(1,2);

        FriendshipsEntityManager friendshipsEM = new FriendshipsEntityManager();
        friendshipsEM.create(f);
    }
}
