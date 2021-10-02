import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    List<List<Integer>> arr = new ArrayList<>();

    IntStream.range(0, 6).forEach(i -> {
      try {
        arr.add(
          Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
    
    boolean valid = isValid(arr);
    
    if(valid){      
      int max = 0;
      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
          int firstLine = arr.get(i).subList(j,j+3).stream().reduce(0, Integer::sum);
          int secondLine = arr.get(i+1).get(j+1);
          int thirdLine = arr.get(i+2).subList(j,j+3).stream().reduce(0, Integer::sum);
          int sum = firstLine+secondLine+thirdLine;
          if(sum > max || (i==0 && j==0)){
            max = sum;
          }
        }
      }
      System.out.println(max);
    }

    bufferedReader.close();
  }
  
  private static boolean isValid(List<List<Integer>> arr){
    for(List<Integer> list : arr){
      if(list.size() != 6){
        return false;
      }else{
        for(Integer i : list){
          if(i < -10 && i > 10){
            return false;
          }
        }
      }
    }                    
    return true;
  }
}
