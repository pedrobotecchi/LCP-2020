/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.io.IOException;

/**
 *
 * @author Pedro Botecchi
 */
public class ScreenController {
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
