import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, q, x;
        String query;
        n = scan.nextInt();
        List<Integer> l = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) l.add(scan.nextInt());
        q = scan.nextInt(); 
        for(int i = 0; i < q; i++){
            query = scan.next();
            x = scan.nextInt();
            if(query.equals("Insert")){
                l.add(x, scan.nextInt());
            }else{
                l.remove(x);
            }
        }
        l.stream().forEach(a -> System.out.print(a + " "));
        scan.close();
    }
}
