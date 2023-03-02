package Visitor;

import Helpers.FileHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VisitorFileHandler extends FileHandler {


	public String[] verify(String code) {
        String[] valid = {"TT"};
        try {
        ArrayList<String> datas = readData("residentVisitorPass", "Resident");
        //Split the data into an array
        for (String data : datas) {
            String[] dataSplit = data.split(",");
            //Split each dataSplit with separator " | " and store in an array
            String[] dataSplit2 = dataSplit[0].split("\\|");
            String validCode = dataSplit2[5].strip();
            //Check if the username and password is valid
            if (code.equals(validCode)) {
                //If valid, return the user's details
                valid = new String[] {dataSplit2[0].strip(), dataSplit2[1].strip(), dataSplit2[2].strip(), dataSplit2[3].strip(), dataSplit2[4].strip(), dataSplit2[5].strip()};
            }
        }
        } catch (Exception e) {
            System.out.println(e);
        }
		return valid;
    }
}
