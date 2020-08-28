public class Reminder
{
    /* --class attributes-- */
    protected String title;
    protected String description;
    protected boolean finished;
    /* --class attributes-- */

    /* --constructors-- */
    protected Reminder(String title, String description)
    {
        this.title = title;
        this.description = description;
        this.set_unfinished();
    }
    /* --constructors-- */

    /* --public methods-- */
    /* --public methods-- */

    /* --private methods-- */
    /* --private methods-- */

    /* --setters-- */
    protected void set_finished() { this.finished = true; }
    protected void set_unfinished() { this.finished = false; }
    /* --setters-- */
    
    /* --getters-- */
    /* --getters-- */
}