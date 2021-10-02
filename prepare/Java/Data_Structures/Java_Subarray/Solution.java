import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for(int i = 0; i< n; i++){
            a[i] = scan.nextInt();
        }
        int r = 0;
        for(int l = 1; l <= n; l++){
            for(int i = 0; i <= n-l; i++){
                int aux = i;
                int sum = 0;
                while(aux < i+l){
                    sum += a[aux];
                    aux++;
                }
                if(sum < 0){
                    r++;
                }
            }
        } 
        System.out.println(r);
    }
}