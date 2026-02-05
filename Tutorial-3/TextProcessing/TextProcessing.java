import java.io.*;
import java.util.*;

public class TextProcessing {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        File f = new File(filename);
        
        if (!f.exists()) {
            System.out.println("Error: File not found -> " + filename);
            return;
        }

        long startTime = System.currentTimeMillis();
        System.out.println("Program Start: " + filename);

        long charCount = 0;
        int palinCount = 0;
        int tokenCount = 0;
        int emoCount = 0;
        int lineCount = 0;

        long totalTokenLength = 0;
        String longestToken = "";

        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineCount++;
                charCount += line.length() + 1;

                // --- 1. Manual CSV Parsing (No Regex) ---
                // We need to find the tweet, which is after the 5th comma.
                String tweet = extractTweetFromCSV(line);

                // --- 2. Manual Tokenization (StringTokenizer) ---
                // " \t\n\r\f," defines the delimiters: space, tabs, newlines, commas
                StringTokenizer tokenizer = new StringTokenizer(tweet, " \t\n\r\f,");

                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    
                    // Skip empty tokens if any
                    if (token.length() == 0) continue;

                    tokenCount++;
                    totalTokenLength += token.length();

                    if (token.length() > longestToken.length()) {
                        longestToken = token;
                    }

                    if (isEmoticon(token)) {
                        emoCount++;
                    } else if (isPalindrome(token)) {
                        palinCount++;
                    }
                }
            }
        }

        long endTime = System.currentTimeMillis();
        double totalTime = (endTime - startTime) / 1000.0;

        System.out.println("Total # Character Count: " + charCount);
        System.out.println("Total # Palindrome found: " + palinCount);
        System.out.println("Total Number of tokens: " + tokenCount);
        System.out.println("Total Number of emoticons: " + emoCount);
        System.out.println("Total # of new lines: " + lineCount);
        System.out.println("The longest size token: " + longestToken);
        System.out.println("Average size token: " + (tokenCount > 0 ? (double) totalTokenLength / tokenCount : 0));
        System.out.println("Total time to execute this program: " + totalTime + " seconds");
    }

    // Helper: extract the 6th column without split()
    private static String extractTweetFromCSV(String line) {
        int commasFound = 0;
        int index = 0;
        
        // Loop to find the position of the 5th comma
        while (commasFound < 5 && index < line.length()) {
            if (line.charAt(index) == ',') {
                commasFound++;
            }
            index++;
        }
        
        // If we found 5 commas, everything after is the tweet
        if (commasFound == 5) {
            String tweet = line.substring(index);
            // Remove surrounding quotes if present
            if (tweet.length() >= 2 && tweet.startsWith("\"") && tweet.endsWith("\"")) {
                return tweet.substring(1, tweet.length() - 1);
            }
            return tweet;
        }
        return ""; // Return empty if line format is wrong
    }

    // Helper: Check Palindrome without replaceAll
    public static boolean isPalindrome(String s) {
        // Build a clean string manually (only letters and digits)
        StringBuilder cleanBuilder = new StringBuilder();
        for (int k = 0; k < s.length(); k++) {
            char c = s.charAt(k);
            if (Character.isLetterOrDigit(c)) {
                cleanBuilder.append(Character.toLowerCase(c));
            }
        }
        
        String clean = cleanBuilder.toString();
        
        if (clean.length() < 2) return false;

        int i = 0, j = clean.length() - 1;
        while (i < j) {
            if (clean.charAt(i) != clean.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    // Helper: Check Emoticon without Regex matches()
    public static boolean isEmoticon(String s) {
        // Manual check for common eyes
        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);
        
        // Check for common specific text emoticons
        if (s.contains("^_^") || s.contains("T_T") || s.contains("o_O") || s.contains("<3")) {
            return true;
        }

        // Basic check: Starts with eyes (:, ;, =) or ends with eyes (D, P, ) )
        boolean startsWithEyes = (first == ':' || first == ';' || first == '=');
        
        // If it starts with eyes, check if it has a valid mouth character anywhere later
        if (startsWithEyes) {
             if (s.contains(")") || s.contains("(") || s.contains("D") || s.contains("P") || s.contains("/") || s.contains("|")) {
                 return true;
             }
        }
        
        return false;
    }
}