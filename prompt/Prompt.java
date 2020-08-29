import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Prompt
{
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
        String user_login = input.nextLine();   // TODO: change var names to avoid confusion
        
        System.out.printf("<< Password: ");
        String password_login = input.nextLine();
        
        if ( engine.add_user(name, surname, email, phone_number, user_login, password_login) )
            System.out.printf("\n>> User successfully created!\n");
        else System.out.printf("\n>> User already exists!\n");
    }

    private void sign_in(Engine engine)
    {
        Scanner input = new Scanner(System.in);

        System.out.printf("\n<< User: ");
        String login_user = input.nextLine();
        
        System.out.printf("<< Password: ");
        String password_login = input.nextLine();

        if ( engine.login_user(login_user, password_login) )
            System.out.printf("\n>> Successfully signed in!\n");
        else
            System.out.printf("\n>> Wrong combination.. Try again later\n");
    }

    private void create_reminder(Engine engine)
    {
        Scanner input = new Scanner(System.in);

        System.out.printf("\n<< Title: ");
        String title = input.nextLine();
        
        System.out.printf("<< Desciption: ");
        String description = input.nextLine();

        if ( engine.add_reminder(title, description) )
            System.out.printf("\n>> Successfully created!\n");
        else
            System.out.printf("\n>> Login first!\n");
    }

    private void close_reminder(Engine engine)
    {
        Scanner input = new Scanner(System.in);

        System.out.printf("\n<< Reminder index: ");
        int index = input.nextInt();

        try
        {
            if ( engine.close_reminder(index) )
                System.out.printf("\n>> Successfully closed!\n");
            else
                System.out.printf("\n>> Login first!\n");
        }

        catch ( IndexOutOfBoundsException e ) { System.out.printf("\n>> Invalid index\n"); }
    }

    private void show_due_reminders(Engine engine)
    {
        ArrayList<Reminder> reminders = engine.get_due_reminders();
        
        if ( reminders != null )
        {
            Iterator<Reminder> i = reminders.iterator();
    
            System.out.println();
            while ( i.hasNext() )
            {
                Reminder cur_reminder = i.next();
                System.out.printf(">> Reminder: %s - %s\n", cur_reminder.get_title(), cur_reminder.get_description());
            }
        }
        else
            System.out.printf("\n>> Login first!\n");
    }

    private void show_closed_reminders(Engine engine)
    {
        ArrayList<Reminder> reminders = engine.get_closed_reminders();
        
        if ( reminders != null )
        {
            Iterator<Reminder> i = reminders.iterator();
    
            System.out.println();
            while ( i.hasNext() )
            {
                Reminder cur_reminder = i.next();
                System.out.printf(">> Reminder: %s - %s\n", cur_reminder.get_title(), cur_reminder.get_description());
            }
        }
        else
            System.out.printf("\n>> Login first!\n");
    }

    public static void main(String args[])
    {
        Prompt app = new Prompt();
        Engine engine = new Engine();

        // -- command prompt app--
        Scanner input = new Scanner(System.in);
        int op;

        do
        {
            System.out.printf("\n-----------------------------------------\n");
            System.out.printf(">> To-do List Command Prompt (0 to close)\n");
            System.out.printf("\n>> 1. Sign up\n>> 2. Sign in\n>> 3. Create reminder\n>> 4. Close reminder\n>> 5. Show due reminders\n>> 6. Show closed reminders\n<< Op: ");
            
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
                    app.create_reminder(engine);
                    break;

                case 4:
                    app.close_reminder(engine);
                    break;

                case 5:
                    app.show_due_reminders(engine);
                    break;

                case 6:
                    app.show_closed_reminders(engine);
                    break;
                
                case 0:
                    System.out.printf("\n>> Closing app...");
                    break;
            }
        } while ( op != 0 );
        // -- command prompt app--
    }
}