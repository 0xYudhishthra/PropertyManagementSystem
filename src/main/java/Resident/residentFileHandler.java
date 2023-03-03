package Resident;

import Helpers.BookingStatus;
import Helpers.ComplaintStatus;
import Helpers.FileHandler;

import java.text.SimpleDateFormat;
import java.util.*;

public class residentFileHandler extends FileHandler {
    @Override
    public ArrayList<String> readData(String filename, String id, String userRole) throws Exception {
        return super.readData(filename, id, userRole);
    }

    @Override
    public ArrayList<String> readData(String filename, String userRole) throws Exception {
        return super.readData(filename, userRole);
    }

    @Override
    public ArrayList<String> getFileHeader(String filename, String userRole) {
        return super.getFileHeader(filename, userRole);
    }

    public Map<Integer, Map<String, String>> getPendingComplaints(String residentID) {
        {
            try {
                ComplaintStatus pendingStatus = ComplaintStatus.PENDING;
                ComplaintStatus inProgressStatus = ComplaintStatus.IN_PROGRESS;
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> complaintMap = new HashMap<>();

                ArrayList<String> complaints = readData("residentComplaint", "resident");
                //also get file header
                ArrayList<String> fileHeader = getFileHeader("residentComplaint", "resident");
                int dataCount = 0;
                for (String complaint : complaints) {
                    Map<String, String> complaintDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] complaintDetailsArray = complaint.split(dataSeparator);
                    String residentIDFromComplaint = complaintDetailsArray[0];
                    String complaintStatus = complaintDetailsArray[complaintDetailsArray.length - 1];
                    //for each char in residentID, check if it is equal to the char in residentIDFromComplaint
                    //if it is, then print true
                    //if it is not, then print false
                    if (residentIDFromComplaint.strip().equals(residentID.strip()) && (complaintStatus.toUpperCase().equals(pendingStatus.toString()) || complaintStatus.toUpperCase().equals(inProgressStatus.toString()))) {
                        int count = 0;
                        int columnCount = 0;

                        for (int i = 0; i < complaint.length(); i++) {
                            if (dataSeparator.charAt(1) == complaint.charAt(i)) {
                                //this means that there is data before the data separator
                                //get the data in reverse by iterating through the string backwards, and then join the string back together in the correct order
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator
                                int end = start - count + 2;

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                //add the char to the temp string
                                for (int j = start; j >= end; j--) temp.append(complaint.charAt(j));
                                //reverse the string
                                var sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                //manually iterate through te sb string, and remove all spaces and super.dataSeparator char at
                                for (int k = 0; k < sb.length(); k++) {
                                    if (sb.charAt(k) == dataSeparator.charAt(1)) {
                                        sb.deleteCharAt(k);
                                    }
                                }
                                //remove any space from the first index of the string
                                if (sb.charAt(0) == ' ') {
                                    sb.deleteCharAt(0);
                                }

                                complaintDetails.put(fileHeader.get(columnCount), sb.toString());
                                //reset the count
                                count = 0;
                                columnCount++;

                            }

                            //if we are reaching the last element in the line, then we need to add the last element to the map
                            if (i == complaint.length() - 1) {
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - count + 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = i; j >= start; j--) {
                                    //add the char to the temp string
                                    temp.append(complaint.charAt(j));
                                }
                                //reverse the string
                                var sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                columnCount++;
                                complaintDetails.put(fileHeader.get(columnCount - 1), sb.toString());
                                columnCount++;
                            }

                            count++;
                        }
                        dataCount++;
                        complaintMap.put(dataCount, complaintDetails);

                    }
                }
                return complaintMap;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    public Map<Integer, Map<String, String>> getPastComplaints(String residentID) {
        try {
            ComplaintStatus resolvedStatus = ComplaintStatus.RESOLVED;
            ComplaintStatus closedStatus = ComplaintStatus.CLOSED;
            //create a list of complaints
            //from the call of the second readData function above, get the list of complaints
            Map<Integer, Map<String, String>> complaintMap = new HashMap<>();

            ArrayList<String> complaints = readData("residentComplaint", "resident");
            //also get file header
            ArrayList<String> fileHeader = getFileHeader("residentComplaint", "resident");

            int dataCount = 0;
            for (String complaint : complaints) {
                Map<String, String> complaintDetails = new HashMap<>();
                //get the last index of the complaint, which is the status of the complaint
                String[] complaintDetailsArray = complaint.split(dataSeparator);
                String residentIDFromComplaint = complaintDetailsArray[0];
                String complaintStatus = complaintDetailsArray[complaintDetailsArray.length - 1];
                if (residentIDFromComplaint.strip().equals(residentID.strip()) && (complaintStatus.toUpperCase().equals(resolvedStatus.toString()) || complaintStatus.toUpperCase().equals(closedStatus.toString()))) {
                    int count = 0;
                    int columnCount = 0;

                    for (int i = 0; i < complaint.length(); i++) {
                        if (complaint.charAt(i) == dataSeparator.charAt(1)) {
                            //this means that there is data before the data separator
                            //get the data in reverse by iterating through the string backwards, and then join the string back together in the correct order
                            //get the value to start iterating from backwards, which is the index of the data separator - 1
                            int start = i - 2;
                            //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator
                            int end = start - count + 2;

                            //create temp string to store the data
                            StringBuilder temp = new StringBuilder();
                            //iterate through the string backwards
                            for (int j = start; j >= end; j--) {
                                //add the char to the temp string
                                temp.append(complaint.charAt(j));
                            }
                            //reverse the string
                            StringBuilder sb = new StringBuilder(temp.toString());
                            sb.reverse();
                            //manually iterate through te sb string, and remove all spaces and super.dataSeparator char at
                            for (int k = 0; k < sb.length(); k++) {
                                if (sb.charAt(k) == dataSeparator.charAt(1)) {
                                    sb.deleteCharAt(k);
                                }
                            }
                            //remove any space from the first index of the string
                            if (sb.charAt(0) == ' ') {
                                sb.deleteCharAt(0);
                            }

                            complaintDetails.put(fileHeader.get(columnCount), sb.toString());
                            //reset the count
                            count = 0;
                            columnCount++;

                        }

                        //if we are reaching the last element in the line, then we need to add the last element to the map
                        if (i == complaint.length() - 1) {
                            //get the value to start iterating from backwards, which is the index of the data separator - 1
                            int start = i - count + 2;
                            //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                            //create temp string to store the data
                            StringBuilder temp = new StringBuilder();
                            //iterate through the string backwards
                            for (int j = i; j >= start; j--) {
                                //add the char to the temp string
                                temp.append(complaint.charAt(j));
                            }
                            //reverse the string
                            StringBuilder sb = new StringBuilder(temp.toString());
                            sb.reverse();
                            columnCount++;
                            complaintDetails.put(fileHeader.get(columnCount - 1), sb.toString());
                            columnCount++;
                        }

                        count++;
                    }
                    dataCount++;
                    complaintMap.put(dataCount, complaintDetails);

                }
            }
            return complaintMap;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public Map<Integer, Map<String, String>> getPendingBookings(String residentID) {
        {
            try {
                BookingStatus pendingStatus = BookingStatus.PENDING;
                BookingStatus confirmedStatus = BookingStatus.CONFIRMED;
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> bookingMap = new HashMap<>();

                ArrayList<String> bookings = readData("residentFacilityBooking", "resident");
                //also get file header
                ArrayList<String> fileHeader = getFileHeader("residentFacilityBooking", "resident");
                int dataCount = 0;
                for (String booking : bookings) {
                    Map<String, String> bookingDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] complaintDetailsArray = booking.split(dataSeparator);
                    String residentIDFromComplaint = complaintDetailsArray[0];
                    String complaintStatus = complaintDetailsArray[complaintDetailsArray.length - 1];
                    if (residentID.strip().equals(residentIDFromComplaint.strip()) && (complaintStatus.toUpperCase().equals(pendingStatus.toString()) || complaintStatus.toUpperCase().equals(confirmedStatus.toString()))) {
                        int count = 0;
                        int columnCount = 0;

                        for (int i = 0; i < booking.length(); i++) {
                            if (booking.charAt(i) == dataSeparator.charAt(1)) {
                                //this means that there is data before the data separator
                                //get the data in reverse by iterating through the string backwards, and then join the string back together in the correct order
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator
                                int end = start - count + 2;

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = start; j >= end; j--) {
                                    //add the char to the temp string
                                    temp.append(booking.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                //manually iterate through te sb string, and remove all spaces and super.dataSeparator char at
                                for (int k = 0; k < sb.length(); k++) {
                                    if (sb.charAt(k) == dataSeparator.charAt(1)) {
                                        sb.deleteCharAt(k);
                                    }
                                }
                                //remove any space from the first index of the string
                                if (sb.charAt(0) == ' ') {
                                    sb.deleteCharAt(0);
                                }

                                bookingDetails.put(fileHeader.get(columnCount), sb.toString());
                                //reset the count
                                count = 0;
                                columnCount++;

                            }

                            //if we are reaching the last element in the line, then we need to add the last element to the map
                            if (i == booking.length() - 1) {
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - count + 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = i; j >= start; j--) {
                                    //add the char to the temp string
                                    temp.append(booking.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                columnCount++;
                                bookingDetails.put(fileHeader.get(columnCount - 1), sb.toString());
                                columnCount++;
                            }

                            count++;
                        }
                        dataCount++;
                        bookingMap.put(dataCount, bookingDetails);

                    }
                }
                return bookingMap;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    public Map<Integer, Map<String, String>> getPastBookings(String residentID) {
        {
            try {
                BookingStatus pendingStatus = BookingStatus.CANCELLED;
                BookingStatus confirmedStatus = BookingStatus.COMPLETED;
                Map<Integer, Map<String, String>> bookingMap = new HashMap<>();

                ArrayList<String> bookings = readData("residentFacilityBooking", "resident");
                //also get file header
                ArrayList<String> fileHeader = getFileHeader("residentFacilityBooking", "resident");
                int dataCount = 0;
                for (String booking : bookings) {
                    Map<String, String> bookingDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] complaintDetailsArray = booking.split(dataSeparator);
                    String residentIDFromComplaint = complaintDetailsArray[0];
                    String complaintStatus = complaintDetailsArray[complaintDetailsArray.length - 1];
                    if (residentIDFromComplaint.strip().equals(residentID.strip()) && (complaintStatus.toUpperCase().equals(pendingStatus.toString()) || complaintStatus.toUpperCase().equals(confirmedStatus.toString()))) {
                        int count = 0;
                        int columnCount = 0;

                        for (int i = 0; i < booking.length(); i++) {
                            if (booking.charAt(i) == dataSeparator.charAt(1)) {
                                //this means that there is data before the data separator
                                //get the data in reverse by iterating through the string backwards, and then join the string back together in the correct order
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator
                                int end = start - count + 2;

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = start; j >= end; j--) {
                                    //add the char to the temp string
                                    temp.append(booking.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                //manually iterate through te sb string, and remove all spaces and super.dataSeparator char at
                                for (int k = 0; k < sb.length(); k++) {
                                    if (sb.charAt(k) == dataSeparator.charAt(1)) {
                                        sb.deleteCharAt(k);
                                    }
                                }
                                //remove any space from the first index of the string
                                if (sb.charAt(0) == ' ') {
                                    sb.deleteCharAt(0);
                                }

                                bookingDetails.put(fileHeader.get(columnCount), sb.toString());
                                //reset the count
                                count = 0;
                                columnCount++;

                            }

                            //if we are reaching the last element in the line, then we need to add the last element to the map
                            if (i == booking.length() - 1) {
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - count + 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = i; j >= start; j--) {
                                    //add the char to the temp string
                                    temp.append(booking.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                columnCount++;
                                bookingDetails.put(fileHeader.get(columnCount - 1), sb.toString());
                                columnCount++;
                            }

                            count++;
                        }
                        dataCount++;
                        bookingMap.put(dataCount, bookingDetails);

                    }
                }
                return bookingMap;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    public Map<Integer, Map<String, String>> getBookings(String residentID) {
        {
            try {
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> paymentMap = new HashMap<>();

                ArrayList<String> bookings = readData("residentFacilityBooking", "Resident");
                System.out.println(bookings);
                //also get file header
                ArrayList<String> fileHeader = getFileHeader("residentFacilityBooking", "Resident");
                int dataCount = 0;
                for (String booking : bookings) {
                    Map<String, String> bookingDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] bookingDetailsArray = booking.split(dataSeparator);
                    String residentIDFromBooking = bookingDetailsArray[0];
                    System.out.println(residentIDFromBooking);
                    if (residentID.strip().equals(residentIDFromBooking.strip())) {
                        int count = 0;
                        int columnCount = 0;

                        for (int i = 0; i < booking.length(); i++) {
                            if (booking.charAt(i) == dataSeparator.charAt(1)) {
                                //this means that there is data before the data separator
                                //get the data in reverse by iterating through the string backwards, and then join the string back together in the correct order
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator
                                int end = start - count + 2;

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = start; j >= end; j--) {
                                    //add the char to the temp string
                                    temp.append(booking.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                //manually iterate through te sb string, and remove all spaces and super.dataSeparator char at
                                for (int k = 0; k < sb.length(); k++) {
                                    if (sb.charAt(k) == dataSeparator.charAt(1)) {
                                        sb.deleteCharAt(k);
                                    }
                                }
                                //remove any space from the first index of the string
                                if (sb.charAt(0) == ' ') {
                                    sb.deleteCharAt(0);
                                }

                                bookingDetails.put(fileHeader.get(columnCount), sb.toString());
                                //reset the count
                                count = 0;
                                columnCount++;

                            }

                            //if we are reaching the last element in the line, then we need to add the last element to the map
                            if (i == booking.length() - 1) {
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - count + 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = i; j >= start; j--) {
                                    //add the char to the temp string
                                    temp.append(booking.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                columnCount++;
                                bookingDetails.put(fileHeader.get(columnCount - 1), sb.toString());
                                columnCount++;
                            }

                            count++;
                        }
                        dataCount++;
                        paymentMap.put(dataCount, bookingDetails);

                    }
                }
                return paymentMap;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    public Map<Integer, Map<String, String>> getPaymentHistory(String residentID) {
        {
            try {
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> paymentMap = new HashMap<>();

                ArrayList<String> payments = readData("residentPayment", "AccountExecutive");
                //also get file header
                ArrayList<String> fileHeader = getFileHeader("residentPayment", "AccountExecutive");
                int dataCount = 0;
                for (String payment : payments) {
                    Map<String, String> bookingDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] paymentDetailsArray = payment.split(dataSeparator);
                    String residentIDFromPayment = paymentDetailsArray[2];
                    if (residentIDFromPayment.strip().equals(residentID.strip())) {
                        int count = 0;
                        int columnCount = 0;

                        for (int i = 0; i < payment.length(); i++) {
                            if (payment.charAt(i) == dataSeparator.charAt(1)) {
                                //this means that there is data before the data separator
                                //get the data in reverse by iterating through the string backwards, and then join the string back together in the correct order
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator
                                int end = start - count + 2;

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = start; j >= end; j--) {
                                    //add the char to the temp string
                                    temp.append(payment.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                //manually iterate through te sb string, and remove all spaces and super.dataSeparator char at
                                for (int k = 0; k < sb.length(); k++) {
                                    if (sb.charAt(k) == dataSeparator.charAt(1)) {
                                        sb.deleteCharAt(k);
                                    }
                                }
                                //remove any space from the first index of the string
                                if (sb.charAt(0) == ' ') {
                                    sb.deleteCharAt(0);
                                }

                                bookingDetails.put(fileHeader.get(columnCount), sb.toString());
                                //reset the count
                                count = 0;
                                columnCount++;

                            }

                            //if we are reaching the last element in the line, then we need to add the last element to the map
                            if (i == payment.length() - 1) {
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - count + 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = i; j >= start; j--) {
                                    //add the char to the temp string
                                    temp.append(payment.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                columnCount++;
                                bookingDetails.put(fileHeader.get(columnCount - 1), sb.toString());
                                columnCount++;
                            }

                            count++;
                        }
                        dataCount++;
                        paymentMap.put(dataCount, bookingDetails);

                    }
                }
                return paymentMap;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    public Map<Integer, Map<String, String>> getInvoice(String residentID) {
        {
            try {
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> invoiceMap = new HashMap<>();

                ArrayList<String> invoices = readData("residentInvoice", "AccountExecutive");
                //also get file header
                ArrayList<String> fileHeader = getFileHeader("residentInvoice", "AccountExecutive");
                int dataCount = 0;
                for (String invoice : invoices) {
                    Map<String, String> invoiceDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] invoiceDetailsArray = invoice.split(dataSeparator);
                    String residentIDFromInvoice = invoiceDetailsArray[3];
                    if (residentIDFromInvoice.strip().equals(residentID.strip())) {
                        int count = 0;
                        int columnCount = 0;

                        for (int i = 0; i < invoice.length(); i++) {
                            if (invoice.charAt(i) == dataSeparator.charAt(1)) {
                                //this means that there is data before the data separator
                                //get the data in reverse by iterating through the string backwards, and then join the string back together in the correct order
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator
                                int end = start - count + 2;

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = start; j >= end; j--) {
                                    //add the char to the temp string
                                    temp.append(invoice.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                //manually iterate through te sb string, and remove all spaces and super.dataSeparator char at
                                for (int k = 0; k < sb.length(); k++) {
                                    if (sb.charAt(k) == dataSeparator.charAt(1)) {
                                        sb.deleteCharAt(k);
                                    }
                                }
                                //remove any space from the first index of the string
                                if (sb.charAt(0) == ' ') {
                                    sb.deleteCharAt(0);
                                }

                                invoiceDetails.put(fileHeader.get(columnCount), sb.toString());
                                //reset the count
                                count = 0;
                                columnCount++;

                            }

                            //if we are reaching the last element in the line, then we need to add the last element to the map
                            if (i == invoice.length() - 1) {
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - count + 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = i; j >= start; j--) {
                                    //add the char to the temp string
                                    temp.append(invoice.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                columnCount++;
                                invoiceDetails.put(fileHeader.get(columnCount - 1), sb.toString());
                                columnCount++;
                            }

                            count++;
                        }
                        dataCount++;
                        invoiceMap.put(dataCount, invoiceDetails);

                    }
                }
                return invoiceMap;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    public Map<Integer, Map<String, String>> getReceipt(String residentID) {
        {
            try {
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> receiptMap = new HashMap<>();

                ArrayList<String> receipts = readData("residentReceipt", "AccountExecutive");
                //also get file header
                ArrayList<String> fileHeader = getFileHeader("residentReceipt", "AccountExecutive");
                int dataCount = 0;
                for (String receipt : receipts) {
                    Map<String, String> invoiceDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] receiptDetailsArray = receipt.split(dataSeparator);
                    String residentIDFromReceipt = receiptDetailsArray[4];
                    if (residentIDFromReceipt.strip().equals(residentID.strip())) {
                        int count = 0;
                        int columnCount = 0;

                        for (int i = 0; i < receipt.length(); i++) {
                            if (receipt.charAt(i) == dataSeparator.charAt(1)) {
                                //this means that there is data before the data separator
                                //get the data in reverse by iterating through the string backwards, and then join the string back together in the correct order
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator
                                int end = start - count + 2;

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                //add the char to the temp string
                                for (int j = start; j >= end; j--) temp.append(receipt.charAt(j));
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                //manually iterate through te sb string, and remove all spaces and super.dataSeparator char at
                                for (int k = 0; k < sb.length(); k++) {
                                    if (sb.charAt(k) == dataSeparator.charAt(1)) {
                                        sb.deleteCharAt(k);
                                    }
                                }
                                //remove any space from the first index of the string
                                if (sb.charAt(0) == ' ') {
                                    sb.deleteCharAt(0);
                                }

                                invoiceDetails.put(fileHeader.get(columnCount), sb.toString());
                                //reset the count
                                count = 0;
                                columnCount++;

                            }

                            //if we are reaching the last element in the line, then we need to add the last element to the map
                            if (i == receipt.length() - 1) {
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - count + 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = i; j >= start; j--) {
                                    //add the char to the temp string
                                    temp.append(receipt.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                columnCount++;
                                invoiceDetails.put(fileHeader.get(columnCount - 1), sb.toString());
                                columnCount++;
                            }

                            count++;
                        }
                        dataCount++;
                        receiptMap.put(dataCount, invoiceDetails);

                    }
                }
                return receiptMap;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    public Map<Integer, Map<String, String>> getStatement(String residentID) {
        {
            try {
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> statementMap = new HashMap<>();

                ArrayList<String> statements = readData("residentStatement", "AccountExecutive");
                //also get file header
                ArrayList<String> fileHeader = getFileHeader("residentStatement", "AccountExecutive");
                int dataCount = 0;
                for (String statement : statements) {
                    Map<String, String> invoiceDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] statementDetailsArray = statement.split(dataSeparator);
                    String residentIDFromStatement = statementDetailsArray[5];
                    if (residentIDFromStatement.strip().equals(residentID.strip())) {
                        int count = 0;
                        int columnCount = 0;

                        for (int i = 0; i < statement.length(); i++) {
                            if (statement.charAt(i) == dataSeparator.charAt(1)) {
                                //this means that there is data before the data separator
                                //get the data in reverse by iterating through the string backwards, and then join the string back together in the correct order
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator
                                int end = start - count + 2;

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = start; j >= end; j--) {
                                    //add the char to the temp string
                                    temp.append(statement.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                //manually iterate through te sb string, and remove all spaces and super.dataSeparator char at
                                for (int k = 0; k < sb.length(); k++) {
                                    if (sb.charAt(k) == dataSeparator.charAt(1)) {
                                        sb.deleteCharAt(k);
                                    }
                                }
                                //remove any space from the first index of the string
                                if (sb.charAt(0) == ' ') {
                                    sb.deleteCharAt(0);
                                }

                                invoiceDetails.put(fileHeader.get(columnCount), sb.toString());
                                //reset the count
                                count = 0;
                                columnCount++;

                            }

                            //if we are reaching the last element in the line, then we need to add the last element to the map
                            if (i == statement.length() - 1) {
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - count + 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = i; j >= start; j--) {
                                    //add the char to the temp string
                                    temp.append(statement.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                columnCount++;
                                invoiceDetails.put(fileHeader.get(columnCount - 1), sb.toString());
                                columnCount++;
                            }

                            count++;
                        }
                        dataCount++;
                        statementMap.put(dataCount, invoiceDetails);

                    }
                }
                return statementMap;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    public Map<String, String> getProfileDetails(String residentID) {
        try {
            //create a list of complaints
            //from the call of the second readData function above, get the list of complaints
            Map<String, String> profileDetails = new HashMap<>();

            ArrayList<String> profiles = readData("residentDetail", "resident");
            //also get file header
            ArrayList<String> fileHeader = getFileHeader("residentDetail", "resident");
            for (String profile : profiles) {
                //get the last index of the complaint, which is the status of the complaint
                String[] profileDetailsArray = profile.split(dataSeparator);
                String residentIDFromProfile = profileDetailsArray[0];
                if (residentID.strip().equals(residentIDFromProfile.strip())) {
                    int count = 0;
                    int columnCount = 0;
                    for (int i = 0; i < profile.length(); i++) {
                        if (profile.charAt(i) == dataSeparator.charAt(1)) {
                            //this means that there is data before the data separator
                            //get the data in reverse by iterating through the string backwards, and then join the string back together in the correct order
                            //get the value to start iterating from backwards, which is the index of the data separator - 1
                            int start = i - 2;
                            //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator
                            int end = start - count + 2;

                            //create temp string to store the data
                            StringBuilder temp = new StringBuilder();
                            //iterate through the string backwards
                            for (int j = start; j > end; j--) {
                                //add the char to the temp string
                                temp.append(profile.charAt(j));
                            }
                            //reverse the string
                            StringBuilder sb = new StringBuilder(temp.toString());
                            sb.reverse();
                            //manually iterate through te sb string, and remove all spaces and super.dataSeparator char at
                            for (int k = 0; k < sb.length(); k++) {
                                if (sb.charAt(k) == dataSeparator.charAt(1)) {
                                    sb.deleteCharAt(k);
                                }
                            }
                            //remove any space from the first index of the string
                            if (sb.charAt(0) == ' ') {
                                sb.deleteCharAt(0);
                            }
                            profileDetails.put(fileHeader.get(columnCount), sb.toString());
                            //reset the count
                            count = 0;
                            columnCount++;

                        }

                        //if we are reaching the last element in the line, then we need to add the last element to the map
                        if (i == profile.length() - 1) {
                            //get the value to start iterating from backwards, which is the index of the data separator - 1
                            int start = i - count + 2;
                            //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                            //create temp string to store the data
                            StringBuilder temp = new StringBuilder();
                            //iterate through the string backwards
                            //add the char to the temp string
                            for (int j = i; j >= start; j--) temp.append(profile.charAt(j));
                            //reverse the string
                            StringBuilder sb = new StringBuilder(temp.toString());
                            sb.reverse();
                            columnCount++;
                            profileDetails.put(fileHeader.get(columnCount - 1), sb.toString());
                            columnCount++;
                        }
                        count++;
                    }
                    return profileDetails;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public Map<Integer, Map<String, String>> getVisitorPasses(String residentID) {
        {
            try {
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> passMap = new HashMap<>();

                ArrayList<String> passes = readData("residentVisitorPass", "resident");

                //also get file header
                ArrayList<String> fileHeader = getFileHeader("residentVisitorPass", "resident");
                int dataCount = 0;
                for (String pass : passes) {
                    Map<String, String> passDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] passDetailsArray = pass.split(dataSeparator);
                    String residentIDFromPass = passDetailsArray[0];
                    if (residentIDFromPass.strip().equals(residentID.strip())) {
                        int count = 0;
                        int columnCount = 0;

                        for (int i = 0; i < pass.length(); i++) {
                            if (pass.charAt(i) == dataSeparator.charAt(1)) {
                                //this means that there is data before the data separator
                                //get the data in reverse by iterating through the string backwards, and then join the string back together in the correct order
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator
                                int end = start - count + 2;

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = start; j >= end; j--) {
                                    //add the char to the temp string
                                    temp.append(pass.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                //manually iterate through te sb string, and remove all spaces and super.dataSeparator char at
                                for (int k = 0; k < sb.length(); k++) {
                                    if (sb.charAt(k) == dataSeparator.charAt(1)) {
                                        sb.deleteCharAt(k);
                                    }
                                }
                                //remove any space from the first index of the string
                                if (sb.charAt(0) == ' ') {
                                    sb.deleteCharAt(0);
                                }

                                passDetails.put(fileHeader.get(columnCount), sb.toString());
                                //reset the count
                                count = 0;
                                columnCount++;

                            }

                            //if we are reaching the last element in the line, then we need to add the last element to the map
                            if (i == pass.length() - 1) {
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - count + 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = i; j >= start; j--) {
                                    //add the char to the temp string
                                    temp.append(pass.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                columnCount++;
                                passDetails.put(fileHeader.get(columnCount - 1), sb.toString());
                                columnCount++;
                            }

                            count++;
                        }
                        dataCount++;
                        passMap.put(dataCount, passDetails);

                    }
                }
                return passMap;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    //build a getComplaints
    public Map<Integer, Map<String, String>> getComplaints(String residentID) {
        {
            try {
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> passMap = new HashMap<>();

                ArrayList<String> complaints = readData("residentComplaint", "resident");

                //also get file header
                ArrayList<String> fileHeader = getFileHeader("residentComplaint", "resident");
                int dataCount = 0;
                for (String complaint : complaints) {
                    Map<String, String> passDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] passDetailsArray = complaint.split(dataSeparator);
                    String residentIDFromPass = passDetailsArray[0];
                    if (residentIDFromPass.strip().equals(residentID.strip())) {
                        int count = 0;
                        int columnCount = 0;

                        for (int i = 0; i < complaint.length(); i++) {
                            if (complaint.charAt(i) == dataSeparator.charAt(1)) {
                                //this means that there is data before the data separator
                                //get the data in reverse by iterating through the string backwards, and then join the string back together in the correct order
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator
                                int end = start - count + 2;

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = start; j >= end; j--) {
                                    //add the char to the temp string
                                    temp.append(complaint.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                //manually iterate through te sb string, and remove all spaces and super.dataSeparator char at
                                for (int k = 0; k < sb.length(); k++) {
                                    if (sb.charAt(k) == dataSeparator.charAt(1)) {
                                        sb.deleteCharAt(k);
                                    }
                                }
                                //remove any space from the first index of the string
                                if (sb.charAt(0) == ' ') {
                                    sb.deleteCharAt(0);
                                }

                                passDetails.put(fileHeader.get(columnCount), sb.toString());
                                //reset the count
                                count = 0;
                                columnCount++;

                            }

                            //if we are reaching the last element in the line, then we need to add the last element to the map
                            if (i == complaint.length() - 1) {
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - count + 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = i; j >= start; j--) {
                                    //add the char to the temp string
                                    temp.append(complaint.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                columnCount++;
                                passDetails.put(fileHeader.get(columnCount - 1), sb.toString());
                                columnCount++;
                            }

                            count++;
                        }
                        dataCount++;
                        passMap.put(dataCount, passDetails);

                    }
                }
                return passMap;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    public String getNewStatementID(String userID) {
        //use the get statement method to get the latest statement ID
        Map<Integer, Map<String, String>> statementMap = getStatement(userID);
        //get the last key in the map
        int lastKey = statementMap.size();

        if (statementMap.isEmpty()) {
            return "ST1";
        } else {
            //get the statement ID from the map
            String statementID = statementMap.get(lastKey).get("STATEMENT ID");
            //Statement id is in format ST002, so we need to get the last 3 digits, and convert it to an int, and add 1 to it
            int statementIDInt = Integer.parseInt(statementID.substring(2));
            statementIDInt++;
            //convert the int back to a string
            statementID = "ST" + statementIDInt;
            return statementID;
        }
    }

    //this function will get the latest invoice ID
    public String getNewInvoiceID(String userID) {
        //use the get statement method to get the latest statement ID
        Map<Integer, Map<String, String>> invoiceMap = getInvoice(userID);
        //get the last key in the map
        int lastKey = invoiceMap.size();
        //get the statement ID from the map
        if (invoiceMap.isEmpty()) {
            return "INV1";
        } else {
            //Statement id is in format ST002, so we need to get the last 3 digits, and convert it to an int, and add 1 to it
            String statementID = invoiceMap.get(lastKey).get("INVOICE ID");
            int statementIDInt = Integer.parseInt(statementID.substring(3));
            statementIDInt++;
            //convert the int back to a string
            statementID = "INV" + statementIDInt;
            return statementID;
        }
    }

    public String getNewReceiptID(String userID) {
        //use the get statement method to get the latest statement ID
        Map<Integer, Map<String, String>> receiptMap = getReceipt(userID);
        //get the last key in the map
        int lastKey = receiptMap.size();

        if (receiptMap.isEmpty()) {
            return "R1";
        } else {
            //get the statement ID from the map
            String receiptID = receiptMap.get(lastKey).get("RECEIPT ID");
            //Statement id is in format ST002, so we need to get the last 3 digits, and convert it to an int, and add 1 to it
            int receiptIDInt = Integer.parseInt(receiptID.substring(1));
            receiptIDInt++;
            //convert the int back to a string
            receiptID = "R" + receiptIDInt;
            return receiptID;
        }
    }

    public String getNewBookingNumber(String userID) {
        //use the get statement method to get the latest statement ID
        Map<Integer, Map<String, String>> bookingMap = getBookings(userID);
        System.out.println(bookingMap);
        //get the last key in the map
        int lastKey = bookingMap.size();
        //get the statement ID from the map
        String bookingID = bookingMap.get(lastKey).get("BOOKING NUMBER");
        //Statement id is in format ST002, so we need to get the last 3 digits, and convert it to an int, and add 1 to it
        int receiptIDInt = Integer.parseInt(bookingID.substring(2));
        receiptIDInt++;
        //convert the int back to a string
        bookingID = "BK" + receiptIDInt;
        return bookingID;
    }

    public String getNewVisitorPassNumber(String userID) {
        //use the get statement method to get the latest statement ID
        Map<Integer, Map<String, String>> visitorPassMap = getVisitorPasses(userID);
        System.out.println(visitorPassMap);
        //get the last key in the map
        int lastKey = visitorPassMap.size();

        String visitorPassNumber;

        if (visitorPassMap.isEmpty()) {
            visitorPassNumber = "VP1";
        } else {
            //Statement id is in format ST002, so we need to get the last 3 digits, and convert it to an int, and add 1 to it
            visitorPassNumber = visitorPassMap.get(lastKey).get("VISITOR PASS NUMBER");
            int receiptIDInt = Integer.parseInt(visitorPassNumber.substring(2));
            receiptIDInt++;
            //convert the int back to a string
            visitorPassNumber = "VP" + receiptIDInt;
        }
        return visitorPassNumber;
    }

    public String getNewComplaintNumber(String userID) {
        //use the get statement method to get the latest statement ID
        Map<Integer, Map<String, String>> complaintMap = getComplaints(userID);
        System.out.println(complaintMap);
        //get the last key in the map
        int lastKey = complaintMap.size();
        //get the statement ID from the map
        if (complaintMap.isEmpty()) {
            return "C1";
        } else {
            String complaintNumber = complaintMap.get(lastKey).get("COMPLAINT NUMBER");
            //Statement id is in format ST002, so we need to get the last 3 digits, and convert it to an int, and add 1 to it
            int receiptIDInt = Integer.parseInt(complaintNumber.substring(1));
            receiptIDInt++;
            //convert the int back to a string
            complaintNumber = "C" + receiptIDInt;
            return complaintNumber;
        }
    }

    public String addPayment(String role, String userID, String amount, String totalAmountPaid, String totalAmountDue, String receiptID) {
        try {
            //get the current date
            Date date = new Date();
            //format the date in ddmmyyyy
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
            String currentDate = formatter.format(date);
            //get details like resident name, building, unit number from the resident file
            //now put all data inside a hashmap and pass it to the writeData function
            HashMap<String, String> receiptDetails = new HashMap<>();
            receiptDetails.put("DATE", currentDate);
            receiptDetails.put("RECEIPT ID", receiptID);
            receiptDetails.put(role.toUpperCase() + " ID", userID);
            receiptDetails.put("AMOUNT", amount);
            receiptDetails.put("AMOUNT PAID", "MYR " + totalAmountPaid);
            receiptDetails.put("TOTAL AMOUNT DUE", totalAmountDue);
            boolean isDataAdded = createData(role.toLowerCase() + "Payment", receiptDetails, "AccountExecutive");
            if (isDataAdded) {
                //return an array that has true and the new statement ID
                return receiptID;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public String addStatement(String role, String userID, String description, String amount, String totalAmountDue) {
        try {
            //get the current date
            Date date = new Date();
            //format the date in ddmmyyyy
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
            String currentDate = formatter.format(date);
            String newStatementID = getNewStatementID(userID) == null ? "ST1" : getNewStatementID(userID);
            //get details like resident name, building, unit number from the resident file
            Map<String, String> residentDetails = getProfileDetails(userID);
            String userName = residentDetails.get(role.toUpperCase() + " NAME");
            String building = residentDetails.get("BUILDING");
            String unitNumber = residentDetails.get("UNIT NAME");
            //now put all data inside a hashmap and pass it to the writeData function
            HashMap<String, String> statementDetails = new HashMap<>();
            statementDetails.put("DATE", currentDate);
            statementDetails.put(role.toUpperCase() + " NAME", userName);
            statementDetails.put(role.toUpperCase() + " ID", userID);
            statementDetails.put("BUILDING", building);
            statementDetails.put("UNIT NUMBER", unitNumber);
            statementDetails.put("DESCRIPTION", description);
            statementDetails.put("AMOUNT", "MYR " + amount);
            statementDetails.put("TOTAL AMOUNT DUE", totalAmountDue);
            statementDetails.put("STATEMENT ID", newStatementID);
            //rturn something like true, statementID
            boolean isDataAdded = createData(role.toLowerCase() + "Statement", statementDetails, "AccountExecutive");
            if (isDataAdded) {
                //return an array that has true and the new statement ID
                return newStatementID;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public String addInvoice(String role, String userID, String amount) {
        try {
            //get the current date
            Date date = new Date();
            //format the date in ddmmyyyy
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
            String currentDate = formatter.format(date);
            String newInvoiceNum = getNewInvoiceID(userID) == null ? "INV1" : getNewInvoiceID(userID);
            //get details like resident name, building, unit number from the resident file
            Map<String, String> residentDetails = getProfileDetails(userID);
            String userName = residentDetails.get(role.toUpperCase() + " NAME");
            //now put all data inside a hashmap and pass it to the writeData function
            HashMap<String, String> invoiceDetails = new HashMap<>();
            invoiceDetails.put("INVOICE DATE", currentDate);
            invoiceDetails.put(role.toUpperCase() + " NAME", userName);
            invoiceDetails.put(role.toUpperCase() + " ID", userID);
            invoiceDetails.put("AMOUNT", "MYR " + amount);
            invoiceDetails.put("INVOICE NUMBER", newInvoiceNum);
            boolean isDataAdded = createData(role.toLowerCase() + "Invoice", invoiceDetails, "AccountExecutive");
            if (isDataAdded) {
                //return an array that has true and the new statement ID
                return newInvoiceNum;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public String addReceipt(String role, String userID, String invoiceID, String statementID, String amount, String totalAmountPaid) {
        try {
            //get the current date
            Date date = new Date();
            //format the date in ddmmyyyy
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
            String currentDate = formatter.format(date);
            String newReceiptID = getNewReceiptID(userID) == null ? "R1" : getNewReceiptID(userID);
            //now put all data inside a hashmap and pass it to the writeData function
            HashMap<String, String> receiptDetails = new HashMap<>();
            receiptDetails.put("DATE", currentDate);
            receiptDetails.put("RECEIPT ID", newReceiptID);
            receiptDetails.put(role.toUpperCase() + " ID", userID);
            receiptDetails.put("INVOICE ID", invoiceID);
            receiptDetails.put("STATEMENT ID", statementID);
            receiptDetails.put("AMOUNT", amount);
            receiptDetails.put("TOTAL AMOUNT PAID", "MYR " + totalAmountPaid);
            boolean isDataAdded = createData(role.toLowerCase() + "Receipt", receiptDetails, "AccountExecutive");
            if (isDataAdded) {
                //return an array that has true and the new statement ID
                return newReceiptID;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public String addBooking(String residentID, String facilityName, String bookingDate, String startTime, String endTime, String bookingNumber, String status) {
        try {
            String newBookingID = getNewBookingNumber(residentID) == null ? "BK1" : getNewBookingNumber(residentID);
            //now put all data inside a hashmap and pass it to the writeData function
            HashMap<String, String> bookingDetails = new HashMap<>();
            bookingDetails.put("FACILITY NAME", facilityName);
            bookingDetails.put("BOOKING DATE", bookingDate);
            bookingDetails.put("START TIME", startTime);
            bookingDetails.put("RESIDENT ID", residentID);
            bookingDetails.put("END TIME", endTime);
            bookingDetails.put("BOOKING NUMBER", bookingNumber);
            bookingDetails.put("STATUS", status);
            boolean isDataAdded = createData("residentFacilityBooking", bookingDetails, "Resident");
            if (isDataAdded) {
                //return an array that has true and the new statement ID
                return newBookingID;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public String addVisitorPass(String residentID, String visitorName, String vehicleNumber, String purpose, String dateOfVisit, String visitorPassNumber) {
        try {
            //get the current date
            Date date = new Date();
            //format the date in ddmmyyyy
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
            String currentDate = formatter.format(date);
            //now put all data inside a hashmap and pass it to the writeData function
            HashMap<String, String> bookingDetails = new HashMap<>();
            bookingDetails.put("VISITOR NAME", visitorName);
            bookingDetails.put("DATE OF VISIT", dateOfVisit);
            bookingDetails.put("RESIDENT ID", residentID);
            bookingDetails.put("VEHICLE NUMBER", vehicleNumber);
            bookingDetails.put("PURPOSE", purpose);
            bookingDetails.put("VISITOR PASS NUMBER", visitorPassNumber);
            boolean isDataAdded = createData("residentVisitorPass", bookingDetails, "Resident");
            if (isDataAdded) {
                //return an array that has true and the new statement ID
                return visitorPassNumber;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public String addComplaint(String residentID, String complaintDate, String complaintDescription, String complaintStatus, String complaintNumber) {
        try {
            //get the current date
            Date date = new Date();
            //format the date in ddmmyyyy
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
            String currentDate = formatter.format(date);
            //now put all data inside a hashmap and pass it to the writeData function
            HashMap<String, String> complaintDetails = new HashMap<>();
            complaintDetails.put("DATE OF COMPLAINT", complaintDate);
            complaintDetails.put("DESCRIPTION", complaintDescription);
            complaintDetails.put("RESIDENT ID", residentID);
            complaintDetails.put("STATUS", complaintStatus);
            complaintDetails.put("COMPLAINT NUMBER", complaintNumber);
            boolean isDataAdded = createData("residentComplaint", complaintDetails, "Resident");
            if (isDataAdded) {
                //return an array that has true and the new statement ID
                return complaintNumber;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public boolean updateProfile(String userID, HashMap<String, String> profileDetails) {
        {
            try {
                HashMap<Integer, HashMap<String, String>> profileMap = new HashMap<>();

                ArrayList<String> profiles = readData("residentDetail", "Resident");
                ArrayList<String> profilesFileHeader = getFileHeader("residentDetail", "Resident");

                int profileDataCount = 0;
                for (String profile : profiles) {
                    HashMap<String, String> statementDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] statementDetailsArray = profile.split(dataSeparator);
                    String residentIDFromProfile = statementDetailsArray[0];
                    int count = 0;
                    int columnCount = 0;

                    for (int i = 0; i < profile.length(); i++) {
                        if (profile.charAt(i) == dataSeparator.charAt(1)) {
                            //this means that there is data before the data separator
                            //get the data in reverse by iterating through the string backwards, and then join the string back together in the correct order
                            //get the value to start iterating from backwards, which is the index of the data separator - 1
                            int start = i - 2;
                            //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator
                            int end = start - count + 2;

                            //create temp string to store the data
                            StringBuilder temp = new StringBuilder();
                            //iterate through the string backwards
                            for (int j = start; j >= end; j--) {
                                //add the char to the temp string
                                temp.append(profile.charAt(j));
                            }
                            //reverse the string
                            StringBuilder sb = new StringBuilder(temp.toString());
                            sb.reverse();
                            //manually iterate through te sb string, and remove all spaces and super.dataSeparator char at
                            for (int k = 0; k < sb.length(); k++) {
                                if (sb.charAt(k) == dataSeparator.charAt(1)) {
                                    sb.deleteCharAt(k);
                                }
                            }
                            //remove any space from the first index of the string
                            if (sb.charAt(0) == ' ') {
                                sb.deleteCharAt(0);
                            }

                            statementDetails.put(profilesFileHeader.get(columnCount), sb.toString());
                            //reset the count
                            count = 0;
                            columnCount++;

                        }

                        //if we are reaching the last element in the line, then we need to add the last element to the map
                        if (i == profile.length() - 1) {
                            //get the value to start iterating from backwards, which is the index of the data separator - 1
                            int start = i - count + 2;
                            //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                            //create temp string to store the data
                            StringBuilder temp = new StringBuilder();
                            //iterate through the string backwards
                            for (int j = i; j >= start; j--) {
                                //add the char to the temp string
                                temp.append(profile.charAt(j));
                            }
                            //reverse the string
                            StringBuilder sb = new StringBuilder(temp.toString());
                            sb.reverse();
                            columnCount++;
                            statementDetails.put(profilesFileHeader.get(columnCount - 1), sb.toString());
                            columnCount++;
                        }

                        count++;
                    }
                    profileDataCount++;
                    profileMap.put(profileDataCount, statementDetails);
                }
                //now that we have the profile map, we just need to find the profile that matches the residentID, and update the profile
                for (int i = 1; i <= profileMap.size(); i++) {
                    HashMap<String, String> profileDetailsMap = profileMap.get(i);
                    System.out.println(profileDetailsMap);
                    String residentID = profileDetailsMap.get("RESIDENT ID");
                    if (residentID.strip().equals(userID.strip())) {
                        //we would then compare the profileDetailsMap with the profileDetails, and update the profileDetailsMap with the profileDetails
                        //then we would update the profileMap with the profileDetailsMap
                        for (String key : profileDetails.keySet()) {
                            profileDetailsMap.put(key, profileDetails.get(key));
                        }
                        profileMap.put(i, profileDetailsMap);
                    }
                }

                //now that we have the updated profileMap, we need to write the data to the file
                boolean isProfileUpdated = updateData("residentDetail", profileMap, "Resident");
                if (isProfileUpdated) {
                    return true;
                }


            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            return false;
        }
    }

    public boolean updateBooking(String userID, HashMap<String, String> bookingDetails) {
        {
            System.out.println(userID);
            System.out.println(bookingDetails);
            try {
                HashMap<Integer, HashMap<String, String>> profileMap = new HashMap<>();

                ArrayList<String> profiles = readData("residentFacilityBooking", "Resident");
                ArrayList<String> profilesFileHeader = getFileHeader("residentFacilityBooking", "Resident");

                int profileDataCount = 0;
                for (String profile : profiles) {
                    HashMap<String, String> statementDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] statementDetailsArray = profile.split(dataSeparator);
                    String residentIDFromProfile = statementDetailsArray[0];
                    int count = 0;
                    int columnCount = 0;

                    for (int i = 0; i < profile.length(); i++) {
                        if (profile.charAt(i) == dataSeparator.charAt(1)) {
                            //this means that there is data before the data separator
                            //get the data in reverse by iterating through the string backwards, and then join the string back together in the correct order
                            //get the value to start iterating from backwards, which is the index of the data separator - 1
                            int start = i - 2;
                            //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator
                            int end = start - count + 2;

                            //create temp string to store the data
                            StringBuilder temp = new StringBuilder();
                            //iterate through the string backwards
                            for (int j = start; j >= end; j--) {
                                //add the char to the temp string
                                temp.append(profile.charAt(j));
                            }
                            //reverse the string
                            StringBuilder sb = new StringBuilder(temp.toString());
                            sb.reverse();
                            //manually iterate through te sb string, and remove all spaces and super.dataSeparator char at
                            for (int k = 0; k < sb.length(); k++) {
                                if (sb.charAt(k) == dataSeparator.charAt(1)) {
                                    sb.deleteCharAt(k);
                                }
                            }
                            //remove any space from the first index of the string
                            if (sb.charAt(0) == ' ') {
                                sb.deleteCharAt(0);
                            }

                            statementDetails.put(profilesFileHeader.get(columnCount), sb.toString());
                            //reset the count
                            count = 0;
                            columnCount++;

                        }

                        //if we are reaching the last element in the line, then we need to add the last element to the map
                        if (i == profile.length() - 1) {
                            //get the value to start iterating from backwards, which is the index of the data separator - 1
                            int start = i - count + 2;
                            //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                            //create temp string to store the data
                            StringBuilder temp = new StringBuilder();
                            //iterate through the string backwards
                            for (int j = i; j >= start; j--) {
                                //add the char to the temp string
                                temp.append(profile.charAt(j));
                            }
                            //reverse the string
                            StringBuilder sb = new StringBuilder(temp.toString());
                            sb.reverse();
                            columnCount++;
                            statementDetails.put(profilesFileHeader.get(columnCount - 1), sb.toString());
                            columnCount++;
                        }

                        count++;
                    }
                    profileDataCount++;
                    profileMap.put(profileDataCount, statementDetails);
                }
                //now that we have the profile map, we just need to find the profile that matches the residentID, and update the profile
                for (int i = 1; i <= profileMap.size(); i++) {
                    HashMap<String, String> profileDetailsMap = profileMap.get(i);
                    String residentID = profileDetailsMap.get("RESIDENT ID");
                    if (residentID.strip().equals(userID.strip()) && profileDetailsMap.get("BOOKING NUMBER").equals(bookingDetails.get("BOOKING NUMBER"))) {
                        //we would then compare the profileDetailsMap with the profileDetails, and update the profileDetailsMap with the profileDetails
                        //then we would update the profileMap with the profileDetailsMap
                        for (String key : bookingDetails.keySet()) {
                            profileDetailsMap.put(key, bookingDetails.get(key));
                        }
                        profileMap.put(i, profileDetailsMap);
                    }
                }

                System.out.println(profileMap);

                //now that we have the updated profileMap, we need to write the data to the file
                boolean isBookingUpdated = updateData("residentFacilityBooking", profileMap, "Resident");
                if (isBookingUpdated) {
                    return true;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            return false;
        }
    }

    public boolean deleteVisitorPass(String userID, String visitorPassDetails) {
        try {
            HashMap<Integer, HashMap<String, String>> profileMap = new HashMap<>();

            ArrayList<String> profiles = readData("residentVisitorPass", "Resident");
            ArrayList<String> profilesFileHeader = getFileHeader("residentVisitorPass", "Resident");

            int profileDataCount = 0;
            for (String profile : profiles) {
                HashMap<String, String> statementDetails = new HashMap<>();
                //get the last index of the complaint, which is the status of the complaint
                String[] statementDetailsArray = profile.split(dataSeparator);
                String residentIDFromProfile = statementDetailsArray[0];
                if (residentIDFromProfile.strip().equals(userID.strip())) {
                    int count = 0;
                    int columnCount = 0;

                    for (int i = 0; i < profile.length(); i++) {
                        if (profile.charAt(i) == dataSeparator.charAt(1)) {
                            //this means that there is data before the data separator
                            //get the data in reverse by iterating through the string backwards, and then join the string back together in the correct order
                            //get the value to start iterating from backwards, which is the index of the data separator - 1
                            int start = i - 2;
                            //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator
                            int end = start - count + 2;

                            //create temp string to store the data
                            StringBuilder temp = new StringBuilder();
                            //iterate through the string backwards
                            for (int j = start; j >= end; j--) {
                                //add the char to the temp string
                                temp.append(profile.charAt(j));
                            }
                            //reverse the string
                            StringBuilder sb = new StringBuilder(temp.toString());
                            sb.reverse();
                            //manually iterate through te sb string, and remove all spaces and super.dataSeparator char at
                            for (int k = 0; k < sb.length(); k++) {
                                if (sb.charAt(k) == dataSeparator.charAt(1)) {
                                    sb.deleteCharAt(k);
                                }
                            }
                            //remove any space from the first index of the string
                            if (sb.charAt(0) == ' ') {
                                sb.deleteCharAt(0);
                            }

                            statementDetails.put(profilesFileHeader.get(columnCount), sb.toString());
                            //reset the count
                            count = 0;
                            columnCount++;

                        }

                        //if we are reaching the last element in the line, then we need to add the last element to the map
                        if (i == profile.length() - 1) {
                            //get the value to start iterating from backwards, which is the index of the data separator - 1
                            int start = i - count + 2;
                            //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                            //create temp string to store the data
                            StringBuilder temp = new StringBuilder();
                            //iterate through the string backwards
                            for (int j = i; j >= start; j--) {
                                //add the char to the temp string
                                temp.append(profile.charAt(j));
                            }
                            //reverse the string
                            StringBuilder sb = new StringBuilder(temp.toString());
                            sb.reverse();
                            columnCount++;
                            statementDetails.put(profilesFileHeader.get(columnCount - 1), sb.toString());
                            columnCount++;
                        }

                        count++;
                    }
                    profileDataCount++;
                    profileMap.put(profileDataCount, statementDetails);
                }

                //now that we have the profile map, find a row matching the residentid and visitorpassid, and delete the row
                for (int i = 1; i <= profileMap.size(); i++) {
                    HashMap<String, String> profileDetailsMap = profileMap.get(i);
                    String residentID = profileDetailsMap.get("RESIDENT ID");
                    String visitorPassID = profileDetailsMap.get("VISITOR PASS NUMBER");
                    if (residentID.equals(userID) && visitorPassID.equals(visitorPassDetails)) {
                        //we would then compare the profileDetailsMap with the profileDetails, and update the profileDetailsMap with the profileDetails
                        //then we would update the profileMap with the profileDetailsMap
                        profileMap.remove(i);
                    }
                }

                //rearrange the profileMap paritcularly the keys, for example, after removing 1, there's 2 and 3 inside, but it should ebe reerranged to 1 and 2
                HashMap<Integer, HashMap<String, String>> rearrangedProfileMap = new HashMap<>();
                int count = 1;
                for (int i = 1; i <= profileMap.size(); i++) {
                    HashMap<String, String> profileDetailsMap = profileMap.get(i);
                    if (profileDetailsMap != null) {
                        rearrangedProfileMap.put(count, profileDetailsMap);
                        count++;
                    }
                }

                //now that we have the updated profileMap, we need to write the data to the file
                boolean isBookingUpdated = updateData("residentVisitorPass", rearrangedProfileMap, "Resident");
                if (isBookingUpdated) {
                    return true;
                }

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

        public boolean updateVisitorPass (String userID, HashMap < String, String > visitorPassDetails){
            {

                try {
                    HashMap<Integer, HashMap<String, String>> profileMap = new HashMap<>();

                    ArrayList<String> passes = readData("residentVisitorPass", "Resident");
                    ArrayList<String> passesFileHeader = getFileHeader("residentVisitorPass", "Resident");

                    int profileDataCount = 0;
                    for (String pass : passes) {
                        HashMap<String, String> statementDetails = new HashMap<>();
                        //get the last index of the complaint, which is the status of the complaint
                        String[] statementDetailsArray = pass.split(dataSeparator);
                        String residentIDFromProfile = statementDetailsArray[0];
                        int count = 0;
                        int columnCount = 0;

                        for (int i = 0; i < pass.length(); i++) {
                            if (pass.charAt(i) == dataSeparator.charAt(1)) {
                                //this means that there is data before the data separator
                                //get the data in reverse by iterating through the string backwards, and then join the string back together in the correct order
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator
                                int end = start - count + 2;

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = start; j >= end; j--) {
                                    //add the char to the temp string
                                    temp.append(pass.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                //manually iterate through te sb string, and remove all spaces and super.dataSeparator char at
                                for (int k = 0; k < sb.length(); k++) {
                                    if (sb.charAt(k) == dataSeparator.charAt(1)) {
                                        sb.deleteCharAt(k);
                                    }
                                }
                                //remove any space from the first index of the string
                                if (sb.charAt(0) == ' ') {
                                    sb.deleteCharAt(0);
                                }

                                statementDetails.put(passesFileHeader.get(columnCount), sb.toString());
                                //reset the count
                                count = 0;
                                columnCount++;

                            }

                            //if we are reaching the last element in the line, then we need to add the last element to the map
                            if (i == pass.length() - 1) {
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - count + 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = i; j >= start; j--) {
                                    //add the char to the temp string
                                    temp.append(pass.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                columnCount++;
                                statementDetails.put(passesFileHeader.get(columnCount - 1), sb.toString());
                                columnCount++;
                            }

                            count++;
                        }
                        profileDataCount++;
                        profileMap.put(profileDataCount, statementDetails);
                    }
                    //now that we have the profile map, we just need to find the profile that matches the residentID, and update the profile
                    for (int i = 1; i <= profileMap.size(); i++) {
                        HashMap<String, String> profileDetailsMap = profileMap.get(i);
                        String residentID = profileDetailsMap.get("RESIDENT ID");
                        if (residentID.strip().equals(userID.strip()) && profileDetailsMap.get("VISITOR PASS NUMBER").equals(visitorPassDetails.get("VISITOR PASS NUMBER"))) {
                            //we would then compare the profileDetailsMap with the profileDetails, and update the profileDetailsMap with the profileDetails
                            //then we would update the profileMap with the profileDetailsMap
                            for (String key : visitorPassDetails.keySet()) {
                                profileDetailsMap.put(key, visitorPassDetails.get(key));
                            }
                            profileMap.put(i, profileDetailsMap);
                        }
                    }

                    System.out.println(profileMap);

                    //now that we have the updated profileMap, we need to write the data to the file
                    boolean isPassUpdated = updateData("residentVisitorPass", profileMap, "Resident");
                    if (isPassUpdated) {
                        return true;
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

                return false;
            }
        }
        public boolean deleteComplaint (String userID, String complaintNumber){
            try {
                HashMap<Integer, HashMap<String, String>> profileMap = new HashMap<>();

                ArrayList<String> complaints = readData("residentComplaint", "Resident");
                ArrayList<String> complaintsFileHeader = getFileHeader("residentComplaint", "Resident");

                int profileDataCount = 0;
                for (String complaint : complaints) {
                    HashMap<String, String> statementDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] statementDetailsArray = complaint.split(dataSeparator);
                    String residentIDFromProfile = statementDetailsArray[0];
                    int count = 0;
                    int columnCount = 0;

                    for (int i = 0; i < complaint.length(); i++) {
                        if (complaint.charAt(i) == dataSeparator.charAt(1)) {
                            //this means that there is data before the data separator
                            //get the data in reverse by iterating through the string backwards, and then join the string back together in the correct order
                            //get the value to start iterating from backwards, which is the index of the data separator - 1
                            int start = i - 2;
                            //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator
                            int end = start - count + 2;

                            //create temp string to store the data
                            StringBuilder temp = new StringBuilder();
                            //iterate through the string backwards
                            for (int j = start; j >= end; j--) {
                                //add the char to the temp string
                                temp.append(complaint.charAt(j));
                            }
                            //reverse the string
                            StringBuilder sb = new StringBuilder(temp.toString());
                            sb.reverse();
                            //manually iterate through te sb string, and remove all spaces and super.dataSeparator char at
                            for (int k = 0; k < sb.length(); k++) {
                                if (sb.charAt(k) == dataSeparator.charAt(1)) {
                                    sb.deleteCharAt(k);
                                }
                            }
                            //remove any space from the first index of the string
                            if (sb.charAt(0) == ' ') {
                                sb.deleteCharAt(0);
                            }

                            statementDetails.put(complaintsFileHeader.get(columnCount), sb.toString());
                            //reset the count
                            count = 0;
                            columnCount++;

                        }

                        //if we are reaching the last element in the line, then we need to add the last element to the map
                        if (i == complaint.length() - 1) {
                            //get the value to start iterating from backwards, which is the index of the data separator - 1
                            int start = i - count + 2;
                            //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                            //create temp string to store the data
                            StringBuilder temp = new StringBuilder();
                            //iterate through the string backwards
                            for (int j = i; j >= start; j--) {
                                //add the char to the temp string
                                temp.append(complaint.charAt(j));
                            }
                            //reverse the string
                            StringBuilder sb = new StringBuilder(temp.toString());
                            sb.reverse();
                            columnCount++;
                            statementDetails.put(complaintsFileHeader.get(columnCount - 1), sb.toString());
                            columnCount++;
                        }

                        count++;
                    }
                    profileDataCount++;
                    profileMap.put(profileDataCount, statementDetails);
                }

                //now that we have the profile map, find a row matching the residentid and visitorpassid, and delete the row
                for (int i = 1; i <= profileMap.size(); i++) {
                    HashMap<String, String> profileDetailsMap = profileMap.get(i);
                    System.out.println(profileDetailsMap);
                    String residentID = profileDetailsMap.get("RESIDENT ID");
                    String complaintID = profileDetailsMap.get("COMPLAINT NUMBER");
                    if (residentID.equals(userID) && complaintID.equals(complaintNumber)) {
                        //we would then compare the profileDetailsMap with the profileDetails, and update the profileDetailsMap with the profileDetails
                        //then we would update the profileMap with the profileDetailsMap
                        profileMap.remove(i);
                    }
                }

                //rearrange the profileMap paritcularly the keys, for example, after removing 1, there's 2 and 3 inside, but it should ebe reerranged to 1 and 2
                HashMap<Integer, HashMap<String, String>> rearrangedProfileMap = new HashMap<>();
                int count = 1;
                for (int i = 1; i <= profileMap.size(); i++) {
                    HashMap<String, String> profileDetailsMap = profileMap.get(i);
                    if (profileDetailsMap != null) {
                        rearrangedProfileMap.put(count, profileDetailsMap);
                        count++;
                    }
                }

                //now that we have the updated profileMap, we need to write the data to the file
                boolean isBookingUpdated = updateData("residentComplaint", rearrangedProfileMap, "Resident");
                if (isBookingUpdated) {
                    return true;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            return false;
        }

        public boolean updateComplaint (String userID, HashMap < String, String > complaintDetails){
            {
                try {
                    HashMap<Integer, HashMap<String, String>> complaintMap = new HashMap<>();

                    ArrayList<String> complaints = readData("residentComplaint", "Resident");
                    ArrayList<String> complaintsFileHeader = getFileHeader("residentComplaint", "Resident");

                    int profileDataCount = 0;
                    for (String complaint : complaints) {
                        HashMap<String, String> statementDetails = new HashMap<>();
                        //get the last index of the complaint, which is the status of the complaint
                        String[] statementDetailsArray = complaint.split(dataSeparator);
                        String residentIDFromProfile = statementDetailsArray[0];
                        int count = 0;
                        int columnCount = 0;

                        for (int i = 0; i < complaint.length(); i++) {
                            if (complaint.charAt(i) == dataSeparator.charAt(1)) {
                                //this means that there is data before the data separator
                                //get the data in reverse by iterating through the string backwards, and then join the string back together in the correct order
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator
                                int end = start - count + 2;

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = start; j >= end; j--) {
                                    //add the char to the temp string
                                    temp.append(complaint.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                //manually iterate through te sb string, and remove all spaces and super.dataSeparator char at
                                for (int k = 0; k < sb.length(); k++) {
                                    if (sb.charAt(k) == dataSeparator.charAt(1)) {
                                        sb.deleteCharAt(k);
                                    }
                                }
                                //remove any space from the first index of the string
                                if (sb.charAt(0) == ' ') {
                                    sb.deleteCharAt(0);
                                }

                                statementDetails.put(complaintsFileHeader.get(columnCount), sb.toString());
                                //reset the count
                                count = 0;
                                columnCount++;

                            }

                            //if we are reaching the last element in the line, then we need to add the last element to the map
                            if (i == complaint.length() - 1) {
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - count + 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = i; j >= start; j--) {
                                    //add the char to the temp string
                                    temp.append(complaint.charAt(j));
                                }
                                //reverse the string
                                StringBuilder sb = new StringBuilder(temp.toString());
                                sb.reverse();
                                columnCount++;
                                statementDetails.put(complaintsFileHeader.get(columnCount - 1), sb.toString());
                                columnCount++;
                            }

                            count++;
                        }
                        profileDataCount++;
                        complaintMap.put(profileDataCount, statementDetails);
                    }
                    //now that we have the profile map, we just need to find the profile that matches the residentID, and update the profile
                    for (int i = 1; i <= complaintMap.size(); i++) {
                        HashMap<String, String> profileDetailsMap = complaintMap.get(i);
                        String residentID = profileDetailsMap.get("RESIDENT ID");
                        if (residentID.equals(userID)) {
                            //we would then compare the profileDetailsMap with the profileDetails, and update the profileDetailsMap with the profileDetails
                            //then we would update the profileMap with the profileDetailsMap
                            for (String key : complaintDetails.keySet()) {
                                profileDetailsMap.put(key, complaintDetails.get(key));
                            }
                            complaintMap.put(i, profileDetailsMap);
                        }
                    }

                    System.out.println(complaintMap);

                    //now that we have the updated profileMap, we need to write the data to the file
                    boolean isPassUpdated = updateData("residentComplaint", complaintMap, "Resident");
                    if (isPassUpdated) {
                        return true;
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

                return false;
            }
        }

    }

