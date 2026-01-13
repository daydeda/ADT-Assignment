import java.io.*;
import java.util.*;

public class TextProcessing {
    public static void main(String[] args)throws IOException{
        // Read file
        String filename = args[0];
        File f = new File(filename);
        
        long startTime = System.currentTimeMillis();
        System.out.println("Program Start: ");

        // Varaible for counting text
        int charCount = 0;
        int palinCount = 0;
        int tokenCount = 0;
        int emoCount = 0;
        int lineCount = 0;

        int totalTokenLength = 0;
        String longestToken = "";

        Scanner myScan = new Scanner(f);
        while (myScan.hasNextLine()){
            String line = myScan.nextLine();
            lineCount++;
            charCount += line.length() + 1;
        }
        myScan.close();
        // Counting token, palindrome, and emoticons
        Scanner tokenScan = new Scanner(f);
        // delimeters splits by comma or whitespace
        tokenScan.useDelimiter("[,\\s]+");
        
        while (tokenScan.hasNextLine()){
            String token = tokenScan.next();
            tokenCount++;
            totalTokenLength += token.length();

            if (token.length() > longestToken.length()){
                longestToken = token;
            }

            if (isEmoticon(token)){
                emoCount++;
            } else if(isPalindrome(token)){
                palinCount++;
            }
        }
        tokenScan.close();
        long endTime = System.currentTimeMillis();
        double totalTime = (endTime - startTime) / 1000.0;



        System.out.println("Total # Character Count: " + charCount);
        System.out.println("Total # Palindrome found: " + palinCount);
        System.out.println("Total Number of tokens: " + tokenCount);
        System.out.println("Total Number of emotiocns: " + emoCount);
        System.out.println("Total # of new line: " + lineCount);
        System.out.println("The longest size token " + longestToken);
        System.out.println("Average size token " + (tokenCount > 0 ? (double)totalTokenLength / 
                    tokenCount : 0));       
        System.out.println("Total time to execute this program: " + totalTime);
        
   }
    
    public static boolean isPalindrome(String s){
        String clean = s.toLowerCase().replaceAll("[^a-z0-9]","");
        if (clean.length() < 2) return false;

        int i = 0, j = clean.length() - 1;
            while (i < j){
            if(clean.charAt(i) != clean.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean isEmoticon(String s){
            return s.matches(".*[:;>=<xX\\\\][\\-~'_]?[\\(\\)\\[\\]\\/\\\\\\|DdPpoO@3<>].*")
                || s.contains("^_^") || s.contains("T_T") || s.contains("o_O") || 
                s.contains("<3") || s.contains("¯_(ツ)_/¯");
    }
}
