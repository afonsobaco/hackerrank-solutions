import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0; i<t; i++){
            String str = scan.next();
            String a ="";
            String b ="";
            for(int c = 0; c < str.length(); c++){
                if(c%2==0){
                    a += str.charAt(c); 
                }else{
                    b += str.charAt(c); 
                }
            }
            System.out.println(a+" "+b);
        }
    }
}
