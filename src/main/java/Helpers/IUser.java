/**
 * Author:  0xYudhishthra (github.com/0xYudhishthra)
 * This file is used to define the IUser interface, some of the methods are defined in the IUser class
 */

//Import the required packages
package Helpers;


/**
 * IUser interface declaration starts here.
 */
public interface IUser {
    /**
     * This method is used to get the user's name
     *
     * @return String
     * @throws Exception
     */
    String getName() throws Exception;

    /**
     * This method is used to get the user's email
     *
     * @return String
     * @throws Exception
     */
    String getEmail() throws Exception;

    /**
     * This method is used to get the user's phone number
     *
     * @return String
     * @throws Exception
     */
    String getPhoneNumber() throws Exception;

    /**
     * This method is used to get the user's address
     *
     * @return String
     * @throws Exception
     */

    String getAddress() throws Exception;

    /**
     * This method is used to get the user's password
     *
     * @return String
     * @throws Exception
     */
    String getPassword() throws Exception;

    /**
     * This method is used to get the user's role
     *
     * @return String
     * @throws Exception
     */
    String getRole() throws Exception;

    /**
     * This method is used to get the user's id
     *
     * @return String
     * @throws Exception
     */
    String getId() throws Exception;

    /**
     * This method is used to get the user's building name
     *
     * @return String
     * @throws Exception
     */
    String getBuildingName() throws Exception;

    /**
     * This method is used to get the user's unit name
     *
     * @return String
     * @throws Exception
     */
    String getUnitName() throws Exception;

    /**
     * This method is used to get the user's move in date
     *
     * @return String
     * @throws Exception
     */
    String getMoveInDate() throws Exception;

    /**
     * This method is used to get the user's profile picture
     *
     * @return String
     * @throws Exception
     */
    String getProfilePicture() throws Exception;

    /**
     * This method is used to get the user's username
     *
     * @return String
     * @throws Exception
     */
    String getUsername() throws Exception;

    /**
     * This method is used to set the user's name
     *
     * @param name
     * @throws Exception
     */
    void setName(String name) throws Exception;

    /**
     * This method is used to set the user's email
     *
     * @param email
     * @throws Exception
     */
    void setEmail(String email) throws Exception;

    /**
     * This method is used to set the user's phone number
     *
     * @param phoneNumber
     * @throws Exception
     */
    void setPhoneNumber(String phoneNumber) throws Exception;

    /**
     * This method is used to set the user's address
     *
     * @param address
     * @throws Exception
     */
    void setAddress(String address) throws Exception;

    /**
     * This method is used to set the user's password
     *
     * @param password
     * @throws Exception
     */
    void setPassword(String password) throws Exception;

    /**
     * This method is used to set the user's role
     *
     * @param role
     * @throws Exception
     */
    void setRole(String role) throws Exception;

    /**
     * This method is used to set the user's id
     *
     * @param id
     * @throws Exception
     */
    void setId(String id) throws Exception;

    /**
     * This method is used to set the user's building name
     *
     * @param buildingName
     * @throws Exception
     */
    void setBuildingName(String buildingName) throws Exception;

    /**
     * This method is used to set the user's unit name
     *
     * @param unitName
     * @throws Exception
     */
    void setUnitName(String unitName) throws Exception;

    /**
     * This method is used to set the user's move in date
     *
     * @param moveInDate
     * @throws Exception
     */
    void setMoveInDate(String moveInDate) throws Exception;

    /**
     * This method is used to set the user's profile picture
     *
     * @param profilePicture
     * @throws Exception
     */
    void setProfilePicture(String profilePicture) throws Exception;

    /**
     * This method is used to set the user's username
     *
     * @param username
     * @throws Exception
     */
    void setUsername(String username) throws Exception;

}
