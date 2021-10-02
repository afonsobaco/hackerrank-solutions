import java.util.*;
import java.text.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        // Write your code here.
        NumberFormat f = NumberFormat.getInstance();
        String us = f.getCurrencyInstance(Locale.US).format(payment);
        String china = f.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = f.getCurrencyInstance(Locale.FRANCE).format(payment);

        Locale INDIA = new Locale("en", "IN");        
        String india = f.getCurrencyInstance(INDIA).format(payment);
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
