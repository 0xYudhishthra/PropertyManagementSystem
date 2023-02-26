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
     * This method is used to create a new data record in a given file
     *
     * @param filename - the file to create the new data record in
     * @param data - the data to insert
     * @return boolean
     * @throws Exception - if data cannot be inserted
     */
//    boolean createData(String filename, Object data, String userRole) throws Exception;

    /**
     * This method is used to create new data records in a given file
     *
     * @param filename
     * @param data
     * @return boolean
     * @throws Exception
     */
//    boolean createData(String filename, Object[] data, String userRole) throws Exception;

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
//    ArrayList<String> getFileHeader(String filename, String userRole) throws Exception;

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
//    boolean updateData(String filename, String id, Object data) throws Exception;

    /**
     * This method is used to update data records from a given filename, with given IDs and datas to update for each ID
     *
     * @param filename
     * @param ids
     * @param data
     * @return boolean
     * @throws Exception
     */
//    boolean updateData(String filename, String[] ids, Object[] data) throws Exception;

    //delete

    /**
     * This method is used to delete all data records from a given filename
     *
     * @param filename
     * @return boolean
     * @throws Exception
     */
//    boolean deleteData(String filename) throws Exception;

    /**
     * This method is used to delete a data record from a given filename, with a given id
     *
     * @param filename
     * @param id
     * @return boolean
     * @throws Exception
     */
//    boolean deleteData(String filename, String id) throws Exception;

    /**
     * This method is used to delete data records from a given filename, with given IDs
     *
     * @param filename
     * @param ids
     * @return boolean
     * @throws Exception
     */
//    boolean deleteData(String filename, String[] ids) throws Exception;
}

