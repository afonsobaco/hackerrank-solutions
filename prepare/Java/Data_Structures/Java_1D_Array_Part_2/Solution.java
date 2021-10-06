import java.util.*;

public class Solution {

   
    // My Solution
    private static boolean canWin(int leap, int[] game){
      int n = game.length;
      int i = 0;
      int r = 0;
      int[] track = new int[n];
      while(i < n-leap && i < n-1){
            r = i;
            if(game[i+leap] ==  0 && track[i+leap] ==  0 ) i += leap;
            else if(game[i+1] ==  0 && track[i+1] == 0 ) i++;
            else if(i > 0 ){
                    if(track[i - 1] ==  0 && game[i - 1] ==  0 ) i--;
                    else i = track[i]-1;
            } else return false;
            if(track[i] == 0) track[i] = r + 1;
      }
      return true;
    }
    
    // #######  Internet Solution (this is cleaner)  #########
    // public static boolean canWin(int leap, int[] game) {
    //   return canWin(leap, game, 0);
    // }    
    // private static boolean canWin(int leap, int[] game, int i){
    //   if(i >= game.length){
    //     return true;
    //   } else if(i < 0 || game[i] == 1){
    //     return false;
    //   }      
    //   game[i]=1;
    //   return canWin(leap, game, i + leap) || 
    //          canWin(leap, game, i + 1) || 
    //          canWin(leap, game, i - 1) ;
    // }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }
            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
