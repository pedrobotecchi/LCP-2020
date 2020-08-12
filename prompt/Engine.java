import java.util.HashMap;
import java.util.TreeSet;

public class Engine
{
    /* --class attributes-- */
    private static HashMap<Integer, User> hash_users;
    private static TreeSet<String> tree_login_user;
    /* --class attributes-- */

    /* --constructors-- */
    public Engine()
    {
        hash_users = new HashMap<Integer, User>();
        tree_login_user = new TreeSet<String>();
    }
    /* --constructors-- */

    /* --public methods-- */
    // add user to the hashmap: true if successfully added -> false if not
    public boolean add_user(String name, String surname, String email, String phone_number, String login_user, String login_password)
    {
        if ( !tree_login_user.contains(login_user) )
        {
            tree_login_user.add(login_user);
            
            int id = (login_user + login_password).hashCode();
            hash_users.put(id, new User(name, surname, email, phone_number, login_user));
            
            return true;
        }
        else return false;
    }

    // find if a user exists: true if it does -> false if it doesn't
    public boolean find_user(String login_user, String login_password)
    {
        int id = (login_user + login_password).hashCode();

        if ( hash_users.containsKey(id) )
            return true;
        else return false;
    }
    /* --public methods-- */
    
    /* --private methods-- */
    /* --private methods-- */

    /* --setters-- */
    /* --setters-- */
    
    /* --getters-- */
    /* --getters-- */
}