class Solution {
    public static int __gcd(int a,int b){
        if(a==b) return a;
        
        if(a>b) return __gcd(a-b,b);
        else return __gcd(a,b-a);
    }
    
    
    public static int _gcd(int a,int b){
        //if(a==0) return b;
        if(b==0) return a;
        
        return _gcd(b,a%b);
        
        
    }
    public static int[] lcmAndGcd(int a, int b) {
        // code here
          
        return new int[] {(a*b)/_gcd(a,b) , _gcd(a,b) };
    }
}