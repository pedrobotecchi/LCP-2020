import java.util.HashMap;
import java.util.Iterator;

public class Engine
{
    /* --class attributes-- */
    private static HashMap<Integer, User> hash_users;
    /* --class attributes-- */

    /* --constructors-- */
    public Engine() { hash_users = new HashMap<Integer, User>(); }
    /* --constructors-- */

    /* --public methods-- */
    // add user to the hashmap: true if successfully added -> false if not
    public boolean add_user(String name, String surname, String email, String phone_number, String login_user, String login_password)
    {
        int id = (login_user + login_password).hashCode();
        
        // verifying if the hash key already exits
        // boolean valid_id = false;
        // do
        // {
        //     id = aux_hash.hashCode();   // TODO: create a new hash function 

        //     if ( hash_users.containsKey(id) )
        //         valid_id = false;
        //     else
        //         valid_id = true;    // TODO: change id when equals

        // } while ( !valid_id );
        
        // TODO: verifying if email and login_user already exist
        // if ( !email.equals(another_user.get_email()) )
        
        hash_users.put(id, new User(name, surname, email, phone_number, login_user));
        
        return true;
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

class User
{
    /* --class attributes-- */
    private String name;
    private String surname;
    private String email;
    private String phone_number;
    private String login_user;
    /* --class attributes-- */

    /* --constructors-- */
    public User(String name, String surname, String email, String phone_number, String login_user)
    {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone_number = phone_number;
        this.login_user = login_user;
    }
    /* --constructors-- */

    /* --setters-- */
    /* --setters-- */
    
    /* --getters-- */
    /* --getters-- */
}