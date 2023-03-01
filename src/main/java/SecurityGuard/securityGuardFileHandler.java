package SecurityGuard;

import Helpers.FileHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class securityGuardFileHandler extends FileHandler {

    public Map<Integer, Map<String, String>> getData(String fileName, String userRole) {
        {
            try {
                //create a list of passes
                //from the call of the second readData function above, get the list of complaints
                Map<Integer, Map<String, String>> passMap = new HashMap<>();

                ArrayList<String> datas = readData(fileName, userRole);
                System.out.println("test : " + datas);
                //also get file header
                ArrayList<String> fileHeader = getFileHeader(fileName, userRole);
                int dataCount = 0;
                for (String data : datas) {
                    Map<String, String> passDetails = new HashMap<>();
                    //get the last index of the complaint, which is the status of the complaint
                    String[] passDetailsArray = data.split(dataSeparator);
                    String residentIDFromPass = passDetailsArray[0];

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

}
