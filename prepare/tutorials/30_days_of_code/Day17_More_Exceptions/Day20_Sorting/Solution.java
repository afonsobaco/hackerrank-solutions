import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        int numSwaps = 0;
        for(int i = 0; i < a.size(); i++){
            int swaps = 0;
            
            for(int j = 0; j < a.size() - 1; j++){
                if(a.get(j) > a.get(j+1)){
                    int x = a.get(j);
                    a.set(j, a.get(j+1));
                    a.set(j+1, x);
                    swaps++;
                    numSwaps++;
                }                
            }            
            if(swaps == 0){
                break;
            }
        }

        System.out.printf("Array is sorted in %1$s swaps.\n",numSwaps);
        System.out.printf("First Element: %1$s\n",a.get(0));
        System.out.printf("Last Element: %1$s\n",a.get(a.size()-1));
        

        bufferedReader.close();
    }
}
