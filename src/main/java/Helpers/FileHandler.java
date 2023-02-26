/**
 * Author:  0xYudhishthra (github.com/0xYudhishthra)
 * This file is used to define the FileReader interface, some methods are defined in the FileReader class
 */

//import the required packages
package Helpers;

import java.util.ArrayList;

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
    protected ArrayList<String> getFileHeader(String filename, String userRole) {
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
//    public boolean createData(String filename, Object data, String userRole) throws Exception {
//        //depending on whether the data passed is Object or Object[], we call the appropriate method
//
//
//        try {
//            boolean writeData = false;
//            if (fileExists(filename, userRole)) {
//                //if the file exists, we append the data to the file
//                writeData = true;
//            } else {
//                //if the file doesn't exist, we create the file and then if that is a success, assign true to writeData
//                writeData = createFile(filename, userRole) && createFileHeader(filename,
//
//            }
//
//            if (writeData) {
//                if (data instanceof Object[]) {
//                    return createData(filename, (Object[]) data, userRole);
//                } else {
//                    return createData(filename, data, userRole);
//                }
//            }
//
//        } catch (Exception e) {
//            throw new Exception("Error occured at createData function with parameters: filename = " + filename + ", data = " + data + ", userRole = " + userRole + " : " + e.getMessage());
//        }
//
//
}
