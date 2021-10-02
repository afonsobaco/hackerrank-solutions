import java.math.BigDecimal;
import java.util.*;
class Solution{

    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
      	sc.close();

        boolean sorted = false;
        int count = 0;
        while(!sorted && count < 100){
            sorted = true;
            for(int i = 0; i < s.length-1; i++){
                if(s[i+1] != null){
                    
                    BigDecimal a = new BigDecimal(s[i]);
                    BigDecimal b = new BigDecimal(s[i+1]);
                    if(a.compareTo(b) < 0){
                        String t = s[i];
                        s[i] = s[i+1];
                        s[i+1] = t;
                        sorted = false;
                    }                   
                }
            }
            count++;
        }

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }

}
