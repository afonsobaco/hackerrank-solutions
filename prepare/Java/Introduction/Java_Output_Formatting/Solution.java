import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("================================");
    for(int i=0;i<3;i++)
    {
        String s1=sc.next();
        int x=sc.nextInt();
        //Complete this line
        while(s1.length() < 15){
            s1+=" ";
        }
        if(x < 10){
            s1+="00";
        }else if(x < 100){
            s1+="0";
        }
        s1+=x;
        System.out.println(s1);
    }
    System.out.println("================================");
  }
}
