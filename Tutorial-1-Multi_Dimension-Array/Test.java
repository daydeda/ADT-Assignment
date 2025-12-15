import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        final int MAX_ROWS = 100;
        final int COLS = 2;
        double myList[][] = new double[MAX_ROWS][COLS];

        String filename = "./t1.csv";
        if(args.length > 0){
            filename = args[0];
        }
        File f = new File(filename);
        Scanner myScan = new Scanner(f);
        myScan.useDelimiter("[,\\s]+");

        int count = 0;

        while (myScan.hasNextDouble() && count < MAX_ROWS * COLS) {
            double value = myScan.nextDouble();
            int rowIndex = count / COLS;
            int colIndex = count % COLS;
            myList[rowIndex][colIndex] = value;
            count++;
        }

        double sum = 0;
        int rowsRead = count / COLS;
        for (int i = 0; i < rowsRead; i++) {
            for (int j = 0; j < COLS; j++) {
                sum += myList[i][j]; 
            }
        }
        System.out.println("Sum for both columns A+B : " + sum);
        System.out.println();

        double[] sums = new double[rowsRead];

        for(int i = 0; i < rowsRead; i++){
            double sumOfRows = 0;
            double a = myList[i][0];
            double b = myList[i][1];
            sumOfRows = a + b;
            System.out.println("Sum of row " + (i + 1) + " : " + sumOfRows);
            sums[i] = sumOfRows;
        }
        System.out.println();

        Arrays.sort(sums);

        System.out.println("Top 5 sums (highest): ");
        for (int i = rowsRead - 1; i >= Math.max(0, rowsRead - 5); i--){
            System.out.println(sums[i]);
        }
        System.out.println();

        System.out.println("Bottom 5 sums (lowest): ");
        for (int i = 0; i < 5 && i < rowsRead; i++){
            System.out.println(sums[i]);
        }
        myScan.close();
    }
}