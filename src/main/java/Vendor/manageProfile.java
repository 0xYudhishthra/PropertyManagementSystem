/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vendor;

/**
 *
 * @author yudhx
 */
public class manageProfile extends javax.swing.JFrame {

    /**
     * Creates new form Profile
     */
    public manageProfile() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manageProfileScrollPane = new javax.swing.JScrollPane();
        manageProfilePanel = new javax.swing.JPanel();
        profilePicture = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        personalDetailsPanel = new javax.swing.JPanel();
        personalDetailsTitle = new javax.swing.JLabel();
        nameTitle = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        contactNumberInput = new javax.swing.JTextField();
        contactNumberTitle = new javax.swing.JLabel();
        emailTitle = new javax.swing.JLabel();
        emailInput = new javax.swing.JTextField();
        nationalityInput = new javax.swing.JTextField();
        nationalityTitle = new javax.swing.JLabel();
        nationalityTitle1 = new javax.swing.JLabel();
        nationalityInput1 = new javax.swing.JTextField();
        buildingDetailsPanel = new javax.swing.JPanel();
        buildingDetailsTitle = new javax.swing.JLabel();
        buildingTitle = new javax.swing.JLabel();
        buildingInput = new javax.swing.JTextField();
        unitNameInput = new javax.swing.JTextField();
        unitNameTitle = new javax.swing.JLabel();
        occupancyDetailsPanel = new javax.swing.JPanel();
        occupancyDetailsTitle = new javax.swing.JLabel();
        moveInDateTitle = new javax.swing.JLabel();
        moveInDateInput = new javax.swing.JTextField();
        accountDetailsPanel = new javax.swing.JPanel();
        accountDetailsTitle = new javax.swing.JLabel();
        usernameTitle = new javax.swing.JLabel();
        usernameInput = new javax.swing.JTextField();
        passwordTitle = new javax.swing.JLabel();
        passwordInput = new javax.swing.JTextField();
        manageProfileTitle = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        manageProfilePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 51, 0), null));

        profilePicture.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        profilePicture.setText("profilePicture");

        update.setBackground(new java.awt.Color(102, 255, 102));
        update.setText("UPDATE");

        personalDetailsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 0), null));

        personalDetailsTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        personalDetailsTitle.setText("Personal Details");

        nameTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        nameTitle.setText("Name");

        nameInput.setText("jTextField1");

        contactNumberInput.setText("jTextField1");

        contactNumberTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        contactNumberTitle.setText("Contact Number");

        emailTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        emailTitle.setText("Email");

        emailInput.setText("jTextField1");

        nationalityInput.setText("jTextField1");

        nationalityTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        nationalityTitle.setText("Nationality");

        nationalityTitle1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        nationalityTitle1.setText("Business Reg Number");

        nationalityInput1.setText("jTextField1");

        javax.swing.GroupLayout personalDetailsPanelLayout = new javax.swing.GroupLayout(personalDetailsPanel);
        personalDetailsPanel.setLayout(personalDetailsPanelLayout);
        personalDetailsPanelLayout.setHorizontalGroup(
            personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(personalDetailsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameTitle)
                        .addComponent(contactNumberTitle)
                        .addComponent(emailTitle)
                        .addComponent(nameInput)
                        .addComponent(contactNumberInput)
                        .addComponent(emailInput))
                    .addComponent(nationalityTitle)
                    .addComponent(nationalityInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nationalityTitle1)
                    .addComponent(nationalityInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        personalDetailsPanelLayout.setVerticalGroup(
            personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(personalDetailsTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contactNumberTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contactNumberInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(emailTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nationalityTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nationalityInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nationalityTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nationalityInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buildingDetailsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 0), null));

        buildingDetailsTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        buildingDetailsTitle.setText("Building Details");

        buildingTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        buildingTitle.setText("Building");

        buildingInput.setText("jTextField1");

        unitNameInput.setText("jTextField1");

        unitNameTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        unitNameTitle.setText("Unit Name");

        javax.swing.GroupLayout buildingDetailsPanelLayout = new javax.swing.GroupLayout(buildingDetailsPanel);
        buildingDetailsPanel.setLayout(buildingDetailsPanelLayout);
        buildingDetailsPanelLayout.setHorizontalGroup(
            buildingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buildingDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buildingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buildingDetailsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buildingTitle)
                    .addComponent(unitNameTitle)
                    .addComponent(buildingInput)
                    .addComponent(unitNameInput))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        buildingDetailsPanelLayout.setVerticalGroup(
            buildingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buildingDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buildingDetailsTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buildingTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buildingInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(unitNameTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(unitNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        occupancyDetailsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 0), null));

        occupancyDetailsTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        occupancyDetailsTitle.setText("Occupancy Details");

        moveInDateTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        moveInDateTitle.setText("Move-In Date");

        moveInDateInput.setText("jTextField1");
        moveInDateInput.setEnabled(false);

        javax.swing.GroupLayout occupancyDetailsPanelLayout = new javax.swing.GroupLayout(occupancyDetailsPanel);
        occupancyDetailsPanel.setLayout(occupancyDetailsPanelLayout);
        occupancyDetailsPanelLayout.setHorizontalGroup(
            occupancyDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(occupancyDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(occupancyDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(occupancyDetailsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(moveInDateTitle)
                    .addComponent(moveInDateInput))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        occupancyDetailsPanelLayout.setVerticalGroup(
            occupancyDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(occupancyDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(occupancyDetailsTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(moveInDateTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(moveInDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        accountDetailsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 0), null));

        accountDetailsTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        accountDetailsTitle.setText("Account Details");

        usernameTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        usernameTitle.setText("Username");

        usernameInput.setText("jTextField1");

        passwordTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        passwordTitle.setText("Password");

        passwordInput.setText("jTextField1");

        javax.swing.GroupLayout accountDetailsPanelLayout = new javax.swing.GroupLayout(accountDetailsPanel);
        accountDetailsPanel.setLayout(accountDetailsPanelLayout);
        accountDetailsPanelLayout.setHorizontalGroup(
            accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(accountDetailsPanelLayout.createSequentialGroup()
                        .addGroup(accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(accountDetailsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usernameTitle)
                            .addComponent(passwordTitle)
                            .addComponent(usernameInput))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(passwordInput))
                .addContainerGap())
        );
        accountDetailsPanelLayout.setVerticalGroup(
            accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(accountDetailsTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernameTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(passwordTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout manageProfilePanelLayout = new javax.swing.GroupLayout(manageProfilePanel);
        manageProfilePanel.setLayout(manageProfilePanelLayout);
        manageProfilePanelLayout.setHorizontalGroup(
            manageProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageProfilePanelLayout.createSequentialGroup()
                .addGroup(manageProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(manageProfilePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(personalDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(manageProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(manageProfilePanelLayout.createSequentialGroup()
                                .addComponent(buildingDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(occupancyDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(accountDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(manageProfilePanelLayout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(profilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manageProfilePanelLayout.setVerticalGroup(
            manageProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageProfilePanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(profilePicture)
                .addGap(44, 44, 44)
                .addGroup(manageProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(manageProfilePanelLayout.createSequentialGroup()
                        .addGroup(manageProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(accountDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buildingDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(occupancyDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(personalDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        manageProfileScrollPane.setViewportView(manageProfilePanel);

        manageProfileTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        manageProfileTitle.setText("Manage Profile");

        back.setBackground(new java.awt.Color(255, 51, 51));
        back.setText("BACK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageProfileScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(manageProfileTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(manageProfileTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageProfileScrollPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(manageProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accountDetailsPanel;
    private javax.swing.JLabel accountDetailsTitle;
    private javax.swing.JButton back;
    private javax.swing.JPanel buildingDetailsPanel;
    private javax.swing.JLabel buildingDetailsTitle;
    private javax.swing.JTextField buildingInput;
    private javax.swing.JLabel buildingTitle;
    private javax.swing.JTextField contactNumberInput;
    private javax.swing.JLabel contactNumberTitle;
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel emailTitle;
    private javax.swing.JPanel manageProfilePanel;
    private javax.swing.JScrollPane manageProfileScrollPane;
    private javax.swing.JLabel manageProfileTitle;
    private javax.swing.JTextField moveInDateInput;
    private javax.swing.JLabel moveInDateTitle;
    private javax.swing.JTextField nameInput;
    private javax.swing.JLabel nameTitle;
    private javax.swing.JTextField nationalityInput;
    private javax.swing.JTextField nationalityInput1;
    private javax.swing.JLabel nationalityTitle;
    private javax.swing.JLabel nationalityTitle1;
    private javax.swing.JPanel occupancyDetailsPanel;
    private javax.swing.JLabel occupancyDetailsTitle;
    private javax.swing.JTextField passwordInput;
    private javax.swing.JLabel passwordTitle;
    private javax.swing.JPanel personalDetailsPanel;
    private javax.swing.JLabel personalDetailsTitle;
    private javax.swing.JLabel profilePicture;
    private javax.swing.JTextField unitNameInput;
    private javax.swing.JLabel unitNameTitle;
    private javax.swing.JButton update;
    private javax.swing.JTextField usernameInput;
    private javax.swing.JLabel usernameTitle;
    // End of variables declaration//GEN-END:variables
}
