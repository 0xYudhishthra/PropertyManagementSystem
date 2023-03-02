package Vendor;

import Helpers.ComplaintStatus;
import Helpers.FileHandler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class vendorFileHandler extends FileHandler {
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

    public Map<Integer, Map<String, String>> getPendingComplaints(String vendorID) {
        {
            try {
                ComplaintStatus pendingStatus = ComplaintStatus.PENDING;
                ComplaintStatus inProgressStatus = ComplaintStatus.IN_PROGRESS;
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> complaintMap = new HashMap<>();

                ArrayList<String> complaints = readData("vendorComplaint", "vendor");
                //also get file header
                ArrayList<String> fileHeader = getFileHeader("vendorComplaint", "vendor");
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
                    for (int i = 0; i < vendorID.length(); i++) {
                        if (vendorID.charAt(i) != residentIDFromComplaint.charAt(i)) {
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

    public Map<Integer, Map<String, String>> getPastComplaints(String vendorID) {
        try {
            ComplaintStatus resolvedStatus = ComplaintStatus.RESOLVED;
            ComplaintStatus closedStatus = ComplaintStatus.CLOSED;
            //create a list of complaints
            //from the call of the second readData function above, get the list of complaints
            Map<Integer, Map<String, String>> complaintMap = new HashMap<>();

            ArrayList<String> complaints = readData("vendorComplaint", "vendor");
            //also get file header
            ArrayList<String> fileHeader = getFileHeader("vendorComplaint", "vendor");

            int dataCount = 0;
            for (String complaint : complaints) {
                Map<String, String> complaintDetails = new HashMap<>();
                //get the last index of the complaint, which is the status of the complaint
                String[] complaintDetailsArray = complaint.split(dataSeparator);
                String residentIDFromComplaint = complaintDetailsArray[0];
                String complaintStatus = complaintDetailsArray[complaintDetailsArray.length - 1];
                boolean isResidentID = true;
                for (int i = 0; i < vendorID.length(); i++) {
                    if (vendorID.charAt(i) != residentIDFromComplaint.charAt(i)) {
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

    public Map<Integer, Map<String, String>> getPaymentHistory(String vendorID) {
        {
            try {
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> paymentMap = new HashMap<>();

                ArrayList<String> payments = readData("vendorPayment", "AccountExecutive");
                //also get file header
                ArrayList<String> fileHeader = getFileHeader("vendorPayment", "AccountExecutive");
                int dataCount = 0;
                for (String payment : payments) {
                    Map<String, String> bookingDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] paymentDetailsArray = payment.split(dataSeparator);
                    String residentIDFromPayment = paymentDetailsArray[2];
                    boolean isResidentID = true;
                    for (int i = 0; i < vendorID.length(); i++) {
                        if (vendorID.charAt(i) != residentIDFromPayment.charAt(i)) {
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

    public Map<Integer, Map<String, String>> getInvoice(String vendorID) {
        {
            try {
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> invoiceMap = new HashMap<>();

                ArrayList<String> invoices = readData("vendorInvoice", "AccountExecutive");
                //also get file header
                ArrayList<String> fileHeader = getFileHeader("vendorInvoice", "AccountExecutive");
                int dataCount = 0;
                for (String invoice : invoices) {
                    Map<String, String> invoiceDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] invoiceDetailsArray = invoice.split(dataSeparator);
                    String residentIDFromInvoice = invoiceDetailsArray[3];
                    boolean isResidentID = true;
                    for (int i = 0; i < vendorID.length(); i++) {
                        if (vendorID.charAt(i) != residentIDFromInvoice.charAt(i)) {
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

    public Map<Integer, Map<String, String>> getReceipt(String vendorID) {
        {
            try {
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> receiptMap = new HashMap<>();

                ArrayList<String> receipts = readData("vendorReceipt", "AccountExecutive");
                //also get file header
                ArrayList<String> fileHeader = getFileHeader("vendorReceipt", "AccountExecutive");
                int dataCount = 0;
                for (String receipt : receipts) {
                    Map<String, String> invoiceDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] receiptDetailsArray = receipt.split(dataSeparator);
                    String residentIDFromReceipt = receiptDetailsArray[4];
                    boolean isResidentID = true;
                    for (int i = 0; i < vendorID.length(); i++) {
                        if (vendorID.charAt(i) != residentIDFromReceipt.charAt(i)) {
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

    public Map<Integer, Map<String, String>> getStatement(String vendorID) {
        {
            try {
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> statementMap = new HashMap<>();

                ArrayList<String> statements = readData("vendorStatement", "AccountExecutive");
                //also get file header
                ArrayList<String> fileHeader = getFileHeader("vendorStatement", "AccountExecutive");
                int dataCount = 0;
                for (String statement : statements) {
                    Map<String, String> invoiceDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] statementDetailsArray = statement.split(dataSeparator);
                    String residentIDFromStatement = statementDetailsArray[5];
                    boolean isResidentID = true;
                    for (int i = 0; i < vendorID.length(); i++) {
                        if (vendorID.charAt(i) != residentIDFromStatement.charAt(i)) {
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

    public Map<String, String> getProfileDetails(String vendorID) {
        try {
            //create a list of complaints
            //from the call of the second readData function above, get the list of complaints
            Map<String, String> profileDetails = new HashMap<>();

            ArrayList<String> profiles = readData("vendorDetail", "vendor");
            //also get file header
            ArrayList<String> fileHeader = getFileHeader("vendorDetail", "vendor");
            for (String profile : profiles) {
                //get the last index of the complaint, which is the status of the complaint
                String[] profileDetailsArray = profile.split(dataSeparator);
                String vendorIDFromProfile = profileDetailsArray[0];
                boolean isVendorID = true;
                for (int i = 0; i < vendorID.length(); i++) {
                    if (vendorID.charAt(i) != vendorIDFromProfile.charAt(i)) {
                        isVendorID = false;
                        break;
                    }
                }
                if (isVendorID) {
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

    public boolean updateProfile(String userID, HashMap<String, String> profileDetails) {
        {
            try {
                HashMap<Integer, HashMap<String, String>> profileMap = new HashMap<>();

                ArrayList<String> profiles = readData("vendorDetail", "Vendor");
                ArrayList<String> profilesFileHeader = getFileHeader("vendorDetail", "Vendor");

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
                    String vendorID = profileDetailsMap.get("VENDOR ID");
                    if (vendorID.equals(userID)) {
                        //we would then compare the profileDetailsMap with the profileDetails, and update the profileDetailsMap with the profileDetails
                        //then we would update the profileMap with the profileDetailsMap
                        for (String key : profileDetails.keySet()) {
                            profileDetailsMap.put(key, profileDetails.get(key));
                        }
                        profileMap.put(i, profileDetailsMap);
                    }
                }

                System.out.println(profileMap);

                //now that we have the updated profileMap, we need to write the data to the file
                boolean isProfileUpdated = updateData("vendorDetail", profileMap, "Vendor");
                if (isProfileUpdated) {
                    return true;
                }


            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            return false;
        }
    }

    public String addPayment(String userID, String amount, String totalAmountPaid, String totalAmountDue, String receiptID) {
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
            receiptDetails.put("VENDOR ID", userID);
            receiptDetails.put("AMOUNT", amount);
            receiptDetails.put("AMOUNT PAID", "MYR " + totalAmountPaid);
            receiptDetails.put("TOTAL AMOUNT DUE", totalAmountDue);
            boolean isDataAdded = createData("vendorPayment", receiptDetails, "AccountExecutive");
            if (isDataAdded) {
                //return an array that has true and the new statement ID
                return receiptID;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
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


    public String addStatement(String userID, String description, String amount, String totalAmountDue) {
        try {
            //get the current date
            Date date = new Date();
            //format the date in ddmmyyyy
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
            String currentDate = formatter.format(date);
            String newStatementID = getNewStatementID(userID);
            //get details like resident name, building, unit number from the resident file
            Map<String, String> residentDetails = getProfileDetails(userID);
            String userName = residentDetails.get("VENDOR NAME");
            String building = residentDetails.get("BUILDING");
            String unitNumber = residentDetails.get("UNIT NAME");
            //now put all data inside a hashmap and pass it to the writeData function
            HashMap<String, String> statementDetails = new HashMap<>();
            statementDetails.put("DATE", currentDate);
            statementDetails.put("VENDOR NAME", userName);
            statementDetails.put("VENDOR ID", userID);
            statementDetails.put("BUILDING", building);
            statementDetails.put("UNIT NUMBER", unitNumber);
            statementDetails.put("DESCRIPTION", description);
            statementDetails.put("AMOUNT", "MYR " + amount);
            statementDetails.put("TOTAL AMOUNT DUE", totalAmountDue);
            statementDetails.put("STATEMENT ID", newStatementID);
            //rturn something like true, statementID
            boolean isDataAdded = createData("vendorStatement", statementDetails, "AccountExecutive");
            if (isDataAdded) {
                //return an array that has true and the new statement ID
                return newStatementID;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

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
            String statementID = invoiceMap.get(lastKey).get("INVOICE NUMBER");
            System.out.println("swatementid" + statementID);
            int statementIDInt = Integer.parseInt(statementID.substring(3));
            statementIDInt++;
            //convert the int back to a string
            statementID = "INV" + statementIDInt;
            return statementID;
        }
    }

    public Map<Integer, Map<String, String>> getComplaints(String vendorID) {
        {
            try {
                System.out.println("vendorID" + vendorID);
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> passMap = new HashMap<>();

                ArrayList<String> complaints = readData("vendorComplaint", "vendor");

                //also get file header
                ArrayList<String> fileHeader = getFileHeader("vendorComplaint", "vendor");
                int dataCount = 0;
                for (String complaint : complaints) {
                    Map<String, String> passDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] passDetailsArray = complaint.split(dataSeparator);
                    String residentIDFromPass = passDetailsArray[0];
                    boolean isResidentID = true;
                    for (int i = 0; i < vendorID.length(); i++) {
                        if (vendorID.charAt(i) != residentIDFromPass.charAt(i)) {
                            isResidentID = false;
                            break;
                        }
                    }
                    if (isResidentID) {
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
                System.out.println("passMap: " + passMap);
                return passMap;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return null;
    }


    public String getNewComplaintNumber(String userID) {
        //use the get statement method to get the latest statement ID
        Map<Integer, Map<String, String>> complaintMap = getComplaints(userID);
        System.out.println("complaintmap" + complaintMap);
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

    public String addComplaint(String vendorID, String complaintDate, String complaintDescription, String complaintStatus, String complaintNumber) {
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
            complaintDetails.put("VENDOR ID", vendorID);
            complaintDetails.put("STATUS", complaintStatus);
            complaintDetails.put("COMPLAINT NUMBER", complaintNumber);
            boolean isDataAdded = createData("vendorComplaint", complaintDetails, "Vendor");
            if (isDataAdded) {
                //return an array that has true and the new statement ID
                return complaintNumber;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }



    public String addInvoice(String userID, String amount) {
        try {
            //get the current date
            Date date = new Date();
            //format the date in ddmmyyyy
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
            String currentDate = formatter.format(date);
            String newInvoiceNum = getNewInvoiceID(userID);
            //get details like resident name, building, unit number from the resident file
            Map<String, String> residentDetails = getProfileDetails(userID);
            String userName = residentDetails.get("VENDOR NAME");
            //now put all data inside a hashmap and pass it to the writeData function
            HashMap<String, String> invoiceDetails = new HashMap<>();
            invoiceDetails.put("INVOICE DATE", currentDate);
            invoiceDetails.put("VENDOR NAME", userName);
            invoiceDetails.put("VENDOR ID", userID);
            invoiceDetails.put("AMOUNT", "MYR " + amount);
            invoiceDetails.put("INVOICE NUMBER", newInvoiceNum);
            System.out.println(invoiceDetails);
            boolean isDataAdded = createData("vendorInvoice", invoiceDetails, "AccountExecutive");
            if (isDataAdded) {
                //return an array that has true and the new statement ID
                return newInvoiceNum;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
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

    public String addReceipt(String userID, String invoiceID, String statementID, String amount, String totalAmountPaid) {
        try {
            System.out.println("invoiceid: " + invoiceID);
            //get the current date
            Date date = new Date();
            //format the date in ddmmyyyy
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
            String currentDate = formatter.format(date);
            String newReceiptID = getNewReceiptID(userID);
            //now put all data inside a hashmap and pass it to the writeData function
            HashMap<String, String> receiptDetails = new HashMap<>();
            receiptDetails.put("DATE", currentDate);
            receiptDetails.put("RECEIPT ID", newReceiptID);
            receiptDetails.put("VENDOR ID", userID);
            receiptDetails.put("INVOICE ID", invoiceID);
            receiptDetails.put("STATEMENT ID", statementID);
            receiptDetails.put("AMOUNT", amount);
            receiptDetails.put("TOTAL AMOUNT PAID", "MYR " + totalAmountPaid);
            System.out.println(receiptDetails);
            boolean isDataAdded = createData("vendorReceipt", receiptDetails, "AccountExecutive");
            if (isDataAdded) {
                //return an array that has true and the new statement ID
                return newReceiptID;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public boolean deleteComplaint(String userID, String complaintNumber) {
        try {
            HashMap<Integer, HashMap<String, String>> profileMap = new HashMap<>();

            ArrayList<String> complaints = readData("vendorComplaint", "Vendor");
            ArrayList<String> complaintsFileHeader = getFileHeader("vendorComplaint", "Vendor");

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
                String residentID = profileDetailsMap.get("VENDOR ID");
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
            boolean isBookingUpdated = updateData("vendorComplaint", rearrangedProfileMap, "Vendor");
            if (isBookingUpdated) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }

    public boolean updateComplaint(String userID, HashMap<String, String> complaintDetails){
        {
            try {
                HashMap<Integer, HashMap<String, String>> complaintMap = new HashMap<>();

                ArrayList<String> complaints = readData("vendorComplaint", "Vendor");
                ArrayList<String> complaintsFileHeader = getFileHeader("vendorComplaint", "Vendor");

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
                    String residentID = profileDetailsMap.get("VENDOR ID");
                    if (residentID.equals(userID)) {
                        //we would then compare the profileDetailsMap with the profileDetails, and update the profileDetailsMap with the profileDetails
                        //then we would update the profileMap with the profileDetailsMap
                        for (String key : complaintDetails.keySet()) {
                            profileDetailsMap.put(key, complaintDetails.get(key));
                        }
                        complaintMap.put(i, profileDetailsMap);
                    }
                }

                //now that we have the updated profileMap, we need to write the data to the file
                boolean isPassUpdated = updateData("vendorComplaint", complaintMap, "Vendor");
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
