import java.util.ArrayList;

public class User
{
    /* --class attributes-- */
    private String name;
    private String surname;
    private String email;
    private String phone_number;
    private String login_user;

    private ArrayList<Reminder> reminders;
    /* --class attributes-- */

    /* --constructors-- */
    public User(String name, String surname, String email, String phone_number, String login_user)
    {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone_number = phone_number;
        this.login_user = login_user;

        this.reminders = new ArrayList<Reminder>();
    }
    /* --constructors-- */

    /* --public methods-- */
    public void new_reminder(String title, String description)
    {
        this.reminders.add(new Reminder(title, description));
    }

    /* --public methods-- */
    
    /* --private methods-- */
    /* --private methods-- */
    
    /* --setters-- */
    /* --setters-- */
    
    /* --getters-- */
    public ArrayList<Reminder> get_reminders() { return this.reminders; }
    /* --getters-- */
}