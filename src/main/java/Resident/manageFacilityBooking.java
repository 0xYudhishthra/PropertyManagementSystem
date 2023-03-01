/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Resident;

import Helpers.BookingStatus;
import Helpers.FacilityList;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yudhx
 */
public class manageFacilityBooking extends javax.swing.JFrame {
    String residentID;

    //instantiate file handler
    Resident.residentFileHandler residentFileHandler = new residentFileHandler();

    /**
     * Creates new form manageFacilityBooking
     */
    public manageFacilityBooking(String residentID) {
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

        back = new javax.swing.JButton();
        manageBookingsTitle = new javax.swing.JLabel();
        manageBookingsScrollPane = new javax.swing.JScrollPane();
        manageBookingsPanel = new javax.swing.JPanel();
        facilityNameTitle = new javax.swing.JLabel();
        addBookingTitle = new javax.swing.JLabel();
        bookingNumberTitle = new javax.swing.JLabel();
        bookingNumberOutput = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        pendingBookingsTitle = new javax.swing.JLabel();
        viewPastBookingsPane = new javax.swing.JScrollPane();
        viewPastBookingsTable = new javax.swing.JTable();
        viewPastBookingsTitle = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        bookingDateTitle = new javax.swing.JLabel();
        startTimeTtile = new javax.swing.JLabel();
        endTimeTitle = new javax.swing.JLabel();
        endTimeInput = new javax.swing.JTextField();
        startTimeInput = new javax.swing.JTextField();
        pendingBookingsPane = new javax.swing.JScrollPane();
        pendingBookingsTable = new javax.swing.JTable();
        bookingDateInput = new javax.swing.JTextField();
        facilityFutsalCourtOption = new javax.swing.JCheckBox();
        facilityPoolOption = new javax.swing.JCheckBox();
        facilityLibraryOption = new javax.swing.JCheckBox();
        book = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        back.setBackground(new java.awt.Color(255, 0, 51));
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        manageBookingsTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        manageBookingsTitle.setText("Manage Bookings");

        manageBookingsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 51, 0), null));

        facilityNameTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        facilityNameTitle.setText("Facility Name");

        addBookingTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        addBookingTitle.setText("Add Booking");

        bookingNumberTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        bookingNumberTitle.setText("Booking Number");

        bookingNumberOutput.setEnabled(false);

        cancel.setBackground(new java.awt.Color(255, 51, 51));
        cancel.setText("CANCEL");
        cancel.setEnabled(false);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        pendingBookingsTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        pendingBookingsTitle.setText("Pending Bookings");

        viewPastBookingsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String[]{
                        "Facility Name", "Booking Date", "Start Time", "End Time", "Booking Number", "Status"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });

        //call the readData function from another
        try {
            //read the data from the database
            Map<Integer, Map<String, String>> data = residentFileHandler.getPastBookings("RN001");
            if (data.size() != 0) {
                viewPastBookingsTable.setEnabled(true);
                for (int i = 1; i < data.size() + 1; i++) {
                    //iterate through the data
                    for (Map.Entry<String, String> entry : data.get(i).entrySet()) {
                        for (int j = 0; j < viewPastBookingsTable.getColumnCount(); j++) {
                            if (entry.getKey().equals(viewPastBookingsTable.getColumnName(j).toUpperCase())) {
                                viewPastBookingsTable.setValueAt(entry.getValue(), i - 1, j);
                            }
                        }
                    }
                }
            } else {
                viewPastBookingsTable.setEnabled(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        viewPastBookingsPane.setViewportView(viewPastBookingsTable);

        viewPastBookingsTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        viewPastBookingsTitle.setText("View Past Bookings");

        update.setBackground(new java.awt.Color(102, 255, 102));
        update.setText("UPDATE");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        bookingDateTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        bookingDateTitle.setText("Booking Date");

        startTimeTtile.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        startTimeTtile.setText("Start Time");

        endTimeTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        endTimeTitle.setText("End Time");

        pendingBookingsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String[]{
                        "Facility Name", "Booking Date", "Start Time", "End Time", "Booking Number", "Status"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        //call the readData function from another
        try {
            //read the data from the database
            Map<Integer, Map<String, String>> data = residentFileHandler.getPendingBookings("RN001");
            if (data.size() != 0) {
                update.setEnabled(true);
                cancel.setEnabled(true);
                pendingBookingsTable.setEnabled(true);
                for (int i = 1; i < data.size() + 1; i++) {
                    //iterate through the data
                    for (Map.Entry<String, String> entry : data.get(i).entrySet()) {
                        for (int j = 0; j < pendingBookingsTable.getColumnCount(); j++) {
                            if (entry.getKey().equals(pendingBookingsTable.getColumnName(j).toUpperCase())) {
                                pendingBookingsTable.setValueAt(entry.getValue(), i - 1, j);
                            }
                        }
                    }
                }
            } else {
                pendingBookingsTable.setEnabled(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        pendingBookingsPane.setViewportView(pendingBookingsTable);

        facilityFutsalCourtOption.setText(FacilityList.GYM.toString().toUpperCase());

        facilityPoolOption.setText(FacilityList.SWIMMING_POOL.toString().toUpperCase());
        facilityPoolOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facilityPoolOptionActionPerformed(evt);
            }
        });

        facilityLibraryOption.setText(FacilityList.FUNCTION_ROOM.toString().toUpperCase());

        book.setBackground(new java.awt.Color(51, 255, 102));
        book.setText("BOOK");
        book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manageBookingsPanelLayout = new javax.swing.GroupLayout(manageBookingsPanel);
        manageBookingsPanel.setLayout(manageBookingsPanelLayout);
        manageBookingsPanelLayout.setHorizontalGroup(
                manageBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(manageBookingsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(manageBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(addBookingTitle)
                                        .addGroup(manageBookingsPanelLayout.createSequentialGroup()
                                                .addGroup(manageBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(manageBookingsPanelLayout.createSequentialGroup()
                                                                .addGroup(manageBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(facilityNameTitle)
                                                                        .addComponent(facilityFutsalCourtOption)
                                                                        .addComponent(facilityPoolOption))
                                                                .addGap(43, 43, 43)
                                                                .addGroup(manageBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(bookingDateInput)
                                                                        .addComponent(bookingDateTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addComponent(facilityLibraryOption))
                                                .addGap(46, 46, 46)
                                                .addGroup(manageBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(endTimeTitle)
                                                        .addComponent(startTimeTtile, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(startTimeInput, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(endTimeInput, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGap(61, 61, 61)
                                                .addGroup(manageBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(bookingNumberTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(bookingNumberOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(book))
                                        .addComponent(viewPastBookingsTitle)
                                        .addComponent(viewPastBookingsPane))
                                .addGroup(manageBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(manageBookingsPanelLayout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addGroup(manageBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(pendingBookingsTitle)
                                                        .addComponent(pendingBookingsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(24, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageBookingsPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(update)
                                                .addGap(25, 25, 25))))
        );
        manageBookingsPanelLayout.setVerticalGroup(
                manageBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(manageBookingsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(manageBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(manageBookingsPanelLayout.createSequentialGroup()
                                                .addComponent(pendingBookingsTitle)
                                                .addGap(18, 18, 18)
                                                .addComponent(pendingBookingsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(manageBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(manageBookingsPanelLayout.createSequentialGroup()
                                                .addComponent(addBookingTitle)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(manageBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(manageBookingsPanelLayout.createSequentialGroup()
                                                                .addGroup(manageBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(manageBookingsPanelLayout.createSequentialGroup()
                                                                                .addGroup(manageBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(bookingNumberTitle)
                                                                                        .addComponent(startTimeTtile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(bookingNumberOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(manageBookingsPanelLayout.createSequentialGroup()
                                                                                .addGap(36, 36, 36)
                                                                                .addComponent(startTimeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(12, 12, 12)
                                                                                .addComponent(endTimeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(endTimeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(manageBookingsPanelLayout.createSequentialGroup()
                                                                .addGroup(manageBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(facilityNameTitle)
                                                                        .addComponent(bookingDateTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(manageBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(bookingDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(facilityPoolOption))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(facilityLibraryOption)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(facilityFutsalCourtOption))
                                                        .addComponent(book, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(viewPastBookingsTitle)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(viewPastBookingsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(33, Short.MAX_VALUE))
        );

        manageBookingsScrollPane.setViewportView(manageBookingsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(manageBookingsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(manageBookingsTitle)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(back)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(manageBookingsTitle))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(manageBookingsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookActionPerformed
        //first check if all the fields are filled, and only one facility is selected
        if (bookingDateInput.getText().equals("") || startTimeInput.getText().equals("") ||
                endTimeInput.getText().equals("") || (!facilityPoolOption.isSelected() &&
                !facilityLibraryOption.isSelected() && !facilityFutsalCourtOption.isSelected())) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields");
            return;
        }

        //only one facility can be selected, so check if more than one is selected
        if (facilityPoolOption.isSelected() && facilityLibraryOption.isSelected() ||
                facilityPoolOption.isSelected() && facilityFutsalCourtOption.isSelected() ||
                facilityLibraryOption.isSelected() && facilityFutsalCourtOption.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please select only one facility");
            return;
        }

        //check the format of the date, it must be in ddmmyyyy
        if (bookingDateInput.getText().length() != 8) {
            JOptionPane.showMessageDialog(null, "Please enter the date in the format ddmmyyyy");
            return;
        }

        //the dd, mm and yyyy must be valid
        int day = Integer.parseInt(bookingDateInput.getText().substring(0, 2));
        int month = Integer.parseInt(bookingDateInput.getText().substring(2, 4));
        int year = Integer.parseInt(bookingDateInput.getText().substring(4, 8));
        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 2023 || year > 2023) {
            JOptionPane.showMessageDialog(null, "Please enter a valid date");
            return;
        }

        //check the format of the start time, it must be in HH:mm
        if (startTimeInput.getText().length() != 5) {
            JOptionPane.showMessageDialog(null, "Please enter the start time in the format HH:mm");
            return;
        }

        //the format submitted would be HH:mm, so we need to check if the HH and mm are valid, in the range 00-23 and 00-59 respectively
        int hour = Integer.parseInt(startTimeInput.getText().substring(0, 1));
        int minute = Integer.parseInt(startTimeInput.getText().substring(3, 4));
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            JOptionPane.showMessageDialog(null, "Please enter a valid start time");
            return;
        }

        //check the format of the end time, it must be in HH:mm
        if (endTimeInput.getText().length() != 5) {
            JOptionPane.showMessageDialog(null, "Please enter the end time in the format HH:mm");
            return;
        }

        //the format submitted would be HH:mm, so we need to check if the HH and mm are valid, in the range 00-23 and 00-59 respectively
        hour = Integer.parseInt(endTimeInput.getText().substring(0, 1));
        minute = Integer.parseInt(endTimeInput.getText().substring(3, 4));
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            JOptionPane.showMessageDialog(null, "Please enter a valid end time");
            return;
        }

        //check if the start time is before the end time
        if (Integer.parseInt(startTimeInput.getText().substring(0, 2)) > Integer.parseInt(endTimeInput.getText().substring(0, 2))) {
            JOptionPane.showMessageDialog(null, "Please enter a valid start and end time");
            return;
        }

        //get the new booking number
        String newBookingNumber = residentFileHandler.getNewBookingNumber(residentID);

        residentFileHandler.addBooking(
                residentID,
                //get the selected facility
                facilityPoolOption.isSelected() ? FacilityList.SWIMMING_POOL.toString().toUpperCase() :
                        facilityLibraryOption.isSelected() ? FacilityList.FUNCTION_ROOM.toString().toUpperCase() : FacilityList.GYM.toString().toUpperCase(),
                bookingDateInput.getText(),
                startTimeInput.getText(),
                endTimeInput.getText(),
                newBookingNumber,
                BookingStatus.PENDING.toString().toUpperCase()
        );

        //sleep for 2 seconds
        try {
            book.setEnabled(false);
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        //fill up the receipt number label
        bookingNumberOutput.setText(newBookingNumber);
        //enable the print button
        book.setEnabled(true);
        //show a success message
        JOptionPane.showMessageDialog(null, "Booking placed successfully, your booking number is " + newBookingNumber, "Success", JOptionPane.INFORMATION_MESSAGE);
        //reload the frame
        new manageFacilityBooking(residentID).setVisible(true);
        this.dispose();
    }



    private void facilityPoolOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facilityPoolOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_facilityPoolOptionActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        //first ensure that a row in the pending bookings table is selected
        if (pendingBookingsTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a booking to update");
            return;
        }

        //if selected row is null, tell the user to select a row with a booking
        if (pendingBookingsTable.getValueAt(pendingBookingsTable.getSelectedRow(), 0) == null) {
            JOptionPane.showMessageDialog(null, "Please select a booking to update");
            return;
        }

        //get the booking number of the selected row
        String bookingNumber = pendingBookingsTable.getValueAt(pendingBookingsTable.getSelectedRow(), 4).toString();
        String facility = pendingBookingsTable.getValueAt(pendingBookingsTable.getSelectedRow(), 0).toString();
        String date = pendingBookingsTable.getValueAt(pendingBookingsTable.getSelectedRow(), 1).toString();
        String startTime = pendingBookingsTable.getValueAt(pendingBookingsTable.getSelectedRow(), 2).toString();
        String endTime = pendingBookingsTable.getValueAt(pendingBookingsTable.getSelectedRow(), 3).toString();
        String status = pendingBookingsTable.getValueAt(pendingBookingsTable.getSelectedRow(), 5).toString();

        new updateFacilityBooking(bookingNumber, residentID, facility, date, startTime, endTime, status).setVisible(true);
        this.dispose();

    }//GEN-LAST:event_updateActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        //first ensure that a row in the pending bookings table is selected
        if (pendingBookingsTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a booking to cancel");
            return;
        }

        //if selected row is null, tell the user to select a row with a booking
        if (pendingBookingsTable.getValueAt(pendingBookingsTable.getSelectedRow(), 0) == null) {
            JOptionPane.showMessageDialog(null, "Please select a booking to cancel");
            return;
        }

        //get confirmation from the user
        int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this booking?", "Confirm", JOptionPane.YES_NO_OPTION);

        //if the user confirms, cancel the booking
        if (confirmation == JOptionPane.YES_OPTION) {
            HashMap<String, String> details = new HashMap<String, String>();
            details.put("RESIDENT ID", residentID);
            details.put("FACILITY NAME", pendingBookingsTable.getValueAt(pendingBookingsTable.getSelectedRow(), 0).toString());
            details.put("BOOKING DATE", pendingBookingsTable.getValueAt(pendingBookingsTable.getSelectedRow(), 1).toString());
            details.put("START TIME", pendingBookingsTable.getValueAt(pendingBookingsTable.getSelectedRow(), 2).toString());
            details.put("END TIME", pendingBookingsTable.getValueAt(pendingBookingsTable.getSelectedRow(), 3).toString());
            details.put("BOOKING NUMBER", pendingBookingsTable.getValueAt(pendingBookingsTable.getSelectedRow(), 4).toString());
            details.put("STATUS", BookingStatus.CANCELLED.toString().toUpperCase());

            //update the database
            boolean isBookingCancelled = residentFileHandler.updateBooking(residentID, details);
            JOptionPane.showMessageDialog(null, "Booking cancelled successfully");
            //reload the frame
            new manageFacilityBooking(residentID).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_cancelActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // close this window and open the previous window
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
            java.util.logging.Logger.getLogger(manageFacilityBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageFacilityBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageFacilityBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageFacilityBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageFacilityBooking(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addBookingTitle;
    private javax.swing.JButton back;
    private javax.swing.JButton book;
    private javax.swing.JTextField bookingDateInput;
    private javax.swing.JLabel bookingDateTitle;
    private javax.swing.JTextField bookingNumberOutput;
    private javax.swing.JLabel bookingNumberTitle;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField endTimeInput;
    private javax.swing.JLabel endTimeTitle;
    private javax.swing.JCheckBox facilityFutsalCourtOption;
    private javax.swing.JCheckBox facilityLibraryOption;
    private javax.swing.JLabel facilityNameTitle;
    private javax.swing.JCheckBox facilityPoolOption;
    private javax.swing.JPanel manageBookingsPanel;
    private javax.swing.JScrollPane manageBookingsScrollPane;
    private javax.swing.JLabel manageBookingsTitle;
    private javax.swing.JScrollPane pendingBookingsPane;
    private javax.swing.JTable pendingBookingsTable;
    private javax.swing.JLabel pendingBookingsTitle;
    private javax.swing.JTextField startTimeInput;
    private javax.swing.JLabel startTimeTtile;
    private javax.swing.JButton update;
    private javax.swing.JScrollPane viewPastBookingsPane;
    private javax.swing.JTable viewPastBookingsTable;
    private javax.swing.JLabel viewPastBookingsTitle;
    // End of variables declaration//GEN-END:variables
}
