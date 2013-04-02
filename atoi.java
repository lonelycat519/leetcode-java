public class Solution {
    public int atoi(String str) {
        int start = 0;
        int end = str.length()-1;
        
        boolean is_pos = false;
        boolean is_neg = false;
        boolean is_space = false;
        
        if(str == null || str.length()==0)  return 0;
        else{
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                    start = i;
                    while(i<str.length()){
                        if(str.charAt(i)<'0' || str.charAt(i)>'9'){
                            break;
                        }
                        i++;
                    }
                    end = i-1;
                    break;
                } else if (str.charAt(i)==' ') {
                    if (is_neg || is_pos) return 0;
                    is_space = true;
                } else if (str.charAt(i) == '-') {
                    if (is_neg || is_pos) return 0;
                    is_neg = true;
                } else if (str.charAt(i) == '+') {
                    if (is_neg || is_pos) return 0;
                    is_pos = true;
                } else {
                    return 0;
                }
            }
            
            long num = 0;
            for(int i=start; i<=end; i++){
                num = num*10 + (str.charAt(i)-'0');
            }
            if(is_neg)  num = -num;
            if(num<Integer.MIN_VALUE)   num = Integer.MIN_VALUE;
            else if(num>Integer.MAX_VALUE)   num = Integer.MAX_VALUE;
            
            return (int)num;
        }
    }
}
