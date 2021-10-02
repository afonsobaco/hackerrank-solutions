import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */        
        System.out.println((A+B).length());
        System.out.println(A.compareTo(B)>0?"Yes":"No");
        String ACap = Character.toUpperCase(A.charAt(0))+A.substring(1);
        String BCap = Character.toUpperCase(B.charAt(0))+B.substring(1);
        System.out.println(ACap + " " + BCap);
    }
}
