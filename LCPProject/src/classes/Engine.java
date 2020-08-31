package classes;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

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

    //private User current_user;
    public static User current_user;
    /* --class attributes-- */
    
    /* -- BD Variables -- */
    private com.mysql.jdbc.Connection myConn = null;
    private com.mysql.jdbc.Statement myStmt = null;
    private ResultSet myRs = null;
    BDFunctions bd = new BDFunctions();
    /* -- BD Variables -- */
    
    /* --constructors-- */
    public Engine()
    {
        hash_users = new HashMap<Integer, User>();
        tree_login_user = new TreeSet<String>();
    }
    /* --constructors-- */

    /* --public methods-- */
    // add user to the hashmap: returns true if successfully added | false if not
    public boolean add_user(User user, String password_login)
    { 
        if((bd.bdCheckUser(user.getLogin(),this).equals(""))){
            return bd.bdInsertUser(user, password_login);
        }
        
        return false;
    }

    public boolean updateUser(User user, String password_login,String oldUser)
    { 
        String newUser = user.getLogin();
        user.setLogin(oldUser);
        
        int userId = bd.bdSearchUserID(user);
        
        user.setLogin(newUser);
        
        if(bd.bdUpdateUser(user,password_login,userId)){
            this.current_user = user;
            return true;
        }
        else        
            return false;
    }
    
    // try to login with a user: returns true if the user is found and set the current_user | false if it doesn't find
    public boolean login_user(String user_login, String password_login)
    {
        int id = (user_login + password_login).hashCode();

        String password = bd.bdCheckUser(user_login,this);

        if(password.equals(password_login)){
            return true;    
        } else {
            return false;
        }
 
    }

    public void updateReminder(Reminder reminder){
        bd.bdUpdateReminder(reminder);
    }
    
    // add a new reminder to the selected user
    public void add_reminder(String title, String description, User user)
    {
        int user_id = bd.bdSearchUserID(user);
        
        if(user_id!=-1){
            Reminder reminder = new Reminder(title,description,false);
            if(bd.bdAddReminder(reminder,user_id)){
                JOptionPane.showMessageDialog(null, "Reminder Inserted !!!");
            } else{
                JOptionPane.showMessageDialog(null, "ERROR - The reminder wasn't inserted !!!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "ERROR - User not Found!!!");
        }
        
        //if ( this.current_user != null )
        //    this.current_user.new_reminder(title, description);
        // else System.out.printf("\n>> Login first\n"); // TODO: throw exception if current_user == null (login_user was never called or returned false)
    }
    
    // Verifies if the email is a valid address
    public static boolean emailValidation(String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    // Verifies if the phone is a valid Phone
    public boolean phoneValidation(String phone) {
        //Matcher matcher = pattern.matcher(phone);
       // return matcher.matches();
       return true;
    }
    /* --public methods-- */
    
    /* --private methods-- */
    // search in hash_users the id passed
    /* --private methods-- */

    /* --setters-- */
    public void setCurrentUser(User user){
        this.current_user = user;
    }
    /* --setters-- */
    
    /* --getters-- */
    public User getCurrentUser(){
        return this.current_user;
    }
    /* --getters-- */
}