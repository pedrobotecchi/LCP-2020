import java.util.HashMap;
import java.util.TreeSet;
import java.util.ArrayList;

public class Engine
{
    /* --class attributes-- */
    private static HashMap<Integer, User> hash_users;
    private static TreeSet<String> tree_login_user;

    private User current_user;
    /* --class attributes-- */

    /* --constructors-- */
    public Engine()
    {
        hash_users = new HashMap<Integer, User>();
        tree_login_user = new TreeSet<String>();
    }
    /* --constructors-- */

    /* --public methods-- */
    // add user to the hashmap: returns true if successfully added | false if not
    public boolean add_user(String name, String surname, String email, String phone_number, String user_login, String password_login)
    {
        if ( !tree_login_user.contains(user_login) )
        {
            tree_login_user.add(user_login);
            
            int id = (user_login + password_login).hashCode();
            hash_users.put(id, new User(name, surname, email, phone_number, user_login));
            
            return true;
        }
        else return false;
    }

    // try to login with a user: returns true if the user is found and set the current_user | false if it doesn't find
    public boolean login_user(String user_login, String password_login)
    {
        int id = (user_login + password_login).hashCode();

        if ( hash_users.containsKey(id) )
        {
            this.current_user = hash_users.get(id);
            return true;
        }
        else return false;
    }

    // add a new reminder to the selected user: returns true if successfully added | false if not
    public void add_reminder(String title, String description)
    {
        if ( this.current_user != null )
            this.current_user.new_reminder(title, description);
        // else System.out.printf("\n>> Login first\n"); // TODO: throw exception if current_user == null (login_user was never called or returned false)
    }

    public ArrayList<Reminder> show_reminders()
    {
        if ( this.current_user != null )
            return this.current_user.get_reminders();
        else
            return null;
    }
    /* --public methods-- */
    
    /* --private methods-- */
    // search in hash_users the id passed
    /* --private methods-- */

    /* --setters-- */
    /* --setters-- */
    
    /* --getters-- */
    /* --getters-- */
}