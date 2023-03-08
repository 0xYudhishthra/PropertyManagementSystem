/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package User;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class loginsystem extends javax.swing.JFrame {

    /**
     * Creates new form loginsystem
     */
    public loginsystem() {
        initComponents();
        this.setLocationRelativeTo(null);// center form in the screen
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1close = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LoginUsername = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        visitor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(148, 172, 191));

        jLabel1close.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel1close.setText("x");
        jLabel1close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1closeMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel2.setText("Login");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1close)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1close)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26))
        );

        jPanel2.setBackground(new java.awt.Color(74, 98, 116));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(236, 240, 241));
        jLabel3.setText("Username:");

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 240, 241));
        jLabel4.setText("Password:");

        LoginUsername.setBackground(new java.awt.Color(152, 159, 167));
        LoginUsername.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        LoginUsername.setForeground(new java.awt.Color(250, 248, 246));
        LoginUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginUsernameActionPerformed(evt);
            }
        });

        password.setBackground(new java.awt.Color(152, 159, 167));
        password.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(250, 248, 246));

        loginButton.setBackground(new java.awt.Color(32, 123, 110));
        loginButton.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        cancel.setBackground(new java.awt.Color(185, 96, 92));
        cancel.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        visitor.setBackground(new java.awt.Color(204, 255, 204));
        visitor.setForeground(new java.awt.Color(0, 102, 102));
        visitor.setText("Visitor");
        visitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visitorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(visitor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(cancel)
                        .addGap(18, 18, 18)
                        .addComponent(loginButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LoginUsername)
                            .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(LoginUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(visitor))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginUsernameActionPerformed

    private void jLabel1closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1closeMouseClicked

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        String usernameInput = LoginUsername.getText();
        String passwordInput = String.valueOf(password.getPassword());
        String[] loginStat = new UserFileHandler().login(usernameInput, passwordInput);
        if(loginStat[0] == "Resident"){
            System.out.println(loginStat[1]);
            Resident.Dashboard resident = new Resident.Dashboard(loginStat[1]);
            resident.setVisible(true);
            this.dispose();
        }
        else if(loginStat[0] == "Security"){
            SecurityGuard.dashboard security = new SecurityGuard.dashboard(loginStat[1]);
            security.setVisible(true);
            this.dispose();
        }
         else if(loginStat[0] == "AccountExecutive"){
            AccountExecutive.Dashboard AccountExecutive  = new AccountExecutive.Dashboard(loginStat[1]);
            AccountExecutive.setVisible(true);
            this.dispose();
        }
         else if(loginStat[0] == "Vendor"){
             System.out.println(loginStat[1]);
            Vendor.Dashboard Vendor  = new Vendor.Dashboard(loginStat[1]);
            Vendor.setVisible(true);
            this.dispose();
        }
        else if(loginStat[0] == "AdminExecutive"){
            System.out.println(loginStat[1]);
            AdminExecutive.Dashboard AdminExecutive  = new AdminExecutive.Dashboard();
            AdminExecutive.setVisible(true);
           this.dispose();
        }
        else if(loginStat[0] == "BuildingManager"){
            System.out.println(loginStat[1]);
            BuildingManager.Dashboard BuildingManager  = new BuildingManager.Dashboard(loginStat[1]);
            BuildingManager.setVisible(true);
            this.dispose();
        }
        else if(loginStat[0] == "BuildingExecutive"){
            System.out.println(loginStat[1]);
            BuildingExecutive.Dashboard BuildingExecutive = new BuildingExecutive.Dashboard(loginStat[1]);
            BuildingExecutive.setVisible(true);
            this.dispose();
        }

        else{
            JOptionPane.showMessageDialog(null, "Invalid Username or Password");
        }

    }//GEN-LAST:event_loginButtonActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    private void visitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visitorActionPerformed
        // TODO add your handling code here:
        Visitor.VisitorPassCode visitor = new Visitor.VisitorPassCode();
        visitor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_visitorActionPerformed

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
            java.util.logging.Logger.getLogger(loginsystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginsystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginsystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginsystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginsystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField LoginUsername;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1close;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton visitor;
    // End of variables declaration//GEN-END:variables
}
