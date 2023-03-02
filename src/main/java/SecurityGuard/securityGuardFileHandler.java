package SecurityGuard;

import Helpers.FileHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class securityGuardFileHandler extends FileHandler {

    @Override
    public boolean createData(String filename, HashMap<String, String> data, String userRole) throws Exception {
        return super.createData(filename, data, userRole);
    }


    public Map<Integer, Map<String, String>> getData(String fileName, String userRole) {
        {
            try {
                //create a list of passes
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> passMap = new HashMap<>();

                ArrayList<String> datas = readData(fileName, userRole);
                //also get file header
                ArrayList<String> fileHeader = getFileHeader(fileName, userRole);
                int dataCount = 0;
                for (String data : datas) {
                    Map<String, String> passDetails = new HashMap<>();

                        int count = 0;
                        int columnCount = 0;

                        for (int i = 0; i < data.length(); i++) {
                            if (data.charAt(i) == dataSeparator.charAt(1)) {
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
                                    temp.append(data.charAt(j));
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
                            if (i == data.length() - 1) {
                                //get the value to start iterating from backwards, which is the index of the data separator - 1
                                int start = i - count + 2;
                                //get the value to end iterating at, which is the index of the data separator - 1 - the length of the data separator

                                //create temp string to store the data
                                StringBuilder temp = new StringBuilder();
                                //iterate through the string backwards
                                for (int j = i; j >= start; j--) {
                                    //add the char to the temp string
                                    temp.append(data.charAt(j));
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
                return passMap;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    public String generateVisitorEntryId() {
        Map<Integer, Map<String, String>> visitorEntryMap = getData("visitorEntry", "SecurityGuard");
        //get the last key in the map
        int lastKey = visitorEntryMap.size();
        //get the statement ID from the map
        String visitorEntryId = visitorEntryMap.get(lastKey).get("VISITOR ENTRY ID");
        //Statement id is in format VE2, so we need to get the last digit, and convert it to an int, and add 1 to it
        //get the last digit
        String lastDigit = visitorEntryId.substring(visitorEntryId.length() - 1);
        //convert the last digit to an int
        int visitorEntryIdInt = Integer.parseInt(lastDigit);
        //add 1 to the int
        visitorEntryIdInt++;
        //convert the int back to a string
        visitorEntryId = "VE" + visitorEntryIdInt;
        return visitorEntryId;
    }

    public String generateIncidentId() {
        Map<Integer, Map<String, String>> incidentMap = getData("incidentRecord", "SecurityGuard");
        //get the last key in the map
        int lastKey = incidentMap.size();
        //get the statement ID from the map
        String incidentId = incidentMap.get(lastKey).get("INCIDENT ID");
        //get the last digit
        String lastDigit = incidentId.substring(incidentId.length() - 1);
        //convert the last digit to an int
        int incidentIdInt = Integer.parseInt(lastDigit);
        //add 1 to the int
        incidentIdInt++;
        //convert the int back to a string
        incidentId = "ID" + incidentIdInt;
        System.out.println("incident id: " + incidentId);
        return incidentId;
    }

    public void addNewEntry(String date, String name, String phoneNumber, String plateNumber, String unitNumber) {
        try {
            //create a new map to store the data
            HashMap<String, String> data = new HashMap<>();
            //add the data to the map
            data.put("VISITOR ENTRY ID", generateVisitorEntryId());
            data.put("DATE", date);
            data.put("NAME", name);
            data.put("PHONE NUMBER", phoneNumber);
            data.put("PLATE NUMBER", plateNumber);
            data.put("UNIT NUMBER", unitNumber);
            //call the createData function to create the data
            createData("visitorEntry", data, "SecurityGuard");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addNewIncident(String date, String name, String plateNumber, String unitNumber, String location, String incidentDetails, String incidentCaused) {
        try {
            //create a new map to store the data
            HashMap<String, String> data = new HashMap<>();
            //add the data to the map
            System.out.println("incident id: " + generateIncidentId());
            data.put("INCIDENT ID", generateIncidentId());
            data.put("DATE", date);
            data.put("NAME", name);
            data.put("PLATE NUMBER", plateNumber);
            data.put("UNIT NUMBER", unitNumber);
            data.put("LOCATION", location);
            data.put("INCIDENT DETAILS", incidentDetails);
            data.put("INCIDENT CAUSED", incidentCaused);
            //call the createData function to create the data
            createData("incidentRecord", data, "SecurityGuard");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateEntry(String date, String name, String phoneNumber, String plateNumber, String unitNumber) {
        try {
            //create a new map to store the data
            HashMap<Integer, HashMap<String, String>> data = new HashMap<>();
            //add the data to the map
            HashMap<String, String> entry = new HashMap<>();
            entry.put("DATE", date);
            entry.put("NAME", name);
            entry.put("PHONE NUMBER", phoneNumber);
            entry.put("PLATE NUMBER", plateNumber);
            entry.put("UNIT NUMBER", unitNumber);

            

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public boolean updateEntryV2(String visitorEntryID, HashMap<String, String> visitorEntryDetails) {
        {

            try {
                HashMap<Integer, HashMap<String, String>> visitorEntryMap = new HashMap<>();

                ArrayList<String> passes = readData("visitorEntry", "SecurityGuard");
                ArrayList<String> passesFileHeader = getFileHeader("visitorEntry", "SecurityGuard");

                int visitorEntryCount = 0;
                for (String pass : passes) {
                    HashMap<String, String> visitorEntryDetailsLocal = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] visitorEntryDetailsArray = pass.split(dataSeparator);
                    String visitorEntryIDFromText = visitorEntryDetailsArray[0];
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

                            visitorEntryDetailsLocal.put(passesFileHeader.get(columnCount), sb.toString());
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
                            visitorEntryDetailsLocal.put(passesFileHeader.get(columnCount - 1), sb.toString());
                            columnCount++;
                        }

                        count++;
                    }
                    visitorEntryCount++;
                    visitorEntryMap.put(visitorEntryCount, visitorEntryDetailsLocal);
                }

                System.out.println("data before update: " + visitorEntryMap);
                //now that we have the profile map, we just need to find the profile that matches the residentID, and update the profile
                for (int i = 1; i <= visitorEntryMap.size(); i++) {
                    HashMap<String, String> visitorEntryDetailsMap = visitorEntryMap.get(i);
                    String visitorEntryIDFromMap = visitorEntryDetailsMap.get("VISITOR ENTRY ID");
                    System.out.println("visitorEntryIDFromMap: " + visitorEntryIDFromMap + " visitorEntryID: " + visitorEntryID);
                    if (visitorEntryIDFromMap.equals(visitorEntryID)) {
                        //we would then compare the profileDetailsMap with the profileDetails, and update the profileDetailsMap with the profileDetails
                        //then we would update the profileMap with the profileDetailsMap
                        for (String key : visitorEntryDetails.keySet()) {
                            visitorEntryDetailsMap.put(key, visitorEntryDetails.get(key));
                        }
                        visitorEntryMap.put(i, visitorEntryDetailsMap);
                    }
                }

                System.out.println("data after update" + visitorEntryMap);

                //now that we have the updated profileMap, we need to write the data to the file
                boolean isVisitorEntryUpdated = updateData("visitorEntry", visitorEntryMap, "SecurityGuard");
                if (isVisitorEntryUpdated) {
                    return true;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            return false;
        }
    }


}
