/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Resident;

/**
 * @author yudhx
 */
public class manageVisitorPass extends javax.swing.JFrame {

    /**
     * Creates new form manageVisitorPass
     */
    public manageVisitorPass() {
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

        manageVisitorPassScrollPane = new javax.swing.JScrollPane();
        manageVisitorPassPanel = new javax.swing.JPanel();
        visitorNameTitle = new javax.swing.JLabel();
        addVisitorPassTitle = new javax.swing.JLabel();
        visitorNumberTitle = new javax.swing.JLabel();
        visitorNumberOutput = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        currentVisitorPassTitle = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        visitDateTitle = new javax.swing.JLabel();
        currentVisitorPassPane = new javax.swing.JScrollPane();
        currentVisitorPassTable = new javax.swing.JTable();
        visitorNameInput = new javax.swing.JTextField();
        apply = new javax.swing.JButton();
        visitDateInput = new javax.swing.JTextField();
        vehicleNumberTitle = new javax.swing.JLabel();
        vehicleNumberInput = new javax.swing.JTextField();
        purposeTitle = new javax.swing.JLabel();
        purposeInput = new javax.swing.JTextField();
        manageVisitorPassTitle = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        manageVisitorPassPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 51, 0), null));

        visitorNameTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        visitorNameTitle.setText("Visitor Name");

        addVisitorPassTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        addVisitorPassTitle.setText("Add Visitor Pass");

        visitorNumberTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        visitorNumberTitle.setText("Visitor Number");

        visitorNumberOutput.setText("jTextField1");
        visitorNumberOutput.setEnabled(false);

        cancel.setBackground(new java.awt.Color(255, 51, 51));
        cancel.setText("CANCEL");
        cancel.setEnabled(false);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        currentVisitorPassTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        currentVisitorPassTitle.setText("Current Visitor Passes");

        update.setBackground(new java.awt.Color(102, 255, 102));
        update.setText("UPDATE");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        visitDateTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        visitDateTitle.setText("Visit Date");

        currentVisitorPassTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Facility Name", "Booking Date", "Start Time", "End Time", "Booking Number", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        currentVisitorPassTable.setEnabled(false);
        currentVisitorPassPane.setViewportView(currentVisitorPassTable);

        visitorNameInput.setText("jTextField4");

        apply.setBackground(new java.awt.Color(51, 255, 102));
        apply.setText("APPLY");
        apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyActionPerformed(evt);
            }
        });

        visitDateInput.setText("jTextField4");

        vehicleNumberTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        vehicleNumberTitle.setText("Vehicle Number");

        vehicleNumberInput.setText("jTextField1");

        purposeTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        purposeTitle.setText("Purpose");

        purposeInput.setText("jTextField1");

        javax.swing.GroupLayout manageVisitorPassPanelLayout = new javax.swing.GroupLayout(manageVisitorPassPanel);
        manageVisitorPassPanel.setLayout(manageVisitorPassPanelLayout);
        manageVisitorPassPanelLayout.setHorizontalGroup(
            manageVisitorPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageVisitorPassPanelLayout.createSequentialGroup()
                .addGroup(manageVisitorPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageVisitorPassPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update)
                        .addGap(1, 1, 1))
                    .addGroup(manageVisitorPassPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(manageVisitorPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currentVisitorPassPane, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(manageVisitorPassPanelLayout.createSequentialGroup()
                                .addGroup(manageVisitorPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addVisitorPassTitle)
                                    .addGroup(manageVisitorPassPanelLayout.createSequentialGroup()
                                        .addGroup(manageVisitorPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(visitorNameTitle)
                                            .addComponent(visitorNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(vehicleNumberInput, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(vehicleNumberTitle))
                                        .addGap(28, 28, 28)
                                        .addGroup(manageVisitorPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(visitDateTitle)
                                            .addComponent(visitDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(manageVisitorPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(purposeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(purposeInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(manageVisitorPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(visitorNumberTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(visitorNumberOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(currentVisitorPassTitle))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                                .addComponent(apply)))))
                .addContainerGap())
        );
        manageVisitorPassPanelLayout.setVerticalGroup(
            manageVisitorPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageVisitorPassPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manageVisitorPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(manageVisitorPassPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(manageVisitorPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(manageVisitorPassPanelLayout.createSequentialGroup()
                                .addGroup(manageVisitorPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageVisitorPassPanelLayout.createSequentialGroup()
                                        .addComponent(visitorNameTitle)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(visitorNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(manageVisitorPassPanelLayout.createSequentialGroup()
                                        .addComponent(visitDateTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(visitDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(manageVisitorPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(purposeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vehicleNumberTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(manageVisitorPassPanelLayout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addGroup(manageVisitorPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(purposeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(vehicleNumberInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(manageVisitorPassPanelLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(manageVisitorPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(manageVisitorPassPanelLayout.createSequentialGroup()
                                        .addComponent(visitorNumberTitle)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(visitorNumberOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(apply, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(addVisitorPassTitle))
                .addGap(18, 18, 18)
                .addComponent(currentVisitorPassTitle)
                .addGap(18, 18, 18)
                .addComponent(currentVisitorPassPane, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(manageVisitorPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        manageVisitorPassScrollPane.setViewportView(manageVisitorPassPanel);

        manageVisitorPassTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        manageVisitorPassTitle.setText("Manage Visitor Pass");

        back.setBackground(new java.awt.Color(255, 51, 51));
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageVisitorPassScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(manageVisitorPassTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageVisitorPassTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageVisitorPassScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void applyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_applyActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // close this window and bring the previous window
        this.dispose();
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(manageVisitorPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageVisitorPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageVisitorPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageVisitorPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageVisitorPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addVisitorPassTitle;
    private javax.swing.JButton apply;
    private javax.swing.JButton back;
    private javax.swing.JButton cancel;
    private javax.swing.JScrollPane currentVisitorPassPane;
    private javax.swing.JTable currentVisitorPassTable;
    private javax.swing.JLabel currentVisitorPassTitle;
    private javax.swing.JPanel manageVisitorPassPanel;
    private javax.swing.JScrollPane manageVisitorPassScrollPane;
    private javax.swing.JLabel manageVisitorPassTitle;
    private javax.swing.JTextField purposeInput;
    private javax.swing.JLabel purposeTitle;
    private javax.swing.JButton update;
    private javax.swing.JTextField vehicleNumberInput;
    private javax.swing.JLabel vehicleNumberTitle;
    private javax.swing.JTextField visitDateInput;
    private javax.swing.JLabel visitDateTitle;
    private javax.swing.JTextField visitorNameInput;
    private javax.swing.JLabel visitorNameTitle;
    private javax.swing.JTextField visitorNumberOutput;
    private javax.swing.JLabel visitorNumberTitle;
    // End of variables declaration//GEN-END:variables
}
