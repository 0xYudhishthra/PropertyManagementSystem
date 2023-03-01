/**
 * Author:  0xYudhishthra (github.com/0xYudhishthra)
 * This file is used to define the FileReader interface, some methods are defined in the FileReader class
 */

//import the required packages
package Helpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * FileReader class declaration starts here.
 */
public class FileHandler implements IFileHandler {
    //declare a static variable to hold the file path
    private static String filePath = "src/main/resources/";

    //store a way to track the existence status of the required text files, there are 8 text files.
    // something like this: {user.txt: true, booking.txt: false, facility.txt: true, etc}
    private static java.util.HashMap<String, Boolean> fileExistsStatus = new java.util.HashMap<>();

    //declare a static variable to hold the file extension
    private static String fileExtension = ".txt";

    //declare a static variable to hold the file separator, syste.getProperty is used here to
    protected static String dataSeparator = " | ";

    //declare a static variable to hold the file header separator
    private static String headerSeparator = "_____________________";


    /**
     * This method is used to read all contents of a given file
     *
     * @param filename
     * @param userRole
     * @return String - the contents of the file
     * @throws Exception
     */
    public ArrayList<String> readData(String filename, String userRole) throws Exception {
        try {
            //create a new java.util.ArrayList to store the contents of the file
            ArrayList<String> data = new ArrayList<>();
            //create a new java.io.BufferedReader to read the contents of the file
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filePath + userRole + "/" + filename + fileExtension));
            System.out.println("read: " + reader);
            //read the contents of the file and store it in the data variable
            String line;
            int count = 0;

            //traverse the lines first to ensure headers are not read, and to know which line index to start reading data frm
            while ((line = reader.readLine()) != null) {
                if (line.contains(headerSeparator)) {
                    count++;
                }

                if (count == 2) {
                    break;
                }
            }

            //traverse to the data line index, and print the data, dont print empty lines
            while ((line = reader.readLine()) != null) {
                if (line.equals("")) {
                    continue;
                }
                data.add(line.strip());
            }
            //close the reader
            reader.close();
            //return the data
            return data;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<String> readData(String filename, String id, String userRole) throws Exception {
        //follows same implementation as above with the exception of the id parameter, we are looking for a specific record in the file
        try {
            ArrayList<String> data = new ArrayList<>();
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filePath + userRole + "/" + filename + fileExtension));
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if (line.contains(headerSeparator)) {
                    count++;
                }
                if (count == 2) {
                    break;
                }
            }
            while ((line = reader.readLine()) != null) {
                if (line.equals("")) {
                    continue;
                }
                if (line.contains(id)) {
                    data.add(line);
                }
            }
            reader.close();
            return data;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    /**
     * This method is used to get the headers of a given file
     *
     * @param filename
     * @return String[] - the headers of the file
     * @throws Exception
     */
    public ArrayList<String> getFileHeader(String filename, String userRole) {
        ArrayList<String> headers = null;
        try {
            headers = new ArrayList<>();
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filePath + userRole + "/" + filename + fileExtension));
            //read the contents of the file and store it in the data variable
            String line;
            //traverse lines until you find "STORE FORMAT: " then read the data along this line, strip the '<' and '>' characters and store it in the headers variable
            while ((line = reader.readLine()) != null) {
                if (line.contains("STORE FORMAT: ")) {
                    //split the elements after store format using the data separator
                    //strip the "STORE FORMAT: " part of the string
                    line = line.replace("STORE FORMAT: ", "");
                    //replace the data separator with a space, and then split the string using the space
                    line = line.replace(dataSeparator, " ");
                    String currentHeader = "";
                    for (int i = 0; i < line.length(); i++) {
                        if (line.charAt(i) == '<') {
                            currentHeader += line.charAt(i);
                        } else if (line.charAt(i) == '>') {
                            currentHeader += line.charAt(i);
                            headers.add(currentHeader.strip());
                            currentHeader = "";
                        } else {
                            currentHeader += line.charAt(i);
                        }
                    }
                    //strip the '<' and '>' characters from each element in the headers variable
                    for (int i = 0; i < headers.size(); i++) {
                        headers.set(i, headers.get(i).replace("<", "").replace(">", ""));
                    }
                    //break out of the loop
                    break;
                }
            }
            //close the reader
