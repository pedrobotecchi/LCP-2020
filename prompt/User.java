import java.util.ArrayList;

public class User
{
    /* --class attributes-- */
    private String name;
    private String surname;
    private String email;
    private String phone_number;
    private String login_user;

    private ArrayList<Reminder> due_reminders;
    private ArrayList<Reminder> closed_reminders;
    /* --class attributes-- */

    /* --constructors-- */
    public User(String name, String surname, String email, String phone_number, String login_user)
    {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone_number = phone_number;
        this.login_user = login_user;

        this.due_reminders = new ArrayList<Reminder>();
        this.closed_reminders = new ArrayList<Reminder>();
    }
    /* --constructors-- */

    /* --public methods-- */
    public void add_reminder(String title, String description)
    {
        this.due_reminders.add(new Reminder(title, description));
    }

    public void close_reminder(int index)
    {
        Reminder reminder = this.due_reminders.get(index);

        reminder.set_finished();
        this.closed_reminders.add(reminder);

        this.due_reminders.remove(index);
    }
    /* --public methods-- */
    
    /* --private methods-- */
    /* --private methods-- */
    
    /* --setters-- */
    /* --setters-- */
    
    /* --getters-- */
    public ArrayList<Reminder> get_due_reminders() { return this.due_reminders; }
    public ArrayList<Reminder> get_closed_reminders() { return this.closed_reminders; }
    // TODO: add getters for the attributes
    /* --getters-- */
}