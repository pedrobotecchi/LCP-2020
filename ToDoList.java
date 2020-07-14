/****************************************************************
 *				Unesp Campus Rio Claro 							*
 *	Lingaguens Comerciais de Programação (2020 - 1º Semestre	*
 * 	Professora Simone											*
 *																*
 *	Project developed by:										*
 *			Pedro Henrique Botecchi								*
 *			Vinicius Silvestre Bueno							*
 *																*
 *--------------------------------------------------------------*
 *	The project consist of a ToDo List, created using Java,  	*
 *	where it's possible inserting and controlling things that 	*
 *	need to be done.											*
 *																*
 ***************************************************************/			


/*********************
 *	IMPORT SECTION   *
 *********************/
import java.util.*;
import java.io.IOException;

public class ToDoList{

	static int option = 1;

	public static void main(String[] args){

		ToDoList todo = new ToDoList();

		while(option!=0){
			todo.clrscr();
			todo.buildMenu();
			switch(option){
				case 1:
					// Calls a function to create a user
					break;
				case 2:
					// Calls a function to do the login
					break;
				case 0:
					option = 0;
					break;
				default:
					System.out.printf("The value typed it's not valid!");
					todo.pauseScreen();
					break; 
			}		
		}
	}

	public void buildMenu(){
		boolean flag = true;

		System.out.printf(":::::   ToDoList Project v1.0.0   :::::\n");
		System.out.printf("\n1 - Sign up\n2 - Sign in\n\n0 - EXIT");
		System.out.printf("\n>> Type your Option : ");

		while(flag){
			try{
				Scanner reading = new Scanner(System.in);
				option = reading.nextInt();
				flag = false;
			} catch(InputMismatchException e){
				System.out.printf("The value typed is not an integer. Retype : ");
			}
		}
	}

	public static void clrscr(){
    	//Clears Screen in java
    	try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    	} catch (IOException | InterruptedException ex) {}
	}

	public static void pauseScreen(){
		System.out.println("\nPress Any Key To Continue...");
        new java.util.Scanner(System.in).nextLine();
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