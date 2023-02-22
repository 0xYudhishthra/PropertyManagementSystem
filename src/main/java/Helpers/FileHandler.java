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
abstract class FileHandler implements IFileHandler {
    //declare a static variable to hold the file path
    private static String filePath = "src/main/resources/";

    //store a way to track the existence status of the required text files, there are 8 text files.
    // something like this: {user.txt: true, booking.txt: false, facility.txt: true, etc}
    private static java.util.HashMap<String, Boolean> fileExistsStatus = new java.util.HashMap<>();

    //declare a static variable to hold the file extension
    private static String fileExtension = ".txt";

    //declare a static variable to hold the file separator, syste.getProperty is used here to
    private static String dataSeparator = " | ";

    //declare a static variable to hold the file header separator
    private static String headerSeparator = "_____________________";


//    /**
//     * This method is used to check that all the files listed in the user files enum passed exist and has headers
//     *
//     * @param userFiles
//     * @param userRole
//     * @return boolean - true if all the files exist and has headers, false otherwise
//     * @throws Exception
//     */
//    //the workflow is such that, the user will pass the name of the enum, and the function will go inside that enum and check if each of the files exists by first comparing
//    // the value obtained by .values() to the output by the fileExists() method,
//    //if the file exists, then the function will check if the file has headers by comparing the output of getHeaders() to the headers in the file
//    //if the file does not exist, then the function will create the file and add the headers to it
//    //if the file exists and has headers, then the function will return true and add the file to the fileExistsStatus hashmap
//    public boolean checkFiles(Class<? extends Enum<?>> enumType, String userRole) throws Exception {
//        try {
//            //loop through the files in the enum
//            Enum<?>[] files = enumType.getEnumConstants();
//            for (Enum<?> file: files) {
//                //check if the file exists
//                if (fileExists(file.toString(), userRole)) {
//                    String[] headers = getHeaders(file.toString(), userRole);
//                    //check if the file has headers
//                    if (headers.equals(getFileHeader(file.toString(), userRole))) {
//                        //add the file to the fileExistsStatus hashmap
//                        fileExistsStatus.put(file.toString(), true);
//                    } else {
//                            String storeFormat = "";
//                            for (int i = 2; i < headers.length; i++) {
//                                storeFormat += headers[i] + ",";
//                            }
//                        //if the file does not have headers, then add the headers to the file
//                            createFileHeader(file.toString(), headers[0], headers[1], new String[]{headers[2:3]}, userRole);
//                    }
//                } else {
//                    //if the file does not exist, then create the file and add the headers to it
//                    createFile(file, userRole);
//                    addHeaders(file, userFiles.getHeaders(file), userRole);
//                }
//            }
//            //return true if all the files exist and has headers
//            return true;
//        } catch (Exception e) {
//            throw new Exception("Error occured at checkFiles function with parameters: userFiles = " + userFiles + " : " + e.getMessage());
//        }
//    }


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
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
            //close the reader
            reader.close();
            //return the data
            return data;
        } catch (Exception e) {
            throw new Exception("Error occured at readData function with parameters: filename = " + filename + ", userRole = " + userRole + " : " + e.getMessage());
        }
    }


    /**
     * This method is used to get the headers of a given file by passing the enum and checking the value of that enum
     *
     * @param filename
     * @return String[] - the headers of the file
     * @throws Exception
     */
//    public String[] getHeaders(String filename, String userRole) throws Exception {
//        try {
//            //The user role is first used to identify which enum file to get, then the filename is used to get the enum value to call and get the
//            //headers from the enum
//            //get the right enum to call by first identifying the user role, all enums usually end with Files, so we add that to the user role
//            //then we use the Class.forName() method to get the class of the enum, then we use the .getEnumConstants() method to get the enum values
//            //then we use the .valueOf() method to get the enum value
//            //then we use the .getHeaders() method to get the headers
////            return userFiles.valueOf(userRole + "Files").getHeaders(filename);
//
//        } catch (Exception e) {
//            throw new Exception("Error occured at getHeaders function with parameters: filename = " + filename + ", userRole = " + userRole + " : " + e.getMessage());
//        }
//    }


    /**
     * This method is used to check if a given file exists
     *
     * @param filename
     * @param userRole
     * @return boolean - true if the file exists, false otherwise
     * @throws Exception
     */
//    public boolean fileExists(String filename, String userRole) throws Exception {
//        try {
//            //check if the file exists by passing the full path to the java.io.File.exists() method, an example is src/main/resources/userRole/filename.txt
//            return new java.io.File(filePath + userRole + "/" + filename + fileExtension).exists();
//        } catch (Exception e) {
//            throw new Exception("Error occured at fileExists function with parameters: filename = " + filename + ", userRole = " + userRole + " : " + e.getMessage());
//        }
//    }

    /**
     * This method is used to create a new file
     *
     * @param filename
     * @param title
     * @param description
     * @param format
     * @param userRole
     * @return boolean - true if the file was created successfully, false otherwise
     * @throws Exception
     */
//    public boolean createFileHeader(String filename, String title, String description, String @NotNull [] format, String userRole) throws Exception {
//        try {
//
//            //create a string builder to hold the header
//            StringBuilder header = new StringBuilder();
//
//            //append the header separator
//            header.append(headerSeparator).append(System.getProperty("line.separator"));
//
//            //append the title
//            header.append(title).append(System.getProperty("line.separator"));
//
//            //append a new line
//            header.append(System.getProperty("line.separator"));
//
//            //append the description
//            header.append(description).append(System.getProperty("line.separator"));
//
//            //append the store format
//            header.append("STORE FORMAT: ");
//
//            //loop through the format array
//            for (int i = 0; i < format.length; i++) {
//                //append the format in the form of <key> | <key> | <key> | ...
//                header.append('<' + format[i] + '>');
//
//                //check if we are at the last element
//                if (i != format.length - 1) {
//                    //if we are not at the last element, append the data separator
//                    header.append(dataSeparator);
//                }
//            }
//
//            //append a new line
//            header.append(System.getProperty("line.separator"));
//
//            //append the header separator
//            header.append(headerSeparator).append(System.getProperty("line.separator"));
//
//            //return the result of the createFile method
//            return createData(filename, header.toString(), userRole);
//        } catch (Exception e) {
//            throw new Exception("Error occurred at createFileHeader function with parameters: filename = " + filename + ", title = " + title + ", description = " + description + ", format = " + format + ", userRole = " + userRole + " : " + e.getMessage());
//        }
//    }

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
