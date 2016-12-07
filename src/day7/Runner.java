package day7;

import java.io.BufferedReader;
import java.io.FileReader;

public class Runner {
  public static void main(String[] args) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("input/day7input1.txt"));
      //BufferedReader reader = new BufferedReader(new FileReader("input/test.txt"));
      int supported = 0;
      while (reader.ready()) {
        String line = reader.readLine();
        boolean inBracket = false;
        boolean isDirty = false;
        String cleaned = "";
        String dirty = "";
        for (char j : line.toCharArray()) {
          boolean incSupported = false;
          if (j == '[') {
            inBracket = true;
            for (int i = 0; i < cleaned.length(); i++) {
              if (i + 3 < cleaned.length()) {
                if (cleaned.charAt(i) == cleaned.charAt(i + 3)
                    && cleaned.charAt(i + 1) == cleaned.charAt(i + 2)
                    && cleaned.charAt(i) != cleaned.charAt(i + 1) && !incSupported) {
                  incSupported = true;
                  supported++;
                  
                }
              }
            }
            cleaned = "";
          }
          if (j == ']') {
            inBracket = false;
            continue;
          }
          if (!inBracket) {
            cleaned += j;
          }
          if (inBracket){
            if (j != '['){
              dirty += j;
            }
            for (int i = 0; i < dirty.length(); i++) {
              if (i + 3 < dirty.length()) {
                if (dirty.charAt(i) == dirty.charAt(i + 3)
                    && dirty.charAt(i + 1) == dirty.charAt(i + 2)
                    && dirty.charAt(i) != dirty.charAt(i + 1)) {
                  isDirty = true;
                }
              }
            }
            dirty = "";
            
          }
          if (isDirty && incSupported){
            supported--;
          }
          //System.out.println(cleaned);
        }
//        for (int i = 0; i < cleaned.length(); i++) {
//          if (i + 3 < cleaned.length()) {
//            if (cleaned.charAt(i) == cleaned.charAt(i + 3)
//                && cleaned.charAt(i + 1) == cleaned.charAt(i + 2)
//                && cleaned.charAt(i) != cleaned.charAt(i + 1)) {
//              supported++;
//            }
//          }
//        }
      }
      System.out.println(supported);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
