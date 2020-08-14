package classes;

import java.util.HashMap;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Engine
{
    /*-- Regex's for field verification*/
    private static final String EMAIL_PATTERN = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PHONE_PATTERN = 
        ".((10)|([1-9][1-9]).)\\s9?[6-9][0-9]{3}-[0-9]{4}"
        + ".((10)|([1-9][1-9]).)\\s[2-5][0-9]{3}-[0-9]{4}";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
    
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

    // add a new reminder to the selected user
    public void add_reminder(String title, String description)
    {
        if ( this.current_user != null )
            this.current_user.new_reminder(title, description);
        // else System.out.printf("\n>> Login first\n"); // TODO: throw exception if current_user == null (login_user was never called or returned false)
    }
    
    // Verifies if the email is a valid address
    public static boolean emailValidation(String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    // Verifies if the phone is a valid Phone
    public boolean phoneValidation(String phone) {
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
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