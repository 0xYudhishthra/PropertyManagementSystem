/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vendor;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * @author yudhx
 */
public class Dashboard extends javax.swing.JFrame {

    Vendor.vendorFileHandler vendorFileHandler = new Vendor.vendorFileHandler();

    /**
     * Creates new form Dasboard
     */
    public Dashboard() {
        initComponents();
    }

        public Dashboard(String UID) {
        // Get Customer Information from Login, then initialize
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profilePicture = new javax.swing.JLabel();
        greetingPrompt = new javax.swing.JLabel();
        greetingLabel = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        managePayments = new javax.swing.JButton();
        manageComplaints = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        try {
            Map<String, String> profileData = vendorFileHandler.getProfileDetails("VN001");
            for (Map.Entry<String, String> entry : profileData.entrySet()) {
                switch (entry.getKey()) {
                    case "PROFILE PICTURE":
                        profilePicture.setIcon(new ImageIcon("src/main/resources/Vendor/ProfilePictures/" + entry.getValue()));
                        Dimension size = profilePicture.getPreferredSize();
                        profilePicture.setBounds(10, 10, size.width, size.height);
                        Image img = ((ImageIcon) profilePicture.getIcon()).getImage();
                        Image newImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                        ImageIcon newImc = new ImageIcon(newImg);
                        profilePicture.setIcon(newImc);
                        break;
                    case "USERNAME":
                        greetingLabel.setText("Welcome, " + entry.getValue() + "!");
                        break;

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        profilePicture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //close this frame and bring up the profile page
                dispose();
                new manageProfile().setVisible(true);
            }
        });

        greetingPrompt.setBackground(new java.awt.Color(51, 255, 0));
        greetingPrompt.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        greetingPrompt.setText("What would you like to do today?");

        greetingLabel.setBackground(new java.awt.Color(102, 255, 0));
        greetingLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        logout.setBackground(new java.awt.Color(255, 0, 51));
        logout.setText("LOGOUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        managePayments.setText("Manage Payments");
        managePayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePaymentsActionPerformed(evt);
            }
        });

        manageComplaints.setText("Manage Complaints");
        manageComplaints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageComplaintsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(greetingPrompt)
                                                        .addComponent(greetingLabel))
                                                .addGap(46, 46, 46)
                                                .addComponent(profilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(logout))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(managePayments, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(manageComplaints, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(greetingLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(greetingPrompt))
                                        .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(profilePicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(managePayments, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(manageComplaints, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // first prompt the user if they are sure they want to logout, if yes, then close the current window and bring up the login window
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout", dialogButton);
        if (dialogResult == 0) {
            // close this window and bring up the login window
//            login login = new login();
//            login.setVisible(true);
            this.dispose();
            //exit the program
            System.exit(0);
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void managePaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePaymentsActionPerformed
        // close this window and bring up the manage payments window
        managePayment managePayment = new managePayment();
        managePayment.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_managePaymentsActionPerformed

    private void manageComplaintsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageComplaintsActionPerformed
        // close this window and bring up the manage complaints window
        manageComplaints manageComplaints = new manageComplaints();
        manageComplaints.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageComplaintsActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel greetingLabel;
    private javax.swing.JLabel greetingPrompt;
    private javax.swing.JButton logout;
    private javax.swing.JButton manageComplaints;
    private javax.swing.JButton managePayments;
    private javax.swing.JLabel profilePicture;
    // End of variables declaration//GEN-END:variables
}
