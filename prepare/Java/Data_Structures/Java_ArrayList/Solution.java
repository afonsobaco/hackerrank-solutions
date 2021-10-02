import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<List<Integer>> data = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++){
            int d = scan.nextInt();
            List<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j < d; j++){
                list.add(scan.nextInt());
            }
            data.add(list);
        }
        int q = scan.nextInt();
        for(int i = 0; i < q; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            if(data.size() >= x && data.get(x-1).size() >= y){
                System.out.println(data.get(x-1).get(y-1));
            }else{
                System.out.println("ERROR!");
            }
        }
    }
}