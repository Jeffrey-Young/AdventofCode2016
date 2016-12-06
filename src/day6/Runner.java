package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {
  public static void main(String[] args){
    List<HashMap<Character, Integer>> frequencies = new ArrayList<HashMap<Character, Integer>>();
    for (int i = 0; i < 8; i++){
      frequencies.add(new HashMap<Character, Integer>());
    }
    try {
      BufferedReader reader = new BufferedReader(new FileReader("input/day6input1.txt"));
      while (reader.ready()){
        char[] line = reader.readLine().toCharArray();
        for (int i = 0; i < line.length; i++){
          if (frequencies.get(i).containsKey(line[i])){
            frequencies.get(i).put(line[i], frequencies.get(i).get(line[i]) + 1);
          }
          else {
            frequencies.get(i).put(line[i], 1);
          }
        }
      }
      for (Map<Character, Integer> map : frequencies){
        int min = 1000000;
        char minKey = '\u0000';
        for (Character k : map.keySet()){
          if (map.get(k) < min){
            min = map.get(k);
            minKey = k;
          }
        }
        System.out.print(minKey);
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
