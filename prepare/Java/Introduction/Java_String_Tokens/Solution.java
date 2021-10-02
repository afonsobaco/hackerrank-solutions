import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        if(s.trim().length() > 0 && s.trim().length() <= 400000){
            String[] tokens = s.trim().split("[ !,?._'@]+");
            System.out.println(tokens.length);
            for(String a : tokens){
                System.out.println(a);
            }
        }else{
            System.out.println(0);
        }
        scan.close();
    }
}

