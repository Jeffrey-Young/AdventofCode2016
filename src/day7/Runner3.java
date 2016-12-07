package day7;

import java.io.BufferedReader;
import java.io.FileReader;

public class Runner3 {
  public static void main(String[] args) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("input/day7input1.txt"));
      // BufferedReader reader = new BufferedReader(new
      // FileReader("input/test.txt"));
      int supported = 0;
      while (reader.ready()) {
        String line = reader.readLine();
        int i = 0;
        boolean foundInvalid = false;
        boolean foundValid = false;
        String regularWord = "";
        while (i < line.length()) {
          if (line.charAt(i) == '[') {
            i++; // skip
            if (!foundValid) {
              // System.out.println(regularWord);
              foundValid = palindromeSearch(regularWord);
            }
            regularWord = "";
            String bracketWord = "";
            while (line.charAt(i) != ']') {
              bracketWord += line.charAt(i);
              i++;
            }
            // search for palindrome
            if (!foundInvalid) {
              foundInvalid = palindromeSearch(bracketWord);
            }
            i++; // one more i++ to skip ]
          }
          regularWord += line.charAt(i);
          i++;
        }
        // check the last token
        // System.out.println(regularWord);
        if (!foundValid) {
          foundValid = palindromeSearch(regularWord);
        }
        if (foundValid && !foundInvalid) {
          supported++;
        }
      }
      System.out.println(supported);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private static boolean palindromeSearch(String line) {
    for (int i = 0; i < line.length(); i++) {
      if (i + 3 < line.length()) {
        if (line.charAt(i) == line.charAt(i + 3) && line.charAt(i + 1) == line.charAt(i + 2) && line.charAt(i) != line.charAt(i + 1)) {
          return true;
        }
      }
    }
    return false;
  }
}
