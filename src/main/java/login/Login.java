/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package login;

import Database.DbOperations;
import javax.swing.JOptionPane;
import Database.user;
import Tabs.Products;
import java.awt.Insets;
import java.awt.Toolkit;
import java.sql.*;


/**
 *
 * @author Muskan
 */
public class Login extends javax.swing.JFrame {
     
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        btnLogin.setEnabled(false);
        setScreenFull();
    }
    public void setScreenFull()
    {
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xs=(int)tk.getScreenSize().getWidth();
        int ys=(int)tk.getScreenSize().getHeight();
        Insets scnMax=Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
        int taskBarSize=scnMax.bottom;
    
        this.setSize(xs,ys);
    }
    public void clear()
    {
        txtuname.setText("");
        btnLogin.setEnabled(false);
    }
    public void validateFields()
    {
        if(txtuname.getText().isEmpty() || txtpassword.getText().isEmpty())
        {
            btnLogin.setEnabled(false);
        }
        else
        {
            btnLogin.setEnabled(true);
        }
    }
    public void login(String uname, String password)
    {
        user user=null;
        try
        {
            ResultSet rs=DbOperations.getData("select * from user where uname='"+txtuname+"' and password='"+txtpassword+"'");
            while(rs.next())
            {
                user=new user();
                user.setStatus(rs.getString("status"));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtuname = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        bthForgot = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        bthExit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        signup = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 55)); // NOI18N
        jLabel6.setText("Anu Cosmetics");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 200, 410, 60));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("LOGIN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 101, -1));

        jLabel2.setFont(new java.awt.Font("Footlight MT Light", 3, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/password.png"))); // NOI18N
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, -1));

        jLabel3.setFont(new java.awt.Font("Footlight MT Light", 3, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/username.png"))); // NOI18N
        jLabel3.setText("Username");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 46, 130, -1));

        txtuname.setToolTipText("Enter Username\n");
        txtuname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtunameActionPerformed(evt);
            }
        });
        txtuname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtunameKeyReleased(evt);
            }
        });
        jPanel1.add(txtuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 298, 28));

        txtpassword.setToolTipText("Enter your password");
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpasswordKeyReleased(evt);
            }
        });
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 270, 28));

        bthForgot.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        bthForgot.setForeground(new java.awt.Color(51, 51, 255));
        bthForgot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/forgot-password.png"))); // NOI18N
        bthForgot.setText("Forgot Password?");
        bthForgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthForgotActionPerformed(evt);
            }
        });
        jPanel1.add(bthForgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 184, -1, -1));

        btnLogin.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 51, 51));
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 142, -1, -1));

        bthExit.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        bthExit.setForeground(new java.awt.Color(0, 51, 51));
        bthExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
        bthExit.setText("Exit");
        bthExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthExitActionPerformed(evt);
            }
        });
        jPanel1.add(bthExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, 30));

        btnClear.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(0, 51, 51));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clear.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 260, 110, 30));

        signup.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        signup.setForeground(new java.awt.Color(255, 51, 51));
        signup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sign up.png"))); // NOI18N
        signup.setText("Sign Up");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        jPanel1.add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 227, -1, 30));

        jLabel4.setFont(new java.awt.Font("Footlight MT Light", 3, 14)); // NOI18N
        jLabel4.setText("Don't Have an Account?");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 161, 25));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 270, 560, 330));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/walpaper.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtunameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtunameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtunameActionPerformed

    private void bthForgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthForgotActionPerformed
        // TODO add your handling code here:
        
            setVisible(false);
            new ForgotPass().setVisible(true);
        
    }//GEN-LAST:event_bthForgotActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        PreparedStatement ps;
        ResultSet rs;
        String uname = txtuname.getText();
        String pass = String.valueOf(txtpassword.getPassword());
        
        String query = "SELECT * FROM user WHERE name =? AND password =?";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_management_system","root","");
            ps = con.prepareStatement(query);
            
            ps.setString(1, uname);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                    new Products().setVisible(true);
                    this.dispose();
            }
            else{
                    JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
                }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void bthExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthExitActionPerformed
    int a= JOptionPane.showConfirmDialog(null,"Do you really want to close this page?","select",JOptionPane.YES_NO_OPTION);
    if(a==0)
    {
        System.exit(0);
    }
// TODO add your handling code here:
    }//GEN-LAST:event_bthExitActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtuname.setText("");
        txtpassword.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new SignUp().setVisible(true); 
    }//GEN-LAST:event_signupActionPerformed

    private void txtunameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtunameKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtunameKeyReleased

    private void txtpasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtpasswordKeyReleased

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bthExit;
    private javax.swing.JButton bthForgot;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton signup;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtuname;
    // End of variables declaration//GEN-END:variables
}
