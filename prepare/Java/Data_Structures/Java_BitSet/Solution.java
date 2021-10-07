import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        BitSet[] sets = new BitSet[2];
        sets[0] = b1;
        sets[1] = b2;
        int m = scan.nextInt();
        for(int i = 0; i < m; i++){
            String op = scan.next();
            int x = scan.nextInt();
            int y = scan.nextInt();
            switch(op){
                case "AND":
                    sets[x-1].and(sets[y-1]);
                    break;
                case "OR":
                    sets[x-1].or(sets[y-1]);
                    break;
                case "XOR":
                    sets[x-1].xor(sets[y-1]);
                    break;
                case "FLIP":
                    sets[x-1].flip(y);
                    break;
                case "SET":
                    sets[x-1].set(y);
                    break;
                default:
                    break;
            }
            System.out.println(sets[0].cardinality()+" "+sets[1].cardinality());
        }
        scan.close();
    }
}
