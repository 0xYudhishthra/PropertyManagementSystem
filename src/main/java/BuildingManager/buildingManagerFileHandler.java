package BuildingManager;

import Helpers.BookingStatus;
import Helpers.ComplaintStatus;
import Helpers.FileHandler;

import java.text.SimpleDateFormat;
import java.util.*;

public class buildingManagerFileHandler extends FileHandler{

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