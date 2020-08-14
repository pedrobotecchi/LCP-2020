/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author Pedro Botecchi
 */
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
        System.out.printf("\n>> Reminder: %s - %s", title, description);
    }
    /* --public methods-- */

    /* --private methods-- */
    /* --private methods-- */

    /* --setters-- */
    public void setName(String name){this.name = name;}
    public void setSurname(String surname){this.surname = surname;}
    public void setEmail(String email){this.email = email;}
    public void setPhone(String phone_number){this.phone_number = phone_number;}
    public void setLogin(String login_user){this.login_user = login_user;}
    /* --setters-- */
    
    /* --getters-- */
    public String getName(){ return this.name; }
    public String getSurname(){ return this.surname; }
    public String getEmail(){ return this.email; }
    public String getPhoneNumber(){ return this.phone_number; }
    public String getLogin(){ return this.login_user; }
    /* --getters-- */

}
