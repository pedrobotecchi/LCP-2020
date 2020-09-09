/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.List;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.w3c.dom.css.RGBColor;

/**
 *
 * @author Pedro Botecchi
 */
public class BDFunctions {
    private com.mysql.jdbc.Connection myConn = null;
    private com.mysql.jdbc.Statement myStmt = null;
    
    private ResultSet myRs = null;
    
    private String user = "root";
    private String pass = "";
    private String url = "jdbc:mysql://localhost:3306/lcp?zeroDateTimeBehavior=convertToNull";
    
    public void bdConnect(){
        
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            myConn = (com.mysql.jdbc.Connection) DriverManager.getConnection(this.url,this.user,this.pass);
            myStmt = (com.mysql.jdbc.Statement) myConn.createStatement();
            
            JOptionPane.showMessageDialog(null, "Connected");
        } catch(Exception exc){
            JOptionPane.showMessageDialog(null, "NOT Connected");
        }
    }
    
    public String bdCheckUser(String login, Engine engine){
        try{
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            myConn = (com.mysql.jdbc.Connection) DriverManager.getConnection(this.url,this.user,this.pass);
            myStmt = (com.mysql.jdbc.Statement) myConn.createStatement();

            ResultSet RS= myStmt.executeQuery
                ("Select * from users where login='"+login+"'");
            
            while(RS.next()){
                User user;
                user = new User(RS.getString("name"),RS.getString("surname"),RS.getString("email"),RS.getString("phone_number"),login);
                
                password= RS.getString("password");

                engine.setCurrentUser(user);
            }
            RS.close();
            myStmt.close();
            myConn.close();
            
            return password;
        } catch(Exception exc){
            JOptionPane.showMessageDialog(null, "DataBase ERROR - Try again later !!!");
        }
        return "";
    }
    
    public boolean bdInsertUser(User user,String password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            myConn = (com.mysql.jdbc.Connection) DriverManager.getConnection(this.url,this.user,this.pass);
            myStmt = (com.mysql.jdbc.Statement) myConn.createStatement();

            myStmt.executeUpdate
                ("INSERT INTO users (name,surname,email,phone_number,login,password) VALUES ('"+user.getName()+"','"
                        +user.getSurname()+"','"
                        +user.getEmail()+"','"
                        +user.getPhoneNumber()+"','"
                        +user.getLogin()+"','"
                        +password+"');");
            
            return true;
        } catch( SQLException e){ //trata os erros SQL
            JOptionPane.showMessageDialog(null, "Erro Cmdo SQL " + e.getMessage() );
        } catch( ClassNotFoundException e){      //trata erros de conexão
            JOptionPane.showMessageDialog( null, " Driver não encontrado " );
        }
        return false;
    }
    
    public int bdSearchUserID(User user){
        try{
            int id = 0;

            Class.forName("com.mysql.jdbc.Driver");
            myConn = (com.mysql.jdbc.Connection) DriverManager.getConnection(this.url,this.user,this.pass);
            myStmt = (com.mysql.jdbc.Statement) myConn.createStatement();

            ResultSet RS= myStmt.executeQuery
                ("Select user_id from users where login='"+user.getLogin()+"'");
            
            if(RS.next()){
                id = RS.getInt("user_id");
            }
            RS.close();
            myStmt.close();
            myConn.close();
            
            return id;
        } catch(Exception exc){
            JOptionPane.showMessageDialog(null, "DataBase ERROR - Try again later !!!");
        }
        return -1;
    }
    
    public boolean bdAddReminder(Reminder reminder,int user_id){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            myConn = (com.mysql.jdbc.Connection) DriverManager.getConnection(this.url,this.user,this.pass);
            myStmt = (com.mysql.jdbc.Statement) myConn.createStatement();

            myStmt.executeUpdate
                ("INSERT INTO reminders (user_id,title,description,finished) VALUES ('"+user_id+"','"
                        +reminder.get_title()+"','"
                        +reminder.get_description()+"',false);");
            
            return true;
        } catch( SQLException e){ //trata os erros SQL
            JOptionPane.showMessageDialog(null, "Erro Cmdo SQL " + e.getMessage() );
        } catch( ClassNotFoundException e){      //trata erros de conexão
            JOptionPane.showMessageDialog( null, " Driver não encontrado " );
        }
        return false;
    }
    
    public ArrayList<Reminder> bdLoadReminders(User user){
        ArrayList<Reminder> reminderM = new ArrayList<Reminder>();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            myConn = (com.mysql.jdbc.Connection) DriverManager.getConnection(this.url,this.user,this.pass);
            myStmt = (com.mysql.jdbc.Statement) myConn.createStatement();

            ResultSet RS= myStmt.executeQuery
                ("Select * from reminders where user_id='"+bdSearchUserID(user)+"'");
            
            while(RS.next()){
                String title;
                String descr;
                boolean finished;

                title = RS.getString("title");
                descr = RS.getString("description");
                finished = RS.getBoolean("finished");
                int id = RS.getInt("reminder_id");
                
                Reminder rm = new Reminder(title,descr,finished);
                rm.setId(id);
                
                reminderM.add(rm);
            }
            RS.close();
            myStmt.close();
            myConn.close();
            
            return reminderM;
        } catch(Exception exc){
            JOptionPane.showMessageDialog(null, "DataBase ERROR - Try again later !!!");
        }
        return null;
    }
    
    public boolean bdUpdateUser(User user,String password_login,int id){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            myConn = (com.mysql.jdbc.Connection) DriverManager.getConnection(this.url,this.user,this.pass);
            myStmt = (com.mysql.jdbc.Statement) myConn.createStatement();

            myStmt.executeUpdate
                ("UPDATE users SET "
                        + "name='"+user.getName()+"',"
                        + "surname='"+user.getSurname()+"',"
                        + "email='"+user.getEmail()+"',"
                        + "phone_number='"+user.getPhoneNumber()+"',"
                        + "login='"+user.getLogin()+"',"
                        + "password='"+password_login+"' WHERE user_id="+id);
            
            return true;
        } catch( SQLException e){ //trata os erros SQL
            JOptionPane.showMessageDialog(null, "Erro Cmdo SQL " + e.getMessage() );
        } catch( ClassNotFoundException e){      //trata erros de conexão
            JOptionPane.showMessageDialog( null, " Driver não encontrado " );
        }
        return false;
    }
    
    public boolean bdUpdateReminder(Reminder reminder){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            myConn = (com.mysql.jdbc.Connection) DriverManager.getConnection(this.url,this.user,this.pass);
            myStmt = (com.mysql.jdbc.Statement) myConn.createStatement();

            myStmt.executeUpdate
                ("UPDATE reminders SET "
                        + "title='" + reminder.getTitle() +"',"
                        + "description='"+reminder.getDescription()+"',"
                        + "finished="+reminder.getFinished()+" WHERE reminder_id="+reminder.getId());
            
            return true;
        } catch( SQLException e){ //trata os erros SQL
            JOptionPane.showMessageDialog(null, "Erro Cmdo SQL " + e.getMessage() );
        } catch( ClassNotFoundException e){      //trata erros de conexão
            JOptionPane.showMessageDialog( null, " Driver não encontrado " );
        }
        return false;
    }
    
     public boolean bdRemoveReminder(Reminder reminder){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            myConn = (com.mysql.jdbc.Connection) DriverManager.getConnection(this.url,this.user,this.pass);
            myStmt = (com.mysql.jdbc.Statement) myConn.createStatement();

            myStmt.executeUpdate
                ("DELETE FROM reminders WHERE reminder_id ="+reminder.getId());
            
            return true;
        } catch( SQLException e){ //trata os erros SQL
            JOptionPane.showMessageDialog(null, "Erro Cmdo SQL " + e.getMessage() );
        } catch( ClassNotFoundException e){      //trata erros de conexão
            JOptionPane.showMessageDialog( null, " Driver não encontrado " );
        }
        return false;
    }
}
