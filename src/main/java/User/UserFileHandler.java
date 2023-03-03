package User;

import Helpers.FileHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserFileHandler extends FileHandler {


	public String[] login(String username, String password) {
        String[] valid = {"TT"};
        try {
        ArrayList<String> datas = readData("loginRecords", "User");
        //Split the data into an array
        for (String data : datas) {
            String[] dataSplit = data.split(",");
            //Split each dataSplit with separator " | " and store in an array
            String[] dataSplit2 = dataSplit[0].split("\\|");
            String UID = dataSplit2[0];
            String validUsername = dataSplit2[1].strip();
            String validPassword = dataSplit2[2].strip();
            //Check if the username and password is valid
            if (username.equals(validUsername) && password.equals(validPassword)) {
                if(UID.startsWith("RN")){
                    valid = new String[]{"Resident", UID};
                }
                else if(UID.startsWith("SG")){
                    valid = new String[]{"Security", UID};
                }
                else if(UID.startsWith("AE")){
                    valid = new String[]{"AccountExecutive", UID};
                }
                else if(UID.startsWith("VN")){
                    valid = new String[]{"Vendor", UID};
                }
                else if(UID.startsWith("AM")){
                    valid = new String[]{"AdminExecutive", UID};
                }
                else if(UID.startsWith("BM")){
                    valid = new String[]{"BuildingManager", UID};
                }
                else if(UID.startsWith("BE")){
                    valid = new String[]{"BuildingExecutive", UID};
                }
            }
        }
        } catch (Exception e) {
            System.out.println(e);
        }
		return valid;
    }
}
