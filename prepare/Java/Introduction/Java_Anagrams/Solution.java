import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if(a.length() != b.length()) return false;    
        if(a.equalsIgnoreCase(b)) return true;
            
        String bLowerCase = b.toLowerCase();
        for(char c : a.toLowerCase().toCharArray()){
            if( bLowerCase.indexOf(c) >= 0){
                bLowerCase = bLowerCase.replaceFirst(Character.toString(c),"");
            }else{
                return false;
            }
        }
        return true;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
