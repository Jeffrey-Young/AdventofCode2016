package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Runner {

  public static void main(String[] args) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("input/day4input1.txt"));
      //BufferedReader reader = new BufferedReader(new FileReader("input/test.txt"));
      FileWriter writer = new FileWriter("output/day4output.txt");
      int idSum = 0;
      while (reader.ready()) {
        String line = reader.readLine();
        String[] tokens = line.split("-");
        String name = "";
        for (int i = 0; i < tokens.length - 1; i++) {
          name += tokens[i];
        }
        int id = Integer.parseInt(tokens[tokens.length - 1].split("\\[")[0]);
        String checksum = tokens[tokens.length - 1].split("\\[")[1].substring(0,
            tokens[tokens.length - 1].split("\\[")[1].length() - 1);

        char[] mostCommon = new char[5];
        String temp = name;
        for (int i = 0; i < 5; i++) {
          mostCommon[i] = findMostCommonLetter(temp);
          String temp2 = "";
          for (int j = 0; j < temp.length(); j++) {
            if (temp.charAt(j) != mostCommon[i]) {
              temp2 += temp.charAt(j);
            }
          }
          temp = temp2;
        }
        
        if (mostCommon[0] == checksum.charAt(0) && mostCommon[1] == checksum.charAt(1) && mostCommon[2] == checksum.charAt(2) && mostCommon[3] == checksum.charAt(3) && mostCommon[4] == checksum.charAt(4)){
          idSum += id;
          String realName = decryptName(name.toCharArray(), id);
          writer.write(realName + "[" + id + "]" + "\n");
        }

//        System.out.println(name);
//        System.out.println(id);
//        System.out.println(checksum);
//        System.out.println(mostCommon[3]);
      }
      writer.flush();
      writer.close();
      System.out.println(idSum);
    } catch (Exception e) {
      e.printStackTrace();
    }     
  }

  private static char findMostCommonLetter(String name) {
    Map<Character, Integer> frequencies = new HashMap<Character, Integer>();
    char[] charArray = name.toCharArray();
    Arrays.sort(charArray); //actually this sort shouldn't be necessary
    for (char i : charArray) {
      if (frequencies.containsKey(i)) {
        frequencies.put(i, frequencies.get(i) + 1);
      } else {
        frequencies.put(i, 1);
      }
    }
    char maxChar = ' ';
    int maxCharCount = 0;
    Character[] sortedArray = frequencies.keySet().toArray(new Character[frequencies.keySet().size()]);
    Arrays.sort(sortedArray);
    for (char i : sortedArray) {
      if (frequencies.get(i) > maxCharCount) {
        maxCharCount = frequencies.get(i);
        maxChar = i;
      }
    }
    return maxChar;
  }
  
  private static String decryptName(char[] encryptedName, int id){
    int offset = id % 26;
    for (int i = 0; i < encryptedName.length; i++){
      encryptedName[i] -= 96;
      //a = 1, z = 26
      encryptedName[i] += offset;
      encryptedName[i] %= 26;
      encryptedName[i] += 96;
      System.out.println((int) encryptedName[i]);

    }
    String output = "";
    for (char i : encryptedName){
      output += i;
    }
    return output;
  }
}