//            reader.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        //return headers
        return headers;
    }

    /**
     * This method is used to create a new data record in a file
     *
     * @param filename
     * @param data
     * @param userRole
     * @return boolean - true if the data was successfully appended to the file, false otherwise
     * @throws Exception
     */
    public boolean createData(String filename, HashMap<String, String> data, String userRole) throws Exception {
        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filePath + userRole + "/" + filename + fileExtension));
            //read the contents of the file and store it in the data variable
            String line;
            int headerCount = 0;
            while ((line = reader.readLine()) != null) {
                if (line.contains(headerSeparator)) {
                    headerCount++;
                }

                if (headerCount == 2) {
                    break;
                }
            }

            //now, we have the line index to start writing data to, so we can close the reader
            reader.close();

            //create a new java.io.BufferedWriter to write the contents of the file
            java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(filePath + userRole + "/" + filename + fileExtension, true));

            ArrayList<String> headers = getFileHeader(filename, userRole);
            //we use a temp variable to store the data to be written to the file
            String temp = "";
            //we compare the key value from object data to that of the headers, and write the data in the same order as the headers
            for (int i = 0; i < headers.size(); i++) {
                //get the key value pair from the data object
                String key = headers.get(i);
                String value = data.get(key);
                //append the value to the temp variable
                temp += value;
                //if we are not at the last element, append the dataSeparator to the temp variable
                if (i != headers.size() - 1) {
                    temp += dataSeparator;
                }
                //if we are at the last element, append the new line character to the temp variable
                else {
                    temp += "\n";
                }
            }

            //write the data to the file
            writer.write(temp);
            //close the writer
            writer.close();
            //if data has been written to the file, return true
            return true;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    /**
     * This method is used to update a data record in a file
     *
     * @param filename
     * @param data
     * @param userRole
     * @return boolean - true if the data was successfully updated in the file, false otherwise
     * @throws Exception
     */
    public boolean updateData(String filename, HashMap<Integer, HashMap<String, String>> data, String userRole) throws Exception {
        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filePath + userRole + "/" + filename + fileExtension));
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath + userRole + "/" + filename + ".temp", false)));
            String line;
            int lineNum = 0; // track line number
            while ((line = reader.readLine()) != null) {
                // check if current line is a header line
                boolean isHeaderSeparator = line.contains(headerSeparator);
                if (isHeaderSeparator) {
                    // if header line, print an extra blank line before it
                    writer.println(line);
                }
                if (!isHeaderSeparator && lineNum != 5) {
                    // if not header line and not first line, print a blank line after it
                    writer.println(line);
                }
                lineNum++;

                if (lineNum == 6) {
                    // if first line, print a blank line after it
                    break;
                }
            }

            // print data
            String temp = "";
            ArrayList<String> headers = getFileHeader(filename, userRole);
            for (int i = 1; i < data.size() + 1; i++) {
                HashMap<String, String> currentData = data.get(i);
                for (int j = 0; j < headers.size(); j++) {
                    String key = headers.get(j);
                    String value = currentData.get(key);
                    temp += value;
                    if (j != headers.size() - 1) {
                        temp += dataSeparator;
                    } else {
                        temp += "\n";
                    }
                }
            }
            writer.println(temp);

            //close the reader
            reader.close();
            //close the writer
            writer.close();
            File realName = new File(filePath + userRole + "/" + filename + fileExtension);
            File oldName = new File(filePath + userRole + "/" + filename + fileExtension + ".tmp");
            //add ".tmp" to the end of the filename
            new File(filePath + userRole + "/" + filename + ".temp").renameTo(realName); // rename the new file to the filename the original file had.
            oldName.delete();
            //if data has been written to the file, return true
            return true;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}



