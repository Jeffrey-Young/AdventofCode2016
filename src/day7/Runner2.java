package day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner2 {
  public static void main(String[] args) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("input/day7input1.txt"));
      int supported = 0;
      while (reader.ready()) {
        String line = reader.readLine();
        boolean invalidLine = false;
        boolean validLine = false;
        Scanner s = new Scanner(line);
        s.useDelimiter("\\|");
        ArrayList<String> valid = new ArrayList<String>();
        ArrayList<String> invalid = new ArrayList<String>();
        while (s.hasNext()) {
          valid.add(s.next());
          if (s.hasNext()) {
            invalid.add(s.next());
          }
        }
        for (String t : invalid) {
          for (int i = 1; i < t.length(); i++) {
            if (i + 3 < t.length()) {
              if (t.charAt(i) == t.charAt(i + 3) && t.charAt(i + 1) == t.charAt(i + 2)
                  && t.charAt(i) != t.charAt(i + 1)) {
                invalidLine = true;
              }
            }
          }
        }
        for (String t : valid) {
          for (int i = 0; i < t.length(); i++) {
            if (i + 3 < t.length()) {
              if (t.charAt(i) == t.charAt(i + 3) && t.charAt(i + 1) == t.charAt(i + 2)
                  && t.charAt(i) != t.charAt(i + 1)) {
                validLine = true;
              }
            }
          }
        }
        if (validLine && !invalidLine) {
          supported++;
        }
      }
      System.out.println(supported);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
