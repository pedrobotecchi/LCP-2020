/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

/********************************************************************
 *				Unesp Campus Rio Claro              *
 *	Lingaguens Comerciais de Programação (2020 - 1º Semestre    *
 * 	Professora Simone                                           *
 *                                                                  *
 *	Project developed by:                                       *
 *			Pedro Henrique Botecchi                     *
 *			Vinicius Silvestre Bueno                    *
 *                                                                  *
 *------------------------------------------------------------------*
 *	The project consist of a ToDo List, created using Java,     *
 *	where it's possible inserting and controlling things that   *
 *	need to be done.                                            *																*
 ********************************************************************/			


/*************************
 *	IMPORT SECTION   *
 *************************/
import java.util.*;
import java.io.IOException;

public class ToDoList {
    
    static int option = 1;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ToDoList todo = new ToDoList();
        MenuBuilder menu = new MenuBuilder();
        ScreenController screen = new ScreenController();

        while(option!=0){
                screen.clrscr();
                option = menu.buildSignMenu();
                switch(option){
                        case 1:
                                // Calls a function to create a user
                                break;
                        case 2:
                                // Calls a function to do the login
                                // Verify if it's a valid user, if it's valid go to do the things
                                while(option!=0){
                                    screen.clrscr();
                                    option = menu.buildSignUpMenu();
                                }
                                break;
                        case 0:
                                option = 0;
                                break;
                        default:
                                System.out.printf("The value typed it's not valid!");
                                screen.pauseScreen();
                                break; 
                }		
        }
    }	
}

class User{
	private String login;
	private String password;

	public User(String login,String password){
		setLogin(login);
		setPassword(password);
	}

	public void setLogin(String login) { this.login = login; }
	public void setPassword(String password) { this.password = password; }
	public String getLogin(){ return this.login; }
	public String getPassword(){ return this.password; }
}