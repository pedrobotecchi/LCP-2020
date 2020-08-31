/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Pedro Botecchi
 */
public class Reminder
{
    /* --class attributes-- */
    protected String title;
    protected String description;
    protected boolean finished;
    private int reminderId;
    /* --class attributes-- */

    /* --constructors-- */
    protected Reminder(String title, String description, boolean finished)
    {
        this.title = title;
        this.description = description;
        this.finished = finished;
    }
    /* --constructors-- */

    /* --public methods-- */
    /* --public methods-- */

    /* --private methods-- */
    /* --private methods-- */

    /* --setters-- */
    public void set_finished() { this.finished = true; }
    public void set_unfinished() { this.finished = false; }
    public void setTitle(String title) {this.title = title;}
    public void setDescription(String description) {this.description = description;}
    public void setId(int id) {this.reminderId = id;}
    /* --setters-- */
    
    /* --getters-- */
    public boolean getFinished() {return this.finished;}
    public String get_title() { return this.title; }
    public String get_description() { return this.description; }
    public String getTitle(){ return this.title;}
    public String getDescription(){ return this.description;}
    public int getId(){return this.reminderId;}
    /* --getters-- */
}