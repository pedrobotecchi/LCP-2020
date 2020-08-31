package classes;

import java.util.Scanner;

public class Prompt
{
    private static Engine engine;
    private static Prompt app;
    
    private void sign_up(Engine engine)
    {
        Scanner input = new Scanner(System.in);

        System.out.printf("\n<< Name: ");
        String name = input.nextLine();
        
        System.out.printf("<< Surname: ");
        String surname = input.nextLine();
        
        System.out.printf("<< E-mail: ");
        String email = input.nextLine();
        
        System.out.printf("<< Phone number: ");
        String phone_number = input.nextLine();
        

        System.out.printf("\n<< User: ");
        String login_user = input.nextLine();
        
        System.out.printf("<< Password: ");
        String login_password = input.nextLine();
        
       // if ( engine.add_user(name, surname, email, phone_number, login_user, login_password, Engine engine = new Engine()))
       //     System.out.printf("\n>> User successfully created!\n");
       // else System.out.printf("\n>> User already exists!\n");
    }

    public void sign_in(Engine engine)
    {
        Scanner input = new Scanner(System.in);

        System.out.printf("\n<< User: ");
        String login_user = input.nextLine();
        
        System.out.printf("<< Password: ");
        String login_password = input.nextLine();

        if ( engine.login_user(login_user, login_password) )
            System.out.printf("\n>> Successfully signed in!\n");
        else
            System.out.printf("\n>> Wrong combination.. Try again later\n");
    }

    private void new_reminder(Engine engine)
    {
        Scanner input = new Scanner(System.in);

        System.out.printf("\n<< Title: ");
        String title = input.nextLine();
        
        System.out.printf("<< Desciption: ");
        String description = input.nextLine();

       // engine.add_reminder(title, description);
    }

    public static void main(String args[])
    {
        app = new Prompt();
        engine = new Engine();

        // -- command prompt app--
        Scanner input = new Scanner(System.in);
        int op;

        do
        {
            System.out.printf("\n-----------------------------------------\n");
            System.out.printf(">> To-do List Command Prompt (0 to close)\n");
            System.out.printf("\n>> 1. Sign up\n>> 2. Sign in\n>> 3. New reminder\n<< Op: ");
            
            op = input.nextInt();
            
            switch (op) 
            {
                case 1:
                    app.sign_up(engine);
                    break;
                
                case 2:
                    app.sign_in(engine);
                    break;

                case 3:
                    app.new_reminder(engine);
                    break;
                
                case 0:
                    System.out.printf("\n>> Closing app...");
                    break;
            }
        } while ( op != 0 );
        // -- command prompt app--
    }
}