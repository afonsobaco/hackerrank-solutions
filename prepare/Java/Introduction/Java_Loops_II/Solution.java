import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            String r = "";
            int p = 1;

            for ( int j = 0; j<n; j++){
                r += ((a + (b*(2*p - 1))))+" "; 
                p*=2;
            }
            System.out.println(r);
        }
        in.close();
    }
}
