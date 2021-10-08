import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in)){
            String s = scan.next();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
            System.out.println(new BigInteger(1,md.digest()).toString(16));
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }
}
