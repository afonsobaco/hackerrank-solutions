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

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        
        int max = 0;
        int c = 0;
        while(n > 0){
            int r = n%2;
            c++;
            c *= r;
            if(c > max){
                max++;
            }
            n = n/2;
        }
        System.out.println(max);
        
        bufferedReader.close();
    }
}
