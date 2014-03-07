package csv.handling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruvin on 2/23/14.
 */
public class ReadFromCSV {

    /**
     * Will return the list of strings where each string/line represent a room or something else
     * (with all attributes) from Room.CSV.
     *@param csvFile name of the file
     *@return
     */
    public List<String> returnSuitableList(String csvFile) {
        BufferedReader br = null;
        String line = "";
        List<String> suitableList = new ArrayList<String>(); //to store the list of rooms from CSV file

        try {
            br = new BufferedReader(new FileReader(csvFile));//Decorator
            while ((line = br.readLine()) != null) {
                    suitableList.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return suitableList;
    }
}

