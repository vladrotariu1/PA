import com.lab10.DBPersistance.entities.UsersEntity;
import com.lab10.DBPersistance.entitiesManager.UsersEntityManager;

public class UserEntityTest {
    public static void main(String[] args) throws Exception {
        //UsersEntity u = new UsersEntity();
        //u.setName("vlad");

        UsersEntityManager userEM = new UsersEntityManager();
        //userEM.create(u);
        UsersEntity u = userEM.findByName("catalin");

        System.out.println(u);
    }
}
