/**
 * Author:  0xYudhishthra (github.com/0xYudhishthra)
 * This file is used to define the FileReader interface, some of the methods are defined in the FileReader class
 */

//Import the required packages
package Helpers;

import java.util.ArrayList;

/**
 * FileReader interface declaration starts here.
 */
public interface IFileHandler {

    /**
     * This method is used to check that all the files listed in the user files enum exist and has headers
     *
     * @return boolean - true if all the files exist and has headers, false otherwise
     * @throws Exception
     */
    boolean checkFiles() throws Exception;

    /**
     * This method is used to check if a given file exists
     *
     * @param filename
     * @return boolean
     * @throws Exception
     */
    boolean fileExists(String filename, String userRole) throws Exception;

    /**
     * This method is used to create a new file
     *
     * @param filename
     * @return boolean
     * @throws Exception
     */
    boolean createFile(String filename, String userRole) throws Exception;

    /**
     * This method is used to create a new data record in a given file
     *
     * @param filename
     * @param data
     * @return boolean
     * @throws Exception
     */
    boolean createData(String filename, Object data, String userRole) throws Exception;

    /**
     * This method is used to create new data records in a given file
     *
     * @param filename
     * @param data
     * @return boolean
     * @throws Exception
     */
    boolean createData(String filename, Object[] data, String userRole) throws Exception;

    /**
     * This method is used to create a default header in a newly created text file. parameters are the main title, description, store format (in the form of: {key1, key2, key3, ...})
     *
     * @param filename
     * @param title
     * @param description
     * @param format
     * @return boolean
     * @throws Exception
     */
    boolean createFileHeader(String filename, String title, String description, String[] format, String userRole) throws Exception;

    //read
    //method to read a data record or data records from a given file

    /**
     * This method is used to read data records from a given filename
     *
     * @param filename
     * @return Object
     * @throws Exception
     */
    ArrayList<String> readData(String filename, String userRole) throws Exception;

    /**
     * This method is used to read a data record from a given filename, with a given id
     *
     * @param filename
     * @param id
     * @return Object
     * @throws Exception
     */
    ArrayList<String> readData(String filename, String id, String userRole) throws Exception;


    /**
     * This method is used to get the file header from a given filename, and return it as a string array
     *
     * @param filename
     * @return String[]
     * @throws Exception
     */
    ArrayList<String> getFileHeader(String filename, String userRole) throws Exception;

    //update

    /**
     * This method is used to update a data record from a given filename, with a given id and data to update
     *
     * @param filename
     * @param id
     * @param data
     * @return boolean
     * @throws Exception
     */
    boolean updateData(String filename, String id, Object data) throws Exception;

    /**
     * This method is used to update data records from a given filename, with given IDs and datas to update for each ID
     *
     * @param filename
     * @param ids
     * @param data
     * @return boolean
     * @throws Exception
     */
    boolean updateData(String filename, String[] ids, Object[] data) throws Exception;

    //delete

    /**
     * This method is used to delete all data records from a given filename
     *
     * @param filename
     * @return boolean
     * @throws Exception
     */
    boolean deleteData(String filename) throws Exception;

    /**
     * This method is used to delete a data record from a given filename, with a given id
     *
     * @param filename
     * @param id
     * @return boolean
     * @throws Exception
     */
    boolean deleteData(String filename, String id) throws Exception;

    /**
     * This method is used to delete data records from a given filename, with given IDs
     *
     * @param filename
     * @param ids
     * @return boolean
     * @throws Exception
     */
    boolean deleteData(String filename, String[] ids) throws Exception;
}

