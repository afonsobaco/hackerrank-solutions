import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        
        BigInteger bigA = new BigInteger(a);
        BigInteger bigB = new BigInteger(b);
        
        System.out.println(bigA.add(bigB));
        System.out.println(bigA.multiply(bigB));
        
    }
}