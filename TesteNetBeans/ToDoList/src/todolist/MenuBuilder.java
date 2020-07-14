/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.util.*;

/**
 *
 * @author Pedro Botecchi
 */
public class MenuBuilder {
    public int buildSignMenu(){
            boolean flag = true;
            int option = 0;
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
            
            return option;
    }
    
    public int buildSignUpMenu(){
            boolean flag = true;
            int option = 0;
            System.out.printf(":::::   ToDoList Project v1.0.0   :::::\n");
            System.out.printf("\n1 - Insert Event\n2 - Remove Events\n\n0 - Exit");
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
            
            return option;
    }
}
