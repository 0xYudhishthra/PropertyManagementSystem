package Resident;

import Helpers.BookingStatus;
import Helpers.ComplaintStatus;
import Helpers.FileHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
                    boolean isResidentID = true;
                    for (int i = 0; i < residentID.length(); i++) {
                        if (residentID.charAt(i) != residentIDFromComplaint.charAt(i)) {
                            isResidentID = false;
                            break;
                        }
                    }
                    if (isResidentID && (complaintStatus.toUpperCase().equals(pendingStatus.toString()) || complaintStatus.toUpperCase().equals(inProgressStatus.toString()))) {
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
                boolean isResidentID = true;
                for (int i = 0; i < residentID.length(); i++) {
                    if (residentID.charAt(i) != residentIDFromComplaint.charAt(i)) {
                        isResidentID = false;
                        break;
                    }
                }
                if (isResidentID && (complaintStatus.toUpperCase().equals(resolvedStatus.toString()) || complaintStatus.toUpperCase().equals(closedStatus.toString()))) {
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
                    boolean isResidentID = true;
                    for (int i = 0; i < residentID.length(); i++) {
                        if (residentID.charAt(i) != residentIDFromComplaint.charAt(i)) {
                            isResidentID = false;
                            break;
                        }
                    }
                    if (isResidentID && (complaintStatus.toUpperCase().equals(pendingStatus.toString()) || complaintStatus.toUpperCase().equals(confirmedStatus.toString()))) {
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
                    boolean isResidentID = true;
                    for (int i = 0; i < residentID.length(); i++) {
                        if (residentID.charAt(i) != residentIDFromComplaint.charAt(i)) {
                            isResidentID = false;
                            break;
                        }
                    }
                    if (isResidentID && (complaintStatus.toUpperCase().equals(pendingStatus.toString()) || complaintStatus.toUpperCase().equals(confirmedStatus.toString()))) {
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
                    boolean isResidentID = true;
                    for (int i = 0; i < residentID.length(); i++) {
                        if (residentID.charAt(i) != residentIDFromPayment.charAt(i)) {
                            isResidentID = false;
                            break;
                        }
                    }
                    if (isResidentID) {
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
                    boolean isResidentID = true;
                    for (int i = 0; i < residentID.length(); i++) {
                        if (residentID.charAt(i) != residentIDFromInvoice.charAt(i)) {
                            isResidentID = false;
                            break;
                        }
                    }
                    if (isResidentID) {
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
                    boolean isResidentID = true;
                    for (int i = 0; i < residentID.length(); i++) {
                        if (residentID.charAt(i) != residentIDFromReceipt.charAt(i)) {
                            isResidentID = false;
                            break;
                        }
                    }
                    if (isResidentID) {
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
                    boolean isResidentID = true;
                    for (int i = 0; i < residentID.length(); i++) {
                        if (residentID.charAt(i) != residentIDFromStatement.charAt(i)) {
                            isResidentID = false;
                            break;
                        }
                    }
                    if (isResidentID) {
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
                boolean isResidentID = true;
                for (int i = 0; i < residentID.length(); i++) {
                    if (residentID.charAt(i) != residentIDFromProfile.charAt(i)) {
                        isResidentID = false;
                        break;
                    }
                }
                if (isResidentID) {
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
                    boolean isResidentID = true;
                    for (int i = 0; i < residentID.length(); i++) {
                        if (residentID.charAt(i) != residentIDFromPass.charAt(i)) {
                            isResidentID = false;
                            break;
                        }
                    }
                    if (isResidentID) {
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


}
