/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Resident;

/**
 * @author yudhx
 */
public class manageComplaints extends javax.swing.JFrame {

    /**
     * Creates new form manageComplaints
     */
    public manageComplaints() {
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

        manageComplaintsScrollPane = new javax.swing.JScrollPane();
        manageComplaintsPanel = new javax.swing.JPanel();
        complaintDetailsTitle = new javax.swing.JLabel();
        addComplaintTitle = new javax.swing.JLabel();
        complaintNumberTitle = new javax.swing.JLabel();
        complaintNumberInput = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        pendingComplaintsTitle = new javax.swing.JLabel();
        pendingComplaintsPane = new javax.swing.JScrollPane();
        pendingComplaintsTable = new javax.swing.JTable();
        viewPastComplaintsTitle = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        complaintDateTitle = new javax.swing.JLabel();
        complaintDetailsInput = new javax.swing.JTextField();
        log = new javax.swing.JButton();
        complaintDateInput = new javax.swing.JTextField();
        viewPastComplaintsPane = new javax.swing.JScrollPane();
        viewPastComplaintsTable = new javax.swing.JTable();
        manageComplaintsTitle = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        manageComplaintsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 51, 0), null));

        complaintDetailsTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        complaintDetailsTitle.setText("Complaint Details");

        addComplaintTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        addComplaintTitle.setText("Add Complaint");

        complaintNumberTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        complaintNumberTitle.setText("Complaint Number");

        complaintNumberInput.setText("jTextField1");
        complaintNumberInput.setEnabled(false);

        delete.setBackground(new java.awt.Color(255, 51, 51));
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        pendingComplaintsTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        pendingComplaintsTitle.setText("Pending Complaints");

        pendingComplaintsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Date of Complaint", "Description", "Complaint Number", "Status"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        pendingComplaintsPane.setViewportView(pendingComplaintsTable);

        viewPastComplaintsTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        viewPastComplaintsTitle.setText("View Past Complaints");

        update.setBackground(new java.awt.Color(102, 255, 102));
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        complaintDateTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        complaintDateTitle.setText("Complaint Date");

        complaintDetailsInput.setText("jTextField4");

        log.setBackground(new java.awt.Color(51, 255, 102));
        log.setText("LOG");
        log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logActionPerformed(evt);
            }
        });

        complaintDateInput.setText("jTextField4");

        viewPastComplaintsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Date of Complaint", "Description", "Complaint Number", "Status"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        viewPastComplaintsPane.setViewportView(viewPastComplaintsTable);

        javax.swing.GroupLayout manageComplaintsPanelLayout = new javax.swing.GroupLayout(manageComplaintsPanel);
        manageComplaintsPanel.setLayout(manageComplaintsPanelLayout);
        manageComplaintsPanelLayout.setHorizontalGroup(
                manageComplaintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(manageComplaintsPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(manageComplaintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addComplaintTitle)
                                        .addGroup(manageComplaintsPanelLayout.createSequentialGroup()
                                                .addGroup(manageComplaintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(complaintDetailsTitle)
                                                        .addComponent(complaintDetailsInput, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(32, 32, 32)
                                                .addGroup(manageComplaintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(complaintDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(complaintDateTitle))
                                                .addGap(41, 41, 41)
                                                .addGroup(manageComplaintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(complaintNumberTitle)
                                                        .addComponent(complaintNumberInput, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(log))
                                        .addComponent(viewPastComplaintsTitle)
                                        .addComponent(viewPastComplaintsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(manageComplaintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pendingComplaintsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pendingComplaintsTitle)
                                        .addGroup(manageComplaintsPanelLayout.createSequentialGroup()
                                                .addComponent(delete)
                                                .addGap(18, 18, 18)
                                                .addComponent(update)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manageComplaintsPanelLayout.setVerticalGroup(
                manageComplaintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(manageComplaintsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(manageComplaintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(manageComplaintsPanelLayout.createSequentialGroup()
                                                .addGroup(manageComplaintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(pendingComplaintsTitle)
                                                        .addComponent(addComplaintTitle))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(pendingComplaintsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(manageComplaintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(manageComplaintsPanelLayout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(manageComplaintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(manageComplaintsPanelLayout.createSequentialGroup()
                                                                .addComponent(complaintNumberTitle)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(complaintNumberInput, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(manageComplaintsPanelLayout.createSequentialGroup()
                                                                .addGroup(manageComplaintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(complaintDetailsTitle)
                                                                        .addComponent(complaintDateTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(manageComplaintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(complaintDetailsInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(complaintDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(viewPastComplaintsTitle)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(viewPastComplaintsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        manageComplaintsScrollPane.setViewportView(manageComplaintsPanel);

        manageComplaintsTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        manageComplaintsTitle.setText("Manage Complaints");

        back.setBackground(new java.awt.Color(255, 0, 51));
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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(manageComplaintsTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 842, Short.MAX_VALUE)
                                .addComponent(back)
                                .addContainerGap())
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(manageComplaintsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(manageComplaintsTitle))
                                .addContainerGap(425, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(57, Short.MAX_VALUE)
                                        .addComponent(manageComplaintsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // close this window and bring up the previous one
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
            java.util.logging.Logger.getLogger(manageComplaints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageComplaints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageComplaints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageComplaints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageComplaints().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addComplaintTitle;
    private javax.swing.JButton back;
    private javax.swing.JTextField complaintDateInput;
    private javax.swing.JLabel complaintDateTitle;
    private javax.swing.JTextField complaintDetailsInput;
    private javax.swing.JLabel complaintDetailsTitle;
    private javax.swing.JTextField complaintNumberInput;
    private javax.swing.JLabel complaintNumberTitle;
    private javax.swing.JButton delete;
    private javax.swing.JButton log;
    private javax.swing.JPanel manageComplaintsPanel;
    private javax.swing.JScrollPane manageComplaintsScrollPane;
    private javax.swing.JLabel manageComplaintsTitle;
    private javax.swing.JScrollPane pendingComplaintsPane;
    private javax.swing.JTable pendingComplaintsTable;
    private javax.swing.JLabel pendingComplaintsTitle;
    private javax.swing.JButton update;
    private javax.swing.JScrollPane viewPastComplaintsPane;
    private javax.swing.JTable viewPastComplaintsTable;
    private javax.swing.JLabel viewPastComplaintsTitle;
    // End of variables declaration//GEN-END:variables
}
