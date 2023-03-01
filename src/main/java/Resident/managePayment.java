/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Resident;

import javax.swing.*;
import java.util.Map;

/**
 * @author yudhx
 */
public class managePayment extends javax.swing.JFrame {
    String residentID;

    //instantiate file handler
    Resident.residentFileHandler residentFileHandler = new residentFileHandler();

    /**
     * Creates new form makePayment
     */
    public managePayment(String residentID) {
        initComponents(residentID);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(String residentID) {

        this.residentID = residentID;

        managePaymentsTitle = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        managePaymentScrollPane = new javax.swing.JScrollPane();
        managePaymentPanel = new javax.swing.JPanel();
        makePaymentTitle = new javax.swing.JLabel();
        amountToPayTitle = new javax.swing.JLabel();
        makePaymentInput = new javax.swing.JTextField();
        receiptNumberTitle = new javax.swing.JLabel();
        receiptNumberOutput = new javax.swing.JTextField();
        pay = new javax.swing.JButton();
        outstandingFeeTitle = new javax.swing.JLabel();
        outstandingFeeOutput = new javax.swing.JLabel();
        javax.swing.JLabel viewPaymentHistoryTitle = new javax.swing.JLabel();
        javax.swing.JScrollPane viewPaymentHistoryPane = new javax.swing.JScrollPane();
        javax.swing.JTable viewPaymentHistoryTable = new javax.swing.JTable();
        javax.swing.JScrollPane viewInvoiceTablePane = new javax.swing.JScrollPane();
        viewInvoiceTable = new javax.swing.JTable();
        javax.swing.JLabel viewInvoiceTitle = new javax.swing.JLabel();
        javax.swing.JLabel viewReceiptTitle = new javax.swing.JLabel();
        javax.swing.JScrollPane viewReceiptPane = new javax.swing.JScrollPane();
        javax.swing.JTable viewReceiptTable = new javax.swing.JTable();
        javax.swing.JScrollPane viewStatementPane = new javax.swing.JScrollPane();
        javax.swing.JTable viewStatementTable = new javax.swing.JTable();
        javax.swing.JLabel viewStatementTitle = new javax.swing.JLabel();
        print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        managePaymentsTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        managePaymentsTitle.setText("Manage Payments");

        back.setBackground(new java.awt.Color(255, 0, 51));
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        managePaymentPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 51, 0), null));

        makePaymentTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        makePaymentTitle.setText("Make Payment");

        amountToPayTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        amountToPayTitle.setText("Amount to Pay");

        receiptNumberTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        receiptNumberTitle.setText("Receipt Number");

        receiptNumberOutput.setEnabled(false);

        pay.setBackground(new java.awt.Color(51, 255, 102));
        pay.setText("PAY");
        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });

        outstandingFeeTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        outstandingFeeTitle.setText("Outstanding Fee");

        outstandingFeeOutput.setFont(new java.awt.Font("Helvetica Neue", 0, 50)); // NOI18N

        viewPaymentHistoryTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        viewPaymentHistoryTitle.setText("View Payment History");

        viewPaymentHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Date", "Amount", "Amount Paid", "Total Amount Due", "Receipt ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        try {
            //read the data from the database
            Map<Integer, Map<String, String>> data = residentFileHandler.getPaymentHistory(residentID);
            if (data.size() != 0) {
                outstandingFeeOutput.setText(data.get(data.size()).get("TOTAL AMOUNT DUE"));
                viewPaymentHistoryTable.setEnabled(true);
                for (int i = 1; i < data.size() + 1; i++) {
                    //iterate through the data
                    for (Map.Entry<String, String> entry : data.get(i).entrySet()) {
                        for (int j = 0; j < viewPaymentHistoryTable.getColumnCount(); j++) {
                            if (entry.getKey().equals(viewPaymentHistoryTable.getColumnName(j).toUpperCase())) {
                                viewPaymentHistoryTable.setValueAt(entry.getValue(), i - 1, j);
                            }
                        }
                    }
                }
            } else {
                viewPaymentHistoryTable.setEnabled(false);
            }

        } catch(Exception e){
            e.printStackTrace();
        }
        viewPaymentHistoryPane.setViewportView(viewPaymentHistoryTable);
        if (viewPaymentHistoryTable.getColumnModel().getColumnCount() > 0) {
            viewPaymentHistoryTable.getColumnModel().getColumn(0).setHeaderValue("Date");
        }

        viewInvoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Resident Name", "Invoice Date", "Amount", "Invoice Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        try {
            //read the data from the database
            Map<Integer, Map<String, String>> data = residentFileHandler.getInvoice(residentID);
            if (data.size() != 0) {
                viewInvoiceTable.setEnabled(true);
                for (int i = 1; i < data.size() + 1; i++) {
                    //iterate through the data
                    for (Map.Entry<String, String> entry : data.get(i).entrySet()) {
                        for (int j = 0; j < viewInvoiceTable.getColumnCount(); j++) {
                            if (entry.getKey().equals(viewInvoiceTable.getColumnName(j).toUpperCase())) {
                                viewInvoiceTable.setValueAt(entry.getValue(), i - 1, j);
                            }
                        }
                    }
                }
            } else {
                viewInvoiceTable.setEnabled(false);
            }

        } catch(Exception e){
            e.printStackTrace();
        }
        viewInvoiceTablePane.setViewportView(viewInvoiceTable);

        viewInvoiceTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        viewInvoiceTitle.setText("View Invoice");

        viewReceiptTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        viewReceiptTitle.setText("View Receipt");

        viewReceiptTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Date", "Receipt ID", "Invoice ID", "Statement ID", "Amount", "Total Amount Paid"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        try {
            //read the data from the database
            Map<Integer, Map<String, String>> data = residentFileHandler.getReceipt(residentID);
            if (data.size() != 0) {
                viewReceiptTable.setEnabled(true);
                for (int i = 1; i < data.size() + 1; i++) {
                    //iterate through the data
                    for (Map.Entry<String, String> entry : data.get(i).entrySet()) {
                        for (int j = 0; j < viewReceiptTable.getColumnCount(); j++) {
                            if (entry.getKey().equals(viewReceiptTable.getColumnName(j).toUpperCase())) {
                                viewReceiptTable.setValueAt(entry.getValue(), i - 1, j);
                            }
                        }
                    }
                }
            } else {
                viewReceiptTable.setEnabled(false);
            }

        } catch(Exception e){
            e.printStackTrace();
        }
        viewReceiptPane.setViewportView(viewReceiptTable);

        viewStatementTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Date", "Building", "Unit Number", "Description", "Amount", "Total Amount Due", "Statement ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        try {
            //read the data from the database
            Map<Integer, Map<String, String>> data = residentFileHandler.getStatement(residentID);
            if (data.size() != 0) {
                viewStatementTable.setEnabled(true);
                for (int i = 1; i < data.size() + 1; i++) {
                    //iterate through the data
                    for (Map.Entry<String, String> entry : data.get(i).entrySet()) {
                        for (int j = 0; j < viewStatementTable.getColumnCount(); j++) {
                            if (entry.getKey().equals(viewStatementTable.getColumnName(j).toUpperCase())) {
                                viewStatementTable.setValueAt(entry.getValue(), i - 1, j);
                            }
                        }
                    }
                }
            } else {
                viewStatementTable.setEnabled(false);
            }

        } catch(Exception e){
            e.printStackTrace();
        }
        viewStatementPane.setViewportView(viewStatementTable);

        viewStatementTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        viewStatementTitle.setText("View Statement");

        print.setBackground(new java.awt.Color(102, 255, 102));
        print.setText("PRINT");
        print.setEnabled(false);

        javax.swing.GroupLayout managePaymentPanelLayout = new javax.swing.GroupLayout(managePaymentPanel);
        managePaymentPanel.setLayout(managePaymentPanelLayout);
        managePaymentPanelLayout.setHorizontalGroup(
            managePaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managePaymentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(managePaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(managePaymentPanelLayout.createSequentialGroup()
                        .addComponent(viewPaymentHistoryTitle)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managePaymentPanelLayout.createSequentialGroup()
                        .addGroup(managePaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amountToPayTitle)
                            .addGroup(managePaymentPanelLayout.createSequentialGroup()
                                .addGroup(managePaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(makePaymentTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(makePaymentInput))
                                .addGap(37, 37, 37)
                                .addGroup(managePaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(receiptNumberOutput, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(receiptNumberTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(35, 35, 35)
                                .addComponent(pay)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 385, Short.MAX_VALUE)
                        .addGroup(managePaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(managePaymentPanelLayout.createSequentialGroup()
                                .addComponent(outstandingFeeTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 380, Short.MAX_VALUE))
                            .addComponent(outstandingFeeOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managePaymentPanelLayout.createSequentialGroup()
                        .addGroup(managePaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(viewPaymentHistoryPane, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(viewInvoiceTablePane))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managePaymentPanelLayout.createSequentialGroup()
                        .addComponent(viewReceiptPane)
                        .addContainerGap())
                    .addGroup(managePaymentPanelLayout.createSequentialGroup()
                        .addGroup(managePaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(viewInvoiceTitle)
                            .addGroup(managePaymentPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(managePaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(viewReceiptTitle)
                                    .addComponent(viewStatementTitle))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managePaymentPanelLayout.createSequentialGroup()
                        .addComponent(viewStatementPane)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managePaymentPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(print)
                .addContainerGap())
        );
        managePaymentPanelLayout.setVerticalGroup(
            managePaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managePaymentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(managePaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountToPayTitle)
                    .addComponent(outstandingFeeTitle))
                .addGroup(managePaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(managePaymentPanelLayout.createSequentialGroup()
                        .addGroup(managePaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(makePaymentTitle)
                            .addComponent(receiptNumberTitle))
                        .addGap(5, 5, 5)
                        .addGroup(managePaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(receiptNumberOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                            .addComponent(makePaymentInput)))
                    .addGroup(managePaymentPanelLayout.createSequentialGroup()
                        .addComponent(outstandingFeeOutput)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(managePaymentPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(47, 47, 47)
                .addComponent(viewPaymentHistoryTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewPaymentHistoryPane, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewInvoiceTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewInvoiceTablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewReceiptTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewReceiptPane, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewStatementTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewStatementPane, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        managePaymentScrollPane.setViewportView(managePaymentPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(managePaymentsTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back))
                    .addComponent(managePaymentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1311, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(managePaymentsTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(managePaymentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1074, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        if (makePaymentInput.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //make sure amount and amount paid is numeric
        try {
            Double.parseDouble(makePaymentInput.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid amount", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //make sure amount and amount paid is non-negative
        if (Double.parseDouble(makePaymentInput.getText()) < 0) {
            JOptionPane.showMessageDialog(null, "Please enter a valid amount", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //make sure total amount due is not 0
        if (Double.parseDouble(outstandingFeeOutput.getText().replace("MYR", "")) == 0) {
            JOptionPane.showMessageDialog(null, "Outstanding fee is 0", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //amount should be equal or more than the amount paid
        if (Double.parseDouble(makePaymentInput.getText()) > Double.parseDouble(outstandingFeeOutput.getText().replace("MYR", ""))) {
            JOptionPane.showMessageDialog(null, "Amount paid should be equal or less than the outstanding amount", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //after user clicks this button, a series of steps will occur
        //we will first create a new statement record, then create a new invoice record, then create a new receipt record, get the receipt id, and then add a new payment record with the receipt id
        //get the new total amount due by subtracting the amount paid from the total amount due
        double newTotalAmountDue = Double.parseDouble(outstandingFeeOutput.getText().replace("MYR", "")) - Double.parseDouble(makePaymentInput.getText());
        //cast the above double to a string with "MYR" in front
        String newTotalAmountDueString = "MYR " + String.valueOf(newTotalAmountDue);

        String newStatementID = residentFileHandler.addStatement(
                "Resident",
                residentID,
                "Resident payment",
                makePaymentInput.getText().strip(),
                newTotalAmountDueString);

        String newInvoiceID = residentFileHandler.addInvoice(
                "Resident",
                residentID,
                makePaymentInput.getText().strip()
        );

        String newReceiptID = residentFileHandler.addReceipt(
                "Resident",
                residentID,
                newInvoiceID,
                newStatementID,
                outstandingFeeOutput.getText().strip(),
                makePaymentInput.getText().strip()
        );

        residentFileHandler.addPayment(
                "Resident",
                residentID,
                outstandingFeeOutput.getText().strip(),
                makePaymentInput.getText().strip(),
                "MYR " + String.valueOf(Double.parseDouble(outstandingFeeOutput.getText().strip().replace("MYR", "")) - Double.parseDouble(makePaymentInput.getText().strip())),
                newReceiptID
        );

        //sleep for 2 seconds
        try {
            pay.setEnabled(false);
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        //fill up the receipt number label
        receiptNumberOutput.setText(newReceiptID);
        //enable the print button
        print.setEnabled(true);
        pay.setEnabled(true);
        //show a success message
        JOptionPane.showMessageDialog(null, "Payment recorded successfully, your receipt number is " + newReceiptID, "Success", JOptionPane.INFORMATION_MESSAGE);
        makePaymentInput.setText("");
        //reload the frame
        new managePayment(residentID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_payActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // close this window and bring the previous one
        this.dispose();
        new Dashboard("RN001").setVisible(true);
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
            java.util.logging.Logger.getLogger(managePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managePayment(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountToPayTitle;
    private javax.swing.JButton back;
    private javax.swing.JTextField makePaymentInput;
    private javax.swing.JLabel makePaymentTitle;
    private javax.swing.JPanel managePaymentPanel;
    private javax.swing.JScrollPane managePaymentScrollPane;
    private javax.swing.JLabel managePaymentsTitle;
    private javax.swing.JLabel outstandingFeeOutput;
    private javax.swing.JLabel outstandingFeeTitle;
    private javax.swing.JButton pay;
    private javax.swing.JButton print;
    private javax.swing.JTextField receiptNumberOutput;
    private javax.swing.JLabel receiptNumberTitle;
    private javax.swing.JTable viewInvoiceTable;
    // End of variables declaration//GEN-END:variables
}
