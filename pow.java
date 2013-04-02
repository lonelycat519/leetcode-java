public class Solution {
    public double pow(double x, int n) {
        if(n==0 || x==1)
            return 1.0;
        if(x==-1 && n%2==1)
            return -1.0;
        if(x==-1 && n%2==0)
            return 1.0;
        
        boolean is_neg = false;
        double result = x;
        double temp = 1.0;
        if(n<0) {
            is_neg = true;
            n = -n;
        }
        
        while(n>1){
            if(n%2==1)
                temp *= result;
            n /= 2;
            result *= result;
        }
        
        if(is_neg)
            result = 1/(result*temp);
        else
            result = result*temp;

        return result;
    }
}
