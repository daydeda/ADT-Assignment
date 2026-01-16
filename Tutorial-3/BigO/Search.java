// Puri Sangnawakit 682115036

import java.util.*;
import java.io.*;

public class Search {
    public static void main(String[] args) throws IOException{

        // 1. Reading data from a file
        String filename = args[0];
        File file = new File(filename);

        Scanner myScan = new Scanner(file);
        myScan.useDelimiter("[,\\s]+");

        // 2. ArrayList to store the values
        ArrayList<Double> dataList = new ArrayList<>();

        while(myScan.hasNextDouble()){
            double value = myScan.nextDouble();
            dataList.add(value);
        }
        myScan.close();

        int result = mySearch(dataList);
        
        System.out.println("Total number of values read: " + dataList.size());
        System.out.println("Number of values > 0.5: " + result);
    }

    public static int mySearch(ArrayList<Double> values) {
        // Number of value that > 0.5
        int countValue = 0;
        for (double val : values){
            if(val > 0.5){
                countValue++;
            }
        }
        return countValue;
    }
}
// Outputs
 /* 
    $> Total number of values read: 85
    $> Number of values > 0.5: 45
 
 */