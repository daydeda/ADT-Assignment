import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class T1_Puri_682115036 {
    public static void main(String[] args) throws FileNotFoundException {
        final int MAX_ROWS = 100;
        final int COLS = 2;
        double myList[][] = new double[MAX_ROWS][COLS];

        String filename = args[0];
        File f = new File(filename);
        Scanner myScan = new Scanner(f);
        myScan.useDelimiter("[,\\s]+");

        // Read data into the 2D array
        int count = 0;

        while (myScan.hasNextDouble() && count < MAX_ROWS * COLS) {
            double value = myScan.nextDouble();
            int rowIndex = count / COLS; // Determine row index
            int colIndex = count % COLS; // Determine column index
            myList[rowIndex][colIndex] = value; // Store value in the array
            count++;
        }
        // Calculate the sum of all columns A and B
        double sum = 0;
        int rowsRead = count / COLS; // Calculate the number of rows read
        for (int i = 0; i < rowsRead; i++) { // Loop through rows
            for (int j = 0; j < COLS; j++) { // Loop through columns
                sum += myList[i][j]; // Keep adding into sum variable
            }
        }
        System.out.println("Sum for both columns A+B : " + sum);
        System.out.println("-----------------------------------");

        // Array to hold sums of each row
        double[] sums = new double[rowsRead];

        // Calculate the sum of each row and print
        for (int i = 0; i < rowsRead; i++) {
            double sumOfRows = 0;
            double a = myList[i][0]; // Column A = [i][0]
            double b = myList[i][1]; // Column B = [i][1]
            sumOfRows = a + b;
            System.out.println("Sum of row " + (i + 1) + " : " + sumOfRows);
            // Store each sum in the sums array
            sums[i] = sumOfRows;
        }
        System.out.println("-----------------------------------");

        // Sort the sums array to get top/bottom
        Arrays.sort(sums);

        // Sum of top 5 sums
        System.out.println("Top 5 sums (highest): ");
        double topSum = 0;
        for (int i = rowsRead - 1; i >= Math.max(0, rowsRead - 5); i--) {
            topSum += sums[i];
            System.out.println(sums[i]);
        }
        System.out.println("Total of top 5: " + topSum);
        System.out.println("-----------------------------------");
        // Sum of bottom 5 sums
        System.out.println("Bottom 5 sums (lowest): ");
        double bottomSum = 0;
        for (int i = 0; i < 5 && i < rowsRead; i++) {
            bottomSum += sums[i];
            System.out.println(sums[i]);
        }
        System.out.println("Total of bottom 5: " + bottomSum);
        System.out.println("-----------------------------------");
        // T1_Puri_682115036.java
        System.out.println("T1_Puri_682115036.java");
        myScan.close();
    }
}
/*
 * Output of the program:
 * 
 * Sum for both columns A+B : 94.64298644399994
 * -----------------------------------
 * Sum of row 1 : 0.660171828
 * Sum of row 2 : 1.409473129
 * Sum of row 3 : 0.629238868
 * Sum of row 4 : 1.183617481
 * Sum of row 5 : 0.347479192
 * Sum of row 6 : 1.119297324
 * Sum of row 7 : 1.17507979
 * Sum of row 8 : 0.43317535799999995
 * Sum of row 9 : 1.4620337399999999
 * Sum of row 10 : 0.724323727
 * Sum of row 11 : 1.106973814
 * Sum of row 12 : 1.092935765
 * Sum of row 13 : 1.087694282
 * Sum of row 14 : 0.75770217
 * Sum of row 15 : 1.6357045989999999
 * Sum of row 16 : 0.33127266899999996
 * Sum of row 17 : 0.835687196
 * Sum of row 18 : 0.291921919
 * Sum of row 19 : 0.9195052220000001
 * Sum of row 20 : 1.213869385
 * Sum of row 21 : 1.353945055
 * Sum of row 22 : 0.755185575
 * Sum of row 23 : 1.251375019
 * Sum of row 24 : 0.9189455690000001
 * Sum of row 25 : 1.2888449199999998
 * Sum of row 26 : 0.579220025
 * Sum of row 27 : 1.58246413
 * Sum of row 28 : 0.600684679
 * Sum of row 29 : 0.587796727
 * Sum of row 30 : 1.2011977580000002
 * Sum of row 31 : 1.5758588169999999
 * Sum of row 32 : 1.640928813
 * Sum of row 33 : 1.940271235
 * Sum of row 34 : 0.6618622590000001
 * Sum of row 35 : 1.079776217
 * Sum of row 36 : 0.796347483
 * Sum of row 37 : 0.887296667
 * Sum of row 38 : 1.441579387
 * Sum of row 39 : 0.559099684
 * Sum of row 40 : 0.5558278569999999
 * Sum of row 41 : 1.4992031749999999
 * Sum of row 42 : 0.424835762
 * Sum of row 43 : 1.089964696
 * Sum of row 44 : 0.75675805
 * Sum of row 45 : 0.48258328500000003
 * Sum of row 46 : 1.338086377
 * Sum of row 47 : 0.899630983
 * Sum of row 48 : 1.015908521
 * Sum of row 49 : 0.756154202
 * Sum of row 50 : 0.671009525
 * Sum of row 51 : 1.854719768
 * Sum of row 52 : 0.559814279
 * Sum of row 53 : 1.497515871
 * Sum of row 54 : 1.663621631
 * Sum of row 55 : 0.47424788199999995
 * Sum of row 56 : 0.140358066
 * Sum of row 57 : 1.78662565
 * Sum of row 58 : 0.414208607
 * Sum of row 59 : 0.43939373200000004
 * Sum of row 60 : 0.22635650400000001
 * Sum of row 61 : 1.419267173
 * Sum of row 62 : 0.883733191
 * Sum of row 63 : 0.968900837
 * Sum of row 64 : 0.938308121
 * Sum of row 65 : 0.504016354
 * Sum of row 66 : 0.761115558
 * Sum of row 67 : 1.249967388
 * Sum of row 68 : 0.211324377
 * Sum of row 69 : 0.831028705
 * Sum of row 70 : 0.105112195
 * Sum of row 71 : 1.706907658
 * Sum of row 72 : 1.262242224
 * Sum of row 73 : 0.769128325
 * Sum of row 74 : 0.7047090629999999
 * Sum of row 75 : 0.314143756
 * Sum of row 76 : 1.191832562
 * Sum of row 77 : 0.619583736
 * Sum of row 78 : 1.237717452
 * Sum of row 79 : 1.436555803
 * Sum of row 80 : 0.517802471
 * Sum of row 81 : 0.604203222
 * Sum of row 82 : 1.2617234050000001
 * Sum of row 83 : 1.101665739
 * Sum of row 84 : 0.71688084
 * Sum of row 85 : 1.328043999
 * Sum of row 86 : 0.48414449699999995
 * Sum of row 87 : 1.266559334
 * Sum of row 88 : 1.263589272
 * Sum of row 89 : 1.050527518
 * Sum of row 90 : 0.426710806
 * Sum of row 91 : 0.861865116
 * Sum of row 92 : 1.914177257
 * Sum of row 93 : 1.3249526870000001
 * Sum of row 94 : 0.554947969
 * Sum of row 95 : 1.103579577
 * Sum of row 96 : 0.960304425
 * Sum of row 97 : 1.076035644
 * Sum of row 98 : 1.3817513629999998
 * Sum of row 99 : 0.661264925
 * -----------------------------------
 * Top 5 sums (highest):
 * 1.940271235
 * 1.914177257
 * 1.854719768
 * 1.78662565
 * 1.706907658
 * -----------------------------------
 * Bottom 5 sums (lowest):
 * 0.105112195
 * 0.140358066
 * 0.211324377
 * 0.22635650400000001
 * 0.291921919
 * -----------------------------------
 * T1_Puri_682115036.java
 * 
 */