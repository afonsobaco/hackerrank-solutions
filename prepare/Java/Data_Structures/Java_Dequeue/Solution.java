    import java.util.*;
    public class test {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Deque deque = new ArrayDeque<>();
            int n = in.nextInt();
            int m = in.nextInt();
            Set<Integer> set = new HashSet<Integer>();

            int max = 0;
            for (int i = 0; i < n; i++) {
                int input = in.nextInt();
                
                deque.add(input);
                set.add(input);
                
                if (deque.size() == m) {
                    if (set.size() > max) {
                        max = set.size();
                    }
                    int first = (int)deque.remove();
                    if (!deque.contains(first)) 
                    {
                        set.remove(first);
                    }
                    if(max == m){
                        break;
                    }
                }
            }
            
            System.out.println(max);            
        }
    }



