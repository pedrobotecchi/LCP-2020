/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcpproject;

import classes.*;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
/**
 *
 * @author Pedro Botecchi
 */
public class SignUp extends javax.swing.JFrame {
    /* --class User attributes-- */
    private String name;
    private String surname;
    private String email;
    private String phone_number;
    private String login_user;
    private String password_user;
    /* --classes -- */ 
    static SignUp sgUP;
    static SignIn sgIN;
    static Engine engine = new Engine();

    /**
     * Creates new form SignUp
     */
    public SignUp(SignIn sgIN) {
        initComponents();
        this.sgIN = sgIN;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        surnameField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        phoneField = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        cpasswordField = new javax.swing.JPasswordField();
        sendButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        incorrectField = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SignUp");
        setBounds(new java.awt.Rectangle(0, 0, 1280, 720));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("To-Do");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 60, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("List");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 70, 30));

        jLabel2.setBackground(new java.awt.Color(57, 57, 59));
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 110, 80));

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(213, 213, 213));
        jLabel4.setText("Sign Up");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 150, 60));

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(213, 213, 213));
        jLabel5.setText("Complete the Fields to sign up the system...");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 330, 20));

        jLabel6.setForeground(new java.awt.Color(213, 213, 213));
        jLabel6.setText("__________________________________________________________________");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 370, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Name:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 50, 20));
        getContentPane().add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 90, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Last Name:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, 110, -1));
        getContentPane().add(surnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, 120, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("E-mail: ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 60, 30));
        getContentPane().add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 190, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Phone:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 70, 40));

        phoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneFieldActionPerformed(evt);
            }
        });
        getContentPane().add(phoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 90, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Username:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 90, 20));
        getContentPane().add(userField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 190, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Password:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 80, 20));
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, 190, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Confirm Password:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, 100, 20));
        getContentPane().add(cpasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 180, 20));

        sendButton.setBackground(new java.awt.Color(50, 50, 52));
        sendButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        sendButton.setForeground(new java.awt.Color(255, 255, 255));
        sendButton.setText("Send");
        sendButton.setOpaque(false);
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 520, 90, -1));

        closeButton.setBackground(new java.awt.Color(255, 51, 51));
        closeButton.setText("X");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, 40, 30));

        incorrectField.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(incorrectField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 530, 230, 20));

        background.setFont(new java.awt.Font("Arial Narrow", 1, 48)); // NOI18N
        background.setForeground(new java.awt.Color(255, 255, 255));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lcpproject/Background.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void phoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneFieldActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        // TODO add your handling code here:
        
        //-- Vars Uses --//
        String cpassword;
        // Fazer a validação dos dados
        boolean validationFlag = false;
        
        /*-- Catch all the fields (Do a future validation) --*/
        name = nameField.getText();
        surname = surnameField.getText();
        phone_number = phoneField.getText();
        email = emailField.getText();
        login_user = userField.getText();
        password_user = new String(passwordField.getPassword());
        cpassword = new String(cpasswordField.getPassword());
        /*-- --*/
        
        /*-- Do the validations and set validation flag if something goes wrong --*/
        if(!password_user.equals(cpassword)){
            incorrectField.setText("Passwords does not match!!");
            passwordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            cpasswordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            validationFlag = true;
        }
        
        if(!engine.emailValidation(email)){
            incorrectField.setText("Invalid e-mail address!!");
            emailField.setBorder(BorderFactory.createLineBorder(Color.RED));
            validationFlag = true;
        } 
        
        if(!engine.phoneValidation(phone_number)){
            incorrectField.setText("Invalid phone number!!");
            phoneField.setBorder(BorderFactory.createLineBorder(Color.RED));
            validationFlag = true;
        }
        
        if(!validationFlag){
            User temp = new User(name,surname,email,phone_number,login_user);
                if(engine.add_user(temp, password_user)){
                    JOptionPane.showMessageDialog(null,"User Sined-up. Welcome!!");
                    sgIN.setEngine(engine);
                    setVisible(false);
                    sgIN.setVisible(true);   
                } else {
                    incorrectField.setText("User name already exists!!");
                    userField.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
        }
        
    }//GEN-LAST:event_sendButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        sgIN.setVisible(true);
    }//GEN-LAST:event_closeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                sgUP = new SignUp(sgIN);
                sgUP.setLocationRelativeTo(null);
                sgUP.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton closeButton;
    private javax.swing.JPasswordField cpasswordField;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel incorrectField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nameField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JFormattedTextField phoneField;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField surnameField;
    private javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables
}
