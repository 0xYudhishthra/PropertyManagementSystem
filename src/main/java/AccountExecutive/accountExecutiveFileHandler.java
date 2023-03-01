package AccountExecutive;

import Helpers.BookingStatus;
import Helpers.ComplaintStatus;
import Helpers.FileHandler;

import java.text.SimpleDateFormat;
import java.util.*;

public class accountExecutiveFileHandler extends FileHandler {
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

    @Override
    public boolean createData(String filename, HashMap<String, String> data, String userRole) throws Exception {
        return super.createData(filename, data, userRole);
    }

    public Map<Integer, Map<String, String>> getPaymentHistory(String role, String userID) {
        {
            try {
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> paymentMap = new HashMap<>();
                ArrayList<String> payments = null;
                ArrayList<String> fileHeader = null;

                if (role.equals("Resident")) {
                    payments = readData("residentPayment", "AccountExecutive");
                    //also get file header
                    fileHeader = getFileHeader("residentPayment", "AccountExecutive");
                }

                if (role.equals("Vendor")) {
                    payments = readData("vendorPayment", "AccountExecutive");
                    //also get file header
                    fileHeader = getFileHeader("vendorPayment", "AccountExecutive");
                }
                int dataCount = 0;
                for (String payment : payments) {
                    Map<String, String> bookingDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] paymentDetailsArray = payment.split(dataSeparator);
                    String residentIDFromPayment = paymentDetailsArray[2];
                    if (userID.equals(residentIDFromPayment)) {
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

    public Map<Integer, Map<String, String>> getInvoice(String role, String userID) {
        {
            try {
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> invoiceMap = new HashMap<>();
                ArrayList<String> invoices = null;
                ArrayList<String> fileHeader = null;

                if (role.equals("Resident")) {
                    invoices = readData("residentInvoice", "AccountExecutive");
                    //also get file header
                    fileHeader = getFileHeader("residentInvoice", "AccountExecutive");
                }

                if (role.equals("Vendor")) {
                    invoices = readData("vendorInvoice", "AccountExecutive");
                    //also get file header
                    fileHeader = getFileHeader("vendorInvoice", "AccountExecutive");
                }

                int dataCount = 0;
                for (String invoice : invoices) {
                    Map<String, String> invoiceDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] invoiceDetailsArray = invoice.split(dataSeparator);
                    String residentIDFromInvoice = invoiceDetailsArray[3];

                    if (userID.equals(residentIDFromInvoice)) {
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

    public Map<Integer, Map<String, String>> getReceipt(String role, String userID) {
        {
            try {
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> receiptMap = new HashMap<>();
                ArrayList<String> receipts = null;
                ArrayList<String> fileHeader = null;

                if (role.equals("Resident")) {
                    receipts = readData("residentReceipt", "AccountExecutive");
                    //also get file header
                    fileHeader = getFileHeader("residentReceipt", "AccountExecutive");
                }

                if (role.equals("Vendor")) {
                    receipts = readData("vendorReceipt", "AccountExecutive");
                    //also get file header
                    fileHeader = getFileHeader("vendorReceipt", "AccountExecutive");
                }
                int dataCount = 0;
                for (String receipt : receipts) {
                    Map<String, String> invoiceDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] receiptDetailsArray = receipt.split(dataSeparator);
                    String residentIDFromReceipt = receiptDetailsArray[4];
                    if (userID.equals(residentIDFromReceipt)) {
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

    public Map<Integer, Map<String, String>> getStatement(String role, String userID) {
        {
            try {
                //create a list of complaints
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> statementMap = new HashMap<>();
                ArrayList<String> statements = null;
                ArrayList<String> fileHeader = null;

                if (role.equals("Resident")) {
                    statements = readData("residentStatement", "AccountExecutive");
                    //also get file header
                    fileHeader = getFileHeader("residentStatement", "AccountExecutive");
                }

                if (role.equals("Vendor")) {
                    statements = readData("vendorStatement", "AccountExecutive");
                    //also get file header
                    fileHeader = getFileHeader("vendorStatement", "AccountExecutive");
                }
                int dataCount = 0;
                for (String statement : statements) {
                    Map<String, String> invoiceDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] statementDetailsArray = statement.split(dataSeparator);
                    String residentIDFromStatement = statementDetailsArray[5];
                    if (userID.equals(residentIDFromStatement)) {
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

    //this function will get the latest statement ID
    public String getNewStatementID(String role, String userID) {
        //use the get statement method to get the latest statement ID
        Map<Integer, Map<String, String>> statementMap = getStatement(role, userID);
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
    public String getNewInvoiceID(String role, String userID) {
        //use the get statement method to get the latest statement ID
        Map<Integer, Map<String, String>> invoiceMap = getInvoice(role, userID);
        //get the last key in the map
        int lastKey = invoiceMap.size();
        if (invoiceMap.isEmpty()) {
            return "INV1";
        } else {
            //get the statement ID from the map
            String statementID = invoiceMap.get(lastKey).get("INVOICE NUMBER");
            //Statement id is in format ST002, so we need to get the last 3 digits, and convert it to an int, and add 1 to it
            int statementIDInt = Integer.parseInt(statementID.substring(3));
            statementIDInt++;
            //convert the int back to a string
            statementID = "INV" + statementIDInt;
            return statementID;
        }
    }

    public String getNewReceiptID(String role, String userID) {
        //use the get statement method to get the latest statement ID
        Map<Integer, Map<String, String>> receiptMap = getReceipt(role, userID);
        //get the last key in the map
        int lastKey = receiptMap.size();
        if (receiptMap.isEmpty()) {
            return "R1";
        } else {
            //get the statement ID from the map
            String receiptID = receiptMap.get(lastKey).get("RECEIPT ID");
            //Statement id is in format ST002, so we need to get the l  ast 3 digits, and convert it to an int, and add 1 to it
            int receiptIDInt = Integer.parseInt(receiptID.substring(1));
            receiptIDInt++;
            //convert the int back to a string
            receiptID = "R" + receiptIDInt;
            return receiptID;
        }
    }

    public String addStatement(String role, String userID, String description, String amount, String totalAmountDue) {
        try {
            //get the current date
            Date date = new Date();
            //format the date in ddmmyyyy
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
            String currentDate = formatter.format(date);
            String newStatementID = getNewStatementID(role, userID) == null ? "ST1" : getNewStatementID(role, userID);
            //get details like resident name, building, unit number from the resident file
            Map<String, String> residentDetails = getProfileDetails(role, userID);
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
            String newInvoiceNum = getNewInvoiceID(role, userID) == null ? "INV1" : getNewInvoiceID(role, userID);
            //get details like resident name, building, unit number from the resident file
            Map<String, String> residentDetails = getProfileDetails(role, userID);
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
            String newReceiptID = getNewReceiptID(role, userID) == null ? "R1" : getNewReceiptID(role, userID);
            //now put all data inside a hashmap and pass it to the writeData function
            HashMap<String, String> receiptDetails = new HashMap<>();
            receiptDetails.put("DATE", currentDate);
            receiptDetails.put("RECEIPT ID", newReceiptID);
            receiptDetails.put(role.toUpperCase() + " ID", userID);
            receiptDetails.put("INVOICE ID", invoiceID);
            receiptDetails.put("STATEMENT ID", statementID);
            receiptDetails.put("AMOUNT", "MYR " + amount);
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
            receiptDetails.put("AMOUNT", "MYR " + amount);
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

    public boolean updatePayment(String role, String userID, String newTotalAmountDue) {
            {
                try {
                    HashMap<Integer, HashMap<String, String>> paymentMap = new HashMap<>();
                    HashMap<Integer, HashMap<String, String>> statementMap = new HashMap<>();
                    ArrayList<String> statements = null;
                    ArrayList<String> payments = null;
                    ArrayList<String> statementsFileHeader = null;
                    ArrayList<String> paymentsFileHeader = null;

                    if (role.equals("Resident")) {
                        payments = readData("residentPayment", "AccountExecutive");
                        paymentsFileHeader = getFileHeader("residentPayment", "AccountExecutive");
                        statements = readData("residentStatement", "AccountExecutive");
                        statementsFileHeader = getFileHeader("residentStatement", "AccountExecutive");
                    }

                    if (role.equals("Vendor")) {
                        payments = readData("vendorPayment", "AccountExecutive");
                        paymentsFileHeader = getFileHeader("vendorPayment", "AccountExecutive");
                        statements = readData("vendorStatement", "AccountExecutive");
                        statementsFileHeader = getFileHeader("vendorStatement", "AccountExecutive");
                    }

                    int statementDataCount = 0;
                    ArrayList<Integer> statementIndexes = new ArrayList<>();
                    for (String statement : statements) {
                        HashMap<String, String> statementDetails = new HashMap<>();
                        //get the last index of the complaint, which is the status of the complaint
                        String[] statementDetailsArray = statement.split(dataSeparator);
                        String residentIDFromStatement = statementDetailsArray[5];
                        if (userID.equals(residentIDFromStatement)) {statementIndexes.add(statements.indexOf(statement));}
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

                                statementDetails.put(statementsFileHeader.get(columnCount), sb.toString());
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
                                statementDetails.put(statementsFileHeader.get(columnCount - 1), sb.toString());
                                columnCount++;
                            }

                            count++;
                        }
                        statementDataCount++;
                        statementMap.put(statementDataCount, statementDetails);

                    }

                    int paymentDataCount = 0;
                    ArrayList<Integer> paymentIndexes = new ArrayList<>();
                    for (String payment : payments) {
                        HashMap<String, String> paymentDetails = new HashMap<>();
                        //get the last index of the complaint, which is the status of the complaint
                        String[] paymentDetailsArray = payment.split(dataSeparator);
                        String residentIDFromPayment = paymentDetailsArray[2];
                        if (userID.equals(residentIDFromPayment)) {paymentIndexes.add(payments.indexOf(payment));}
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

                                paymentDetails.put(paymentsFileHeader.get(columnCount), sb.toString());
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
                                paymentDetails.put(paymentsFileHeader.get(columnCount - 1), sb.toString());
                                columnCount++;
                            }

                            count++;
                        }
                        paymentDataCount++;
                        paymentMap.put(paymentDataCount, paymentDetails);
                    }


                    //update the current TOTAL AMOUNT DUE in both maps with the new value from the function call
                    statementMap.get(Collections.max(statementIndexes) + 1).put("TOTAL AMOUNT DUE", "MYR " + newTotalAmountDue);
                    paymentMap.get(Collections.max(paymentIndexes) + 1).put("TOTAL AMOUNT DUE", "MYR " + newTotalAmountDue);


                    boolean isPaymentUpdated = updateData(role.toLowerCase() + "Payment", paymentMap, "AccountExecutive");
                    boolean isStatementUpdated = updateData(role.toLowerCase() + "Statement", statementMap, "AccountExecutive");


//                    if (isPaymentUpdated && isStatementUpdated) {
//                        //return an array that has true and the new statement ID
//                        return true;
//                    }

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

        return false;
    }

    public Map<String, String> getProfileDetails(String role, String userID) {
        try {
            //create a list of complaints
            //from the call of the second readData function above, get the list of complaints
            Map<String, String> profileDetails = new HashMap<>();
            ArrayList<String> profiles = null;
            ArrayList<String> fileHeader = null;

            if (role.equals("Resident")) {
                profiles = readData("residentDetail", "Resident");
                //also get file header
                fileHeader = getFileHeader("residentDetail", "Resident");
            }

            if (role.equals("Vendor")) {
                profiles = readData("vendorDetail", "Vendor");
                //also get file header
                fileHeader = getFileHeader("vendorDetail", "Vendor");
            }

            for (String profile : profiles) {
                //get the last index of the complaint, which is the status of the complaint
                String[] profileDetailsArray = profile.split(dataSeparator);
                String userIDFromProfile = profileDetailsArray[0];

                if (userID.equals(userIDFromProfile)) {
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


}
